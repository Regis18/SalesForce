/*
 * @(#) CampaignClassicPage.java Copyright (c) 2019 Jala Foundation.
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
import salesforce.ui.pages.abstracts.CampaignPageAbstract;

/**
 * CampaignClassicPage.
 * @author Regis Humana.
 */
public class CampaignClassicPage extends CampaignPageAbstract {
    /**
     * CampaignForm.
     */
    @FindBy(id = "bodyCell")
    private WebElement campaignForm;
    /**
     * Button: New Campaign.
     */
    @FindBy(xpath = "//input[@name=\"new\"]")
    private WebElement newCampaignBtn;

    /**
     * Wait for Campaign Form.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(campaignForm));
    }

    /**
     * Click in to New Campaign button and initialize NewCampaignClassicPage.
     * @return NewCampaignClassicPage.
     */
    @Override
    public NewCampaignClassicPage clickNewCampaignBtn() {
        newCampaignBtn.click();
        return new NewCampaignClassicPage();
    }

    @Override
    public boolean checkCampaignList(String name) {
        return true;
    }
}
