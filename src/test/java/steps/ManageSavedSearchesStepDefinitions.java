package steps;


import com.codeborne.selenide.Condition;
import configuration.AppConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.ManageSearchesPage;

import static com.codeborne.selenide.Selenide.page;

public class ManageSavedSearchesStepDefinitions {

    @Then("^User edits Save Search Folder$")
    public void userEditsSaveSearchFolder()  {
        page(ManageSearchesPage.class).editSavedSearchesFolder();
    }

    @Then("^User Creates New Folder for Saved Search$")
    public void userCreatesNewFolderForSavedSearch()  {
        page(ManageSearchesPage.class).createNewFolder();
    }

    @And("^User clicks on close button on Manage Saved Searches Dialog$")
    public void userClicksOnCloseButtonOnManageSavedSearchesDialog()  {
        page(ManageSearchesPage.class).clickCloseOnManageSavedSearches();
    }

    @Then("^User select and delete Search Item$")
    public void userSelectAndDeleteSearchItem() {
        ManageSearchesPage page = page(ManageSearchesPage.class);
        page.selectManageSearchItemForDeleting();
    }

    @Then("^User verifies that the list is empty$")
    public void userVerifiesThatTheListIsEmpty() {
        ManageSearchesPage page = page(ManageSearchesPage.class);
        page.getManageSearchModal().shouldHave(Condition.matchesText(AppConstants.EMPTY_SAVED_SEARCHES_LIST_TEXT));
    }

    @Then("^User verifies Manage Search Modal Window$")
    public void userVerifiesManageSearchModalWindow() {
        ManageSearchesPage page = page(ManageSearchesPage.class);
        page.getManageSearchModalWindow().should(Condition.exist);
        page.getManageSearchModalWindow().shouldBe(Condition.visible);
    }

    @Then("^User verifies Manage Search ButtonSet$")
    public void userVerifiesManageSearchButtonSet() {
        ManageSearchesPage page = page(ManageSearchesPage.class);
        page.getManageSearchButtonSet().should(Condition.exist);
        page.getManageSearchButtonSet().shouldBe(Condition.visible);
    }
}
