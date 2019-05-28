/*
 * @(#) OneCampaignClassicPage.java Copyright (c) 2019 Jala Foundation.
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
import salesforce.ui.pages.abstracts.campaign.EditCampaignAbstract;
import salesforce.ui.pages.abstracts.campaign.NewCampaignAbstract;
import salesforce.ui.pages.abstracts.campaign.OneCampaignAbstract;

/**
 * OneCampaignClassicPage.
 * @author Regis Humana
 * @version 0.0.1
 */
public class OneCampaignClassicPage extends OneCampaignAbstract {
    @FindBy(xpath = "//td[@class=\" oRight\"]")
    private WebElement campaignDetailForm;

    @FindBy(xpath = "//h1[@class=\"pageType\"]")
    private WebElement campaignPanelTitle;

    @FindBy(xpath = "//h2[@class=\"pageDescription\"]")
    private WebElement campaignTitleLbl;

    @FindBy(css = "td[id='topButtonRow'] input[value='Delete']")
    private WebElement deleteUpBtn;
    /**
     * Wait for Campaign panel title.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(campaignPanelTitle));
    }

    /**
     * Verify if the components of the Campaign exist.
     * @return boolean
     */
    @Override
    public boolean verifyComponentsCampaign() {
        return campaignDetailForm.isDisplayed();
    }

    /**
     * Get the Name Campaign.
     * @return string
     */
    @Override
    public String getNameCampaign() {
        return campaignTitleLbl.getText();
    }

    /**
     * Delete campaign.
     * @param nameCampaign string
     */
    @Override
    public void deleteCampaign(final String nameCampaign) {
        deleteUpBtn.click();
        driver.switchTo().alert().accept();
    }
//todo DO it

    @Override
    public EditCampaignAbstract openEditCampaign() {
        return null;
    }
}