@Admin
Feature: Admin
  Background:
    Given I open browser
    And I navigate to the login page
    Then I login with username "Admin" and password "admin123"
    And I choose menu "Admin"

  @TC01Admin
  Scenario: Testcase Create new user
    Then I click Add button at Admin page
    When I create new user with below information
      | userRole        | ESS           |
      | employeeName    | Ranga Akunuri |
      | status          | Enabled       |
      | userName        | Huynh10       |
      | password        | H123456z      |
      | confirmPassword | H123456z      |
    Then I see message "Successfully Saved" at user page
    And  I logout account Admin
    Then I login with username "Huynh10" and password "H123456z"
    Then I should see list menu main

