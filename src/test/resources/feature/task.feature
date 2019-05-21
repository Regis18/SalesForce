Feature: Sign in in the SalesForce Application

  Scenario: Create a new task and asigned an user
    Given I sign in to the salesforce Application
    When I navigate to home page
#    When I create a new task from home page with the following values
#      | Asunto    | Task1    |
#      | Estado    | Untitled |
#      | Prioridad | Private  |
#      | Asignado A| user     |
#    Then the task should be displayed in task list

#    When I navigate to Project Dashboard page
#    Then the Dashboard page should be displayed the Project name
#    When I navigate to Projects page
#    Then the Projects page should be displayed the Project name
#    When I display the Projects panel from the top bar
#    Then the Projects panel should be displayed the Project name
#    When I navigate to Project Dashboard page
#    Then sign out of the application