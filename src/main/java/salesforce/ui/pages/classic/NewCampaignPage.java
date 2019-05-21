/*
 * @(#) NewCampaignPage.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.classic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Campaign;
import salesforce.ui.behaves.NewCampaignAbstract;

/**
 * NewCampaignPage.
 * @author Regis Humana.
 */
public class NewCampaignPage extends NewCampaignAbstract {
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

    /**
     * Set Campaign Data into all the information that campaign needs.
     * @Param data Campaign
     */
    @Override
    protected void setCampaignData(final Campaign data) {
        setNameTxt(data.getName());
    }
}
