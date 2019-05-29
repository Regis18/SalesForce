Feature: Create, delete, update tasks of SalesForce
  Background:
    Given I log in to the SalesForce Application
    Given I navigate to SalesForce HomePage

  Scenario: Create a new task
    When I create a new task with this information
      | Subject    | callTask<random> |
      | Comment    | test task        |
      | DueDate    | 5/27/2019        |
      | Priority   | High             |
      | Status     | In Progress      |
    When I navigate to Tasks Homepage
    Then I verify the task is displayed
    Then I logout of the SalesForce Application

  Scenario: Delete task when it has any task.
    Given I create a new task with this information
      | Subject    | callTask<random> |
      | Comment    | test task        |
      | DueDate    | 5/28/2019        |
      | Priority   | Low              |
      | Status     | Not Started      |
    Given I navigate to Tasks Homepage
    When I delete the task
    Then I verify the task was deleted
    Then I logout of the SalesForce Application

  Scenario: update task
    Given I create a new task with this information
      | Subject    | callTask<random> |
      | Comment    | test task        |
      | DueDate    | 5/28/2019        |
      | Priority   | High             |
      | Status     | In Progress      |
    Given I navigate to Tasks Homepage
    When I update the subject task
    Then I navigate to Tasks Homepage
    Then I verify the task is displayed
    Then I logout of the SalesForce Application

