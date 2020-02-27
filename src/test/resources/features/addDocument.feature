Feature: Add document

  Background:
    Given User is on index page

  @new
  Scenario: New Document without is created
    Given Search component is rendered
    Then User creates new document with file
    Then User closes the document Tab
    Then Search container is displayed
    Then User fills form to search document by name
    Then User clicks Search button
    And Verify the new document is in search result
    Then Open the document
    And Verify the new document has uploaded image