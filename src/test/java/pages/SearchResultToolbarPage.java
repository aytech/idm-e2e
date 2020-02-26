package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configuration.ClassSelectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class SearchResultToolbarPage extends BasePage {

    public void verifySearchResultText() {
        $(By.className(ClassSelectors.SEARCH_COUNT_AREA))
                .shouldHave(Condition.matchText("^[0-9]{1,9}\\smatching documents$"));
    }

    public SelenideElement getSearchCount() {
        return $(By.className(ClassSelectors.SEARCH_COUNT_AREA));
    }
}