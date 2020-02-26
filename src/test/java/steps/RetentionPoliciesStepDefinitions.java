package steps;

import configuration.AppConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.ControlCenterHomePage;
import pages.ControlCenterSidebarPage;
import pages.RetentionPolicyPage;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.RETENTION_POLICY_ACTION_DROPDOWN;

public class RetentionPoliciesStepDefinitions {

    @Then("^User creates new Retention Policy for Purge Delete Documents$")
    public void userCreatesNewRetentionPolicyForPurgeDeletedDocuments() throws IllegalAccessException {
        page(RetentionPolicyPage.class).addRetentionPolicy(RETENTION_POLICY_ACTION_DROPDOWN, PURGE_DELETED_DOCUMENTS);
    }

    @Then("^User Runs Retention Policy$")
    public void userRunsRetentionPolicy() {
        page(SearchPage.class).openControlCenter();
        page(ControlCenterHomePage.class).clickLink(AppConstants.RETENTION_POLICIES);
        RetentionPolicyPage page = page(RetentionPolicyPage.class);
        page.waitPageToBeDisplayed();
        page.run();
    }

    @Then("^User creates new Retention Policy for Delete Active Documents$")
    public void userCreatesNewRetentionPolicyForDeleteActiveDocuments() throws IllegalAccessException {
        page(RetentionPolicyPage.class).addRetentionPolicy(RETENTION_POLICY_ACTION_DROPDOWN, DELETE_ACTIVE_DOCUMENTS);
    }

    @Then("^User creates and run new Retention Policy for Delete Active Documents$")
    public void userCreatesAndRunNewRetentionPolicyForDeleteActiveDocuments() {
        RetentionPolicyPage page = page(RetentionPolicyPage.class);
        page(RetentionPolicyPage.class).addRetentionPolicy(RETENTION_POLICY_ACTION_DROPDOWN, DELETE_ACTIVE_DOCUMENTS);
        page.waitPageToBeDisplayed();
        page.run();
    }

    @Then("^User edits and runs the Retention Policy for Delete Archive Documents$")
    public void userEditsAndRunsTheRetentionPolicyForDeleteArchiveDocuments() {
        RetentionPolicyPage page = page(RetentionPolicyPage.class);
        page.editRetentionPolicy(RETENTION_POLICY_ACTION_DROPDOWN, DELETE_ARCHIVED_DOCUMENTS);
        page.waitPageToBeDisplayed();
        page.run();
    }
    
    @And("^User deletes retention policy$")
    public void userDeletesRetentionPolicy() {
        page(ControlCenterSidebarPage.class).navigateToControlCenterHome();
        page(ControlCenterHomePage.class).clickLink(RETENTION_POLICIES);
        RetentionPolicyPage page = page(RetentionPolicyPage.class);
        page.waitPageToBeDisplayed();
        page.delete();
    }
}