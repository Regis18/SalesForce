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

package salesforce.ui.pages.lightning;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.BasePage;

/**
 * NewTaskLightPopUp class in this popup we fill information for create a new task.
 *
 * @author Melvi Caballero
 * @version 0.0.1
 */
public class NewTaskLightPopUp extends BasePage {
    public static final int MILLIS = 2000;
    public static final int MILLIS1 = 3000;
    public static final int INT = 100;
    /**
     * Subject TextBox.
     */
    @FindBy(xpath = "//lightning-grouped-combobox[label[contains(text(),\"Subject\")]]/div/div/"
            + "lightning-base-combobox/div/div/input")
    private WebElement subjectTextBox;
    /**
     * save button.
     */
    @FindBy(xpath = "//button[@title=\"Save\"]")
    private WebElement saveButton;
    /**
     * notification close button.
     */
    @FindBy(xpath = "//button[@title=\"Close\"]")
    private WebElement notificationCloseButton;
    /**
     * Comments text area.
     */
    @FindBy(xpath = "//textarea")
    private WebElement commentsTextArea;

    /**
     * click save button.
     */
    public void clickSaveButton() {
        saveButton.click();
    }

    /**
     * click saved notification.
     */
    public void clickCloseNotificationButton() {
        notificationCloseButton.click();
    }

    /**
     * Fill the text box.
     *
     * @param value the text to set.
     */
    public void setSubjectTextBox(final String value) {
        subjectTextBox.sendKeys(value);
    }

    /**
     * Fill the comments.
     *
     * @param value the text to set.
     */
    public void setComments(final String value) {
        commentsTextArea.sendKeys(value);
    }

    /**
     * Create new Task.
     * @return the subject of the task.
     */
    public String createNewTask() {
        String nameSubject = "Call" + String.valueOf((int) (Math.random() * INT));
        setSubjectTextBox(nameSubject);
        setComments("Test task.");
        clickSaveButton();
        return nameSubject;
    }

    /**
     * Wait for Page.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
