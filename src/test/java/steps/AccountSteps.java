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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import salesforce.entities.Account;
import salesforce.ui.pages.TransporterPage;
import salesforce.ui.pages.abstracts.Account.AccountPageAbstract;
import salesforce.ui.pages.abstracts.Account.HomeAccountPageAbstract;
import salesforce.ui.pages.abstracts.Account.NewAccountPageAbstract;
import salesforce.ui.pages.abstracts.Account.OneAccountAbstract;
import salesforce.ui.pages.lightning.Account.OneAccountLightPage;

import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * AccountSteps.
 * @author Luis Guardia.
 */
public class AccountSteps {

    AccountPageAbstract accountPage;
    HomeAccountPageAbstract homeAccountPage;
    NewAccountPageAbstract newAccountPage;
    OneAccountAbstract oneAccountPage;
    TransporterPage transporterPage = TransporterPage.getInstance();
    Account account;

    @Given("^I navigate to Home Page$")
    public void navigateToAccountHomePage() {
        homeAccountPage = transporterPage.navigateToAccountHomePage();
    }

    @Given("^I navigate to account page$")
    public void goAccountPage() {
        accountPage = homeAccountPage.clickAccountBtn();
    }

    @When("^I create a new account in Salesforce with the following value")
    public void createNewAccount(Map<String, String> accountInformation) throws InterruptedException {
        account = new Account();
        account.setInformation(accountInformation);
        String nameAccount = account.getName();
        newAccountPage = accountPage.clickNewAccountBtn();
        oneAccountPage = newAccountPage.createNewAccount(nameAccount);
    }

    @Then("^I verify a message confirmation of a new account was created$")
    public void verifyAMessageConfirmationOfANewAccountWasCreated() {
        try {
            String message = ((OneAccountLightPage)oneAccountPage).getMessageConfirmation();
            assertEquals(message, "Account \"" + account.getName() + "\" was created.");
        } catch (ClassCastException e) {
            System.out.println("In Classic Skin there is no message confirmation");
        }

    }
/*
    @And("^I verify the page of account that was created$")
    public void goListAccountPage() throws InterruptedException {
        Thread.sleep(5000);
        listAccountPage = pageTransporter.navigateToListAccountPage(urlListAccounts);
        Thread.sleep(5000);
    }

    @Then("^I verify new account is in the list of accounts$")
    public void verifyNewAccount() {
        System.out.println("");
        //accountPage = pageTransporter.navigateToAccountPage(urlAccount);
    }*/
}
