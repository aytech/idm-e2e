package steps;

import configuration.Configuration;
import configuration.SystemConfiguration;
import cucumber.api.java.en.Then;
import pages.*;

import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.*;

public class IONConfigurationStepDefinitions {

    @Then("^user creates Status ValueSet$")
    public void userCreatesStatusValueSet() {
        page(ControlCenterHomePage.class).clickLink(VALUE_SET_TEXT);
        page(ValueSetPage.class).addStatusValueSet(SHORT);
    }

    @Then("^User creates document type with Status ValueSet attribute$")
    public void userCreatesDocumentTypeWithValueSetAttribute() {
        page(ControlCenterHomePage.class).clickLink(DOCUMENT_TYPE_TEXT);
        page(DocumentTypePage.class).waitEntityListToBeDisplayed();
        page(DocumentTypePage.class).createDocumentType();
        page(DocumentTypePage.class).addingStatusValueSetAttribute();
    }

    @Then("^User adds workflow to newly created document type$")
    public void userCreatesWorkflowForNewlyCreatedDocumentType() {
        page(IONConfigurationPage.class).addWorkflowConfiguration(INBOUND_WF);
    }

    @Then("^User adds a document and verifies status$")
    public void userAddsNewDocumentAndVerifyStatusOfTheDocumentWhenWorkflowIsTriggered() {
        page(AddDocumentPage.class).addDocumentForNewlyCreatedDocumentType();
        page(DocumentDetailPage.class).uploadFileToDocument(SystemConfiguration.filePath);
        page(IONConfigurationPage.class).setStatus(DRAFT);
        page(DocumentDetailActionBarPage.class).saveDocument();
        page(IONConfigurationPage.class).switchToAttributesTab();
        page(IONConfigurationPage.class).triggerWorkflow();
        page(DocumentDetailActionBarPage.class).refreshDocumentUntilStatusChanges();
        page(IONConfigurationPage.class).verifyStatusOfTheAttribute();
    }
}