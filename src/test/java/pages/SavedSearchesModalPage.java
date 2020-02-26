package pages;

import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import configuration.IDSelectors;
import configuration.XPathSelectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SavedSearchesModalPage extends BasePage {

    public SelenideElement getPage() {
        return $(By.xpath(XPathSelectors.INFOR_MODAL));
    }

    public void setSaveSearchName(String name) {
        $(By.id(IDSelectors.SAVE_SEARCH_INPUT))
                .setValue(name);
        clickOKOnSaveSearch();
    }

    private void clickOKOnSaveSearch() {
        clickButtonByText(AppConstants.OK_BUTTON_TEXT);
    }

    public void selectFolderForSavedSearch(String folder,String name) {
        $(By.id(IDSelectors.SAVE_SEARCH_INPUT))
                .setValue(name);
        SelenideElement dropdown = $(By.id(IDSelectors.SAVED_SEARCH_FOLDER));
        dropdown.click();
        for (SelenideElement dropdownOption : dropdown.$$(By.tagName("option"))) {
            if (dropdownOption.text().equals(folder)) {
                dropdownOption.click();
                clickOKOnSaveSearch();
                break;
            }

        }
    }
}
