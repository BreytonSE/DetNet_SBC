@web
Feature: Device details feature
  As a Blast Central Operator, I want to view and interact with all device-related data through the Device Details
  section, So that I can verify device status, review diagnostics, request and download logs, manage detonator data, and
  maintain comments accurately.

  @a_deviceDetails
  Scenario: Verify that the navigation to the device details screen works correctly
    Given the user has entered valid BlastWeb login credentials
    When I select a device to view the details
    Then I verify the device summary screen is open

##    TODO: Not done yet
#  @b_deviceDetails
#  Scenario: Verify that the device details page renders meaningful data
#    Given the user has entered valid BlastWeb login credentials
#    When I select a device to view the details
#    Then I verify the device summary screen is open
#    And verify that the wireless transmitter status should be visible if the BCU is connected to a wireless system
#    And the antenna on and off option should be available if the BCU is connected to a wireless system

#  TODO: Not done yet (Complete last step)
  @c_deviceDetails
  Scenario: Verify that the device details channels component loads with appropriate data
    Given the user is logged into BlastWeb with valid credentials
    When the user selects a device from the device list
    And the user navigates to the device details page
    Then the device details channels component should load successfully
    And the error panels should display the correct error types

  @d_deviceDetails
  Scenario: Verify that the device details logs component loads with appropriate data.
    Given the user is logged into BlastWeb with valid credentials
    When the user selects a device from the device list
    And the user navigates to the device details page
    And the user opens the device details logs panel
    Then the device logs panel should be visible with appropriate data

#    TODO: Fails due to 'duplicate key value violates unique constraint...' issue. Not safe to run at the moment.
#  @e_deviceDetails
#  Scenario: Verify that the device details logs component can request a log
#    Given the user is logged into BlastWeb with valid credentials
#    When the user selects a device from the device list
#    And the user navigates to the device details page
#    And the user opens the device details logs panel
#    And the user modifies the datetime filters for logs
#    And the user modifies the category filters for logs
#    And the user requests a log from the device
#    Then a notification should be displayed confirming the log request
#    And the events page should show an entry indicating the log request

  @f_deviceDetails
  Scenario: Verify the device details log generates completely and is downloadable
    Given the user is logged into BlastWeb with valid credentials
    When the user selects a device from the device list
    And the user navigates to the device details page
    And the user opens the device details logs panel
    Then click the download icon in the action column

#  @g_deviceDetails
#  Scenario: Verify that the device details events components loads with appropriate data
#    Given the user is logged into BlastWeb with valid credentials
#    When the user selects a device from the device list
#    And the user navigates to the device details page
#    And the user navigates to the device details events page
#    And filter the from dates accordingly
#    Then the device details events should display meaningful data without errors
#    And the events should be paginated
#    And the user should be able to filter events by date

  @h_deviceDetails
  Scenario: Verify that the device details comments components loads with appropriate data.
    Given the user is logged into BlastWeb with valid credentials
    When the user selects a device from the device list
    And the user navigates to the device details page
    And the the user navigates to the device details comments page
    When the user clicks the Add Comment button
    And the user enters a comment to be added to the device
    And the user saves the comment
    Then the comment should be displayed on the comments page

  @i_deviceDetails
  Scenario: Verify that device comments can be edited from the system.
    Given the user is logged into BlastWeb with valid credentials
    When the user selects a device from the device list
    And the user navigates to the device details page
    And the the user navigates to the device details comments page
    And the user clicks the pencil icon for the comment
    Then a popup prompt should be displayed for comment editing
    When the user edits the comment and clicks the "Edit Comment" button
    Then the comment should be updated successfully

  @j_deviceDetails
  Scenario: Verify that device comments can be deleted from the system
    Given the user is logged into BlastWeb with valid credentials
    When the user selects a device from the device list
    And the user navigates to the device details page
    And the the user navigates to the device details comments page
    And user click the delete icon to delete the comment
    Then a popup prompt should display for comment deletion
    When the user delete the comment by clicking the "Yes" button
    Then the comment should be deleted successfully

  @k_deviceDetails
  Scenario: Verify that the device details detonators are displayed when user request for detonators
    Given the user is logged into BlastWeb with valid credentials
    When the user selects a device from the device list
    And the user navigates to the device details page
    And the user navigates to the device details detonators page
    Then the device details detonators page should be displayed
    When the user request for detonators
    Then a list of detonators should be displayed