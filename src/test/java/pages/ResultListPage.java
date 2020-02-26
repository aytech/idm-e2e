package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.*;
import static pages.DocumentTypePage.documentTypeName;

public class ResultListPage extends BasePage {

    public void clickAddResultListButton() {
        $(By.xpath(RESULT_LIST_ADD_BUTTON)).waitUntil(Condition.visible, DEFAULT_TIMEOUT);
        $(By.xpath(RESULT_LIST_ADD_BUTTON)).click();
    }

    public void getResultListPage() {
        $(By.xpath(RESULT_LIST_PAGE)).waitUntil(exist, ASYNC_TIMEOUT);
    }

    public void selectResultListDocumentType() {
        $(By.xpath(RESULT_LIST_DOCUMENT_TYPE_DROPDOWN)).waitUntil(Condition.visible, DEFAULT_TIMEOUT);
        selectFromDropDown(RESULT_LIST_DOCUMENT_TYPE_DROPDOWN, documentTypeName);
        clickButtonByText(CONFIRM_BUTTON_TEXT_OK.toUpperCase());
        selectAllProperties();
    }

    private void selectAllProperties() {
        for (String s : AppConstants.propertiesResultListTexts) {
            $(By.xpath(RESULT_LIST_ADD_ATTRIBUTE)).click();
            SelenideElement dropDown = $(By.xpath(PROPERTIES_IN_RESULT_LIST));
            dropDown.click();
            selectFromDropDown(PROPERTIES_IN_RESULT_LIST, s);
            clickButtonByText(CONFIRM_BUTTON_TEXT_OK.toUpperCase());
        }
    }

    public static boolean isDocumentTypePresent() {
        for (SelenideElement option : $$(By.xpath(RESULT_LIST_DOCUMENT_TYPES_LIST))) {
            if (option.text().equals(documentTypeName)) {
                return true;
            }
        }
        return false;
    }

    public void verifyResultListDisplayed() {
        List<String> resultListTexts = Arrays.asList(AppConstants.resultListTexts);
        for (SelenideElement resultListProperties : $$(By.xpath(CARD_LIST_ITEM))) {
            if (resultListTexts.contains(resultListProperties.text())) {
                resultListProperties.shouldBe(Condition.visible);
            }
        }
    }

    public void addResultList() {
        clickAddResultListButton();
        selectResultListDocumentType();
        clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
        getToastMessage().waitUntil(Condition.appears, ASYNC_TIMEOUT);
        waitUntilToastMessageDisappear();
    }
}