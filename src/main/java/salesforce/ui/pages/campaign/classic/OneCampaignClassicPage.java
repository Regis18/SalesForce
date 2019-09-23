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

package salesforce.ui.pages.campaign.classic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Campaign;
import salesforce.ui.pages.campaign.abstracts.CampaignPageAbstract;
import salesforce.ui.pages.campaign.abstracts.EditCampaignAbstract;
import salesforce.ui.pages.campaign.abstracts.OneCampaignAbstract;
import salesforce.utils.DriverMethods;

/**
 * OneCampaignClassicPage.
 *
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

    @FindBy(css = "[id='topButtonRow'] input[name='edit']")
    private WebElement editUpBtn;

    @FindBy(id = "Campaign_Tab")
    private WebElement campaignTabBar;

    private String valueCampaign = "//*[td[contains(text(), 'key')]]//*//div[contains(text(), 'element')]";

    private String valueActiveCampaign = "//*[td[contains(text(), 'key')]]//*//div//img[@title='element']";

    private final String element = "element";

    private final String key = "key";

    /**
     * Wait for Campaign panel title.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(campaignPanelTitle));
    }

    /**
     * Verify if the components of the Campaign exist.
     *
     * @return boolean
     */
    @Override
    public boolean verifyComponentsCampaign(final Campaign campaign) {
        return campaignDetailForm.isDisplayed();
    }

    /**
     * Gets the Name Campaign.
     *
     * @return string
     */
    @Override
    public String getNameCampaign() {
        return campaignTitleLbl.getText();
    }

    /**
     * Deletes campaign.
     *
     * @param nameCampaign string
     * @return CampaignClassicPage.
     */
    @Override
    public CampaignPageAbstract deleteCampaign(final String nameCampaign) {
        wait.until(ExpectedConditions.visibilityOf(deleteUpBtn));
        deleteUpBtn.click();
        driver.switchTo().alert().accept();
        return new CampaignClassicPage();
    }

    /**
     * Opens a form for edit a campaign.
     *
     * @return EditCampaignClassic
     */
    @Override
    public EditCampaignAbstract openEditCampaign() {
        wait.until(ExpectedConditions.visibilityOf(editUpBtn));
        editUpBtn.click();
        return new EditCampaignClassicPage();
    }

    /**
     * Check if the values of Campaign is correct in the list.
     *
     * @param key   String.
     * @param value Value.
     * @return Boolean.
     */
    @Override
    public boolean isCampaignFieldValueDisplayed(final String key, final String value) {
        if (key.equals("Active")) {
            String values = value.equals("true") ? "Checked" : "Not Checked";
            return DriverMethods.searchForExistentElement(By.xpath(valueActiveCampaign
                    .replace(this.element, values)
                    .replace(this.key, key)));
        } else {
            return DriverMethods.searchForExistentElement(By.xpath(valueCampaign
                    .replace(this.element, value)
                    .replace(this.key, key)));
        }
    }

    /**
     * Click the button Campaign and redirected to CampaignPage.
     *
     * @return CampaignPageAbstract.
     */
    @Override
    public CampaignPageAbstract openCampaignPage() {
        campaignTabBar.click();
        return new CampaignClassicPage();
    }
}