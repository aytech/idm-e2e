Feature: Retention policies

  Background:
    Given User is on index page

  @smoke @purgeDeletedDocuments @retentionPolicy
  Scenario: Creating and Running Retention Policy for Purge Delete Documents
    Given Search component is rendered
    Then User creates a new document type
    Then User navigates to IDM search page
    Then User creates new document with file for newly created Document Type
    Then User closes the document Tab
    Then User creates new document without file for newly created Document Type
    Then User closes the document Tab
    Then Search container is displayed
    Then User navigates to Control Center
    Then User navigates to Retention Policies Page
    Then User creates new Retention Policy for Purge Delete Documents
    Then User navigates to IDM search page
    Then User performs a search for newly created document type
    Then Result contains documents
    Then User selects all documents and deletes them
    And No result is displayed
    Then User Runs Retention Policy
    Then User deletes document type
    Then User verifies document type does not Exist

  @notImplemented
  Scenario: Add Archive Active Documents Retention Policy by Use Query Builder
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Retention policies under Configuration on the Control Center panel
    Then Retention policies page should be displayed
    When User clicks on Add button
    Then Add Retention Policy modal window should be displayed
    Then Query Builder option should be marked
    Then Document type drop down list should be able to select
    Then Property or Attribute field should be disable
    Then Operation field should be disable
    Then Search field should be disable
    Then Extend Query button should be displayed and active
    Then None filter should be displayed in Filter field
    Then Archive Active Documents action should be displayed in Action field
    Then Policies are automatically scheduled to run nightly, server time text should be displayed under Action field
    Then Description field should be empty to fill
    Then Cancel and Ok buttons should be displayed and active
    When User clicks on Information icon to review
    Then Information description should be opened and displayed
    When User clicks on Information icon to closed
    Then Information description should be closed and not displayed
    When User clicks on Document Type field
    Then document types drop down list should be displayed
    When User selects and clicks on any document type from drop down list
    Then selected document type should be displayed
    Then Property or Attribute field should be able to select
    Then Operation field should be disable
    Then Search field should be disable
    When User clicks on Property or Attribute field
    Then Properties or Attributes drop down list should be displayed
    When User selects and clicks on any Property or Attribute from drop down list
    Then selected Property or Attribute should be displayed
    Then Operation field should be able to select
    Then Search field should be disable
    When User clicks on Operation field
    Then Operations drop down list should be displayed
    When User selects and clicks on any Operation from drop down list
    Then selected Operation should be displayed
    Then Search field should be able to fill
    When User fills Search field
    Then filled values should be displayed
    When User clicks on Filter field
    Then filters drop down list should be displayed
    When User clicks on Action field
    Then actions from drop down list should be displayed
    When User selects and clicks on Archive Active Documents
    Then Archive Active Documents action should be displayed
    When User clicks on Ok button
    Then Add Retention Policy modal window should be closed
    Then Retention policy has been created confirmation popup should be displayed
    Then created retention policy should be saved and displayed on the end of the list
    Then created retention policy should have inactive key
    When User clicks on created 'Archive Active Documents retention policy
    Then created retention policy should be highlighted in blue
    When User clicks on inactive key on created retention policy
    Then the key is displayed in an active state

  @notImplemented
  Scenario: Add Purge Deleted Documents Retention Policy by Use Query Builder
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Retention policies under Configuration on the Control Center panel
    Then Retention policies page should be displayed
    When User clicks on Add button
    Then Add Retention Policy modal window should be displayed
    Then User Query Builder option should be marked
    Then Document type drop down list should be able to select
    Then Property or Attribute field should be disable
    Then Operation field should be disable
    Then Search field should be disable
    Then Cancel and Ok buttons should be displayed and active
    When User clicks on Document Type field
    Then document types drop down list should be displayed
    When User selects and clicks on any document type from drop down list
    Then selected document type should be displayed
    Then Property or Attribute field should be able to select
    Then Operation field should be disable
    Then Search field should be disable
    When User clicks on Filter field
    Then filters drop down list should be displayed
    When User selects and clicks on Created date
    Then the days field with default 1 should be displayed
    Then the period field with default Days ago should be displayed
    When User clicks on Action field
    Then actions from drop down list should be displayed
    When User selects and clicks on Purge Deleted Documents
    Then Purge Deleted Documents action should be displayed
    When User clicks on Ok button
    Then Add Retention Policy modal window should be closed
    Then Retention policy has been created confirmation popup should be displayed
    Then created retention policy should be saved and displayed on the end of the list
    Then created retention policy should have inactive key

  @notImplemented
  Scenario: Add Delete Active Documents Retention Policy by Use Query Builder
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Retention policies under Configuration on the Control Center panel
    Then Retention policies page should be displayed
    When User clicks on Add button
    Then Add Retention Policy modal window should be displayed
    Then User Query Builder option should be marked
    Then Document type drop down list should be able to select
    Then Property or Attribute field should be disable
    Then Operation field should be disable
    Then Search field should be disable
    Then Cancel and Ok buttons should be displayed and active
    When User clicks on Document Type field
    Then document types drop down list should be displayed
    When User selects and clicks on any document type from drop down list
    Then selected document type should be displayed
    Then Property or Attribute field should be able to select
    Then Operation field should be disable
    Then Search field should be disable
    When User clicks on Filter field
    Then filters drop down list should be displayed
    When User selects and clicks on Created date
    Then the days field with default 1 should be displayed
    Then the period field with default Days ago should be displayed
    When User enters 999 in the days field
    Then 999 should be displayed in the days field
    When User clicks on Days ago in period field
    Then the drop down list with Days ago Months ago Years ago should be displayed
    When User selects and clicks on Months ago
    Then Months ago should be displayed
    When User clicks on Action field
    Then actions from drop down list should be displayed
    When User selects and clicks on Delete Active Documents
    Then Delete Active Documents action should be displayed
    When User clicks on Ok button
    Then Add Retention Policy modal window should be closed
    Then Retention policy has been created confirmation popup should be displayed
    Then created retention policy should be saved and displayed on the end of the list
    Then created retention policy should have inactive key

  @notImplemented
  Scenario: Add Delete Archived Documents Retention Policy by Use Query Builder
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Retention policies under Configuration on the Control Center panel
    Then Retention policies page should be displayed
    When User clicks on Add button
    Then Add Retention Policy modal window should be displayed
    Then User Query Builder option should be marked
    Then Document type drop down list should be able to select
    Then Property or Attribute field should be disable
    Then Operation field should be disable
    Then Search field should be disable
    Then Cancel and Ok buttons should be displayed and active
    When User clicks on Document Type field
    Then document types drop down list should be displayed
    When User selects and clicks on any document type from drop down list
    Then selected document type should be displayed
    Then Property or Attribute field should be able to select
    Then Operation field should be disable
    Then Search field should be disable
    When User clicks on Action field
    Then actions from drop down list should be displayed
    When User selects and clicks on Delete Active Documents
    Then Delete Active Documents action should be displayed
    When User enters any characters on Description field
    Then filled characters should be displayed
    When User clicks on Ok button
    Then Add Retention Policy modal window should be closed
    Then Retention policy has been created confirmation popup should be displayed
    Then created retention policy should be saved and displayed on the end of the list
    Then created retention policy should have inactive key

  @notImplemented
  Scenario: Add Restore Archived Documents Retention Policy by Use Query Builder
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Retention policies under Configuration on the Control Center panel
    Then Retention policies page should be displayed
    When User clicks on Add button
    Then Add Retention Policy modal window should be displayed
    Then User Query Builder option should be marked
    Then Document type drop down list should be able to select
    Then Property or Attribute field should be disable
    Then Operation field should be disable
    Then Search field should be disable
    Then Cancel and Ok buttons should be displayed and active
    When User clicks on Document Type field
    Then document types drop down list should be displayed
    When User selects and clicks on any document type from drop down list
    Then selected document type should be displayed
    Then Property or Attribute field should be able to select
    Then Operation field should be disable
    Then Search field should be disable
    When User clicks on Action field
    Then actions from drop down list should be displayed
    When User selects and clicks on Restore Archived Documents
    Then Restore Archived Documents action should be displayed
    When User clicks on Ok button
    Then Add Retention Policy modal window should be closed
    Then Retention policy has been created confirmation popup should be displayed
    Then created retention policy should be saved and displayed on the end of the list
    Then created retention policy should have inactive key

  @notImplemented
  Scenario: Add Restore Deleted Documents Retention Policy by Use Query Builder
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Retention policies under Configuration on the Control Center panel
    Then Retention policies page should be displayed
    When User clicks on Add button
    Then Add Retention Policy modal window should be displayed
    Then User Query Builder option should be marked
    Then Document type drop down list should be able to select
    Then Property or Attribute field should be disable
    Then Operation field should be disable
    Then Search field should be disable
    Then Cancel and Ok buttons should be displayed and active
    When User clicks on Document Type field
    Then document types drop down list should be displayed
    When User selects and clicks on any document type from drop down list
    Then selected document type should be displayed
    Then Property or Attribute field should be able to select
    Then Operation field should be disable
    Then Search field should be disable
    When User clicks on Action field
    Then actions from drop down list should be displayed
    When User selects and clicks on Restore Deleteed Documents
    Then Restore Deleteed Documents action should be displayed
    When User clicks on Ok button
    Then Add Retention Policy modal window should be closed
    Then Retention policy has been created confirmation popup should be displayed
    Then created retention policy should be saved and displayed on the end of the list
    Then created retention policy should have inactive key

  @notImplemented
  Scenario: Run immediately Archive Active Documents policy with active key
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Retention policies under Configuration on the Control Center panel
    Then Retention policies page should be displayed
    Then the existing list of retention policies should be displayed
    Then If the existing list is empty
    Then User creates Archive Active Documents policy with active key
    When User selects Archive Active Documents policy with active key from the existing list
    Then selected policy should be highlighted in grey
    Then If Archive Active Documents policy is not displayed in the existing list
    Then User creates Archive Active Documents policy with active key
    Then Else if Archive Active Documents policy is dispayed with unactive key from the existing list
    Then User clicks on the key to active
    And the key should be in an active state
    And the selected policy should be highlighted in blue
    When User clicks on Run button
    Then Archive Active Documents action should be triggered
    Then Retention policy has been run successfully confirmation popup window should be displayed
    When User clicks on Back to Document button
    Then the landing page should displayed
    When User expands the search stack
    Then the search stack should be expanded
    When User clicks on Document Type field
    Then document types from drop down list should be displayed
    When User selects and clicks on document type on that the policy was triggered
    Then selected document type should be displayed
    When User clicks on Search button
    Then O matching documents search result should be displayed
    When User expands the search stack
    Then the search stack should be expanded
    When User clicks on Document Type field
    Then document types from drop down list should be displayed
    When User selects and clicks on document type on that the policy was triggered
    Then selected document type should be displayed
    When User clicks on Active field
    Then types of documents from drop down list should be displayed
    When User selects and clicks Archived
    Then Archived type should be displayed
    When User clicks on Search button
    Then corresponding search result should be displayed

  @notImplemented
  Scenario: Run immediately Purge Deleted Documents policy with unactive key
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Retention policies under Configuration on the Control Center panel
    Then Retention policies page should be displayed
    Then the existing list of retention policies should be displayed
    Then If the existing list is empty
    Then User creates Purge Deleted Documents policy with unactive key
    When User selects Purge Deleted Documents policy with unactive key from the existing list
    Then selected policy should be highlighted in grey
    Then If Purge Deleted Documents policy is not displayed in the existing list
    Then User creates Purge Deleted Documents policy with unactive key
    Then Else if Purge Deleted Documents policy is dispayed with active key from the existing list
    Then User clicks on the key to unactive
    And the key should be in an unactive state
    And the selected policy should be highlighted in blue
    When User clicks on Run button
    Then Purge Deleted Documents action should be triggered
    Then Retention policy has been run successfully confirmation popup window should be displayed
    When User clicks on Back to Document button
    Then the landing page should displayed
    When User expands the search stack
    Then the search stack should be expanded
    When User clicks on Document Type field
    Then document types from drop down list should be displayed
    When User selects and clicks on document type on that the policy was triggered
    Then selected document type should be displayed
    When User clicks on Active field
    Then types of documents from drop down list should be displayed
    When User selects and clicks Deleted
    Then Deleted type should be displayed
    When User clicks on Search button
    Then O matching documents search result should be displayed

  @notImplemented
  Scenario: Run nightly Delete Active Documents policy with active key
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Retention policies under Configuration on the Control Center panel
    Then Retention policies page should be displayed
    Then the existing list of retention policies should be displayed
    Then If the existing list is empty
    Then User creates Delete Active Documents policy with active key
    When User selects Delete Active Documents policy with active key from the existing list
    Then selected policy should be highlighted in grey
    Then If Delete Active Documents policy is not displayed in the existing list
    Then User creates Delete Active Documents policy with active key
    Then Else if Delete Active Documents policy is dispayed with unactive key from the existing list
    Then User clicks on the key to active
    And the key should be in an active state
    And the selected policy should be highlighted in blue
    When User clicks on Back to Document button
    Then the landing page should displayed
    When User expands the search stack
    Then the search stack should be expanded
    When User clicks on Document Type field
    Then document types from drop down list should be displayed
    When User selects and clicks on document type on that the policy was triggered
    Then selected document type should be displayed
    When User clicks on Active field
    Then types of documents from drop down list should be displayed
    When User clicks on Search button
    Then some documetns should be displayed
    When User clicks on Landing page next day
    Then Landing page should be displayed
    When User expands the search stack
    Then the search stack should be expanded
    When User clicks on Document Type field
    Then document types from drop down list should be displayed
    When User selects and clicks on document type on that the policy was triggered
    Then selected document type should be displayed
    When User clicks on Active field
    Then types of documents from drop down list should be displayed
    When User clicks on Search button
    Then O matching documents search result should be displayed

  @notImplemented
  Scenario: Edit Retention Policy by Use Query Builder
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Retention policies under Configuration on the Control Center panel
    Then Retention policies page should be displayed
    Then the existing list of retention policies should be displayed
    Then If the existing list is empty
    Then User creates Archive Active Documents policy
    When User selects and clicks on any retention policy from the existing list
    Then selected policy should be highlighted in blue
    When User clicks on Edit button
    Then Edit Retention Policy modal window should be displayed
    Then Query Builder option should be marked
    Then Document type field should be displayed with selected document type
    Then Cancel and Ok buttons should be displayed and active
    When User clicks on Document Type field
    Then document types drop down list should be displayed
    When User selects and clicks on any document type from drop down list
    Then selected document type should be displayed
    When User clicks on Property or Attribute field
    Then Properties or Attributes drop down list should be displayed
    When User selects and clicks on any Property or Attribute from drop down list
    Then selected Property or Attribute should be displayed
    Then Operation field should be able to select
    Then Search field should be disable
    When User clicks on Operation field
    Then Operations drop down list should be displayed
    When User selects and clicks on any Operation from drop down list
    Then selected Operation should be displayed
    Then Search field should be able to fill
    When User fills Search field
    Then filled values should be displayed
    When User clicks on Action field
    Then actions from drop down list should be displayed
    When User selects and clicks on any action
    Then selected action action should be displayed
    When User enters any characters on Description field
    Then filled characters should be displayed
    When User clicks on Ok button
    Then Edit Retention Policy modal window should be closed
    Then Retention policy has been updated confirmation popup should be displayed
    Then changes of retention policy should be saved

  @notImplemented
  Scenario: Delete Retention Policy
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Retention policies under Configuration on the Control Center panel
    Then Retention policies page should be displayed
    Then the existing list of retention policies should be displayed
    Then If the existing list is empty
    Then User creates 'Archive Active Documents policy
    When User selects and clicks on any retention policy from the existing list
    Then selected policy should be highlighted in blue
    When User clicks on "Delete" button
    Then 'Delete' modal window should be displayed
    Then 'Do you really want to delete this Retention Policy?' should be displayed
    Then "No" and "Yes" button should be displayed
    When User clicks on "No" button
    Then 'Delete' modal window should be closed
    Then the existing list should have stayed without changes
    When User selects and clicks on any retention policy from the existing list
    Then selected policy should be highlighted in blue
    When User clicks on "Delete" button
    Then 'Delete' modal window should be displayed
    When User clicks on "Yes" button
    Then 'Delete' modal window should be closed
    Then 'Retention policy has been deleted' confirmation popup should be displayed
    Then selected retention policy should be deleted

  @notImplemented
  Scenario: Add Archive Active Documents Retention Policy by Enter Query Manually
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Retention policies under Configuration on the Control Center panel
    Then Retention policies page should be displayed
    When User clicks on "Add" button
    Then 'Add Retention Policy' modal window should be displayed
    Then 'Query Builder' option should be marked
    When User clicks on 'Enter Query Manually' checkbox
    Then 'Enter Query Manually' checkbox should be marked
    Then 'XQuery' field should be displayed and it should be empty
    Then 'Archive Active Documents' action should be displayed in Action field
    Then "Policies are automatically scheduled to run nightly, server time." text should be displayed under Action field
    Then 'Description' field should be empty to fill
    Then "Cancel" and "Ok" buttons should be displayed and active
    When User clicks on Information icon to review
    Then Information description should be opened and be displayed
    When User clicks on Information icon to closed
    Then Information description should be closed and not be displayed
    When User enter invalid XQuery in 'XQuery' field
    Then invalid XQuery in 'XQuery' field should be displayed
    When User clicks on "Yes" button
    Then 'Invalid XQuery Operation error' modal window should be displayed
    When User clicks on "Close" button
    Then 'Operation error' modal window should be closed
    When User clicks on "Add" button
    Then 'Add Retention Policy' modal window should be displayed
    Then 'Query Builder' option should be marked
    When User clicks on 'Enter Query Manually' checkbox
    Then 'Enter Query Manually' checkbox should be marked
    When User enter valid XQuery in XQuery field
    Then valid XQuery in XQuery field should be displayed
    When User clicks on Action field
    Then actions from drop down list should be displayed
    When User selects and clicks on Archive Active Documents
    Then Archive Active Documents action should be displayed
    When User enters any characters in 'Description' field
    Then entered characters should be displayed
    When User clicks on Ok button
    Then Add Retention Policy modal window should be closed
    Then Retention policy has been created confirmation popup should be displayed
    Then created retention policy should be saved and displayed on the end of the list
    Then created retention policy should have inactive key

