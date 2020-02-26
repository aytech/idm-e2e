Feature: Search document

  Background:
    Given User is on index page

  @smoke
  Scenario: Search Page is displayed
    Given Search component is rendered
    When Search container is displayed
    Then User Searches by clicking Search Button
    And Search dropdown remains open
    And No result is displayed

  @smoke
  Scenario: User can search for document and XQuery is generated
    Given Search component is rendered
    When User creates new document without file
    Then User closes the document Tab
    Then User searches document
    And Search result text is displayed
    And Search result contains the document
    Then Search container is displayed
#    Commenting this as advanced search was changed
#    And XQuery for entity type was generated

  @smoke @archived @search
  Scenario: User Searches for archived documents
    Given Search component is rendered
    Then User creates new document without file
    Then User archives document from document details page
    Then Search container is displayed
    And User fills form to search document by name
    Then User selects Archived from dropdown
    And User clicks Search button
    Then Archived document is displayed in the result list

  @smoke @deleted @search
  Scenario: User Searches for deleted documents
    Given Search component is rendered
    Then User creates new document without file
    Then User deletes document from document details page
    Then Search container is displayed
    And User fills form to search document by name
    Then User selects Deleted from dropdown
    And User clicks Search button
    Then Deleted document is displayed in the result list