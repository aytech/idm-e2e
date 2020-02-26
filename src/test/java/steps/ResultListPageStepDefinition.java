package steps;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.ResultListPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.*;

public class ResultListPageStepDefinition {

    @Then("^User adds Result list Configuration$")
    public void userSelectsTheDocumentTypeFromTheDropdown() {
       page(ResultListPage.class).addResultList();
    }

    @Then("^User verifies Added Result list$")
    public void userChecksForNewlyAddedResultList() {
        Assert.assertTrue(ResultListPage.isDocumentTypePresent());
    }

    @And("^User verifies Result list for document type$")
    public void userVerifiesResultList() {
        ResultListPage page = page(ResultListPage.class);
        page.verifyResultListDisplayed();
    }
}