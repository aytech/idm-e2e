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

  @smoke @deleteDocuments
  Scenario: Creating and Deleting Document type and Documents
    Given Search component is rendered
    Then User creates a new document type
    Then User navigates to IDM search page
    Then User creates new document with file for newly created Document Type
    Then User closes the document Tab
    Then User creates new document without file for newly created Document Type
    Then User closes the document Tab
    Then User performs a search for newly created document type
    Then Result contains documents
    Then User selects all documents and deletes them
    And No result is displayed
    Then User navigates to Control Center
    Then User deletes document type
    Then User verifies document type does not Exist