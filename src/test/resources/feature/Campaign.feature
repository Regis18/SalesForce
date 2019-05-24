@smoke
Feature: Create, delete, update campaigns of Salesforce
  Background:
    Given I log in to the SalesForce Application
    And I navigate to HomePage

  @deleteCampaign
  Scenario: Create a new Campaign in Salesforce
    Given I navigate to Campaign Page
    When I create a new campaign for Campaigns
    |Name             |New Campaign |
    |Active           |True         |
    |Type             |Webinar      |
    |Status           |Completed    |
    |Star Date        |01/01/2019   |
    |End Date         |02/02/2019   |
    |Expected Revenue |100          |
    |Budgeted Cost    |100          |
    |Actual Cost      |100          |
    |Expected Response|10           |
    |Num Sent         |10           |
    |Description      |Good Morning |
    Then I verify a message confirmation of a new campaign was created
    And I verify the page of campaign that was created
    When I navigate to Campaign Page
    Then I verify "New Campaign" is in the list of campaigns

#  @deleteCampaign
#  Scenario: Delete a new Campaign in Salesforce
#    Given I create a new campaign "New Campaign" for Campaigns
#    And I navigate to Campaign Page
#    When I delete a campaign "Delete Campaign" in Salesforce
#    Then I verify a message confirmation of the campaign was deleted
#    And I verify "Delete Campaign" is not in the list of campaigns

#  @deleteCampaign
#  Scenario: Update a new Campaign in Salesforce
#    Given I create a new campaign "New Campaign" in Salesforce
#    And I navigate to Campaign Form
#    When I update the campaign name "New Campaign" to "Update Campaign" in Salesforce
#    Then I verify a message confirmation of the campaign was saved
#    And I verify "Update Campaign" is in the list of campaigns
#
#  @deleteCampaign
#  Scenario: Search a new Campaign in Salesforce
#    Given I create a new campaign "New Campaign" in Salesforce
#    And I navigate to Campaign Form
#    When I search the campaign name "Created Campaign" in the Search field of Campaign form
#    Then I verify "Created Campaign" is founded in the list of campaigns