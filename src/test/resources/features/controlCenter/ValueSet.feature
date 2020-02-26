Feature: Value Set

  Background:
    Given User is on index page

  @smoke @StringDataTypeValueSet @Valueset
  Scenario: Adding and deleting String Datatype Valueset
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to Value Set administration page
    Then User creates String datatype valueset
    Then User adds value of type String to ValueSet
    And Confirmation toast message should be displayed
    Then User searches for saved Value Set
    And User edits String valueset
    And Confirmation toast message should be displayed
    And User deletes Value Set
    Then User verifies Value Set does not Exist

  @smoke @ShortDataTypeValueSet @Valueset
  Scenario: Adding and deleting Short Datatype Valueset
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to Value Set administration page
    Then User creates Short datatype valueset
    And User adds invalid Short value
    Then Validation error for invalid Short value should be displayed
    Then User adds value of type Short to ValueSet
    And Confirmation toast message should be displayed
    Then User searches for saved Value Set
    And User edits Short valueset
    And Confirmation toast message should be displayed
    And User deletes Value Set
    Then User verifies Value Set does not Exist

  @smoke @longDataTypeValueSet @Valueset
  Scenario: Adding and deleting Long Datatype Valueset
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to Value Set administration page
    Then User creates Long datatype valueset
    And User adds invalid Long value
    Then Validation error for invalid Long value should be displayed
    Then User adds value of type Long to ValueSet
    And Confirmation toast message should be displayed
    Then User searches for saved Value Set
    And User edits Long valueset
    And Confirmation toast message should be displayed
    And User deletes Value Set
    Then User verifies Value Set does not Exist

  @smoke @DecimalDataTypeValueSet @Valueset
  Scenario: Adding and deleting Decimal Datatype Valueset
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to Value Set administration page
    Then User creates Decimal datatype valueset
    And User adds invalid Decimal value
    Then Validation error for invalid Decimal value should be displayed
    Then User adds value of type Decimal to ValueSet
    And Confirmation toast message should be displayed
    Then User searches for saved Value Set
    And User edits Decimal valueset
    And Confirmation toast message should be displayed
    And User deletes Value Set
    Then User verifies Value Set does not Exist

  @smoke @DoubleDataTypeValueSet @ValueSet
  Scenario: Adding and deleting Double Datatype Valueset
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to Value Set administration page
    Then User creates Double datatype valueset
    And User adds invalid Double value
    Then Validation error for invalid Double value should be displayed
    Then User adds value of type Double to ValueSet
    And Confirmation toast message should be displayed
    Then User searches for saved Value Set
    And User edits Double valueset
    And Confirmation toast message should be displayed
    And User deletes Value Set
    Then User verifies Value Set does not Exist

  @smoke @UuidDataTypeValueSet @ValueSet
  Scenario: Adding and deleting UUID Datatype Valueset
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to Value Set administration page
    Then User creates UUID datatype valueset
    And User adds invalid UUID value
    Then Validation error for invalid GUID value should be displayed
    Then User adds value of type UUID to ValueSet
    And Confirmation toast message should be displayed
    Then User searches for saved Value Set
    And User edits UUID valueset
    And Confirmation toast message should be displayed
    And User deletes Value Set
    Then User verifies Value Set does not Exist

  @smoke @DateDataTypeValueSet @ValueSet
  Scenario: Adding and deleting Date Datatype Valueset
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to Value Set administration page
    Then User creates Date datatype valueset
    And User adds invalid Date value
    Then Validation error for invalid Date value should be displayed
    Then User adds value of type Date to ValueSet
    And Confirmation toast message should be displayed
    Then User searches for saved Value Set
    And User edits Date valueset
    And Confirmation toast message should be displayed
    And User deletes Value Set
    Then User verifies Value Set does not Exist

  @smoke @TimeDataTypeValueSet @Valueset
  Scenario: Adding and deleting Time Datatype Valueset
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to Value Set administration page
    Then User creates Time datatype valueset
    And User adds invalid Time value
    Then Validation error for invalid Time value should be displayed
    Then User adds value of type Time to ValueSet
    And Confirmation toast message should be displayed
    Then User searches for saved Value Set
    And User edits Time valueset
    And Confirmation toast message should be displayed
    And User deletes Value Set
    Then User verifies Value Set does not Exist

  @smoke @TimeStampDataTypeValueSet @ValueSet
  Scenario: Adding and deleting TimeStamp Datatype Valueset
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to Value Set administration page
    Then User creates TimeStamp datatype valueset
    And User adds invalid TimeStamp value
    Then Validation error for invalid TimeStamp value should be displayed
    Then User adds value of type TimeStamp to ValueSet
    And Confirmation toast message should be displayed
    Then User searches for saved Value Set
    And User edits TimeStamp valueset
    And Confirmation toast message should be displayed
    And User deletes Value Set
    Then User verifies Value Set does not Exist

  @notimplemented
  Scenario: UI for Value Set items
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    Then Control Center menu should be displayed
    Then Control Center panel should be displayed
    When User clicks on Administration menu in Control Center menu
    Then Administration menu should be expanded
    Then Document Type sub menu should be displayed
    Then Value Set sub menu should be displayed
    Then Import or Export sub menu should be displayed
    When User clicks on Value Set sub menu
    Then Value Set tab should be displayed
    Then Value Set header should be displayed
    Then Toggle Control Center SideBar on the left side of the header should be displayed
    Then Back to Documents button on the right side of the header should be displayed
    Then Type search item here field under the header should be displayed
    Then the actual list of Value Set under Type search item here field should be displayed
    Then Click on a value set to view details or edit text should be displayed
    Then active Add button on the right side should be displayed
    When User clicks on any Value Set of the actual list of Value Set
    Then General tab should be opened
    Then Values tab should be displayed
    Then Display name field should be displayed
    Then Translation button on the right side of Display name field should be displayed
    Then Name field should be displayed
    Then Data Type field should be displayed
    Then active Add and Delete buttons on the top right should be displayed
    When User clicks on Value tab
    Then the value table should be displayed
    Then There are no values set You can create one by clicking add button text should be displayed if the value table is empty
    Then some values in the value table should be displayed if the value table is not empty
    Then active Add button should be displayed
    Then nonactive Value Translations button should be displayed
    Then nonactive Edit button should be displayed
    Then nonactive Delete button should be displayed
    When User clicks on any value of the value table
    Then the selected value should be highlighted in gray
    Then active Value Translations button should be displayed
    Then active Add button should be displayed
    Then active Edit button should be displayed
    Then active Delete button should be displayed
    When User clicks on Back to Document button
    Then Landing page should be displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    Then Control Center panel should be displayed
    When User clicks on Value Set link under Administration section on the Control Center panel
    Then Value Set tab should be displayed
    Then Value Set in Control Center menu should be highlighted in blue
    When User clicks on Document link on the top of Control Center menu
    Then Landing page should be displayed

  @notimplemented
  Scenario: Delete Value Set in 'General' tab
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Value Set link under Administration section on the Control Center panel
    Then Value Set tab should be displayed
    Then 'Type search item here' field should be displayed
    Then the actual list of Value Set under 'Type search item here' field should be displayed
    Then active "+ Add" and "Delete" button should be displayed
    When User clicks on any value set from the actual list of Value Set
    Then the selected value set should be highlighted in blue
    Then 'General' tab of the selected value set should be displayed
    When User clicks on "Delete" button
    Then 'Delete Value Set' pop up window should be displayed
    Then 'Are you sure you want to delete the value set?' text on pop up window should be displayed
    Then "No" and "Yes" buttons should be displayed
    When User clicks on "No" button
    Then 'Delete Value Set' pop up window should be closed
    Then the selected value set should not be removed
    Then the selected value set should be displayed in the actual list of Value Set
    When User click on "Delete" button
    Then 'Delete Value Set' pop up window should be displayed
    When User clicks on "Yes" button
    Then the selected value set should be removed from the actual list of Value Set
    Then the selected value set should not be displayed in the actual list of Value Set

  @notimplemented
  Scenario: Delete Value Set in 'Values' tab
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Value Set link under Administration section on the Control Center panel
    Then Value Set tab should be displayed
    When User clicks on any value set from the actual list of Value Set
    Then selected value set should be highlighted in blue
    Then 'General' tab of the selected value set should be displayed
    When User clicks on 'Values' tab
    Then 'Values' tab should be displayed
    Then active "+ Add" button on the top right should be displayed
    Then active "Delete" button on the top right should be displayed
    When User click on "Delete" button on the top right
    Then 'Delete Value Set' pop up window should be displayed
    Then 'Are you sure you want to delete the value set?' text on pop up window should be displayed
    Then "No" and "Yes" buttons should be displayed
    When User clicks on "No" button
    Then 'Delete Value Set' pop up window should be closed
    Then the selected value set should not be removed
    Then the selected value set should be displayed in the actual list of Value Set
    When User click on "Delete" button
    Then 'Delete Value Set' pop up window should be displayed
    When User clicks on "Yes" button
    Then the selected value set should be removed
    Then the selected value set should not be displayed in the actual list of Value Set
    When User selects Uuid data type from Data Type dropdown list
    Then Uuid data type should be displayed
    When User clicks on Yes button
    Then the created value set with Uuid data type should be saved

  @notimplemented
  Scenario: Add value in Value Set
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Value Set link under Administration section on the Control Center panel
    Then Value Set tab should be displayed
    When User clicks on any value set from the actual list of Value Set
    Then selected value set should be highlighted in blue
    Then General tab of the selected value set should be displayed
    When User clicks on Values tab
    Then Values tab should be displayed
    When User clicks on Add button
    Then Add Value popup window should be displayed
    Then Name field should be displayed as a required
    Then Value field should be displayed as a required
    Then No and Yes buttons should be displayed
    When User enters some characters in Name field
    Then the entered characters in Name field should be displayed
    When User enters some characters in Value field
    Then the entered characters in Value field should be displayed
    When User clicks on No button
    Then Add Value popup window should be closed and changes should not be saved
    When User clicks on Add button
    Then Add Value popup window should be displayed
    When User enters some characters in Name field
    Then the entered characters in Name field should be displayed
    When User enters some characters in Value field
    Then the entered characters in Value field should be displayed
    When User clicks on Yes button
    Then Add Value popup window should be closed and the created value should be saved

  @notimplemented
  Scenario: Edit value in Value Set
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Value Set link under Administration section on the Control Center panel
    Then Value Set tab should be displayed
    When User clicks on any value set from the actual list of Value Set which at least has one value
    Then selected value set should be highlighted in blue
    Then General tab of the selected value set should be displayed
    When User clicks on Values tab
    Then Values tab should be displayed
    Then the value table should be displayed
    When User clicks on any value from the value table
    Then the selected value should be highlighted in grey
    When User clicks on Edit button
    Then Edit Value popup window should be displayed
    Then Name field should be filled and marked as required
    Then Value field should be filled and marked as required
    Then No and Yes buttons should be displayed
    When User changes any characters in Name field
    Then the entered characters in Name field should be displayed
    When User changes any characters in Value field
    Then the entered characters in Value field should be displayed
    When User clicks on No button
    Then Edit Value popup window should be closed and changes should not be saved
    When User clicks on Edit button
    Then Edit Value popup window should be displayed
    When User changes any characters in Name field
    Then the entered characters in Name field should be displayed
    When User changes any characters in Value field
    Then the entered characters in Value field should be displayed
    When User clicks on Yes button
    Then Edit Value popup window should be closed and value should be displayed with changes

  @notimplemented
  Scenario: Delete value in Value Set
    Given Landing page is displayed
    When User clicks on Control Center icon
    Then Control Center Home page should be displayed
    When User clicks on Value Set link under Administration section on the Control Center panel
    Then Value Set tab should be displayed
    When User clicks on any value set from the actual list of Value Set which at least has one value
    Then selected value set should be highlighted in blue
    Then General tab of the selected value set should be displayed
    When User clicks on Values tab
    Then Values tab should be displayed
    Then the value table should be displayed
    When User clicks on any value from the value table
    Then the selected value should be highlighted in grey
    When User clicks on "Delete" button
    Then the selected value should be deleted and not displayed in the value table
    When User clicks on Delete button
    Then the selected value should be deleted and not displayed in the value table