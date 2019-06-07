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

package salesforce.ui.pages.campaign.classic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.campaign.abstracts.CampaignPageAbstract;
import salesforce.utils.DriverMethods;

/**
 * CampaignClassicPage.
 * @author Regis Humana.
 * @version 0.0.1
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
    @FindBy(xpath = "//input[@name='new']")
    private WebElement newCampaignBtn;

    @FindBy(id = "phSearchInput")
    private WebElement searchTxt;

    private String campaignList = "//tr[@onmouseout='if (window.hiOff){hiOff(this);}']//a[contains(text(),'campaign')]";
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

    /**
     * Check the campaign name in the list.
     * @param name string.
     * @return boolean.
     */
    @Override
    public boolean checkCampaignList(final String name) {
        return DriverMethods.searchForExistentElement(By.xpath(campaignList.replace("campaign", name)));
    }
    /**
     * Searches the campaign in the list.
     * @param name string.
     */
    @Override
    public void searchCampaignInList(String name) {
        searchTxt.click();
    }
}
