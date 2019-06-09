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

import core.selenium.WebDriverConfig;
import core.utils.Common;
import core.utils.Logs;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import salesforce.api.CampaignApi;
import salesforce.entities.Campaign;
import salesforce.entities.Context;
import salesforce.ui.pages.TransporterPage;
import salesforce.ui.pages.campaign.abstracts.CampaignPageAbstract;
import salesforce.ui.pages.campaign.abstracts.EditCampaignAbstract;
import salesforce.ui.pages.campaign.abstracts.NewCampaignAbstract;
import salesforce.ui.pages.campaign.abstracts.OneCampaignAbstract;
import salesforce.ui.pages.campaign.light.CampaignLightPage;
import salesforce.ui.pages.campaign.light.OneCampaignLightPage;
import salesforce.ui.pages.home.HomePageAbstract;
import salesforce.ui.pages.search.SearchAbstractPage;
import salesforce.utils.EntityId;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Campaign steps.
 * @author Regis Humana
 * @version 0.0.1
 */
public class CampaignSteps {
    private String skin = WebDriverConfig.getSkin();
    private CampaignPageAbstract campaignPage;
    private HomePageAbstract homePage;
    private NewCampaignAbstract newCampaignPage;
    private EditCampaignAbstract editCampaignPage;
    private OneCampaignAbstract oneCampaignPage;
    private SearchAbstractPage searchPage;
    private TransporterPage transporterPage = TransporterPage.getInstance();
    private Context context;
    private Campaign campaign;
    private CampaignApi campaignApi = new CampaignApi();;
    private JsonPath jsonPath;
    private List<Map<String, String>> mapOut = new ArrayList<>();
    private EntityId entityId;
    private List<String> ids = new ArrayList<>();
    private String element;
    private String key;

    /**
     * Campaign steps.
     * @param context string
     */
    public CampaignSteps(Context context) {
        this.context = context;
        this.campaign = context.getCampaign();
        entityId = new EntityId();
    }

    /**
     * Navigates to Campaign Page.
     */
    @Given("^I open the Campaigns Page$")
    public void openToCampaignForm() {
        homePage = context.getHomePage();
        campaignPage = homePage.clickCampaignBtn();
    }

    /**
     * Verifies a message confirmation.
     */
    @Then("^I verify a confirmation message of a new Campaign was created$")
    public void verifyAConfirmationMessageOfANewCampaignWasCreated() {
        try {
            String message = ((OneCampaignLightPage)oneCampaignPage).getMessageConfirmation();
            if (message.equals("")) {
                message = ((CampaignLightPage)campaignPage).getMessageConfirmation();
            }
            assertEquals(message, "Campaign \"" + campaign.getName() + "\" was created.");
        } catch (ClassCastException e) {
            System.out.println("In Classic Skin there is no message confirmation");
        }
    }

    /**
     * Verifies campaign.
     */
    @Then("^I verify the page of Campaign that was created$")
    public void verifyThePageOfCampaignThatWasCreated() {
        assertTrue(oneCampaignPage.verifyComponentsCampaign(campaign));
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
     * Deletes Campaign.
     * @param name string
     */
    @When("^I delete a campaign \"([^\"]*)\" in its own Page$")
    public void deleteACampaignInSalesforce(String name) {
        campaignPage = oneCampaignPage.deleteCampaign(name);
    }

    /**
     * Verifies message confirmation.
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
     * Verifies campaign is not the list.
     */
    @And("^I verify \"([^\"]*)\" is not in the list of campaigns$")
    public void verifyIsNotInTheListOfCampaigns() {
        boolean result = campaignPage.checkCampaignList(campaign.getName());
        System.out.println("DELETE: " + result);
        assertFalse(result);
    }

    /**
     * Updates the characteristics of a campaign.
     */
    @When("^I update the Campaign \"New Campaign\" with the following values$")
    public void updateTheCampaignTheCharacteristics(final Map<String, String> mapOut) {
        campaign.processInformation(mapOut);
        oneCampaignPage = editCampaignPage.createNewCampaign(campaign, mapOut);
        this.mapOut.remove(0);
        this.mapOut.add(mapOut);
    }

    /**
     * Opens to the Edit Popup to initialize Edit Campaign.
     */
    @When("^I open the Edit Campaign Popup$")
    public void openTheEditPopupOfTheCampaign() {
        editCampaignPage = oneCampaignPage.openEditCampaign();
    }

    /**
     * Verifies if a confirmation message is displayed in Light.
     */
    @Then("^I verify a confirmation message of the Campaign was saved$")
    public void verifyAConfirmationMessageOfTheCampaignWasSaved() {
        try {
            String message = ((OneCampaignLightPage)oneCampaignPage).getMessageConfirmation();
            assertEquals(message, "Campaign \"" + campaign.getName() + "\" was saved.");
        } catch (ClassCastException e) {
            System.out.println("In Classic Skin there is no message confirmation");
        }
    }

    /**
     * Verifies the updated
     */
    @Then("^I verify the values of Campaign in its own Page$")
    public void verifyTheDataOfCampaignInItsOwnPage() {
        mapOut.get(0).forEach((key, value) -> {
            if (key.equals("IsActive")) {
                key = "Active";
            } else if (key.equals("StartDate")) {
                key = "Start Date";
                value = Common.translateDate(value.toLowerCase());
            } else if (key.equals("EndDate")) {
                key = "End Date";
                value = Common.translateDate(value.toLowerCase());
            } else if (key.equals("ExpectedRevenue")) {
                key = "Expected Revenue";
            } else if (key.equals("BudgetedCost")) {
                key = "Budgeted Cost";
            } else if (key.equals("ActualCost")) {
                key = "Actual Cost";
            } else if (key.equals("ExpectedResponse")) {
                key = "Expected Response";
            } else if (key.equals("NumberSent")) {
                key = "Num Sent";
            }
            assertTrue(oneCampaignPage.isCampaignFieldValueDisplayed(key, value),
                    "The field " + key + " was not displayed. Expected value " + value);
        });
    }

    /**
     * Create a Campaign with API Testing.
     * @param mapOut mapOut.
     */
    @Given("^I have a Campaign with the following values$")
    public void haveACampaignWithTheFollowingValues(final Map<String, String> mapOut) {
        jsonPath = campaignApi.createCampaign(mapOut);
        jsonPath = campaignApi.getCampaignById(jsonPath.getString("id"));
        mapOut.forEach((key, value) -> {
            campaign.setJsonValues(key, jsonPath);
        });
        campaign.setId(jsonPath.getString("Id"));
        ids.add(campaign.getId());
        context.setIds(ids);
        this.mapOut.add(mapOut);
    }

    /**
     *Navigate to Campaign Page.
     */
    @When("^I navigate to the Campaign Page$")
    public void navigateToTheCampaignPage() {
        oneCampaignPage = transporterPage.navigateToOneCampaign(campaign.getId());
    }

    /**
     * Search the campaign in the list of the Campaigns.
     * @param nameCampaign string.
     */
    @And("^I search the Campaign name \"([^\"]*)\" in the Search field of Campaign form$")
    public void searchTheCampaignNameInTheSearchFieldOfCampaignForm(String nameCampaign) {
        if (skin.equals("light")) {
            campaignPage.searchCampaignInList(nameCampaign);
        } else {
            Logs.getInstance().getLog().info("Just for LIGHT and not Classic");
        }
    }

    /**
     * Verify the values of the campaign with API result.
     */
    @And("^I verify through API if the account that was \"([^\"]*)\"$")
    public void verifyThroughAPIIfTheAccountThatWas() {
        JsonPath jsonCampaign = campaignApi.getCampaignById(campaign.getId());
        mapOut.get(0).forEach((key, value) -> {
            String values = value;
            if (key.equals("StartDate") || key.equals("EndDate")) {
                values = Common.translateDateAPI(value.toLowerCase());
            }
            assertTrue(jsonCampaign.getString(key).contains(values),
                    "The field " + key + "was not equal. Expected value "
                            + values + " but it found: " + jsonCampaign.getString(key));
        });
    }

    /**
     * Creates new campaign.
     * @param mapOut mapOut.
     */
    @When("^I create a new Campaign for Campaigns$")
    public void createANewCampaignForCampaigns(final Map<String, String> mapOut) {
        this.mapOut.add(mapOut);
        campaign.processInformation(mapOut);
        newCampaignPage = campaignPage.clickNewCampaignBtn();
        oneCampaignPage = newCampaignPage.createNewCampaign(campaign, mapOut);
        campaign.setId(entityId.getIdEntitie());
        ids.add(campaign.getId());
        context.setIds(ids);
    }

    /**
     * Opens Campaign page from Individual Campaign Page.
     */
    @When("^I open the Campaigns Page from Individual Campaign Page$")
    public void openTheCampaignsPageFromIndividualCampaignPage() {
        campaignPage = oneCampaignPage.openCampaignPage();
    }

    /**
     * Searches element.
     * @param name string
     */
    @When("^I search \"([^\"]*)\" in the Search field$")
    public void searchInTheSearchField(String name) {
        homePage = context.getHomePage();
        searchPage = homePage.searchElement(name);
    }

    /**
     * Verifies the element is in the searches.
     * @param element string.
     * @param key string.
     */
    @Then("^I verify \"([^\"]*)\" of \"([^\"]*)\" is in the list of searches in Search Page$")
    public void verifyOfIsInTheListOfSearchesInSearchPage(final String element, final String key) {
        this.element = element;
        this.key = key;
        assertTrue(searchPage.doesElementExist(key, element));
    }

    /**
     * Open the element that was searched.
     */
    @When("^I open the element that was searched$")
    public void openTheElementThatWasSearched() {
        oneCampaignPage = searchPage.accessToElementSearched(key, element);
    }
}
