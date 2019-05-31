/*
 * @(#) TaskPageLightning.java Copyright (c) 2019 Jala Foundation.
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

import core.selenium.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Task;
import salesforce.ui.pages.task.abstracts.TaskPageAbstract;

/**
 * TaskLightPage class in this class whe navigate for this page the
 * task created are displayed.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class TaskPageLightning extends TaskPageAbstract {
    public static final int MILLIS = 2500;
    public static final int INT = 100;

    /**
     * Task web element.
     */
    @FindBy(css = ".forceRecordLayout:nth-child(1) .slds-split-view__list-item-action .slds-grow")
    private WebElement task;

//    @FindBy(xpath = "//*[contains(@class,\"slds-button__icon_x-small\")]")
//    private WebElement displayAsDropDownButton;

    /**
     * Dropdownbutton web element.
     */
    @FindBy(xpath = "//a[contains(@class,\"sldsButtonHeightFix\")]")
    private WebElement getDisplayAsDropDownButton;

    /**
     * Delete task web element.
     */
    @FindBy(xpath = "//a[contains(.,'Delete')]")
    private WebElement deletetask;
    /**
     * Delete confirmation web element.
     */
    @FindBy(xpath = "//button[span[contains(.,'Delete')]]")
    private WebElement deleteConfirmationtask;

    /**
     * Recent task refresh web element.
     */
    @FindBy(xpath = "//button[@name='refreshButton']")
    private WebElement recentTasksRefresh;
    /**
     * Edit subject web element.
     */
    @FindBy(xpath = "//button[@title=\"Edit Subject\"]")
    private WebElement editSubjectTask;

    /**
     * Update new subject task web element.
     */
    @FindBy(xpath = "//lightning-grouped-combobox[contains(@class,'slds-form-element forceTextEnumLookup')]")
    private WebElement updateNewSubjectTask;

    /**
     * Save update web element.
     */
    @FindBy(xpath = "//button[contains(@class,'slds-button slds-button--neutral uiButton--brand')]")
    private WebElement saveUpdateTask;

    @FindBy(xpath = "//div[span[img[@title='User']]]")
    private WebElement userIcon;


    /**
     * Verify subject is displayed.
     *
     * @param subjectTask the subject.
     * @return if successful
     */
    public boolean verifySubjectExist(final String subjectTask) {
        try {
            WebElement subjectExist =
                    driver.findElement(By.xpath("//span[contains(text(),\""
                            + subjectTask + "\")][1]"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Click task.
     */
    public void clickDisplayTask() {
        task.click();
    }

    /**
     * Click save update.
     */
    public void clickSaveUpdateTask() {
        saveUpdateTask.click();
    }

    /**
     * Click recent refresh.
     */
    public void clickRecentTasksRefresh() {
        recentTasksRefresh.click();
        try {
            Thread.sleep(MILLIS);
        } catch (Exception e) {
        }
    }

    /**
     * Click dropdown.
     */
    public void clickDropDownButton() {

        if (WebDriverConfig.getInstance().getBrowser().toLowerCase() == "chrome") {
            getDisplayAsDropDownButton.click();
        } else {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", getDisplayAsDropDownButton);
        }
    }

    /**
     * click delete item.
     */
    public void clickDeleteItem() {
        deletetask.click();
    }

    /**
     * Click the delete confirmation.
     */
    public void clickDeleteConfirmationItem() {
        deleteConfirmationtask.click();
    }

    /**
     * Click edit subject.
     */
    public void clickEditSubjectTask() {
        editSubjectTask.click();
    }

    /**
     * Update task subject.
     *
     * @param newSubjectTask new subject
     */
    public void setUpdateNewSubjectTask(final String newSubjectTask) {
        updateNewSubjectTask.sendKeys(newSubjectTask);
    }

    /**
     * Delete current task.
     *
     * @param task the task
     */
    public void deleteCurrentTask(final Task task) {
        clickDropDownButton();
        clickDeleteItem();
        try {
            Thread.sleep(MILLIS);
        } catch (Exception e) {
        }
        clickDeleteConfirmationItem();
    }

    /**
     * Update current task.
     *
     * @param task the task
     * @return updated task
     */
    public Task updateCurrentTask(final Task task) {
        clickEditSubjectTask();

        String nameTaskSubject = "Updated" + String.valueOf((int) (Math.random() * INT));
        setUpdateNewSubjectTask(nameTaskSubject);
        clickSaveUpdateTask();
        try {
            Thread.sleep(MILLIS);
        } catch (Exception e) {
        }
        task.setSubject(task.getSubject() + nameTaskSubject);
        return task;
    }

    /**
     * Logout.
     */
    public void logout() {
        userIcon.click();
        WebElement itemToSelect = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//a[text()='Log Out']")));
        itemToSelect.click();
        try {
            Thread.sleep(MILLIS);
        } catch (Exception e) {
        }
    }

    /**
     * Wait for page to load.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
