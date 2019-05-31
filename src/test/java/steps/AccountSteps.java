/*
 * @(#) AccountSteps.java Copyright (c) 2019 Jala Foundation.
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
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import salesforce.entities.Account;
import salesforce.entities.Context;
import salesforce.ui.pages.abstracts.HomePageAbstract;
import salesforce.ui.pages.account.abstracts.AccountPageAbstract;
import salesforce.ui.pages.account.abstracts.NewAccountPageAbstract;
import salesforce.ui.pages.account.abstracts.OneAccountAbstract;
import salesforce.ui.pages.account.light.OneAccountLightPage;
import salesforce.utils.EntityId;
import java.util.Map;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

/**
 * AccountSteps.
 * @author Luis Guardia.
 */
public class AccountSteps {

    private HomePageAbstract homePage;
    private AccountPageAbstract accountPage;
    private NewAccountPageAbstract newAccountPage;
    private OneAccountAbstract oneAccountPage;
    private Context context;
    private Account account;
    private EntityId entitiesId;

    /**
     * Account steps.
     * @param context string
     */
    public AccountSteps(Context context) {
        this.context = context;
        this.account = context.getAccount();
        this.entitiesId = new EntityId();
    }

    /**
     * Navigate to Account Page.
     */
    @When("^I open the Account Page$")
    public void navigateToAccountPage() {
        homePage = context.getHomePage();
        accountPage = homePage.clickAccountBtn();
    }

    /**
     * Create new account.
     * @param accountInformation
     */
    @And("^I create a new Account from Accounts Page with the following values$")
    public void createNewAccount(Map<String, String> accountInformation) {
        account.setAccountInformation(accountInformation);
        newAccountPage = accountPage.clickNewAccountBtn();
        oneAccountPage = newAccountPage.createNewAccount(account, accountInformation);
        context.getAccount().setId(entitiesId.getIdEntitie());
    }

    /**
     * Verify a message confirmation.
     */
    @When("^I verify a message that confirms the new Account was created is displayed$")
    public void verifyAMessageConfirmationOfANewAccountWasCreated() {
        try {
            String message = ((OneAccountLightPage)oneAccountPage).getMessageConfirmation();
            assertEquals(message, "Account \"" + account.getName() + "\" was created.");
        } catch (ClassCastException e) {
            System.out.println("In Classic Skin there is no message confirmation");
        }
    }

    /**
     * Verify account.
     */
    @And("^I verify the page of account that was created$")
    public void verifyThePageOfAccountThatWasCreated() {
        assertTrue(oneAccountPage.verifyComponentsAccount());
    }

    /**
     * Verify account to the list.
     */
    @Then("^I verify the Account is in the accounts list in Accounts page$")
    public void verifyIsInTheListOfAccounts() {
        assertTrue(accountPage.checkAccountList(context.getAccount().getName()));
    }

    /**
     * Navigate to Account Page.
     */
    @When("^I open Accounts page from Accounts page$")
    public void AccountPage() {
        homePage = context.getHomePage();
        accountPage = homePage.clickAccountBtn();
    }

    /**
     * Deletes Account.
     */
    @When("^I delete a Account in its own Page$")
    public void deleteAnAccountInSalesforce() {
        oneAccountPage.deleteAccount();
    }

    /**
     * Verifies account is not the list.
     */
    @And("^I verify the account is not in the list of accounts$")
    public void verifyIsNotInTheListOfAccounts() {
        assertFalse(accountPage.checkAccountList(account.getName()));
    }
}
