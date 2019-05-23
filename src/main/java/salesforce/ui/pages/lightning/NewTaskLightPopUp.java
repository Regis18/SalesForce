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
import salesforce.ui.pages.abstracts.NewTaskAbstract;

/**
 * This class is for create a new class from light experience skin.
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

    @Override
    protected void clickSaveButton() {
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
}
