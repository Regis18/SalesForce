/*
 * @(#) PageFactory.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui;

import salesforce.ui.pages.abstracts.campaign.CampaignPageAbstract;
import salesforce.ui.pages.abstracts.HomePageAbstract;
import salesforce.ui.pages.abstracts.campaign.OneCampaignAbstract;
import salesforce.ui.pages.classic.campaign.CampaignClassicPage;
import salesforce.ui.pages.classic.HomeClassicPage;
import salesforce.ui.pages.classic.campaign.OneCampaignClassicPage;
import salesforce.ui.pages.lightning.campaign.CampaignLightPage;
import salesforce.ui.pages.lightning.HomeLightPage;
import salesforce.ui.pages.lightning.campaign.OneCampaignLightPage;
import salesforce.utils.Setup;

/**
 * PageFactory.
 * @author Regis Humana
 */
public final class PageFactory {

    private static Setup setup = Setup.getInstance();

    /**
     * Get the Page Object that is correct.
     * @return HomePageAbstract.
     */
    public static HomePageAbstract homePage() {
        switch (setup.getLayout()) {
            case "classic":
                return new HomeClassicPage();
            case "light":
                return new HomeLightPage();
            default:
                return null;
        }
    }

    /**
     * Get the Page Object that is correct.
     * @return CampaignPageAbstract.
     */
    public static CampaignPageAbstract campaignPage() {
        switch (setup.getLayout()) {
            case "classic":
                return new CampaignClassicPage();
            case "light":
                return new CampaignLightPage();
            default:
                return null;
        }
    }

    /**
     * Get the Page Object that is correct.
     * @return OneCampaignAbstract.
     */
    public static OneCampaignAbstract oneCampaignPage() {
        switch (setup.getLayout()) {
            case "classic":
                return new OneCampaignClassicPage();
            case "light":
                return new OneCampaignLightPage();
            default:
                return null;
        }
    }
}
