@smoke
Feature: Create, read, update and delete a Account
  Background:
    Given I log in to the SalesForce Application
    And I navigate to Home Page

  @deleteAccount
  Scenario: Create a new account in SalesForce
    Given   I navigate to account page
    When   I create a new account in Salesforce with the following value
      | Account name | my new account |
    Then   I verify a message confirmation of a new account was created
    And    I verify the page of account that was created
    When   I navigate to account form
    Then   I verify new account is in the list of accounts