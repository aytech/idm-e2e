package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.LanguagesPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.page;
import static configuration.AppConstants.*;

public class LanguagesStepDefinitions {

    @Then("^User adds several languages$")
    public void userAddsSeveralLanguages() {
        LanguagesPage page = page(LanguagesPage.class);
        page.addLanguage(LANGUAGE_ARABIC);
        page.addLanguage(LANGUAGE_CZECH);
        page.addLanguage(LANGUAGE_GERMAN);
        page.addLanguage(LANGUAGE_GREEK);
        page.addLanguage(LANGUAGE_HINDI);
    }

    @And("^Verify that added languages appear in the list$")
    public void languageShouldBeAddedToPage() {
        page(LanguagesPage.class).getLanguageTableRow(LANGUAGE_ARABIC).should(exist);
        page(LanguagesPage.class).getLanguageTableRow(LANGUAGE_CZECH).should(exist);
        page(LanguagesPage.class).getLanguageTableRow(LANGUAGE_GERMAN).should(exist);
        page(LanguagesPage.class).getLanguageTableRow(LANGUAGE_GREEK).should(exist);
       page(LanguagesPage.class).getLanguageTableRow(LANGUAGE_HINDI).should(exist);
    }

    @Then("^User removes previously added languages$")
    public void userRemovesLanguages() {
        page(LanguagesPage.class).deleteLanguageRow(LANGUAGE_ARABIC);
        page(LanguagesPage.class).deleteLanguageRow(LANGUAGE_CZECH);
        page(LanguagesPage.class).deleteLanguageRow(LANGUAGE_GERMAN);
        page(LanguagesPage.class).deleteLanguageRow(LANGUAGE_GREEK);
        page(LanguagesPage.class).deleteLanguageRow(LANGUAGE_HINDI);
    }

    @And("^Verify that removed languages are not in the list$")
    public void languagesShouldNotBeOnThePage() {
        page(LanguagesPage.class).getLanguageTableRow(LANGUAGE_ARABIC).shouldNot(exist);
        page(LanguagesPage.class).getLanguageTableRow(LANGUAGE_CZECH).shouldNot(exist);
        page(LanguagesPage.class).getLanguageTableRow(LANGUAGE_GERMAN).shouldNot(exist);
        page(LanguagesPage.class).getLanguageTableRow(LANGUAGE_GREEK).shouldNot(exist);
        page(LanguagesPage.class).getLanguageTableRow(LANGUAGE_HINDI).shouldNot(exist);
    }
}