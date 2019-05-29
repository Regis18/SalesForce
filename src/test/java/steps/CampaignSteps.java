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

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import salesforce.api.CampaignApi;
import salesforce.entities.Campaign;
import salesforce.entities.Context;
import salesforce.ui.pages.campaign.abstracts.EditCampaignAbstract;
import salesforce.ui.pages.campaign.abstracts.NewCampaignAbstract;
import salesforce.ui.pages.TransporterPage;
import salesforce.ui.pages.campaign.abstracts.CampaignPageAbstract;
import salesforce.ui.pages.abstracts.HomePageAbstract;
import salesforce.ui.pages.campaign.abstracts.OneCampaignAbstract;
import salesforce.ui.pages.campaign.light.OneCampaignLightPage;

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
    private EditCampaignAbstract editCampaignPage;
    private OneCampaignAbstract oneCampaignPage;
    private TransporterPage transporterPage = TransporterPage.getInstance();
    private Context context;
    private Campaign campaign;
    private CampaignApi campaignApi;
    private JsonPath jsonPath;
    private Map<String, String> mapOut;

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
    @Given("^I open the Campaigns Page$")
    public void openToCampaignForm() {
        homePage = context.getHomePage();
        campaignPage = homePage.clickCampaignBtn();
    }

    /**
     * Create new campaign.
     * @param mapOut
     */
    @When("^I create a new campaign for Campaigns$")
    public void createANewCampaign(final Map<String, String> mapOut) {
        this.mapOut = mapOut;
        campaign.processInformation(mapOut);
        newCampaignPage = campaignPage.clickNewCampaignBtn();
        oneCampaignPage = newCampaignPage.createNewCampaign(campaign, mapOut);
    }

    /**
     * Verify a message confirmation.
     */
    @Then("^I verify a confirmation message of a new campaign was created$")
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
    @Then("^I verify the Campaign name was \"([^\"]*)\" in the list of campaigns in Campaigns Page$")
    public void verifyIsInTheListOfCampaigns(String name) {
        // It is false because means that the element exist in the list.
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
     * @param name
     */
    @And("^I verify \"([^\"]*)\" is not in the list of campaigns$")
    public void verifyIsNotInTheListOfCampaigns(String name) {
        assertFalse(campaignPage.checkCampaignList(campaign.getName()));
    }

    /**
     * Update the characteristics of a campaign.
     * @param nameUpdate string
     */
    @When("^I update the Campaign \"New Campaign\" with the following values$")
    public void updateTheCampaignTheCharacteristics(final String nameUpdate, final Map<String, String> mapOut) {
        campaign.processInformation(mapOut);
        oneCampaignPage = editCampaignPage.createNewCampaign(campaign, mapOut);
        this.mapOut = mapOut;
    }

    /**
     * Open to the Edit Popup to initialize Edit Campaign.
     */
    @When("^I open the Edit Campaign Popup$")
    public void openTheEditPopupOfTheCampaign() {
        editCampaignPage = oneCampaignPage.openEditCampaign();
    }

    /**
     * Verify if a confirmation message is displayed in Light.
     */
    @Then("^I verify a confirmation message of the campaign was saved$")
    public void verifyAConfirmationMessageOfTheCampaignWasSaved() {
        try {
            String message = ((OneCampaignLightPage)oneCampaignPage).getMessageConfirmation();
            assertEquals(message, "Campaign \"" + campaign.getName() + "\" was saved.");
        } catch (ClassCastException e) {
            System.out.println("In Classic Skin there is no message confirmation");
        }
    }

    /**
     * Verify the updated
     */
    @Then("^I verify the updated values of Campaign in its own Page$")
    public void verifyTheDataUpdatedOfCampaignInItsOwnPage() {
        assertTrue(oneCampaignPage.verifyDataCampaign(campaign, mapOut));
        // Update mapOut with the values from the entity
        mapOut.forEach((key, value) -> {
            assertTrue(oneCampaignPage.isCampaignFieldValueDisplayed(key, value),
                    "The field " + key + "was not displayed. Expected value "
                            + value);
        });
    }

    @Given("^I have a Campaign with the following values$")
    public void haveACampaignWithTheFollowingValues(final Map<String, String> mapOut) {
        campaignApi = new CampaignApi();
        jsonPath = campaignApi.createCampaign(mapOut);
        campaign.setJsonValues(jsonPath);
    }

    @When("^I navigate to the Campaign Page$")
    public void navigateToTheCampaignPage() {
        oneCampaignPage = transporterPage.navigateToOneCampaign(campaign.getId());
    }
}
