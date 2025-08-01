@web
Feature: Dashboard functional integrity for BCU device management
  As a system operator or blast controller, I want to interact  with the BlastWeb dashboard to monitor, control, and
  verify the status and behavior of BCU devices, so that I can ensure accurate execution of blasting operations,
  maintain system safety, and quickly respond to errors or device conditions.

  @a_dashboard
  Scenario: Verify system alerts and event logs reflect, and clear device error conditions correctly for Blastweb 1
    Given the user has entered valid BlastWeb login credentials
    And the user is on the dashboard page
    And the user opens the alert dropdown
    When the user creates a condition that triggers the Device Not Available alert
    And the user refreshes the page after verifying the Device Not Available alert
    And the user creates a condition that triggers the Short Circuit alert
    And the user refreshes the page after verifying the Short Circuit alert
    And the user creates a condition that triggers the High Leakage alert
    And the user refreshes the page after verifying the High Leakage alert
    And the user creates a condition that triggers the High Current alert
    And the user refreshes the page after verifying the High Current alert
    And the user refreshes the page after verifying the Acknowledgement Alert alert
    And the user creates a condition that triggers the Low Battery alert
    And the user refreshes the page after verifying the Low Battery alert
    And the user creates a condition that triggers the Last Detonator Bad alert
    And the user refreshes the page after verifying the Last Detonator Bad alert
    And the user creates a condition that triggers the Last Detonator Bad Voltage alert
    And the user refreshes the page after verifying the Last Detonator Bad Voltage alert
    And the user creates a condition that triggers the Harness Break alert
    And the user refreshes the page after verifying the Harness Break alert
    And the user creates a condition that triggers the Programming Error alert
    And the user refreshes the page after verifying the Programming Error alert
    And the user creates a condition that triggers the Test Mode alert
    And the user refreshes the page after verifying the Test Mode alert
    And the user creates a condition that triggers the TX Error Preventing Blast alert
    And the user refreshes the page after verifying the TX Error Preventing Blast alert
    Then the event log should reflect the resolution of each error condition
    And the user restores the BCU condition to operate without alerts

  @b_dashboard
   Scenario: Delete dummy device from the dashboard
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Devices page
    And the user select the Dummy Device to delete
    Then the user deletes the dummy device completely from the dashboard

  @c_dashboard
  Scenario: Verify that user can set the channel offset using SBC
    Given the user sign in as Blast Central Operator
    And the user is on the dashboard page
    And the selected device is in the "Ready to Arm" state
    When the user clicks on the offset icon
    Then six channel fields should be displayed
    When the user sets the channel offset values
    And clicks the save button
    Then the offset icon should be displayed in blue and black

    @d_dashboard
  Scenario: Add the dummy device back to the dashboard that user deleted earlier
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Devices page
    And the user clicks on the Add Device button
    And the user sets the device ID of the device
    And the user sets the device location for the device
    And the user selects the device network for the device
    And the user selects the device network interface as Ethernet
    And the user selects the device type as BCU
    And the user assigns an administrator as device manager
    And the user sets the device IP address of the device
    And the user saves the new device

  @e_dashboard
  Scenario: Verify that dashboard grouping functionality works as expected
    Given the user has entered valid BlastWeb login credentials
    And the user is on the dashboard page
    Then the "Group By" dropdown should be visible
    When the user opens the Group By dropdown
    And the user selects Key as the grouping option
    And the user selects Network as the grouping option
    And the user selects State as the grouping option
    And the user selects Firmware as the grouping option
    And the user selects Custom as the grouping option
    And the user selects Selected as the grouping option
    And the user selects Alive as the grouping option
    And the user selects Type as the grouping option

  @f_dashboard
  Scenario: Verify that device selection and device de-selection is functional
    Given the user has entered valid BlastWeb login credentials
    And the user is on the dashboard page
    When the user selects a single device checkbox
    And the user de-selects the device checkbox
    And the user selects all devices
    Then all devices should be selected successfully

  @g_dashboard
  Scenario: Verify that device that are in the "Ready to Arm" state will be armed
    Given the user sign in as Blast Central Operator
    And the user is on the dashboard page
    When the user selects a device that is in the "Ready to Arm" state
    And the user opens the action panel and selects "Arm Selected"
    Then the device should be presented for arming without any errors

#    Not done yet -- Needs a NFC card reader
  @h_dashboard
  Scenario: Verify that device in "Ready to Blast" -state will be presented to be blasted
    Given the user sign in as Blast Central Operator
    And the user is on the dashboard page
    When the user selects a device that is in the Ready to Blast state
    And the user opens the action panel and selects Blast Selected
    Then the blast confirmation screen should be displayed
    And the user clicks the "Proceed to Blast" button

#    Not done yet -- A blast action is required first in order to complete this scenario
  @i_dashboard
  Scenario: Verify that you can view blast summary after blast is successfully completed
    Given the user sign in as Blast Central Operator
    And the user is on the dashboard page
    When the user opens the "Reports" tab
    Then a dropdown should open with three different report types
    When the user selects the Blast Report option
    Then the blast summary should be visible after the successful blast

  @j_dashboard
  Scenario: Delete dummy device from the dashboard again
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Devices page
    And the user select the Dummy Device to delete
    Then the user deletes the dummy device completely from the dashboard

  @k_dashboard
  Scenario: Send a device state change request to make it in a "Ready to Arm" -state
    Given the user sign in as Blast Central Operator
    And the user is on the dashboard page
    When the user views the device details
    And the device state is not already "Ready to Arm"
    And the device by firmware and sort by descending
    Then the user sends a device state change request to set it to "Ready to Arm"

  @l_dashboard
  Scenario: Verify that a device in "Ready to Arm" -state will be armed using the "Arm All Ready" option from action panel
    Given the user sign in as Blast Central Operator
    And the user is on the dashboard page
    When the user selects a device that is in the "Ready to Arm" state
    And the user opens the action panel and selects Arm All Ready
    Then the device should be successfully armed after selecting the "Arm All Ready" option

#    Not done yet
#  @m_dashboard
#  Scenario: Verify that a BCU connected to a wireless system will be armed
#    Given the user sign in as Blast Central Operator
#    And the user is on the dashboard page
#    When the user selects a device that is in the "Ready to Arm" state
#    And the user opens the action panel and selects Arm Wireless Selected
#    And the user selects the blast group associated with the blast and confirms
#    And the user clicks the re-blast checkbox
#    And the user clicks the OK button
#    Then the device should be successfully armed with a wireless channel
#    And the device state should be "Ready to Arm" if re-blast checkbox is checked, otherwise it should remain as "Blasted"

  @n_dashboard
  Scenario: Verify that the device in the "Ready to Blast" state will be presented to be blasted
    Given the user sign in as Blast Central Operator
    And the user is on the dashboard page
    And the device is in a "Ready to Arm" state
    When the user opens the action panel
    And the user selects "Blast All Ready" from the action panel
    And the user proceeds to blast
    And the user supplies the currently logged in user's password
    And the user supplies account details for another user that has rights to initiate a blast
    Then the device should transition to a blasting state

#    Another BCU (device id 1408) was added here, so a different BCU was used from here
#    BCU 502 was deleted temporary (Add back when doing a regression)
  @o_dashboard
  Scenario: Verify that a devices in "Ready to Blast" state will be presented to be blasted without using a blast card
    Given the user sign in as Blast Central Operator
    And the user is on the dashboard page
    And select device with id 1408
    And verify the device 1408 is in a "Ready to Arm" state else send an email request
    When the user opens the action panel
    And the user selects "Blast Selected" from the action panel
    And the user clicks the "Proceed to Blast" button
    And the user supplies their own password
    And the user supplies valid account credentials for another user authorized to initiate a blast
    Then the blast card prompt window should not be displayed

#   TODO: Implement the following missing scenarios
#    Acknowledgement of Disabled Channels (@p_dashboard)
#    BCU Panel Colors (@q_dashboard)
#    Highlight BCU State (@r_dashboard)

  @s_dashboard
  Scenario: Verify that the aggregated dashboard events log is functional and shows events
    Given the user has entered valid BlastWeb login credentials
    And the user is on the dashboard page
    When the user views the device details
    And the user navigates to the BCU events section
    Then the event date should be visible
    And the event time should be visible

  @t_dashboard
  Scenario: Verify that the device is in an UNKNOWN state when there is no communication between BCU and SBC
    Given the user has entered valid BlastWeb login credentials
    And the user is on the dashboard page
    Then verify that the BCU is in an "UNKNOWN" state else send a state change request via email

  @u_dashboard
  Scenario: Verify the expiration countdown window period for the 'Ready to Blast' command
    Given the user sign in as Blast Central Operator
    And the user is on the dashboard page
    And the device is in "Ready to Arm" state or a request is made for a state change
    When the user selects the wireless device to arm
    And the user opens the action panel
    And the user clicks on "Arm Wireless Selected"
    Then the device state should change to "Arming"
    And then change to "Ready to Blast"
    And the countdown window period should be displayed
    And the device state should revert to "Ready to Arm" after the window period expires