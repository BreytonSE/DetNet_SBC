@web
  Feature: SBC and BCU communication feature
    As an administrator of BlastWeb, I want to establish communication between the SBC (Surface Blast Controller)
    and BCU (Blast Control Unit) so that blast actions can execute safely and timely.

  Scenario: Verify that a user can establish encrypted communication between SBC and BCU
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to Device Settings to add a device
    And the user clicks on the Add Device button
    And the user enters the relevant device details for BCU II and presses "Add Device"
    Then the system should verify that the device is on the same network
    And the device state should be verified