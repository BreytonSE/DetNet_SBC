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
  Scenario: Verify that an existing user's data can be edited, ensuring that information can be updated on the backend
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    Then the user navigates to the Settings page
    And go to users
    Then click on the pencil icon
    And edit any information about the user
    And apply the new changes by clicking the 'Save' button
    Then I verify that the user information has been updated

  @d_userManagement
  Scenario: Verify that users can be deleted, ensuring that information can be deleted on the backend
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    Then the user navigates to the Settings page
    And go to users
    Then user click on the trash bin icon
    And confirm to delete the user
    And then verify in the database that the user has been deleted