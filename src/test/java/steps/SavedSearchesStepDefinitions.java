package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import cucumber.api.java.en.Then;
import pages.SavedSearchesModalPage;

import static com.codeborne.selenide.Selenide.page;

public class SavedSearchesStepDefinitions {

    @Then("^User verifies Save Search Modal Window$")
    public void userVerifiesSaveSearchModalWindow() {
        SelenideElement modal = page(SavedSearchesModalPage.class).getPage();
        modal.should(Condition.exist);
        modal.shouldBe(Condition.visible);
    }

    @Then("^User sets name for new Save Search$")
    public void userSetsNameForNewSaveSearch() {
        page(SavedSearchesModalPage.class).setSaveSearchName(AppConstants.SAVE_SEARCH_NAME);
    }

    @Then("^User sets name for New Saved Search$")
    public void userSetsNameForNewSavedSearch() {
        page(SavedSearchesModalPage.class).setSaveSearchName(AppConstants.SAVE_SEARCH_NEW_FOLDER_CHILD);
    }

    @Then("^User sets name for Saved Search and selects newly created folder from the dropdown$")
    public void userSetsNameForSavedSearchAndSelectsNewlyCreatedFolderFromTheDropdown() {
        page(SavedSearchesModalPage.class).selectFolderForSavedSearch(AppConstants.SAVE_SEARCH_NEW_FOLDER,AppConstants.SAVE_SEARCH_NEW_FOLDER_CHILD);
    }
}
