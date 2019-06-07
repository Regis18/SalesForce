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

    private String customerAccount = "//div[div[span[contains(text(),'Customer Priority')]]]//*//span[class=\"test-id__field-label\"]";

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

    @FindBy(xpath = "//div[starts-with(@class,'branding-actions ')]//child::li[5]//a")
    private WebElement editBtn;

    @FindBy(xpath = "//button[@title=\"Delete\"]")
    private WebElement deleteBtn;

    @FindBy(xpath = "//ul[contains(@class,'slds-button-group slds-m-left--xx-small o')]"
            + "//div[@data-aura-class='uiPopupTrigger']//a")
    private WebElement mainMenuCmb;

    @FindBy(xpath = "//div[span[text()='Account Name']]/following-sibling::div//span[@class='uiOutputText']")
    private WebElement nameAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Rating']]/following-sibling::div//span[@class=\"test-id__field-value slds-form-element__static slds-grow \"]")
    private WebElement ratingAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Account Number']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement numberAccountlbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Account Site']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement siteAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Type']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement typeAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Industry']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement industryAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Annual Revenue']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement revenueAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Parent Account']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement parentAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Phone']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement phoneAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Fax']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement faxAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Website']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement websiteAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Ticker Symbol']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement tickerAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Ownership']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement ownershipAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Employees']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement employeeAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='SIC Code']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement sicCodeAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Billing Address']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement billingStreetAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Shipping Address']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement shippingStreetAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='Customer Priority']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement customerAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//div[span[text()='SLA Expiration Date']]/following-sibling::div//span[@class='test-id__field-value slds-form-element__static slds-grow ']")
    private WebElement slaDateAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//label[span[text()='Number of Locations']]/following-sibling::input[@class=' input']")
    private WebElement locationsAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//span[span[text()='Active']]/following-sibling::div//a[@class='select']")
    private WebElement activeAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//span[span[text()='SLA']]/following-sibling::div//a[@class='select']")
    private WebElement slaAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//label[span[text()='SLA Serial Number']]/following-sibling::input[@class=' input']")
    private WebElement slaSerialAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//span[span[text()='Upsell Opportunity']]/following-sibling::div//a[@class='select']")
    private WebElement upsellAccountLbl;

    @FindBy(xpath = "//div[@class='column region-main']//label[span[text()='Description']]/following-sibling::textarea[@class=' textarea']")
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
     * Click in to New Account button and initialize NewAccountClassicPage.
     * @return NewAccountClassicPage.
     */
    @Override
    public NewAccountPopup editAccount() {
        mainMenuCmb.click();
        editBtn.click();
        return new NewAccountPopup();
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
        System.out.println("light: ");
        while (it.hasNext()) {
            String getValue;
            String key = (String) it.next();
            if (key.equals("Revenue")) {
                String value = getAccountFieldsValues(key);
                getValue = value.replace("¤", "");
                mapAccount.put(key, getValue);
                System.out.println(" key: "+key+" value: "+getValue);
            } else if (key.equals("Billing Street") || key.equals("Billing City") || key.equals("Billing State") || key.equals("Billing Zip") || key.equals("Billing Country")) {
                if (isBillingAdrress) {
                    key = "Billing Street";
                    String value = getAccountFieldsValues(key);
                    getValue = value.replaceAll("\n", " ");
                    getValue = getValue.replaceAll(",", " ");
                    isBillingAdrress = false;
                    mapAccount.put(key, getValue);
                    System.out.println(" key: "+key+" value: "+getValue);
                }
            } else if (key.equals("Shipping Street") || key.equals("Shipping City") || key.equals("Shipping State") || key.equals("Shipping Zip") || key.equals("Shipping Country")) {
                if (isShippingAdrress) {
                    key = "Shipping Street";
                    String value = getAccountFieldsValues(key);
                    getValue = value.replace(",", "");
                    getValue = getValue.replaceAll("\n", " ");
                    isShippingAdrress = false;
                    mapAccount.put(key, getValue);
                    System.out.println(" key: "+key+" value: "+getValue);
                }
            } else {
                getValue = getAccountFieldsValues(key);
                mapAccount.put(key, getValue);
                System.out.println(" key: "+key+" value: "+getValue);
            }
        }
        return mapAccount;
    }

    /**
     * Get the values of an account.
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