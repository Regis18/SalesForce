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
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import salesforce.entities.Campaign;
import salesforce.entities.Context;
import salesforce.ui.pages.abstracts.campaign.NewCampaignAbstract;
import salesforce.ui.pages.TransporterPage;
import salesforce.ui.pages.abstracts.campaign.CampaignPageAbstract;
import salesforce.ui.pages.abstracts.HomePageAbstract;
import salesforce.ui.pages.abstracts.campaign.OneCampaignAbstract;
import salesforce.ui.pages.lightning.campaign.OneCampaignLightPage;

import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Campaign steps
 * @author Regis Humana
 * @version 0.0.1
 */
public class CampaignSteps {
    private CampaignPageAbstract campaignPage;
    private HomePageAbstract homePage;
    private NewCampaignAbstract newCampaignPage;
    private OneCampaignAbstract oneCampaignPage;
    private TransporterPage transporterPage = TransporterPage.getInstance();
    private Context context;
    private Campaign campaign;

    /**
     * Campaign steps.
     * @param context string
     */
    public CampaignSteps(Context context) {
        this.context = context;
        this.campaign = context.getCampaign();
    }

    /**
     * Navigate to Campaign Page.
     */
    @Given("^I navigate to Campaign Page$")
    public void navigateToCampaignForm() {
        homePage = context.getHomePage();
        campaignPage = homePage.clickCampaignBtn();
    }

    /**
     * Create new campaign.
     * @param mapOut
     */
    @When("^I create a new campaign for Campaigns$")
    public void createANewCampaign(final Map<String, String> mapOut) {
        campaign.processInformation(mapOut);
        newCampaignPage = campaignPage.clickNewCampaignBtn();
        oneCampaignPage = newCampaignPage.createNewCampaign(campaign, mapOut);
    }

    /**
     * Verify a message confirmation.
     */
    @Then("^I verify a message confirmation of a new campaign was created$")
    public void verifyAMessageConfirmationOfANewCampaignWasCreated() {
        try {
            String message = ((OneCampaignLightPage)oneCampaignPage).getMessageConfirmation();
            assertEquals(message, "Campaign \"" + campaign.getName() + "\" was created.");
        } catch (ClassCastException e) {
            System.out.println("In Classic Skin there is no message confirmation");
        }
    }

    /**
     * Verify campaign.
     */
    @Then("^I verify the page of campaign that was created$")
    public void verifyThePageOfCampaignThatWasCreated() {
        assertTrue(oneCampaignPage.verifyComponentsCampaign());
    }

    /**
     * Verify campaign to the list.
     * @param name string.
     */
    @Then("^I verify \"([^\"]*)\" is in the list of campaigns$")
    public void verifyIsInTheListOfCampaigns(String name) {
        // It is true because means that the element exist in the list.
        assertTrue(campaignPage.checkCampaignList(campaign.getName()));
    }

    /**
     * Delete Campaign.
     * @param name string
     */
    @When("^I delete a campaign \"([^\"]*)\" in its own Page$")
    public void deleteACampaignInSalesforce(String name) {
        oneCampaignPage.deleteCampaign(name);
    }

    /**
     * Verify message confirmation.
     */
    @Then("^I verify a message confirmation of the campaign was deleted$")
    public void verifyAMessageConfirmationOfTheCampaignWasDeleted() {
        try {
            String message = ((OneCampaignLightPage)oneCampaignPage).getMessageConfirmation();
            assertEquals(message, "Campaign \"" + campaign.getName() + "\" was deleted.");
        } catch (ClassCastException e) {
            System.out.println("In Classic Skin there is no message confirmation");
        }
    }

    /**
     * Verify campaign is not the list.
     * @param name string.
     */
    @And("^I verify \"([^\"]*)\" is not in the list of campaigns$")
    public void verifyIsNotInTheListOfCampaigns(String name) {
        assertFalse(campaignPage.checkCampaignList(campaign.getName()));
    }

    /**
     * Delete from campaigns list.
     * @param name string.
     */
    @When("^I delete a campaign \"([^\"]*)\" from Campaigns Page$")
    public void deleteACampaignFromCampaignsPage(String name) {
        campaignPage.deleteCampaign("put Id");
    }
}
