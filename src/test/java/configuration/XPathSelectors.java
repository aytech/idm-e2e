package configuration;

import static configuration.AppConstants.*;
import static pages.DocumentTypePage.documentTypeName;

public class XPathSelectors {
    public static final String ACTION_BUTTONS = "//button[@data-e2e-id=\"document-action\"]";
    public static final String ADD_DOCUMENT_BUTTON = "//button[@data-e2e-id=\"addDocumentButton\"]";
    public static final String ADVANCED_SEARCH_CONTAINER = "//a[@data-e2e-id=\"advanced-search\"]";
    public static final String ADVANCED_SEARCH_TOGGLE = "//a[@data-e2e-id=\"showMoreShortcuts\"]";
    public static final String CARD_LIST_ACTION_MENU = "//div[@data-e2e-id=\"action-menu-container\"]";
    public static final String DOCUMENT_DETAILS_ACTION_MENU = "//div[@data-e2e-id=\"document-details-action-menu\"]";
    public static final String DOCUMENT_DETAILS_MORE_ACTION_BUTTON = "//*[@data-e2e-id=\"document-details-action-menu\"]//*[@data-e2e-id=\"more-actions-button\"]";
    public static final String DOCUMENT_FILE_TAB_LINK = "//a[@data-e2e-id=\"document-tab-file\"]";
    public static final String DOCUMENT_DETAILS_LIST = "//*[@data-e2e-id=\"document-details-action-menu\"]";
    public static final String DOCUMENT_TAB_ATTRIBUTES = "//a[@data-e2e-id=\"document-tab-attributes\"]";
    public static final String DOCUMENT_TAB_PROPERTIES = "//a[@data-e2e-id=\"document-tab-properties\"]";
    public static final String FILE_UPLOAD_INPUT = "//input[@data-e2e-id=\"input-file-upload\"]";
    public static final String FORM_TEXT_FIELDS = "//input[contains(@data-e2e-id,\"form-value\")]";
    public static final String DATE_TIME_VALUE_FIELD = "//input[contains(@data-e2e-id,\"-picker\")]";
    public static final String VALUE_FIELD_DROPDOWN_SEARCH_STACK = "//idm-attribute-search//select[contains(@data-e2e-id,\"form-select\")]";
    public static final String VALUE_SET_VALUE = "//input[@id=\"valueSetValue\" or contains(@data-e2e-id, \"-picker\")]";
    public static final String VALUE_SET_DATE_TIME_VALUE = "//input[contains(@data-e2e-id, \"-picker\")]";
    public static final String TIME_PICKER_ICON = "//input[contains(@data-e2e-id,\"form-input\")]//..//*[@id=\"icon-clock\"]";
    public static final String DATE_PICKER_ICON = "//input[contains(@data-e2e-id,\"form-input\")]//..//*[@id=\"icon-calendar\"]";
    public static final String MORE_ACTIONS_BUTTON = "//a[@data-e2e-id=\"more-actions-button\"]";
    public static final String RESOURCE_IMAGE_CONTAINER = "//div[@data-e2e-id=\"resource-image-container\"]";
    public static final String SEARCH_BUTTON = "//button[@data-e2e-id=\"button-search\"]";
    public static final String SEARCH_PANEL = "//div[@data-e2e-id=\"quick-search-panel\"]";
    public static final String SELECT_ATTRIBUTE = "//select[@data-e2e-id=\"select-attribute\"]";
    public static final String SELECT_DOCUMENT_STATE = "//select[@data-e2e-id=\"select-document-state\"]";
    public static final String SELECT_ENTITY_TYPE = "//select[@data-e2e-id=\"select-entity-type\"]";
    public static final String ENTITY_TYPE_SEARCH_STACK = "//select[@data-e2e-id=\"select-entity-type\"]//option";
    public static final String SELECT_OPERATION = "//select[@data-e2e-id=\"select-operation\"]";
    public static final String CARD_LIST_ITEM = "//li[@data-e2e-id=\"card-list-item\"]";
    public static final String PREVIEW = "//*[@data-e2e-id=\"resource-image-webdav\"]";
    public static final String SEARCH_RESULT_ACTION_MENU = "//div[@data-e2e-id=\"action-menu-container\"]";
    public static final String SHORTCUT_MENU_BUTTON = "//button[@data-e2e-id=\"saved-searches-manage-button\"]";
    public static final String SORTING_ARROW = "//*[@data-e2e-id=\"sort-order-switch\"]";
    public static final String CONTROL_CENTER_BUTTON = "//button[@data-e2e-id=\"controlCenterButton\"]";
    public static final String CONTROL_CENTER_MENU = "//idm-control-center//nav[@data-e2e-id=\"control-center-menu\"]";
    public static final String CONTROL_CENTER_SIDEBAR_TOGGLE = "//button[@data-e2e-id=\"control-center-menu-toggle\"]";
    public static final String NEW_VALUE_SET = "//*[@id=\"maincontent\"]/idm-value-set//button[contains(text(), \"New Value Set\")]";
    public static final String WIZARD_CANCEL = "//button[@data-e2e-id=\"wizard-cancel\"]";
    public static final String WIZARD_NEXT = "//button[@data-e2e-id=\"wizard-next\"]";
    public static final String WIZARD_PREVIOUS = "//button[@data-e2e-id=\"wizard-previous\"]";
    public static final String WIZARD_DONE = "//button[@data-e2e-id=\"wizard-done\"]";
    public static final String DOCUMENT_TYPE_DISPLAY_NAME = "//input[@data-e2e-id=\"document-type-displayName\"]";
    public static final String VALUE_SET_DISPLAY_NAME = "//input[@id=\"new-valueset-display-name\"]";
    public static final String ATTRIBUTE_DISPLAY_NAME = "//input[@data-e2e-id=\"attribute-displayName\"]";
    public static final String ACL_TABLE_CONTAINER = "//div[@data-e2e-id=\"acl-table-container\"]";
    public static final String MODAL_PAGE_CONTAINER_NEW = "//*[@data-e2e-id=\"infor-modal\"]";
    public static final String MODAL_BUTTON_SET = "//*[@data-e2e-id=\"infor-modal-buttonset\"]";
    public static final String MODAL_BUTTONS = "//*[@data-e2e-id=\"infor-modal-buttonset\"]/button";
    public static final String SAVED_SEARCH_BUTTON = "//button[@data-e2e-id=\"save-search-button\"]";
    public static final String INFOR_MODAL = "//*[@data-e2e-id=\"infor-modal\"]";
    public static final String SEARCH_ELEMENT = "//div[@data-e2e-id=\"search-element\"]";
    public static final String ATTRIBUTE_LIST = "//div[@data-e2e-id=\"attribute-list-content\"]";
    public static final String MANAGE_SAVED_SEARCHES_BUTTON = "//button[@data-e2e-id=\"saved-searches-manage-button\"]";
    public static final String MANAGE_SEARCHES_BUTTONSET = "//div[@data-e2e-id=\"manage-saved-searches-button-set\"]";
    public static final String MANAGE_SEARCHES_LIST_ITEM = "//ul[@data-e2e-id=\"manage-saved-searches-list\"]";
    public static final String MANAGE_SEARCHES_DIALOG_YES = "//div[@data-e2e-id=\"infor-modal-buttonset\"]/button[contains(text(),\"Yes\")]";
    public static final String MANAGE_SEARCHES_DIALOG_OK = "//div[@data-e2e-id=\"infor-modal-buttonset\"]/button[contains(text(),\"OK\")]";
    public static final String ACL_ADD_BUTTON = "//button[@data-e2e-id=\"acl-add\"]";
    public static final String VALUE_ERROR_TOOLTIP = "//div[@data-e2e-id=\"form-field-error-message\"]";
    public static final String VALUE_SET_ENTITY_LIST = "//ul[@data-e2e-id=\"value-set-list\"]//li";
    public static final String SAVE_CHANGES_BUTTON_VALUE_SET = "//button[@data-e2e-id=\"value-set-save\"]";
    public static final String DELETE_BUTTON_VALUE_SET = "//button[@data-e2e-id=\"value-set-delete\"]";
    public static final String VALUES_ADD_BUTTON = "//button[@data-e2e-id=\"value-set-value-add\"]";
    public static final String VALUE_SET_DATATYPE_DROPDOWN = "//select[@data-e2e-id=\"value-set-new-data-type\"]";
    public static final String VALUE_SET_ENTITY_SEARCH_INPUT = "//input[@data-e2e-id=\"value-set-search\"]";
    public static final String DATE_PICKER_CALENDER = "//div[@data-e2e-id=\"date-picker-calendar\"]";
    public static final String TIME_PICKER_CALENDER = "//div[@data-e2e-id=\"date-picker-time\"]";
    public static final String DATE_TIME_PICKER_OK_BUTTON = "//button[@data-e2e-id=\"date-picker-confirm\"]";
    public static final String DATE_PICKER_TODAY_BUTTON = "//button[@data-e2e-id=\"date-picker-today\"]";
    public static final String RESULT_LIST_ADD_BUTTON = "//button[@data-e2e-id=\"result-list-add\"]";
    public static final String RESULT_LIST_PAGE = "//div[@data-e2e-id=\"result-list-content\"]";
    public static final String RESULT_LIST_DOCUMENT_TYPE_DROPDOWN = "//select[@data-e2e-id=\"result-list-document-type-add-list\"]";
    public static final String PROPERTIES_IN_RESULT_LIST = "//select[@data-e2e-id=\"result-list-property-add-list\"]";
    public static final String RESULT_LIST_ADD_ATTRIBUTE = "//button[@data-e2e-id=\"result-list-property-add\"]";
    public static final String RESULT_LIST_DELETE_BUTTON = "//button[@data-e2e-id=\"result-list-delete\"]";
    public static final String RESULT_LIST_DOCUMENT_TYPES_LIST = "//ul[@data-e2e-id=\"result-list-document-type-list\"]//li";
    public static final String ADDING_ROLE_BUTTON = "//button[@data-e2e-id=\"document-type-acl-add-roles-add\"]";
    public static final String OK_BUTTON_ACL = "//button[@data-e2e-id=\"document-type-acl-add-confirm\"]";
    public static final String PERMISSIONS_CHECKBOX_ACL = "//div[@data-e2e-id=\"document-type-acl-add-privileges-row\"]";
    public static final String NAME_ACL = String.format("//div[@data-e2e-id=\"acl-table-container\"]//td[contains(text(), \"%s\")]", ACL_NAME);
    public static final String ACL_NAME_FIELD = "//input[@data-e2e-id=\"document-type-acl-add-name\"]";
    public static final String ACL_DESCRIPTION_FIELD = "//textarea[@data-e2e-id=\"document-type-acl-add-description\"]";
    public static final String ROLES_LIST_DROPDOWN = "//select[@data-e2e-id=\"document-type-acl-add-roles-list\"]";
    public static final String SET_AS_DEFAULT_ACL_BUTTON = "//button[@data-e2e-id=\"document-type-acl-default\"]";
    public static final String DEFAULT_CHECK_MARK_ACL = "//idm-document-type-acl//tr[td//span[@data-e2e-id=\"document-type-acl-default-icon\"]]";
    public static final String ACL_RULES_PAGE = "//div[@data-e2e-id=\"document-type-acl-rules\"]";
    public static final String ADD_ACL_RULE_BUTTON = "//button[@data-e2e-id=\"document-type-acl-rules-add\"]";
    public static final String ACL_NAME_DROP_DOWN = "//select[@data-e2e-id=\"document-type-acl-rules-acl\"]";
    public static final String SAVE_AS_NEW_DOCUMENT_MODAL = "//div[@data-e2e-id=\"dialog-select-document-type\"]//div[@class=\"infor-modal-container\"]";
    public static final String DOCUMENT_TYPE_DROPDOWN = "//select[@data-e2e-id=\"dialog-select-document-type-dropdown\"]";
    public static final String RELATED_DOCUMENTS_RULES_PAGE = "//div[@data-e2e-id=\"document-type-related-document-rules\"]";
    public static final String ADD_RELATED_DOCUMENTS_RULE_BUTTON = "//button[@data-e2e-id=\"document-type-related-document-rules-add\"]";
    public static final String SELECT_ALL_LABEL = "//idm-search-result//label[@for=\"selectAll\"]";
    public static final String ENTITY_SEARCH_INPUT = "//input[@data-e2e-id=\"document-type-search\"]";
    public static final String ENTITY_LIST = "//ul[@data-e2e-id=\"document-type-list\"]//li";
    public static final String GENERAL_TAB = "//div[@data-e2e-id=\"document-type-general\"]";
    public static final String ATTRIBUTE_REQUIRED_LABEL = "//input[@data-e2e-id=\"document-type-attribute-required\"]//following-sibling::label";
    public static final String TEMPLATE_LABEL = "//idm-document-type-general//label[@for=\"template\"]";
    public static final String ENABLE_TEMPLATE_LABEL = "//idm-document-properties//label[@for=\"template\"]";
    public static final String SHORTCUT_MENU = "//div[@data-e2e-id=\"saved-searches-list\"]";
    public static final String CARD_HOLDER_CONTROL_CENTER_HOME = "//div[@data-e2e-id=\"control-center-home-page-cards\"]";
    public static final String SEARCH_ACTION_BUTTONS = "//div[@data-e2e-id=\"action-menu-container\"]//button//span[text()=\"%s\"]";

    //Separating Xpaths to Track date e2e tag
    public static final String NEW_DOCUMENT_TAB = "//span[@class=\"idm-tab-name\" and contains(text(), \"New Document\")]";
    public static final String SAVED_SEARCH_LIST = "//idm-saved-searches//div[@data-e2e-id=\"saved-searches-list\"]//ul[@class=\"saved-searches-list\"]";
    public static final String SAVED_SEARCH_LINK = "//a//span[@class=\"saved-search-name\"]";
    public static final String TOAST_MESSAGE = "//infor-toast-message-container//div[@class=\"infor-toast-message\"]";
    public static final String MORE_LIST = "//ul[@class=\"more-list\"]";
    public static final String DOCUMENT_TAB_LIST = "//infor-simple-tabs//li";
    public static final String DOCUMENT_TYPE_MAIN = "//div[@class=\"document-types-main\"]";
    public static final String DATATYPE_DROPDOWN = "//select[@id=\"type\"]";
    public static final String INFOR_MANAGE_SAVED_SEARCHES_MODAL = "//idm-modal-manage-saved-searches";
    public static final String HEADER_ACTION_BUTTONS = "//div[@class=\"idm-header-section-buttons\"]//button";
    public static final String DESCRIPTION_FIELD = "//input[@id=\"description\"]";
    public static final String INFOR_MODAL_CONTAINER = "div[@class=\"infor-modal-container\"]";
    public static final String CARD_HOLDER_LINKS = "//div[@class=\"card-holder\"]//a";
    public static final String MAIN_CONTAINER = "//div[@class=\"main-content-container\"]";
    public static final String CONTAINER_FLUID = "//div[@class=\"container-fluid\"]";
    public static final String DOCUMENT_TYPE_DROPDOWN_ADD_DOCUMENT = "//idm-add-document//div//input";
    public static final String DOCUMENT_TYPE_FILTER_PAGE = "//idm-control-center-configuration-document-type-filter";
    public static final String NEW_FILTER_BUTTON = "//div[@id=\"document-type-filter-actions\"]//button[contains(text(),\"New Filter\")]";
    public static final String DELETE_FILTER_BUTTON = "//div[@id=\"document-type-filter-actions\"]//button[contains(text(),\"Delete\")]";
    public static final String FILTER_ROLE_DROP_DOWN = "//select[@id=\"document-type-filters\"]";
    public static final String ENABLE_FILTER_SWITCH = "//*[@id=\"document-type-filter-main-content\"]//label[contains(text(),\"Enable Filter\")]";
    public static final String VALUES_NAME = "//dialog[@data-e2e-id=\"infor-modal\"]//input[@id=\"valueSetName\"]";
    public static final String DOCUMENT_TYPE_NEW_LIST = "//*[@id=\"new-document-modal-document-type-input\"]";
    public static final String DOCUMENT_TYPE_FILTER_DISABLED = "//idm-control-center-configuration-document-type-filter-edit//div[@class=\"row disabled\"]";
    public static final String SELECTED_DOCUMENT_TYPE_LIST_FILTER = "//div[contains(h4,\"Selected Document Types\")]//ul//li";
    public static final String SELECTED_DOCUMENT_TYPE_FILTER_INDEX = "//div[contains(h4,\"Selected Document Types\")]//ul//li";
    public static final String DOCUMENT_TYPE_INDEX_SEARCH_STACK = "//select[@data-e2e-id=\"select-entity-type\"]//option[%s]";
    public static final String DOCUMENT_TAB_SECURITY = "//a[@data-e2e-id=\"document-tab-security\"]";
    public static final String SECURITY_TAB_ACL = "//idm-document-detail-tabs//idm-document-security//div[@class=\"idm-field\"]";
    public static final String SECURITY_TAB_ACL_DROP_DOWN = "//select[@id =\"item-acl\"]";
    public static final String ERROR_POPUP = "//idm-error-modal-component";
    public static final String SORTING_DROPDOWN = "//button[@data-e2e-id=\"save-search-button\"]";
    public static final String VALUE_SET_DROPDOWN_DOCUMENT_TYPE = "//select[@id=\"valueSetEntity\"]";
    public static final String MAPPED_RELATED_ATTRIBUTE_VALUE = "//div[label[contains(text(),\"%s\")]]//div//span[contains(text(),\"%s\")]";
    public static final String PICKER_VALUE_FIELD = "//div[label[contains(text(),\"%s\")]]//input[contains(@data-e2e-id,\"picker\")]";
    public static final String VALUES_DROP_DOWN_ATTRIBUTE_FIELD = "//div[label[contains(text(),\"%s\")]]//select[contains(@data-e2e-id,\"form-select\")]";
    public static final String DOCUMENT_DETAILS_PAGE = "//idm-document-details";
    public static final String TEMPLATE_NAME = "//input[@id=\"item-template-name\"]";
    public static final String TEMPLATE_DETAILS = "//textarea[@id=\"item-template-details\"]";

    //ValueSet
    public static final String VALUE_SET_VALUES_TAB = "//span[@class=\"idm-tab-name\" and contains(text(), \"Values\")]";
    public static final String VALUE_SET_GENERAL_TAB = "//span[@class=\"idm-tab-name\" and contains(text(), \"General\")]";
    public static final String VALUE_SET_GENERAL_DISPLAY_NAME = "//input[@id=\"displayName\"]";
    public static final String VALUE_SET_TABLE_VALUE = "//idm-value-set-values//tbody//td[contains(text(), \"%s\")]";
    public static final String VALUE_SET_EDIT_BUTTON = "//idm-value-set-values//button[contains(text(), \" Edit \")]";

    //Languages
    public static final String LANGUAGES_PAGE = "//idm-control-center-configuration-languages";
    public static final String LANGUAGES_DELETE_BUTTON = "//idm-control-center-configuration-languages//div[contains(@class, \"navigation-toolbar-actions\")]//button";
    public static final String LANGUAGES_CONFIRM_YES_BUTTON = "//idm-confirmation-modal-component//button[contains(text(), \"Yes\")]";
    public static final String LANGUAGES_ADD_BUTTON = "//idm-control-center-configuration-languages//button[contains(text(), \"Add\")]";
    public static final String LANGUAGE_CONFIGURATION_PAGE = "//idm-control-center-configuration-add-language";

    // Retention Policy
    public static final String RETENTION_POLICIES_DESCRIPTION_TEXT = "//textarea[@id=\"description\"]";
    public static final String RETENTION_POLICY_ADD_BUTTON = "//div[@class=\"navigation-toolbar-actions\"]//button[contains(text(), \"Add\")]";
    public static final String RETENTION_POLICY_DELETE_BUTTON = "//div[@class=\"navigation-toolbar-actions\"]//button[contains(text(), \"Delete\")]";
    public static final String RETENTION_POLICY_ACTION_DROPDOWN = "//select[@id=\"action\"]";
    public static final String RETENTION_POLICIES_PAGE = "//idm-control-center-configuration-retention-policies";
    public static final String RETENTION_POLICY_TABLE_DATA = ("%s%s//td[contains(text(), \"%s\")]");
    public static final String RETENTION_POLICY_TABLE_DATA_RUN = ("%s%s//td[contains(text(), \"%s\")]//..//button");
    public static final String VALUE_SET_LINK = "//ul[@data-e2e-id=\"value-set-list\"]//a[contains(text(),\"%s\")]";
    public static final String ZERO_SEARCH_RESULTS = "//div[@class=\"search-count\"]//span[text()=\"0 matching documents\"]";
    public static final String RETENTION_POLICY_EDIT_BUTTON = "//div[@class=\"navigation-toolbar-actions\"]//button[contains(text(), \"Edit\")]";

    //SearchPage
    public static final String SORT_RESULTS_BY = "//button[@data-e2e-id=\"sort-order-switch\"]" ;
    public static final String SORT_BY_ACTIONS = "//div[@class=\"dropdown-selection-list\"]//a";
    public static final String SORT_RESULTS_BUTTON = "//button[@data-e2e-id=\"sort-results-button\"]";

    // Control Center Sidebar
    public static final String CONFIGURATION_TOGGLE = "//a[contains(text(), \"Configuration\")]";
    public static final String CONFIGURATION_NAV_SECTION = "//idm-control-center-menu//li[@id = \"Configuration-header\"]/ul";
    public static final String MIME_TYPE_PAGE_NAV_LINK = "//idm-control-center-menu//a[contains(text(), \"MIME Types\")]";

    // MIME Types
    public static final String MIME_TYPES_PAGE = "//idm-control-center//idm-mime-type-component";
    public static final String ADD_MIME_TYPE_BUTTON = "//idm-mime-type-component//button[contains(text(), \"Add\")]";
    public static final String ADD_MIME_TYPE_FORM = "//idm-mime-type-modal//*[@id=\"%s\"]";
    public static final String ADD_MIME_TYPE_MODAL_YES_BUTTON = "//idm-mime-type-modal//button[contains(text(),\" Yes \")]";
    public static final String DELETE_MIME_TYPE_BUTTON = "//idm-mime-type-component//button[contains(text(), \"Delete\")]";
    public static final String DELETE_MIME_TYPE_MODAL_YES_BUTTON = "//idm-confirmation-modal-component//button[contains(text(),\" Yes \")]";
    public static final String MIME_TYPE_TABLE_ROW = "//idm-mime-type-component//td[contains(text(), \"%s\")]/parent::tr";
    public static final String MIME_TYPE_ROW = String.format("//idm-mime-type-component//td[contains(text(), \"%s\")]/parent::tr",MIME_TYPE_EXTENSION);

    public static final String EDIT_MIME_TYPE_BUTTON = "//idm-mime-type-component//button[contains(text(), \"Edit\")]";
    public static final String RESULT_LIST_CARD_VIEW = "//idm-card-list-item//div[contains(text(),\"%s\")]";

    //ION Configuration
    public static final String ADD_OUTPUT_PARAMETER = "//div[contains(h3,\"Output parameters\")]//button[contains(text(), \"Add\")]";
    public static final String IDM_VALUE_DROPDOWN = "//select[@id=\"output-item0\"]";
    public static final String WORKFLOW_NAME = "//idm-ion-workflow-modal//div[label[contains(text(),\"Name\")]]//input";
    public static final String ION_CONFIGURATION_ADD_WORKFLOW_BUTTON = "//button[contains(text(),\" Add new workflow configuration \")]";
    public static final String APPROVED_STATUS = "//idm-document-attributes//div[span[contains(text(), \"APPROVED\")]]";
    public static final String ION_VALUE = "//input[@id=\"output-ion0\"]";
    public static final String INBOUND_WORKFLOW = "//idm-start-workflow-button//li//a[contains(text(),\" InboundWF \")]";
    public static final String START_WORKFLOW_BUTTON = "//idm-start-workflow-button//button[span[contains(text(), \"Start workflow\")]]";
    public static final String DOCUMENT_TYPE_CONFIGURATION_LIST = String.format("//table[@class=\"infor-datagrid-table-medium document-type-table\"]//td[contains(text(),\"%s\")]", documentTypeName);
    public static final String STATUS_ATTRIBUTE_DROPDOWN = "//div[contains(label,\"Status\")]//select[@data-e2e-id=\"form-select-dropdown\"]";

    //Print
    public static final String PRINT_CONFIGURATION_PAGE = "//idm-control-center-configuration-print";
    public static final String MANAGE_SERVICES_PRINT = "//idm-print-list//a//span[contains(text(), \"Manage Service\")]";
    public static final String ADD_PRINT_CREDENTIALS_BUTTON = "//input[@id=\"print-upload\"]";
    public static final String ACCEPT_PRINTER_TAB = "//a//span[contains(text(),\"Accept Printers\")]";
    public static final String PRINTER_TAB = "//a//span[text()=\"Printers\"]";
    public static final String INPUT_PRINTER_ID = "//input[@id=\"accept-printer-field\"]";
    public static final String ACCEPT_PRINTER_BUTTON = "//button[contains(text(),\"Accept printer\")]";
    public static final String ACCEPT_PRINTER_PAGE = "//idm-accept-printer";
    public static final String PRINTER_ROW = String.format("//idm-printers-list//td[contains(text(), \"%s\")]", PRINTER_ID);
    public static final String ATTRIBUTES_TAB = "//idm-document-attributes";
    public static final String PROPERTIES_TAB = "//idm-document-properties";

    //System Health
    public static final String SELF_HEALING_PAGE = "//idm-control-center-health-check";
    public static final String SYNCHRONIZE_THE_DATA_MODEL = "//idm-self-healing//li/a[text()=\" Synchronize the data model \"]";
    public static final String RESULT_IS_SUCCESSFUL = "//div[@class='infor-card-content']//p[contains(text(),'true')]";

    //Related Information
    public static final String RELATED_INFORMATION_FRAME = "//iframe[contains(@src, \"relatedInformation\")]";
    public static final String RELATED_DOCUMENTS_LIST = "//div[@ng-controller=\"RelatedDocumentsCtrl as src\"]//*[@id=\"listview\"]//ul//li//p";
    public static final String SHOW_IN_IDM_BUTTON = "//button[@id=\"detailListShowIDM\"]";
    public static final String RELATED_INFORMATION_PANEL = "//li[contains(@class, \"expanded\")]";

    //Security Audit Log
    public static final String DISABLE_SECURITY_AUDIT_LOG = "//idm-control-center-configuration-security-audit-log//infor-swaplist//div[@class=\"row disabled\"]";
    public static final String ENABLE_SECURITY_AUDIT_LOG_SWITCH = "//idm-control-center-configuration-security-audit-log//label[contains(text(),\"Enable Security Audit Log\")]";
    public static final String SECURITY_AUDIT_LOG_PAGE = "//idm-control-center-configuration-security-audit-log";
    public static final String DOCUMENT_TYPES_UNDER_AUDIT_LOGGING = "//div[@class='swaplist-card']//*[contains(text(),'audit logging')]//..//a[contains(text(),\"%s\")]";
    public static final String NOT_LOGGED_DOCUMENT_TYPES = "//div[@class='swaplist-card']//*[contains(text(),'Not logged Document Types')]//..//a[contains(text(),\"%s\")]";
    public static final String CONTROL_CENTER_HOME = "//idm-control-center-menu//a[contains(text(),\"Home\")]";
}