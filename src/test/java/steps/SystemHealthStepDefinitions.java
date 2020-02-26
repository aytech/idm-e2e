package steps;

import cucumber.api.java.en.Then;
import pages.SystemHealthPage;
import static com.codeborne.selenide.Selenide.page;

public class SystemHealthStepDefinitions {

    @Then("^User performs Self Healing$")
    public void userPerformsSelfHealing(){
        SystemHealthPage page = page(SystemHealthPage.class);
        page.performSelfHealing();
    }

    @Then("^User verifies result is displayed$")
    public void userVerifiesResultIsDisplayed(){
        SystemHealthPage page = page(SystemHealthPage.class);
        page.verifyResultExists();
    }
}
