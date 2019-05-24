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

package salesforce.ui.pages.classic.campaign;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import salesforce.entities.Campaign;
import salesforce.ui.pages.abstracts.campaign.NewCampaignAbstract;

/**
 * NewCampaignClassicPage.
 * @author Regis Humana.
 */
public class NewCampaignClassicPage extends NewCampaignAbstract {
    /**
     * Main Form of New Campaign.
     */
    @FindBy(id = "bodyCell")
    private WebElement newCampaignForm;
    /**
     * Name TextBox.
     */
    @FindBy(id = "cpn1")
    private WebElement nameTxt;
    /**
     * Save bottom Button.
     */
    @FindBy (xpath = "//td[@id=\"bottomButtonRow\"]//input[@name=\"save\"]")
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
    protected void setActiveChk(boolean isActivate) {
        if(isActivate) {
            activateChk.click();
        }
    }

    @Override
    protected void setTypeCmb(String type) {
        Select accountRole = new Select(typeCmb);
        accountRole.selectByVisibleText(type);
    }

    @Override
    protected void setStatusCmb(String status) {
        Select accountRole = new Select(statusCmb);
        accountRole.selectByVisibleText(status);
    }

    @Override
    protected void setStartDate(String startDate) {
        startDateTxt.sendKeys(startDate);
    }

    @Override
    protected void setEndDate(String endDate) {
        endDateTxt.sendKeys(endDate);
    }

    @Override
    protected void setExpectedRevenueTxt(Integer expected) {
        expectedRevenueTxt.sendKeys(expected.toString());
    }

    @Override
    protected void setBudgetedCostTxt(Integer budgeted) {
        budgetedCostTxt.sendKeys(budgeted.toString());
    }

    @Override
    protected void setActualCostTxt(Integer actualCost) {
        actualCostTxt.sendKeys(actualCost.toString());
    }

    @Override
    protected void setNumSent(Integer numSent) {
        numSentTxt.sendKeys(numSent.toString());
    }

    @Override
    protected void setDescriptionTxt(String description) {
        descriptionTxt.sendKeys(description);
    }

    @Override
    public void setCampaignData(Campaign data) {
        super.setCampaignData(data);
    }
}