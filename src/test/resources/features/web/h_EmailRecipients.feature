@web
  Feature: Email recipients feature
    As a system administrator I want to view, add, edit, delete, and search email recipients So that I can manage email
    notification targets effectively and ensure proper backend integration

  @a_emailRecipients
  Scenario: Verify that email recipients can be viewed
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Email Recipients section
    Then the user should be on the email recipients page
    And if the list is empty, the text "No Recipients Present" should be displayed

  @b_emailRecipients
  Scenario: Verify that recipients can be added to the system, ensuring that information can be written back to the backend
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Email Recipients section
    And the user clicks on the Add Recipient button
    Then the Add Recipient form should be displayed
    When the user enters the recipient email address
    And the user enters the recipient first name
    And the user enters the recipient last name
    And the user selects the recipient severity
    And the user clicks the Add Recipient button to save the entry
    Then the new recipient should appear in the recipients list as well is in the database