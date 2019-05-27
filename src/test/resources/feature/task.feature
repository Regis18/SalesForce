Feature: Create, delete, update tasks of SalesForce
  Background:
    Given I log in to the SalesForce Application
    Given I navigate to HomePage

  Scenario: Create a new task
    When I create a new task with this information
      | subject    | callTask<random> |
      | comment    | test task|
    When I navigate to Tasks Homepage
    Then I verify the task is displayed

  Scenario: Delete task when it has any task.
    Given I create a new task with this information
      | subject    | callTask<random> |
      | comment    | test task |
    Given I navigate to Tasks Homepage
    When I delete the task
    Then I verify the task was deleted

  Scenario: update task
    Given I create a new task with this information
      | subject    | callTask<random> |
      | comment    | test task|
    Given I navigate to Tasks Homepage
    When I update the subject task
    Then I navigate to Tasks Homepage
    Then I verify the task is displayed

