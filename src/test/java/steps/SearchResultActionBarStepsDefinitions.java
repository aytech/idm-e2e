package steps;

import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import configuration.Configuration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;
import utility.FileUtility;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.*;
import static pages.DocumentTypePage.documentTypeName;

public class SearchResultActionBarStepsDefinitions {
    @When("^User searches document$")
    public void userSearchesAndSelectDocument() throws IllegalAccessException {
        SearchPage searchPage = page(SearchPage.class);
        searchPage.selectEntityType(Configuration.getProperty(IDM_DOCUMENT_TYPE));
        searchPage.selectAttribute(AppConstants.ATTRIBUTES_NAME_TEXT);
        searchPage.selectOperation(AppConstants.EQUALS_OPERATOR);
        searchPage.setTextSearchValue(DocumentDetailPage.documentName);
        searchPage.clickSearchButton();
    }

    @And("^User selects document$")
    public void userSelectsDocument() {
        page(CardListSearchResultPage.class).selectFirstDocumentFromResultList();
    }

    @And("^User selects all documents and deletes them$")
    public void userSelectsAllDocumentsAndDeletesThem() {
        CardListSearchResultPage page = page(CardListSearchResultPage.class);
        page.selectAllDocuments();
        page.verifyActionBarButtonsAreEnabled();
        page.deleteDocument();
    }

    @And("^All action buttons should be present$")
    public void defaultButtonsInActionBarShouldBePresent() {
        page(CardListSearchResultPage.class).verifyActionBarDefaultButtonSet();
    }

    @And("^Action buttons not related to resource file should be enabled$")
    public void actionButtonsNotRelatedToResourceFileShouldBeEnabled() {
        page(CardListSearchResultPage.class).verifyActionBarButtonSetNoFileEnabled();
    }

    @And("^All Action buttons should be enabled$")
    public void allActionButtonsShouldBeEnabled() {
        page(CardListSearchResultPage.class).verifyActionBarButtonsAreEnabled();
    }

    @Then("^User clicks on Display button$")
    public void userClicksOnDisplayButton() {
        CardListSearchResultPage page = page(CardListSearchResultPage.class);
        page.verifyActionButtonDisplayed(DISPLAY_BUTTON_TEXT);
        page.displayDocument();
    }

    @Then("^User clicks on checkOut button$")
    public void userClicksOnCheckOutButton() {
        page(CardListSearchResultPage.class).checkOutDocument();
    }

    @And("^New tab with document details is opened$")
    public void newTabWithDocumentDetailsIsOpened() {
        page(DocumentDetailPage.class).verifyDocumentTabExists(3);
    }

    @And("^Image resource is displayed in the document details page$")
    public void imageResourceIsDisplayedInTheDocumentDetail() {
        page(DocumentDetailPage.class).verifyImageExists();
    }

    @And("^Discard Check Out button should be displayed$")
    public void discardCheckOutButtonShouldBeDisplayed() {
        page(CardListSearchResultPage.class).verifyActionButtonDisplayed(AppConstants.DISCARD_CHECKOUT_BUTTON_TEXT);
    }

    @Then("^User uploads new image and save document$")
    public void userUploadsNewImage() throws IllegalAccessException {
        DocumentDetailPage documentDetailPage = page(DocumentDetailPage.class);
        documentDetailPage.uploadFileToDocument(Configuration.getProperty(IDM_FILENAME_SECONDARY));
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User clicks on Discard Check Out button$")
    public void userClicksOnDiscardCheckOutButton() {
        page(CardListSearchResultPage.class).discardCheckOutDocument();
    }

    @And("^Check Out button should be displayed$")
    public void checkOutButtonShouldBeDisplayed() {
        page(CardListSearchResultPage.class).verifyActionButtonDisplayed(AppConstants.CHECKOUT_BUTTON_TEXT);
    }

    @And("^Verify new image upload was discarded and previous image is displayed$")
    public void verifyNewImageUploadWasDiscardedAndPreviousImageIsDisplayed() throws IllegalAccessException {
        page(DocumentDetailPage.class).verifyImageFilename(BasePage.getPrimaryFileName());
    }

    @And("^User verifies Image Exists$")
    public void userVerifiedImageExists() {
        page(DocumentDetailPage.class).verifyImageExists();
    }

    @And("^User verifies old image appears in document detail$")
    public void userVerifiedNoImageExists() throws IllegalAccessException {
        page(DocumentDetailPage.class).verifyImageFilename(BasePage.getPrimaryFileName());
    }

    @And("^User verifies document Tab exists$")
    public void userVerifiesDocumentTab() {
        page(DocumentDetailPage.class).verifyDocumentTabExists(2);
    }

    @Then("^User closes the document Tab$")
    public void userClosesTheDocumentTab() {
        page(TabsPage.class).closeDocumentTabs();
    }

    @And("^Check In button should be displayed$")
    public void checkInButtonShouldBeDisplayed() {
        page(CardListSearchResultPage.class).verifyActionButtonDisplayed(AppConstants.CHECK_IN_BUTTON_TEXT);
    }

    @And("^Discard Check Out button in action bar should be displayed$")
    public void discardCheckOutButtonInActionBarShouldBeDisplayed() {
        SelenideElement button =
                page(DocumentDetailActionBarPage.class).getActionButton(AppConstants.DISCARD_CHECKOUT_BUTTON_TEXT);
        assert button != null;
        button.should(exist);
    }

    @And("^Check In button in action bar should be displayed$")
    public void checkInButtonInActionBarShouldBeDisplayed() {
        SelenideElement button =
                page(DocumentDetailActionBarPage.class).getActionButton(AppConstants.CHECK_IN_BUTTON_TEXT);
        assert button != null;
        button.should(exist);
    }

    @And("^Check Out badge should be displayed$")
    public void checkOutBadgeShouldBeDisplayed() {
        page(DocumentDetailPage.class).getCheckedOutBadgeContainer().should(exist);
    }

    @Then("^User clicks on Copy button$")
    public void userClicksOnCopyButton() {
        page(CardListSearchResultPage.class).copyDocument();
    }

    @Then("^User adds a new name and save document$")
    public void userAddsANewNameAndSaveDocument() {
        page(DocumentDetailPage.class).setNewDocumentNameCopy();
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User clicks on Delete button$")
    public void userClicksOnDeleteButton() {
        page(CardListSearchResultPage.class).deleteDocument();
    }

    @Then("^User clicks on Archive button$")
    public void userClicksOnArchiveButton() {
        page(CardListSearchResultPage.class).archiveDocument();
    }

    @Then("^User clicks on Send In Email button$")
    public void userClicksOnSendInEmailButton() {
        page(CardListSearchResultPage.class).sendInEmail();
    }

    @And("^User fills all the email fields and click on send from Search Page$")
    public void userFillsAllTheEmailFieldsAndClickOnSend() throws IllegalAccessException {
        page(CardListSearchResultPage.class).fillEmailFields();
    }

    @Then("^User clicks on Save As New Document button$")
    public void userClicksOnSaveAsNewDocumentButton() {
        page(CardListSearchResultPage.class).saveAsNewDocument();
    }

    @Then("^User selects New Document Type$")
    public void userSelectsNewDocumentType() throws IllegalAccessException {
        page(CardListSearchResultPage.class).saveNewDocument();
    }

    @Then("^User clicks on Download button$")
    public void userClicksOnDownloadButton() {
        page(CardListSearchResultPage.class).downloadDocument();
    }

    @Then("^User clicks on Download as PDF button$")
    public void userClicksOnDownloadAsPdfButton() {
        page(CardListSearchResultPage.class).downloadAsPdf();
    }

    @And("^User verifies the file was downloaded$")
    public void userVerifiesDownloadedFile() throws IllegalAccessException {
        String filePath = Configuration.getProperty(IDM_FILENAME_PRIMARY);
        page(CardListSearchResultPage.class).verifyDownloadedFile(filePath);
    }

    @Then("^Download button should be enabled$")
    public void downloadButtonShouldBeEnabled() {
        page(CardListSearchResultPage.class).verifyActionButtonDisplayed(AppConstants.DOWNLOAD);
    }

    @Then("^User waits for file to be downloaded$")
    public void userWaitsForFileToBeDownloaded() throws InterruptedException, IllegalAccessException, FileNotFoundException {
        String fileNameDownloadedPath = FileUtility.getDownloadedFilePath(FileUtility.getFileNamePrimary());
        FileUtility.waitForFileToDownload(fileNameDownloadedPath);
    }

    @Then("^User waits for PDF file to be downloaded$")
    public void userWaitsForPDFFileToBeDownloaded() throws InterruptedException, FileNotFoundException, IllegalAccessException {
        String filePath = FileUtility.getDownloadedFilePath(FileUtility.getFileNamePDF());
        FileUtility.waitForFileToDownload(filePath);
    }

    @Then("^Remove downloaded file$")
    public void removeDownloadedFile() throws IllegalAccessException {
        FileUtility.removeDownloadedFile(FileUtility.getFileNamePrimary());
    }

    @And("^Download as PDF button should be enabled$")
    public void downloadAsPDFButtonShouldBeEnabled() {
        page(CardListSearchResultPage.class).verifyActionButtonDisplayed(AppConstants.DOWNLOAD_AS_PDF);
    }

    @And("^User verifies PDF file was downloaded$")
    public void userVerifiesPDFFileWasDownloaded() {
        page(CardListSearchResultPage.class).verifyDownloadedFile(FileUtility.getFileNamePDF());
    }

    @Then("^Remove downloaded PDF file$")
    public void removeDownloadedPDFFile() throws IllegalAccessException {
        FileUtility.removeDownloadedFile(FileUtility.getFileNamePDF());
    }

    @When("^User clicks on Add to Favorites button$")
    public void userClicksOnAddToFavoritesButton() {
        page(CardListSearchResultPage.class).addToFavoritesDocument();
    }

    @And("^Favorites Badge should be displayed$")
    public void favoritesBadgeShouldBeDisplayed() {
        page(DocumentDetailPage.class).getFavoritesBadgeContainer().should(exist);
    }

    @Then("^User clicks on Remove from Favorites button$")
    public void userClicksOnRemoveFromFavoritesButton() {
        page(CardListSearchResultPage.class).removeFromFavoritesDocument();
    }

    @And("^Add to favorites button is displayed$")
    public void addToFavoritesButtonIsDisplayed() {
        page(CardListSearchResultPage.class).verifyActionButtonDisplayed(AppConstants.ADD_TO_FAVORITES_BUTTON_TEXT);
    }

    @Then("^User checks select all check box$")
    public void userSelectsDocuments() {
        page(CardListSearchResultPage.class).selectAllDocuments();
    }

    @Then("^User verifies document Tabs exists$")
    public void userVerifiesDocumentTabsExists() {
        page(DocumentDetailPage.class).verifyDocumentTabExists(3);
    }

    @Then("^User searches for Archived documents$")
    public void userSearchesForArchivedDocuments() {
        SearchPage page = page(SearchPage.class);
        page.selectEntityType(documentTypeName);
        page.selectAttribute(AppConstants.ATTRIBUTES_NAME_TEXT);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setTextSearchValue(DocumentDetailPage.documentName);
        page.selectState(STATE_ARCHIVED);
        page.search();
    }

    @Then("^Archived documents is displayed in the result list$")
    public void archivedDocumentsIsDisplayedInTheResultList() {
        page(CardListSearchResultPage.class).verifyDocumentsExistsInSearchResults();
    }

    @Then("^User navigates to another copy$")
    public void userNavigatesToAnotherCopy() {
        page(DocumentDetailPage.class).navigateToCopy();
    }

    @And("^Check Out button should not be displayed$")
    public void checkOutButtonShouldNotBeDisplayed() {
        page(CardListSearchResultPage.class).getSearchActionButton(CHECKOUT_BUTTON_TEXT).shouldNot(visible);
    }

    @And("^Discard Check Out button should not be displayed$")
    public void discardCheckOutButtonShouldNotBeDisplayed() {
        page(CardListSearchResultPage.class).getSearchActionButton(DISCARD_CHECKOUT_BUTTON_TEXT).shouldNot(visible);
    }

    @Then("^User clicks on Check In button$")
    public void userClicksOnCheckInButton() {
        page(CardListSearchResultPage.class).checkInDocument();
    }

    @And("^Check In button should not be displayed$")
    public void checkInButtonShouldNotBeDisplayed() {
        page(CardListSearchResultPage.class).getSearchActionButton(CHECK_IN_BUTTON_TEXT).shouldNot(visible);
    }

    @Then("^User verifies new document Tabs exists$")
    public void userVerifiesNewDocumentTabsExists() {
       page(DocumentDetailPage.class).getNewDocumentTabs().shouldHaveSize(2);
    }
}