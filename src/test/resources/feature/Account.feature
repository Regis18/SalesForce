@smoke
Feature: Create, read, update and delete a Account
  Background:
    Given I log in to the Salesforce Application
    And I navigate to HomePage

  @deleteAccount
  Scenario: Create a new account in Salesforce
    When I open the Account Page
    And I create a new Account from Accounts Page with the following values
      | Name             | New test create      |
    When I verify a message that confirms the new Account was created is displayed
    Then I verify the page of Account that was created
    When I open the Account details page from Account Page
    Then I verify the Account values are displayed in Account details page
    When I perform a get request for the Account by API
    Then I verify the Account response contains the Account value

  @deleteAccount
  Scenario: Create a new account in Salesforce
    When I open the Account Page
    And I create a new Account from Accounts Page with the following values
      | Name             | New test             |
      | Number           | 12345667             |
      | Site             | new site             |
      | Type             | Prospect             |
      | Industry         | Technology           |
      | Revenue          | 500                  |
      | Rating           | Warm                 |
      | Phone            | 71717379             |
      | Fax              | 123456789            |
      | Website          | http://google.com.bo |
      | Ticker           | ticker               |
      | Ownership        | Private              |
      | Employee         | 12                   |
      | Sic Code         | 100-2540             |
      | Billing Street   | 111                  |
      | Billing City     | 222                  |
      | Billing State    | 333                  |
      | Billing Zip      | 444                  |
      | Billing Country  | 555                  |
      | Shipping Street  | shipp street         |
      | Shipping City    | shipp street         |
      | Shipping State   | shipp street         |
      | Shipping Zip     | shipp street         |
      | Shipping Country | bill street          |
      | Customer         | High                 |
      | Sla Date         | 7/20/2020            |
      | Locations        | 10                   |
      | Active           | Yes                  |
      | Sla              | Platinum             |
      | Sla Serial       | 1425-458f            |
      | Upsell           | Maybe                |
      | Description      | Description          |

    When I verify a message that confirms the new Account was created is displayed
    Then I verify the page of Account that was created
    When I open the Account details page from Account Page
    Then I verify the Account values are displayed in Account details page
    When I perform a get request for the Account by API
    Then I verify the Account response contains the Account value

    Scenario: Delete an Account when it has an Account
    Given I have an Account with the following values
      | Name             | New test 100         |
    When I open the Account Page
    Then I search the Account in the list of Accounts
    When I delete a Account in its own Page
    Then I verify a message that confirms the new Account was deleted is displayed
    Then I open the Account Page

  @deleteAccount
  Scenario: update Account
    Given I have an Account with the following values
      | Name             | Update Account       |
      | Number           | 77932458             |
      | Site             | new site             |
      | Type             | Prospect             |
      | Industry         | Technology           |
      | Revenue          | 500                  |
      | Rating           | Warm                 |
      | Phone            | 71717379             |
      | Fax              | 123456789            |
      | Website          | http://google.com.bo |
      | Ticker           | ticker               |
      | Ownership        | Private              |
      | Employee         | 12                   |
      | Sic Code         | 100-2540             |
      | Billing Street   | 111                  |
      | Billing City     | 222                  |
      | Billing State    | 333                  |
      | Billing Zip      | 444                  |
      | Billing Country  | 555                  |
      | Shipping Street  | shipp street         |
      | Shipping City    | shipp street         |
      | Shipping State   | shipp street         |
      | Shipping Zip     | shipp street         |
      | Shipping Country | bill street          |
      | Customer         | High                 |
      | Sla Date         | 7/20/2020            |
      | Locations        | 10                   |
      | Active           | Yes                  |
      | Sla              | Platinum             |
      | Sla Serial       | 1425-458f            |
      | Upsell           | Maybe                |
      | Description      | Description          |
    When I open the Account Page
    Then I search the Account in the list of Accounts
    When I update the Account with the following values
      | Name             | Update Account       |
      | Number           | 12345667             |
      | Site             | new site             |
      | Type             | Prospect             |
      | Industry         | Technology           |
      | Revenue          | 500                  |
      | Rating           | Warm                 |
      | Phone            | 71717379             |
      | Fax              | 123456789            |
      | Website          | http://google.com.bo |
      | Ticker           | ticker               |
      | Ownership        | Public               |
      | Employee         | 20                   |
      | Sic Code         | 100-2540             |
      | Billing Street   | Av. Villazon         |
      | Billing City     | Cochabamba           |
      | Billing State    | Cercado              |
      | Billing Zip      | 65874                |
      | Billing Country  | Sacaba               |
      | Shipping Street  | Av. Villazon         |
      | Shipping City    | Cochabamba           |
      | Shipping State   | Cercado              |
      | Shipping Zip     | 65874                |
      | Shipping Country | Sacaba               |
      | Customer         | High                 |
      | Sla Date         | 10/20/2020           |
      | Locations        | 25                   |
      | Active           | No                   |
      | Sla              | Platinum             |
      | Sla Serial       | 1425-458f            |
      | Upsell           | Maybe                |
      | Description      | update Information   |
    Then I verify a message that confirms the new Account was saved is displayed
    Then I verify the page of Account that was created
    When I open the Account details page from Account Page
    When I perform a get request for the Account by API
    Then I verify the Account response contains the Account value