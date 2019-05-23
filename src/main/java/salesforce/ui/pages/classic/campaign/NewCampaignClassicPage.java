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

    }

    @Override
    protected void setTypeCmb(String type) {

    }

    @Override
    protected void setStatusCmb(String status) {

    }

    @Override
    protected void setStartDate(String startDate) {

    }

    @Override
    protected void setEndDate(String endDate) {

    }

    @Override
    protected void setExpectedRevenueTxt(Integer expected) {

    }

    @Override
    protected void setBudgetedCostTxt(Integer budgeted) {

    }

    @Override
    protected void setActualCostTxt(Integer actualCost) {

    }

    @Override
    protected void setNumSent(Integer numSent) {

    }

    @Override
    protected void setDescriptionTxt(String description) {

    }

    @Override
    public void setCampaignData(Campaign data) {
        super.setCampaignData(data);
    }
}
