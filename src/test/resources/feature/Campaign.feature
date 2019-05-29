@smoke
Feature: Create, delete, update campaigns of Salesforce
  Background:
    Given I log in to the SalesForce Application
    And I navigate to HomePage

#  @deleteCampaign
#  Scenario: Create a new Campaign in Salesforce
#    Given I open to Campaign Page
#    When I create a new campaign for Campaigns
#    |Name             |New Campaign |
#    |Active           |True         |
#    |Type             |Webinar      |
#    |Status           |Completed    |
#    |Star Date        |01/01/2019   |
#    |End Date         |02/02/2019   |
#    |Expected Revenue |100          |
#    |Budgeted Cost    |100          |
#    |Actual Cost      |100          |
#    |Expected Response|10           |
#    |Num Sent         |10           |
#    |Description      |Good Morning |
#    Then I verify a confirmation message of a new campaign was created
#    And I verify the page of campaign that was created
#    When I open to Campaign Page
#    Then I verify "New Campaign" is in the list of campaigns
#
#  @deleteCampaign
#  Scenario: Delete a new Campaign in Salesforce
#    Given I open to Campaign Page
#    When I create a new campaign for Campaigns
#      |Name             |Delete Campaign |
#    When I delete a campaign "Delete Campaign" in its own Page
#    Then I verify "Delete Campaign" is not in the list of campaigns

  @deleteCampaign
  Scenario: Update a new Campaign in Salesforce
    Given I open to Campaign Page
    And I create a new campaign for Campaigns
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
    When I open the Edit Popup of the Campaign
    And I update the campaign the characteristics of "New Campaign" with the following characteristics:
    |Name             |Update Campaign |
    |Active           |False           |
    |Type             |Email           |
    |Status           |In Progress     |
    |Star Date        |01/05/2019      |
    |End Date         |02/07/2019      |
    |Expected Revenue |300             |
    |Budgeted Cost    |200             |
    |Actual Cost      |200             |
    |Expected Response|50              |
    |Num Sent         |70              |
    |Description      |Good Night      |
    Then I verify a confirmation message of the campaign was saved
    And I verify the data updated of Campaign in its own Page
    When I open to Campaign Page
    And I verify "Update Campaign" is in the list of campaigns

#  @deleteCampaign
#  Scenario: Search a new Campaign in Salesforce
#    Given I create a new campaign "New Campaign" for Campaigns
#    And I navigate to Campaign Page
#    When I search the campaign name "Created Campaign" in the Search field of Campaign form
#    Then I verify "Created Campaign" is founded in the list of campaigns