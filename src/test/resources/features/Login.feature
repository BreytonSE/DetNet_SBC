Feature: BlastWeb login feature
  As a user of BlastWeb, I want to be able to log in and out of the application,so that I can securely access my account
  and end my session when needed.

#  Valid Login
  Scenario: Verify that an authorized user can successfully log in and out of the application
    Given I enter my BlastWeb username and password
    When I click on the login button
    Then I should be on the dashboard page
    And then I log out of the application again
    And verify that I am back on the login page

#    Invalid Login
  Scenario: Verify that that user is denied access to BlastWeb if credentials are invalid
    Given I enter an invalid username and password
    When I click on 'Login'
    Then I should see an error message under the password input field
    And the 'Unauthorized' bar should be visible at the bottom right corner