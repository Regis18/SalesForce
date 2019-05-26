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

package salesforce.ui.pages.classic.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.entities.Task;
import salesforce.ui.pages.abstracts.task.TaskPageAbstract;

/**
 * Task Page classic.
 * @autor Melvi Caballero.
 * @version 0.0.1
 */
public class TaskPageClassic extends TaskPageAbstract {

    public static final int INT = 100;
    @FindBy(xpath = "//a[span[contains(text(),'callTask2')]]")
    private WebElement taskList;

    @FindBy(xpath = "//td[@id='topButtonRow']//input[@name='delete']")
    private WebElement deleteTask;

    @FindBy(xpath = "//td[@id='topButtonRow']//input[@name='edit']")
    private WebElement updateTask;

    @FindBy(css = "input#tsk5")
    private WebElement subjectTextBox;

    @FindBy(xpath = "//form[@id='editPage']//div[contains(@class,'pbHeader')]//input[1]")
    private WebElement saveTask;

    public void clickTask(){
        taskList.click();
    }

    public void clickDisplayTask() {
        taskList.click();
    }


    @Override
    public boolean verifySubjectExist(String subjectTask) {
        try {
            WebElement subjectExist =
                    driver.findElement(By.xpath("//a[contains(text(),\"" + subjectTask + "\")][1]"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void clickRecentTasksRefresh() {

    }

    @Override
    public void deleteCurrentTask(Task task) {
        WebElement currentTask = driver.findElement(By.xpath("//a[span[contains(text(),'" + task.getSubject()+ "')]]"));
        currentTask.click();
        deleteTask.click();
    }

    @Override
    public Task updateCurrentTask(Task task) {
        WebElement currentTask = driver.findElement(By.xpath("//a[span[contains(text(),'" + task.getSubject() + "')]]"));
        currentTask.click();
        updateTask.click();
        String nameTaskSubject = "Updated" + String.valueOf((int) (Math.random() * INT));
        setUpdateNewSubjectTask(nameTaskSubject);
        saveTask.click();
        task.setSubject(nameTaskSubject);
        return task;
    }

    public void setUpdateNewSubjectTask(String task){
        subjectTextBox.sendKeys(task);

    }
}
