@web
Feature: User management feature
  As an administrator of BlastWeb, I want to create, retrieve, edit, and delete users so that I can manage each user's
  access and roles effectively

  @a_userManagement
  Scenario: Verify that users can be viewed without any retrieval issues
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    Then the user navigates to the Settings page
    And go to users
    Then verify that the system users can be seen
    And also on the database

  @b_userManagement
  Scenario: Verify that a new user can be added to the system, ensuring that the information can be written back to the
  backend
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    Then the user navigates to the Settings page
    And go to users
    Then clicks on the Add User button
    And verify that the User form page is open
    And set the username
    And set the email
    And set the name of the user
    And set the surname of the user
    Then set a role for the user
    And clicks the Add User button
    Then lastly verify that the user has been added and appears as the last item of the user view page

   @c_userManagement
  Scenario: Verify that you can add five additional users
     Given the user has entered valid BlastWeb login credentials
     When the user opens the navigation menu by clicking the current system user's name
     Then the user navigates to the Settings page
     And go to users
     Then clicks on the Add User button
     And the user adds a third user
     And the user adds a fourth user
     And the user adds a fifth user
     And the user adds a sixth user
     And the user adds a seventh user
     And the user adds an eight user who is a blast operator

  @d_userManagement
  Scenario: Verify that an existing user's data can be edited, ensuring that information can be updated on the backend
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    Then the user navigates to the Settings page
    And go to users
    Then click on the pencil icon
    And edit any information about the user
    And apply the new changes by clicking the 'Save' button
    Then I verify that the user information has been updated

  @e_userManagement
  Scenario: Verify that users can be deleted, ensuring that information can be deleted on the backend
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    Then the user navigates to the Settings page
    And go to users
    Then user click on the trash bin icon
    And confirm to delete the user
    Then lastly verify that the user has been deleted on the user interface

  @f_userManagement
  Scenario: Verify that multiple users can be deleted, ensuring that information can be deleted on the backend
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    Then the user navigates to the Settings page
    And go to users
    And the administrator clicks on the square icon to select multiple or all users
    And the administrator clicks on the "Delete Users" button to delete selected users
    And the administrator confirms deletion of the selected users
    Then the selected users should no longer be visible in the users interface

  @g_userManagement
  Scenario: Verify that a user can reset their password
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    Then the user navigates to the Settings page
    And go to users
    And the user clicks on the shield icon next to the target user
    Then a popup prompt should appear asking the user to confirm the password reset
    When the user clicks "Yes" to confirm the password reset
    Then log out of again
    And enter the username in both username and password field once on the login screen
    And the user should be prompted to set a new password

  @h_userManagement
  Scenario: Verify that a user can be searched using their username, first name and surname
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    Then the user navigates to the Settings page
    And go to users
    When the user types the username into the search bar
    Then the user should be found in the search results
    When the user types the first name into the search bar
    Then the user should be found in the search results
    When the user types the surname into the search bar
    Then the user should be found in the search results