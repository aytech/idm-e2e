Feature:Business Context Model

  Background:
    Given User is on index page

  Scenario: Adding a Business Context Model
    Given Control Center Icon is displayed
    When User click on Control Center Icon
    Then Control Center Homepage should be displayed
    Then User clicks on Business Context Model under Configuration
    Then Business Context Model Page Should be displayed
    Then User clicks on Add button
    Then User fills the form in Add Business Context Model popup
    Then User clicks on OK button in Add Business Context Model
    Then Verify for the newly added Business Context Model
    And Verify its reflection in Client

  Scenario: Editing a Business Context Model
    Given Control Center Icon is displayed
    When User click on Control Center Icon
    Then Control Center Homepage should be displayed
    Then User clicks on Business Context Model under Configuration
    Then Business Context Model Page Should be displayed
    Then User selects any Business Context Model
    Then User clicks on Edit button
    Then User Edit the form in Edit Business Context Model popup
    Then User clicks on OK button in Edit Business Context Model
    Then Verify for the Edited Business Context Model
    And Verify its reflection in Client

  Scenario: Deleting a Business Context Model
    Given Control Center Icon is displayed
    When User click on Control Center Icon
    Then Control Center Homepage should be displayed
    Then User clicks on Business Context Model under Configuration
    Then Business Context Model Page Should be displayed
    Then User selects any Business Context Model
    Then User clicks on Delete button
    Then User clicks on Yes button in Delete popup
    Then Verify for the Deleted Business Context Model
    And Verify its reflection in Client