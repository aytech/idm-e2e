package pages;

import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static configuration.AppConstants.DEFAULT_TIMEOUT;
import static configuration.AppConstants.PRINT_CONFIGURATION_FILE_PATH;
import static configuration.XPathSelectors.*;
import static configuration.XPathSelectors.PRINTER_ROW;
import static configuration.XPathSelectors.PRINT_CONFIGURATION_PAGE;

public class PrintPage extends BasePage {

    private SelenideElement getPage() {
        return $(By.xpath(PRINT_CONFIGURATION_PAGE));
    }

    public void waitTillExists() {
        waitForLoadingIndicators(DEFAULT_TIMEOUT);
        getPage().waitUntil(exist, DEFAULT_TIMEOUT);
    }

    public void navigateToManageServices() {
        $(By.xpath(MANAGE_SERVICES_PRINT)).click();
    }

    public void addCredentials() {
        String cwd = System.getProperty("user.dir");
        $(By.xpath(ADD_PRINT_CREDENTIALS_BUTTON)).sendKeys(cwd + PRINT_CONFIGURATION_FILE_PATH);
    }

    public void configurePrinter() {
        $(By.xpath(INPUT_PRINTER_ID)).setValue(AppConstants.PRINTER_ID);
        $(By.xpath(ACCEPT_PRINTER_BUTTON)).click();
    }

    public void navigateToAcceptPrinterTab() {
        waitUntilToastMessageDisappear();
        $(By.xpath(ACCEPT_PRINTER_TAB)).click();
        $(By.xpath(ACCEPT_PRINTER_PAGE)).waitUntil(visible, DEFAULT_TIMEOUT);
    }

    public void navigateToPrintersTab() {
        waitUntilToastMessageDisappear();
        $(By.xpath(PRINTER_TAB)).click();
    }

    public SelenideElement getPrinter() {
        return $(By.xpath(PRINTER_ROW));

    }
}