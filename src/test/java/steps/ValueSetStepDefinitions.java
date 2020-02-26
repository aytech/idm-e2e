package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.*;

import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.*;
import static pages.BasePage.waitForLoadingIndicators;
import static pages.ValueSetPage.valueSetName;


public class ValueSetStepDefinitions {

    @Then("^User creates String datatype valueset$")
    public void userCreatesStringDataTypeValueSet() {
        page(ValueSetPage.class).addValueSet(STRING);
    }

    @Then("^User creates Short datatype valueset$")
    public void userCreatesShortDataTypeValueSet() {
        page(ValueSetPage.class).addValueSet(SHORT);
    }

    @Then("^User creates Long datatype valueset$")
    public void userCreatesLongDataTypeValueSet() {
        page(ValueSetPage.class).addValueSet(LONG);
    }

    @Then("^User creates Decimal datatype valueset$")
    public void userCreatesDecimalDataTypeValueSet() {
        page(ValueSetPage.class).addValueSet(DECIMAL);
    }

    @Then("^User creates Double datatype valueset$")
    public void userCreatesDoubleDataTypeValueSet() {
        page(ValueSetPage.class).addValueSet(DOUBLE);
    }

    @Then("^User creates UUID datatype valueset$")
    public void userCreatesUuidDataTypeValueSet() {
        page(ValueSetPage.class).addValueSet(UUID);
    }

    @Then("^User creates Date datatype valueset$")
    public void userCreatesDateDataTypeValueSet() {
        page(ValueSetPage.class).addValueSet(DATE);
    }

    @Then("^User creates Time datatype valueset$")
    public void userCreatesTimeDataTypeValueSet() {
        page(ValueSetPage.class).addValueSet(TIME);
    }

    @Then("^User creates TimeStamp datatype valueset$")
    public void userCreatesTimeStampDataTypeValueSet() {
        page(ValueSetPage.class).addValueSet(TIMESTAMP);
    }

    @And("User adds invalid Short value")
    public void userAddsInvalidShortValue() {
        page(ValueSetPage.class).addInvalidValue("ABC#$%");
    }

    @Then("^Validation error for invalid Short value should be displayed$")
    public void validationErrorForInvalidShortValue() {
        page(ValueSetPage.class).errorToolTips().shouldHave(Condition.matchesText("Must be a short integer, Minimum value is -32767, Maximum value is 32767"));
    }

    @And("User adds invalid Long value")
    public void userAddsInvalidLongValue() {
        page(ValueSetPage.class).addInvalidValue("ABC#$%");
    }

    @Then("^Validation error for invalid Long value should be displayed$")
    public void validationErrorForInvalidLongValue() {
        page(ValueSetPage.class).errorToolTips().shouldHave(Condition.matchesText("Must be a long integer, Minimum value is -9007199254740990, Maximum value is 9007199254740990"));
    }

    @And("User adds invalid Decimal value")
    public void userAddsInvalidDecimalValue() {
        page(ValueSetPage.class).addInvalidValue("ABC#$%");
    }

    @Then("^Validation error for invalid Decimal value should be displayed$")
    public void validationErrorForInvalidDecimalValue() {
        page(ValueSetPage.class).errorToolTips().shouldHave(Condition.matchesText("Must be a number, Minimum value is -9007199254740990, Maximum value is 9007199254740990"));
    }

    @And("User adds invalid Double value")
    public void userAddsInvalidDoubleValue() {
        page(ValueSetPage.class).addInvalidValue("ABC#$%");
    }

    @Then("^Validation error for invalid Double value should be displayed$")
    public void validationErrorForInvalidDoubleValue() {
        page(ValueSetPage.class).errorToolTips().shouldHave(Condition.matchesText("Must be a double"));
    }

    @And("User adds invalid UUID value")
    public void userAddsInvalidGuidValue() {
        page(ValueSetPage.class).addInvalidValue("ABC#$%");
    }

    @Then("^Validation error for invalid GUID value should be displayed$")
    public void validationErrorForInvalidGUIDValue() {
        page(ValueSetPage.class).errorToolTips().shouldHave(Condition.matchesText("Must be a GUID"));
    }

    @And("User adds invalid Time value")
    public void userAddsInvalidTimeValue() {
        page(ValueSetPage.class).addInvalidValue("03:00");
    }

    @Then("^Validation error for invalid Time value should be displayed$")
    public void validationErrorForInvalidTimeValue() {
        page(ValueSetPage.class).errorToolTips().shouldHave(Condition.matchesText("Invalid time"));
    }

    @And("User adds invalid Date value")
    public void userAddsInvalidDateValue() {
        page(ValueSetPage.class).addInvalidValue("34:00:00");
    }

    @Then("^Validation error for invalid Date value should be displayed$")
    public void validationErrorForInvalidDateValue() {
        page(ValueSetPage.class).errorToolTips().shouldHave(Condition.matchesText("Invalid date"));
    }

    @And("User adds invalid TimeStamp value")
    public void userAddsInvalidTimeStampValue() {
        page(ValueSetPage.class).addInvalidValue("03/13/2019, 00:00");
    }

    @Then("^Validation error for invalid TimeStamp value should be displayed$")
    public void validationErrorForInvalidTimeStampValue() {
        page(ValueSetPage.class).errorToolTips().shouldHave(Condition.matchesText("Invalid date"));
    }

    @Then("^User adds value of type String to ValueSet$")
    public void userAddsValueOfTypeStringToValueSet() {
        page(ValueSetPage.class).addStringValue();
    }

    @Then("^User adds value of type Short to ValueSet$")
    public void userAddsValueOfTypeShortToValueSet() {
        page(ValueSetPage.class).addValues(SHORT_DATA_TYPE_VALUE);
    }

    @Then("^User adds value of type Long to ValueSet$")
    public void userAddsValueOfTypeLongToValueSet() {
        page(ValueSetPage.class).addValues(LONG_DATA_TYPE_VALUE);
    }

    @Then("^User adds value of type Decimal to ValueSet$")
    public void userAddsValueOfTypeDecimalToValueSet() {
        page(ValueSetPage.class).addValues(DECIMAL_DATA_TYPE_VALUE);
    }

    @Then("^User adds value of type Double to ValueSet$")
    public void userAddsValueOfTypeDoubleToValueSet() {
        page(ValueSetPage.class).addValues(DOUBLE_DATA_TYPE_VALUE);
    }

    @Then("^User adds value of type UUID to ValueSet$")
    public void userAddsValueOfTypeUuidToValueSet() {
        page(ValueSetPage.class).addValues(UUID_DATA_TYPE_VALUE);
    }

    @Then("^User adds value of type Date to ValueSet$")
    public void userAddsValueOfTypeDateToValueSet() {
        page(ValueSetPage.class).addValues(" ");
    }

    @Then("^User adds value of type Time to ValueSet$")
    public void userAddsValueOfTypeTimeToValueSet() {
        page(ValueSetPage.class).addValues(" ");
    }

    @Then("^User adds value of type TimeStamp to ValueSet$")
    public void userAddsValueOfTypeTimeStampToValueSet() {
        page(ValueSetPage.class).addValues(" ");
    }

    @And("^User edits String valueset$")
    public void editStringValueSet() {
        ValueSetPage page = page(ValueSetPage.class);
        page.editValueSetDisplayName();
        page.getSaveChangesButton().should(Condition.appear);
        page.editValuesNameAndValue("123@");
        page.getSaveChangesButton();
    }

    @And("^User edits Short valueset$")
    public void userEditShortValueSet() {
        ValueSetPage page = page(ValueSetPage.class);
        page.editValueSetDisplayName();
        page.getSaveChangesButton().should(Condition.appear);
        page.editValuesNameAndValue("456");
    }

    @And("^User edits Long valueset$")
    public void userEditLongValueSet() {
        ValueSetPage page = page(ValueSetPage.class);
        page.editValueSetDisplayName();
        page.getSaveChangesButton().should(Condition.appear);
        page.editValuesNameAndValue("123890");
    }

    @And("^User edits Decimal valueset$")
    public void userEditDecimalValueSet() {
        ValueSetPage page = page(ValueSetPage.class);
        page.editValueSetDisplayName();
        page.getSaveChangesButton().should(Condition.appear);
        page.editValuesNameAndValue("67.89");
    }

    @And("^User edits Double valueset$")
    public void userEditDoubleValueSet() {
        ValueSetPage page = page(ValueSetPage.class);
        page.editValueSetDisplayName();
        page.getSaveChangesButton().should(Condition.appear);
        page.editValuesNameAndValue("677.899");
    }

    @And("^User edits Date valueset$")
    public void userEditDateValueSet() {
        ValueSetPage page = page(ValueSetPage.class);
        page.editValueSetDisplayName();
        page.getSaveChangesButton().should(Condition.appear);
        page.editValuesNameAndValue("08/20/1995");
    }

    @And("^User edits Time valueset$")
    public void userEditTimeValueSet() {
        ValueSetPage page = page(ValueSetPage.class);
        page.editValueSetDisplayName();
        page.getSaveChangesButton().should(Condition.appear);
        page.editValuesNameAndValue("12:12:12");
    }

    @And("^User edits TimeStamp valueset$")
    public void userEditTimeStampValueSet() {
        ValueSetPage page = page(ValueSetPage.class);
        page.editValueSetDisplayName();
        page.getSaveChangesButton().should(Condition.appear);
        page.editValuesNameAndValue("03/13/2019, 00:00:00");
    }

    @And("^User edits UUID valueset$")
    public void userEditUuidValueSet() {
        ValueSetPage page = page(ValueSetPage.class);
        page.editValueSetDisplayName();
        page.getSaveChangesButton().should(Condition.appear);
        page.editValuesNameAndValue("ef0e6718-1db6-4fe7-829c-1950a2f56e01");
    }

    @And("^User searches for saved Value Set$")
    public void userSearchesForSavedValueSet() {
        page(ValueSetPage.class).searchForSavedValueSet();
    }

    @And("^User deletes Value Set$")
    public void userDeleteValueSet() {
        page(ValueSetPage.class).deleteValueSet();
    }

    @And("^User verifies Value Set does not Exist$")
    public void userVerifiesValueSetDoesNotExist() {
        ValueSetPage page = page(ValueSetPage.class);
        page.setTextSearchValueValueSet(valueSetName);
        page.verifyEntityListEmpty().shouldHaveSize(0);
    }

    @Then("^User Creates New Value Set with Values$")
    public void newValueSetWithValues() {
        page(SearchPage.class).openControlCenter();
        page(ControlCenterHomePage.class).clickLink(VALUE_SET_TEXT);
        ValueSetPage page = page(ValueSetPage.class);
        page.addValueSet(STRING);
        page.addStringValue();
        waitForLoadingIndicators(VALUE_SET_TIMEOUT);
        page.getToastMessage().waitUntil(Condition.exist, DEFAULT_TIMEOUT);
        page.getToastMessage().shouldBe(Condition.visible);
        page.waitUntilToastMessageDisappear();
        page(DocumentTypePage.class).clickHeaderActionButtonControlCenter(BACK_TO_DOCUMENTS_BUTTON);
    }

    @And("^User deletes newly created Value Set$")
    public void userDeletesNewlyCreatedValueSet() {
        page(ControlCenterSidebarPage.class).open();
        page(ControlCenterSidebarPage.class).selectAdministrationOption(VALUE_SET_TEXT);
        page(ValueSetPage.class).waitEntityListToBeDisplayed();
        page(ControlCenterSidebarPage.class).closeControlCenterLeftPanel();
        page(ValueSetPage.class).deleteNewlyCreatedValueSet();
    }
}