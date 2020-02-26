package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.*;
import static pages.BasePage.waitForLoadingIndicators;
import static pages.DocumentTypePage.documentTypeName;

public class SecurityAuditLogPage extends BasePage {

    public void enableSecurityAuditLogSwitch() {
        if (isAuditLogSwitchDisabled()) {
            $(By.xpath(ENABLE_SECURITY_AUDIT_LOG_SWITCH)).click();
            waitForLoadingIndicators(SLEEP_TIMEOUT);
            clickHeaderActionButtonControlCenter(SECURITY_AUDIT_LOG_SAVE_CHANGES_BUTTON);
            waitForLoadingIndicators(ASYNC_TIMEOUT);
        }
    }

    private boolean isAuditLogSwitchDisabled() {
        return $(By.xpath(DISABLE_SECURITY_AUDIT_LOG)).isDisplayed();
    }

    public void addDocumentTypeForAuditLog() {
        $(By.xpath(String.format(NOT_LOGGED_DOCUMENT_TYPES, documentTypeName))).click();
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        clickHeaderActionButtonControlCenter(SECURITY_AUDIT_LOG_SAVE_CHANGES_BUTTON);
        getToastMessage().waitUntil(exist, ASYNC_TIMEOUT);
        waitUntilToastMessageDisappear();
    }

    public SelenideElement getDocumentTypeUnderAuditLogging() {
        return $(By.xpath(String.format(DOCUMENT_TYPES_UNDER_AUDIT_LOGGING, documentTypeName)));
    }

    public SelenideElement getPage() {
        return $(By.xpath(SECURITY_AUDIT_LOG_PAGE));
    }

    public void waitTillExists() {
        sleep(DEFAULT_TIMEOUT);
        getPage().waitUntil(Condition.exist, ASYNC_TIMEOUT);
    }

    public void moveDocumentTypeToNotLoggedDocumentType() {
        $(By.xpath(String.format(DOCUMENT_TYPES_UNDER_AUDIT_LOGGING, documentTypeName))).click();
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        clickHeaderActionButtonControlCenter(SECURITY_AUDIT_LOG_SAVE_CHANGES_BUTTON);
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        getToastMessage().waitUntil(exist, ASYNC_TIMEOUT);
        waitUntilToastMessageDisappear();
    }

    public SelenideElement getNotLoggedDocumentTypes() {
        return $(By.xpath(String.format(NOT_LOGGED_DOCUMENT_TYPES, documentTypeName)));
    }
}