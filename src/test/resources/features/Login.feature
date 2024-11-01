@Login
Feature: Login

  Background:
    Given I open browser
    And I navigate to the login page

@TC01login
  Scenario: Testcase Successful login
    When I login with username "Admin" and password "admin123"
    Then I should see list menu main


