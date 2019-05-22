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

package salesforce.ui.pages.lightning;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.abstracts.OneCampaignAbstract;

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

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(campaignPanelTitle));
    }

    @Override
    public boolean verifyComponentsCampaign() {
        clickDetailsTab();
        return detailsForm.isDisplayed();
    }

    @Override
    public String getNameCampaign() {
        return campaignTitleLbl.getText();
    }

    public String getMessageConfirmation() {
        return messageConfirmation.getText();
    }

    private void clickDetailsTab() {
        detailsTab.click();
    }
}
