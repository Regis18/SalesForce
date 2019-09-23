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
import salesforce.ui.pages.campaign.abstracts.CampaignPageAbstract;
import salesforce.ui.pages.campaign.abstracts.EditCampaignAbstract;
import salesforce.ui.pages.campaign.abstracts.OneCampaignAbstract;
import salesforce.utils.DriverMethods;

/**
 * OneCampaignLightPage.
 * @author Regis Humana.
 * @version 0.0.1
 */
public class OneCampaignLightPage extends OneCampaignAbstract {
    @FindBy(xpath = "//div[contains(@class,\"s1FixedTop forceHighlightsStencilDesktop\")]")
    private WebElement campaignPanelTitle;

    @FindBy(xpath = "//span[contains(@class, 'forceActionsText')]")
    private WebElement messageConfirmation;

    @FindBy(xpath = "//button[@title='Close']")
    private WebElement closeMessageConfirmation;

    @FindBy(xpath = "//div[contains(@class,\"OutputName\")]//span[contains(@class,\"OutputText\")]")
    private WebElement campaignTitleLbl;

    @FindBy(xpath = "//div[@data-component-id=\"flexipage_tabset\"]//section[contains(@class,\"active uiTab\")]")
    private WebElement detailsForm;

    @FindBy(xpath = "//ul[contains(@class,'slds-button-group slds-m-left--xx-small o')]"
                    + "//div[@data-aura-class='uiPopupTrigger']//a")
    private WebElement mainMenuCmb;

    @FindBy(css = "[class='uiImage uiOutputCheckbox']")
    private WebElement isActive;

    //**can be removed
    @FindBy(css = "button[title='Delete']")
    private WebElement deletePopupBtn;

    private String valueCampaign = "//div[div[span[contains(text(),'key')]]]//*//span[contains(text(),'element')]";

    private String valueActiveCampaign = "//div[div[span[contains(text(),'key')]]]//*//span[*[@alt='element']]";

    private String nameCampaign = "//span//span[contains(text(), 'element')]";

    private final String element = "element";

    private final String key = "key";

    /**
     * Wait for Campaign Panel Title.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(campaignPanelTitle));
    }

    /**
     * Verify the components of the campaign.
     * @return boolean.
     */
    @Override
    public boolean verifyComponentsCampaign(final Campaign campaign) {
        clickDetailsTab();
        return DriverMethods.searchForExistentElement(By.xpath(nameCampaign.replace(
                "element", campaign.getName())));
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
        wait.until(ExpectedConditions.visibilityOf(messageConfirmation));
        return messageConfirmation.getText();
    }

    /**
     * Click to detailsTab.
     */
    private void clickDetailsTab() {
        WebElement detailTab = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@title='Details' ]//span[@class='title']")));
        detailTab.click();
    }

    /**
     * Delete campaign.
     * @param nameCampaign string
     * @return CampaignLightPage.
     */
    @Override
    public CampaignPageAbstract deleteCampaign(final String nameCampaign) {
        mainMenuCmb.click();
        WebElement deleteMainMenuCmb = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[starts-with(@class,'branding-actions ')]//child::li[3]//a")));
        deleteMainMenuCmb.click();
        wait.until(ExpectedConditions.visibilityOf(deletePopupBtn));
        deletePopupBtn.click();
        return new CampaignLightPage();
    }

    /**
     * Open the Edit Popup doing click in the menu.
     * @return EditCampaignAbstract could be Light o Classic.
     */
    @Override
    public EditCampaignAbstract openEditCampaign() {
        wait.until(ExpectedConditions.visibilityOf(mainMenuCmb));
        mainMenuCmb.click();
        WebElement editMainMenuCmb = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[starts-with(@class,'branding-actions ')]//child::li[2]//a")));
        editMainMenuCmb.click();
        return new EditCampaignLightPopup();
    }

    /**
     * Check if the values of Campaign is correct in the list.
     * @param key String.
     * @param value Value.
     * @return Boolean
     */
    public boolean isCampaignFieldValueDisplayed(final String key, final String value) {
        if (key.equals("Name")) {
            clickDetailsTab();
        }
        if (key.equals("Active")) {
            String values = value.equals("true") ? "True" : "False";
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
     * @return CampaignPageAbstract.
     */
    @Override
    public CampaignPageAbstract openCampaignPage() {
        closeMessageConfirmation.click();
        WebElement campaignTabBar = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//one-app-nav-bar-item-root[@data-id='Campaign']")));
        campaignTabBar.click();
        return new CampaignLightPage();
    }
}
