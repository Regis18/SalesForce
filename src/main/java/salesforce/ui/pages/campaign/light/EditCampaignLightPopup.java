/*
 * @(#) EditCampaignLightPopup.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.campaign.light;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.campaign.abstracts.EditCampaignAbstract;

/**
 * EditCampaignLightPopup.
 *
 * @author Regis Humana
 * @version 0.0.1
 */
public class EditCampaignLightPopup extends EditCampaignAbstract {

    @FindBy(css = "[class='modal-container slds-modal__container']")
    private WebElement editCampaignPopup;

    @FindBy(css = "[class^='uiInput uiInputText'] input")
    private WebElement nameTxt;

    @FindBy(css = "[class^='slds-button slds-button--neutral uiButton--default']")
    private WebElement saveBtn;

    @FindBy(css = "[class^='uiInput uiInputCheckbox'] input")
    private WebElement activateChk;

    @FindBy(xpath = "//child::div[4][contains(@class,'Row')]//a")
    private WebElement typeCmb;

    @FindBy(xpath = "//child::div[5][contains(@class,'Row')]//a")
    private WebElement statusCmb;

    @FindBy(xpath = "//child::div[6][contains(@class,'Row')]//input")
    private WebElement startDateTxt;

    @FindBy(xpath = "//child::div[7][contains(@class,'Row')]//input")
    private WebElement endDateTxt;

    @FindBy(xpath = "//child::div[8][contains(@class,'Row')]//input")
    private WebElement expectedRevenueTxt;

    @FindBy(xpath = "//child::div[9][contains(@class,'Row')]//input")
    private WebElement budgetedCostTxt;

    @FindBy(xpath = "//child::div[10][contains(@class,'Row')]//input")
    private WebElement actualCostTxt;

    @FindBy(xpath = "//child::div[11][contains(@class,'Row')]//input")
    private WebElement expectedResponseTxt;

    @FindBy(xpath = "//child::div[12][contains(@class,'Row')]//input")
    private WebElement numSentTxt;

    @FindBy(css = "[class=' textarea']")
    private WebElement descriptionTxt;

    private String statusElements = "div[role=\"menu\"] li[role='presentation'] a[title='element']";

    /**
     * Waits for the Edit Campaign Popup appears.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(editCampaignPopup));
    }

    //SETTERS

    /**
     * Sets the name into NameTxt.
     *
     * @param name **this is the name**
     */
    protected void setNameTxt(final String name) {
        nameTxt.clear();
        nameTxt.sendKeys(name);
    }

    /**
     * Clicks to Save the changes.
     */
    public void clickSaveBtn() {
        saveBtn.click();
    }

    /**
     * Sets Activate checkbox.
     *
     * @param isActivate boolean
     */
    @Override
    protected void setActiveChk(final boolean isActivate) {
        if (isActivate) {
            activateChk.click();
        }
    }

    /**
     * Set type combo box.
     *
     * @param type string.
     */
    @Override
    protected void setTypeCmb(final String type) {
        typeCmb.click();
        driver.findElement(By.cssSelector(statusElements.replace("element", type))).click();
    }

    /**
     * Set status combo box.
     *
     * @param status string.
     */
    @Override
    protected void setStatusCmb(final String status) {
        //--None--, Planned, Completed, In Progress, Aborted
        statusCmb.click();
        driver.findElement(By.cssSelector(statusElements.replace("element", status))).click();
    }

    /**
     * Sets start date text box.
     *
     * @param startDate string.
     */
    @Override
    protected void setStartDate(final String startDate) {
        startDateTxt.clear();
        startDateTxt.sendKeys(startDate);
    }

    /**
     * Sets end date text box.
     *
     * @param endDate string.
     */
    @Override
    protected void setEndDate(final String endDate) {
        endDateTxt.clear();
        endDateTxt.sendKeys(endDate);
    }

    /**
     * Sets expected revenue text box.
     *
     * @param expected integer.
     */
    @Override
    protected void setExpectedRevenueTxt(final Integer expected) {
        expectedRevenueTxt.clear();
        expectedRevenueTxt.sendKeys(expected.toString());
    }

    /**
     * Sets budgeted cost text box.
     *
     * @param budgeted integer.
     */
    @Override
    protected void setBudgetedCostTxt(final Integer budgeted) {
        budgetedCostTxt.clear();
        budgetedCostTxt.sendKeys(budgeted.toString());
    }

    /**
     * Sets actual cost text box.
     *
     * @param actualCost integer.
     */
    @Override
    protected void setActualCostTxt(final Integer actualCost) {
        actualCostTxt.clear();
        actualCostTxt.sendKeys(actualCost.toString());
    }

    /**
     * Sets num sent text box.
     *
     * @param numSent integer.
     */
    @Override
    protected void setNumSent(final Integer numSent) {
        numSentTxt.clear();
        numSentTxt.sendKeys(numSent.toString());
    }

    /**
     * Sets description text box.
     *
     * @param description string.
     */
    @Override
    protected void setDescriptionTxt(final String description) {
        descriptionTxt.clear();
        descriptionTxt.sendKeys(description);
    }

    /**
     * Set to Expected Response text.
     *
     * @param expectedResponse string
     */
    @Override
    protected void setExpectedResponse(final Integer expectedResponse) {
        expectedResponseTxt.sendKeys(Keys.CONTROL + "a");
        expectedResponseTxt.sendKeys(Keys.DELETE);
        expectedResponseTxt.sendKeys(expectedResponse.toString());
    }

}
