package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import configuration.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static configuration.AppConstants.*;
import static configuration.CSSSelectors.BUTTON_ADVANCED_SEARCH;
import static configuration.XPathSelectors.*;

public class SearchPage extends BasePage {

    public void waitTillRendered() {
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        /*
        // TODO: Dismissing error modal must be removed when the
        // https://jira.infor.com/browse/IDM-5759 is resolved
        */
        if (isOperationFailedPopupDisplayed()) {
            clickButtonByText(CLOSE_BUTTON_TEXT);
        }
        $(By.xpath(XPathSelectors.SEARCH_PANEL))
                .waitUntil(exist, ASYNC_TIMEOUT);
    }

    public void selectAttribute(String attribute) {
        open();
        selectFromDropDown(SELECT_ATTRIBUTE, attribute);
    }

    public void selectSortingOption(String sortingOption) {
        waitForLoadingIndicators(AppConstants.ASYNC_TIMEOUT);
        $(By.xpath(XPathSelectors.SORT_RESULTS_BY)).click();
        $(By.xpath(SORT_RESULTS_BUTTON)).click();
        $(By.xpath(SORT_BY_ACTIONS)).waitUntil(visible, DEFAULT_TIMEOUT);
        for (SelenideElement option : $$(By.xpath(XPathSelectors.SORT_BY_ACTIONS))) {
            if (option.text().equals(sortingOption)) {
                option.click();
                waitForLoadingIndicators(ASYNC_TIMEOUT);
                break;
            }
        }
    }

    public void clickSortingArrow() {
        waitForLoadingIndicators(AppConstants.ASYNC_TIMEOUT);
        $(By.xpath(XPathSelectors.SORTING_ARROW)).waitUntil(visible, AppConstants.ASYNC_TIMEOUT)
                .click();
        waitForLoadingIndicators(AppConstants.ASYNC_TIMEOUT);
    }

    public void selectOperation(String operation) {
        open();
        selectFromDropDown(SELECT_OPERATION, operation);
    }

    public void selectState(String state) {
        open();
        selectFromDropDown(SELECT_DOCUMENT_STATE, state);
    }

    public void verifyCardListGone() {
        $(By.tagName(TagSelectors.IDM_CARD_LIST_TAG)).is(exist);
    }

    public void search() {
        open();
        SelenideElement searchButton = $(By.id(IDSelectors.SEARCH_BUTTON));
        searchButton.click();
        if ($(By.cssSelector(CSSSelectors.TYPEAHEAD)).is(exist)) {
            searchButton.click();
        }
    }

    public void isSearchDropdownDisplayed() {
        $(By.tagName(TagSelectors.IDM_SEARCH_TAG)).is(exist);
    }

    public void setTextSearchValue(String value) {
        $(By.xpath(XPathSelectors.FORM_TEXT_FIELDS)).setValue(value);
    }

    public void clickDeletedByMeShortcutLink() {
        expandAdvancedSearch();
        $(By.id(IDSelectors.SHORTCUT_DELETED_BY_ME)).click();
    }

    public void clickCreatedByMeShortcutLink() {
        expandAdvancedSearch();
        $(By.id(IDSelectors.SHORTCUT_CREATED_BY_ME)).click();
    }

    public void clickCheckedOutByMeShortcutLink() {
        expandAdvancedSearch();
        $(By.id(IDSelectors.SHORTCUT_CHECKED_OUT_BY_ME)).click();
    }

    private boolean isAdvancedSearchOpen() {
        return $(By.xpath(XPathSelectors.ADVANCED_SEARCH_CONTAINER)).exists();
    }

    public void expandAdvancedSearch() {
        open();
        if (!isAdvancedSearchOpen()) {
            $(By.xpath(XPathSelectors.ADVANCED_SEARCH_TOGGLE)).click();
        }
    }

    private void selectDocumentStateInAdvancedSearch(String state) {
        selectFromDropDown(SELECT_DOCUMENT_STATE, state);
    }

    public void selectArchiveSearchOption() {
        selectDocumentStateInAdvancedSearch(AppConstants.STATE_ARCHIVED);
    }

    public void selectDeletedSearchOption() {
        selectDocumentStateInAdvancedSearch(AppConstants.STATE_DELETED);
    }

    public void clickSearchButton() {
        open();
        SelenideElement searchButton = $(By.xpath(XPathSelectors.SEARCH_BUTTON));
        searchButton.click();
        // Typeahead prompt steals focus from Search button, click twice
        if ($(By.cssSelector(CSSSelectors.TYPEAHEAD)).is(exist)) {
            searchButton.click();
        }
        SelenideElement modal = $(By.className(ClassSelectors.MODAL_PAGE_CONTAINER));
        if (modal.exists()) {
            clickButtonByText(CLOSE_BUTTON_TEXT);
        }
    }

    public void clickShortcutButton() {
        if (!isShortcutMenuOpen()) {
            SelenideElement shortcutButton = $(By.xpath(XPathSelectors.SHORTCUT_MENU_BUTTON));
            shortcutButton.click();
            waitForLoadingIndicators(ASYNC_TIMEOUT);
        }
    }

    private boolean isShortcutMenuOpen() {
        return $(By.xpath(XPathSelectors.SHORTCUT_MENU)).isDisplayed();
    }

    private void clickActionButton(String buttonText) {
        SelenideElement shortcutMenu = $(By.xpath(XPathSelectors.SHORTCUT_MENU));
        for (SelenideElement button : shortcutMenu.$$(By.cssSelector(CSSSelectors.SHORTCUT_MENU_BUTTONS))) {
            if (button.text().trim().equals(buttonText)) {
                button.click();
                break;
            }
        }
        clickButtonByText(AppConstants.CONFIRM_BUTTON_TEXT.toUpperCase());
    }

    private boolean isSearchElementOpen() {
        return $(By.xpath(SEARCH_ELEMENT)).exists();
    }

    public void open() {
        if (!isSearchElementOpen()) {
            $(By.cssSelector(BUTTON_ADVANCED_SEARCH)).click();
        }
    }

    public void close() {
        if (isSearchElementOpen()) {
            $(By.cssSelector(CSSSelectors.SEARCH_SELECTOR)).click();
        }
    }

    public void selectEntityType(String documentType) {
        open();
        selectFromDropDown(SELECT_ENTITY_TYPE, documentType);
    }

    public SelenideElement getSaveSearchButton() {
        return $(By.xpath(XPathSelectors.SAVED_SEARCH_BUTTON));
    }

    public void clickSaveSearchButton() {
        getSaveSearchButton().click();
    }

    public void verifyXQuerySearchValue(String xquery) {
        expandAdvancedSearch();
        $(By.id(IDSelectors.XQUERY_TEXTAREA)).shouldHave(value(xquery));
    }


    public void openControlCenter() {
          /*
        // TODO: Dismissing error modal must be removed when the
        // https://jira.infor.com/browse/IDM-5759 is resolved
        */
        SelenideElement dialog = $(By.xpath(XPathSelectors.INFOR_MODAL));
        if (dialog.exists()) {
            clickButtonByText(CLOSE_BUTTON_TEXT);
        }
        $(By.xpath(XPathSelectors.CONTROL_CENTER_BUTTON)).click();
        waitForLoadingIndicators(DEFAULT_TIMEOUT);
    }

    public void expandEntitiesDropDown() {
        waitTillRendered();
        open();
        $(By.xpath(SELECT_ENTITY_TYPE)).click();
    }

    public SelenideElement getEntity(int index) {
        return $(By.xpath(String.format(DOCUMENT_TYPE_INDEX_SEARCH_STACK, index))).waitUntil(exist, ASYNC_TIMEOUT);
    }

    public ElementsCollection getEntityList() {
        return $$(By.xpath(ENTITY_TYPE_SEARCH_STACK));
    }

    private boolean isOperationFailedPopupDisplayed() {
        return $(By.xpath(XPathSelectors.ERROR_POPUP)).isDisplayed();
    }

    public void setValueWithPicker(String value) {
        $(By.xpath(DATE_TIME_VALUE_FIELD)).setValue(value);
    }

    public void setValueFromDropDown(String value) {
        selectFromDropDown(VALUE_FIELD_DROPDOWN_SEARCH_STACK, value);
    }
}