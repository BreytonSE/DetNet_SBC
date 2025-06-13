@web
Feature: Device management feature
  As a system administrator with elevated privileges, I want to view, add, edit, delete, and search for devices in the
  system settings, so that I can effectively manage the devices to the system and ensure all device-related data is
  accurate and up to date

  @a_deviceManagement
  Scenario: Verify devices can be viewed
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Devices section
    Then the user should see all system devices listed without errors

  @b_deviceManagement
  Scenario: Verify that devices can be added to the system
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Devices section
    And the user clicks on the Add Device button
    And the user enters the device ID
    And the user enters the device location
    And the user selects the device network
    And the user selects the device network interface
    And the user selects the device type
    And the user assigns a device manager
    And the user assigns a parent device
    And the user assigns a group to the device
    And the user sets the device IP address
    And the user saves the new device
    Then the device should be visible in the list and successfully registered on the backend
    When the user adds a fourth device
    And the user adds a fifth device
    And the user adds a sixth device
    And the user adds a seventh device

  @c_deviceManagement
  Scenario: Verify that a device can be edited, ensuring that information can be updated on the backend
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Devices section
    And the user clicks on the pencil icon for a device
    Then the device edit page should be displayed
    When the user updates the group of the selected device
    Then the updated group should be reflected on the front end
    And the backend should reflect the updated device group