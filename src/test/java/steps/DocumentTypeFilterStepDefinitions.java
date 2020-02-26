package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.DocumentTypeFilterPage;
import pages.SearchPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.MDS_FILE_DOCUMENT_TYPE;
import static configuration.AppConstants.ROLE_ADMINISTRATOR;

public class DocumentTypeFilterStepDefinitions {

    @Then("^User adds role for which the filter will be applied$")
    public void userAddsRole() {
        page(DocumentTypeFilterPage.class).addFilterForRole(ROLE_ADMINISTRATOR);
    }

    @And("^Verify that added role is in the List$")
    public void roleAddedToList() {
        DocumentTypeFilterPage page = page(DocumentTypeFilterPage.class);
        page.getRole(ROLE_ADMINISTRATOR).shouldBe(exist);
        page.getRole(ROLE_ADMINISTRATOR).shouldBe(visible);
    }

    @Then("^User enables filter for newly added role$")
    public void addFilter() {
        page(DocumentTypeFilterPage.class).addFilter(ROLE_ADMINISTRATOR);
    }

    @And("^Verify that filter is applied in search stack$")
    public void verifyAppliedFilterInSearchStack() {
        SearchPage page = page(SearchPage.class);
        page.expandEntitiesDropDown();
        page.getEntityList().shouldHaveSize(2);
        page.getEntity(2).shouldHave(exactText(MDS_FILE_DOCUMENT_TYPE));
    }

    @Then("^Deletes the filter$")
    public void deleteFilter() {
        page(DocumentTypeFilterPage.class).removeRole(ROLE_ADMINISTRATOR);
    }

    @And("^Verify that filter was removed from the list$")
    public void filterShouldNotBeDisplayed() {
        page(DocumentTypeFilterPage.class).getRole(ROLE_ADMINISTRATOR).shouldNot(exist);
    }
}