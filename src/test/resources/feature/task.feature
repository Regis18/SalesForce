Feature: Create, delete, update tasks of SalesForce
  Background:
    Given I log in to the SalesForce Application
    When I navigate to HomePage
  Scenario: Create a new task
    When I create a new task in SalesForce
    When I navigate to Tasks Homepage
    Then I verify the task is displayed

  Scenario: Delete task
    When I create a new task in SalesForce
    When I navigate to Tasks Homepage
    When I delete the task
    Then I verify the task was deleted

  Scenario: update task
    When I create a new task in SalesForce
    When I navigate to Tasks Homepage
    When I update the subject task
    Then I verify the task is displayed

