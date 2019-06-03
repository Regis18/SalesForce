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

package salesforce.ui.pages.task.lightning;

import core.utils.StrategySetter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Task;
import salesforce.ui.pages.task.abstracts.NewTaskAbstract;

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

    @FindBy(xpath = "//input[@class='inputDate input']")
    private WebElement dueDateTextBox;

    @FindBy(xpath = "//a[@title='High']")
    private WebElement priorityDropDown;

    @FindBy(xpath = "//input[@id='reminder_select_check']")
    private WebElement statusDropDown;

    @FindBy(xpath = "//span[contains(@class, \"forceActionsText\")]")
    private WebElement messageConfirmation;

    /**
     * Gets message confirmation after create a task.
     * @return the text message.
     */
    public String getMessageConfirmation() {
        wait.until(ExpectedConditions.visibilityOf(messageConfirmation));
        return messageConfirmation.getText();
    }

    /**
     * Verifies a message confirmation is displayed.
     * @param message value
     * @return the text message.
     */
    public boolean verifyMessage(final String message) {
        return message.equals(getMessageConfirmation());
    }

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
     * Set Due Date.
     *
     * @param value Value
     */
    protected void setDueDate(final String value) {
        dueDateTextBox.sendKeys(value);
    }

    /**
     * Set priority.
     *
     * @param value value
     */
    protected void setPriority(final String value) {
        // Wait for visibility of combobox and click on it to open drop-down list.
        WebElement combobox = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[span/span[text()='Priority']]"
                        + "/div/div/div/div/a[@class='select']")));
        combobox.click();
        //Select Option.
        WebElement itemToSelect = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//a[@title='" + value + "']")));
        itemToSelect.click();
    }

    /**
     * Sets status.
     *
     * @param value value
     */
    protected void setStatus(final String value) {
        // Wait for visibility of combobox and click on it to open drop-down list
        WebElement combobox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[span/span[text()='Status']]/div/div/div/div/a[@class='select']")));
        combobox.click();
        //Select Option
        WebElement itemToSelect = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//a[@title='" + value + "']")));
        itemToSelect.click();
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
        fields.add("Subject");
        fields.add("Comment");
        fields.add("DueDate");
        fields.add("Priority");
        fields.add("Status");

        HashMap<String, StrategySetter> strategyMap = composeTextBoxStrategyMap(task);

        fields.forEach(field -> {
            strategyMap.get(field).executeMethod();
        });

        clickSaveButton();
        return task.getSubject();
    }

    /**
     * Sets text Map strategy.
     *
     * @param myTask task
     * @return strategyMap
     */
    private HashMap<String, StrategySetter> composeTextBoxStrategyMap(final Task myTask) {
        HashMap<String, StrategySetter> strategyMap = new HashMap<>();
        strategyMap.put("Subject", () -> setSubjectTextBox(myTask.getSubject()));
        strategyMap.put("Comment", () -> setComments(myTask.getComment()));
        strategyMap.put("DueDate", () -> setDueDate(myTask.getDueDate()));
        strategyMap.put("Priority", () -> setPriority(myTask.getPriority()));
        strategyMap.put("Status", () -> setStatus(myTask.getStatus()));
        return strategyMap;
    }
}
