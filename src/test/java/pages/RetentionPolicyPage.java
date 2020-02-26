package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configuration.XPathSelectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.*;
import static pages.DocumentTypePage.documentTypeName;

public class RetentionPolicyPage extends BasePage {

    public void waitPageToBeDisplayed() {
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        $(By.xpath(XPathSelectors.RETENTION_POLICIES_PAGE)).waitUntil(exist, ASYNC_TIMEOUT);
    }

    private void clickAdd() {
        $(By.xpath(RETENTION_POLICY_ADD_BUTTON)).click();
    }

    private SelenideElement getTableData(String retentionPolicy) {
        String selector = String.format(RETENTION_POLICY_TABLE_DATA, RETENTION_POLICIES_PAGE, MAIN_CONTAINER, retentionPolicy);
        return $(By.xpath(selector));
    }

    public void run() {
        getTableData(documentTypeName);
        getRunButton(documentTypeName).click();
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        getToastMessage().waitUntil(Condition.visible, DEFAULT_TIMEOUT);
        waitUntilToastMessageDisappear();
    }

    public void delete() {
        getTableData(documentTypeName).click();
        $(By.xpath(RETENTION_POLICY_DELETE_BUTTON)).click();
        clickButtonByText(CONFIRM_BUTTON_TEXT.toUpperCase());
        getToastMessage().waitUntil(Condition.visible, DEFAULT_TIMEOUT);
        waitUntilToastMessageDisappear();
    }

    private SelenideElement getRunButton(String retentionPolicy) {
        String selector = String.format(RETENTION_POLICY_TABLE_DATA_RUN, RETENTION_POLICIES_PAGE, MAIN_CONTAINER, retentionPolicy);
        return $(By.xpath(selector));
    }

    private void setDescriptionText() {
        $(By.xpath(XPathSelectors.RETENTION_POLICIES_DESCRIPTION_TEXT)).setValue(documentTypeName);
    }

    private SelenideElement getRetentionPoliciesTableToggleLabel(String retentionPolicy) {
        String selector = String.format("%s%s//td[contains(text(), \"%s\")]//..//td[1]//input", RETENTION_POLICIES_PAGE, MAIN_CONTAINER, retentionPolicy);
        return $(By.xpath(selector));
    }

    public void addRetentionPolicy(String dropdown, String actionType) {
        clickAdd();
        isInforModalDisplayed();
        selectFromDropDown(SELECT_ENTITY_TYPE, documentTypeName);
        selectFromDropDown(dropdown, actionType);
        setDescriptionText();
        clickButtonByText(CONFIRM_BUTTON_TEXT_OK);
        getToastMessage();
        waitUntilToastMessageDisappear();
    }

    private void clickEditButton() {
        $(By.xpath(RETENTION_POLICY_EDIT_BUTTON)).click();
    }

    public void editRetentionPolicy(String dropdown, String actionType) {
        getTableData(documentTypeName).click();
        clickEditButton();
        isInforModalDisplayed();
        selectFromDropDown(dropdown, actionType);
        clickButtonByText(CONFIRM_BUTTON_TEXT_OK);
        getToastMessage();
        waitUntilToastMessageDisappear();
    }
}