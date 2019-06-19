Feature: Contacts
  Background:
    Given I log in to the Salesforce Application
    And I navigate to HomePage

  Scenario: Create a new Contact with the necessary fields
    Given I open Contacts Page
    When I create a new Contact for Contacts

