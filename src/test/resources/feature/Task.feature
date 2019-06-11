@smoke
Feature: Create, delete, update tasks of Salesforce

  Background:
    Given I log in to the Salesforce Application
    Given I navigate to HomePage

  @deleteTask @deleteAllTask
  Scenario: Create a new Task with required information
    When I create a new Task with this values
      | Subject  | callTask_random |
      | Comment  | test task       |
      | DueDate  | tomorrow        |
      | Priority | High            |
      | Status   | In Progress     |
    Then I verify a message that confirms the new Task was "created" is displayed
    When I navigate to Tasks Homepage
    Then I verify the Task subject is displayed in Tasks Homepage
    When I open the Task details page from Tasks Homepage
    Then I verify the Task values are displayed in Task details page
    When I perform a get request for the Task by API
    Then I verify the task response contains the Task values

  @deleteTask @deleteAllTask @createAccountForTask @createContactForTask @deleteAccount @deleteContact
  Scenario: Create a new Task with all the fields.
    When I create a new Task with this values
      | Subject  | callTask_random        |
      | Comment  | test task              |
      | DueDate  | tomorrow               |
      | Priority | High                   |
      | Status   | In Progress            |
      | Contact  | contactForTask_random  |
      | Account  | accountForTask_random  |
    Then I verify a message that confirms the new Task was "created" is displayed
    When I navigate to Tasks Homepage
    Then I verify the Task subject is displayed in Tasks Homepage
    When I open the Task details page from Tasks Homepage
    Then I verify the Task values are displayed in Task details page
    When I perform a get request for the Task by API
    Then I verify the task response contains the Task values

  @deleteTask
  Scenario: Delete Task when it has any Task.
    Given I have a Task with this values
      | Subject  | callTask_random |
      | Comment  | test task       |
      | Priority | High            |
      | Status   | In Progress     |
    When I navigate to Tasks Homepage
    And I delete the Task
    Then I verify a message that confirms the new Task was "deleted" is displayed
    Then I verify the Task was removed from Task section

  @deleteTask
  Scenario: Edit subject task when a is has any Task.
    Given I have a Task with this values
      | Subject  | callTask_random |
      | Comment  | test task       |
      | Priority | High            |
      | Status   | In Progress     |
    Given I navigate to Tasks Homepage
    When I edit the subject Task
    Then I verify a message that confirms the new Task was "edited" is displayed
    Then I navigate to Tasks Homepage
    Then I verify the Task subject is displayed in Tasks Homepage
    When I open the Task details page from Tasks Homepage
    Then I verify the Task values are displayed in Task details page
    When I perform a get request for the Task by API
    Then I verify the task response contains the Task values

  @deleteTask
  Scenario: Update subject task when a is has any Task.
    Given I have a Task with this values
      | Subject  | callTask_random |
      | Comment  | test task       |
      | Priority | High            |
      | Status   | In Progress     |
    Given I navigate to Tasks Homepage
    When I update the subject Task
    Then I navigate to Tasks Homepage
    Then I verify the Task subject is displayed in Tasks Homepage
    When I open the Task details page from Tasks Homepage
    Then I verify the Task values are displayed in Task details page
    When I perform a get request for the Task by API
    Then I verify the task response contains the Task values

  @deleteTask @deleteAllTask
  Scenario Outline: Create a new Task with sample information
    When I create a new Task with this <Subject>, <Priority> and <Status>
    Then I verify a message that confirms the new Task was "created" is displayed
    When I navigate to Tasks Homepage
    Then I verify the Task subject is displayed in Tasks Homepage
    When I open the Task details page from Tasks Homepage
    Then I verify the Task values are displayed in Task details page
    Examples:
      | Subject           | Priority | Status                   |
      | callTask_random   | High     | In Progress              |
      | emailTask_random  | Low      | Not Started              |
      | sendLetter_random | Normal   | Waiting on someone else  |
      | sendQuote_random  | Low      | Deferred                 |
      | complete_random   | Normal   | Completed                |
