/*
 * @(#) TaskPageClassic.java Copyright (c) 2019 Jala Foundation.
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Task;
import salesforce.ui.pages.task.abstracts.TaskPageAbstract;

/**
 * Task Page classic.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class TaskPageClassic extends TaskPageAbstract {
    public static final int MILLIS = 2500;
    public static final int INT = 100;

    // Recent Items
    @FindBy(xpath = "//a[span[contains(text(),'callTask2')]]")
    private WebElement taskList;

    // Create a new task
    // Task edit
    @FindBy(xpath = "//form[@id='editPage']//div[contains(@class,'pbHeader')]//input[1]")
    private WebElement saveTask;


    // Task information
    @FindBy(css = "input#tsk5")
    private WebElement subjectTextBox;
    // Description information

    // Recurrence
    @FindBy(xpath="//input[@id='IsRecurrence'")
    private WebElement getRecurrence;

    // Reminder
    @FindBy(xpath="//input[@id='reminder_select_check'")
    private WebElement getReminder;
    // Attachments

    // Edit task
    @FindBy(xpath = "//td[@id='topButtonRow']//input[@name='edit']")
    private WebElement updateTask;

    @FindBy(xpath = "//td[@id='topButtonRow']//input[@name='delete']")
    private WebElement deleteTask;

    @FindBy(xpath = "//input[@name='newTask']")
    private WebElement newTaskButton;


    // Task Details
    private static final String SUBJECT = "//div[@id='tsk5_ileinner']";
    private static final String PRIORITY = "//div[@id='tsk13_ileinner']";
    private static final String STATUS = "//div[@id='tsk12_ileinner']";
    private static final String CONTACT = "//div[@id='tsk2_ileinner']//a";
    private static final String ACCOUNT = "//div[@id='tsk3_ileinner']//a";

    // Description information
    private static final String COMMENT = "//div[@id='tsk6_ileinner']";

    // Tab bar
    @FindBy(xpath = "//div[span[@id='userNavLabel']]")
    private WebElement userIcon;

    /**
     * Click on task list.
     */
    public void clickTask() {
        taskList.click();
    }

    /**
     * Display the task list.
     */
    public void clickDisplayTask() {
        taskList.click();
    }

    @Override
    public boolean verifySubjectExist(final String subjectTask) {
        try {
            WebElement subjectExist =
                    driver.findElement(By.xpath("//a[contains(text(),\"" + subjectTask + "\")][1]"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean verifyTaskWasCreated(final Task task) {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUBJECT)));
            WebElement subject =
                    driver.findElement(By.xpath(SUBJECT));
            String uiSubject = subject.getText();
            if (!uiSubject.equals(task.getSubject())) {
                return false;
            }
            WebElement comment =
                    driver.findElement(By.xpath(COMMENT));
            String uiComment = comment.getText().trim();
            if (!uiComment.equals(task.getComment())) {
                return false;
            }
            WebElement priority =
                    driver.findElement(By.xpath(PRIORITY));
            String uiPriority = priority.getText().trim();
            if (!uiPriority.equals(task.getPriority())) {
                return false;
            }
            WebElement status =
                    driver.findElement(By.xpath(STATUS));
            String uiStatus = status.getText().trim();
            if (!uiStatus.equals(task.getStatus())) {
                return false;
            }

            WebElement contact = driver.findElement(By.xpath(CONTACT));
            String uiContact = contact.getText();
            if (!uiContact.equals(task.getContact())) {
                return false;
            }

            WebElement account = driver.findElement(By.xpath(ACCOUNT));
            String uiAccount = account.getText();
            if (!uiAccount.equals(task.getAccount())) {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void clickRecentTasksRefresh() {
    }

    @Override
    public void deleteCurrentTask(final Task task) {
        WebElement currentTask = driver.findElement(By.xpath("//a[span[contains(text(),'"
                + task.getSubject() + "')]]"));
        currentTask.click();
        deleteTask.click();
    }

    @Override
    public Task updateCurrentTask(final Task task) {
        WebElement currentTask = driver.findElement(By.xpath("//a[span[contains(text(),'"
                + task.getSubject() + "')]]"));
        currentTask.click();
        updateTask.click();
        String nameTaskSubject = "Updated" + String.valueOf((int) (Math.random() * INT));
        setUpdateNewSubjectTask(nameTaskSubject);
        saveTask.click();
        task.setSubject(nameTaskSubject);
        return task;
    }

    @Override
    public void verifyTaskValues(final Task task) {
        WebElement subjectTask =
                driver.findElement(By.xpath("//a[text()=\"" + task.getSubject() + "\"][1]"));
        subjectTask.click();

    }

    /**
     * Logout.
     */
    @Override
    public void logout() {
        userIcon.click();
        WebElement itemToSelect = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logout')]")));
        itemToSelect.click();
        try {
            Thread.sleep(MILLIS);
        } catch (Exception e) {
        }
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newTaskButton));
    }

    /**
     * Update the subject in the task.
     *
     * @param task map of attributes task.
     */
    public void setUpdateNewSubjectTask(final String task) {
        subjectTextBox.sendKeys(task);
    }

}
