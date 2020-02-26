Feature: shortcuts menu

  Background:
    Given User is on index page

  @smoke @createDocumentType @ShortCut
  Scenario: Creating a Document type with template enabled
    When Search component is rendered
    Then User creates a new document type
    And User enable Template in document type

  @smoke @recentlyModified @ShortCut
  Scenario: Searching for documents by using Recently Modified Shortcut
    Given Search component is rendered
    When User creates new document with file for newly created Document Type
    Then User opens Shortcut Menu
    Then User clicks on Recently Modified Shortcut
    And Result contains documents
    Then User sorts the document by Modified Date
    
  @smoke @myDocuments @ShortCut
  Scenario: Searching for documents by using My Documents Shortcut
    Given Search component is rendered
    When User creates new document without file for newly created Document Type
    Then User closes the document Tab
    Then User searches document for newly created document type
    Then User selects document
    And User clicks on Display button
    Then User checks out new document from document details page
    Then User uploads new image and save document
    And User verifies Image Exists
    And User checks In document from document details page
    Then User closes the document Tab
    When User opens Shortcut Menu
    Then User clicks on My Documents Shortcut
    And Result contains documents
    Then User sorts the document by Created Date
    And User verifies the modified document

  @smoke @Templates @ShortCut
  Scenario: Searching for documents by using Templates shortcut
    Given Search component is rendered
    Then User creates new document with file for newly created Document Type
    Then User enables Template in document
    And User closes the document Tab
    Then User opens Shortcut Menu
    Then User clicks on Templates Shortcut
    And Result contains documents
    Then User sorts the document by Modified Date
    And User verifies the modified document

  @smoke @Trash @ShortCut
  Scenario: Searching for documents by using Trash shortcut
    Given Search component is rendered
    When User creates new document without file for newly created Document Type
    Then User closes the document Tab
    Then User searches document for newly created document type
    Then User selects document
    Then User clicks on Delete button
    Then User opens Shortcut Menu
    Then User clicks on Trash Shortcut
    And Result contains documents
    Then User sorts the document by Created Date
    And User verifies the modified document

  @smoke @Favorites @ShortCut
  Scenario: Searching for documents by using Favorites shortcut
    Given Search component is rendered
    When User creates new document without file for newly created Document Type
    Then User closes the document Tab
    Then User searches document for newly created document type
    Then User selects document
    Then User clicks on Display button
    When User clicks on Add to Favorites button
    Then User refreshes the page
    Then Remove from favorites button is displayed
    When User opens Shortcut Menu
    Then User clicks on Favorites Shortcut
    And Result contains documents
    And Favorites Badge should be displayed
    Then User searches document for newly created document type
    Then User selects document
    Then User clicks on Remove from Favorites button
#    And Add to favorites button is displayed

  @smoke @editSavedSearches @ShortCut
  Scenario: Editing Saved Searches Folder
    Given Search component is rendered
    Then User performs a search
    Then Result contains documents
    Then User Gets Result Count
    Then User verifies Save Search button is displayed
    Then User clicks on Save Search button
    Then User verifies Save Search Modal Window
    Then User sets name for new Save Search
    Then User opens Shortcut Menu
    Then User opens Manage Searches Modal
    Then User verifies Manage Search Modal Window
    Then User verifies Manage Search ButtonSet
    Then User edits Save Search Folder
    Then User makes another search
    Then User opens Shortcut Menu
    Then User Verifies that Saved Searches dropdown is expanded
    Then User clicks on Updated Saved Search
    Then User verifies the results for saved search shortcut

  @smoke @savedSearches @ShortCut
  Scenario: Searching for documents by using Saved Searches shortcut
    Given Search component is rendered
    Then User performs a search
    Then Result contains documents
    Then User Gets Result Count
    Then User verifies Save Search button is displayed
    Then User clicks on Save Search button
    Then User verifies Save Search Modal Window
    Then User sets name for new Save Search
    Then User makes another search
    Then User opens Shortcut Menu
    Then User clicks on Saved Search
    Then User verifies the results for saved search shortcut

  @smoke @addSavedSearch @ShortCut
  Scenario: Adding folder for saved Search from Manage Searches
    Given Search component is rendered
    Then User opens Shortcut Menu
    Then User opens Manage Searches Modal
    Then User verifies Manage Search Modal Window
    Then User verifies Manage Search ButtonSet
    Then User Creates New Folder for Saved Search
    Then User performs a search
    Then Result contains documents
    Then User Gets Result Count
    Then User verifies Save Search button is displayed
    Then User clicks on Save Search button
    Then User verifies Save Search Modal Window
    Then User sets name for Saved Search and selects newly created folder from the dropdown
    Then User makes another search
    Then User opens Shortcut Menu
    Then User expands Saved Search New folder
    Then User clicks on Saved Search List Item
    Then User verifies the results for saved search shortcut

  @smoke @deleteSavedSearches @ShortCut
  Scenario: Deleting Saved Searched List from Manage Searches
    Given Search component is rendered
    Then User opens Shortcut Menu
    Then User opens Manage Searches Modal
    Then User verifies Manage Search Modal Window
    Then User verifies Manage Search ButtonSet
    Then User select and delete Search Item
    And User clicks on close button on Manage Saved Searches Dialog

  @smoke @deleteDocumentType @ShortCut
  Scenario: Deleting document type
    Given Search component is rendered
    Then User navigates to Control Center
    Then User navigates to Retention Policies Page
    Then User creates and run new Retention Policy for Delete Active Documents
    And User deletes document type
    Then User verifies document type does not Exist
