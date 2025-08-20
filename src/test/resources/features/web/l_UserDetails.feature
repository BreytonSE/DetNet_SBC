@web
  Feature: User details edit feature
    As a Blastweb SBC administrator, I want to manage my account details so that I can view, update my information, or
    change my password without errors.

    @a_userDetails
  Scenario: Verify that user is navigated to the 'My Account Details' -page when clicking on clicking on My Account menu
    Given the user is logged into BlastWeb with valid credentials
    When the user open the navigation menu
    And click on "My Account" menu item
    Then verify that user is on user detail page with URL "http://localhost:8080/en/user-account"

   @b_userDetails
  Scenario: Verify that user gets directed to the "Edit User" page when clicking on "Edit Details" -button
     Given the user is logged into BlastWeb with valid credentials
     When the user open the navigation menu
     And click on "My Account" menu item
     And click on "Edit Details" button
     Then verify that the "Edit User" page is open

   @c_userDetails
   Scenario: Verify that user gets directed to the "Password Reset" page when clicking on "Change My Password" -button
     Given the user is logged into BlastWeb with valid credentials
     When the user open the navigation menu
     And click on "My Account" menu item
     And click on "Change My Password"
     Then verify that the user is navigated to the password reset page