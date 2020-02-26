Feature: Document Type Filter

  Background:
    Given User is on index page

  @smoke @documentTypeFilter @addingFilter
  Scenario: Adding and Deleting Document Type Filter
    Given Search component is rendered
    When User navigates to Control Center
    Then User navigates to Document Type Filter configuration page
    Then User adds role for which the filter will be applied
    And Verify that added role is in the List
    Then User enables filter for newly added role
    Then User navigates to IDM search page
    And Verify that filter is applied in search stack
    Then User navigates to Control Center
    Then User navigates to Document Type Filter configuration page
    Then Deletes the filter
    And Verify that filter was removed from the list