package pages;

import configuration.XPathSelectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static configuration.AppConstants.*;
import static configuration.XPathSelectors.*;
import static configuration.XPathSelectors.INBOUND_WORKFLOW;

public class IONConfigurationPage extends BasePage {

    private void addOutputParameter() {
        $(By.xpath(ADD_OUTPUT_PARAMETER)).click();
        selectFromDropDown(IDM_VALUE_DROPDOWN, configuration.AppConstants.STATUS);
        $(By.xpath(XPathSelectors.ION_VALUE)).setValue("MDS_Status");
    }

    public void addWorkflowConfiguration(String workflowName) {
        selectDocumentTypeFromConfigurationList();
        clickAddNewWorkflowConfiguration();
        setWorkflowName(workflowName);
        addOutputParameter();
        clickButtonByText(CONFIRM_BUTTON_TEXT_OK.toUpperCase());
        getToastMessage().shouldBe(visible);
        waitUntilToastMessageDisappear();
    }

    public void selectDocumentTypeFromConfigurationList() {
        $(By.xpath(DOCUMENT_TYPE_CONFIGURATION_LIST)).click();
    }

    private void setWorkflowName(String name) {
        $(By.xpath(WORKFLOW_NAME)).setValue(name);
    }

    private void clickAddNewWorkflowConfiguration() {
        $(By.xpath(ION_CONFIGURATION_ADD_WORKFLOW_BUTTON)).click();
    }

    public void verifyStatusOfTheAttribute() {
        $(By.xpath(APPROVED_STATUS)).waitUntil(appear, ASYNC_TIMEOUT);
    }

    private void startWorkFlow() {
        $(By.xpath(START_WORKFLOW_BUTTON)).click();
        $(By.xpath(INBOUND_WORKFLOW)).click();
    }

    public void triggerWorkflow() {
        startWorkFlow();
        getToastMessage();
        $(By.xpath(TOAST_MESSAGE)).waitUntil(disappear, ASYNC_TIMEOUT);
    }

    public void switchToAttributesTab() {
        $(By.xpath(XPathSelectors.DOCUMENT_TAB_ATTRIBUTES)).waitUntil(visible, ASYNC_TIMEOUT)
                .click();
    }

    public void setStatus(String StatusValue) {
        switchToAttributesTab();
        selectFromDropDown(STATUS_ATTRIBUTE_DROPDOWN, StatusValue);
    }
}