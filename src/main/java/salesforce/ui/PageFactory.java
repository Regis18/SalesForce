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

import salesforce.ui.pages.campaign.abstracts.CampaignPageAbstract;
import salesforce.ui.pages.account.abstracts.AccountPageAbstract;
import salesforce.ui.pages.account.abstracts.OneAccountAbstract;
import salesforce.ui.pages.abstracts.HomePageAbstract;
import salesforce.ui.pages.campaign.abstracts.OneCampaignAbstract;
import salesforce.ui.pages.campaign.classic.CampaignClassicPage;
import salesforce.ui.pages.account.classic.AccountClassicPage;
import salesforce.ui.pages.account.classic.OneAccountClassicPage;
import salesforce.ui.pages.classic.HomeClassicPage;
import salesforce.ui.pages.task.abstracts.TaskPageAbstract;
import salesforce.ui.pages.campaign.classic.OneCampaignClassicPage;
import salesforce.ui.pages.campaign.light.CampaignLightPage;
import salesforce.ui.pages.account.light.AccountLightPage;
import salesforce.ui.pages.account.light.OneAccountLightPage;
import salesforce.ui.pages.classic.task.TaskPageClassic;
import salesforce.ui.pages.task.classic.TaskPageClassic;
import salesforce.ui.pages.lightning.HomeLightPage;
import salesforce.ui.pages.campaign.light.OneCampaignLightPage;
import salesforce.ui.pages.task.lightning.TaskPageLightning;
import salesforce.utils.Setup;

/**
 * PageFactory.
 * @author Regis Humana
 */
public class PageFactory {

    private static Setup setup = Setup.getInstance();

    /**
     * Get the Page Object that is correct.
     * @return HomePageAbstract.
     */
    public static HomePageAbstract getHomePage() {
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
    public static CampaignPageAbstract getCampaignPage() {
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
    public static OneCampaignAbstract getOneCampaignPage() {
        switch (setup.getLayout()) {
            case "classic":
                return new OneCampaignClassicPage();
            case "light":
                return new OneCampaignLightPage();
            default:
                return null;
        }
    }

    public static TaskPageAbstract getTaskHomePage() {
        switch (setup.getLayout()) {
            case "classic":
                return new TaskPageClassic();
            case "light":
                return new TaskPageLightning();
            default:
                return null;
        }
    }

    /**
     * Get the Page Object that is correct.
     * @return AccountPageAbstract.
     */
    public static AccountPageAbstract getAccountPage() {
        switch (setup.getLayout()) {
            case "classic":
                return new AccountClassicPage();
            case "light":
                return new AccountLightPage();
            default:
                return null;
        }
    }

    /**
     * Get the Page Object that is correct.
     * @return OneAccountAbstract.
     */
    public static OneAccountAbstract getOneAccountPage() {
        switch (setup.getLayout()) {
            case "classic":
                return new OneAccountClassicPage();
            case "light":
                return new OneAccountLightPage();
            default:
                return null;
        }
    }
}
