Feature: Create, delete, update tasks of SalesForce

  Background:
    Given I log in to the SalesForce Application
    Given I navigate to SalesForce HomePage

  @deleteTask
  Scenario: Create a new task
    When I create a new task with this information
      | Subject  | callTask_random |
      | Comment  | test task       |
      | DueDate  | 5/30/2019       |
      | Priority | High            |
      | Status   | In Progress     |
    Then I verify a message that confirms the new Task was created is displayed
    When I navigate to Tasks Homepage
    Then I verify the task is displayed
   # Then I logout of the SalesForce Application

  @createTask
  Scenario: Delete task when it has any task.
    Given I navigate to Tasks Homepage
    When I delete the created task
    Then I verify the task was deleted
    #Then I logout of the SalesForce Application

  @createTask @deleteTask
  Scenario: update task
    Given I navigate to Tasks Homepage
    When I update the subject task
    Then I navigate to Tasks Homepage
    Then I verify the task is displayed
#    Then I logout of the SalesForce Application

