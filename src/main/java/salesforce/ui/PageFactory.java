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
import salesforce.ui.pages.home.HomePageAbstract;
import salesforce.ui.pages.campaign.abstracts.OneCampaignAbstract;
import salesforce.ui.pages.campaign.classic.CampaignClassicPage;
import salesforce.ui.pages.account.classic.AccountClassicPage;
import salesforce.ui.pages.account.classic.OneAccountClassicPage;
import salesforce.ui.pages.home.HomeClassicPage;
import salesforce.ui.pages.task.abstracts.NewTaskAbstract;
import salesforce.ui.pages.task.abstracts.TaskPageAbstract;
import salesforce.ui.pages.campaign.classic.OneCampaignClassicPage;
import salesforce.ui.pages.campaign.light.CampaignLightPage;
import salesforce.ui.pages.account.light.AccountLightPage;
import salesforce.ui.pages.account.light.OneAccountLightPage;
import salesforce.ui.pages.task.classic.NewTaskClassic;
import salesforce.ui.pages.task.classic.TaskPageClassic;
import salesforce.ui.pages.home.HomeLightPage;
import salesforce.ui.pages.campaign.light.OneCampaignLightPage;
import salesforce.ui.pages.task.lightning.NewTaskLightPopUp;
import salesforce.ui.pages.task.lightning.TaskPageLightning;
import salesforce.utils.Setup;

/**
 * PageFactory.
 * @author Regis Humana
 */
public class PageFactory {
    private static final String CLASSIC = "classic";
    private static final String LIGHT = "light";

    private static Setup setup = Setup.getInstance();

    /**
     * Get the Page Object that is correct.
     * @return HomePageAbstract.
     */
    public static HomePageAbstract getHomePage() {
        switch (setup.getLayout()) {
            case CLASSIC:
                return new HomeClassicPage();
            case LIGHT:
                return new HomeLightPage();
            default:
                return null;
        }
    }

    /**
     * Gets the Page Object that is correct.
     * @return CampaignPageAbstract.
     */
    public static CampaignPageAbstract getCampaignPage() {
        switch (setup.getLayout()) {
            case CLASSIC:
                return new CampaignClassicPage();
            case LIGHT:
                return new CampaignLightPage();
            default:
                return null;
        }
    }

    /**
     * Gets the Page Object that is correct.
     * @return OneCampaignAbstract.
     */
    public static OneCampaignAbstract getOneCampaignPage() {
        switch (setup.getLayout()) {
            case CLASSIC:
                return new OneCampaignClassicPage();
            case LIGHT:
                return new OneCampaignLightPage();
            default:
                return null;
        }
    }

    /**
     *
     * @return
     */
    public static TaskPageAbstract getTaskHomePage() {
        switch (setup.getLayout()) {
            case CLASSIC:
                return new TaskPageClassic();
            case LIGHT:
                return new TaskPageLightning();
            default:
                return null;
        }
    }

    /**
     *
     * @return
     */
    public static NewTaskAbstract getNewTaskPage() {
        switch (setup.getLayout()) {
            case CLASSIC:
                return new NewTaskClassic();
            case LIGHT:
                return new NewTaskLightPopUp();
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
            case CLASSIC:
                return new AccountClassicPage();
            case LIGHT:
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
            case CLASSIC:
                return new OneAccountClassicPage();
            case LIGHT:
                return new OneAccountLightPage();
            default:
                return null;
        }
    }
}
