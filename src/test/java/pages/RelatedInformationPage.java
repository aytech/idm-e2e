package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import configuration.XPathSelectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static configuration.AppConstants.DEFAULT_TIMEOUT;
import static configuration.XPathSelectors.*;
import static configuration.XPathSelectors.RELATED_INFORMATION_FRAME;
import static configuration.XPathSelectors.SHOW_IN_IDM_BUTTON;

public class RelatedInformationPage extends BasePage {

    public void switchToRelationInformationFrame() {
        getWebDriver().switchTo().frame($(By.xpath(RELATED_INFORMATION_FRAME)));
    }

    public SelenideElement getRelatedDocumentList() {
        return $(By.xpath(RELATED_DOCUMENTS_LIST));
    }

    public void showInIDM() {
        $(By.xpath(RELATED_DOCUMENTS_LIST)).click();
        $(By.xpath(SHOW_IN_IDM_BUTTON)).waitUntil(visible,DEFAULT_TIMEOUT);
        $(By.xpath(SHOW_IN_IDM_BUTTON)).click();
    }
}