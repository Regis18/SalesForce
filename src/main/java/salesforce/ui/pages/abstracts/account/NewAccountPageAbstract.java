/*
 * @(#) NewAccountPageAbstract.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.abstracts.account;

import core.utils.StrategySetter;
import salesforce.entities.Account;
import salesforce.ui.BasePage;
import salesforce.ui.PageFactory;


import java.util.HashMap;
import java.util.Map;

/**
 * NewAccountPageAbstract.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public abstract class NewAccountPageAbstract extends BasePage {
    /**
     * Create a new account, it create for classic and lightning pages.
     *
     * @param account String.
     */
    public OneAccountAbstract createNewAccount(final Account account, final Map accountInformation) {
        setAccountData(account, accountInformation);
        clickSaveBtn();
        return PageFactory.oneAccountPage();
    }

    /**
     * Click in Save button.
     */
    protected abstract void clickSaveBtn();

    /**
     * Set name of account.
     *
     * @param name String
     */
    protected abstract void setNameTxt(String name);

    /**
     * Set name of account.
     * @param rating String.
     */
    public abstract void setRating(String rating);

    /**
     * Set name of account.
     * @param phone String.
     */
    public abstract void setPhone(String phone);

    /**
     * Set parent of account.
     * @param parent String.
     */
    public abstract void setParent(String parent);

    /**
     * Set fax of account.
     * @param fax String.
     */
    public abstract void setFax(String fax);
    /**
     * Set numberAccount of account.
     * @param numberAccount String.
     */
    public abstract void setNumberAccount(String numberAccount);

    /**
     * Set webSite of account.
     * @param webSite String.
     */
    public abstract void setWebSite(String webSite);

    /**
     * Set site of account.
     * @param site String.
     */
    public abstract void setSite(String site);

    /**
     * Set ticker of account.
     * @param ticker String.
     */
    public abstract void setTicker(String ticker);

    /**
     * Set name of account.
     * @param type String.
     */
    public abstract void setType(String type);
    /**
     * Set name of account.
     * @param ownership String.
     */
    public abstract void setOwnership(String ownership);

    /**
     * Set industry of account.
     * @param industry String.
     */
    public abstract void setIndustry(String industry);

    /**
     * Set employee of account.
     * @param employee String.
     */
    public abstract void setEmployee(String employee);

    /**
     * Set anualRevenue of account.
     * @param anualRevenue String.
     */
    public abstract void setAnualRevenue(String anualRevenue);

    /**
     * Set sicCode of account.
     * @param sicCode String.
     */
    public abstract void setSicCode(String sicCode);

    /**
     * Set billingStreet of account.
     * @param billingStreet String.
     */
    public abstract void setBillingStreet(String billingStreet);

    /**
     * Set shippingStreet of account.
     * @param shippingStreet String.
     */
    public abstract void setShippingStreet(String shippingStreet);

    /**
     * Set billingCity of account.
     * @param billingCity String.
     */
    public abstract void setBillingCity(String billingCity);

    /**
     * Set billingState of account.
     * @param billingState String.
     */
    public abstract void setBillingState(String billingState);

    /**
     * Set shippingCity of account.
     * @param shippingCity String.
     */
    public abstract void setShippingCity(String shippingCity);

    /**
     * Set shippingState of account.
     * @param shippingState String.
     */
    public abstract void setShippingState(String shippingState);

    /**
     * Set billingZip of account.
     * @param billingZip String.
     */
    public abstract void setBillingZip(String billingZip);

    /**
     * Set billingCountry of account.
     * @param billingCountry String.
     */
    public abstract void setBillingCountry(String billingCountry);

    /**
     * Set shippingZip of account.
     * @param shippingZip String.
     */
    public abstract void setShippingZip(String shippingZip);

    /**
     * Set shippingCountry of account.
     * @param shippingCountry String.
     */
    public abstract void setShippingCountry(String shippingCountry);

    /**
     * Set customerPriority of account.
     * @param customerPriority String.
     */
    public abstract void setCustomerPriority(String customerPriority);

    /**
     * Set slaAccount of account.
     * @param slaAccount String.
     */
    public abstract void setSlaAccount(String slaAccount);

    /**
     * Set slaDate of account.
     * @param slaDate String.
     */
    public abstract void setSlaDate(String slaDate);

    /**
     * Set slaSerial of account.
     * @param slaSerial String.
     */
    public abstract void setSlaSerial(String slaSerial);

    /**
     * Set numberLocations of account.
     * @param numberLocations String.
     */
    public abstract void setNumberLocations(String numberLocations);

    /**
     * Set upsellOportunity of account.
     * @param upsellOportunity String.
     */
    public abstract void setUpsellOportunity(String upsellOportunity);

    /**
     * Set active of account.
     * @param active String.
     */
    public abstract void setActive(String active);

    /**
     * Set description of account.
     * @param description String.
     */
    public abstract void setDescription(String description);


    /**
     * Set Campaign Data.
     * Just is name, can be more.
     *
     * @param account
     */
    public void setAccountData(final Account account, final Map<String, String> accountInformation) {
        HashMap<String, StrategySetter> strategyMap = composeStrategyMap(account, accountInformation);
        accountInformation.keySet().forEach(key -> {
            strategyMap.get(key).executeMethod();
            System.out.println(key);
        });
    }

    private HashMap<String, StrategySetter> composeStrategyMap(final Account account, final Map<String, String> accountInformation){
        HashMap<String, StrategySetter> strategyMap  = new HashMap<>();
        strategyMap.put("Name",        () -> setNameTxt(accountInformation.get("Name")));
        strategyMap.put("Phone",       () -> setPhone(accountInformation.get("Phone")));
        strategyMap.put("Fax",         () -> setFax(accountInformation.get("Fax")));
        strategyMap.put("Number",      () -> setNumberAccount(accountInformation.get("Number")));
        strategyMap.put("Website",     () -> setWebSite(accountInformation.get("Website")));
        strategyMap.put("Site",        () -> setSite(accountInformation.get("Ticker")));
        strategyMap.put("Ticker",      () -> setTicker(accountInformation.get("ticker")));
        strategyMap.put("Employee",    () -> setEmployee(accountInformation.get("Employee")));
        strategyMap.put("Revenue",     () -> setAnualRevenue(accountInformation.get("Revenue")));
        strategyMap.put("Sic Code",    () -> setSicCode(accountInformation.get("Sic Code")));
        strategyMap.put("Bill Street", () -> setBillingStreet(accountInformation.get("Bill Street")));
        strategyMap.put("Shipp Street",() -> setShippingStreet(accountInformation.get("Shipp Street")));
        strategyMap.put("Bill City",   () -> setBillingCity(accountInformation.get("Bill City")));
        strategyMap.put("Bill State",  () -> setBillingState(accountInformation.get("Bill State")));

        return strategyMap;
    }
}
