package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.*;
import static org.openqa.selenium.By.xpath;

public class SystemHealthPage extends BasePage {

    public SelenideElement getPage() {
        return $(xpath(SELF_HEALING_PAGE));
    }

    public void performSelfHealing() {
        $(xpath(SYNCHRONIZE_THE_DATA_MODEL)).click();
    }

    public void verifyResultExists() {
        $(By.xpath(RESULT_IS_SUCCESSFUL)).waitUntil(exist, ASYNC_TIMEOUT);
    }
}