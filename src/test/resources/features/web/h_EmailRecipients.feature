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

  @c_emailRecipients
  Scenario: Verify that additional recipients can be added to the system
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Email Recipients section
    And the user clicks on the Add Recipient button
    Then the Add Recipient form should be displayed
    And the user creates a second recipient
    And the user creates a third recipient
    And the user creates a fourth recipient
    And the user creates a fifth recipient
    And the user creates a sixth recipient

  @d_emailRecipients
  Scenario: Verify that recipients can be edited, ensuring that information can be updated on the backend
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Email Recipients section
    And the user clicks the pencil icon for a recipient
    And the user edits the recipient information
    And the user clicks the save button
    And update the interval
    Then the recipient data should be updated

  @e_emailRecipients
  Scenario: Verify that recipients can be searched using their username, firstname and lastname
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Email Recipients section
    Then the search bar should be visible
    When the user enters a recipient's username into the search bar
    Then the matching recipient username should appear in the results
    When the user enters a recipient's first name into the search bar
    Then the matching recipient first name should appear in the results
    When the user enters a recipient's last name into the search bar
    Then the matching recipient last name should appear in the results

  @f_emailRecipients
  Scenario: Verify that user can delete a single recipients, as well as multiple recipients
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Email Recipients section
    And delete a single recipient
    Then verify the single recipient is deleted
    And delete multiple recipients
    Then verify that selected recipients is deleted