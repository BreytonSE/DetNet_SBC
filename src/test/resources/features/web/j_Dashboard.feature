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
    And the user creates a condition that triggers the Acknowledgement Alert alert
    And the user refreshes the page after verifying the Acknowledgement Alert alert
    And the user creates a condition that triggers the Low Battery alert
    And the user refreshes the page after verifying the Low Battery alert
    And the user creates a condition that triggers the Last Detonator Bad alert
    And the user refreshes the page after verifying the Last Detonator Bad alert
    And the user creates a condition that triggers the Last Detonator Bad Voltage alert
    And the user refreshes the page after verifying the Last Detonator Bad Voltage alert
    And the user creates a condition that triggers the Blast Voltage Bad alert
    And the user refreshes the page after verifying the Blast Voltage Bad alert
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

#  @b_dashboard
#  Scenario: Verify system alerts and event logs reflect, and clear device error conditions correctly for Blastweb 2
#    Given the user has entered valid BlastWeb login credentials
#    And the user is on the dashboard page
#    When the user creates the condition for each error type for Blastweb II
#    Then the corresponding error should be displayed in the system alert dropdown
#    And a corresponding event should be logged in the event log for the affected BCU
#    When the user removes the condition for each error type
#    Then the corresponding error should be cleared from the system alert dropdown
#    And the event log should reflect the resolution of the error condition

#  @c_dashboard
#  Scenario: Verify that user can set the channel offset using SBC
#    Given the user has entered valid BlastWeb login credentials
#    And the user is on the dashboard page
#    And the selected device is in the "Ready to Arm" state
#    When the user clicks on the offset icon
#    Then six channel fields should be displayed
#    When the user sets the channel offset values
#    And clicks the save button
#    Then the offset icon should be displayed in blue and black
#    And the BCU should update the channels with the specified offset seconds

#  @d_dashboard
#  Scenario: Verify that dashboard grouping functionality works as expected
#    Given the user has entered valid BlastWeb login credentials
#    And the user is on the dashboard page
#    Then the "Group By" dropdown should be visible
#    When the user opens the Group By dropdown
#    And the user selects Key as the grouping option
#    And the user selects Network as the grouping option
#    And the user selects State as the grouping option
#    And the user selects Firmware as the grouping option
#    And the user selects Custom as the grouping option
#    And the user selects Selected as the grouping option
#    And the user selects Alive as the grouping option
#    And the user selects Type as the grouping option