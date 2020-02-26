package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import configuration.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static configuration.AppConstants.*;
import static configuration.ClassSelectors.BUSY_INDICATOR;
import static configuration.ClassSelectors.MODAL_PAGE_CONTAINER;
import static configuration.IDSelectors.*;
import static configuration.XPathSelectors.*;

public class BasePage {

    public static String mappingValue;

    private void login() throws Exception {
        if (isLoggedIn()) {
            return;
        }
        String user = Configuration.getProperty(IDM_USER);
        String password = Configuration.getProperty(IDM_PASSWORD);
        if (user == null || password == null) {
            throw new Exception("Login credentials not found");
        }
        $(By.id(IDSelectors.LOGIN_FORM_USER)).setValue(user);
        $(By.id(IDSelectors.LOGIN_FORM_PASSWORD)).setValue(password);
        $(By.id(IDSelectors.LOGIN_FORM_SUBMIT)).click();
    }

    public void loginToGrid() throws IllegalAccessException {
        SelenideElement inputUser = $(By.id(LOGIN_FORM_USER_GRID));
        SelenideElement inputPassword = $(By.id(LOGIN_FORM_PASSWORD_GRID));
        SelenideElement buttonSubmit = $(By.id(LOGIN_FORM_SUBMIT_GRID));

        if (inputUser.exists()) {
            inputUser.setValue(Configuration.getProperty(IDM_USER));
            inputPassword.setValue(Configuration.getProperty(IDM_PASSWORD));
            buttonSubmit.click();
        }
    }

    private boolean isLoggedIn() {
        return !$(By.id(IDSelectors.LOGIN_FORM)).is(exist);
    }

    private boolean isRelatedInformationWidgetOpen() {
        return $(By.xpath(RELATED_INFORMATION_PANEL)).is(visible);
    }

    private void closeRelatedInformationWidget() {
        getWebDriver().switchTo().defaultContent();
        if (isRelatedInformationWidgetOpen()) {
            SelenideElement button = $(By.cssSelector(CSSSelectors.RELATED_INFORMATION_BUTTON));
            SelenideElement widget = $(By.xpath(RELATED_INFORMATION_PANEL));
            button.click();
            widget.waitUntil(Condition.disappears, AppConstants.ASYNC_TIMEOUT);
        }
    }

    public void maximizeBrowserWindow() {
        getWebDriver().manage().window().maximize();
        // Browser nodes do not support maximize sometimes, explicitly setting
        Dimension dimension = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
        getWebDriver().manage().window().setSize(dimension);
    }

    public void switchToIdmInMingle() throws Exception {
        if (!isLoggedIn()) {
            login();
        }
        $(By.id(IDSelectors.MINGLE_SWITCH)).click();
        $(By.tagName(TagSelectors.IDM_MINGLE_TAG))
                .$(By.cssSelector(CSSSelectors.IDM_MINGLE))
                .waitUntil(exist, ASYNC_TIMEOUT)
                .click();
        sleep(AppConstants.DEFAULT_TIMEOUT);
        closeRelatedInformationWidget();
        switchToClientFrame();
    }

    public void switchToClientFrame() {
        getWebDriver().switchTo().defaultContent();
        ElementsCollection frames = $$(By.tagName(TagSelectors.IFRAME_TAG));

        for (int index = 0; index < frames.size(); index++) {
            getWebDriver().switchTo().frame(index);
            if ($(By.id(IDSelectors.CLIENT_FRAME)).is(exist)) {
                getWebDriver().switchTo().frame(0);
                $(By.id(IDSelectors.BODY))
                        .waitUntil(exist, AppConstants.DEFAULT_TIMEOUT);
                break;
            }
            getWebDriver().switchTo().defaultContent();
        }
    }

    void clickButtonByText(String buttonText) {
        SelenideElement inforButtonSet = $(By.xpath(MODAL_BUTTON_SET));
        if (inforButtonSet.exists()) {
            ElementsCollection buttonSet = inforButtonSet.$$(By.tagName("button"));
            clickButtonInModal(buttonSet, buttonText);
            $(By.xpath(INFOR_MODAL_CONTAINER)).waitUntil(Condition.disappears, DEFAULT_TIMEOUT);
            $(By.xpath(MODAL_PAGE_CONTAINER_NEW)).waitUntil(Condition.disappears, ASYNC_TIMEOUT);
            return;
        }
        SelenideElement modalContainer = $(By.className(MODAL_PAGE_CONTAINER));
        if (modalContainer.exists()) {
            ElementsCollection buttonSet = modalContainer.$$(By.cssSelector(CSSSelectors.BUTTONSET_BUTTONS));
            clickButtonInModal(buttonSet, buttonText);
            modalContainer.waitUntil(Condition.disappears, ASYNC_TIMEOUT);
        }
    }

    private void clickButtonInModal(ElementsCollection buttonSet, String buttonText) {
        for (SelenideElement button : buttonSet) {
            if (button.text().trim().equals(buttonText)) {
                button.click();
                break;
            }
        }
    }

    /**
     * @deprecated use {@link #clickButtonByText} instead
     */
    void clickButtonInModalNew(String buttonText) {
        SelenideElement modal = $(By.xpath(XPathSelectors.MODAL_PAGE_CONTAINER_NEW));
        for (SelenideElement button : $$(By.xpath(XPathSelectors.MODAL_BUTTONS))) {
            if (button.text().equals(buttonText)) {
                button.click();
                modal.waitUntil(Condition.disappears, AppConstants.DEFAULT_TIMEOUT);
                break;
            }
        }
    }

    /**
     * Get form field that contains specified ID. Form fields have common
     * E2E selector, this method allows for filtering
     *
     * @return SelenideElement
     */
    SelenideElement getDocumentAttributesFormFieldByPartialID(String id) {
        for (SelenideElement formField : $$(By.xpath(XPathSelectors.FORM_TEXT_FIELDS))) {
            if (formField.attr("id").contains(id)) {
                return formField;
            }
        }
        return null;
    }

    public static String getPrimaryFileName() throws IllegalAccessException {
        String fileName = Configuration.getProperty(IDM_FILENAME_PRIMARY);
        return fileName.substring(fileName.lastIndexOf(File.separator) + 1);
    }

    /**
     * @deprecated Use {#link waitForLoadingIndicators} instead
     */
    public void waitForLoadingIndicator() {
        SelenideElement busyIndicator = $(By.className(BUSY_INDICATOR));
        if (busyIndicator.exists()) {
            busyIndicator.waitUntil(Condition.disappear, ASYNC_TIMEOUT);
        }
    }

    public static void waitForLoadingIndicators(int timeout) {
        for (SelenideElement indicator : $$(By.className(BUSY_INDICATOR))) {
            if (indicator.isDisplayed()) {
                indicator.waitUntil(Condition.disappears, timeout);
            }
        }
    }

    public void setMappingAttributeValue() {
        generateRandomMappingValue();
        $(By.xpath(XPathSelectors.FORM_TEXT_FIELDS)).setValue(mappingValue);
    }

    private void generateRandomMappingValue() {
        mappingValue = String.format(
                RandomStringUtils.random(7, true, false));
    }

    public void clickHeaderActionButtonControlCenter(String buttonText) {
        for (SelenideElement button : $$(By.xpath(HEADER_ACTION_BUTTONS))) {
            if (button.text().equals(buttonText)) {
                button.click();
                break;
            }
            waitForLoadingIndicators(ASYNC_TIMEOUT);
        }
    }

    public SelenideElement getToastMessage() {
        waitForLoadingIndicators(ASYNC_TIMEOUT);
        return $(By.xpath(TOAST_MESSAGE)).waitUntil(exist, ASYNC_TIMEOUT);
    }

    public boolean isInforModalDisplayed() {
        return $(By.xpath(INFOR_MODAL)).is(Condition.visible);
    }

    public void selectFromDropDown(String dropDownXpath, String optionText) {
        SelenideElement dropDown = $(By.xpath(dropDownXpath));
        dropDown.click();
        for (SelenideElement dropDownOption : dropDown.$$(By.tagName("option"))) {
            if (dropDownOption.getText().trim().equals(optionText)) {
                dropDownOption.click();
                break;
            }
        }
    }

    public void waitUntilToastMessageDisappear() {
        $(By.xpath(TOAST_MESSAGE)).waitUntil(disappear, DEFAULT_TIMEOUT);
    }

    public SelenideElement getModal() {
        return $(By.xpath(INFOR_MODAL));
    }

    public SelenideElement errorToolTips() {
        return $(By.xpath(VALUE_ERROR_TOOLTIP));
    }

    public void openRelationInformationWidget() {
        getWebDriver().switchTo().defaultContent();
        if (!isRelatedInformationWidgetOpen()) {
            SelenideElement button = $(By.cssSelector(CSSSelectors.RELATED_INFORMATION_BUTTON));
            SelenideElement widget = $(By.xpath(RELATED_INFORMATION_PANEL));
            button.click();
            widget.waitUntil(visible, AppConstants.ASYNC_TIMEOUT);
        }
    }
}