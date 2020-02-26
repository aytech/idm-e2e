package steps;

import configuration.Configuration;
import cucumber.api.java.en.Given;
import pages.BasePage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.*;

public class IndexPageStepDefinitions {
    @Given("^User is on index page$")
    public void userIsOnIndexPage() throws Exception {
        Configuration.readConfiguration();
        if (BasePage.getEnvironment().equals(ENV_DEVELOPMENT)) {
            Map<String, String> urls = Configuration.buildEnvironmentUrls();
            System.out.println(
                    String.format("Testing in development environment, GRID URL: %s, Client URL: %s",
                            urls.get(GRID_KEY), urls.get(CLIENT_KEY)));
            open(urls.get(GRID_KEY));
            page(BasePage.class).loginToGrid();
            open(urls.get(CLIENT_KEY));
            page(BasePage.class).maximizeBrowserWindow();
        } else {
            System.out.println("Testing in staging environment, URL: " + IDM_CLIENT_STAGING_URL);
            open(Configuration.getProperty(IDM_CLIENT_STAGING_URL));
            page(BasePage.class).maximizeBrowserWindow();
            page(BasePage.class).switchToIdmInMingle();
        }
    }
}
