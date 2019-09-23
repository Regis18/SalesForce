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
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import salesforce.api.AccountApi;
import salesforce.entities.Account;
import salesforce.entities.Context;
import salesforce.ui.pages.home.HomePageAbstract;
import salesforce.ui.pages.account.abstracts.AccountPageAbstract;
import salesforce.ui.pages.account.abstracts.EditAccountAbstract;
import salesforce.ui.pages.account.abstracts.NewAccountPageAbstract;
import salesforce.ui.pages.account.abstracts.OneAccountAbstract;
import salesforce.ui.pages.account.light.OneAccountLightPage;
import salesforce.utils.EntityId;
import java.util.Map;

import static org.testng.Assert.*;
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
    private EditAccountAbstract newEditAccount;
    private Context context;
    private Account account;
    private EntityId entitiesId;
    private Account newAccount;
    private Map<String, String> dataInformation;
    AccountApi accountApi;

    /**
     * Account steps.
     * @param context string
     */
    public AccountSteps(Context context) {
        this.context = context;
        this.account = context.getAccount();
        this.entitiesId = new EntityId();
        this.accountApi = new AccountApi();
    }

    /**
     * Navigate to Account Page.
     */
    @Given("^I have an Account with the following values$")
    public void createAccountByAPi(Map<String, String> accountInformation) {
        account.setAccountInformation( accountInformation);
        accountApi.createAccount(account);
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
        dataInformation = accountInformation;
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
     * Verify a message confirmation.
     */
    @When("^I verify a message that confirms the new Account was deleted is displayed$")
    public void verifyAMessageConfirmationOfANewAccountWasDeleted() {
        try {
            Thread.sleep(1000);
            String message = ((OneAccountLightPage)oneAccountPage).getMessageConfirmation();
            assertEquals(message, "Account \"" + account.getName() + "\" was deleted.");
        } catch (ClassCastException e) {
            System.out.println("In Classic Skin there is no message confirmation");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verify a message confirmation.
     */
    @When("^I verify a message that confirms the new Account was saved is displayed$")
    public void verifyAMessageConfirmationOfANewAccountWasSaved() {
        try {
            Thread.sleep(1000);
            String message = ((OneAccountLightPage)oneAccountPage).getMessageConfirmation();
            assertEquals(message, "Account \"" + account.getName() + "\" was saved.");
        } catch (ClassCastException e) {
            System.out.println("In Classic Skin there is no message confirmation");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verify account.
     */
    @And("^I verify the page of Account that was created$")
    public void verifyThePageOfAccountThatWasCreated() {
        String titleAccount = oneAccountPage.getNameAccount();
        assertEquals(titleAccount, account.getName());
    }

    /**
     * Open the tab Details.
     */
    @When("^I open the Account details page from Account Page$")
    public void displayPageOfAccountDetails() {
        assertTrue(oneAccountPage.isDisplayedDetailsPage());
    }

    /**
     * Verify the values of a Account.
     */
    @Then("^I verify the Account values are displayed in Account details page$")
    public void verifyDataOfAccountInDetails() {
        assertEquals(account.createMapAccount(dataInformation), oneAccountPage.createHasMapAccount(dataInformation));
    }

    /**
     * Get the Id of an Account by API.
     */
    @When("^I perform a get request for the Account by API$")
    public void getIdOfAccountByApi() {
        newAccount = AccountApi.getAccount(account.getId());
    }

    /**
     * Verify account to the list.
     */
    @Then("^I verify the Account response contains the Account value$")
    public void verifyAccountOfApi() {
        Assert.assertEquals(newAccount.getName(), account.getName());
    }

    /**
     * Verify an Account to the list of Accounts.
     */
    @Then("^I verify the Account is in the accounts list in Accounts page$")
    public void verifyIsInTheListOfAccounts() {
        assertTrue(accountPage.checkAccountList(account.getName()));
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
     * Delete an Account.
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

    /**
     * Search an Account is the list of Accounts.
     */
    @When("^I search the Account in the list of Accounts$")
    public void searchAnAccountInAccountPage() {
        oneAccountPage = accountPage.selectAccount(account.getId());
    }

    /**
     * Update the values of an Account.
     */
    @When("^I update the Account with the following values$")
    public void updateAnAccountInSalesforce(Map<String, String> accountInformation) {
        newEditAccount = oneAccountPage.editAccount();
        oneAccountPage = newEditAccount.createNewAccount(account, accountInformation);
        account.setAccountInformation(accountInformation);
    }
}
