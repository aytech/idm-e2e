Feature: Security Audit Log

  Background:
    Given User is on index page

  @smoke @SecurityAuditLog
  Scenario: Document type security audit logging
    Given Search component is rendered
    Then User creates a new document type
    Then User navigates to Security Audit Log configuration page
    Then User enables Security Audit Log
    Then User adds and verifies DocumentType under audit logging
    Then User moves and verifies DocumentType under Not logged Document Types
    And User deletes document type
    Then User verifies document type does not Exist