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

  @d_deviceManagement
  Scenario: Verify that a device can be searched using the ID, Location and IP
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Devices section
    Then the device search bar should be visible
    When the user searches for a device by ID
    Then the searched device should appear by searched ID
    And the user searches for a device by location
    Then the searched device should appear by searched location
    And the user searches for a device by IP
    Then the searched device should appear by searched IP

  @e_deviceManagement
  Scenario: Verify that devices can be deleted from the device view list
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Devices section
    And the user clicks on the delete icon to delete a single device
    Then the device delete confirmation dialog should be displayed
    When the user confirms deletion of the single device
    Then the device should be removed from the list
    And the checkboxes for device selection should be visible
    When the user selects all devices using the header checkbox
    And the user deselects specific devices from the bulk delete selection
    And the user clicks the Delete Devices button
    Then the selected devices should be deleted and removed from the list