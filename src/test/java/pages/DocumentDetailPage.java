package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import configuration.ClassSelectors;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static configuration.AppConstants.*;
import static configuration.TagSelectors.IDM_ADD_FILE;
import static configuration.XPathSelectors.*;

public class DocumentDetailPage extends BasePage {

    public static String documentName;

    public void verifyImageExists() {
        $(By.xpath(RESOURCE_IMAGE_CONTAINER))
                .waitUntil(exist, ASYNC_TIMEOUT);
        $(By.xpath(PREVIEW)).waitUntil(exist, ASYNC_TIMEOUT)
                .should(exist);
    }

    public void verifyImageFilename(String fileName) {
        $(By.className(ClassSelectors.FILE_NAME)).shouldHave(text(fileName));
    }

    private void switchToFileTab() {
        $(By.xpath(DOCUMENT_FILE_TAB_LINK)).click();
        $(By.tagName(IDM_ADD_FILE)).waitUntil(visible, ASYNC_TIMEOUT);
    }

    public void switchToPropertiesTab() {
        $(By.xpath(DOCUMENT_TAB_PROPERTIES)).click();
        $(By.xpath(PROPERTIES_TAB)).waitUntil(visible, DEFAULT_TIMEOUT);
    }


    public void uploadFileToDocument(String filename) {
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        switchToFileTab();
        SelenideElement input = $(By.xpath(FILE_UPLOAD_INPUT));
        input.sendKeys(filename);
    }

    public void verifyDocumentTabExists(int noOfTabs) {
        $$(By.xpath(DOCUMENT_TAB_LIST)).shouldHaveSize(noOfTabs);
        switchToAttributesTab();
    }

    public SelenideElement getCheckedOutBadgeContainer() {
        return $(By.className(ClassSelectors.CHECKED_OUT_BADGE_CONTAINER));
    }

    public SelenideElement getFavoritesBadgeContainer() {
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        return $(By.className(ClassSelectors.FAVORITES_BADGE_CONTAINER));
    }

    private void switchToAttributesTab() {
        $(By.xpath(DOCUMENT_TAB_ATTRIBUTES)).waitUntil(visible, ASYNC_TIMEOUT)
                .click();
        $(By.xpath(ATTRIBUTES_TAB)).waitUntil(visible, DEFAULT_TIMEOUT);
    }

    private void generateRandomDocumentName() {
        documentName = String.format("%s_%s", AppConstants.DOCUMENT_NAME_PREFIX,
                RandomStringUtils.random(5, true, false));
    }

    public void setNewDocumentNameCopy() {
        switchToAttributesTab();
        getDocumentAttributesFormFieldByPartialID(ATTRIBUTES_NAME_TEXT)
                .setValue(documentName + DOCUMENT_NAME_PREFIX_COPY);
    }

    public void setNewDocumentName() {
        switchToAttributesTab();
        generateRandomDocumentName();
        getDocumentAttributesFormFieldByPartialID(ATTRIBUTES_NAME_TEXT)
                .setValue(documentName);
    }

    public void setMappingValue() {
        switchToAttributesTab();
        getDocumentAttributesFormFieldByPartialID(ATTRIBUTES_NAME_TEXT)
                .setValue(mappingValue);
    }

    public void switchToSecurityTab() {
        $(By.xpath(DOCUMENT_TAB_SECURITY)).waitUntil(visible, ASYNC_TIMEOUT)
                .click();
    }

    public SelenideElement getACL() {
        switchToSecurityTab();
        return $(By.xpath(SECURITY_TAB_ACL)).waitUntil(exist, DEFAULT_TIMEOUT);
    }

    public void addShortValue(String value) {
        switchToAttributesTab();
        getDocumentAttributesFormFieldByPartialID(SHORT_ATTRIBUTE_NAME).setValue(value);
    }

    public void addLongValue(String value) {
        switchToAttributesTab();
        getDocumentAttributesFormFieldByPartialID(LONG_ATTRIBUTE_NAME).setValue(value);
    }

    public void addDecimalValue(String value) {
        switchToAttributesTab();
        getDocumentAttributesFormFieldByPartialID(DECIMAL_ATTRIBUTE_NAME).setValue(value);
    }

    public void addDateValue(String value) {
        switchToAttributesTab();
        setValueForPickerValueField(DATE_ATTRIBUTE_NAME, value);
    }

    public void addTimeValue(String value) {
        switchToAttributesTab();
        setValueForPickerValueField(TIME_ATTRIBUTE_NAME, value);
    }

    public void addTimestampValue(String value) {
        switchToAttributesTab();
        setValueForPickerValueField(TIMESTAMP_ATTRIBUTE_NAME, value);
    }

    public void addDoubleValue(String value) {
        switchToAttributesTab();
        getDocumentAttributesFormFieldByPartialID(DOUBLE_ATTRIBUTE_NAME).setValue(value);
    }

    public void addGuidValue(String value) {
        switchToAttributesTab();
        getDocumentAttributesFormFieldByPartialID(GUID_ATTRIBUTE_NAME).setValue(value);
    }

    private void setValueForPickerValueField(String attribute, String value) {
        String selector = String.format(PICKER_VALUE_FIELD, attribute);
        $(By.xpath(selector)).setValue(value);
    }

    public void selectValueFromDropDown(String attribute, String value) {
        String valuesDropDown = String.format(VALUES_DROP_DOWN_ATTRIBUTE_FIELD, attribute);
        selectFromDropDown(valuesDropDown, value);
    }

    public SelenideElement getMappedValue() {
        switchToAttributesTab();
        String selector = String.format(MAPPED_RELATED_ATTRIBUTE_VALUE, ATTRIBUTE_NAME, mappingValue);
        return $(By.xpath(selector));
    }

    public void setSameDocumentName() {
        switchToAttributesTab();
        getDocumentAttributesFormFieldByPartialID(ATTRIBUTES_NAME_TEXT)
                .setValue(documentName);
    }

    public void navigateToCopy() {
        $(By.xpath(NEW_DOCUMENT_TAB)).click();
        $(By.xpath(DOCUMENT_DETAILS_LIST)).waitUntil(visible, ASYNC_TIMEOUT);
    }

    public ElementsCollection getNewDocumentTabs(){
        return $$(By.xpath(NEW_DOCUMENT_TAB));
    }
    
    public void enableTemplate() {
        $(By.xpath(ENABLE_TEMPLATE_LABEL)).click();
        $(By.xpath(TEMPLATE_NAME)).setValue(TEMPLATE_NAME_VALUE);
        $(By.xpath(TEMPLATE_DETAILS)).setValue(TEMPLATE_DETAILS_VALUE);
    }
}