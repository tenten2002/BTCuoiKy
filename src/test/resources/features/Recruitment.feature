@Recruitment
Feature: Recruitment

  Background:
    Given I open browser
    And I navigate to the login page
    Then I login with username "Admin" and password "admin123"
    And I choose menu "Recruitment"

  @TC01Recruitment
  Scenario: Testcase Add new candidate
    Then I click Add button at Recruitment page
    When I create new candidate with below information
      | firstName   | Test       |
      | lastName    | Applicant  |
      | middleName  | A          |
      | vacancy      | Software Engineer |
      | email       | test@domain.com   |
      | phone       | 07894 456231      |
      | date        | 2024-01-11        |
    Then I see message "Successfully Saved" at Recruitment page
