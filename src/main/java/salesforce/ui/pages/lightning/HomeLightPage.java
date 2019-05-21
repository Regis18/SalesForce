/*
 *  @HomeLightPage.java Copyright (c) 2019 Jala Foundation.
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
import salesforce.ui.BasePage;

/**
 * HomeLightPage.
 * @author Regis Humana
 */
public class HomeLightPage extends BasePage {
    /**
     * Main tool bar of lighting.
     */
    @FindBy(css = "div[class=\"slds-context-bar\"]")
    private WebElement lightToolBar;
    /**
     * Button for opening Campaign.
     */
    @FindBy(xpath = "//span[@class=\"slds-truncate\"] [contains(text(),\"Campaign\")]")
    private WebElement campaignBtn;

    /**
     * Wait for the element that is required.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(lightToolBar));
    }

    /**
     * Click in the campaign button.
     * @return CampaignLightPage.
     */
    public CampaignLightPage clickCampaignBtn() {
        campaignBtn.click();
        return new CampaignLightPage();
    }
}
