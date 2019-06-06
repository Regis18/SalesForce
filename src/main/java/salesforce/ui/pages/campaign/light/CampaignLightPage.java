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
package salesforce.ui.pages.campaign.light;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
public class CampaignLightPage extends CampaignPageAbstract {

    @FindBy(xpath = "//span[@class=\"uiOutputText forceBreadCrumbItem\"]")
    private WebElement campaignTitleLbl;

    @FindBy(xpath = "//a[@title=\"New\"]")
    private WebElement newCampaignBtn;

    @FindBy(css = "[name='Campaign-search-input']")
    private WebElement searchCampaignTxt;

    private String campaignList = "//a[@data-refid=\"recordId\" and contains(text(),\"Campaign\")]";

    private final String campaign = "Campaign";

    /**
     * Wait for the title appears.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(campaignTitleLbl));
    }

    /**
     * Click to the New Campaign button and creates NewCampaignPopup object.
     */
    @Override
    public NewCampaignPopup clickNewCampaignBtn() {
        newCampaignBtn.click();
        return new NewCampaignPopup();
    }

    /**
     * Check name in Campaign List.
     * @param name string.
     * @return boolean.
     */
    @Override
    public boolean checkCampaignList(final String name) {
        return DriverMethods.isElementPresent(By.xpath(campaignList.replace(campaign, name)));
    }

    /**
     * Searches the campaign in the list.
     * @param name string.
     */
    @Override
    public void searchCampaignInList(final String name) {
        searchCampaignTxt.sendKeys(name);
        searchCampaignTxt.sendKeys(Keys.ENTER);
    }
}
