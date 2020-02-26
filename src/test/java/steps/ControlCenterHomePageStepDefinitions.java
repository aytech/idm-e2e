package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.Then;
import pages.*;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.*;

public class ControlCenterHomePageStepDefinitions {

    @Then("^control center Menu is displayed$")
    public void controlCenterMenuIsDisplayed() {
        page(ControlCenterSidebarPage.class).open();
        ElementsCollection menuItems = page(ControlCenterHomePage.class).getMenuItems();
        menuItems.shouldHave(texts(controlCenterMenuTexts));
    }

    @Then("^User opens Document Type administration$")
    public void userClickOnDocumentTypeUnderAdministration() {
        page(ControlCenterSidebarPage.class).selectAdministrationOption(DOCUMENT_TYPE_TEXT);
        page(DocumentTypePage.class).waitEntityListToBeDisplayed();
    }

    @Then("^User expands Control Center navigation panel$")
    public void userExpandsControlCenterNavigationPanel() {
        page(ControlCenterSidebarPage.class).open();
    }

    @Then("^User navigates to result list configuration page$")
    public void userClickOnResultListUnderConfiguration() {
        page(ControlCenterSidebarPage.class).navigateToControlCenterHome();
        page(ControlCenterHomePage.class).clickLink(RESULT_LIST);
        page(ResultListPage.class).getResultListPage();
    }

    @Then("^User navigates to Value Set administration page$")
    public void userClicksOnValueSetInHomepage() {
        page(ControlCenterHomePage.class).clickLink(VALUE_SET_TEXT);
    }


    @Then("^User navigates to ION Configuration administration page$")
    public void userClicksOnIONConfigurationInHomepage() {
        page(ControlCenterHomePage.class).clickLink(ION_CONFIGURATION_TEXT);
    }

    @Then("^User navigates to document type configuration page$")
    public void userOpensDocumentTypeConfiguration() {
        page(ControlCenterHomePage.class).clickLink(DOCUMENT_TYPE_TEXT);
        DocumentTypePage page = page(DocumentTypePage.class);
        page.waitEntityListToBeDisplayed();
        page.selectDocumentType();
        page.getGeneralTab().should(Condition.exist);
        page.getGeneralTab().should(Condition.visible);
    }

    @Then("^User navigates to Retention Policies Page$")
    public void userNavigatesToRetentionPoliciesPage() {
        page(ControlCenterHomePage.class).clickLink(RETENTION_POLICIES);
        page(RetentionPolicyPage.class).waitPageToBeDisplayed();
    }

    @Then("^User navigates to Languages configuration page$")
    public void userClicksOnLanguagesInHomepage() {
        page(ControlCenterHomePage.class).clickLink(LANGUAGES_TEXT);
        page(LanguagesPage.class).waitTillExists();
    }

    @Then("^User navigates to Document Type Filter configuration page$")
    public void userNavigatesToDocumentTypeFilterPage() {
        page(ControlCenterHomePage.class).clickLink(DOCUMENT_TYPE_FILTER);
        page(DocumentTypeFilterPage.class).waitTillExists();
    }

    @Then("^User navigates to Mime Types page$")
    public void userNavigatesToMimeTypesPage() {
        page(ControlCenterHomePage.class).clickLink(MIME_TYPE_TEXT);
        page(MimeTypesPage.class).waitTillExists();
    }

    @Then("^User navigates to Print Configuration Page$")
    public void userNavigatesToPrintConfigurationPage() {
        page(ControlCenterHomePage.class).clickLink(PRINT_TEXT);
        page(PrintPage.class).waitTillExists();
    }

    @Then("^User navigates to Self Healing page$")
    public void userNavigatesToSelfHealingPage() {
        page(ControlCenterHomePage.class).clickLink(SELF_HEALING_TEXT);
    }

    @Then("^User navigates to Security Audit Log configuration page$")
    public void userNavigatesToSecurityAuditLogConfigurationPage() {
        page(ControlCenterSidebarPage.class).open();
        page(ControlCenterSidebarPage.class).selectConfigurationOption(SECURITY_AUDIT_LOG);
        page(SecurityAuditLogPage.class).waitTillExists();
    }
}