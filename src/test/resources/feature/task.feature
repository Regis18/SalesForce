@task
Feature: Create, delete, update tasks of Salesforce

  Background:
    Given I log in to the Salesforce Application
    Given I navigate to HomePage

  @deleteTask @deleteAllTask
  Scenario: Create a new Task
    When I create a new Task with this values
      | Subject  | callTask_random |
      | Comment  | test task       |
      | DueDate  | 5/30/2019       |
      | Priority | High            |
      | Status   | In Progress     |
    Then I verify a message that confirms the new Task was created is displayed
    When I navigate to Tasks Homepage
    Then I verify the Task is displayed
    Then I verify the page of Task that was created

  @createTask
  Scenario: Delete Task when it has any Task.
    Given I navigate to Tasks Homepage
    When I delete the created Task
    Then I verify the Task was deleted

  @createTask @deleteTask
  Scenario: update task
    Given I navigate to Tasks Homepage
    When I update the subject Task
    Then I navigate to Tasks Homepage
    Then I verify the Task is displayed
    Then I verify the page of Task that was created

