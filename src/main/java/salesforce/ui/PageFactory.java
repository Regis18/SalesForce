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

import salesforce.ui.pages.abstracts.CampaignPageAbstract;
import salesforce.ui.pages.classic.CampaignPage;
import salesforce.ui.pages.lightning.CampaignLightPage;
import salesforce.utils.Setup;

public final class PageFactory {
    private static Setup setup = Setup.getInstance();

    public static CampaignPageAbstract campaignPage() {
        switch (setup.getLayout()) {
            case "classic":
                return new CampaignPage();
            case "light":
                return new CampaignLightPage();
            default:
                return null;
        }
    }
}
