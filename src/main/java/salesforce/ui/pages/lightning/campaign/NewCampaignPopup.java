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

package salesforce.ui.pages.lightning.campaign;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import salesforce.entities.Campaign;
import salesforce.ui.pages.abstracts.campaign.NewCampaignAbstract;

import java.lang.ref.PhantomReference;
import java.util.List;


/**
 * NewCampaignPopup.
 * @author Regis Humana.
 * @version 0.0.1
 */
public class NewCampaignPopup extends NewCampaignAbstract {

    @FindBy(css = "div[class=\"modal-container slds-modal__container\"]")
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

    @FindBy(css = "div[id^='133']")
    private WebElement typeCmb;

    @FindBy(css = "div[id^='197']")
    private WebElement statusCmb;

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
    protected void setActiveChk(boolean isActivate) {
        if(isActivate) {
            activateChk.click();
        }
    }

    /**
     * Set type combo box.
     * @param type string.
     */
    @Override
    protected void setTypeCmb(String type) {
//        Select accountRole = new Select(typeCmb);
//        accountRole.selectByVisibleText(type);
        typeCmb.sendKeys(type);
    }

    /**
     * Set status combo box.
     * @param status string.
     */
    @Override
    protected void setStatusCmb(String status) {
//        Select accountRole = new Select(statusCmb);
//        accountRole.selectByVisibleText(status);
        statusCmb.sendKeys(status);
    }

    /**
     * Set start date text box.
     * @param startDate string.
     */
    @Override
    protected void setStartDate(String startDate) {
        startDateTxt.sendKeys(startDate);
    }

    /**
     * Set end date text box.
     * @param endDate string.
     */
    @Override
    protected void setEndDate(String endDate) {
        endDateTxt.sendKeys(endDate);
    }

    /**
     * Set expected revenue text box.
     * @param expected integer.
     */
    @Override
    protected void setExpectedRevenueTxt(Integer expected) {
        expectedRevenueTxt.sendKeys(expected.toString());
    }

    /**
     * Set budgeted cost text box.
     * @param budgeted integer.
     */
    @Override
    protected void setBudgetedCostTxt(Integer budgeted) {
        budgetedCostTxt.sendKeys(budgeted.toString());
    }

    /**
     * Set actual cost text box.
     * @param actualCost integer.
     */
    @Override
    protected void setActualCostTxt(Integer actualCost) {
        actualCostTxt.sendKeys(actualCost.toString());
    }

    /**
     * Set num sent text box.
     * @param numSent integer.
     */
    @Override
    protected void setNumSent(Integer numSent) {
        numSentTxt.sendKeys(numSent.toString());
    }

    /**
     * Set description text box.
     * @param description string.
     */
    @Override
    protected void setDescriptionTxt(String description) {
        descriptionTxt.sendKeys(description);
    }

    /**
     * Set campaign data into Campaign form.
     * @param data Campaign
     */
    @Override
    public void setCampaignData(Campaign data) {
        super.setCampaignData(data);
    }
}
