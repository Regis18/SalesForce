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

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import salesforce.entities.Campaign;
import salesforce.entities.Context;
import salesforce.ui.pages.abstracts.NewCampaignAbstract;
import salesforce.ui.pages.TransporterPage;
import salesforce.ui.pages.abstracts.CampaignPageAbstract;
import salesforce.ui.pages.abstracts.HomePageAbstract;
import salesforce.ui.pages.abstracts.OneCampaignAbstract;
import salesforce.ui.pages.lightning.OneCampaignLightPage;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CampaignSteps {
    private CampaignPageAbstract campaignPage;
    private HomePageAbstract homePage;
    private NewCampaignAbstract newCampaignPage;
    private OneCampaignAbstract oneCampaignPage;
    private TransporterPage transporterPage = TransporterPage.getInstance();
    private Context context;
    private Campaign campaign;


    public CampaignSteps(Context context) {
        this.context = context;
        this.campaign = context.getCampaign();
    }

    @Given("^I navigate to HomePage$")
    public void navigateToHomePage() {
        homePage = transporterPage.navigateToHomePage();
    }

    @Given("^I navigate to Campaign Page$")
    public void navigateToCampaignForm() {
        campaignPage = homePage.clickCampaignBtn();
    }

    @When("^I create a new campaign \"([^\"]*)\" for Campaigns$")
    public void createANewCampaign(final String name) {
        campaign.setName(name);
        newCampaignPage = campaignPage.clickNewCampaignBtn();
        oneCampaignPage = newCampaignPage.createNewCampaign(campaign);
    }

    @Then("^I verify a message confirmation of a new campaign was created$")
    public void verifyAMessageConfirmationOfANewCampaignWasCreated() {
        try {
        String message = ((OneCampaignLightPage)oneCampaignPage).getMessageConfirmation();
        assertEquals(message, "Campaign \"" + campaign.getName() + "\" was created.");
        } catch (ClassCastException e) {
            System.out.println("In Classic Skin there is no message confirmation");
        }

    }


    @Then("^I verify the page of campaign that was created$")
    public void verifyThePageOfCampaignThatWasCreated() {
        assertTrue(oneCampaignPage.verifyComponentsCampaign());
    }

    @Then("^I verify \"([^\"]*)\" is in the list of campaigns$")
    public void verifyIsInTheListOfCampaigns(String name) {
        // It is false because means that the element exist in the list.
        assertFalse(campaignPage.checkCampaignList(campaign.getName()));
    }
}
