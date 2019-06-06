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
     *
     * @return
     */
    @Override
    public boolean verifyComponentsAccount() {
        return detailsForm.isDisplayed();
    }

    /**
     * Implement isDisplayedDetailsPage.
     *
     * @return true component
     */
    @Override
    public boolean isDisplayedDetailsPage() {
        clickDetailsTab();
        return detailsForm.isDisplayed();
    }

    /**
     * Get the name of the account title.
     *
     * @return name string.
     */
    @Override
    public String getNameAccount() {
        return accountTitleLbl.getText();
    }

    /**
     * Get the message confirmation.
     *
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
     * Get the values of an account.
     *
     * @param accountInformation Map
     * @return mapAccount Map
     */
    @Override
    public Map<String, String> createHasMapAccount(final Map<String, String> accountInformation) {
        Map<String, String> mapAccount = new HashMap<String, String>();
        Iterator it = accountInformation.keySet().iterator();
        boolean isBillingAdrress = true;
        boolean isShippingAdrress = true;
        while (it.hasNext()) {
            String getValue;
            String key = (String) it.next();
            if (key.equals("Revenue")) {
                String value = getAccountFieldsValues(key);
                getValue = value.replace("¤", "");
                mapAccount.put(key, getValue);
                System.out.println(key + "  " + getValue);
            } else if (key.equals("Billing Street") || key.equals("Billing City") || key.equals("Billing State") || key.equals("Billing Zip") || key.equals("Billing Country")) {
                if (isBillingAdrress) {
                    key = "Billing Street";
                    String value = getAccountFieldsValues(key);
                    getValue = value.replaceAll("\n", " ");
                    getValue = getValue.replaceAll(",", " ");
                    isBillingAdrress = false;
                    mapAccount.put(key, getValue);
                    System.out.println(key + "  " + getValue);
                }
            } else if (key.equals("Shipping Street") || key.equals("Shipping City") || key.equals("Shipping State") || key.equals("Shipping Zip") || key.equals("Shipping Country")) {
                if (isShippingAdrress) {
                    key = "Shipping Street";
                    String value = getAccountFieldsValues(key);
                    getValue = value.replace(",", "");
                    getValue = getValue.replaceAll("\n", " ");
                    isShippingAdrress = false;
                    mapAccount.put(key, getValue);
                    System.out.println(key + "  " + getValue);
                }
            } else {
                getValue = getAccountFieldsValues(key);
                mapAccount.put(key, getValue);
                System.out.println(key + "  " + getValue);
            }

        }
        return mapAccount;
    }


    /**
     * Get the values of an account.
     *
     * @param key Map
     * @return mapAccount Map
     */
    public String getAccountFieldsValues(String key) {
        HashMap<String, WebElement> fieldWebElementsMap = new HashMap<>();
        fieldWebElementsMap.put("Name", nameAccountLbl);
        fieldWebElementsMap.put("Parent", parentAccountLbl);
        fieldWebElementsMap.put("Number", numberAccountlbl);
        fieldWebElementsMap.put("Site", siteAccountLbl);
        fieldWebElementsMap.put("Type", typeAccountLbl);
        fieldWebElementsMap.put("Industry", industryAccountLbl);
        fieldWebElementsMap.put("Revenue", revenueAccountLbl);
        fieldWebElementsMap.put("Rating", ratingAccountLbl);
        fieldWebElementsMap.put("Phone", phoneAccountLbl);
        fieldWebElementsMap.put("Fax", faxAccountLbl);
        fieldWebElementsMap.put("Website", websiteAccountLbl);
        fieldWebElementsMap.put("Ticker", tickerAccountLbl);
        fieldWebElementsMap.put("Ownership", ownershipAccountLbl);
        fieldWebElementsMap.put("Employee", employeeAccountLbl);
        fieldWebElementsMap.put("Sic Code", sicCodeAccountLbl);
        fieldWebElementsMap.put("Billing Street", billingStreetAccountLbl);
        fieldWebElementsMap.put("Shipping Street", shippingStreetAccountLbl);
        fieldWebElementsMap.put("Customer", customerAccountLbl);
        fieldWebElementsMap.put("Sla Date", slaDateAccountLbl);
        fieldWebElementsMap.put("Locations", locationsAccountLbl);
        fieldWebElementsMap.put("Active", activeAccountLbl);
        fieldWebElementsMap.put("Sla", slaAccountLbl);
        fieldWebElementsMap.put("Sla Serial", slaSerialAccountLbl);
        fieldWebElementsMap.put("Upsell", upsellAccountLbl);
        fieldWebElementsMap.put("Description", descriptionAccountLbl);

        return fieldWebElementsMap.get(key).getText();
    }
}