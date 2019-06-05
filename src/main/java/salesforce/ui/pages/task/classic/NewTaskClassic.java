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

package salesforce.ui.pages.task.classic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.entities.Task;
import salesforce.ui.pages.task.abstracts.NewTaskAbstract;

/**
 * New Task classic skin.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class NewTaskClassic extends NewTaskAbstract {

    // Tab bar
    @FindBy(css = "#createNewButton")
    private WebElement createNewTaskDropDown;

    @FindBy(css = "#createNewMenu")
    private WebElement createNewTaskMenu;

    @FindBy(xpath = "//div[@id='createNewMenu']/a[@class='taskMru menuButtonMenuLink' and contains(text(),'Task')]")
    private WebElement taskMenuItem;

    // Task edit
    @FindBy(xpath = "//form[@id='editPage']//div[contains(@class,'pbHeader')]//input[1]")
    private WebElement saveTask;
    
    // Task information
    @FindBy(css = "input#tsk5")
    private WebElement subjectTextBox;

    // Description information
    @FindBy(xpath = "//textarea[@id='tsk6']")
    private WebElement commentTextArea;

    @FindBy(xpath = "//input[@id='tsk4']")
    private WebElement dueDateTextBox;

    @FindBy(xpath = "//input[@id='reminder_select_check']")
    private WebElement reminderCheckBox;

    @FindBy(xpath = "//select[@id='tsk13']")
    private WebElement priorityDropDown;

    @FindBy(xpath = "//select[@id='tsk12']")
    private WebElement statusDropDown;
    // Recurrence
    // Reminder
    /**
     * Verifies of message confirmation after to create a new task.
     * @param message value
     * @return true for a classic skin.
     */
    public boolean verifyMessage(final String message) {
        return true;
    }

    @Override
    public String createNewTask(final Task task) {
        createNewTaskDropDown.click();
        taskMenuItem.click();
        subjectTextBox.sendKeys(task.getSubject());
        dueDateTextBox.sendKeys(task.getDueDate());
        commentTextArea.sendKeys(task.getComment());
        priorityDropDown.sendKeys(task.getPriority());
        statusDropDown.sendKeys(task.getStatus());
        reminderCheckBox.click();
        saveTask.click();
        return task.getSubject();
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
