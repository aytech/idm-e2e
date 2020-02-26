package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.Then;
import pages.BasePage;
import pages.SecurityAuditLogPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.ASYNC_TIMEOUT;

public class SecurityAuditLogStepDefinitions {

    @Then("^User enables Security Audit Log$")
    public void userEnablesSecurityAuditLog() {
        page(SecurityAuditLogPage.class).enableSecurityAuditLogSwitch();
    }

    @Then("^User adds and verifies DocumentType under audit logging$")
    public void userAddDocumentTypeUnderAuditLogging() {
        page(SecurityAuditLogPage.class).addDocumentTypeForAuditLog();
        page(SecurityAuditLogPage.class).getDocumentTypeUnderAuditLogging().shouldBe(Condition.visible);
    }

    @Then("^User moves and verifies DocumentType under Not logged Document Types$")
    public void userMoveDocumentTypeToNotLoggedDocumentType() {
        page(SecurityAuditLogPage.class).moveDocumentTypeToNotLoggedDocumentType();
        page(SecurityAuditLogPage.class).getNotLoggedDocumentTypes().shouldBe(Condition.visible);
    }
}