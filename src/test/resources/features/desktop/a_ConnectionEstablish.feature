@desktop
  Feature: Use a backup database file to establish communication
    As a Surface Blast Controller administrator, I want to be able to use a database backup file so that I can successfully
    establish a connection between the BCU and SBC

#    Invalidate cache data in Intellij to run this scenario
    @a_serverConfig
  Scenario: Verify that a user can use a backup file to establish communication between the BCU and the SBC
    Given the user stops the server and web server if they are running
    When the user clicks "Restore from backup" on the server configuration interface
    And the user selects the backup file
    And the user saves the configuration
    And the user starts the server
    Then the user starts the web server