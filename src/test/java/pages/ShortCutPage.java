package pages;

import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import configuration.CSSSelectors;
import configuration.XPathSelectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static configuration.AppConstants.ASYNC_TIMEOUT;
import static configuration.AppConstants.DEFAULT_TIMEOUT;

public class ShortCutPage extends BasePage {

    public void clickRecentlyModifiedShortcut() {
        clickShortcutButton(AppConstants.RECENTLY_MODIFIED_SHORTCUT);
    }

    private void clickShortcutButton(String buttonText) {
        SelenideElement shortcutMenu = $(By.xpath(XPathSelectors.SHORTCUT_MENU));
        for (SelenideElement button : shortcutMenu.$$(By.cssSelector(CSSSelectors.SHORTCUT_MENU_BUTTONS))) {
            if (button.text().trim().equals(buttonText)) {
                button.waitUntil(visible, AppConstants.DEFAULT_TIMEOUT).click();
                break;
            }
            waitForLoadingIndicators(AppConstants.ASYNC_TIMEOUT);
        }
    }

    public void clickMyDocuments() {
        clickShortcutButton(AppConstants.MY_DOCUMENTS_SHORTCUT);
        waitForLoadingIndicators(ASYNC_TIMEOUT);
    }

    public void clickChatAttachmentsShortcut() {
        clickShortcutButton(AppConstants.CHAT_ATTACHMENTS);
    }

    public void clickTemplatesShortcut() {
        clickShortcutButton(AppConstants.TEMPLATES);
    }

    public void clickTrashShortcut() {
        clickShortcutButton(AppConstants.TRASH);
    }

    public void clickFavoritesShortcut() {
        clickShortcutButton(AppConstants.FAVORITES);
    }

    public void clickSavedSearchesShortcut() {
        clickShortcutButton(AppConstants.SAVED_SEARCHES);
        expandSavedSearch();
    }

    public void waitSearchListToBeDisplayed() {
        getSavedSearchList().waitUntil(exist, DEFAULT_TIMEOUT);
    }

    private void expandSavedSearch() {
        if (!getSavedSearchList().isDisplayed()) {
            clickShortcutButton(AppConstants.SAVED_SEARCHES);
            waitSearchListToBeDisplayed();
        }
    }

    public SelenideElement getSavedSearchList() {
        return $(By.xpath(XPathSelectors.SAVED_SEARCH_LIST));
    }

    public void clickSavedSearchesLink(String linkText) {
        for (SelenideElement link : getSavedSearchList().$$(By.xpath(XPathSelectors.SAVED_SEARCH_LINK))) {
            if (link.text().trim().equals(linkText)) {
                link.click();
                break;
            }
        }
    }

    public void openManageSearchesModal() {
        $(By.xpath(XPathSelectors.MANAGE_SAVED_SEARCHES_BUTTON)).click();
    }
}
