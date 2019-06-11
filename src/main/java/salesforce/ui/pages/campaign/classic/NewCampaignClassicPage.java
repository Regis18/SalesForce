/*
 * @(#) NewCampaignClassicPage.java Copyright (c) 2019 Jala Foundation.
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

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import salesforce.entities.Campaign;
import salesforce.ui.pages.campaign.abstracts.NewCampaignAbstract;

import java.util.Map;

/**
 * NewCampaignClassicPage.
 * @author Regis Humana.
 * @version 0.0.1
 */
public class NewCampaignClassicPage extends NewCampaignAbstract {

    @FindBy(id = "bodyCell")
    private WebElement newCampaignForm;

    @FindBy(id = "cpn1")
    private WebElement nameTxt;

    @FindBy (xpath = "//td[@id='bottomButtonRow']//input[@name='save']")
    private WebElement saveBottomBtn;

    @FindBy(id = "cpn16")
    private WebElement activateChk;

    @FindBy(id = "cpn5")
    private WebElement startDateTxt;

    @FindBy(id = "cpn6")
    private WebElement endDateTxt;

    @FindBy(id = "cpn2")
    private WebElement typeCmb;

    @FindBy(id = "cpn3")
    private WebElement statusCmb;

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

    /**
     * Wait for newCampaignForm.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newCampaignForm));
    }

    /**
     * Click into Save bottom.
     */
    @Override
    protected void clickSaveBtn() {
        saveBottomBtn.click();
    }

    /**
     * Set name in the name TextBox.
     * @param name String
     */
    @Override
    protected void setNameTxt(final String name) {
        nameTxt.sendKeys(name);
    }

    @Override
    protected void setActiveChk(final boolean isActivate) {
        if (isActivate) {
            activateChk.click();
        }
    }

    /**
     * Set Type of Lightning.
     * @param type string.
     */
    @Override
    protected void setTypeCmb(final String type) {
        Select accountRole = new Select(typeCmb);
        accountRole.selectByVisibleText(type);
    }

    /**
     * Set Status Combo Box.
     * @param status string.
     */
    @Override
    protected void setStatusCmb(final String status) {
        Select accountRole = new Select(statusCmb);
        accountRole.selectByVisibleText(status);
    }

    /**
     * Set start date.
     * @param startDate string.
     */
    @Override
    protected void setStartDate(final String startDate) {
        startDateTxt.sendKeys(startDate);
    }

    /**
     * Set End Date.
     * @param endDate string.
     */
    @Override
    protected void setEndDate(final String endDate) {
        endDateTxt.sendKeys(endDate);
    }

    /**
     * Set expected revenue text box.
     * @param expected integer.
     */
    @Override
    protected void setExpectedRevenueTxt(final Integer expected) {
        expectedRevenueTxt.sendKeys(expected.toString());
    }

    /**
     * Set budgeted cost text box.
     * @param budgeted integer.
     */
    @Override
    protected void setBudgetedCostTxt(final Integer budgeted) {
        budgetedCostTxt.sendKeys(budgeted.toString());
    }

    /**
     * Set actual cost text box.
     * @param actualCost integer.
     */
    @Override
    protected void setActualCostTxt(final Integer actualCost) {
        actualCostTxt.sendKeys(actualCost.toString());
    }

    /**
     * Set num sent text box.
     * @param numSent integer.
     */
    @Override
    protected void setNumSent(final Integer numSent) {
        numSentTxt.sendKeys(numSent.toString());
    }

    /**
     * Set description text box.
     * @param description string.
     */
    @Override
    protected void setDescriptionTxt(final String description) {
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

    /**
     * Get Message Error.
     * @return string.
     */
    @Override
    public String getMessageErrorLbl() {
        return "";
    }

    /**
     * Get Message Field Necessary.
     * @return string.
     */
    public  String getMessageFieldNecessaryLbl() {
        return "";
    }

    /**
     * Get Message Completed Field.
     * @return string.
     */
    public String getMessageCompletedFieldLbl() {
        return "";
    }
}
