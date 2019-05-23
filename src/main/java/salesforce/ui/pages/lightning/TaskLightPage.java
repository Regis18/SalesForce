/*
 * @(#) TaskLightPage.java Copyright (c) 2019 Jala Foundation.
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.BasePage;

/**
 * TaskLightPage class in this class whe navigate for this page the task created are displayed.
 *
 * @author Melvi Caballero
 * @version 0.0.1
 */
public class TaskLightPage extends BasePage {
    public static final int MILLIS = 2500;
    public static final int INT = 100;
    /**
     * task web element.
     */
    @FindBy(css = ".forceRecordLayout:nth-child(1) .slds-split-view__list-item-action .slds-grow")
    private WebElement task;

//    @FindBy(xpath = "//*[contains(@class,\"slds-button__icon_x-small\")]")
//    private WebElement displayAsDropDownButton;

    /**
     * dropdownbutton web element.
     */
    @FindBy(xpath = "//a[contains(@class,\"sldsButtonHeightFix\")]")
    private WebElement getDisplayAsDropDownButton;
    /**
     * delete task web element.
     */
    @FindBy(xpath = "//a[contains(.,'Delete')]")
    private WebElement deletetask;
    /**
     * delete confirmation web element.
     */
    @FindBy(xpath = "//button[span[contains(.,'Delete')]]")
    private WebElement deleteConfirmationtask;
    /**
     * recent task refresh web element.
     */
    @FindBy(xpath = "//button[@name='refreshButton']")
    private WebElement recentTasksRefresh;
    /**
     * edit subject web element.
     */
    @FindBy(xpath = "//button[@title=\"Edit Subject\"]")
    private WebElement editSubjectTask;
    /**
     * update new subject task web element.
     */
    @FindBy(xpath = "//lightning-grouped-combobox[contains(@class,'slds-form-element forceTextEnumLookup')]")
    private WebElement updateNewSubjectTask;
    /**
     * save update web element.
     */
    @FindBy(xpath = "//button[contains(@class,'slds-button slds-button--neutral uiButton--brand')]")
    private WebElement saveUpdateTask;

    /**
     * Verify subject is displayed.
     *
     * @param subjectTask the subject.
     * @return if successful
     */
    public boolean verifySubjectExist(final String subjectTask) {
        try {
            WebElement subjectExist =
                    driver.findElement(By.xpath("//span[contains(text(),\"" + subjectTask + "\")][1]"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * click task.
     */
    public void clickDisplayTask() {
        task.click();
    }

    /**
     * click save update.
     */
    public void clickSaveUpdateTask() {
        saveUpdateTask.click();
    }

    /**
     * click recent refresh.
     */
    public void clickRecentTasksRefresh() {
        recentTasksRefresh.click();
        try {
            Thread.sleep(MILLIS);
        } catch (Exception e) {
        }
    }

    /**
     * click dropdown.
     */
    public void clickDropDownButton() {
        getDisplayAsDropDownButton.click();
    }

    /**
     * clic delete item.
     */
    public void clickDeleteItem() {
        deletetask.click();
    }

    /**
     * clic the delete confirmation.
     */
    public void clickDeleteConfirmationItem() {
        deleteConfirmationtask.click();
    }

    /**
     * click edit subject.
     */
    public void clickEditSubjectTask() {
        editSubjectTask.click();
    }

    /**
     * update task subject.
     *
     * @param newSubjectTask new subject
     */
    public void setUpdateNewSubjectTask(final String newSubjectTask) {
        updateNewSubjectTask.sendKeys(newSubjectTask);
    }

    /**
     * delete current task.
     */
    public void deleteCurrentTask() {
        clickDropDownButton();
        clickDeleteItem();
        try {
            Thread.sleep(MILLIS);
        } catch (Exception e) {
        }
        clickDeleteConfirmationItem();
    }

    /**
     * update current task.
     *
     * @return new subject.
     */
    public String updateCurrentTask() {
        clickEditSubjectTask();
        String nameTaskSubject = "Updated" + String.valueOf((int) (Math.random() * INT));
        setUpdateNewSubjectTask(nameTaskSubject);
        clickSaveUpdateTask();
        return nameTaskSubject;
    }

    /**
     * wait for page to load.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
