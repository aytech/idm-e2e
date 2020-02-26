Feature: Print

  Background:
    Given User is on index page

  @smoke @Printer @addPrinter
  Scenario: Adding a Printer configuration
    When User navigates to Control Center
    Then User navigates to Print Configuration Page
    Then User adds Printer Credentials
    Then Confirmation toast message should be displayed
    Then User configures Printer
    Then Confirmation toast message should be displayed
    And User verifies the Printer