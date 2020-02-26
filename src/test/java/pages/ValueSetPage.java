package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import configuration.XPathSelectors;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.*;

public class ValueSetPage extends BasePage {
    public static String valueSetName;

    public void addValueSet(String dataType) {
        clickOnNewValueSetButton();
        getNewValueSetPopup().should(Condition.exist);
        getNewValueSetPopup().shouldBe(Condition.visible);
        setNewValueSetDisplayName();
        selectFromDropDown(VALUE_SET_DATATYPE_DROPDOWN, dataType);
        clickButtonByText(CONFIRM_BUTTON_TEXT.toUpperCase());
        waitForLoadingIndicators(VALUE_SET_TIMEOUT);
        $(By.xpath(TOAST_MESSAGE)).waitUntil(Condition.appears, ASYNC_TIMEOUT);
    }

    public void addValues(String value) {
        if (!isDateORTimePickerDisplayed()) {
            $(By.xpath(VALUE_SET_VALUE)).setValue(value);
        } else if (isDatePickerDisplayed()) {
            setDateValue();
        } else {
            setTimeValue();
        }
        clickButtonByText(OK_BUTTON_TEXT);
        $(By.xpath(TOAST_MESSAGE)).waitUntil(Condition.disappear, ASYNC_TIMEOUT);
        clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }

    private void addInvalidValues(String value) {
        $(By.xpath(VALUE_SET_VALUE)).setValue(value);
    }

    private void clickOnNewValueSetButton() {
        $(By.xpath(NEW_VALUE_SET)).click();
    }

    private SelenideElement getNewValueSetPopup() {
        return $(By.xpath(INFOR_MODAL));
    }

    private void setNewValueSetDisplayName() {
        generateRandomValueSetDisplayName();
        $(By.xpath(VALUE_SET_DISPLAY_NAME)).setValue(valueSetName);
    }

    public void editValueSetDisplayName() {
        navigateToGeneralTab();
        generateRandomValueSetDisplayName();
        $(By.xpath(VALUE_SET_GENERAL_DISPLAY_NAME)).setValue(valueSetName);
    }

    public SelenideElement getSaveChangesButton() {
        return $(By.xpath(SAVE_CHANGES_BUTTON_VALUE_SET));
    }

    public void editValuesNameAndValue(String value) {
        navigateToValuesTab();
        selectValuesValueRowByName(ADDING_VALUE_NAME);
        clickOnValuesEditButton();
        editValuesName();
        editValuesValue(value);
        clickButtonByText(CONFIRM_BUTTON_TEXT_OK);
        clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
    }

    private void clickOnValuesEditButton() {
        $(By.xpath(VALUE_SET_EDIT_BUTTON)).click();
    }

    private void editValuesValue(String value) {
        $(By.xpath(VALUE_SET_VALUE)).clear();
        $(By.xpath(VALUE_SET_VALUE)).setValue(value);
    }

    private void selectValuesValueRowByName(String rowValue) {
        $(By.xpath(String.format(VALUE_SET_TABLE_VALUE, rowValue))).click();
    }

    private void editValuesName() {
        $(By.xpath(VALUES_NAME)).clear();
        $(By.xpath(VALUES_NAME)).setValue("2");
    }

    private void navigateToValuesTab() {
        $(By.xpath(VALUE_SET_VALUES_TAB)).click();
    }

    private void navigateToGeneralTab() {
        $(By.xpath(VALUE_SET_GENERAL_TAB)).click();
    }

    public void addStringValue() {
        clickOnValuesAddButton();
        addValueName();
        addValues(STRING_DATA_TYPE_VALUE);
    }

    public void addInvalidValue(String value) {
        clickOnValuesAddButton();
        addValueName();
        addInvalidValues(value);
    }

    private void clickOnValuesAddButton() {
        $(By.xpath(VALUES_ADD_BUTTON)).click();
    }

    public void searchForSavedValueSet() {
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        for (SelenideElement valueSet : $$(By.xpath(ENTITY_LIST))) {
            if (valueSet.getText().equals(valueSetName)) {
                valueSet.click();
                break;
            }
        }
    }

    private void addValueName() {
        $(By.xpath(VALUES_NAME)).setValue(ADDING_VALUE_NAME);
    }

    private void setDateValue() {
        selectDatePicker();
        $(By.xpath(DATE_PICKER_TODAY_BUTTON)).click();
    }

    private void setTimeValue() {
        selectTimePicker();
        $(By.xpath(DATE_TIME_PICKER_OK_BUTTON)).click();
    }

    private void selectDatePicker() {
        $(By.xpath(DATE_PICKER_ICON)).click();
        $(By.xpath(DATE_PICKER_CALENDER)).should(Condition.appear);
    }

    private void selectTimePicker() {
        $(By.xpath(TIME_PICKER_ICON)).click();
        $(By.xpath(TIME_PICKER_CALENDER)).should(Condition.appear);
    }

    public void deleteValueSet() {
        $(By.xpath(DELETE_BUTTON_VALUE_SET)).click();
        clickButtonByText(CONFIRM_BUTTON_TEXT.toUpperCase());
        waitForLoadingIndicators(VALUE_SET_TIMEOUT);
        $(By.xpath(TOAST_MESSAGE)).waitUntil(Condition.appears, ASYNC_TIMEOUT);
    }

    public void setTextSearchValueValueSet(String value) {
        waitForLoadingIndicators(VALUE_SET_TIMEOUT);
        $(By.xpath(TOAST_MESSAGE)).waitUntil(Condition.disappears, ASYNC_TIMEOUT);
        $(By.xpath(VALUE_SET_ENTITY_SEARCH_INPUT)).setValue(value);
    }

    public ElementsCollection verifyEntityListEmpty() {
        return $$(By.xpath(VALUE_SET_ENTITY_LIST));
    }

    public SelenideElement getToastMessage() {
        return $(By.xpath(TOAST_MESSAGE));
    }

    public SelenideElement errorToolTips() {
        return $(By.xpath(VALUE_ERROR_TOOLTIP));
    }

    private boolean isDateORTimePickerDisplayed() {
        return $(By.xpath(VALUE_SET_DATE_TIME_VALUE)).is(Condition.exist);
    }

    private boolean isDatePickerDisplayed() {
        return $(By.xpath(DATE_PICKER_ICON)).is(Condition.exist);
    }

    private void generateRandomValueSetDisplayName() {
        valueSetName = RandomStringUtils.random(7, true, false);
    }

    public void deleteNewlyCreatedValueSet() {
        if (isValueSetDisplayed()) {
            $(By.linkText(valueSetName)).click();
            waitForLoadingIndicators(VALUE_SET_TIMEOUT);
            deleteValueSet();
            setTextSearchValueValueSet(valueSetName);
            verifyEntityListEmpty().shouldHaveSize(0);
        }
    }

    public void addStatusValueSet(String dataType) {
        clickOnNewValueSetButton();
        getNewValueSetPopup().should(Condition.exist);
        getNewValueSetPopup().shouldBe(Condition.visible);
        setNewValueSetDisplayName();
        selectFromDropDown(VALUE_SET_DATATYPE_DROPDOWN, dataType);
        clickButtonByText(CONFIRM_BUTTON_TEXT.toUpperCase());
        waitForLoadingIndicators(VALUE_SET_TIMEOUT);
        addStatusValue(APPROVED, "20");
        getToastMessage().waitUntil(Condition.exist, DEFAULT_TIMEOUT);
        waitUntilToastMessageDisappear();
        addStatusValue(DRAFT, "10");
        clickHeaderActionButtonControlCenter(SAVE_CHANGES_BUTTON);
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        getToastMessage().waitUntil(Condition.exist, DEFAULT_TIMEOUT);
        getToastMessage().shouldBe(Condition.visible);
        waitUntilToastMessageDisappear();
    }

    private void addStatusValue(String Name, String Value) {
        clickOnValuesAddButton();
        $(By.xpath(VALUES_NAME)).setValue(Name);
        $(By.xpath(VALUE_SET_VALUE)).setValue(Value);
        clickButtonByText(OK_BUTTON_TEXT);
    }

    public void waitEntityListToBeDisplayed() {
        $(By.xpath(VALUE_SET_ENTITY_LIST)).waitUntil(exist, VALUE_SET_TIMEOUT);
    }

    public boolean isValueSetDisplayed() {
        return $(By.xpath(String.format(VALUE_SET_LINK, valueSetName))).isDisplayed();
    }
}