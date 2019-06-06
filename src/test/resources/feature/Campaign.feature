@smoke
Feature: Create, delete, update campaigns of Salesforce
  Background:
    Given I log in to the Salesforce Application
    And I navigate to HomePage

  @deleteCampaign
  Scenario: Create a new Campaign in Salesforce
    Given I open the Campaigns Page
    When I create a new Campaign for Campaigns
    | Name              | New Campaign |
    | IsActive            | True         |
    | Type              | Webinar      |
    | Status            | Completed    |
    | StarDate         | today        |
    | EndDate          | 2 weeks      |
    | ExpectedRevenue  | 100          |
    | BudgetedCost     | 100          |
    | ActualCost       | 100          |
    | ExpectedResponse | 10           |
    | NumberSent          | 10           |
    | Description       | Good Morning |
    Then I verify a confirmation message of a new Campaign was created
    And I verify the page of Campaign that was created
    When I open the Campaigns Page
    Then I verify the Campaign name was "created" in the list of campaigns in Campaigns Page

  @deleteCampaign
  Scenario: Delete a new Campaign in Salesforce
    Given I open the Campaigns Page
    When I create a new campaign for Campaigns
    |Name             |Delete Campaign |
    When I delete a campaign "Delete Campaign" in its own Page
    Then I verify "Delete Campaign" is not in the list of campaigns

  @deleteCampaign
  Scenario: Update a new Campaign in Salesforce
    Given I have a Campaign with the following values
    | Name             | New Campaign |
    | IsActive         | true         |
    | Type             | Webinar      |
    | Status           | Completed    |
    | Star Date        | tomorrow     |
    | End Date         | 2 days       |
    | ExpectedRevenue  | 100          |
    | BudgetedCost     | 100          |
    | ActualCost       | 100          |
    | ExpectedResponse | 10           |
    | NumberSent       | 10           |
    | Description      | Good Morning |
    When I navigate to the Campaign Page
    And I open the Edit Campaign Popup
    And I update the Campaign "New Campaign" with the following values
    | Name             | Update Campaign |
    | Active           | False           |
    | Type             | Email           |
    | Status           | In Progress     |
    | Star Date        | One week        |
    | End Date         | Tomorrow        |
    | Expected Revenue | 300             |
    | Budgeted Cost    | 200             |
    | Actual Cost      | 200             |
    | Expected Response| 50              |
    | Num Sent         | 70              |
    | Description      | Good Night      |
    Then I verify a confirmation message of the Campaign was saved
    And I verify the updated values of Campaign in its own Page
    When I open the Campaigns Page
    And I verify the Campaign name was "updated" in the list of campaigns in Campaigns Page

  @deleteCampaign
  Scenario: Search a new Campaign in Salesforce
    Given I have a Campaign with the following values
    | Name             | Created Campaign |
    | IsActive         | true             |
    And I have a Campaign with the following values
    | Name             | Another Campaign |
    | IsActive         | false            |
    When I open the Campaigns Page
    And I search the campaign name "Created Campaign" in the Search field of Campaign form
    Then I verify the Campaign name was "searched" in the list of campaigns in Campaigns Page