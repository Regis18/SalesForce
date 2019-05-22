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
import cucumber.api.java.en.When;
import salesforce.entities.Campaign;
import salesforce.entities.Context;
import salesforce.ui.behaves.NewCampaignAbstract;
import salesforce.ui.pages.TransporterPage;
import salesforce.ui.pages.abstracts.CampaignPageAbstract;
import salesforce.ui.pages.abstracts.HomePageAbstract;

public class CampaignSteps {
    private CampaignPageAbstract campaignPage;
    private HomePageAbstract homePage;
    private TransporterPage transporterPage = TransporterPage.getInstance();
    private Context context;
    private Campaign campaign;
    private NewCampaignAbstract newCampaign;

    public CampaignSteps(Context context) {
        this.context = context;
        this.campaign = context.getCampaign();
    }

    @Given("^I navigate to Campaign Form$")
    public void navigateToCampaignForm() {
        homePage = transporterPage.navigateToHomePage();
        campaignPage = homePage.clickCampaignBtn();
    }

    @When("^I create a new campaign \"([^\"]*)\" in Salesforce$")
    public void createANewCampaignInSalesforce(final String name) {
        campaign.setName(name);
        newCampaign = campaignPage.clickNewCampaignBtn();
        newCampaign.createNewCampaign(campaign);
    }
}
