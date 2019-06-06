/*
 * @(#) OneAccountClassicPage.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.account.classic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.account.abstracts.OneAccountAbstract;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * OneAccountClassicPage.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public class OneAccountClassicPage extends OneAccountAbstract {





    private String value;
    private String val = "null";
    @FindBy(xpath = "//td[@class=\" oRight\"]")
    private WebElement accountDetailForm;

    @FindBy(xpath = "//div[@class=\"bPageTitle\"]")
    private WebElement accountPanelTitle;

    @FindBy(xpath = "//h2[@class=\"topName\"]")
    private WebElement accountTitleLbl;

    @FindBy(xpath = "//td[@id=\"topButtonRow\"]//input[@name=\"delete\"]")
    private WebElement deleteBtn;

    @FindBy(xpath = "//h2[@class=\"topName\"]")
    private WebElement name;

    @FindBy(id = "acc3_ileinner")
    private WebElement parent;

    @FindBy(id = "acc5_ileinner")
    private WebElement number;

    @FindBy(id = "acc23_ileinner")
    private WebElement site;

    @FindBy(id = "acc6_ileinner")
    private WebElement type;

    @FindBy(id = "acc7_ileinner")
    private WebElement industry;

    @FindBy(id = "acc8_ileinner")
    private WebElement revenue;

    @FindBy(id = "acc17_ileinner")
    private WebElement billingAddres;

    @FindBy(id = "00N4P0000072sE6_ileinner")
    private WebElement priority;

    @FindBy(id = "00N4P0000072sE9_ileinner")
    private WebElement slaDate;

    @FindBy(id = "00N4P0000072sE7_ileinner")
    private WebElement numberLocations;

    @FindBy(id = "00N4P0000072sE5_ileinner")
    private WebElement active;

    @FindBy(id = "acc20_ileinner")
    private WebElement description;

    @FindBy(id = "acc9_ileinner")
    private WebElement rating;

    @FindBy(id = "acc10_ileinner")
    private WebElement phone;

    @FindBy(id = "acc11_ileinner")
    private WebElement fax;

    @FindBy(id = "acc12_ileinner")
    private WebElement webSite;

    @FindBy(id = "acc13_ileinner")
    private WebElement ticker;

    @FindBy(id = "acc14_ileinner")
    private WebElement ownership;

    @FindBy(id = "acc15_ileinner")
    private WebElement employee;

    @FindBy(id = "acc16_ileinner")
    private WebElement sicCode;

    @FindBy(id = "acc18_ileinner")
    private WebElement shippinAddres;

    @FindBy(id = "00N4P0000072sE8_ileinner")
    private WebElement sla;

    @FindBy(id = "00N4P0000072sEA_ileinner")
    private WebElement slaSerial;

    @FindBy(id = "00N4P0000072sEB_ileinner")
    private WebElement upsell;

    /**
     * Wait for Account panel title.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountPanelTitle));
    }

    /**
     * Verify if the components of the Account exist.
     * @return boolean
     */
    @Override
    public boolean verifyComponentsAccount() {
        return accountDetailForm.isDisplayed();
    }

    /**
     * Implement isDisplayedDetailsPage.
     * @return true component
     */
    @Override
    public boolean isDisplayedDetailsPage() {
        return accountDetailForm.isDisplayed();
    }

    /**
     * Get the Name Account.
     * @return string
     */
    @Override
    public String getNameAccount() {
        return accountTitleLbl.getText();
    }

    /**
     * Delete account.
     */
    @Override
    public void deleteAccount() {
        deleteBtn.click();
        driver.switchTo().alert().accept();
    }

    /**
     * Get the values of an account.
     * @param accountInformation Map
     * @return mapAccount Map
     */
    @Override
    public Map<String, String> createHasMapAccount(final Map<String, String> accountInformation) {
        Map<String, String> mapAccount = new HashMap<String, String>();
        Iterator it = accountInformation.keySet().iterator();
        boolean isBillingAdrress=true;
        boolean isShippingAdrress=true;
        while (it.hasNext()) {
            String getValue;
            String key = (String) it.next();
            if (key == "Revenue") {
                String value = getAccountFieldsValues(key);
                //getValue = value.replace("¤", "");
                getValue = value.replace( "¤", "");
                System.out.println(key + "valueeeeeeeeee: " + getValue);
                mapAccount.put(key, getValue);
            } else
                if (key == "Billing Street" || key == "Billing City" || key == "Billing State" || key == "Billing Zip" || key == "Billing Country") {
                System.out.println("boolean: " + isBillingAdrress);
                if (isBillingAdrress) {
                    key = "Billing Street";
                    String value = getAccountFieldsValues(key);
                    //getValue = value.replace( ",", "");
                    getValue = value.replaceAll("\n", " ");
                    System.out.println(key + "valueeeeeeeeee: " + getValue);
                    isBillingAdrress = false;
                    mapAccount.put(key, getValue);
                }
            }  else
                if (key == "Shipping Street" || key == "Shipping City" || key == "Shipping State" || key == "Shipping Zip" || key == "Shipping Country") {
                System.out.println("boolean: " + isShippingAdrress);
                if (isShippingAdrress) {
                    key = "Shipping Street";
                    String value = getAccountFieldsValues(key);
                    getValue = value.replace( ",", "");
                    getValue = getValue.replaceAll("\n", " ");
                    System.out.println(key + "valueeeeeeeeee: " + getValue);
                    isShippingAdrress = false;
                    mapAccount.put(key, getValue);
                }
            } else {
                getValue = getAccountFieldsValues(key);
                System.out.println(key + "valueeeeeeeeee: " + getValue);
                mapAccount.put(key, getValue);
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
        fieldWebElementsMap.put("Name", name);
        fieldWebElementsMap.put("Parent", parent);
        fieldWebElementsMap.put("Number", number);
        fieldWebElementsMap.put("Site", site);
        fieldWebElementsMap.put("Type", type);
        fieldWebElementsMap.put("Industry", industry);
        fieldWebElementsMap.put("Revenue", revenue);
        fieldWebElementsMap.put("Rating", rating);
        fieldWebElementsMap.put("Phone", phone);
        fieldWebElementsMap.put("Fax", fax);
        fieldWebElementsMap.put("Website", webSite);
        fieldWebElementsMap.put("Ticker", ticker);
        fieldWebElementsMap.put("Ownership", ownership);
        fieldWebElementsMap.put("Employee", employee);
        fieldWebElementsMap.put("Sic Code", sicCode);
        fieldWebElementsMap.put("Billing Street", billingAddres);
        fieldWebElementsMap.put("Shipping Street", shippinAddres);
        fieldWebElementsMap.put("Customer", priority);
        fieldWebElementsMap.put("Sla Date", slaDate);
        fieldWebElementsMap.put("Locations", numberLocations);
        fieldWebElementsMap.put("Active", active);
        fieldWebElementsMap.put("Sla", sla);
        fieldWebElementsMap.put("Sla Serial", slaSerial);
        fieldWebElementsMap.put("Upsell", upsell);
        fieldWebElementsMap.put("Description", description);

        return fieldWebElementsMap.get(key).getText();
    }

    /**
     * Gets the value of an attribute.
     * @return attribute String
     * @param key String
     */
    private String getValueAccount(String key) {
        String setKey = key;
        String valueAttribute = "";
        String value = "";
        switch (setKey) {
            case "Name":
                valueAttribute = name.getText();
                break;
            case "Parent":
                valueAttribute = parent.getText();
                break;
            case "Number":
                valueAttribute = number.getText();
                break;
            case "Site":
                valueAttribute = site.getText();
                break;
            case "Type":
                valueAttribute = type.getText();
                break;
            case "Industry":
                valueAttribute = industry.getText();
                break;
            case "Revenue":
                value = revenue.getText();
                valueAttribute = value.replace("¤", "");
                break;
            case "Rating":
                valueAttribute = rating.getText();
                break;
            case "Phone":
                valueAttribute = phone.getText();
                break;
            case "Fax":
                valueAttribute = fax.getText();
                break;
            case "Website":
                valueAttribute = webSite.getText();
                break;
            case "Ticker":
                valueAttribute = ticker.getText();
                break;
            case "Ownership":
                valueAttribute = ownership.getText();
                break;
            case "Employee":
                valueAttribute = employee.getText();
                break;
            case "Sic Code":
                valueAttribute = sicCode.getText();
                break;
            case "Billing Street":
                value = billingAddres.getText();
                String a = value.replaceAll("\n", " ");
                System.out.println(a);
                //valueAttribute = billingAddresAccount.getText();
                break;
            case "Billing City":
                valueAttribute = billingAddres.getText();
                break;
            case "Billing State":
                valueAttribute = billingAddres.getText();
                break;
            case "Billing Zip":
                valueAttribute = billingAddres.getText();
                break;
            case "Billing Country":
                valueAttribute = billingAddres.getText();
                break;
            case "Shipping Street":
                valueAttribute = shippinAddres.getText();
                break;
            case "Shipping City":
                valueAttribute = shippinAddres.getText();
                break;
            case "Shipping State":
                valueAttribute = shippinAddres.getText();
                break;
            case "Shipping Zip":
                valueAttribute = shippinAddres.getText();
                break;
            case "Shipping Country":
                valueAttribute = shippinAddres.getText();
                break;
            case "Customer":
                valueAttribute = priority.getText();
                break;
            case "Sla Date":
                valueAttribute = slaDate.getText();
                break;
            case "Locations":
                valueAttribute = numberLocations.getText();
                break;
            case "Active":
                valueAttribute = active.getText();
                break;
            case "Sla":
                valueAttribute = sla.getText();
                break;
            case "Sla Serial":
                valueAttribute = slaSerial.getText();
                break;
            case "Upsell":
                valueAttribute = upsell.getText();
                break;
            case "Description":
                valueAttribute = description.getText();
                break;
            default:
                return null;
        }
        return valueAttribute;
    }
}
