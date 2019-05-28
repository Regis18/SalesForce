@smoke
Feature: Create, read, update and delete a Account
  Background:
    Given I log in to the SalesForce Application
    And I navigate to HomePage

  @deleteAccount
  Scenario: Create a new Account in SalesForce
    When I open the Account Page
    And I create a new Account from Accounts Page with the following values
      |  Name      | New Account 10 |
    Then I verify a message that confirms the new Account was created is displayed
    And I verify the page of account that was created
    #When I open Accounts Page from Accounts Page
    Then I verify the Account "New Account 10" in the Accounts list in Accounts Page


  @deleteAccount
  Scenario: Create a new account in SalesForce
    When I open the Account Page
    And I create a new Account from Accounts Page with the following values
      | Name         |  New Account 4   |
      | Phone        |  71717379     |
      | Fax          |  123456789    |
      | Number       |  12345667     |
      | Website      |  new web Site |
      | Site         |  new site     |
      | Ticker       |  ticker       |
      | Employee     |  employee     |
      | Revenue      |  revenue      |
      | Sic Code     |  sic code     |
      | Bill Street  |  bill street  |
      | Shipp Street |  shipp street |
      | Bill City    |  bill city    |
      | Bill State   |  bill state   |
    Then I verify a message that confirms the new Account was created is displayed
    And I verify the page of account that was created
    When I open Accounts page from Accounts page
    Then I verify the Account "New Account 4" in the accounts list in Accounts page