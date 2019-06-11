@funcional
Feature: Create, delete, update tasks of Salesforce

  Background:
    Given I log in to the Salesforce Application
    Given I navigate to HomePage

@deleteTask @acceptance
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

@deleteTask @lightning @acceptance
Scenario: Create a new Task with Status Completed with required information
When I create a new Task with this values
| Subject  | callTask_random |
| Comment  | test task       |
| DueDate  | tomorrow        |
| Priority | High            |
| Status   | Completed       |
Then I verify a message that confirms the new Task was "created" is displayed
When I navigate to Tasks Homepage
Then I verify the Task subject is displayed in Tasks Homepage
When I open the Task details page from Tasks Homepage
Then I verify the Task values are displayed in Task details page
When I perform a get request for the Task by API
Then I verify the task response contains the Task values
