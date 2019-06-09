Feature: Test positive and negative of create, delete, update and search campaigns of Salesforce
  Background:
    Given I log in to the Salesforce Application
    And I navigate to HomePage

  This is an example of eighty characters in campaigns name, and nothing important
  @deleteCampaign
  Scenario Outline: Create a new Campaign with extreme values in Salesforce with all fields of Campaign
    Given I open the Campaigns Page
    When I create a new Campaign for Campaigns
      | Name              | <Name> |
      | IsActive          | true         |
      | Type              | Webinar      |
      | Status            | Completed    |
      | StartDate         | today        |
      | EndDate           | 2 weeks      |
      | ExpectedRevenue   | 100          |
      | BudgetedCost      | 100          |
      | ActualCost        | 100          |
      | ExpectedResponse  | 10           |
      | NumberSent        | 10           |
      | Description       | Good Morning |
    Then I verify a confirmation message of a new Campaign was created
    And I verify the page of Campaign that was created
    And I verify the values of Campaign in its own Page
    When I open the Campaigns Page from Individual Campaign Page
    Then I verify the Campaign name was "created" in the list of campaigns in Campaigns Page
    And I verify through API if the account that was "created"

    Examples:
    | Name                                                                             |
    | This is an example of eighty characters in campaigns name, and nothing important |

  Scenario: Don't create a Campaign with empty name
    Given I open the Campaigns Page
    When I create a new Campaign for Campaigns
      | Name              |               |
    Then I verify a error message with the details of the problem
    And I verify that a message "Complete this field" in the name Campaign field