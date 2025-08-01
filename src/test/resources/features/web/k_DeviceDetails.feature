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