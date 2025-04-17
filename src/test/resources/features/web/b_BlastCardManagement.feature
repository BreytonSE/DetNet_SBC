@web
Feature: Active card management feature
  As a system user, I want the ability to effectively manage blast cards, so that I can create, search, select, archive,
  or delete cards based on operational needs.

  @a_blastCardManagement
  Scenario: Verify that user can add a blast, active, and timed blast on the system.
    Given the user has entered valid BlastWeb login credentials
    And the NFC reader is connected to the computer or laptop
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Blast Cards section
    And the user navigates to the Active Cards tab
    And the user clicks on the Add Blast Card button
    Then the user taps the blast card on the NFC reader when the Add Blast Card popup is displayed

  @b_blastCardManagement
  Scenario: Verify that user can archive blast cards
    Given the user has entered valid BlastWeb login credentials
    And the NFC reader is connected to the computer or laptop
    When the user opens the navigation menu by clicking the current system user's name
    And the user navigates to the Settings page
    And the user navigates to the Blast Cards section
    And the user navigates to the Active Cards tab
    And the user clicks on the Add Blast Card button
    Then the user taps the blast card on the NFC reader when the Add Blast Card popup is displayed
    And the user clicks on the Archive Cards button to archive multiple cards
    And the user clicks the Archive icon from the table to archive a single card
    Then the user navigates to the Archived cards
    And the user verifies that the blast card is visible in the archive list

#  @c_blastCardManagement
#  Scenario: Verify that user can delete blast cards
#    Given the user has entered valid BlastWeb login credentials
#    And the NFC reader is connected to the computer or laptop
#    When the user opens the navigation menu by clicking the current system user's name
#    And the user navigates to the Settings page
#    And the user navigates to the Blast Cards section
#    And the user navigates to the Active Cards tab
#    And the user clicks on the Add Blast Card button
#    Then the user taps the blast card on the NFC reader when the Add Blast Card popup is displayed
#    And the user clicks on the 'Delete Cards' button to delete multiple cards
#    And the user clicks the 'Delete' icon from the table to delete a single card
#    Then the user verifies that the blast card has been removed from the system
#
#  @d_blastCardManagement
#  Scenario: Verify that a user can search for a card using serial number, key type, or updated date
#    Given the user has entered valid BlastWeb login credentials
#    And the NFC reader is connected to the computer or laptop
#    When the user opens the navigation menu by clicking the current system user's name
#    And the user navigates to the Settings page
#    And the user navigates to the Blast Cards section
#    And the user navigates to the Active Cards tab
#    Then enter a value in the search bar
#    And click the search button
#    Then finally verify if a list of cards is displaying based on the searched word