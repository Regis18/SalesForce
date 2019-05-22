/*
 * @(#) CampaignSteps.java Copyright (c) 2019 Jala Foundation.
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

package steps;

import cucumber.api.java.en.Given;
import salesforce.ui.pages.classic.CampaignPage;
import salesforce.ui.pages.classic.HomePage;

public class CampaignSteps {
    private CampaignPage campaignPage;

    @Given("^I navigate to Campaign Form$")
    public void navigateToCampaignForm() {
        HomePage homePage = new HomePage();
        campaignPage = homePage.clickCampaignTab();
    }

}
