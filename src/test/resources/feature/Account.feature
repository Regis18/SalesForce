@smoke
Feature: Create, read, update and delete a Account
  Background:
    Given I log in to the SalesForce Application
    And I navigate to HomePage

  @deleteAccount
  Scenario: Create a new account in SalesForce
    When I open the Account Page
    And I create a new Account from Accounts Page with the following values

      | Name             | New Account 15 |
      | Parent           | New Parent    |
      | Number           | 12345667      |
      | Site             | new site      |
      | Type             | Prospect      |
      | Industry         | Technology    |
      | Revenue          | 2500          |
      | Rating           | War          |
      | Phone            | 71717379      |
      | Fax              | 123456789     |
      | Website          | new web Site  |
      | Ticker           | ticker        |
      | Ownership        | Private        |
      | Employee         | employee      |
      | Sic Code         | 100-2540      |
      | Billing Street   | bill street   |
      | Billing City     | bill street   |
      | Billing State    | bill street   |
      | Billing Zip      | bill street   |
      | Billing Country  | bill street   |
      | Shipping Street  | shipp street  |
      | Shipping City    | shipp street  |
      | Shipping State   | shipp street  |
      | Shipping Zip     | shipp street  |
      | Shipping Country | bill street   |
      | Customer         | High          |
      | Sla Date         | 7/20/2020     |
      | Locations        | 10            |
      | Active           | Yes           |
      | Sla              | Platinum      |
      | Sla Serial       | 1425-458f     |
      | Upsell           | Maybe         |
      | Description      | Description   |

    Then I verify a message that confirms the new Account was created is displayed
    And I verify the page of account that was created
    When I open Accounts page from Accounts page
    Then I verify the Account is in the accounts list in Accounts page