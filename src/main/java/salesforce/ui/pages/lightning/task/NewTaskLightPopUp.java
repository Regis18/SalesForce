/*
 * @(#) NewTaskLightPopUp.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 *  Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 *
 */

package salesforce.ui.pages.lightning.task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.entities.Task;
import salesforce.ui.pages.abstracts.task.NewTaskAbstract;
import salesforce.utils.Strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class is for create a new class from light experience skin.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class NewTaskLightPopUp extends NewTaskAbstract {

    /**
     * Subject TextBox.
     */
    @FindBy(xpath = "//lightning-grouped-combobox[label[contains(text(),\"Subject\")]]/div/div/"
            + "lightning-base-combobox/div/div/input")
    private WebElement subjectTextBox;

    /**
     * Save button.
     */
    @FindBy(xpath = "//button[@title=\"Save\"]")
    private WebElement saveButton;

    /**
     * Notification close button.
     */
    @FindBy(xpath = "//button[@title=\"Close\"]")
    private WebElement notificationCloseButton;

    /**
     * Comments text area.
     */
    @FindBy(xpath = "//textarea")
    private WebElement commentsTextArea;

    /**
     * Save button.
     */
    public void clickSaveButton() {
        saveButton.click();
    }

    @Override
    protected void clickCloseNotificationButton() {
        notificationCloseButton.click();
    }

    @Override
    protected void setSubjectTextBox(final String value) {
        subjectTextBox.sendKeys(value);
    }

    @Override
    protected void setComments(final String value) {
        commentsTextArea.sendKeys(value);
    }

    /**
     * Create Task.
     *
     * @param task object.
     * @return string subject task.
     */
    @Override
    public String createNewTask(final Task task) {
        //log.info("Set information of project.");
        List<String> fields = new ArrayList();
        fields.add("subject");
        fields.add("comment");

        HashMap<String, Strategy> strategyMap = composeTextBoxStrategyMap(task);

        fields.forEach(field -> {
            strategyMap.get(field).executeMethod();
        });

        clickSaveButton();
        return task.getSubject();
    }

    /**
     * Set text Map strategy.
     *
     * @param myTask task
     * @return strategyMap
     */
    private HashMap<String, Strategy> composeTextBoxStrategyMap(final Task myTask) {
        HashMap<String, Strategy> strategyMap = new HashMap<>();
        strategyMap.put("subject", () -> setSubjectTextBox(myTask.getSubject()));
        strategyMap.put("comment", () -> setComments(myTask.getComment()));
        //strategyMap.put("status", () -> setStatus(myTask.getComment()));
        //strategyMap.put("email", () -> setEmail(myTask.getEmail()));
        return strategyMap;
    }
}