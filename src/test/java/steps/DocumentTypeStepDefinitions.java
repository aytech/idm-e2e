package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.*;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.*;
import static configuration.XPathSelectors.DATATYPE_DROPDOWN;

import static pages.DocumentTypePage.documentTypeName;
import static pages.ValueSetPage.valueSetName;

public class DocumentTypeStepDefinitions extends BasePage {

    @Then("^user click on new document type button$")
    public void userClickOnNewDocumentTypeButton() {
        page(DocumentTypePage.class).clickHeaderActionButtonControlCenter(NEW_DOCUMENT_TYPE_BUTTON);
    }

    @Then("^new Document Type form is displayed$")
    public void newDocumentTypeFormIsDisplayed() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getNextButton().should(Condition.exist);
        page.getNextButton().shouldBe(Condition.enabled);
        page.getCancelButton().should(Condition.exist);
        page.getCancelButton().shouldBe(Condition.enabled);
    }

    @Then("^user fill the form with valid display name$")
    public void userFillTheFormWithValidDisplayName() {
        page(DocumentTypePage.class).setNewDocumentTypeDisplayName();
    }

    @Then("^user click on next button$")
    public void userClickOnNextButton() {
        page(DocumentTypePage.class).getNextButton().click();
    }

    @And("^user verifies Attribute page$")
    public void userVerifiesAttributePage() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getAttributeList().should(Condition.exist);
        page.getAttributeList().shouldBe(Condition.visible);
    }

    @Then("^click on add Attribute button$")
    public void clickOnAddAttributeButton() {
        page(DocumentTypePage.class).clickOnAddAttributeButton();
    }

    @Then("^Attribute form page is displayed$")
    public void attributeFormPageIsDisplayed() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getAttributeForm().should(Condition.exist);
        page.getAttributeForm().shouldBe(Condition.visible);
    }

    @Then("^user fill the form with valid Attribute display name$")
    public void userFillTheFormWithValidAttributeDisplayName() {
        page(DocumentTypePage.class).setNewAttributeDisplayName();
    }

    @And("^user selects String data type from the data type drop down$")
    public void userSelectsStringDataTypeFromTheDataTypeDropDown() {
        page(DocumentTypePage.class).selectFromDropDown(DATATYPE_DROPDOWN, STRING);
    }

    @And("^user enable the Required checkbox$")
    public void userEnableTheRequiredCheckbox() {
        page(DocumentTypePage.class).clickOnRequiredCheckbox();
    }

    @Then("^user navigates to ACL page$")
    public void userNavigatesToACLPage() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getAclTableContainer().should(Condition.exist);
        page.getAclTableContainer().shouldBe(Condition.visible);
    }

    @And("^Cancel Previous and Done buttons are displayed$")
    public void cancelPreviousAndDoneButtonsAreDisplayed() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getCancelButton().should(Condition.exist);
        page.getCancelButton().shouldBe(Condition.enabled);
        page.getPreviousButton().should(Condition.exist);
        page.getPreviousButton().shouldBe(Condition.enabled);
        page.getDoneButton().should(Condition.exist);
        page.getDoneButton().shouldBe(Condition.enabled);
    }

    @Then("^user click on done button$")
    public void userClickOnDoneButton() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getDoneButton().click();
    }

    @Then("^new document type should be saved$")
    public void newDocumentTypeShouldBeSaved() {
        page(DocumentTypePage.class).waitEntityListToBeDisplayed();
    }

    @And("^User searches for saved documentType$")
    public void userSearchesForSavedDocumentType() throws IllegalAccessException {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.waitEntityListToBeDisplayed();
        page.searchAndSelectDocumentTypeForNewDocument();
    }

    @And("^cancel button is in enabled state and next button in enabled state$")
    public void cancelButtonIsInEnabledStateAndNextButtonInEnabledState() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getNextButton().should(Condition.exist);
        page.getNextButton().shouldBe(Condition.enabled);
        page.getCancelButton().should(Condition.exist);
        page.getCancelButton().shouldBe(Condition.enabled);
    }

    @Then("^new document type should be saved and toast message is displayed$")
    public void newDocumentTypeShouldBeSavedAndToastMessageIsDisplayed() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getToastMessage().shouldBe(Condition.visible);
    }

    @And("^User deletes document type$")
    public void userDeletesDocumentType() {
        page(ControlCenterSidebarPage.class).open();
        page(ControlCenterSidebarPage.class).selectAdministrationOption(DOCUMENT_TYPE_TEXT);
        page(DocumentTypePage.class).waitEntityListToBeDisplayed();
        page(ControlCenterSidebarPage.class).closeControlCenterLeftPanel();
        DocumentTypePage page = page(DocumentTypePage.class);
        page.selectDocumentType();
        page.getGeneralTab().should(Condition.exist);
        page.getGeneralTab().should(Condition.visible);
        page.getEntityPage().should(Condition.exist);
        page.deleteDocumentType();
        page.getToastMessage().waitUntil(Condition.visible, DEFAULT_TIMEOUT);
        page.waitUntilToastMessageDisappear();
    }

    @And("^User verifies document type does not Exist$")
    public void userVerifiesDocumentTypeDoesNotExist() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.setTextSearchValueDocumentType(documentTypeName);
        page.getEntityList().shouldNot(exist);
    }

    @Then("^User opens document type configuration$")
    public void userSearchForDocumentType() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.selectDocumentType();
        page.getGeneralTab().should(Condition.exist);
        page.getGeneralTab().should(Condition.visible);
    }

    @Then("^User navigates to Attribute page$")
    public void userNavigatesToAttributePage() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.navigateToAttributesTab();
    }

    @Then("^user adds short attribute$")
    public void userAddsShortAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.clickOnAddAttributeButton();
        page.setAttributeDisplayName(SHORT_ATTRIBUTE_NAME);
        page.selectFromDropDown(DATATYPE_DROPDOWN, SHORT);
        page.clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }

    @Then("^User clicks on Save Changes button$")
    public void userClicksOnSaveChangesButton() {
        page(DocumentTypePage.class).clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }

    @Then("^user adds long attribute$")
    public void userAddsLongAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.clickOnAddAttributeButton();
        page.setAttributeDisplayName(LONG_ATTRIBUTE_NAME);
        page.selectFromDropDown(DATATYPE_DROPDOWN, LONG);
        page.clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }

    @Then("^Changes Saved toast message should be displayed$")
    public void DocumentTypeShouldBeSavedAndToastMessageIsDisplayed() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getToastMessage().shouldBe(Condition.visible);
        page.getToastMessage().waitUntil(Condition.disappears, ASYNC_TIMEOUT);
        page.waitUntilToastMessageDisappear();
    }

    @And("^User verifies that short attribute is added$")
    public void userChecksForShortAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getAttribute(SHORT_ATTRIBUTE_NAME).should(Condition.exist);
        page.getAttribute(SHORT_ATTRIBUTE_NAME).shouldBe(Condition.visible);
    }

    @Then("^user adds decimal attribute$")
    public void userAddsDecimalAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.clickOnAddAttributeButton();
        page.setAttributeDisplayName(DECIMAL_ATTRIBUTE_NAME);
        page.selectFromDropDown(DATATYPE_DROPDOWN, DECIMAL);
        page.clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }

    @Then("^user adds date attribute$")
    public void userAddsDateAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.clickOnAddAttributeButton();
        page.setAttributeDisplayName(DATE_ATTRIBUTE_NAME);
        page.selectFromDropDown(DATATYPE_DROPDOWN, DATE);
        page.clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }


    @Then("^user adds time attribute$")
    public void userAddsTimeAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.clickOnAddAttributeButton();
        page.setAttributeDisplayName(TIME_ATTRIBUTE_NAME);
        page.selectFromDropDown(DATATYPE_DROPDOWN, TIME);
        page.clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }

    @Then("^user adds timestamp attribute$")
    public void userFillTheFormWithValidTimestampAttributeDisplayName() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.clickOnAddAttributeButton();
        page.setAttributeDisplayName(TIMESTAMP_ATTRIBUTE_NAME);
        page.selectFromDropDown(DATATYPE_DROPDOWN, TIMESTAMP);
        page.clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }

    @Then("^user adds double attribute$")
    public void userFillTheFormWithValidDoubleAttributeDisplayName() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.clickOnAddAttributeButton();
        page.setAttributeDisplayName(DOUBLE_ATTRIBUTE_NAME);
        page.selectFromDropDown(DATATYPE_DROPDOWN, DOUBLE);
        page.clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }

    @Then("^user adds boolean attribute$")
    public void userFillTheFormWithValidBooleanAttributeDisplayName() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.clickOnAddAttributeButton();
        page.setAttributeDisplayName(BOOLEAN_ATTRIBUTE_NAME);
        page.selectFromDropDown(DATATYPE_DROPDOWN, BOOLEAN);
        page.clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }

    @Then("^user adds GUID attribute$")
    public void userFillTheFormWithValidGuidAttributeDisplayName() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.clickOnAddAttributeButton();
        page.setAttributeDisplayName(GUID_ATTRIBUTE_NAME);
        page.selectFromDropDown(DATATYPE_DROPDOWN, GUID);
        page.clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }

    @Then("^user adds Valueset attribute$")
    public void userFillTheFormWithValidValueSetAttributeDisplayName() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.clickOnAddAttributeButton();
        page.setAttributeDisplayName(VALUESET_ATTRIBUTE_NAME);
        page.selectFromDropDown(DATATYPE_DROPDOWN, VALUE_SET_TEXT);
        page.selectFromDropDown(VALUE_SET_DROPDOWN_DOCUMENT_TYPE, valueSetName);
        page.clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }

    @And("^User verifies that long attribute is added$")
    public void userChecksForLongAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getAttribute(LONG_ATTRIBUTE_NAME).should(Condition.exist);
        page.getAttribute(LONG_ATTRIBUTE_NAME).shouldBe(Condition.visible);
    }

    @And("^User verifies that decimal attribute is added$")
    public void userChecksForDecimalAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getAttribute(DECIMAL_ATTRIBUTE_NAME).should(Condition.exist);
        page.getAttribute(DECIMAL_ATTRIBUTE_NAME).shouldBe(Condition.visible);
    }

    @And("^User verifies that date attribute is added$")
    public void userChecksForDateAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getAttribute(DATE_ATTRIBUTE_NAME).should(Condition.exist);
        page.getAttribute(DATE_ATTRIBUTE_NAME).shouldBe(Condition.visible);
    }

    @And("^User verifies that Time attribute is added$")
    public void userChecksForTimeAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getAttribute(TIME_ATTRIBUTE_NAME).should(Condition.exist);
        page.getAttribute(TIME_ATTRIBUTE_NAME).shouldBe(Condition.visible);
    }

    @And("^User verifies that Timestamp attribute is added$")
    public void userChecksForTimestampAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getAttribute(TIMESTAMP_ATTRIBUTE_NAME).should(Condition.exist);
        page.getAttribute(TIMESTAMP_ATTRIBUTE_NAME).shouldBe(Condition.visible);
    }

    @And("^User verifies that Double attribute is added$")
    public void userChecksForDoubleAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getAttribute(DOUBLE_ATTRIBUTE_NAME).should(Condition.exist);
        page.getAttribute(DOUBLE_ATTRIBUTE_NAME).shouldBe(Condition.visible);
    }

    @And("^User verifies that Boolean attribute is added$")
    public void userChecksForBooleanAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getAttribute(BOOLEAN_ATTRIBUTE_NAME).should(Condition.exist);
        page.getAttribute(BOOLEAN_ATTRIBUTE_NAME).shouldBe(Condition.visible);
    }

    @And("^User verifies that GUID attribute is added$")
    public void userChecksForGUIDAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getAttribute(GUID_ATTRIBUTE_NAME).should(Condition.exist);
        page.getAttribute(GUID_ATTRIBUTE_NAME).shouldBe(Condition.visible);
    }

    @And("^User verifies that Valueset attribute is added$")
    public void userChecksForValueSetAttribute() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getAttribute(VALUESET_ATTRIBUTE_NAME).should(Condition.exist);
        page.getAttribute(VALUESET_ATTRIBUTE_NAME).shouldBe(Condition.visible);
    }

    @Then("^User verifies document type Exists$")
    public void userVerifiesDocumentTypeExists() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.waitEntityListToBeDisplayed();
        page.setTextSearchValueDocumentType(documentTypeName);
        page.getEntityList().shouldHave(Condition.exactText(documentTypeName));
    }

    @Then("^User navigates to ACL page$")
    public void userNavigatesToAclPage() {
        page(DocumentTypePage.class).navigateToACLPage();
        page(DocumentTypePage.class).getAclTableContainer();
    }

    @Then("^User opens new ACL form$")
    public void userClickingOnAddAclButton() {
        page(DocumentTypePage.class).clickAddAclButton();
    }

    @Then("^User fills the form for the new acl$")
    public void userFillingNewAclForm() {
        page(DocumentTypePage.class).addNewACL(ROLE_ADMINISTRATOR);
    }

    @Then("^User verifies new ACL was created successfully$")
    public void userCheckingForAcl() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getDefaultAcl().shouldHave(Condition.matchesText(ACL_NAME));
    }

    @And("^User set new ACL as default ACL$")
    public void userSetNewAclAsDefaultAcl() {
        page(DocumentTypePage.class).setAsDefaultAcl();
    }

    @Then("^User closes expanded Control Center navigation panel$")
    public void userClosesControlCenterNavigationPanel() {
        page(ControlCenterSidebarPage.class).closeControlCenterLeftPanel();
    }

    @Then("^User navigates to ACL Rules tab$")
    public void userNavigatesToAclRulesTab() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.navigateToACLRulesTab();
        page.getACLRulesPage().should(Condition.exist);
        page.getACLRulesPage().shouldBe(Condition.visible);
    }

    @Then("^User verifies the ACL Rules of the document type$")
    public void userChecksForACLRule() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getRule().should(Condition.exist);
        page.getRule().shouldBe(Condition.visible);
    }

    @Then("^User creates a new document type$")
    public void userCreatesANewDocumentType() throws InterruptedException {
        page(SearchPage.class).openControlCenter();
        page(ControlCenterHomePage.class).clickLink(DOCUMENT_TYPE_TEXT);
        page(DocumentTypePage.class).waitEntityListToBeDisplayed();
        page(DocumentTypePage.class).createDocumentType();
    }

    @Then("^User navigates to IDM search page$")
    public void userNavigatesBackToClient() {
        page(DocumentTypePage.class).clickHeaderActionButtonControlCenter(BACK_TO_DOCUMENTS_BUTTON);
        page(SearchPage.class).waitTillRendered();
    }

    @Then("^User navigates to Related Documents tab$")
    public void userNavigatesToRelatedDocumentsRulesTab() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.navigateToRelatedDocumentsRulesTab();
        page.getRelatedDocumentsPage().should(Condition.exist);
        page.getRelatedDocumentsPage().shouldBe(Condition.visible);
    }

    @Then("^User verifies the Related Documents Rule of the document type$")
    public void userChecksForRelatedDocumentsRule() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.getRule().should(Condition.exist);
        page.getRule().shouldBe(Condition.visible);
    }

    @And("^Verify that Acl Rule is applied$")
    public void userVerifiesAppliedAclRule() {
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.getACL().shouldBe(Condition.visible);
        page.getACL().shouldHave(Condition.exactText(ACL_NAME));
    }

    @And("^Verify the document ACL$")
    public void userVerifiesAppliedAcl() {
        DocumentDetailPage page = page(DocumentDetailPage.class);
        page.getACL().shouldBe(Condition.visible);
        page.getACL().shouldHave(Condition.exactText(ACL_NAME));
    }

    @Then("^User creates a copy of the opened document type$")
    public void userCopiesTheDocumentType() {
        page(DocumentTypePage.class).copyDocumentType();
    }

    @Then("^User verifies all attributes exist in the copy of the document type$")
    public void userVerifiesTheCopiedDocumentType() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.selectCopiedDocumentType();
        page.navigateToAttributesTab();
        page.getAttribute(SHORT_ATTRIBUTE_NAME).should(Condition.exist).shouldBe(Condition.visible);
        page.getAttribute(LONG_ATTRIBUTE_NAME).should(Condition.exist).shouldBe(Condition.visible);
        page.getAttribute(DECIMAL_ATTRIBUTE_NAME).should(Condition.exist).shouldBe(Condition.visible);
        page.getAttribute(DATE_ATTRIBUTE_NAME).should(Condition.exist).shouldBe(Condition.visible);
        page.getAttribute(TIME_ATTRIBUTE_NAME).should(Condition.exist).shouldBe(Condition.visible);
        page.getAttribute(DOUBLE_ATTRIBUTE_NAME).should(Condition.exist).shouldBe(Condition.visible);
        page.getAttribute(BOOLEAN_ATTRIBUTE_NAME).should(Condition.exist).shouldBe(Condition.visible);
        page.getAttribute(GUID_ATTRIBUTE_NAME).should(Condition.exist).shouldBe(Condition.visible);
        page.getAttribute(VALUESET_ATTRIBUTE_NAME).should(Condition.exist).shouldBe(Condition.visible);
    }

    @And("^User removes the copy$")
    public void userDeletesCopiedDocumentType() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.deleteDocumentType();
        page.getToastMessage().waitUntil(Condition.visible, DEFAULT_TIMEOUT);
        page.waitUntilToastMessageDisappear();
        page.setTextSearchValueDocumentType(documentTypeName + "_Copy");
        page.getEntityList().shouldNot(exist);
    }

    @And("^User Verifies the related documents$")
    public void userVerifiesTheRelatedDocuments() {
        RelatedInformationPage page = page(RelatedInformationPage.class);
        page.openRelationInformationWidget();
        page.switchToRelationInformationFrame();
        page.getRelatedDocumentList().waitUntil(visible, DEFAULT_TIMEOUT);
        page.showInIDM();
        page(DocumentDetailPage.class).switchToClientFrame();
        page(DocumentDetailPage.class).getMappedValue().should(exist);
    }

    @Then("^User adds Related Documents Rule$")
    public void userAddsRelatedDocumentsRule() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.addRelatedDocumentsRule();
        page.fillRelatedDocumentsRuleForm();
        page.setMappingAttributeValue();
        page.clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }

    @Then("^User adds ACL Rule$")
    public void userAddsACLRule() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.addACLRule();
        page.fillAclRuleForm();
        page.setMappingAttributeValue();
        page.clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }

    @Then("^User enable Template in document type$")
    public void userEnableTemplateInDocumentType() {
        DocumentTypePage page = page(DocumentTypePage.class);
        page.clickOnTemplateCheckbox();
        page.clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
        page.getToastMessage().shouldBe(Condition.visible);
        page.getToastMessage().waitUntil(Condition.disappears, ASYNC_TIMEOUT);
        page.waitUntilToastMessageDisappear();
    }
}