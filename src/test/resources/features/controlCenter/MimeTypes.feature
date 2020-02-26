Feature: MIME Types

Background:
    Given User is on index page

@smoke
Scenario: Adding mime type
    When User navigates to Control Center
    Then User navigates to Mime Types page
    Then User adds mime type
    Then Confirmation toast message should be displayed
    Then Verify mime type is added in the mime types table

@smoke
Scenario: Editing mime type
    When User navigates to Control Center
    Then User navigates to Mime Types page
    Then User edits mime type
    Then User verifies mime type is updated

@notImplemented
Scenario: Searching of mime type
    When User navigates to Control Center
    Then User navigates to Mime Types page
    Then User searches previously added mime type
    Then Verify mime type is displayed in the mime types table

@smoke
Scenario: Deleting mime type
    When User navigates to Control Center
    Then User navigates to Mime Types page
    Then User removes previously added mime type and verifies it is deleted
    Then Confirmation toast message should be displayed