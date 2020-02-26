package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configuration.*;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.APPROVED_STATUS;
import static configuration.XPathSelectors.MORE_LIST;

public class DocumentDetailActionBarPage extends BasePage {

    private void openMoreActionsPopup() {
        SelenideElement moreActionButton = $(By.xpath(XPathSelectors.DOCUMENT_DETAILS_MORE_ACTION_BUTTON));
        moreActionButton.waitUntil(exist, AppConstants.ASYNC_TIMEOUT);
        if (moreActionButton.isDisplayed() && moreActionButton.is(visible)) {
            if (!isActionPopoverOpen()) {
                moreActionButton.click();
            }
        }
    }

    private void clickActionButton(String buttonText) {
        openMoreActionsPopup();
        for (SelenideElement actionButton : $$(By.xpath(XPathSelectors.ACTION_BUTTONS))) {
            if (actionButton.text().equals(buttonText)) {
                actionButton.click();
                break;
            }
        }
    }

    public void deleteDocument() {
        clickActionButton(AppConstants.DELETE_BUTTON_TEXT);
        clickButtonByText(AppConstants.CONFIRM_BUTTON_TEXT.toUpperCase());
        waitForLoadingIndicators(ASYNC_TIMEOUT);
    }

    public void saveDocument() {
        SelenideElement save =
                page(DocumentDetailActionBarPage.class)
                        .getActionButton(AppConstants.SAVE_BUTTON_TEXT);
        assert save != null;
        save.click();
        waitForLoadingIndicators(AppConstants.ASYNC_TIMEOUT);
    }

    public void archiveDocument() {
        clickActionButton(AppConstants.ARCHIVE_BUTTON_TEXT);
        clickButtonByText(AppConstants.CONFIRM_BUTTON_TEXT.toUpperCase());
        waitForLoadingIndicators(ASYNC_TIMEOUT);
    }

    public void checkOutDocument() {
        clickActionButton(AppConstants.CHECKOUT_BUTTON_TEXT);
    }

    public void checkInDocument() {
        clickActionButton(AppConstants.CHECK_IN_BUTTON_TEXT);
        waitForLoadingIndicators(DEFAULT_TIMEOUT);
    }

    public void discardCheckOutDocument() {
        clickActionButton(DISCARD_CHECKOUT_BUTTON_TEXT);
        clickButtonByText(CONFIRM_BUTTON_TEXT.toUpperCase());
    }

    public void downloadDocument() {
        clickActionButton(AppConstants.DOWNLOAD);
    }

    public void copyDocument() {
        clickActionButton(AppConstants.COPY_BUTTON_TEXT);
    }

    public void downloadAsPdfDocument() {
        clickActionButton(AppConstants.DOWNLOAD_AS_PDF);
    }

    public void saveAsNewDocument() {
        clickActionButton(AppConstants.SAVE_AS_NEW_DOCUMENT);
    }

    public void sendInEmail() {
        clickActionButton(AppConstants.SEND_IN_EMAIL_BUTTON_TEXT);
    }

    public void refreshDocument() {
        clickActionButton(REFRESH_BUTTON_TEXT);
    }

    public void refreshDocumentUntilStatusChanges() {
        for (int i = 1; i <= 5; i++) {
            if (!isStatusDisplayed()) {
                clickActionButton(REFRESH_BUTTON_TEXT);
            }
        }
    }

    public void fillEmailFields() throws IllegalAccessException {
        $(By.id(IDSelectors.TO)).setValue(Configuration.getProperty(IDM_USER_EMAIL));
        $(By.id(IDSelectors.SUBJECT)).setValue(EMAIL_SUBJECT_PREFIX);
        $(By.id(IDSelectors.MESSAGE)).setValue(EMAIL_MESSAGE_PREFIX);
        clickButtonByText(SEND_BUTTON_TEXT);
    }

    private SelenideElement getEmailModalWindow() {
        return $(By.className(ClassSelectors.EMAIL_MODAL_WINDOW));
    }

    public void verifyEmailModal() {
        if (!getEmailModalWindow().isDisplayed()) {
            sendInEmail();
        }
    }

    public SelenideElement getActionButton(String buttonText) {
        SelenideElement actionMenu = $(By.xpath(XPathSelectors.DOCUMENT_DETAILS_ACTION_MENU));
        for (SelenideElement button : actionMenu.$$(By.xpath(XPathSelectors.ACTION_BUTTONS))) {
            button.waitUntil(exist, ASYNC_TIMEOUT);
            if (button.text().trim().equals(buttonText)) {
                return button;
            }
        }
        return null;
    }

    public void verifyActionButtonDisplayed(String buttonText) {
        openMoreActionsPopover();
        SelenideElement button = getActionButton(buttonText);
        if (button == null) {
            throw new NoSuchElementException(String.format("Action button %s was not found", buttonText));
        }
        button.shouldBe(Condition.visible);
    }

    private boolean isActionPopoverOpen() {
        // Looks like popover element is duplicated on page in current implementation
        for (SelenideElement list : $$(By.xpath(MORE_LIST))) {
            if (list.isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    private void openMoreActionsPopover() {
        SelenideElement moreActionButton = $(By.xpath(XPathSelectors.DOCUMENT_DETAILS_MORE_ACTION_BUTTON));
        if (moreActionButton.exists() && moreActionButton.is(visible)) {
            if (!isActionPopoverOpen()) {
                moreActionButton.click();
            }
        }
    }

    public void verifyActionBarButtonSetNoFileEnabled() {
        openMoreActionsPopover();
        SelenideElement actionMenu = $(By.xpath(XPathSelectors.DOCUMENT_DETAILS_LIST));
        for (SelenideElement button : actionMenu.$$(By.tagName(TagSelectors.BUTTON))) {
            if (Arrays.asList(AppConstants.actionButtonsTextsNoFileEnabled).contains(button.text())) {
                button.shouldBe(Condition.enabled);
            }
        }
    }

    public void verifyActionBarButtonsAreEnabled() {
        openMoreActionsPopover();
        List<String> actionButtonTexts = Arrays.asList(AppConstants.actionButtonsTexts);
        for (SelenideElement button : $$(By.xpath(XPathSelectors.DOCUMENT_DETAILS_MORE_ACTION_BUTTON))) {
            if (actionButtonTexts.contains(button.text())) {
                button.shouldBe(Condition.enabled);
            }
        }
    }

    private boolean isStatusDisplayed() {
        return $(By.xpath(APPROVED_STATUS)).isDisplayed();
    }
}