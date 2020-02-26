Feature: ION Configuration

  Background:
    Given User is on index page

  @smoke @Workflow @IonConfiguration
  Scenario: Adding a workflow
    Given Search component is rendered
    When User navigates to Control Center
    Then user creates Status ValueSet
    Then User navigates to search page and navigates back to ControlCenter
    Then User creates document type with Status ValueSet attribute
    Then User navigates to search page and navigates back to ControlCenter
    Then User navigates to ION Configuration administration page
    Then User adds workflow to newly created document type
    Then User navigates to IDM search page
    Then User adds a document and verifies status
    When User navigates to Control Center
    Then User navigates to Retention Policies Page
    Then User creates and run new Retention Policy for Delete Active Documents
    And User deletes document type
    Then User verifies document type does not Exist
    And User deletes newly created Value Set
    Then User verifies Value Set does not Exist