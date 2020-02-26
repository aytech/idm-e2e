package steps;

import com.codeborne.selenide.Condition;
import configuration.AppConstants;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ShortCutPage;

import static com.codeborne.selenide.Selenide.page;

public class ShortCutPageStepDefinitions {

    @When("^User clicks on My Documents Shortcut$")
    public void userClicksOnMyDocumentsShortcut() {
        page(ShortCutPage.class).clickMyDocuments();
    }

    @Then("^User clicks on Recently Modified Shortcut$")
    public void userClicksOnRecentlyModifiedShortcut() {
        page(ShortCutPage.class).clickRecentlyModifiedShortcut();
    }

    @Then("^User clicks on Chat Attachments Shortcut$")
    public void userClicksOnChatAttachmentsShortcut() {
        page(ShortCutPage.class).clickChatAttachmentsShortcut();
    }

    @Then("^User clicks on Templates Shortcut$")
    public void userClicksOnTemplatesShortcut() {
        page(ShortCutPage.class).clickTemplatesShortcut();
    }

    @Then("^User clicks on Trash Shortcut$")
    public void userClicksOnTrashShortcut() {
        page(ShortCutPage.class).clickTrashShortcut();
    }

    @Then("^User clicks on Favorites Shortcut$")
    public void userClicksOnFavoritesShortcut() {
        page(ShortCutPage.class).clickFavoritesShortcut();
    }

    @Then("^User expands Saved Searches shortcut$")
    public void userExpandsSavedSearchesShortcut() {
        ShortCutPage page = page(ShortCutPage.class);
        page.clickSavedSearchesShortcut();
        page.waitSearchListToBeDisplayed();
        page.getSavedSearchList().should(Condition.exist);
        page.getSavedSearchList().shouldBe(Condition.visible);
    }

    @Then("^User Verifies that Saved Searches dropdown is expanded$")
    public void userVerifiesThatSavedSearchesDropdownIsExpanded() {
        ShortCutPage page = page(ShortCutPage.class);
        page.waitSearchListToBeDisplayed();
        page.getSavedSearchList().should(Condition.exist);
        page.getSavedSearchList().shouldBe(Condition.visible);
    }

    @Then("^User opens Manage Searches Modal$")
    public void userOpensManageSearchesModal() {
        page(ShortCutPage.class).openManageSearchesModal();
    }

    @Then("^User clicks on Updated Saved Search$")
    public void userClicksOnUpdatedSavedSearch() {
        page(ShortCutPage.class).clickSavedSearchesLink(AppConstants.SAVE_SEARCH_EDIT_FOLDER);
    }

    @Then("^User clicks on Saved Search$")
    public void userClicksOnSavedSearch() {
        page(ShortCutPage.class).clickSavedSearchesLink(AppConstants.SAVE_SEARCH_NAME);
    }

    @Then("^User expands Saved Search New folder$")
    public void userExpandsSavedSearchFolder() {
        ShortCutPage page = page(ShortCutPage.class);
        page.clickSavedSearchesLink(AppConstants.SAVE_SEARCH_NEW_FOLDER);
        page.waitSearchListToBeDisplayed();
        page.getSavedSearchList().should(Condition.exist);
        page.getSavedSearchList().shouldBe(Condition.visible);
    }

    @Then("^User clicks on Saved Search List Item$")
    public void userClicksOnSavedSearchListItem() {
        page(ShortCutPage.class).clickSavedSearchesLink(AppConstants.SAVE_SEARCH_NEW_FOLDER_CHILD);
    }
}
