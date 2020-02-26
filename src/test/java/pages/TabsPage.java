package pages;

import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import configuration.XPathSelectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static configuration.ClassSelectors.TAB_NAME;

public class TabsPage extends BasePage {

    public SelenideElement getTab(String tabText) {
        for (SelenideElement tab : $$(By.xpath(XPathSelectors.DOCUMENT_TAB_LIST))) {
            SelenideElement tabName = tab.$(By.className(TAB_NAME));
            if (tabName.getText().equals(tabText)) {
                return tab;
            }
        }
        return null;
    }

    public void closeDocumentTabs() {
        waitForLoadingIndicators(AppConstants.ASYNC_TIMEOUT);
        for (SelenideElement tab : $$(By.xpath(XPathSelectors.DOCUMENT_TAB_LIST))) {
            SelenideElement closeIcon = tab.$(By.tagName("button"));
            if (closeIcon.exists()) {
                closeIcon.click();
                clickButtonByText(AppConstants.CONFIRM_BUTTON_TEXT_NO.toUpperCase());
            }
        }
    }
}
