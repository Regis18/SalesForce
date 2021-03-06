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

import java.util.HashMap;
import java.util.Map;

/**
 * Task Page classic.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class TaskPageClassic extends TaskPageAbstract {
    public static final int MILLIS = 2500;
    public static final int INT = 100;
    // Task Details
    private static final String SUBJECT = "//div[@id='tsk5_ileinner']";
    private static final String PRIORITY = "//div[@id='tsk13_ileinner']";
    private static final String STATUS = "//div[@id='tsk12_ileinner']";
    // Description information
    private static final String CONTACT = "//div[@id='tsk2_ileinner']//a";
    private static final String ACCOUNT = "//div[@id='tsk3_ileinner']//a";
    // Attachments
    // Description information
    private static final String COMMENT = "//div[@id='tsk6_ileinner']";
    private static final String DUEDATE = "//div[@id='tsk4_ileinner']";
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
    // Recurrence
    @FindBy(xpath = "//input[@id='IsRecurrence'")
    private WebElement getRecurrence;
    // Reminder
    @FindBy(xpath = "//input[@id='reminder_select_check'")
    private WebElement getReminder;
    // Edit task
    @FindBy(xpath = "//td[@id='topButtonRow']//input[@name='edit']")
    private WebElement updateTask;
    @FindBy(xpath = "//td[@id='topButtonRow']//input[@name='delete']")
    private WebElement deleteTask;
    @FindBy(xpath = "//input[@name='newTask']")
    private WebElement newTaskButton;
    // Tab bar
    @FindBy(xpath = "//div[span[@id='userNavLabel']]")
    private WebElement userIcon;

    /**
     * Fill locators map.
     * @return locators map.
     */
    private HashMap<String, String> fillLocatorMap() {
        HashMap<String, String> locMap = new HashMap<>();
        locMap.put("Subject", SUBJECT);
        locMap.put("Comment", COMMENT);
        locMap.put("Status", STATUS);
        locMap.put("DueDate", DUEDATE);
        locMap.put("Priority", PRIORITY);
        locMap.put("Account", ACCOUNT);
        locMap.put("Contact", CONTACT);
        return locMap;
    }

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

    /**
     * Verifies subject task exist.
     * @param subjectTask subject Task.
     * @return boolean value.
     */
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

    /**
     * Verifies Task was created.
     * @param task the task.
     * @return boolean value.
     */
    @Override
    public boolean verifyTaskWasCreated(final Task task) {
        HashMap<String, String> datos = fillLocatorMap();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUBJECT)));

            for (Map.Entry<String, String> dato : datos.entrySet()) {
                if (!task.getField(dato.getKey()).equals("")) {
                    WebElement field =
                            driver.findElement(By.xpath(dato.getValue()));
                    String uiSubject = field.getText();
                    if (!uiSubject.equals(task.getField(dato.getKey()))) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Edit current task.
     * @param task information.
     * @return task information.
     */
    @Override
    public Task editCurrentTask(Task task) {
        return updateCurrentTask(task);
    }

    /**
     * Click Recent Task Refresh.
     */
    @Override
    public void clickRecentTasksRefresh() {
    }

    /**
     * Delete Current task.
     * @param task task infomation.
     */
    @Override
    public void deleteCurrentTask(final Task task) {
        WebElement currentTask = driver.findElement(By.xpath("//a[span[contains(text(),'"
                + task.getSubject() + "')]]"));
        currentTask.click();
        deleteTask.click();
    }

    /**
     * Update current task.
     * @param task task information.
     * @return task information.
     */
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

    /**
     * Verifies task values.
     * @param task information.
     */
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
