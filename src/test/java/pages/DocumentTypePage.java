package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import configuration.CSSSelectors;
import configuration.IDSelectors;
import configuration.XPathSelectors;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.*;
import static pages.ValueSetPage.valueSetName;


public class DocumentTypePage extends BasePage {
    public static String documentTypeName;

    public void waitEntityListToBeDisplayed() {
        $(By.xpath(XPathSelectors.ENTITY_LIST)).waitUntil(exist, DOCUMENT_TYPE_TIMEOUT);
    }

    public void setNewDocumentTypeDisplayName() {
        generateRandomDocumentTypeName();
        $(By.xpath(DOCUMENT_TYPE_DISPLAY_NAME)).setValue(documentTypeName);
    }

    public void setNewAttributeDisplayName() {
        waitForLoadingIndicators(AppConstants.ASYNC_TIMEOUT);
        $(By.xpath(ATTRIBUTE_DISPLAY_NAME))
                .waitUntil(exist, DEFAULT_TIMEOUT)
                .setValue(AppConstants.ATTRIBUTE_NAME);
    }

    public SelenideElement getNextButton() {
        return $(By.xpath(WIZARD_NEXT));
    }

    public SelenideElement getEntityPage() {
        return $(By.xpath(DOCUMENT_TYPE_MAIN));
    }

    public SelenideElement getCancelButton() {
        return $(By.xpath(WIZARD_CANCEL));
    }

    public SelenideElement getDoneButton() {
        return $(By.xpath(WIZARD_DONE));
    }

    public SelenideElement getPreviousButton() {
        return $(By.xpath(WIZARD_PREVIOUS));
    }

    public void clickOnRequiredCheckbox() {
        $(By.xpath(ATTRIBUTE_REQUIRED_LABEL)).click();
    }

    public void clickOnTemplateCheckbox() {
        $(By.xpath(TEMPLATE_LABEL)).click();
    }

    public SelenideElement getAclTableContainer() {
        return $(By.xpath(ACL_TABLE_CONTAINER));
    }

    public SelenideElement getToastMessage() {
        waitForLoadingIndicators(DOCUMENT_TYPE_TIMEOUT);
        return $(By.xpath(XPathSelectors.TOAST_MESSAGE)).waitUntil(exist, ASYNC_TIMEOUT);
    }

    public SelenideElement getAttributeForm() {
        return $(By.id(IDSelectors.ATTRIBUTE_FORM));
    }

    public void clickOnAddAttributeButton() {
        $(By.id(IDSelectors.ADD_ATTRIBUTE)).click();
        clickButtonByText(AppConstants.CONFIRM_BUTTON_TEXT.toUpperCase());
    }

    private void clickSubHeaderButton(String buttonText) {
        for (SelenideElement actionButton : $$(By.cssSelector(CSSSelectors.ENTITY_ACTIONS))) {
            if (actionButton.text().equals(buttonText)) {
                actionButton.click();
                break;
            }
        }
        clickButtonByText(AppConstants.CONFIRM_BUTTON_TEXT.toUpperCase());
    }

    public void deleteDocumentType() {
        clickSubHeaderButton(AppConstants.DELETE_BUTTON_TEXT);
        waitForLoadingIndicators(DOCUMENT_TYPE_TIMEOUT);
    }

    public void setTextSearchValueDocumentType(String value) {
        $(By.xpath(ENTITY_SEARCH_INPUT)).setValue(value);
    }

    public SelenideElement getEntityList() {
        return $(By.xpath(ENTITY_LIST));
    }

    public void searchAndSelectDocumentTypeForNewDocument() {
        for (SelenideElement docType : $$(By.xpath(ENTITY_LIST))) {
            if (docType.getText().equals(documentTypeName)) {
                docType.click();
                break;
            }
        }
    }

    public void selectDocumentType() {
        /*
        // TODO: Dismissing error modal must be removed when the
        // https://jira.infor.com/browse/IDM-5759 is resolved
        */
        SelenideElement dialog = $(By.xpath(XPathSelectors.INFOR_MODAL));
        if (dialog.exists()) {
            clickButtonByText(CLOSE_BUTTON_TEXT);
        }
        $(By.xpath(ENTITY_SEARCH_INPUT)).click();
        $(By.xpath(ENTITY_SEARCH_INPUT)).setValue(documentTypeName);
        $(By.linkText(documentTypeName)).click();
    }

    public SelenideElement getGeneralTab() {
        return $(By.xpath(GENERAL_TAB));
    }

    public void navigateToAttributesTab() {
        $(By.linkText(IDSelectors.ATTRIBUTES_TAB)).click();
    }

    public void setAttributeDisplayName(String displayName) {
        waitForLoadingIndicators(AppConstants.ASYNC_TIMEOUT);
        $(By.xpath(ATTRIBUTE_DISPLAY_NAME))
                .waitUntil(exist, DEFAULT_TIMEOUT)
                .setValue(displayName);
    }

    public SelenideElement getAttributeList() {
        return $(By.xpath(ATTRIBUTE_LIST));
    }

    public SelenideElement getAttribute(String attributeName) {
        return $(By.linkText(attributeName));
    }

    public void navigateToACLPage() {
        $(By.linkText(ACL_TAB)).click();
    }

    public void clickAddAclButton() {
        $(By.xpath(ACL_ADD_BUTTON)).click();
    }

    private void setAclName() {
        $(By.xpath(ACL_NAME_FIELD)).setValue(ACL_NAME);
    }

    private void setAclDescription() {
        $(By.xpath(ACL_DESCRIPTION_FIELD)).setValue(ACL_DESCRIPTION);
    }

    private void expandRolesList() {
        if (!isRolesListExpanded()) {
            $(By.linkText(AppConstants.ROLES_LIST_ACL)).click();
        }
    }

    public void addNewACL(String roleText) {
        setAclName();
        setAclDescription();
        expandRolesList();
        selectFromDropDown(ROLES_LIST_DROPDOWN, roleText);
        assignPermissions();
        addRole();
        clickOkButton();
    }

    private void addRole() {
        $(By.xpath(ADDING_ROLE_BUTTON)).click();
    }

    private void clickOkButton() {
        $(By.xpath(OK_BUTTON_ACL)).click();
    }

    private boolean isRolesListExpanded() {
        return $(By.xpath(ROLES_LIST_DROPDOWN)).is(Condition.visible);
    }

    private void aclPermissions(String permissionText) {
        for (SelenideElement permission : $$(By.xpath(PERMISSIONS_CHECKBOX_ACL))) {
            if (permission.text().equals(permissionText)) {
                permission.click();
                break;
            }
        }
    }

    private void assignPermissions() {
        aclPermissions(EDIT_PERMISSION_ACL);
        aclPermissions(CREATE_PERMISSION_ACL);
        aclPermissions(DELETE_PERMISSION_ACL);
        aclPermissions(CHECKIN_PERMISSION_ACL);
        aclPermissions(CHECKOUT_PERMISSION_ACL);
        aclPermissions(CHANGE_ACL_PERMISSION_ACL);
    }

    public void createDocumentType() {
        clickHeaderActionButtonControlCenter(NEW_DOCUMENT_TYPE_BUTTON);
        setNewDocumentTypeDisplayName();
        getNextButton().click();
        getAttributeList();
        clickOnAddAttributeButton();
        getAttributeForm();
        setNewAttributeDisplayName();
        selectFromDropDown(DATATYPE_DROPDOWN, STRING);
        getNextButton().click();
        waitForLoadingIndicators(DEFAULT_TIMEOUT);
        getDoneButton().click();
        waitForLoadingIndicators(DEFAULT_TIMEOUT);
        getToastMessage();
        waitEntityListToBeDisplayed();
        sleep(SLEEP_TIMEOUT);
        setTextSearchValueDocumentType(documentTypeName);
        getEntityList().shouldHave(Condition.exactText(documentTypeName));
        selectDocumentType();
        getGeneralTab().waitUntil(visible, DEFAULT_TIMEOUT);
    }

    public void setAsDefaultAcl() {
        selectAcl();
        $(By.xpath(SET_AS_DEFAULT_ACL_BUTTON)).click();
    }

    public SelenideElement getDefaultAcl() {
        return $(By.xpath(DEFAULT_CHECK_MARK_ACL)).waitUntil(exist, ASYNC_TIMEOUT);
    }

    private void selectAcl() {
        $(By.xpath(NAME_ACL)).click();

    }

    public void navigateToACLRulesTab() {
        $(By.linkText(ACL_RULES_TAB)).click();
    }

    public SelenideElement getACLRulesPage() {
        return $(By.xpath(XPathSelectors.ACL_RULES_PAGE));
    }

    public void addACLRule() {
        $(By.xpath(XPathSelectors.ADD_ACL_RULE_BUTTON)).click();
    }

    public void fillAclRuleForm() {
        setDescription();
        selectFromDropDown(ACL_NAME_DROP_DOWN, ACL_NAME);
        selectFromDropDown(SELECT_ATTRIBUTE, ATTRIBUTES_NAME_TEXT);
        selectFromDropDown(SELECT_OPERATION, EQUALS_OPERATOR);
        selectFromDropDown(ACL_NAME_DROP_DOWN, ACL_NAME);
        selectFromDropDown(SELECT_ATTRIBUTE, ATTRIBUTES_NAME_TEXT);
        selectFromDropDown(SELECT_OPERATION, EQUALS_OPERATOR);
    }

    private void setDescription() {
        $(By.xpath(XPathSelectors.DESCRIPTION_FIELD)).setValue(AppConstants.DESCRIPTION);
    }

    public SelenideElement getRule() {
        return $(By.linkText(AppConstants.DESCRIPTION));
    }

    private void generateRandomDocumentTypeName() {
        documentTypeName = String.format(
                RandomStringUtils.random(7, true, false));
    }

    public void navigateToRelatedDocumentsRulesTab() {
        $(By.linkText(RELATED_DOCUMENTS_RULES_TAB)).click();
    }

    public SelenideElement getRelatedDocumentsPage() {
        return $(By.xpath(XPathSelectors.RELATED_DOCUMENTS_RULES_PAGE));
    }

    public void addRelatedDocumentsRule() {
        $(By.xpath(XPathSelectors.ADD_RELATED_DOCUMENTS_RULE_BUTTON)).click();
    }

    public void fillRelatedDocumentsRuleForm() {
        setDescription();
        selectFromDropDown(SELECT_ENTITY_TYPE, documentTypeName);
        selectFromDropDown(SELECT_ATTRIBUTE, ATTRIBUTES_NAME_TEXT);
        selectFromDropDown(SELECT_OPERATION, EQUALS_OPERATOR);
    }

    public void addingStatusValueSetAttribute() {
        navigateToAttributesTab();
        clickOnAddAttributeButton();
        setStatusValueSetAttributeDisplayName();
        selectFromDropDown(DATATYPE_DROPDOWN, VALUESET);
        selectFromDropDown(VALUE_SET_DROPDOWN_DOCUMENT_TYPE, valueSetName);
        clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
        waitForLoadingIndicators(DOCUMENT_TYPE_TIMEOUT);
        waitUntilToastMessageDisappear();
    }

    private void setStatusValueSetAttributeDisplayName() {
        waitForLoadingIndicators(AppConstants.ASYNC_TIMEOUT);
        $(By.xpath(ATTRIBUTE_DISPLAY_NAME))
                .waitUntil(exist, DEFAULT_TIMEOUT)
                .setValue(STATUS);
    }

    public void copyDocumentType() {
        clickSubHeaderButton(COPY_BUTTON_TEXT);
        getNextButton().click();
        getNextButton().click();
        getDoneButton().click();
        waitForLoadingIndicators(DOCUMENT_TYPE_TIMEOUT);
    }

    public void selectCopiedDocumentType() {
        /*
        // TODO: Dismissing error modal must be removed when the
        // https://jira.infor.com/browse/IDM-5759 is resolved
        */
        SelenideElement dialog = $(By.xpath(XPathSelectors.INFOR_MODAL));
        if (dialog.exists()) {
            clickButtonByText(CLOSE_BUTTON_TEXT);
        }
        $(By.xpath(ENTITY_SEARCH_INPUT)).click();
        $(By.xpath(ENTITY_SEARCH_INPUT)).setValue(documentTypeName + "_Copy");
        $(By.linkText(documentTypeName + "_Copy")).click();
    }
}