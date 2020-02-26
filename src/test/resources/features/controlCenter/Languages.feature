Feature: Languages


  Background:
    Given User is on index page

  @smoke @addLanguages @language
  Scenario: Add and Delete a language
    Given Search component is rendered
    Then User navigates to Control Center
    Then User navigates to Languages configuration page
    Then User adds several languages
    And Verify that added languages appear in the list
    Then User removes previously added languages
    And Verify that removed languages are not in the list