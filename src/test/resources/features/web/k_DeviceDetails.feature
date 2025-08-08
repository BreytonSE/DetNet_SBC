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

#    TODO: Not done yet
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

#    Currently fails (no logs to display)
#  @d_deviceDetails
#  Scenario: Verify that the device details logs component loads with appropriate data.
#    Given the user is logged into BlastWeb with valid credentials
#    When the user selects a device from the device list
#    And the user navigates to the device details page
#    And the user opens the device details logs panel
#    Then the device logs panel should be visible with appropriate data

#    TODO: Last three steps needs to be completed still
  @e_deviceDetails
  Scenario: Verify that the device details logs component can request a log
    Given the user is logged into BlastWeb with valid credentials
    When the user selects a device from the device list
    And the user navigates to the device details page
    And the user opens the device details logs panel
    And the user modifies the datetime filters for logs
    And the user modifies the category filters for logs
    And the user requests a log from the device
    Then a notification should be displayed confirming the log request
    And the events page should show an entry indicating the log request

#    TODO: Must be completed
#  @f_deviceDetails
#  Scenario: Verify the the device details log generates completely and is downloadable
#    Given the user is logged into BlastWeb with valid credentials
#    When the user selects a device from the device list
#    And the user navigates to the device details page
#    And the user opens the device details logs panel
#    click the download icon in the action column

#    TODO: Must be completed
#  @g_deviceDetails
#  Scenario: Verify that the device details events components loads with appropriate data
#    Given the user is logged into BlastWeb with valid credentials
#    When the user selects a device from the device list
#    And the user navigates to the device details page
#    And the user navigates to the device details events page
#    Then the device details events should display meaningful data without errors
#    And the events should be paginated
#    And the user should be able to filter events by date