Feature: System Health

Background:
    Given User is on index page

@notImplemented
  Scenario: Perform system Health Check for ALL
    Given Search component is rendered
    Given Control Center Icon is displayed
    When User clicks on Control Center Icon
    Then Control Center Menu is displayed
    Then User clicks on Health Check under System Health
    Then Health Check Page is displayed
    Then User clicks on All under Verify System.
    Then User checks for the results in ALL
    Then User verifies Grid version in Infor Grid
    Then User Verifies data in Storage
    Then User verifies Default data Model is Available
    Then User Verifies for the version of Infor Grid
    Then User Verifies if the Email is sent to the user
    Then User verifies connection with ION API is Successful
    Then User verifies data in ION

@notImplemented
  Scenario: Perform system Health for IDM
    Given Search component is rendered
    Given Control Center Icon is displayed
    When User clicks on Control Center Icon
    Then Control Center Menu is displayed
    Then User clicks on Health Check under System Health
    Then Health Check Page is displayed
    Then User clicks on IDM under Verify System.
    Then User checks for the results in IDM
    Then User verifies version in General
    Then User Verifies data in Storage
    Then User verifies Default data Model is Available
    Then User Verifies for the version of Infor Grid
    Then User Verifies if the Email is sent to the user
    Then User verifies connection with Ming.le Services is Successful
    Then User verifies connection with DOcument Output is Successful

@notImplemented
  Scenario: Perform system Health for ION
    Given Search component is rendered
    Given Control Center Icon is displayed
    When User clicks on Control Center Icon
    Then Control Center Menu is displayed
    Then User clicks on Health Check under System Health
    Then Health Check Page is displayed
    Then User clicks on IDM under Verify System.
    Then User checks for the results in ION
    Then User verifies version in General
    Then User Verifies data in Storage
    Then User verifies Default data Model is Available
    Then User Verifies for the version of Infor Grid
    Then User Verifies if the Email is sent to the user
    Then User verifies connection with ION approval Workflow is Successful

@notImplemented
  Scenario: Perform system Health for ION Api
    Given Search component is rendered
    Given Control Center Icon is displayed
    When User clicks on Control Center Icon
    Then Control Center Menu is displayed
    Then User clicks on Health Check under System Health
    Then Health Check Page is displayed
    Then User clicks on IDM under Verify System.
    Then User checks for the results in ION
    Then User verifies version in General
    Then User Verifies data in Storage
    Then User verifies Default data Model is Available
    Then User Verifies for the version of Infor Grid
    Then User Verifies if the Email is sent to the user
    Then User verifies connection with ION Api is Successful

@smoke
  Scenario: Perform Self Healing
    When User navigates to Control Center
    Then User navigates to Self Healing page
    Then User performs Self Healing
    Then User verifies result is displayed