/*
 * @(#) OneAccountLightPage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 *  Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 *
 */

package salesforce.ui.pages.account.light;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.account.abstracts.OneAccountAbstract;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * OneAccountLightPage.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public class OneAccountLightPage extends OneAccountAbstract {

    @FindBy(xpath = "//div[@class=\"windowViewMode-normal oneContent active lafPageHost\"]//div[@class=\"row region-header\"]")
    private WebElement accountPanelTitle;

    @FindBy(xpath = "//span[contains(@class, \"forceActionsText\")]")
    private WebElement messageConfirmation;

    @FindBy(xpath = "//div[contains(@class,\"OutputName\")]//span[contains(@class,\"OutputText\")]")
    private WebElement accountTitleLbl;

    @FindBy(xpath = "//a[@title=\"Details\" ]//span[@class=\"title\"]")
    private WebElement detailsTab;

    @FindBy(xpath = "//div[@data-component-id=\"flexipage_tabset\"]//section[contains(@class,\"active uiTab\")]")
    private WebElement detailsForm;

    @FindBy(xpath = "//div[starts-with(@class,'branding-actions ')]//child::li[6]//a")
    private WebElement deleteElementCmbBtn;

    @FindBy(xpath = "//button[@title=\"Delete\"]")
    private WebElement deleteBtn;

    @FindBy(xpath = "//ul[contains(@class,'slds-button-group slds-m-left--xx-small o')]"
            + "//div[@data-aura-class='uiPopupTrigger']//a")
    private WebElement mainMenuCmb;

    @FindBy(css = "[data-aura-rendered-by^=\"99\"] [class=\"uiOutputText\"]")
    private WebElement nameAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"132\"] [data-aura-class=\"forceOutputLookup\"]")
    private WebElement parentAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"205\"] [class=\"uiOutputText\"]")
    private WebElement numberAccountlbl;

    @FindBy(css = "[data-aura-rendered-by^=\"248\"] [class=\"uiOutputText\"]")
    private WebElement siteAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"287\"] [data-aura-rendered-by^=\"278\"] ")
    private WebElement typeAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"327\"] [data-aura-rendered-by^=\"318\"] ")
    private WebElement industryAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"366\"] [data-aura-class^=\"forceOutputCurrency\"] ")
    private WebElement revenueAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"78\"] [data-aura-rendered-by^=\"69:\"] ")
    private WebElement ratingAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"118\"] [class=\"uiOutputPhone\"]")
    private WebElement phoneAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"184\"] [class=\"uiOutputPhone\"]")
    private WebElement faxAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"214\"] [class=\"uiOutputURL\"]")
    private WebElement websiteAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"265\"] [class=\"uiOutputText\"]")
    private WebElement tickerAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"305\"] [data-aura-rendered-by^=\"296\"]")
    private WebElement ownershipAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"344\"] [class=\"uiOutputNumber\"]")
    private WebElement employeeAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"383\"] [class=\"uiOutputText\"]")
    private WebElement sicCodeAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"427\"] [class=\"forceOutputAddress\"]")
    private WebElement billingStreetAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"466\"] [class=\"forceOutputAddress\"]")
    private WebElement shippingStreetAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"495\"] [data-aura-rendered-by^=\"486\"]")
    private WebElement customerAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"534\"] [class=\"uiOutputDate\"]")
    private WebElement slaDateAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"572\"] [class=\"uiOutputNumber\"]")
    private WebElement locationsAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"612\"] [data-aura-rendered-by^=\"603\"]")
    private WebElement activeAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"513\"] [data-aura-rendered-by^=\"504\"]")
    private WebElement slaAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"551\"] [data-aura-class=\"uiOutputText\"]")
    private WebElement slaSerialAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"590\"] [data-aura-rendered-by^=\"581\"]")
    private WebElement upsellAccountLbl;

    @FindBy(css = "[data-aura-rendered-by^=\"777\"] [class=\"uiOutputTextArea\"]")
    private WebElement descriptionAccountLbl;

    /**
     * Wait for account Panel Title.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountPanelTitle));
    }

    /**
     * Verify the components of the account.
     * @return
     */
    @Override
    public boolean verifyComponentsAccount() {
        return detailsForm.isDisplayed();
    }

    /**
     * Implement isDisplayedDetailsPage.
     * @return true component
     */
    @Override
    public boolean isDisplayedDetailsPage() {
        clickDetailsTab();
        return detailsForm.isDisplayed();
    }

    /**
     * Get the name of the account title.
     * @return name string.
     */
    @Override
    public String getNameAccount() {
        return accountTitleLbl.getText();
    }

    /**
     * Get the message confirmation.
     * @return message string.
     */
    public String getMessageConfirmation() {
        wait.until(ExpectedConditions.visibilityOf(messageConfirmation));
        return messageConfirmation.getText();
    }

    /**
     * Click to detailsTab.
     */
    private void clickDetailsTab() {
        detailsTab.click();
    }

    /**
     * Delete account.
     */
    @Override
    public void deleteAccount() {
        mainMenuCmb.click();
        deleteElementCmbBtn.click();
        deleteBtn.click();
    }

    /**
     * Get account description.
     * @param accountInformation Map
     * @return mapAccount Map
     */
    @Override
    public Map<String, String> createHasMapAccount(final Map<String, String> accountInformation) {
        Map<String, String> mapAccount = new HashMap<String, String>();
        Iterator it = accountInformation.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            String getValue = getValueAccount(key);
            mapAccount.put(key, getValue);
        }
        return mapAccount;
    }

    /**
     * Gets the value of an attribute.
     * @return attribute String
     * @param key String
     */
    private String getValueAccount(String key) {
        String setKey = key;
        String valueAttribute = "";
        switch (setKey) {
            case "Name":
                valueAttribute = nameAccountLbl.getText();
                break;
            case "Parent":
                valueAttribute = parentAccountLbl.getText();
                break;
            case "Number":
                valueAttribute = numberAccountlbl.getText();
                break;
            case "Site":
                valueAttribute = siteAccountLbl.getText();
                break;
            case "Type":
                valueAttribute = typeAccountLbl.getText();
                break;
            case "Industry":
                valueAttribute = industryAccountLbl.getText();
                break;
            case "Revenue":
                String value = revenueAccountLbl.getText();
                valueAttribute = value.replace("¤", "");
                break;
            case "Rating":
                valueAttribute = ratingAccountLbl.getText();
                break;
            case "Phone":
                valueAttribute = phoneAccountLbl.getText();
                break;
            case "Fax":
                valueAttribute = faxAccountLbl.getText();
                break;
            case "Website":
                valueAttribute = websiteAccountLbl.getText();
                break;
            case "Ticker":
                valueAttribute = tickerAccountLbl.getText();
                break;
            case "Ownership":
                valueAttribute = ownershipAccountLbl.getText();
                break;
            case "Employee":
                valueAttribute = employeeAccountLbl.getText();
                break;
            case "Sic Code":
                valueAttribute = sicCodeAccountLbl.getText();
                break;
            case "Billing Street":
                valueAttribute = billingStreetAccountLbl.getText();
                break;
            case "Billing City":
                valueAttribute = billingStreetAccountLbl.getText();
                break;
            case "Billing State":
                valueAttribute = billingStreetAccountLbl.getText();
                break;
            case "Billing Zip":
                valueAttribute = billingStreetAccountLbl.getText();
                break;
            case "Billing Country":
                valueAttribute = billingStreetAccountLbl.getText();
                break;
            case "Shipping Street":
                valueAttribute = shippingStreetAccountLbl.getText();
                break;
            case "Shipping City":
                valueAttribute = shippingStreetAccountLbl.getText();
                break;
            case "Shipping State":
                valueAttribute = shippingStreetAccountLbl.getText();
                break;
            case "Shipping Zip":
                valueAttribute = shippingStreetAccountLbl.getText();
                break;
            case "Shipping Country":
                valueAttribute = shippingStreetAccountLbl.getText();
                break;
            case "Customer":
                valueAttribute = customerAccountLbl.getText();
                break;
            case "Sla Date":
                valueAttribute = slaDateAccountLbl.getText();
                break;
            case "Locations":
                valueAttribute = locationsAccountLbl.getText();
                break;
            case "Active":
                valueAttribute = activeAccountLbl.getText();
                break;
            case "Sla":
                valueAttribute = slaAccountLbl.getText();
                break;
            case "Sla Serial":
                valueAttribute = slaSerialAccountLbl.getText();
                break;
            case "Upsell":
                valueAttribute = upsellAccountLbl.getText();
                break;
            case "Description":
                valueAttribute = descriptionAccountLbl.getText();
                break;
            default:
                return null;
        }
        return valueAttribute;
    }
}
