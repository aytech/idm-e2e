package steps;

import com.codeborne.selenide.Condition;
import configuration.AppConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;
import pages.DocumentDetailPage;
import pages.DocumentTypePage;
import pages.SearchPage;


import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.*;
import static pages.BasePage.waitForLoadingIndicators;

public class BasePageStepDefinitions {

    @And("^Confirmation toast message should be displayed$")
    public void confirmationToastMessageIsDisplayed() {
        BasePage page = page(BasePage.class);
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        page.getToastMessage().waitUntil(Condition.exist, DEFAULT_TIMEOUT);
        page.getToastMessage().shouldBe(Condition.visible);
    }

    @Then("^User navigates to search page and navigates back to ControlCenter$")
    public void UserNavigatesToSearchPageAndNavigatesBackToControlCenter() {
        page(DocumentTypePage.class).clickHeaderActionButtonControlCenter(BACK_TO_DOCUMENTS_BUTTON);
        page(SearchPage.class).waitTillRendered();
        page(SearchPage.class).openControlCenter();
    }

    @When("^User searches document for newly created document type$")
    public void userSearchesAndSelectDocumentForDocumentType() throws IllegalAccessException {
        SearchPage searchPage = page(SearchPage.class);
        searchPage.selectEntityType(DocumentTypePage.documentTypeName);
        searchPage.selectAttribute(AppConstants.ATTRIBUTES_NAME_TEXT);
        searchPage.selectOperation(AppConstants.EQUALS_OPERATOR);
        searchPage.setTextSearchValue(DocumentDetailPage.documentName);
        searchPage.clickSearchButton();
    }
}