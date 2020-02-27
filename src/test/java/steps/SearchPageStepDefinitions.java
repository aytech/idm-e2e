package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import configuration.Configuration;
import configuration.SystemConfiguration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.*;
import static pages.DocumentTypePage.documentTypeName;

public class SearchPageStepDefinitions {

    private static String resultListCountText;

    @Given("^Search component is rendered$")
    public void userIsOnSearchPage() {
        page(SearchPage.class).waitTillRendered();
    }

    @When("^Search container is displayed$")
    public void Search_container_is_displayed() {
        page(SearchPage.class).open();
    }

    @And("^No result is displayed$")
    public void noResultIsDisplayed() {
        SearchPage page = page(SearchPage.class);
        page.close();
        page.verifyCardListGone();
    }

    @Then("^User Searches by clicking Search Button$")
    public void userSearchesByClickingOnSearchButton() {
        page(SearchPage.class).search();
    }

    @Then("^User searches by Checked out by me shortcut$")
    public void userSearchesCheckedOutByMe() {
        page(SearchPage.class).clickCheckedOutByMeShortcutLink();
    }

    @Then("^User searches by Created by me shortcut$")
    public void userSearchesByCreatedByMeShortcut() {
        page(SearchPage.class).clickCreatedByMeShortcutLink();
    }

    @And("^Search dropdown remains open$")
    public void searchDropdownRemainsOpen() {
        page(SearchPage.class).isSearchDropdownDisplayed();
    }

    @When("^User checks out new document from document details page$")
    public void userChecksOutNewDocumentFromDocumentDetailsPage() {
        page(DocumentDetailActionBarPage.class).checkOutDocument();
    }

    @When("^User deletes document from document details page$")
    public void userDeletesDocumentFromDocumentDetailsPage() {
        SelenideElement documentTab = page(TabsPage.class).getTab(DocumentDetailPage.documentName);
        page(DocumentDetailActionBarPage.class).deleteDocument();
        if (documentTab != null) {
            documentTab.waitUntil(Condition.disappears, ASYNC_TIMEOUT);
        }
    }

    @Then("^User searches by Deleted by me shortcut$")
    public void userSearchesByDeletedByMeShortcut() {
        page(SearchPage.class).clickDeletedByMeShortcutLink();
    }

    @Then("^User archives document from document details page$")
    public void userArchivesDocumentFromDocumentDetailsPage() {
        page(DocumentDetailActionBarPage.class).archiveDocument();
    }

    @Then("^User fills form to search document by name$")
    public void userSelectsDocumentName() throws IllegalAccessException {
        SearchPage page = page(SearchPage.class);
        page.selectEntityType(SystemConfiguration.documentType);
        page.selectAttribute(AppConstants.ATTRIBUTES_NAME_TEXT);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setTextSearchValue(DocumentDetailPage.documentName);
    }

    @When("^Search advanced field is expanded$")
    public void searchAdvancedFieldIsExpanded() {
        page(SearchPage.class).expandAdvancedSearch();
    }

    @Then("^User selects Archived from dropdown$")
    public void userSelectsArchivedFromDropdown() {
        page(SearchPage.class).selectState(STATE_ARCHIVED);
    }

    @Then("^User selects Deleted from dropdown$")
    public void userSelectsDeletedFromDropdown() {
        page(SearchPage.class).selectState(STATE_DELETED);
    }

    @And("^Archived document is displayed in the result list$")
    public void userCanFindDocumentByNameAmongArchivedDocuments() {
        page(CardListSearchResultPage.class).verifyDocumentExistsInSearchResults();
    }

    @Then("^Deleted document is displayed in the result list$")
    public void deletedDocumentIsDisplayedInTheResultList() {
        page(CardListSearchResultPage.class).verifyDocumentExistsInSearchResults();
    }

    @Then("^User clicks Search button$")
    public void userClicksSearchButton() {
        page(SearchPage.class).clickSearchButton();
    }

    @And("^Search result text is displayed$")
    public void searchResultTextIsDisplayed() {
        page(SearchResultToolbarPage.class).verifySearchResultText();
    }

    @And("^Search result contains the document$")
    public void searchResultContainsTheDocument() {
        page(CardListSearchResultPage.class).verifyDocumentExistsInSearchResults();
    }

    @And("^XQuery for entity type was generated$")
    public void xQueryWasGenerated() throws IllegalAccessException {
        String xQuery = String.format("/%s[@%s = \"%s\"]",
                SystemConfiguration.documentType.replaceAll("\\s", "_"),
                AppConstants.ATTRIBUTES_NAME_TEXT, DocumentDetailPage.documentName);
        page(SearchPage.class).verifyXQuerySearchValue(xQuery);
    }

    @And("^Result contains documents$")
    public void resultContainsDocuments() {
        CardListSearchResultPage page = page(CardListSearchResultPage.class);
        page.getSearchResult().shouldHave(sizeGreaterThan(0));
        BasePage.waitForLoadingIndicators(AppConstants.ASYNC_TIMEOUT);
    }

    @And("^Result contains no documents$")
    public void resultContainsNoDocuments() {
        page(CardListSearchResultPage.class).verifySearchResultEmpty();
    }

    @When("^User opens Shortcut Menu$")
    public void userOpensShortcutMenu() {
        page(SearchPage.class).clickShortcutButton();
    }

    @Then("^User sorts the document by Modified Date$")
    public void userSortsTheDocumentByModifiedDate() {
        SearchPage page = page(SearchPage.class);
        page.selectSortingOption(MODIFIED_DATE);
        page.clickSortingArrow();
    }

    @Then("^User sorts the document by Created Date$")
    public void userSortsTheDocumentByCreatedDate() {
        SearchPage page = page(SearchPage.class);
        page.selectSortingOption(CREATED_DATE);
        page.clickSortingArrow();
    }

    @And("^User verifies the modified document$")
    public void userVerifiesModifiedDocument() {
        CardListSearchResultPage page = page(CardListSearchResultPage.class);
        page.selectFirstDocumentFromResultList();
        page.verifyDocumentFileName();
    }

    @When("^User navigates to Control Center$")
    public void userClicksOnControlCenterIcon() {
        page(SearchPage.class).openControlCenter();
    }

    @Then("^User performs a search$")
    public void userPerformsASearch() {
        SearchPage searchPage = page(SearchPage.class);
        searchPage.selectEntityType(AppConstants.IDM_SAVE_SEARCH_DOCUMENT_TYPE);
        searchPage.clickSearchButton();
    }

    @Then("^User Gets Result Count$")
    public void userGetsResultCount() {
        SearchPageStepDefinitions.resultListCountText = page(SearchResultToolbarPage.class).getSearchCount().getText().trim();
    }

    @Then("^User verifies Save Search button is displayed$")
    public void userVerifiesSaveSearchButtonIsDisplayed() {
        SearchPage searchPage = page(SearchPage.class);
        searchPage.getSaveSearchButton().should(Condition.exist);
        searchPage.getSaveSearchButton().shouldBe(Condition.visible);
    }

    @Then("^User clicks on Save Search button$")
    public void userClicksOnSaveSearchButton() {
        page(SearchPage.class).clickSaveSearchButton();
    }

    @Then("^User makes another search$")
    public void userMakesAnotherSearch() {
        SearchPage searchPage = page(SearchPage.class);
        searchPage.selectEntityType(AppConstants.IDM_SAVE_SEARCH_DOCUMENT_TYPE_NEW);
        searchPage.clickSearchButton();
    }

    @Then("^User verifies the results for saved search shortcut$")
    public void userVerifiesTheResultsForSavedSearchShortcut() {
        SearchResultToolbarPage page = page(SearchResultToolbarPage.class);
        page.waitForLoadingIndicators(AppConstants.ASYNC_TIMEOUT);
        page.getSearchCount().shouldHave(Condition.matchesText(resultListCountText));
    }

    @Then("^User performs a search for newly created document type$")
    public void userPerformsASearchForNewlyCreatedDocumentType() {
        SearchPage searchPage = page(SearchPage.class);
        searchPage.open();
        searchPage.selectEntityType(documentTypeName);
        searchPage.clickSearchButton();
        searchPage.waitForLoadingIndicators(ASYNC_TIMEOUT);
    }

    @Then("^User searches document by short value$")
    public void userSearchesForNewlyCreatedShortValueDocument() {
        SearchPage page = page(SearchPage.class);
        page.selectEntityType(documentTypeName);
        page.selectAttribute(SHORT_ATTRIBUTE_NAME);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setTextSearchValue(SHORT_DATA_TYPE_VALUE);
        page.clickSearchButton();
    }


    @Then("^User searches document by long value$")
    public void userSearchesForNewlyCreatedLongValueDocument() {
        SearchPage page = page(SearchPage.class);
        page.selectEntityType(documentTypeName);
        page.selectAttribute(LONG_ATTRIBUTE_NAME);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setTextSearchValue(LONG_DATA_TYPE_VALUE);
        page.clickSearchButton();
    }

    @Then("^User searches document by decimal value$")
    public void userSearchesForNewlyCreatedDecimalValueDocument() {
        SearchPage page = page(SearchPage.class);
        page.selectEntityType(documentTypeName);
        page.selectAttribute(DECIMAL_ATTRIBUTE_NAME);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setTextSearchValue(DECIMAL_DATA_TYPE_VALUE);
        page.clickSearchButton();
    }

    @Then("^User searches document by Double value$")
    public void userSearchesForNewlyCreatedDoubleValueDocument() {
        SearchPage page = page(SearchPage.class);
        page.selectEntityType(documentTypeName);
        page.selectAttribute(DOUBLE_ATTRIBUTE_NAME);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setTextSearchValue(DOUBLE_DATA_TYPE_VALUE);
        page.clickSearchButton();
    }

    @Then("^User searches document by GUID value$")
    public void userSearchesForNewlyCreatedGuidValueDocument() {
        SearchPage page = page(SearchPage.class);
        page.selectEntityType(documentTypeName);
        page.selectAttribute(GUID_ATTRIBUTE_NAME);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setTextSearchValue(UUID_DATA_TYPE_VALUE);
        page.clickSearchButton();
    }

    @Then("^User searches document by Date value$")
    public void userSearchesForNewlyCreatedDateValueDocument() {
        SearchPage page = page(SearchPage.class);
        page.selectEntityType(documentTypeName);
        page.selectAttribute(DATE_ATTRIBUTE_NAME);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setValueWithPicker("03/13/2019");
        page.clickSearchButton();
    }

    @Then("^User searches document by Time value$")
    public void userSearchesForNewlyCreatedTimeValueDocument() {
        SearchPage page = page(SearchPage.class);
        page.selectEntityType(documentTypeName);
        page.selectAttribute(TIME_ATTRIBUTE_NAME);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setValueWithPicker("00:00:00");
        page.clickSearchButton();
    }

    @Then("^User searches document by Timestamp value$")
    public void userSearchesForNewlyCreatedTimestampValueDocument() {
        SearchPage page = page(SearchPage.class);
        page.selectEntityType(documentTypeName);
        page.selectAttribute(TIMESTAMP_ATTRIBUTE_NAME);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setValueWithPicker("03/13/2019, 00:00:00");
        page.clickSearchButton();
    }

    @Then("^User searches document by true Boolean value$")
    public void userSearchesForNewlyCreatedTrueBooleanValueDocument() {
        SearchPage page = page(SearchPage.class);
        page.selectEntityType(documentTypeName);
        page.selectAttribute(BOOLEAN_ATTRIBUTE_NAME);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setValueFromDropDown("true");
        page.clickSearchButton();
    }

    @Then("^User searches document by false Boolean value$")
    public void userSearchesForNewlyCreatedFalseBooleanValueDocument() {
        SearchPage page = page(SearchPage.class);
        page.selectEntityType(documentTypeName);
        page.selectAttribute(BOOLEAN_ATTRIBUTE_NAME);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setValueFromDropDown("false");
        page.clickSearchButton();
    }

    @Then("^User searches document by value set value$")
    public void userSearchesForNewlyCreatedValueSetValueDocument() {
        SearchPage page = page(SearchPage.class);
        page.selectEntityType(documentTypeName);
        page.selectAttribute(VALUESET_ATTRIBUTE_NAME);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setValueFromDropDown(ADDING_VALUE_NAME);
        page.clickSearchButton();
    }

    @Then("^User searches for newly created document$")
    public void userSearchesForNewlyCreatedDocument() {
        SearchPage page = page(SearchPage.class);
        page.open();
        page.selectEntityType(documentTypeName);
        page.selectAttribute(AppConstants.ATTRIBUTES_NAME_TEXT);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setTextSearchValue(DocumentDetailPage.documentName);
        page.clickSearchButton();
        page.waitForLoadingIndicators(ASYNC_TIMEOUT);
    }

    @Then("^User performs a search for newly created documents$")
    public void userPerformsASearchForNewlyCreatedDocuments() {
        SearchPage page = page(SearchPage.class);
        page.open();
        page.selectEntityType(documentTypeName);
        page.selectAttribute(AppConstants.ATTRIBUTES_NAME_TEXT);
        page.selectOperation(AppConstants.EQUALS_OPERATOR);
        page.setTextSearchValue(DocumentDetailPage.documentName);
        page.clickSearchButton();
        page.waitForLoadingIndicators(ASYNC_TIMEOUT);
    }
}