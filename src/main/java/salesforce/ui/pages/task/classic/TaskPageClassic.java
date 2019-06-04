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
import salesforce.utils.DriverMethods;

/**
 * Task Page classic.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class TaskPageClassic extends TaskPageAbstract {
    public static final int MILLIS = 2500;
    public static final int INT = 100;

    @FindBy(xpath = "//a[span[contains(text(),'callTask2')]]")
    private WebElement taskList;

    @FindBy(xpath = "//td[@id='topButtonRow']//input[@name='delete']")
    private WebElement deleteTask;

    @FindBy(xpath = "//td[@id='topButtonRow']//input[@name='edit']")
    private WebElement updateTask;

    @FindBy(css = "input#tsk5")
    private WebElement subjectTextBox;

//    @FindBy(xpath = "//form[@id='editPage']//div[contains(@class,'pbHeader')]//input[1]")
    @FindBy(css = "form[id='editPage'] div[class*='pbHeader'] input")
    private WebElement saveTask;

    @FindBy(xpath = "//div[span[@id='userNavLabel']]")
    private WebElement userIcon;

//    @FindBy(xpath = "//input[@name='newTask']")
    @FindBy(name = "newTask")
    private WebElement newTaskButton;

    private static final String TASK_SUBJECT_XPATH = "//div[@class='taskBlock']//span[text()='%s']";

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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tsk5_ileinner']")));
            WebElement subject =
                    driver.findElement(By.xpath("//div[@id='tsk5_ileinner']"));
            String uiSubject = subject.getText();
            if (!uiSubject.equals(task.getSubject())) {
                return false;
            }
            WebElement comment =
                    driver.findElement(By.xpath("//div[@id='tsk6_ileinner']"));
            String uiComment = comment.getText().trim();
            if (!uiComment.equals(task.getComment())) {
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

    @Override
    public boolean isTaskSubjectDisplayed(final Task task) {
        return DriverMethods.isElementPresent(By.xpath(String.format(TASK_SUBJECT_XPATH, task.getSubject())));
    }

    @Override
    public void openTaskByTaskSubject(final Task task) {
        driver.findElement(By.xpath(String.format(TASK_SUBJECT_XPATH, task.getSubject()))).click();
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
