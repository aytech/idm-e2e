package steps;

import configuration.AppConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.DocumentDetailActionBarPage;
import pages.DocumentDetailPage;
import pages.DocumentTypePage;

import static com.codeborne.selenide.Selenide.page;

public class DocumentDetailsActionsBarStepDefinitions {

    @And("^All action buttons should be present on document details page$")
    public void defaultButtonsInActionBarShouldBePresent() {
        page(DocumentDetailActionBarPage.class).verifyActionBarButtonSetNoFileEnabled();
    }

    @And("^Action buttons not related to resource file should be enabled in document details page$")
    public void actionButtonsNotRelatedToResourceFileShouldBeEnabled() {
        page(DocumentDetailActionBarPage.class).verifyActionBarButtonSetNoFileEnabled();
    }

    @And("^All Action buttons should be enabled in document details page$")
    public void allActionButtonsShouldBeEnabled() {
        page(DocumentDetailActionBarPage.class).verifyActionBarButtonsAreEnabled();
    }

    @And("^Discard Check Out button should be displayed in document details page$")
    public void discardCheckOutButtonShouldBeDisplayed() {
        page(DocumentDetailActionBarPage.class).verifyActionButtonDisplayed(AppConstants.DISCARD_CHECKOUT_BUTTON_TEXT);
    }

    @Then("^User clicks on Download button from document details page$")
    public void userClicksOnDownloadButtonFromDocumentDetailsPage() {
        page(DocumentDetailActionBarPage.class).downloadDocument();
    }

    @Then("^User clicks on Download As Pdf button from document details page$")
    public void userClicksOnDownloadAsPdfButtonFromDocumentDetailsPage() {
        page(DocumentDetailActionBarPage.class).downloadAsPdfDocument();
    }

    @Then("^User clicks on Save As New Document button from document details page$")
    public void userClicksOnSaveAsNewDocumentButtonFromDocumentDetailsPage() {
        page(DocumentDetailActionBarPage.class).saveAsNewDocument();
    }

    @Then("^Download button should be enabled in document details page$")
    public void downloadButtonShouldBeEnabled() {
        page(DocumentDetailActionBarPage.class).verifyActionButtonDisplayed(AppConstants.DOWNLOAD);
    }

    @Then("^User clicks on Copy button from document details page$")
    public void userClicksOnCopyButtonFromDocumentDetailsPage() {
        page(DocumentDetailActionBarPage.class).copyDocument();
    }

    @Then("^Delete button should be enabled in document details page$")
    public void deleteButtonShouldBeEnabledInDocumentDetailsPage() {
        page(DocumentDetailActionBarPage.class).verifyActionButtonDisplayed(AppConstants.DELETE_BUTTON_TEXT);
    }

    @Then("^User clicks on Delete button from document details page$")
    public void userClicksOnDeleteButtonFromDocumentDetailsPage() {
        page(DocumentDetailActionBarPage.class).deleteDocument();
    }

    @Then("^Archive button should be enabled in document details page$")
    public void archiveButtonShouldBeEnabledInDocumentDetailsPage() {
        page(DocumentDetailActionBarPage.class).verifyActionButtonDisplayed(AppConstants.ARCHIVE_BUTTON_TEXT);
    }

    @Then("^User clicks on Archive button from document details page$")
    public void userClicksOnArchiveButtonFromDocumentDetailsPage() {
        page(DocumentDetailActionBarPage.class).archiveDocument();
    }

    @Then("^Send in Email button should be enabled in document details page$")
    public void sendInEmailButtonShouldBeEnabledInDocumentDetailsPage() {
        page(DocumentDetailActionBarPage.class).verifyActionButtonDisplayed(AppConstants.SEND_IN_EMAIL_BUTTON_TEXT);
    }

    @Then("^User clicks on Send In Email button from document details page$")
    public void userClicksOnSendInEmailButtonFromDocumentDetailsPage() {
        page(DocumentDetailActionBarPage.class).sendInEmail();
    }

    @And("^User verifies Email Modal Window$")
    public void userVerifiesEmailModalWindow() throws IllegalAccessException {
        DocumentDetailActionBarPage page = page(DocumentDetailActionBarPage.class);
        page.verifyEmailModal();
    }

    @And("^User fills all the email fields and click on send$")
    public void userFillsAllTheEmailFieldsAndClickOnSend() throws IllegalAccessException {
        page(DocumentDetailActionBarPage.class).fillEmailFields();
    }

    @Then("^User deletes the document which is added previously")
    public void userDeletesAddedDocument() {
        page(DocumentDetailActionBarPage.class).deleteDocument();
    }

    @Then("^User refreshes the page$")
    public void userRefreshesThePage() {
        page(DocumentDetailActionBarPage.class).refreshDocument();
    }

    @Then("^Remove from favorites button is displayed$")
    public void removeFromFavoritesButtonIsDisplayed() {
        page(DocumentDetailActionBarPage.class).verifyActionButtonDisplayed(AppConstants.REMOVE_FROM_FAVORITES_BUTTON_TEXT);
    }

    @Then("^User enables Template in document$")
    public void userEnableTemplateInDocument() {
        page(DocumentDetailActionBarPage.class).checkOutDocument();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.switchToPropertiesTab();
        page.enableTemplate();
        page(DocumentDetailActionBarPage.class).saveDocument();
        page(DocumentDetailActionBarPage.class).checkInDocument();
    }

    @And("^User checks In document from document details page$")
    public void userChecksInDocumentFromDocumentDetailsPage() {
        page(DocumentDetailActionBarPage.class).checkInDocument();
    }
}