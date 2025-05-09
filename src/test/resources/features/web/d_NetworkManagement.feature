@web
  Feature: Network management feature
    As a system administrator, I want to view, edit, and delete network configurations via the BlastWeb interface, so
    that I can ensure the network layer of the system is up-to-date, accurate, and reflective of the required setup.

  Scenario: Verify that networks of the system can be viewed on the BlastWeb interface as well as on the backend
  (database)
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user opens the "Networks" page
    Then a list of networks should be displayed on the interface
    And the same list of networks should be present in the backend database

  Scenario: Verify that networks can be added to the system, ensuring the information can written back to the backend
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user opens the "Networks" page
    And the user clicks on the "Add Network" button
    And the user fills in all required form fields with valid network information
    And the user submits the new network
    Then the user adds another network
    Then the new network should appear as the last item in the network list
    And the new network should be present in the backend database

  Scenario: Verify that an existing network can be edited, ensuring that information can be updated on the backend
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user opens the "Networks" page
    And the user clicks on the edit (pencil) icon of an existing network
    And the user updates the desired network information
    And the user clicks the Save button
    Then the updated network information should be saved successfully without any errors
    And the changes should be reflected in the backend database

  Scenario: Verify that a network can be deleted, ensuring that information can be deleted on the backend
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user opens the "Networks" page
    And the user clicks on the trash icon associated with the network to be deleted
    And the user confirms the deletion by clicking the Delete button in the popup
    Then the network should no longer be visible on the BlastWeb interface

#    Needs fixing
#  Scenario: Verify that multiple networks can be deleted at once
#    Given the user has entered valid BlastWeb login credentials
#    When the user opens the navigation menu by clicking the current system user's name
#    And the user navigates to the Settings page
#    And the user opens the "Networks" page
#    And the user selects multiple networks by clicking the checkboxes in the network list or the header checkbox
#    And the user clicks the enabled "Delete Networks" button
#    And a confirmation popup is displayed for network deletion
#    And the user clicks "Yes" to confirm the deletion
#    Then the selected networks should be successfully deleted from the interface

  Scenario: Verify that a network can be searched using ID and name
    Given the user has entered valid BlastWeb login credentials
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user opens the "Networks" page
    And the user clicks the search bar
    And the user types the ID or name of the network in the search bar
    Then the list should display results matching the entered search keyword