package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import configuration.XPathSelectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Selenide.$;
import static configuration.AppConstants.ASYNC_TIMEOUT;
import static configuration.AppConstants.DEFAULT_TIMEOUT;
import static configuration.XPathSelectors.*;

public class LanguagesPage extends BasePage {


    public SelenideElement getPage() {
        return $(By.xpath(LANGUAGES_PAGE));
    }

    public void waitTillExists() {
        getPage().waitUntil(Condition.exist, AppConstants.ASYNC_TIMEOUT);
    }

    public SelenideElement getLanguageTableRow(String languageName) {
        String selector = String.format("%s%s//td[contains(text(), \"%s\")]", LANGUAGES_PAGE, CONTAINER_FLUID, languageName);
        return $(By.xpath(selector));
    }

    private SelenideElement getLanguageTableDataCheckboxLabel(String languageName) {
        String selector = String.format("%s%s//td[contains(text(), \"%s\")]//..//label", LANGUAGES_PAGE, CONTAINER_FLUID, languageName);
        return $(By.xpath(selector));
    }

    public void deleteLanguageRow(String languageName) {
        getLanguageTableDataCheckboxLabel(languageName).click();
        $(By.xpath(LANGUAGES_DELETE_BUTTON)).click();
        $(By.xpath(LANGUAGES_CONFIRM_YES_BUTTON)).click();
        waitForLoadingIndicators(DEFAULT_TIMEOUT);
        getToastMessage().waitUntil(disappears, AppConstants.DEFAULT_TIMEOUT);
    }

    private void clickOnAddLanguageButton() {
        $(By.xpath(XPathSelectors.LANGUAGES_ADD_BUTTON)).click();
    }

    private void selectingLanguage() {
        $(By.xpath(String.format("%s//button[contains(text(), \"OK\")]", LANGUAGE_CONFIGURATION_PAGE))).click();
    }

    public void addLanguage(String languageName) {
        clickOnAddLanguageButton();
        if (findLanguage(languageName).exists()) {
            $(By.xpath(getLanguageTableDataSelector(languageName))).parent().click();
            selectingLanguage();
            waitForLoadingIndicators(ASYNC_TIMEOUT);
            getToastMessage().waitUntil(appears, AppConstants.DEFAULT_TIMEOUT);
            waitUntilToastMessageDisappear();
        } else {
            clickButtonByText(AppConstants.CANCEL_BUTTON_TEXT);
        }
    }

    private SelenideElement findLanguage(String languageName) {
        $(By.xpath(String.format("%s//%s", LANGUAGE_CONFIGURATION_PAGE, "input"))).setValue(languageName);
        return $(By.xpath(getLanguageTableDataSelector(languageName)));
    }

    private String getLanguageTableDataSelector(String languageName) {
        return String.format("%s//td[contains(text(), %s)]", LANGUAGE_CONFIGURATION_PAGE, languageName);
    }
}