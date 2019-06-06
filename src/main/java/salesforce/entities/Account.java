/*
 * @(#) account.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.entities;

import core.utils.StrategySetter;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * account.
 * @author Luis Guardia.
 */
public class Account {

    private String id;
    private String name;
    private String parent;
    private String numberAccount;
    private String site;
    private String type;
    private String industry;
    private String anualRevenue;
    private String rating;
    private String phone;
    private String fax;
    private String webSite;
    private String ticker;
    private String ownership;
    private String employee;
    private String sicCode;
    private String billingStreet;
    private String billingCity;
    private String billingState;
    private String billingZip;
    private String billingCountry;
    private String shippingStreet;
    private String shippingCity;
    private String shippingState;
    private String shippingZip;
    private String shippingCountry;
    private String customerPriority;
    private String slaDate;
    private String numberLocations;
    private String active;
    private String slaAccount;
    private String slaSerial;
    private String upsellOportunity;
    private String description;
    private String value;

    /**
     * Get account id.
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * Get account id.
     * @param id String
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Get account name.
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * Set account type.
     * @param name String
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Get account phone.
     * @return phone String
     */
    public String getRating() {
        return rating;
    }

    /**
     * Set account rating.
     * @param rating String
     */
    public void setRating(final String rating) {
        this.rating = rating;
    }

    /**
     * Get account phone.
     * @return phone String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set account phone.
     * @param phone String
     */
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    /**
     * Get account parent.
     * @return parent String
     */
    public String getParent() {
        return parent;
    }

    /**
     * Set account parent.
     * @param parent String
     */
    public void setParent(final String parent) {
        this.parent = parent;
    }

    /**
     * Get account fax.
     * @return fax String
     */
    public String getFax() {
        return fax;
    }

    /**
     * Set account fax.
     * @param fax String
     */
    public void setFax(final String fax) {
        this.fax = fax;
    }

    /**
     * Get account number.
     * @return numberAccount String
     */
    public String getNumberAccount() {
        return numberAccount;
    }

    /**
     * Set account numberAccount.
     * @param numberAccount String
     */
    public void setNumberAccount(final String numberAccount) {
        this.numberAccount = numberAccount;
    }

    /**
     * Get account webSite.
     * @return webSite String
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * Set account webSite.
     * @param webSite String
     */
    public void setWebSite(final String webSite) {
        this.webSite = webSite;
    }

    /**
     * Get account site.
     * @return site String
     */
    public String getSite() {
        return site;
    }

    /**
     * Set account site.
     * @param site String
     */
    public void setSite(final String site) {
        this.site = site;
    }

    /**
     * Get account ticker.
     * @return ticker String
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * Set account ticker.
     * @param ticker String
     */
    public void setTicker(final String ticker) {
        this.ticker = ticker;
    }

    /**
     * Get account type.
     * @return type String
     */
    public String getType() {
        return type;
    }

    /**
     * Set account type.
     * @param type String
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Get account ownership.
     * @return ownership String
     */
    public String getOwnership() {
        return ownership;
    }

    /**
     * Set account ownership.
     * @param ownership String
     */
    public void setOwnership(final String ownership) {
        this.ownership = ownership;
    }

    /**
     * Get account industry.
     * @return industry String
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * Set account industry.
     * @param industry String
     */
    public void setIndustry(final String industry) {
        this.industry = industry;
    }

    /**
     * Get account employee.
     * @return employee String
     */
    public String getEmployee() {
        return employee;
    }

    /**
     * Set account employee.
     * @param employee String
     */
    public void setEmployee(final String employee) {
        this.employee = employee;
    }

    /**
     * Get account anual revenue.
     * @return anual revenue String
     */
    public String getAnualRevenue() {
        return anualRevenue;
    }

    /**
     * Set account anualRevenue.
     * @param anualRevenue String
     */
    public void setAnualRevenue(final String anualRevenue) {
        this.anualRevenue = anualRevenue;
    }

    /**
     * Get account sic code.
     * @return sic code String
     */
    public String getSicCode() {
        return sicCode;
    }

    /**
     * Set account sicCode.
     * @param sicCode String
     */
    public void setSicCode(final String sicCode) {
        this.sicCode = sicCode;
    }

    /**
     * Get account billing street.
     * @return billing street String
     */
    public String getBillingStreet() {
        return billingStreet;
    }

    /**
     * Set account billingStreet.
     * @param billingStreet String
     */
    public void setBillingStreet(final String billingStreet) {
        this.billingStreet = billingStreet;
    }

    /**
     * Get account shipping street.
     * @return shipping street String
     */
    public String getShippingStreet() {
        return shippingStreet;
    }

    /**
     * Set account shippingStreet.
     * @param shippingStreet String
     */
    public void setShippingStreet(final String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    /**
     * Get account billing City.
     * @return billing City String
     */
    public String getBillingCity() {
        return billingCity;
    }

    /**
     * Set account billingCity.
     * @param billingCity String
     */
    public void setBillingCity(final String billingCity) {
        this.billingCity = billingCity;
    }

    /**
     * Get account billing state.
     * @return billing state String
     */
    public String getBillingState() {
        return billingState;
    }

    /**
     * Set account billingState.
     * @param billingState String
     */
    public void setBillingState(final String billingState) {
        this.billingState = billingState;
    }

    /**
     * Get account shipping city.
     * @return shipping city String
     */
    public String getShippingCity() {
        return shippingCity;
    }

    /**
     * Set account shippingCity.
     * @param shippingCity String
     */
    public void setShippingCity(final String shippingCity) {
        this.shippingCity = shippingCity;
    }

    /**
     * Get account shipping state.
     * @return shipping state String
     */
    public String getShippingState() {
        return shippingState;
    }

    /**
     * Set account shippingState.
     * @param shippingState String
     */
    public void setShippingState(final String shippingState) {
        this.shippingState = shippingState;
    }

    /**
     * Get account billing zip.
     * @return billing zip String
     */
    public String getBillingZip() {
        return billingZip;
    }

    /**
     * Set account billingZip.
     * @param billingZip String
     */
    public void setBillingZip(final String billingZip) {
        this.billingZip = billingZip;
    }

    /**
     * Get account billing country.
     * @return billing country String
     */
    public String getBillingCountry() {
        return billingCountry;
    }

    /**
     * Set account billingCountry.
     * @param billingCountry String
     */
    public void setBillingCountry(final String billingCountry) {
        this.billingCountry = billingCountry;
    }

    /**
     * Get account shipping zip.
     * @return shipping zip String
     */
    public String getShippingZip() {
        return shippingZip;
    }

    /**
     * Set account shippingZip.
     * @param shippingZip String
     */
    public void setShippingZip(final String shippingZip) {
        this.shippingZip = shippingZip;
    }

    /**
     * Get account shipping country.
     * @return shipping country String
     */
    public String getShippingCountry() {
        return shippingCountry;
    }

    /**
     * Set account shippingCountry.
     * @param shippingCountry String
     */
    public void setShippingCountry(final String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    /**
     * Get account customer priority.
     * @return customer priority String
     */
    public String getCustomerPriority() {
        return customerPriority;
    }

    /**
     * Set account customerPriority.
     * @param customerPriority String
     */
    public void setCustomerPriority(final String customerPriority) {
        this.customerPriority = customerPriority;
    }

    /**
     * Get account SLA.
     * @return SLA String
     */
    public String getSlaAccount() {
        return slaAccount;
    }

    /**
     * Set account slaAccount.
     * @param slaAccount String
     */
    public void setSlaAccount(final String slaAccount) {
        this.slaAccount = slaAccount;
    }

    /**
     * Get account SLA date.
     * @return SLA date String
     */
    public String getSlaDate() {
        return slaDate;
    }

    /**
     * Set account slaDate.
     * @param slaDate String
     */
    public void setSlaDate(final String slaDate) {
        this.slaDate = slaDate;
    }

    /**
     * Get account SLA serial.
     * @return SLA serial String
     */
    public String getSlaSerial() {
        return slaSerial;
    }

    /**
     * Set account slaSerial.
     * @param slaSerial String
     */
    public void setSlaSerial(final String slaSerial) {
        this.slaSerial = slaSerial;
    }

    /**
     * Get account number of locations.
     * @return number of locations String
     */
    public String getNumberLocations() {
        return numberLocations;
    }

    /**
     * Set account numberLocations.
     * @param numberLocations String
     */
    public void setNumberLocations(final String numberLocations) {
        this.numberLocations = numberLocations;
    }

    /**
     * Get account upsell oportunity.
     * @return upsell oportunity String
     */
    public String getUpsellOportunity() {
        return upsellOportunity;
    }

    /**
     * Set account upsellOportunity.
     * @param upsellOportunity String
     */
    public void setUpsellOportunity(final String upsellOportunity) {
        this.upsellOportunity = upsellOportunity;
    }

    /**
     * Get account active.
     * @return active String
     */
    public String getActive() {
        return active;
    }

    /**
     * Set account active.
     * @param active String
     */
    public void setActive(final String active) {
        this.active = active;
    }

    /**
     * Get account description.
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set account type.
     * @param description String
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Set the values of an account.
     * @param accountInformation Map
     */
    public void  setAccountInformation(final Map<String, String> accountInformation) {
        HashMap<String, StrategySetter> strategyMap = composeStrategyMap(accountInformation);
        accountInformation.keySet().forEach(key -> {
            strategyMap.get(key).executeMethod();
        });
    }

    /**
     * Compose the values of Account.
     * @param accountInformation Map
     * @return Hashmap
     */
    private HashMap<String, StrategySetter> composeStrategyMap(final Map<String, String> accountInformation) {
        HashMap<String, StrategySetter> strategyMap  = new HashMap<>();
        strategyMap.put("Name",        () -> setName(accountInformation.get("Name")));
        strategyMap.put("Parent",        () -> setParent(accountInformation.get("Parent")));
        strategyMap.put("Number",      () -> setNumberAccount(accountInformation.get("Number")));
        strategyMap.put("Site",        () -> setSite(accountInformation.get("Site")));
        strategyMap.put("Type",        () -> setType(accountInformation.get("Type")));
        strategyMap.put("Industry",        () -> setIndustry(accountInformation.get("Industry")));
        strategyMap.put("Revenue",     () -> setAnualRevenue(accountInformation.get("Revenue")));
        strategyMap.put("Rating",     () -> setRating(accountInformation.get("Rating")));
        strategyMap.put("Phone",       () -> setPhone(accountInformation.get("Phone")));
        strategyMap.put("Fax",         () -> setFax(accountInformation.get("Fax")));
        strategyMap.put("Website",     () -> setWebSite(accountInformation.get("Website")));
        strategyMap.put("Ticker",      () -> setTicker(accountInformation.get("Ticker")));
        strategyMap.put("Ownership",      () -> setOwnership(accountInformation.get("Ownership")));
        strategyMap.put("Employee",    () -> setEmployee(accountInformation.get("Employee")));
        strategyMap.put("Sic Code",    () -> setSicCode(accountInformation.get("Sic Code")));
        strategyMap.put("Billing Street", () -> setBillingStreet(accountInformation.get("Billing Street")));
        strategyMap.put("Billing City", () -> setBillingCity(accountInformation.get("Billing City")));
        strategyMap.put("Billing State", () -> setBillingState(accountInformation.get("Billing State")));
        strategyMap.put("Billing Zip", () -> setBillingZip(accountInformation.get("Billing Zip")));
        strategyMap.put("Billing Country", () -> setBillingCountry(accountInformation.get("Billing Country")));
        strategyMap.put("Shipping Street", () -> setShippingStreet(accountInformation.get("Shipping Street")));
        strategyMap.put("Shipping City", () -> setShippingCity(accountInformation.get("Shipping City")));
        strategyMap.put("Shipping State", () -> setShippingState(accountInformation.get("Shipping State")));
        strategyMap.put("Shipping Zip", () -> setShippingZip(accountInformation.get("Shipping Zip")));
        strategyMap.put("Shipping Country", () -> setShippingCountry(accountInformation.get("Shipping Country")));
        strategyMap.put("Customer", () -> setCustomerPriority(accountInformation.get("Customer")));
        strategyMap.put("Sla Date",    () -> setSlaDate(accountInformation.get("Sla Date")));
        strategyMap.put("Locations", () -> setNumberLocations(accountInformation.get("Locations")));
        strategyMap.put("Active", () -> setActive(accountInformation.get("Active")));
        strategyMap.put("Sla",   () -> setSlaAccount(accountInformation.get("Sla")));
        strategyMap.put("Sla Serial",   () -> setSlaSerial(accountInformation.get("Sla Serial")));
        strategyMap.put("Upsell",  () -> setUpsellOportunity(accountInformation.get("Upsell")));
        strategyMap.put("Description",  () -> setDescription(accountInformation.get("Description")));

        return strategyMap;
    }

    /**
     * Get account description.
     * @param accountInformation Map
     * @return mapAccount Map
     */
    public Map<String, String> createMapAccount(Map<String, String> accountInformation) {
        Map<String, String> mapAccount = new HashMap<String, String>();
        Iterator it = accountInformation.keySet().iterator();
        boolean isBillingStreet = true;
        boolean isShippingStreet = true;
        while (it.hasNext()) {
            String key = (String) it.next();
            String getValue;
            if (key.equals("Billing Street") || key.equals("Billing City") || key.equals("Billing State") || key.equals("Billing Zip") || key.equals("Billing Country")) {
                if (isBillingStreet) {
                    key = "Billing Street";
                    getValue = getValueAccount(key);
                    mapAccount.put(key, getValue);
                    isBillingStreet = false;
                    System.out.println("shipppppppppppppppp: "+getValue);
                }
            } else if (key.equals("Shipping Street") || key.equals("Shipping City") || key.equals("Shipping State") || key.equals("Shipping Zip") || key.equals("Shipping Country")) {
                if (isShippingStreet) {
                    key = "Shipping Street";
                    getValue = getValueAccount(key);
                    mapAccount.put(key, getValue);
                    isShippingStreet = false;
                    System.out.println("billllllllllllllllllll: "+getValue);
                }
            } else {
                getValue = getValueAccount(key);
                mapAccount.put(key, getValue);
                System.out.println("otrossssss: "+getValue);
            }
        }
        return mapAccount;
    }

    /**
     * Get the values of an account.
     * @param key Map
     * @return getValueAccount Map
     */
    public String getValueAccount(String key) {
        HashMap<String, String> getAccountFiledValues = new HashMap<>();
        getAccountFiledValues.put("Name", getName());
        getAccountFiledValues.put("Parent", getParent());
        getAccountFiledValues.put("Number", getNumberAccount());
        getAccountFiledValues.put("Site", getSite());
        getAccountFiledValues.put("Type", getType());
        getAccountFiledValues.put("Industry", getIndustry());
        getAccountFiledValues.put("Revenue", getAnualRevenue());
        getAccountFiledValues.put("Rating", getRating());
        getAccountFiledValues.put("Phone", getPhone());
        getAccountFiledValues.put("Fax", getFax());
        getAccountFiledValues.put("Website", getWebSite());
        getAccountFiledValues.put("Ticker", getTicker());
        getAccountFiledValues.put("Ownership", getOwnership());
        getAccountFiledValues.put("Employee", getEmployee());
        getAccountFiledValues.put("Sic Code", getSicCode());
        getAccountFiledValues.put("Billing Street", getBillingAddress());
        getAccountFiledValues.put("Shipping Street", getShippingAdrress());
        getAccountFiledValues.put("Customer", getCustomerPriority());
        getAccountFiledValues.put("Sla Date", getSlaDate());
        getAccountFiledValues.put("Locations", getNumberLocations());
        getAccountFiledValues.put("Active", getActive());
        getAccountFiledValues.put("Sla", getSlaAccount());
        getAccountFiledValues.put("Sla Serial", getSlaSerial());
        getAccountFiledValues.put("Upsell", getUpsellOportunity());
        getAccountFiledValues.put("Description", getDescription());

        return getAccountFiledValues.get(key);
    }

    /**
     * Get the values of Billing Address.
     * @return billingAdrress String
     */
    private String getBillingAddress() {
        String billingAdrress = "";
        if (getBillingStreet() != null) {
            billingAdrress += getBillingStreet() + " ";
        }
        if (getBillingCity() != null) {
            billingAdrress += getBillingCity() + " ";
        }
        if (getBillingState() != null) {
            billingAdrress += getBillingState() + " ";
        }
        if (getBillingZip() != null) {
            billingAdrress += getBillingZip() + " ";
        }
        if (getBillingCountry() != null) {
            billingAdrress += getBillingCountry();
        }
        return billingAdrress;
    }

    private String getShippingAdrress() {
        String shippingAdrress = "";
        if (getShippingStreet() != null) {
            shippingAdrress += getShippingStreet() + " ";
        }
        if (getShippingCity() != null) {
            shippingAdrress += getShippingCity() + " ";
        }
        if (getShippingState() != null) {
            shippingAdrress += getShippingState() + " ";
        }
        if (getShippingZip() != null) {
            shippingAdrress += getShippingZip() + " ";
        }
        if (getShippingCountry() != null) {
            shippingAdrress += getShippingCountry();
        }
        return shippingAdrress;
    }
}
