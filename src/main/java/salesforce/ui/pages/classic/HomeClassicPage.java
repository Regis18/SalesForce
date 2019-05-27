/*
 * @(#) HomeLightPage.java Copyright (c) 2019 Jala Foundation.
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
import salesforce.ui.pages.abstracts.HomePageAbstract;
import salesforce.ui.pages.abstracts.task.NewTaskAbstract;
import salesforce.ui.pages.classic.campaign.CampaignClassicPage;
import salesforce.ui.pages.classic.task.NewTaskClassic;

/**
 * HomeLightPage.
 * @author Regis Humana
 */
public class HomeClassicPage extends HomePageAbstract {

    /**
     * Is the main table of Home.
     */
    @FindBy(css = "table[id=\"bodyTable\"]")
    private WebElement homeTable;

    /**
     * Campaign tab.
     */
    @FindBy(id = "Campaign_Tab")
    private WebElement campaignTab;

    /**
     * Wait for homeTable is ready.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(homeTable));
    }

    /**
     * Click to Campaign and initialize CampaignClassicPage.
     * @return CampaignClassicPage.
     */
    public CampaignClassicPage clickCampaignBtn() {
        campaignTab.click();
        return new CampaignClassicPage();
    }

    @Override
    public NewTaskAbstract displayCreateTask() {
        return  new NewTaskClassic();
    }
}
