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

package salesforce.ui.pages.classic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.abstracts.OneCampaignAbstract;

public class OneCampaignClassicPage extends OneCampaignAbstract {
    @FindBy
    private WebElement campaignPanelTitle;
    private WebElement campaignTitleLbl;
    private WebElement detailsTab;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(campaignPanelTitle));
    }
    @Override
    public boolean verifyComponentsCampaign() {
        return true;
    }

    @Override
    public String getNameCampaign() {
        return "n";
    }
}