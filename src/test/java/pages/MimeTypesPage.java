package pages;

import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import configuration.XPathSelectors;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.*;

public class MimeTypesPage extends BasePage {

    public SelenideElement getPage() {
        return $(By.xpath(MIME_TYPES_PAGE));
    }

    public void waitTillExists() {
        waitForLoadingIndicators(DEFAULT_TIMEOUT);
        getPage().waitUntil(exist, DEFAULT_TIMEOUT);
    }

    private void clickOnAdd() {
        $(By.xpath(ADD_MIME_TYPE_BUTTON)).click();
    }

    private void enterNewFormValues() {
        $(By.xpath(String.format(ADD_MIME_TYPE_FORM, "name"))).setValue(MIME_TYPE_NAME);
        $(By.xpath(String.format(ADD_MIME_TYPE_FORM, "extension"))).setValue(MIME_TYPE_EXTENSION);
        $(By.xpath(String.format(ADD_MIME_TYPE_FORM, "value"))).setValue(MIME_TYPE_VALUE);
    }

    private void clickOnAddYesButton() {
        $(By.xpath(ADD_MIME_TYPE_MODAL_YES_BUTTON)).click();
    }

    public SelenideElement getTableRowByText(String mimeType) {
        return $(By.xpath(String.format(MIME_TYPE_TABLE_ROW, mimeType)));
    }

    public void deleteMimeType(String value) {
        getTableRowByText(value).click();
        $(By.xpath(DELETE_MIME_TYPE_BUTTON)).click();
        $(By.xpath(DELETE_MIME_TYPE_MODAL_YES_BUTTON)).click();
    }

    public SelenideElement findMimeType() {
        return $(By.xpath(XPathSelectors.MIME_TYPE_ROW));
    }

    public void addMimeType() {
        if (findMimeType().exists()) {
            deleteMimeType(MIME_TYPE_EXTENSION);
            getToastMessage().waitUntil(exist, DEFAULT_TIMEOUT);
            waitUntilToastMessageDisappear();
        }
        clickOnAdd();
        enterNewFormValues();
        clickOnAddYesButton();
    }

    public void selectMimeType() {
        $(By.xpath(MIME_TYPE_ROW)).click();
    }

    public void clickOnEdit() {
        $(By.xpath(EDIT_MIME_TYPE_BUTTON)).click();
    }

    public void editMimeTypeName() {
        $(By.xpath(String.format(ADD_MIME_TYPE_FORM, "name"))).setValue(EDIT_MIME_TYPE_NAME);
    }

    public void clickOnEditYesButton() {
        $(By.xpath(ADD_MIME_TYPE_MODAL_YES_BUTTON)).click();
        waitForLoadingIndicators(DEFAULT_TIMEOUT);
        getToastMessage().waitUntil(disappears, AppConstants.DEFAULT_TIMEOUT);
    }

    public void editMimeType() {
        findMimeType();
        selectMimeType();
        clickOnEdit();
        editMimeTypeName();
        clickOnEditYesButton();
    }
}