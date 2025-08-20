@web
  Feature: Events reports monitoring
    As a Blastweb SBC administrator, I want to navigate to the Events Reports section, retrieve and filter reports, and
    export them so that I can analyze events data and it for further use.

  @a_eventsReport
  Scenario: Verify that user can view events reports
    Given the user is logged into BlastWeb with valid credentials
    When the user opens the "Reports" dropdown on the navigation bar
    And the user selects "Events Report" from the dropdown list
    Then the user should be directed to the "Event Report" page in the reports section

  @b_eventsReport
  Scenario: Verify that user can retrieve a report and view its page contents
    Given the user is logged into BlastWeb with valid credentials
    When the user opens the "Reports" dropdown on the navigation bar
    And the user selects "Events Report" from the dropdown list
    Then the report contents should be displayed
    And the events report should be paginated
    And the events report should be sortable
    And the events report should be filterable by device
    And the events report should be filterable by event category