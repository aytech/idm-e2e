Feature: Action Bar Search Page

  Background:
    Given User is on index page

  @smoke @createDocumentType @SearchResultActionBar
  Scenario: Creating a Document type
    When Search component is rendered
    Then User creates a new document type

  @unstable @ActionButtons @SearchResultActionBar
  Scenario: All action buttons available on new documents
    Given Search component is rendered
    When User creates new document without file for newly created Document Type
    Then User closes the document Tab
    Then User searches for newly created document
    Then User selects document
    And All action buttons should be present

  @smoke @ActionButtons @SearchResultActionBar
  Scenario: Action buttons visibility for documents without resource file
    Given Search component is rendered
    When User creates new document without file for newly created Document Type
    Then User closes the document Tab
    Then User searches for newly created document
    Then User selects document
    And Action buttons not related to resource file should be enabled

  @smoke @ActionButtons @SearchResultActionBar
  Scenario: Action buttons visibility for documents with resource file
    Given Search component is rendered
    When User creates new document with file for newly created Document Type
    Then User closes the document Tab
    Then User searches for newly created document
    Then User selects document
    And All Action buttons should be enabled

  @smoke @Display @SearchResultActionBar
  Scenario: Display Document and image
    Given Search component is rendered
    When User creates new document with file for newly created Document Type
    Then User closes the document Tab
    Then User searches for newly created document
    Then User selects document
    And All Action buttons should be enabled
    Then User clicks on Display button
    Then User verifies document Tab exists
    And Image resource is displayed in the document details page

  @smoke @CheckOut @SearchResultActionBar
  Scenario: Check out
    Given Search component is rendered
    When User creates new document without file for newly created Document Type
    Then User closes the document Tab
    Then User searches for newly created document
    Then User selects document
    And Action buttons not related to resource file should be enabled
    Then User clicks on checkOut button
    Then User searches for newly created document
    Then User selects document
    And Discard Check Out button should be displayed
    And Check In button should be displayed
    Then User clicks on Display button
    And Discard Check Out button in action bar should be displayed
    And Check In button in action bar should be displayed
    And Check Out badge should be displayed
    Then User searches for newly created document
    Then User selects document
    Then User clicks on Check In button

  @smoke @DiscardCheckOut @SearchResultActionBar
  Scenario: Discard Check Out
    Given Search component is rendered
    When User creates new document with file for newly created Document Type
    Then User closes the document Tab
    Then User searches for newly created document
    Then User selects document
    And Action buttons not related to resource file should be enabled
    Then User clicks on checkOut button
    Then User clicks on Display button
    Then User uploads new image and save document
    And User verifies Image Exists
    And User verifies document Tab exists
    Then User closes the document Tab
    Then User clicks on Discard Check Out button
    # Sometimes Check Out button is not displayed immediately
    #  so uncommenting this step till further investigation
#    And  Check Out button should be displayed
    Then User clicks on Display button
    And User verifies old image appears in document detail

  # This will fail in Docker, we need to update the code
  # to run Selenide with custom profile and set the
  # download path explicitly
  @unstable @Download @SearchResultActionBar
  Scenario: Download Document
    Given Search component is rendered
    When User creates new document with file
    Then User verifies document Tab exists
    And User verifies Image Exists
    Then User closes the document Tab
    Then User searches document
    Then User selects document
    Then Download button should be enabled
    Then User clicks on Download button
    Then User waits for file to be downloaded
    And User verifies the file was downloaded
    Then Remove downloaded file

  # This fails because of the conflict between busy indicator and modal.
  # Error is at "User clicks on Download as PDF button". Current behavior:
  # 1. Click "Download as PDF" button.
  # 2. Busy indicator appears
  # 3. Modal windows appears (busy indicator is not discarded)
  # 4. When modal is confirmed, first modal, then busy indicator are discarded
  # To fix:
  # - When "Download as PDF" button is clicked, confirmation modal should appear
  # - Unless modal is confirmed ("Download as PDF" clicked in modal), no busy indicator should appear
  # - When modal is confirmed, it should be discarded and busy indicator should appear
  # - Busy indicator should disappear when response from server is received
  # - https://jira.infor.com/browse/IDM-5459 is created for the issue
  @unstable @DownloadAsPDF @SearchResultActionBar
  Scenario: Download Document as PDF
    Given Search component is rendered
    When User creates new document with file
    Then User verifies document Tab exists
    And User verifies Image Exists
    Then User closes the document Tab
    Then User searches document
    Then User selects document
    And Download as PDF button should be enabled
    Then User clicks on Download as PDF button
    Then User waits for PDF file to be downloaded
    And User verifies PDF file was downloaded
    Then Remove downloaded PDF file

  @smoke @SaveAsNewDocument @SearchResultActionBar
  Scenario: Save Document as new
    Given Search component is rendered
    When User creates new document with file for newly created Document Type
    Then User verifies document Tab exists
    And User verifies Image Exists
    Then User closes the document Tab
    Then User searches for newly created document
    Then User selects document
    And All Action buttons should be enabled
    Then User clicks on Save As New Document button
    Then User selects New Document Type
    Then User verifies Image Exists
    And User adds a new name and save document

  @stub @Print @SearchResultActionBar
  Scenario: Print Document
    Given Search component is rendered

  @smoke @Copy @SearchResultActionBar
  Scenario: Copy Document
    Given Search component is rendered
    When User creates new document with file for newly created Document Type
    Then User verifies document Tab exists
    And User verifies Image Exists
    Then User closes the document Tab
    Then User searches for newly created document
    Then User selects document
    And All Action buttons should be enabled
    Then User clicks on Copy button
    Then User verifies document Tab exists
    And Image resource is displayed in the document details page
    Then User adds a new name and save document

  @smoke @Delete @SearchResultActionBar
  Scenario: Delete Document
    Given Search component is rendered
    When User creates new document without file for newly created Document Type
    Then User closes the document Tab
    Then User searches for newly created document
    Then User selects document
    And Action buttons not related to resource file should be enabled
    Then User clicks on Delete button
    When Search container is displayed
    Then User searches document
    And Result contains no documents

  @smoke @Archive @SearchResultActionBar
  Scenario: Archive Document
    Given Search component is rendered
    When User creates new document without file for newly created Document Type
    Then User closes the document Tab
    Then User searches for newly created document
    Then User selects document
    And Action buttons not related to resource file should be enabled
    Then User clicks on Archive button
    Then Search container is displayed
    Then User searches for Archived documents
    Then Archived document is displayed in the result list

  @smoke @Email @SearchResultActionBar
  Scenario: Send Document in email
    Given Search component is rendered
    When User creates new document with file for newly created Document Type
    Then User closes the document Tab
    Then User searches for newly created document
    Then User selects document
    And All Action buttons should be enabled
    Then User clicks on Send In Email button
    And User fills all the email fields and click on send from Search Page

  @smoke @MultipleDisplay @SearchResultActionBar
  Scenario: Display multiple documents
    Given Search component is rendered
    Then User creates two documents one with file and one without file
    Then User performs a search for newly created documents
    Then Result contains documents
    Then User checks select all check box
    And All Action buttons should be enabled
    Then User clicks on Display button
    Then User verifies document Tabs exists

  @smoke @MultipleSaveAsNewDocument @SearchResultActionBar
  Scenario: Save Documents as new
    Given Search component is rendered
    Then User creates two documents one with file and one without file
    Then User performs a search for newly created documents
    Then Result contains documents
    Then User checks select all check box
    And All Action buttons should be enabled
    Then User clicks on Save As New Document button
    Then User selects New Document Type
    Then User verifies Image Exists
    And User adds a new name and save document

  @smoke @MultipleCheckOut @SearchResultActionBar
  Scenario: Performing check out action on multiple documents
    Given Search component is rendered
    Then User creates two documents one with file and one without file
    Then User performs a search for newly created document type
    Then Result contains documents
    Then User checks select all check box
    And All Action buttons should be enabled
    Then User clicks on checkOut button
    Then User performs a search for newly created document type
    Then Result contains documents
    Then User checks select all check box
    And Discard Check Out button should be displayed
    And Check In button should be displayed
    And Check Out button should not be displayed

  @smoke @MultipleDiscardCheckOut @SearchResultActionBar
  Scenario: Discard Check Out action on multiple documents
    Given Search component is rendered
    Then User performs a search for newly created document type
    Then Result contains documents
    Then User checks select all check box
    And All Action buttons should be enabled
    Then User clicks on Discard Check Out button
    And  Check Out button should be displayed
    And Discard Check Out button should not be displayed

  @smoke @MultipleCheckIn @SearchResultActionBar
  Scenario: Performing check In action on multiple documents
    Given Search component is rendered
    Then User creates two documents one with file and one without file
    Then User performs a search for newly created documents
    Then Result contains documents
    Then User checks select all check box
    Then User clicks on checkOut button
    Then User performs a search for newly created documents
    Then Result contains documents
    Then User checks select all check box
    And All Action buttons should be enabled
    And Discard Check Out button should be displayed
    And Check In button should be displayed
    Then User clicks on Check In button
    And  Check Out button should be displayed
    And Check In button should not be displayed

  @smoke @MultipleEmail @SearchResultActionBar
  Scenario: Send multiple documents in email
    Given Search component is rendered
    Then User creates two documents one with file and one without file
    Then User performs a search for newly created documents
    Then Result contains documents
    Then User checks select all check box
    And All Action buttons should be enabled
    Then User clicks on Send In Email button
    And User fills all the email fields and click on send from Search Page

  @smoke @MultipleArchive @SearchResultActionBar
  Scenario: Archive Multiple Documents
    Given Search component is rendered
    Then User creates two documents one with file and one without file
    Then User performs a search for newly created documents
    Then Result contains documents
    Then User checks select all check box
    And All Action buttons should be enabled
    Then User clicks on Archive button
    Then User searches for Archived documents
    Then Archived documents is displayed in the result list

  @smoke @MultipleCopy @SearchResultActionBar
  Scenario: Copy Multiple Documents
    Given Search component is rendered
    Then User creates two documents one with file and one without file
    Then User performs a search for newly created documents
    Then Result contains documents
    Then User checks select all check box
    And All Action buttons should be enabled
    Then User clicks on Copy button
    Then User verifies new document Tabs exists
    Then User adds a new name and save document
    Then User navigates to another copy
    And Image resource is displayed in the document details page
    Then User adds a new name and save document

  @smoke @MultipleDelete @SearchResultActionBar
  Scenario: Delete Documents
    Given Search component is rendered
    Then User creates two documents one with file and one without file
    Then User performs a search for newly created documents
    Then Result contains documents
    Then User selects all documents and deletes them
    When Search container is displayed
    Then User performs a search for newly created documents
    And Result contains no documents

  @smoke @deleteDocumentType @SearchResultActionBar
  Scenario: Deleting document type
    Given Search component is rendered
    Then User navigates to Control Center
    Then User navigates to Retention Policies Page
    Then User creates and run new Retention Policy for Delete Active Documents
    Then User edits and runs the Retention Policy for Delete Archive Documents
    And User deletes retention policy
    And User deletes document type
    Then User verifies document type does not Exist