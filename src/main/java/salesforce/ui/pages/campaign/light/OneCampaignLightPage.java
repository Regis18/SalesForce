/*
 * @(#) OneCampaignLightPage.java Copyright (c) 2019 Jala Foundation.
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Campaign;
import salesforce.ui.pages.campaign.abstracts.EditCampaignAbstract;
import salesforce.ui.pages.campaign.abstracts.OneCampaignAbstract;
import salesforce.utils.DriverMethods;

import java.util.Map;

/**
 * OneCampaignLightPage.
 * @author Regis Humana.
 * @version 0.0.1
 */
public class OneCampaignLightPage extends OneCampaignAbstract {
    @FindBy(xpath = "//div[contains(@class,\"s1FixedTop forceHighlightsStencilDesktop\")]")
    private WebElement campaignPanelTitle;

    @FindBy(xpath = "//span[contains(@class, \"forceActionsText\")]")
    private WebElement messageConfirmation;

    @FindBy(xpath = "//div[contains(@class,\"OutputName\")]//span[contains(@class,\"OutputText\")]")
    private WebElement campaignTitleLbl;

    @FindBy(xpath = "//a[@title=\"Details\" ]//span[@class=\"title\"]")
    private WebElement detailsTab;

    @FindBy(xpath = "//div[@data-component-id=\"flexipage_tabset\"]//section[contains(@class,\"active uiTab\")]")
    private WebElement detailsForm;

    @FindBy(xpath = "//ul[contains(@class,'slds-button-group slds-m-left--xx-small o')]" +
                    "//div[@data-aura-class='uiPopupTrigger']//a")
    private WebElement mainMenuCmb;

    @FindBy(xpath = "//div[starts-with(@class,'branding-actions ')]//child::li[3]//a")
    private WebElement deleteMainMenuCmb;

    @FindBy(xpath = "//div[starts-with(@class,'branding-actions ')]//child::li[2]//a")
    private WebElement editMainMenuCmb;

    //**can be removed
    @FindBy(css = "button[title='Delete']")
    private WebElement deletePopupBtn;

    private String valueCampaign = "//div[div[span[contains(text(),'key')]]]//*//span[contains(text(),'element')]";

    private final String ELEMENT = "element";

    private final String KEY = "key";

    /**
     * Wait for Campaign Panel Title.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(campaignPanelTitle));
    }

    /**
     * Verify the components of the campaign.
     * @return
     */
    @Override
    public boolean verifyComponentsCampaign() {
        clickDetailsTab();
        return detailsForm.isDisplayed();
    }

    /**
     * Get the name of the Campaign title.
     * @return name string
     */
    @Override
    public String getNameCampaign() {
        return campaignTitleLbl.getText();
    }

    /**
     * Get the message confirmation.
     * @return message string.
     */
    public String getMessageConfirmation() {
        return messageConfirmation.getText();
    }

    /**
     * Click to detailsTab.
     */
    private void clickDetailsTab() {
        detailsTab.click();
    }

    /**
     * Delete campaign.
     * @param nameCampaign string
     */
    @Override
    public void deleteCampaign(final String nameCampaign) {
        mainMenuCmb.click();
        deleteMainMenuCmb.click();
        deletePopupBtn.click();
    }

    /**
     * Open the Edit Popup doing click in the menu.
     * @return EditCampaignAbstract could be Light o Classic.
     */
    @Override
    public EditCampaignAbstract openEditCampaign() {
        mainMenuCmb.click();
        editMainMenuCmb.click();
        return new EditCampaignLightPopup();
    }

    /**
     * Check if the values of Campaign is correct in the list.
     * @param key String.
     * @param value Value.
     * @return Boolean
     */
    public boolean isCampaignFieldValueDisplayed(String key, String value) {
        return DriverMethods.isElementPresent(By.xpath(valueCampaign.replace(ELEMENT, value).replace(KEY, key)));
    }
}