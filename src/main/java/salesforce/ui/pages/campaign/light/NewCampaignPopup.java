/*
 * @(#) NewCampaignPopup.java Copyright (c) 2019 Jala Foundation.
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
import salesforce.entities.Campaign;
import salesforce.ui.pages.campaign.abstracts.NewCampaignAbstract;

import java.util.Map;

/**
 * NewCampaignPopup.
 * @author Regis Humana.
 * @version 0.0.1
 */
public class NewCampaignPopup extends NewCampaignAbstract {

    @FindBy(css = "div[class='modal-container slds-modal__container']")
    private WebElement newCampaignPopup;

    @FindBy(xpath = "//div[@data-aura-class=\"uiInput uiInputText uiInput--default uiInput--input\"]//input")
    private WebElement nameTxt;

    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[contains(@class,'uiInputCheckbox')]//input[@type='checkbox']")
    private WebElement activateChk;

    @FindBy(css = "input[id^='254']")
    private WebElement startDateTxt;

    @FindBy(css = "input[id^='295']")
    private WebElement endDateTxt;

    @FindBy(css = "input[id^='336']")
    private WebElement expectedRevenueTxt;

    @FindBy(css = "input[id^='372']")
    private WebElement budgetedCostTxt;

    @FindBy(css = "input[id^='408']")
    private WebElement actualCostTxt;

    @FindBy(css = "input[id^='444']")
    private WebElement expectedResponseTxt;

    @FindBy(css = "input[id^='480']")
    private WebElement numSentTxt;

    @FindBy(css = "textarea[id^='621']")
    private WebElement descriptionTxt;

    @FindBy(css = "[class='genericError uiOutputText']")
    private WebElement reviewErrorMessageLbl;

    @FindBy(css = "[class='errorsList'] li")
    private WebElement requiredFieldsMessageLbl;

    private String statusElements = "li[role='presentation'] a[title='element']";

    /**
     * Wait for the Popup to initialize.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newCampaignPopup));
    }

    /**
     * Set the name into NameTxt.
     * @param name **this is the name**
     */
    protected void setNameTxt(final String name) {
        nameTxt.sendKeys(name);
    }

    /**
     * Click to Save the changes.
     */
    public void clickSaveBtn() {
        saveBtn.click();
    }

    /**
     * Set Activate checkbox.
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
     * @param type string.
     */
    @Override
    protected void setTypeCmb(final String type) {
        WebElement typeCmb = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("div[id^='133'] a")));
        typeCmb.click();
        driver.findElement(By.cssSelector(statusElements.replace("element", type))).click();
    }

    /**
     * Set status combo box.
     * @param status string.
     */
    @Override
    protected void setStatusCmb(final String status) {
        //--None--, Planned, Completed, In Progress, Aborted
        WebElement statusCmb = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector("div[id^='197'] a")));
        statusCmb.click();
        driver.findElement(By.cssSelector(statusElements.replace("element", status))).click();
    }

    /**
     * Set start date text box.
     * @param startDate string.
     */
    @Override
    protected void setStartDate(final String startDate) {
        startDateTxt.clear();
        startDateTxt.sendKeys(startDate);
    }

    /**
     * Set end date text box.
     * @param endDate string.
     */
    @Override
    protected void setEndDate(final String endDate) {
        endDateTxt.clear();
        endDateTxt.sendKeys(endDate);
    }

    /**
     * Set expected revenue text box.
     * @param expected integer.
     */
    @Override
    protected void setExpectedRevenueTxt(final Integer expected) {
        expectedRevenueTxt.clear();
        expectedRevenueTxt.sendKeys(expected.toString());
    }

    /**
     * Set budgeted cost text box.
     * @param budgeted integer.
     */
    @Override
    protected void setBudgetedCostTxt(final Integer budgeted) {
        budgetedCostTxt.clear();
        budgetedCostTxt.sendKeys(budgeted.toString());
    }

    /**
     * Set actual cost text box.
     * @param actualCost integer.
     */
    @Override
    protected void setActualCostTxt(final Integer actualCost) {
        actualCostTxt.clear();
        actualCostTxt.sendKeys(actualCost.toString());
    }

    /**
     * Set num sent text box.
     * @param numSent integer.
     */
    @Override
    protected void setNumSent(final Integer numSent) {
        numSentTxt.clear();
        numSentTxt.sendKeys(numSent.toString());
    }

    /**
     * Set description text box.
     * @param description string.
     */
    @Override
    protected void setDescriptionTxt(final String description) {
        descriptionTxt.clear();
        descriptionTxt.sendKeys(description);
    }

    /**
     * Set campaign data into Campaign form.
     * @param data Campaign
     * @param map Map
     */
    @Override
    public void setCampaignData(final Campaign data, final Map<String, String> map) {
        super.setCampaignData(data, map);
    }

    /**
     * Set to Expected Response text.
     * @param expectedResponse string
     */
    @Override
    protected void setExpectedResponse(final Integer expectedResponse) {
        expectedResponseTxt.sendKeys(Keys.CONTROL + "a");
        expectedResponseTxt.sendKeys(Keys.DELETE);
        expectedResponseTxt.sendKeys(expectedResponse.toString());
    }
}
