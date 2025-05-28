@web
Feature: Device groups management feature
  As a system administrator, I want to manage device groups in the system (view, create, edit, delete, and search),
  so that I can maintain accurate group data and ensure proper organization and access control within the system.

  Scenario: Verify that user can view groups of the system
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Groups section
    Then the Groups page should be displayed
    And the system should display a list of groups or show the message "No Groups"

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