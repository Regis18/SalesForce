Feature: Create, delete, update tasks of SalesForce

  Scenario: Create a new task
    Given I log in to the SalesForce Application
    When I navigate to home page
    When I create a new task in SalesForce
    When I navigate to Lightning Tasks home page
    Then I verify the task is displayed

  Scenario: Delete task
    Given I log in to the SalesForce Application
    When I navigate to home page
    When I create a new task in SalesForce
    When I navigate to Lightning Tasks home page
    When I delete the task
    Then I verify the task was deleted

  Scenario: update task
    Given I log in to the SalesForce Application
    When I navigate to home page
    When I create a new task in SalesForce
    When I navigate to Lightning Tasks home page
    When I update the subject task
#    When I navigate to Lightning Tasks home page
    Then I verify the task is displayed

#  Scenario: Search  task
#    Given I log in to the SalesForce Application
#    When I navigate to home page
#    When I create a new task in SalesForce
#    When I navigate to Lightning Tasks home page
#    When I search the subject task
#    Then I verify the task was founded
