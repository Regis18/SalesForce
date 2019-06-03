/*
 * @(#) EditCampaignClassicPage.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.campaign.classic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.campaign.abstracts.EditCampaignAbstract;

/**
 * EditCampaignClassicPage.
 * @author Regis Humana.
 * @version 0.0.1
 */
public class EditCampaignClassicPage extends EditCampaignAbstract {

    @FindBy(id = "bodyCell")
    private WebElement editBodyForm;

    @FindBy(css = "[id='topButtonRow'] input[name='save']")
    private WebElement saveBtn;

    @FindBy(id = "cpn1")
    private WebElement nameTxt;

    @FindBy(id = "cpn16")
    private WebElement activateChk;

    @FindBy(id = "cpn2")
    private WebElement typeCmb;

    @FindBy(id = "cpn3")
    private WebElement statusCmb;

    @FindBy(id = "cpn5")
    private WebElement startDateTxt;

    @FindBy(id = "cpn6")
    private WebElement endDateTxt;

    @FindBy(id = "cpn8")
    private WebElement expectedRevenueTxt;

    @FindBy(id = "cpn9")
    private WebElement budgetedCostTxt;

    @FindBy(id = "cpn10")
    private WebElement actualCostTxt;

    @FindBy(id = "cpn11")
    private WebElement expectedResponseTxt;

    @FindBy(id = "cpn13")
    private WebElement numSentTxt;

    @FindBy(id = "cpn4")
    private WebElement descriptionTxt;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(editBodyForm));
    }
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
        typeCmb.sendKeys(type);
    }

    /**
     * Set status combo box.
     *
     * @param status string.
     */
    @Override
    protected void setStatusCmb(final String status) {
        //--None--, Planned, Completed, In Progress, Aborted
        statusCmb.sendKeys(status);
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
        expectedResponseTxt.clear();
        expectedResponseTxt.sendKeys(expectedResponse.toString());
    }
}
