Feature: Result List

  Background:
    Given User is on index page

  @smoke @addResultList @ResultList
  Scenario: Adding a result List
    Given Search component is rendered
    Then User creates a new document type
    Then User navigates to result list configuration page
    Then User adds Result list Configuration
    Then User verifies Added Result list
    Then User navigates to IDM search page
    Then User creates new document with file for newly created Document Type
    Then User closes the document Tab
    Then User performs a search for newly created document type
    And User verifies Result list for document type
    Then User navigates to Control Center
    Then User navigates to Retention Policies Page
    Then User creates and run new Retention Policy for Delete Active Documents
    And User deletes document type
    Then User verifies document type does not Exist

  Scenario: Deleting an result List
    Given Control Center Icon is displayed
    When User click on Control Center Icon
    Then Control Center Homepage should be displayed
    Then User clicks on Result List under Configuration
    Then Result List Page Should be displayed
    Then User selects the document type from the dropdown
    Then User clicks on Delete Document Type button
    Then Verify for the deleted Result List
    And Verify its reflection in Client

  Scenario: Reordering properties/attributes
    Given Control Center Icon is displayed
    When User click on Control Center Icon
    Then Control Center Homepage should be displayed
    Then User clicks on Result List under Configuration
    Then Result List Page Should be displayed
    Then User selects the property
    Then User clicks on reordering button
    Then Verify for the reordered properties
    And Verify its reflection in Client