/*
 * @(#) NewTaskClassic.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.classic.task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.entities.Task;
import salesforce.ui.pages.abstracts.task.NewTaskAbstract;

/**
 * New Task.
 */
public class NewTaskClassic extends NewTaskAbstract {

    @FindBy(css = "#createNewButton")
    private WebElement createNewTaskDropDown;

    @FindBy(css = "#createNewMenu")
    private WebElement createNewTaskMenu;

    @FindBy(css = "#createNewMenu,.taskMru menuButtonMenuLink")
    private WebElement task;

    @FindBy(css = "input#tsk5")
    private WebElement subjectTextBox;

    @FindBy(css = "//textarea[@id='tsk6']")
    private WebElement commentTextArea;

    @FindBy(xpath = "//form[@id='editPage']//div[contains(@class,'pbHeader')]//input[1]")
    private WebElement saveTask;

    @FindBy(xpath = "//td[@id='topButtonRow']//input[@name='delete']")
    private WebElement deleteTask;

    @FindBy(xpath = "//td[@id='topButtonRow']//input[@name='edit']")
    private WebElement updateTask;

    @Override
    public String createNewTask(Task task) {
        return null;
    }

    @Override
    protected void clickSaveButton() {
        saveTask.click();
    }

    @Override
    protected void clickCloseNotificationButton() {

    }

    @Override
    protected void setSubjectTextBox(final String value) {
        subjectTextBox.sendKeys(value);
    }

    @Override
    protected void setComments(final String value) {
        commentTextArea.sendKeys(value);
    }
}
