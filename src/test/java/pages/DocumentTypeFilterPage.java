package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.*;

public class DocumentTypeFilterPage extends BasePage {

    private SelenideElement getPage() {
        return $(By.xpath(DOCUMENT_TYPE_FILTER_PAGE));
    }

    public void waitTillExists() {
        getPage().waitUntil(exist, ASYNC_TIMEOUT);
    }

    private void clickOnNewFilterButton() {
        $(By.xpath(NEW_FILTER_BUTTON)).click();
    }

    public SelenideElement getRole(String role) {
        return $(By.linkText(role));
    }

    private boolean isRoleAdded(String role) {
        return $(By.linkText(role)).isDisplayed();
    }

    public void addFilterForRole(String role) {
        if (!isRoleAdded(role)) {
            clickOnNewFilterButton();
            selectFromDropDown(FILTER_ROLE_DROP_DOWN, role);
            clickButtonByText(CONFIRM_BUTTON_TEXT_OK);
            waitForLoadingIndicators(ASYNC_TIMEOUT);
            waitUntilToastMessageDisappear();
        }
    }

    private void clickOnDeleteButton() {
        $(By.xpath(DELETE_FILTER_BUTTON)).click();
    }

    private void selectRole(String role) {
        $(By.linkText(role)).click();
    }

    public void removeRole(String role) {
        if (isRoleAdded(role)) {
            selectRole(role);
            clickOnDeleteButton();
            clickButtonByText(CONFIRM_BUTTON_TEXT.toUpperCase());
            waitForLoadingIndicators(ASYNC_TIMEOUT);
        }
    }

    private void enableFilter() {
        if (isFilterDisabled()) {
            $(By.xpath(ENABLE_FILTER_SWITCH)).click();
        }
    }

    private void clickingDocumentType() {
        $(By.linkText(MDS_FILE_DOCUMENT_TYPE)).click();
    }

    public void addFilter(String role) {
        selectRole(role);
        enableFilter();
        removingAllDocumentTypeFromSelectedSection();
        clickingDocumentType();
        clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        waitUntilToastMessageDisappear();
    }

    private boolean isFilterDisabled() {
        return $(By.xpath(DOCUMENT_TYPE_FILTER_DISABLED)).isDisplayed();
    }

    private ElementsCollection getSelectedDocumentTypeList() {
        return $$(By.xpath(SELECTED_DOCUMENT_TYPE_LIST_FILTER));
    }

    private void removingAllDocumentTypeFromSelectedSection() {
        int length = getSelectedDocumentTypeList().size();
        for (int i = length; i > 0; i--) {
            $(By.xpath(SELECTED_DOCUMENT_TYPE_FILTER_INDEX + "[\"+i+\"]")).click();
        }
    }
}