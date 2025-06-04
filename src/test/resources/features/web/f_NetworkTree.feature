@web
Feature: View network tree feature
  As an administrator of the BlastWeb SBC, I want to view the full network tree of the system and navigate to specific
  networks or devices, so that I can verify the structure and access the details of each network and device for review
  or editing

  @a_networkTree
  Scenario: Verify that the network tree of the system can be viewed and allows navigation to specific devices on an
  selected network.
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    When the user opens the network tree
    Then the user verifies url of the network tree page
    And the user verifies that the network tree page is open
    Then the user selects a device to view the dropdown list of sub-devices or navigates to the selected device's details page
    And verify that the user is on device details page