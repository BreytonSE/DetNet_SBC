Feature: This is a test run

  Scenario: Verify that the user can launch the BlastWeb
    Given I launch BlastWeb
    When I set Username
    And I set the Password
    Then I toggle password visibility
    And click on the login button