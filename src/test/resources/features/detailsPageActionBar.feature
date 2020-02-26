Feature: Action Bar Document Details Page

  Background:
    Given User is on index page

  @smoke @ActionButtons @DocumentDetailsPage
  Scenario: All action buttons available on new documents
    Given Search component is rendered
    When User creates new document without file
    And All action buttons should be present on document details page

  @smoke @ActionButtons @DocumentDetailsPage
  Scenario: Action buttons visibility for documents without resource file
    Given Search component is rendered
    When User creates new document without file
    And Action buttons not related to resource file should be enabled in document details page

  @smoke @ActionButtons @DocumentDetailsPage
  Scenario: Action buttons visibility for documents with resource file
    Given Search component is rendered
    When User creates new document with file
    And All Action buttons should be enabled in document details page

  @smoke @checkout @DocumentDetailsPage
  Scenario: Check out
    Given Search component is rendered
    When User creates new document with file
    And Action buttons not related to resource file should be enabled in document details page
    Then User checks out new document from document details page
    Then User refreshes the page
    Then Discard Check Out button should be displayed in document details page
    And Check In button in action bar should be displayed
    And Check Out badge should be displayed

  @smoke @discardCheckoutDocumentDetails @DocumentDetailsPage
  Scenario: Discard Check Out
    Given Search component is rendered
    When User creates new document with file
    And Action buttons not related to resource file should be enabled in document details page
    Then User checks out new document from document details page
    Then User uploads new image and save document
    And User verifies Image Exists
    And User verifies document Tab exists
    Then User closes the document Tab
    Then User searches document
    Then User selects document
    Then User clicks on Discard Check Out button
    And  Check Out button should be displayed
    Then User clicks on Display button
    And User verifies old image appears in document detail

  # This will fail in Docker, we need to update the code
  # to run Selenide with custom profile and set the
  # download path explicitly
  @unstable @downloadDocumentDetails @DocumentDetailsPage1
  Scenario: Download Document
    Given Search component is rendered
    When User creates new document with file
    Then User verifies document Tab exists
    And User verifies Image Exists
    Then Download button should be enabled in document details page
    Then User clicks on Download button from document details page
    Then User waits for file to be downloaded
    And User verifies the file was downloaded
    Then Remove downloaded file

  # It is not able to remove the file
  @unstable @DownloadAsPDF @DocumentDetailsPage1
  Scenario: Download Document as PDF
    Given Search component is rendered
    When User creates new document with file
    Then User verifies document Tab exists
    Then User closes the document Tab
    Then User searches document
    Then User selects document
    Then User clicks on Display button
    Then User clicks on Download As Pdf button from document details page
    Then User waits for PDF file to be downloaded
    And User verifies PDF file was downloaded
    Then Remove downloaded PDF file

  @smoke @saveAsNewDocumentDocumentDetails @DocumentDetailsPage
  Scenario: Save Document as new
    Given Search component is rendered
    When User creates new document with file
    Then User verifies document Tab exists
    And User verifies Image Exists
    Then User closes the document Tab
    Then User searches document
    Then User selects document
    Then User clicks on Display button
    Then User clicks on Save As New Document button from document details page
    Then User selects New Document Type
    Then User verifies Image Exists
    And User adds a new name and save document

  @stub @Print  @DocumentDetailsPage1
  Scenario: Print Document
    Given Search component is rendered

  @smoke @copyDocumentDetails @DocumentDetailsPage
  Scenario: Copy Document
    Given Search component is rendered
    When User creates new document with file
    Then User verifies document Tab exists
    And User verifies Image Exists
    Then User closes the document Tab
    Then User searches document
    Then User selects document
    Then User clicks on Display button
    Then User clicks on Copy button from document details page
    And New tab with document details is opened
    And Image resource is displayed in the document details page
    Then User adds a new name and save document

  @smoke @deleteDocumentDetails @DocumentDetailsPage
  Scenario: Delete Document
    Given Search component is rendered
    When User creates new document without file
    Then User refreshes the page
    Then Delete button should be enabled in document details page
    Then User clicks on Delete button from document details page
    When Search container is displayed
    Then User searches document
    And Result contains no documents

  @smoke @archiveDocumentDetails  @DocumentDetailsPage
  Scenario: Archive Document
    Given Search component is rendered
    When User creates new document without file
    Then User refreshes the page
    Then Archive button should be enabled in document details page
    Then User clicks on Archive button from document details page
    Then Search container is displayed
    And User fills form to search document by name
    Then User selects Archived from dropdown
    And User clicks Search button
    Then Archived document is displayed in the result list

  # Fails on filling the email address
  @unstable @sendInEmail  @DocumentDetailsPage1
  Scenario: Send Document in email
    Given Search component is rendered
    When User creates new document with file
    Then User verifies document Tab exists
    And User verifies Image Exists
    Then User closes the document Tab
    Then User searches document
    Then User selects document
    Then User clicks on Display button
    Then Send in Email button should be enabled in document details page
    Then User clicks on Send In Email button from document details page
    And User verifies Email Modal Window
    And User fills all the email fields and click on send
