package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import configuration.CSSSelectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.*;

public class ControlCenterHomePage extends BasePage {

    public ElementsCollection getMenuItems() {
        return $$(By.xpath(CONTROL_CENTER_MENU));
    }

    public void clickLink(String linkText) {
        waitForLoadingIndicators(AppConstants.ASYNC_TIMEOUT);
        $(By.xpath(CARD_HOLDER_CONTROL_CENTER_HOME)).waitUntil(Condition.visible,DEFAULT_TIMEOUT);
        for (SelenideElement option : $$(By.xpath(CARD_HOLDER_LINKS))) {
        if (option.text().equals(linkText)) {
            option.click();
            break;
        }
    }
        waitForLoadingIndicators(VALUE_SET_TIMEOUT);
    }
}