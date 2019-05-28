@smoke
Feature: Create, read, update and delete a Account
  Background:
    Given I log in to the SalesForce Application
    And I navigate to Home Page

  #@deleteAccount
  Scenario: Create a new account in SalesForce
    Given   I navigate to account page
    When   I create a new account in Salesforce with the following value
      |  name      | new Account 3 |
    Then   I verify a message confirmation of a new account was created
    And I verify the page of account that was created
    When I navigate to account Page
    Then I verify "New Account" is in the list of accounts


  #@deleteAccount
  Scenario: Create a new account in SalesForce
    Given   I navigate to account page
    When   I create a new account in Salesforce with the following value
      | name         |  new Account 4   |
      | phone        |  71717379     |
      | fax          |  123456789    |
      | number       |  12345667     |
      | website      |  new web Site |
      | site         |  new site     |
      | ticker       |  ticker       |
      | employee     |  employee     |
      | revenue      |  revenue      |
      | sic code     |  sic code     |
      | bill street  |  bill street  |
      | shipp street |  shipp street |
      | bill city    |  bill city    |
      | bill state   |  bill state   |
    Then   I verify a message confirmation of a new account was created
    And    I verify the page of account that was created
    When   I navigate to account Page
    Then   I verify "New Account" is in the list of accounts