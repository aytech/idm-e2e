package pages;

import com.codeborne.selenide.SelenideElement;
import configuration.CSSSelectors;
import configuration.XPathSelectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static configuration.XPathSelectors.*;

public class ControlCenterSidebarPage extends BasePage {

    public void open() {
        if (!isOpen()) {
            $(By.xpath(CONTROL_CENTER_SIDEBAR_TOGGLE)).click();
        }
    }

    private boolean isOpen() {
        return $(By.xpath(CONTROL_CENTER_MENU)).exists();
    }

    private void expandAdministrationSection() {
        getAdministrationDropDown().click();
    }

    public void selectAdministrationOption(String optionText) {
        expandAdministrationSection();
        for (SelenideElement option : getAdministrationDropDown().$$(By.tagName("a"))) {
            if (option.text().equals(optionText)) {
                option.click();
                break;
            }
        }
    }

    private SelenideElement getAdministrationDropDown() {
        return $(By.cssSelector(CSSSelectors.ADMINISTRATION));
    }

    private SelenideElement getConfigurationDropDown() {
        return $(By.cssSelector(CSSSelectors.CONFIGURATION));
    }

    public void expandConfigurationSection() {
        if (!isConfigurationSectionOpen()) {
            getConfigurationDropDown().click();
        }
    }

    private boolean isConfigurationSectionOpen() {
        return $(By.xpath(CONFIGURATION_NAV_SECTION)).isDisplayed();
    }

    public void selectConfigurationOption(String optionText) {
        expandConfigurationSection();
        for (SelenideElement option : getConfigurationDropDown().$$(By.tagName("a"))) {
            if (option.text().equals(optionText)) {
                option.click();
                break;
            }
        }
    }

    public void closeControlCenterLeftPanel() {
        if (isOpen()) {
            $(By.xpath(CONTROL_CENTER_SIDEBAR_TOGGLE)).click();
        }
    }

    public void navigateToControlCenterHome() {
        open();
        $(By.xpath(XPathSelectors.CONTROL_CENTER_HOME)).click();
        closeControlCenterLeftPanel();
    }
}