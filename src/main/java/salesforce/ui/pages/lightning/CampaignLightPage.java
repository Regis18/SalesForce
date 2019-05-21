/*
 * @(#) CampaignLightPage.java Copyright (c) 2019 Jala Foundation.
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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Campaign;
import salesforce.ui.components.NewCampaignPopup;
import salesforce.ui.pages.abstracts.CampaignPageAbstract;

/**
 * CampaignPage
 * @author Regis Humana
 */
public class CampaignLightPage extends CampaignPageAbstract {
    /**
     * Title of the page "Campaign"
     */
    @FindBy(xpath = "//span[@class=\"uiOutputText forceBreadCrumbItem\"]")
    private WebElement campaignTitleLbl;
    /**
     * New button to create Campaign
     */
    @FindBy(xpath = "//a[@title=\"New\"]")
    private WebElement newCampaignBtn;

    /**
     * Wait for the title appears
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(campaignTitleLbl));
    }

    /**
     * Click to the New Campaign button and creates NewCampaignPopup object
     */
    @Override
    public NewCampaignPopup clickNewCampaignBtn() {
        newCampaignBtn.click();
        return new NewCampaignPopup();
    }

}
