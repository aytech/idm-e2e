package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import configuration.Configuration;
import configuration.SystemConfiguration;
import configuration.XPathSelectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.*;
import static pages.DocumentTypePage.documentTypeName;

public class AddDocumentPage extends BasePage {

    public void clickAddDocumentButton() {
        /*
        // TODO: Dismissing error modal must be removed when the
        // https://jira.infor.com/browse/IDM-5759 is resolved
        */
        SelenideElement dialog = $(By.xpath(XPathSelectors.INFOR_MODAL));
        if (dialog.exists()) {
            clickButtonByText(CLOSE_BUTTON_TEXT);
        }
        $(By.xpath(XPathSelectors.ADD_DOCUMENT_BUTTON)).waitUntil(Condition.exist, AppConstants.ASYNC_TIMEOUT).click();
        $(By.xpath(MODAL_PAGE_CONTAINER_NEW)).waitUntil(exist, DEFAULT_TIMEOUT);
    }

    public void addDocument() {
        clickAddDocumentButton();
        selectDocumentTypeForNewDocument();
        clickButtonByText(AppConstants.CREATE_BUTTON_TEXT);
    }

    public void addDocumentForNewlyCreatedDocumentType() {
        clickAddDocumentButton();
        selectCreatedDocumentTypeForNewDocument();
        clickButtonByText(AppConstants.CREATE_BUTTON_TEXT);
    }

    public void selectDocumentTypeForNewDocument() {
        $(By.xpath(XPathSelectors.DOCUMENT_TYPE_DROPDOWN_ADD_DOCUMENT)).setValue((SystemConfiguration.documentType));
        ElementsCollection documentTypeList = $$(By.xpath(DOCUMENT_TYPE_DROPDOWN_LIST));
        for (SelenideElement dropDownListItem : documentTypeList) {
            SelenideElement link = dropDownListItem.$(By.tagName("a"));
            if (link.text().equals(SystemConfiguration.documentType)) {
                link.click();
                break;
            }
        }
    }

    private void selectCreatedDocumentTypeForNewDocument() {
        $(By.xpath(XPathSelectors.DOCUMENT_TYPE_DROPDOWN_ADD_DOCUMENT)).setValue(documentTypeName);
        SelenideElement documentTypeList = $(By.xpath(DOCUMENT_TYPE_NEW_LIST));
        for (SelenideElement dropDownOption : documentTypeList.$$(By.tagName("option"))) {
            if (dropDownOption.text().equals(documentTypeName)) {
                dropDownOption.click();
                break;
            }
        }
    }
}