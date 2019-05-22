Feature: Create, delete, update tasks of SalesForce

  Scenario: Create a new task and asigned an user
    Given I log in to the SalesForce Application
    When I navigate to home page
    When I create a new task in SalesForce
    When I navigate to Lightning Tasks home page
#    Then I verify the task is displayed
