package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import configuration.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import utility.FileUtility;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.*;

public class CardListSearchResultPage extends BasePage {

    private boolean isActionBarVisible() {
        return $(By.id(IDSelectors.TOOLBAR)).isDisplayed();
    }

    public void selectFirstDocumentFromResultList() {
        //        temp fix for the modal window and it will be removed once the root cause for the modal window is found
        SelenideElement modal = $(By.className(ClassSelectors.MODAL_PAGE_CONTAINER));
        if (modal.exists()) {
            clickButtonByText(CLOSE_BUTTON_TEXT);
        }
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        if (!isActionBarVisible()) {
            $(By.xpath(CARD_LIST_ITEM)).click();
        }
    }

    public void selectAllDocuments() {
        $(By.xpath(XPathSelectors.SELECT_ALL_LABEL)).click();
    }

    public void verifyDocumentFileName() {
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        SelenideElement fileName = $(By.xpath(CARD_LIST_ITEM)).waitUntil(Condition.exist, ASYNC_TIMEOUT);
        String file = fileName.getText();
        Assert.assertTrue(file.trim().contains(DocumentTypePage.documentTypeName));
    }

    private boolean isActionPopoverOpen() {
        return $(By.xpath(XPathSelectors.MORE_ACTIONS_BUTTON)).attr("class").contains("is-open");
    }

    private void openMoreActionsPopover() {
        SelenideElement moreActionButton = $(By.xpath(XPathSelectors.MORE_ACTIONS_BUTTON));
        if (moreActionButton.exists() && moreActionButton.is(visible)) {
            if (!isActionPopoverOpen()) {
                moreActionButton.click();
            }
        }
    }

    private SelenideElement getActionButton(String buttonText) {
        SelenideElement actionMenu = $(By.xpath(XPathSelectors.CARD_LIST_ACTION_MENU));
        for (SelenideElement button : actionMenu.$$(By.xpath(XPathSelectors.ACTION_BUTTONS))) {
            button.waitUntil(Condition.enabled, ASYNC_TIMEOUT);
            if (button.text().trim().equals(buttonText)) {
                return button;
            }
        }
        return null;
    }

    private void clickActionButton(String buttonText) {
        clickActionButton(buttonText, CONFIRM_BUTTON_TEXT.toUpperCase());
    }

    private void clickActionButton(String buttonText, String confirmButtonText) {
        SelenideElement actionMenu = $(By.xpath(XPathSelectors.CARD_LIST_ACTION_MENU));
        for (SelenideElement button : actionMenu.$$(By.xpath(XPathSelectors.ACTION_BUTTONS))) {
            if (button.text().equals(buttonText)) {
                button.click();
                break;
            }
        }
    }

    public void displayDocument() {
        clickActionButton(DISPLAY_BUTTON_TEXT);
        $(By.xpath(DOCUMENT_DETAILS_PAGE)).waitUntil(visible, ASYNC_TIMEOUT);
    }

    public void copyDocument() {
        clickActionButton(COPY_BUTTON_TEXT);
    }

    public void deleteDocument() {
        clickActionButton(DELETE_BUTTON_TEXT);
        clickButtonByText(CONFIRM_BUTTON_TEXT.toUpperCase());
        waitForLoadingIndicators(AppConstants.ASYNC_TIMEOUT);
    }

    public void addToFavoritesDocument() {
        clickActionButton(ADD_TO_FAVORITES_BUTTON_TEXT);
    }

    public void removeFromFavoritesDocument() {
        clickActionButton(REMOVE_FROM_FAVORITES_BUTTON_TEXT);
    }

    public void archiveDocument() {
        clickActionButton(ARCHIVE_BUTTON_TEXT);
        clickButtonByText(CONFIRM_BUTTON_TEXT.toUpperCase());
        waitForLoadingIndicators(ASYNC_TIMEOUT);
    }

    public void sendInEmail() {
        clickActionButton(SEND_IN_EMAIL_BUTTON_TEXT);
    }

    public void saveAsNewDocument() {
        clickActionButton(SAVE_AS_NEW_DOCUMENT);
    }

    public void downloadDocument() {
        clickActionButton(DOWNLOAD);
    }

    public void downloadAsPdf() {
        String documentPID = $(By.xpath(CARD_LIST_ITEM)).attr("id");
        FileUtility.setFileNamePDF(documentPID + "-LATEST.pdf");
        clickActionButton(DOWNLOAD_AS_PDF, DOWNLOAD_AS_PDF);
    }

    public void saveNewDocument() throws IllegalAccessException {
        selectNewDocumentType();
        clickButtonByText(CREATE_BUTTON_TEXT);
    }

    public void verifyDownloadedFile(String filePath) {
        Assert.assertTrue(new File(filePath).exists());
    }

    private void selectNewDocumentType() throws IllegalAccessException {
        String newDocumentType = Configuration.getProperty(IDM_NEW_DOCUMENT_TYPE);
        $(By.xpath(XPathSelectors.SAVE_AS_NEW_DOCUMENT_MODAL)).waitUntil(Condition.exist, ASYNC_TIMEOUT);
        selectFromDropDown(DOCUMENT_TYPE_DROPDOWN, newDocumentType);
    }

    public void fillEmailFields() throws IllegalAccessException {
        $(By.id(IDSelectors.TO)).setValue(Configuration.getProperty(IDM_USER_EMAIL));
        $(By.id(IDSelectors.SUBJECT)).setValue(EMAIL_SUBJECT_PREFIX);
        $(By.id(IDSelectors.MESSAGE)).setValue(EMAIL_MESSAGE_PREFIX);
        clickButtonByText(SEND_BUTTON_TEXT.toUpperCase());
    }

    public void checkOutDocument() {
        clickActionButton(CHECKOUT_BUTTON_TEXT);
        waitForLoadingIndicators(ASYNC_TIMEOUT);
    }

    public void discardCheckOutDocument() {
        clickActionButton(DISCARD_CHECKOUT_BUTTON_TEXT);
        clickButtonByText(CONFIRM_BUTTON_TEXT.toUpperCase());
    }

    public boolean isInforModalDisplayed() {
        return $(By.xpath(INFOR_MODAL)).is(Condition.visible);
    }

    public void openDocumentFromSearchResult(String documentTitle) {
        for (SelenideElement row : $$(By.xpath(CARD_LIST_ITEM))) {
            SelenideElement title = row.$(By.cssSelector(CSSSelectors.DOCUMENT_TITLE_LINK));
            if (title.text().equals(documentTitle)) {
                row.click();
                clickActionButton(DISPLAY_BUTTON_TEXT);
            }
        }
    }

    public void verifyActionBarDefaultButtonSet() {
        openMoreActionsPopover();
        SelenideElement actionMenu = $(By.xpath(XPathSelectors.SEARCH_RESULT_ACTION_MENU));
        actionMenu.$$(By.tagName(TagSelectors.BUTTON_A)).shouldHave(texts(actionButtonsTexts));
    }

    public void verifyActionBarButtonSetNoFileEnabled() {
        openMoreActionsPopover();
        SelenideElement actionMenu = $(By.xpath(XPathSelectors.SEARCH_RESULT_ACTION_MENU));
        for (SelenideElement button : actionMenu.$$(By.tagName(TagSelectors.BUTTON))) {
            if (Arrays.asList(actionButtonsTextsNoFileEnabled).contains(button.text())) {
                button.shouldBe(Condition.enabled);
            }
        }
    }

    public void verifyActionBarButtonsAreEnabled() {
        openMoreActionsPopover();
        List<String> actionButtonTexts = Arrays.asList(actionButtonsTexts);
        for (SelenideElement button : $$(By.xpath(XPathSelectors.ACTION_BUTTONS))) {
            if (actionButtonTexts.contains(button.text())) {
                button.shouldBe(Condition.enabled);
            }
        }
    }

    public void verifyDocumentExistsInSearchResults() {
        $$(By.xpath(CARD_LIST_ITEM)).shouldHaveSize(1);
    }

    public ElementsCollection getSearchResult() {
        return $$(By.xpath(CARD_LIST_ITEM));
    }

    public void verifySearchResultEmpty() {
        $$(By.xpath(CARD_LIST_ITEM)).shouldHaveSize(0);
    }

    public void verifyActionButtonDisplayed(String buttonText) {
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        SelenideElement button = getActionButton(buttonText);
        assert button != null;
        button.waitUntil(Condition.appears, ASYNC_TIMEOUT).shouldBe(visible);
    }

    public void verifyDocumentsExistsInSearchResults() {
        $$(By.xpath(CARD_LIST_ITEM)).shouldHaveSize(2);
    }

    public SelenideElement getSearchActionButton(String action) {
        String selector = String.format(SEARCH_ACTION_BUTTONS, action);
        return $(By.xpath(selector));
    }

    public void checkInDocument() {
        clickActionButton(CHECK_IN_BUTTON_TEXT);
        waitForLoadingIndicators(ASYNC_TIMEOUT);
    }
}