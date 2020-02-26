package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import configuration.AppConstants;
import configuration.IDSelectors;
import configuration.XPathSelectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static configuration.XPathSelectors.MANAGE_SEARCHES_BUTTONSET;

public class ManageSearchesPage extends BasePage {

    public SelenideElement getManageSearchModal() {
        return $(By.xpath(XPathSelectors.INFOR_MANAGE_SAVED_SEARCHES_MODAL));
    }

    public void selectManageSearchItemForDeleting() {
        SelenideElement manageSearchList = $(By.xpath(XPathSelectors.MANAGE_SEARCHES_LIST_ITEM));
        ElementsCollection listItems = manageSearchList.$$(By.tagName("li"));
        // Need to loop backward as the array was going out of Index
        for (int index = listItems.size() - 1; index >= 0; index--) {
            if (listItems.get(index).getText().contains((AppConstants.SAVE_SEARCH_PREFIX))) {
                listItems.get(index).click();
                clickButtonByTextManageSearches(AppConstants.DELETE_BUTTON_TEXT);
                clickYesOnDialog();
            }
        }
    }

    public void selectManageSearchItem() {
        SelenideElement manageSearchList = $(By.xpath(XPathSelectors.MANAGE_SEARCHES_LIST_ITEM));
        for (SelenideElement listItems : manageSearchList.$$(By.tagName("li"))) {
            if (listItems.getText().contains((AppConstants.SAVE_SEARCH_PREFIX))) {
                listItems.click();
            }
        }
    }
    
    private void clickOnNewFolderManageSearches() {
        clickButtonByTextManageSearches(AppConstants.NEW_FOLDER_TEXT);
    }

    public void createNewFolder() {
        clickOnNewFolderManageSearches();
        setSaveSearchName(AppConstants.SAVE_SEARCH_NEW_FOLDER);
        clickOKOnDialog();
        clickCloseOnManageSavedSearches();
    }

    public void editSavedSearchesFolder() {
        selectManageSearchItem();
        clickButtonByTextManageSearches(AppConstants.EDIT_FOLDER_TEXT);
        setSaveSearchName(AppConstants.SAVE_SEARCH_EDIT_FOLDER);
        clickOKOnDialog();
        clickCloseOnManageSavedSearches();
    }

    // There are multiple Infor modal on the Page so need to write this method to identify proper one
    private void clickButtonByTextManageSearches(String buttonText) {
        SelenideElement manageSearchesButtonSet = $(By.xpath(MANAGE_SEARCHES_BUTTONSET));
        if (manageSearchesButtonSet.exists()) {
            ElementsCollection buttonSet = manageSearchesButtonSet.$$(By.tagName("button"));
            for (SelenideElement button : buttonSet) {
                if (button.text().trim().equals(buttonText)) {
                    button.click();
                    break;
                }
            }
        }
    }

    // There are atleast 3 modal button set when the manage search window is open and it is not able to click on Yes button as it tries to look
//    in the first buttonset so need to write this method to uniquely identify Yes button
    private void clickYesOnDialog() {
        $(By.xpath(XPathSelectors.MANAGE_SEARCHES_DIALOG_YES)).click();
    }

    private void clickOKOnDialog() {
        $(By.xpath(XPathSelectors.MANAGE_SEARCHES_DIALOG_OK)).click();
    }

    public SelenideElement getManageSearchModalWindow() {
        return $(By.xpath(XPathSelectors.INFOR_MODAL));
    }

    public SelenideElement getManageSearchButtonSet() {
        return $(By.xpath(XPathSelectors.MANAGE_SEARCHES_BUTTONSET));
    }

    public void clickCloseOnManageSavedSearches() {
        clickButtonByText(AppConstants.CLOSE_BUTTON_TEXT);
    }

    private void setSaveSearchName(String name) {
        waitForLoadingIndicators(AppConstants.ASYNC_TIMEOUT);
        $(By.id(IDSelectors.SAVE_SEARCH_INPUT))
                .setValue(name);
    }
}
