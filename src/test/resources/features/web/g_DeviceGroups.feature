@web
Feature: Device groups management feature
  As a system administrator, I want to manage device groups in the system (view, create, edit, delete, and search),
  so that I can maintain accurate group data and ensure proper organization and access control within the system.

  @a_groups
  Scenario: Verify that user can view groups of the system
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Groups section
    Then the Groups page should be displayed
    And the system should display a list of groups or show the message "No Groups"

  @b_groups
  Scenario: Verify that user can add groups to the system, ensuring that information can be stored in the database
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Groups section
    And the user clicks on the Add Group button
    Then the Add Group page should be displayed
    When the user enters a group name
    And the user selects a group color
    And the user saves the group
    Then the group should appear on the Groups interface
    And the group should be saved in the database

  @c_groups
  Scenario:  Verify that a user can add more groups
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Groups section
    And the user clicks on the Add Group button
    And the user creates a second group
    And the user creates a third group
    And the user creates a fourth group
    And the user creates a fifth group
    And the user creates a sixth group

  @d_groups
  Scenario: Verify that user can edit groups, ensuring that information can be updated on the backend
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Groups section
    Then the pencil (edit) icon should be visible for each group
    When the user edits the group information
    And the user saves the changes
    Then the updated group information should be visible on the frontend
    And the updated group information should be persisted in the backend

  @e_groups
  Scenario: Verify that a group can be searched using their ID and name
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Groups section
    When the user enters the group name or group ID in the search bar
    Then the group matching the entered name or ID should appear in the results list

#    There is an issue with this script..look at it
  @f_groups
  Scenario: Validate user can select and delete multiple groups
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Groups section
    And the user clicks on the bin icon next to a group
    And the user deletes a single group
    And the user selects multiple groups by clicking on their checkboxes
    And the user clicks on the Delete Groups button
    Then the selected groups should no longer be visible in the list