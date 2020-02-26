package steps;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import pages.MimeTypesPage;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.*;

public class MimeTypesStepDefinitions {

    @Then("^User adds mime type$")
    public void userAddsMimeType() {
        MimeTypesPage page = page(MimeTypesPage.class);
        page.addMimeType();
    }

    @Then("^Verify mime type is added in the mime types table$")
    public void mimeTypeIsAddedMimeTypesTable() {
        MimeTypesPage page = page(MimeTypesPage.class);
        page.getTableRowByText(MIME_TYPE_NAME).should(exist);
        page.getTableRowByText(MIME_TYPE_EXTENSION).should(exist);
        page.getTableRowByText(MIME_TYPE_VALUE).should(exist);
    }

    @Then("^User removes previously added mime type and verifies it is deleted$")
    public void userRemovesPreviouslyAddedMimeType() {
        MimeTypesPage page = page(MimeTypesPage.class);
        SelenideElement row = page.getTableRowByText(MIME_TYPE_VALUE);
        page.deleteMimeType(MIME_TYPE_VALUE);
        row.shouldNot(exist);
    }

    @Then("^User edits mime type$")
    public void userEditsMimeType() {
        MimeTypesPage page = page(MimeTypesPage.class);
        page.editMimeType();
    }

    @Then("^User verifies mime type is updated$")
    public void userVerifiesMimeTypeIsUpdated() {
        MimeTypesPage page = page(MimeTypesPage.class);
        page.getTableRowByText(EDIT_MIME_TYPE_NAME).should(exist);
        page.getTableRowByText(MIME_TYPE_EXTENSION).should(exist);
        page.getTableRowByText(MIME_TYPE_VALUE).should(exist);
    }
}