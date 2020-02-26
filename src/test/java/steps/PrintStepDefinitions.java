package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.PrintPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class PrintStepDefinitions {

    @Then("^User adds Printer Credentials$")
    public void userAddsPrinterCredentials() {
        PrintPage page = page(PrintPage.class);
        page.navigateToManageServices();
        page.addCredentials();
    }

    @Then("^User configures Printer$")
    public void userConfiguresPrinter() {
        PrintPage page = page(PrintPage.class);
        page.navigateToAcceptPrinterTab();
        page.configurePrinter();
    }

    @And("^User verifies the Printer$")
    public void userVerifiesThePrinter() {
        PrintPage page = page(PrintPage.class);
        page.navigateToPrintersTab();
        page.getPrinter().should(exist);
        page.getPrinter().shouldBe(visible);
    }
}