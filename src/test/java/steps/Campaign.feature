@smoke
Feature: Create, delete, update campaigns of Salesforce
  Background:
    Given I am logged in with Username and Password into the Salesforce

  @deleteCampaign
  Scenario: Create a new Campaign in Salesforce
    And I navigate to Campaign Form
    When I create a new campaign "New Campaign" in Salesforce
    Then I should see a message confirmation of a new campaign was created
    And I should see the page of campaign that was created
    When I navigate to Campaign Form
    Then I verify "New Campaign" is in the list of campaigns

  @deleteCampaign
  Scenario: Delete a new Campaign in Salesforce
    Given I create a new campaign "New Campaign" in Salesforce
    And I navigate to Campaign Form
    When I delete a campaign "Delete Campaign" in Salesforce
    Then I should see a message confirmation of the campaign was deleted
    And I verify "Delete Campaign" is not in the list of campaigns

  @deleteCampaign
  Scenario: Update a new Campaign in Salesforce
    Given I create a new campaign "New Campaign" in Salesforce
    And I navigate to Campaign Form
    When I update the campaign name "New Campaign" to "Update Campaign" in Salesforce
    Then I should see a message confirmation of the campaign was saved
    And I verify "Update Campaign" is in the list of campaigns

  @deleteCampaign
  Scenario: Search a new Campaign in Salesforce
    Given I create a new campaign "New Campaign" in Salesforce
    And I navigate to Campaign Form
    When I search the campaign name "Created Campaign" in the Search field of Campaign form
    Then I verify "Created Campaign" is founded in the list of campaigns