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
 * New Task classic skin.
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class NewTaskClassic extends NewTaskAbstract {

    @FindBy(css = "#createNewButton")
    private WebElement createNewTaskDropDown;

    @FindBy(css = "#createNewMenu")
    private WebElement createNewTaskMenu;

    @FindBy(xpath = "//div[@id='createNewMenu']/a[@class='taskMru menuButtonMenuLink']")
    private WebElement taskMenuItem;

    @FindBy(css = "input#tsk5")
    private WebElement subjectTextBox;

    @FindBy(xpath = "//textarea[@id='tsk6']")
    private WebElement commentTextArea;

    @FindBy(xpath = "//form[@id='editPage']//div[contains(@class,'pbHeader')]//input[1]")
    private WebElement saveTask;


    @Override
    public String createNewTask(Task task) {
        createNewTaskDropDown.click();
        taskMenuItem.click();
        subjectTextBox.sendKeys(task.getSubject());
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
