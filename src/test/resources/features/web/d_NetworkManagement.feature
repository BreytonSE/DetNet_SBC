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