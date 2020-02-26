Feature: Add Document Type

  Background:
    Given User is on index page

  @smoke @addDocumentType @DocumentType
  Scenario: New Document Type with required and string data type attributes
    Given Search component is rendered
    When User navigates to Control Center
    Then User expands Control Center navigation panel
    Then User opens Document Type administration
    Then user click on new document type button
    Then new Document Type form is displayed
    Then user fill the form with valid display name
    And cancel button is in enabled state and next button in enabled state
    Then user click on next button
    And user verifies Attribute page
    Then click on add Attribute button
    Then Attribute form page is displayed
    Then user fill the form with valid Attribute display name
    And user selects String data type from the data type drop down
    And user enable the Required checkbox
    Then user click on next button
    Then user navigates to ACL page
    And Cancel Previous and Done buttons are displayed
    Then user click on done button
    Then Changes Saved toast message should be displayed
    Then User verifies document type Exists
    Then User closes expanded Control Center navigation panel
    Then User navigates to IDM search page

  @smoke @shortDataType @DocumentType
  Scenario: Adding a short data type attribute to existing document type
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to document type configuration page
    Then User navigates to Attribute page
    And user verifies Attribute page
    Then user adds short attribute
    Then Changes Saved toast message should be displayed
    And User verifies that short attribute is added
    Then User navigates to IDM search page
    Then User adds a document with invalid short value
    And Verifies error tooltip for invalid short value
    Then User adds a document with valid short value
    Then User searches document by short value
    And Verify the new document is in search result

  @smoke @longDataType @DocumentType
  Scenario: Adding a Long datatype attribute to existing document type
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to document type configuration page
    Then User navigates to Attribute page
    And user verifies Attribute page
    Then user adds long attribute
    Then Changes Saved toast message should be displayed
    And User verifies that long attribute is added
    Then User navigates to IDM search page
    Then User adds a document with invalid long value
    And Verifies error tooltip for invalid long value
    Then User adds a document with valid long value
    Then User searches document by long value
    And Verify the new document is in search result

  @smoke @decimalDataType @DocumentType
  Scenario: Adding a Decimal datatype attribute to existing document type
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to document type configuration page
    Then User navigates to Attribute page
    And user verifies Attribute page
    Then user adds decimal attribute
    Then Changes Saved toast message should be displayed
    And User verifies that decimal attribute is added
    Then User navigates to IDM search page
    Then User adds a document with invalid decimal value
    And Verifies error tooltip for invalid decimal value
    Then User adds a document with valid decimal value
    Then User searches document by decimal value
    And Verify the new document is in search result

  @smoke @dateDataType @DocumentType
  Scenario: Adding a Date datatype attribute to existing document type
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to document type configuration page
    Then User navigates to Attribute page
    And user verifies Attribute page
    Then user adds date attribute
    Then Changes Saved toast message should be displayed
    And User verifies that date attribute is added
    Then User navigates to IDM search page
    Then User adds a document with invalid Date value
    And Verifies error tooltip for invalid Date value
    Then User adds a document with valid Date value
    Then User searches document by Date value
    And Verify the new document is in search result

  @smoke @timeDataType @DocumentType
  Scenario: Adding a Time datatype attribute to existing document type
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to document type configuration page
    Then User navigates to Attribute page
    And user verifies Attribute page
    Then user adds time attribute
    Then Changes Saved toast message should be displayed
    And User verifies that Time attribute is added
    Then User navigates to IDM search page
    Then User adds a document with invalid Time value
    And Verifies error tooltip for invalid Time value
    Then User adds a document with valid Time value
    Then User searches document by Time value
    And Verify the new document is in search result

  @smoke @timestampDataType @DocumentType
  Scenario: Adding a Time Stamp datatype attribute to existing document type
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to document type configuration page
    Then User navigates to Attribute page
    And user verifies Attribute page
    Then user adds timestamp attribute
    Then Changes Saved toast message should be displayed
    And User verifies that Timestamp attribute is added
    Then User navigates to IDM search page
    Then User adds a document with invalid Timestamp value
    And Verifies error tooltip for invalid Timestamp value
    Then User adds a document with valid Timestamp value
    Then User searches document by Timestamp value
    And Verify the new document is in search result

  @smoke @doubleDataType @DocumentType
  Scenario: Adding a Double datatype attribute to existing document type
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to document type configuration page
    Then User navigates to Attribute page
    And user verifies Attribute page
    Then user adds double attribute
    Then Changes Saved toast message should be displayed
    And User verifies that Double attribute is added
    Then User navigates to IDM search page
    Then User adds a document with invalid Double value
    And Verifies error tooltip for invalid Double value
    Then User adds a document with valid Double value
    Then User searches document by Double value
    And Verify the new document is in search result

  @smoke @booleanDataType @DocumentType
  Scenario: Adding a Boolean datatype attribute to existing document type
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to document type configuration page
    Then User navigates to Attribute page
    And user verifies Attribute page
    Then user adds boolean attribute
    Then Changes Saved toast message should be displayed
    And User verifies that Boolean attribute is added
    Then User navigates to IDM search page
    Then User adds a document with true boolean value
    Then User searches document by true Boolean value
    And Verify the new document is in search result
    Then User adds a document with false boolean value
    Then User searches document by false Boolean value
    And Verify the new document is in search result

  @smoke @guidDataType @DocumentType
  Scenario: Adding a GUID datatype attribute to existing document type
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to document type configuration page
    Then User navigates to Attribute page
    And user verifies Attribute page
    Then user adds GUID attribute
    Then Changes Saved toast message should be displayed
    And User verifies that GUID attribute is added
    Then User navigates to IDM search page
    Then User adds a document with invalid GUID value
    And Verifies error tooltip for invalid GUID value
    Then User adds a document with valid GUID value
    Then User searches document by GUID value
    And Verify the new document is in search result

  @smoke @valuesetDataType @DocumentType
  Scenario: Adding a ValueSet datatype attribute to existing document type
    Given Search component is rendered
    Then User Creates New Value Set with Values
    When User navigates to Control Center
    Then User navigates to document type configuration page
    Then User navigates to Attribute page
    And user verifies Attribute page
    Then user adds Valueset attribute
    Then Changes Saved toast message should be displayed
    And User verifies that Valueset attribute is added
    Then User navigates to IDM search page
    Then User adds a document with value set value
    Then User searches document by value set value
    And Verify the new document is in search result

  @smoke @ACL @DocumentType
  Scenario: Adding ACL to existing document type
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to document type configuration page
    Then User navigates to ACL page
    Then User opens new ACL form
    Then User fills the form for the new acl
    And User set new ACL as default ACL
    Then User clicks on Save Changes button
    Then Changes Saved toast message should be displayed
    Then User verifies new ACL was created successfully
    Then User navigates to IDM search page
    Then User adds a document with new ACL
    And Verify the document ACL
    Then User deletes the document which is added previously

 # Marking test as unstable as related information Panel is redesigned
  @Unstable @RelatedDocumentsRule @DocumentType
  Scenario: Adding an Related documents rule
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to document type configuration page
    Then User navigates to Related Documents tab
    Then User adds Related Documents Rule
    Then Changes Saved toast message should be displayed
    Then User verifies the Related Documents Rule of the document type
    Then User navigates to IDM search page
    Then User adds a document as per related document rule
    Then User adds new document
    And User Verifies the related documents

  @smoke @ACLRule @DocumentType
  Scenario: Adding an ACL Rule
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to document type configuration page
    Then User navigates to ACL Rules tab
    Then User adds ACL Rule
    Then Changes Saved toast message should be displayed
    Then User verifies the ACL Rules of the document type
    Then User navigates to IDM search page
    Then User adds the document as per Acl Rule
    And Verify that Acl Rule is applied
    Then User deletes the document which is added previously

  @smoke @CopyDocumentType @DocumentType
  Scenario: Copy a Document Type
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to document type configuration page
    Then User creates a copy of the opened document type
    Then User verifies all attributes exist in the copy of the document type
    And User removes the copy

  @notImplemented
  Scenario: Editing an Related documents rule
    Given Search component is rendered
    When User navigates to Control Center
    Then User expands Control Center navigation panel
    Then user click on document type under administration
    Then document type page is opened
    Then user Select document type
    Then document type General tab is displayed
    Then User navigates to Related Documents tab
    Then User verifies Related Documents Page
    Then User User select rule in bundle
    Then Related documents rules form is displayed
    Then User edits the form with the valid values
    # eg: /AllAttributes[@String = "trycheck"]
    And save changes button is enabled
    Then User clicks on Save changes button
    And toast message is displayed
    Then User verifies edited related documents rule of the document type

  @notImplemented
  Scenario: Editing an ACL Rule
    Given Search component is rendered
    When User opens Control Center
    Then User expands Control Center navigation panel
    Then user click on document type under administration
    Then document type page is opened
    Then user Select document type
    Then document type General tab is displayed
    Then User navigates to ACL Rules tab
    Then User verifies ACL Rules page
    Then User select rule in Current rules
    Then ACL Rules form is displayed
    Then User edits the form with the valid values
    # eg: /AllAttributes[@String = "try12"]
    And save changes button is enabled
    Then User clicks on Save changes button
    And toast message is displayed
    Then User verifies the  edited ACL RUles of the document type

  @notImplemented
  Scenario: Deleting an Related documents rule
    Given Search component is rendered
    When User opens Control Center
    Then User expands Control Center navigation panel
    Then user click on document type under administration
    Then document type page is opened
    Then user Select document type
    Then document type General tab is displayed
    Then User navigates to Related Documents tab
    Then User verifies Related Documents Page
    Then User User select rule in bundle
    Then Related documents rules form is displayed
    Then User Clicks on delete button
    And save changes button is enabled
    Then User clicks on Save changes button
    And toast message is displayed
    Then User verifies deleted related documents rule of the document type

  @notImplemented
  Scenario: Deleting an ACL Rule
    Given Search component is rendered
    When User opens Control Center
    Then User expands Control Center navigation panel
    Then user click on document type under administration
    Then document type page is opened
    Then user Select document type
    Then document type General tab is displayed
    Then User navigates to ACL Rules tab
    Then User verifies ACL Rules page
    Then User select rule in Current rules
    Then ACL Rules form is displayed
    Then User Clicks on delete button
    And save changes button is enabled
    Then User clicks on Save changes button
    And toast message is displayed
    Then User verifies deleted ACL RUles of the document type

  @smoke @deleteDocumentType @DocumentType
  Scenario: Deleting document type
    Given Search component is rendered
    Then User navigates to Control Center
    Then User navigates to Retention Policies Page
    Then User creates and run new Retention Policy for Delete Active Documents
    And User deletes document type
    Then User verifies document type does not Exist
    And User deletes newly created Value Set