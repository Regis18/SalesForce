Feature: Create, delete, update tasks of Salesforce
  Background:
    Given I log in to the Salesforce Application
    Given I navigate to Salesforce HomePage

  Scenario: Create a new Task
    When I create a new Task with this values
      | Subject    | callTask_random  |
      | Comment    | test task        |
      | DueDate    | tomorrow         |
      | Priority   | High             |
      | Status     | In Progress      |
    Then I verify a message that confirms the new Task was created is displayed
    And I verify the page of Task that was created
    When I navigate to Tasks Homepage
    Then I verify the Task is in the Task list in Task page
    Then I verify the Task is displayed
#    Then I logout of the Salesforce Application

#  Scenario: Delete Task when it has any Task
#    Given I create a new task with this values
#      | Subject    | callTask<random> |
#      | Comment    | test task        |
#      | DueDate    | 5/28/2019        |
#      | Priority   | Low              |
#      | Status     | Not Started      |
#    Given I navigate to Tasks Homepage
#    When I delete the Task
#    Then I verify the Task was deleted
#    Then I logout of the Salesforce Application
#
#  Scenario: update Task
#    Given I create a new Task with this value
#      | Subject    | callTask<random> |
#      | Comment    | test task        |
#      | DueDate    | 5/28/2019        |
#      | Priority   | High             |
#      | Status     | In Progress      |
#    Given I navigate to Tasks Homepage
#    When I update the subject Task
#    Then I navigate to Tasks Homepage
#    Then I verify the Task is displayed
#    Then I logout of the Salesforce Application

