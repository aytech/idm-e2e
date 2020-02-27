package steps;

import com.codeborne.selenide.Condition;
import configuration.Configuration;
import configuration.SystemConfiguration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.SECURITY_TAB_ACL_DROP_DOWN;

public class AddDocumentStepDefinitions {

    @When("^User creates new document without file$")
    public void userCreatesNewDocumentWithoutFile() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocument();
        page(DocumentDetailPage.class)
                .setNewDocumentName();
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @When("^User creates new document with file$")
    public void userCreatesNewDocumentWithFile() {
        page(AddDocumentPage.class).addDocument();
        DocumentDetailPage documentDetailPage = page(DocumentDetailPage.class);
        documentDetailPage.uploadFileToDocument(SystemConfiguration.documentType);
        documentDetailPage.setNewDocumentName();
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^Verify the new document is in search result$")
    public void newDocumentIsInSearchResult() {
        page(CardListSearchResultPage.class).verifyDocumentExistsInSearchResults();
    }

    @Then("^Open the document$")
    public void openTheDocument() {
        page(CardListSearchResultPage.class).openDocumentFromSearchResult(DocumentDetailPage.documentName);
    }

    @And("^Verify the new document has uploaded image$")
    public void verifyTheNewDocumentHasUploadedImage() {
        page(DocumentDetailPage.class).verifyImageExists();
    }

    @Then("^User creates new document with file for newly created Document Type$")
    public void userCreatesNewDocumentWithFileForNewlyCreatedDocumentType() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage documentDetailPage = page(DocumentDetailPage.class);
        documentDetailPage.uploadFileToDocument(SystemConfiguration.filePath);
        documentDetailPage.setNewDocumentName();
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User creates new document without file for newly created Document Type$")
    public void userCreatesNewDocumentWithoutFileForNewlyCreatedDocumentType() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        page(DocumentDetailPage.class)
                .setNewDocumentName();
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User adds the document as per Acl Rule$")
    public void userAddsDocumentAsPerAclRule() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        page(DocumentDetailPage.class).setMappingValue();
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User adds a document with new ACL$")
    public void userAddsDocumentWithNewAcl() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.setNewDocumentName();
        page.switchToSecurityTab();
        page.selectFromDropDown(SECURITY_TAB_ACL_DROP_DOWN, ACL_NAME);
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User adds a document with invalid short value$")
    public void userAddsDocumentWithInvalidShortValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        page(DocumentDetailPage.class).addShortValue(INVALID_VALUE);
    }

    @Then("^User adds a document with invalid long value$")
    public void userAddsDocumentWithInvalidLongValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        page(DocumentDetailPage.class).addLongValue(INVALID_VALUE);
    }

    @Then("^User adds a document with invalid decimal value$")
    public void userAddsDocumentWithInvalidDecimalValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        page(DocumentDetailPage.class).addDecimalValue(INVALID_VALUE);
    }

    @Then("^User adds a document with invalid Date value$")
    public void userAddsDocumentWithInvalidDateValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        page(DocumentDetailPage.class).addDateValue(INVALID_VALUE);
    }

    @Then("^User adds a document with invalid Time value$")
    public void userAddsDocumentWithInvalidTimeValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        page(DocumentDetailPage.class).addTimeValue(INVALID_VALUE);
    }

    @Then("^User adds a document with invalid Timestamp value$")
    public void userAddsDocumentWithInvalidTimestampValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        page(DocumentDetailPage.class).addTimestampValue(INVALID_VALUE);
    }

    @Then("^User adds a document with invalid Double value$")
    public void userAddsDocumentWithInvalidDoubleValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        page(DocumentDetailPage.class).addDoubleValue(INVALID_VALUE);
    }

    @Then("^User adds a document with invalid GUID value$")
    public void userAddsDocumentWithInvaldiGuidValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        page(DocumentDetailPage.class).addGuidValue(INVALID_VALUE);
    }

    @Then("^User adds a document with valid GUID value$")
    public void userAddsDocumentWithGuidValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.setNewDocumentName();
        page.addGuidValue(UUID_DATA_TYPE_VALUE);
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User adds a document with valid Double value$")
    public void userAddsDocumentWithDoubleValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.setNewDocumentName();
        page.addDoubleValue(DOUBLE_DATA_TYPE_VALUE);
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User adds a document with valid Timestamp value$")
    public void userAddsDocumentWithTimestampValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.setNewDocumentName();
        page.addTimestampValue("03/13/2019, 00:00:00");
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User adds a document with valid Time value$")
    public void userAddsDocumentWithTimeValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.setNewDocumentName();
        page.addTimeValue("00:00:00");
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User adds a document with valid Date value$")
    public void userAddsDocumentWithDateValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.setNewDocumentName();
        page.addDateValue("03/13/2019");
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User adds a document with valid decimal value$")
    public void userAddsDocumentWithDecimalValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.setNewDocumentName();
        page.addDecimalValue(DECIMAL_DATA_TYPE_VALUE);
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User adds a document with valid long value$")
    public void userAddsDocumentWithLongValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.setNewDocumentName();
        page.addLongValue(LONG_DATA_TYPE_VALUE);
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User adds a document with valid short value$")
    public void userAddsDocumentWithShortValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.setNewDocumentName();
        page.addShortValue(SHORT_DATA_TYPE_VALUE);
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @And("^Verifies error tooltip for invalid short value$")
    public void validationErrorToolTipForShortValue() {
        page(AddDocumentPage.class).errorToolTips().shouldHave(Condition.matchesText("Must be a short integer"));
    }

    @And("^Verifies error tooltip for invalid long value$")
    public void validationErrorToolTipForLongValue() {
        page(AddDocumentPage.class).errorToolTips().shouldHave(Condition.matchesText("Must be a long integer"));
    }

    @And("^Verifies error tooltip for invalid decimal value$")
    public void validationErrorToolTipForDecimalValue() {
        page(AddDocumentPage.class).errorToolTips().shouldHave(Condition.matchesText("Must be a number"));
    }

    @And("^Verifies error tooltip for invalid Date value$")
    public void validationErrorToolTipForDateValue() {
        page(AddDocumentPage.class).errorToolTips().shouldHave(Condition.matchesText("Invalid date"));
    }

    @And("^Verifies error tooltip for invalid Time value$")
    public void validationErrorToolTipForTimeValue() {
        page(AddDocumentPage.class).errorToolTips().shouldHave(Condition.matchesText("Invalid time"));
    }

    @And("^Verifies error tooltip for invalid Timestamp value$")
    public void validationErrorToolTipForTimestampValue() {
        page(AddDocumentPage.class).errorToolTips().shouldHave(Condition.matchesText("Invalid date"));
    }

    @And("^Verifies error tooltip for invalid Double value$")
    public void validationErrorToolTipForDoubleValue() {
        page(AddDocumentPage.class).errorToolTips().shouldHave(Condition.matchesText("Must be a double"));
    }

    @And("^Verifies error tooltip for invalid GUID value$")
    public void validationErrorToolTipForUUIDValue() {
        page(AddDocumentPage.class).errorToolTips().shouldHave(Condition.matchesText("Must be a GUID"));
    }

    @Then("^User adds a document with true boolean value$")
    public void userAddsDocumentWithTrueBooleanValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.setNewDocumentName();
        page.selectValueFromDropDown(BOOLEAN_ATTRIBUTE_NAME, BOOLEAN_TRUE_VALUE);
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User adds a document with false boolean value$")
    public void userAddsDocumentWithFalseBooleanValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.setNewDocumentName();
        page.selectValueFromDropDown(BOOLEAN_ATTRIBUTE_NAME, BOOLEAN_FALSE_VALUE);
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User adds a document with value set value$")
    public void userAddsDocumentWithValueSetValue() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.setNewDocumentName();
        page.selectValueFromDropDown(VALUESET_ATTRIBUTE_NAME, ADDING_VALUE_NAME);
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User adds a document as per related document rule$")
    public void userAddsADocumentAsPerRelatedDocumentRule() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.uploadFileToDocument(SystemConfiguration.filePath);
        page.setMappingValue();
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User adds new document$")
    public void userAddsNewDocument() throws IllegalAccessException {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.uploadFileToDocument(SystemConfiguration.filePath);
        page.setNewDocumentName();
        page(DocumentDetailActionBarPage.class).saveDocument();
    }

    @Then("^User creates two documents one with file and one without file$")
    public void userCreatesTwoDocumentsOneWithFileAndOneWithoutFile() {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        DocumentDetailPage documentDetailPage = page(DocumentDetailPage.class);
        documentDetailPage.uploadFileToDocument(SystemConfiguration.filePath);
        documentDetailPage.setNewDocumentName();
        page(DocumentDetailActionBarPage.class).saveDocument();
        page(TabsPage.class).closeDocumentTabs();
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        documentDetailPage.setSameDocumentName();
        page(DocumentDetailActionBarPage.class).saveDocument();
        page(TabsPage.class).closeDocumentTabs();
    }
}