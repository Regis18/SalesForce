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

import java.util.HashMap;
import java.util.Map;

/**
 * account.
 * @author Luis Guardia.
 */
public class Account {
    private String name;
    private String rating;
    private String phone;
    private String parent;
    private String fax;
    private String numberAccount;
    private String webSite;
    private String site;
    private String ticker;
    private String type;
    private String ownership;
    private String industry;
    private String employee;
    private String anualRevenue;
    private String sicCode;
    private String billingStreet;
    private String shippingStreet;
    private String billingCity;
    private String billingState;
    private String shippingCity;
    private String shippingState;
    private String billingZip;
    private String billingCountry;
    private String shippingZip;
    private String shippingCountry;
    private String customerPriority;
    private String slaAccount;
    private String slaDate;
    private String slaSerial;
    private String numberLocations;
    private String upsellOportunity;
    private String active;
    private String description;

    /**
     * Get account name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set account type.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get account rating.
     * @return rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * Set account rating.
     * @param rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * Get account phone.
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set account phone.
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get account parent.
     * @return parent
     */
    public String getParent() {
        return parent;
    }

    /**
     * Set account parent.
     * @param parent
     */
    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     * Get account fax.
     * @return fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * Set account fax.
     * @param fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Get account number.
     * @return number
     */
    public String getNumberAccount() {
        return numberAccount;
    }

    /**
     * Set account numberAccount.
     * @param numberAccount
     */
    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    /**
     * Get account webSite.
     * @return webSite
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * Set account webSite.
     * @param webSite
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    /**
     * Get account site.
     * @return site
     */
    public String getSite() {
        return site;
    }

    /**
     * Set account site.
     * @param site
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * Get account ticker.
     * @return ticker
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * Set account ticker.
     * @param ticker
     */
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    /**
     * Get account type.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Set account type.
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get account ownership.
     * @return ownership
     */
    public String getOwnership() {
        return ownership;
    }

    /**
     * Set account ownership.
     * @param ownership
     */
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    /**
     * Get account industry.
     * @return industry
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * Set account industry.
     * @param industry
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * Get account employee.
     * @return employee
     */
    public String getEmployee() {
        return employee;
    }

    /**
     * Set account employee.
     * @param employee
     */
    public void setEmployee(String employee) {
        this.employee = employee;
    }

    /**
     * Get account anual revenue.
     * @return anual revenue
     */
    public String getAnualRevenue() {
        return anualRevenue;
    }

    /**
     * Set account anualRevenue.
     * @param anualRevenue
     */
    public void setAnualRevenue(String anualRevenue) {
        this.anualRevenue = anualRevenue;
    }

    /**
     * Get account sic code.
     * @return sic code
     */
    public String getSicCode() {
        return sicCode;
    }

    /**
     * Set account sicCode.
     * @param sicCode
     */
    public void setSicCode(String sicCode) {
        this.sicCode = sicCode;
    }

    /**
     * Get account billing street.
     * @return billing street
     */
    public String getBillingStreet() {
        return billingStreet;
    }

    /**
     * Set account billingStreet.
     * @param billingStreet
     */
    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }

    /**
     * Get account shipping street.
     * @return shipping street
     */
    public String getShippingStreet() {
        return shippingStreet;
    }

    /**
     * Set account shippingStreet.
     * @param shippingStreet
     */
    public void setShippingStreet(String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    /**
     * Get account billing City.
     * @return billing City
     */
    public String getBillingCity() {
        return billingCity;
    }

    /**
     * Set account billingCity.
     * @param billingCity
     */
    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    /**
     * Get account billing state.
     * @return billing state
     */
    public String getBillingState() {
        return billingState;
    }

    /**
     * Set account billingState.
     * @param billingState
     */
    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    /**
     * Get account shipping city.
     * @return shipping city
     */
    public String getShippingCity() {
        return shippingCity;
    }

    /**
     * Set account shippingCity.
     * @param shippingCity
     */
    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    /**
     * Get account shipping state.
     * @return shipping state
     */
    public String getShippingState() {
        return shippingState;
    }

    /**
     * Set account shippingState.
     * @param shippingState
     */
    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    /**
     * Get account billing zip.
     * @return billing zip
     */
    public String getBillingZip() {
        return billingZip;
    }

    /**
     * Set account billingZip.
     * @param billingZip
     */
    public void setBillingZip(String billingZip) {
        this.billingZip = billingZip;
    }

    /**
     * Get account billing country.
     * @return billing country
     */
    public String getBillingCountry() {
        return billingCountry;
    }

    /**
     * Set account billingCountry.
     * @param billingCountry
     */
    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    /**
     * Get account shipping zip.
     * @return shipping zip
     */
    public String getShippingZip() {
        return shippingZip;
    }

    /**
     * Set account shippingZip.
     * @param shippingZip
     */
    public void setShippingZip(String shippingZip) {
        this.shippingZip = shippingZip;
    }

    /**
     * Get account shipping country.
     * @return shipping country
     */
    public String getShippingCountry() {
        return shippingCountry;
    }

    /**
     * Set account shippingCountry.
     * @param shippingCountry
     */
    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    /**
     * Get account customer priority.
     * @return customer priority
     */
    public String getCustomerPriority() {
        return customerPriority;
    }

    /**
     * Set account customerPriority.
     * @param customerPriority
     */
    public void setCustomerPriority(String customerPriority) {
        this.customerPriority = customerPriority;
    }

    /**
     * Get account SLA.
     * @return SLA
     */
    public String getSlaAccount() {
        return slaAccount;
    }

    /**
     * Set account slaAccount.
     * @param slaAccount
     */
    public void setSlaAccount(String slaAccount) {
        this.slaAccount = slaAccount;
    }

    /**
     * Get account SLA date.
     * @return SLA date
     */
    public String getSlaDate() {
        return slaDate;
    }

    /**
     * Set account slaDate.
     * @param slaDate
     */
    public void setSlaDate(String slaDate) {
        this.slaDate = slaDate;
    }

    /**
     * Get account SLA serial.
     * @return SLA serial
     */
    public String getSlaSerial() {
        return slaSerial;
    }

    /**
     * Set account slaSerial.
     * @param slaSerial
     */
    public void setSlaSerial(String slaSerial) {
        this.slaSerial = slaSerial;
    }

    /**
     * Get account number of locations.
     * @return number of locations
     */
    public String getNumberLocations() {
        return numberLocations;
    }

    /**
     * Set account numberLocations.
     * @param numberLocations
     */
    public void setNumberLocations(String numberLocations) {
        this.numberLocations = numberLocations;
    }

    /**
     * Get account upsell oportunity.
     * @return upsell oportunity
     */
    public String getUpsellOportunity() {
        return upsellOportunity;
    }

    /**
     * Set account upsellOportunity.
     * @param upsellOportunity
     */
    public void setUpsellOportunity(String upsellOportunity) {
        this.upsellOportunity = upsellOportunity;
    }

    /**
     * Get account active.
     * @return active
     */
    public String getActive() {
        return active;
    }

    /**
     * Set account active.
     * @param active
     */
    public void setActive(String active) {
        this.active = active;
    }

    /**
     * Get account description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set account type.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the values of an account.
     * @param accountInformation *
     */
    public void  setAccountInformation(final Map<String, String> accountInformation){
        HashMap<String, StrategySetter> strategyMap = composeStrategyMap(accountInformation);
        accountInformation.keySet().forEach(key -> {strategyMap.get(key).executeMethod();});

    }

    private HashMap<String, StrategySetter> composeStrategyMap(final Map<String, String> accountInformation){
        HashMap<String, StrategySetter> strategyMap  = new HashMap<>();
        strategyMap.put("name",        () -> setName(accountInformation.get("name")));
        strategyMap.put("phone",       () -> setPhone(accountInformation.get("phone")));
        strategyMap.put("fax",         () -> setName(accountInformation.get("fax")));
        strategyMap.put("number",      () -> setName(accountInformation.get("number")));
        strategyMap.put("website",     () -> setName(accountInformation.get("website")));
        strategyMap.put("site",        () -> setName(accountInformation.get("site")));
        strategyMap.put("ticker",      () -> setName(accountInformation.get("ticker")));
        strategyMap.put("employee",    () -> setName(accountInformation.get("employee")));
        strategyMap.put("revenue",     () -> setName(accountInformation.get("revenue")));
        strategyMap.put("sic code",    () -> setName(accountInformation.get("sic code")));
        strategyMap.put("bill street", () -> setName(accountInformation.get("bill street")));
        strategyMap.put("shipp street",() -> setName(accountInformation.get("shipp street")));
        strategyMap.put("bill city",   () -> setName(accountInformation.get("bill city")));
        strategyMap.put("bill state",  () -> setName(accountInformation.get("bill state")));

        return strategyMap;
    }
}
