@PIM
Feature: Quản lý Thông tin Nhân viên

  Background:
    Given I open browser
    And I navigate to the login page
    Then I login with username "Admin" and password "admin123"
    And I choose menu "PIM"

  @TC01PIM
  Scenario: Tìm kiếm nhân viên và cập nhật thông tin cá nhân
    When I search user with below information
      | employeeName     | Sara Tencrady              |
      | employeeId       | 0103                       |
      | employmentStatus | Full-Time Permanent        |
      | sub Unit         | Human Resources            |
      | jobTitle         | Payroll Administrator      |
    Then I click icon edit at user list
    And I choose tabmenu "Personal Details"
    # When I update personal details with below information
    #  | firstName   | Sara               |
    #  | lastName    | Tencrady           |
    #  | otherId     | 12345              |
    #  | nationality  | American          |
    #Then I see message "Successfully Updated" at Personal Details page

  @TC02PIM
  Scenario: Cập nhật thông tin liên lạc của nhân viên
    When I search user with below information
      | employeeName     | Sara Tencrady              |
      | employeeId       | 0103                       |
    Then I click icon edit at user list
    And I choose tabmenu "Contact Details"
    When I update contact information with below information
      | street1 | 123 Street |
      | street2 | 456 Street |
      | city     | New York  |
      | state    | NY        |
      | zipCode  | 10001     |
      | country   | USA      |
    Then I see message "Successfully Updated" at Contact Details page
