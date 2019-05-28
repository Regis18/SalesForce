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

import salesforce.entities.Account;
import salesforce.entities.Campaign;
import salesforce.ui.BasePage;
import salesforce.ui.PageFactory;
import salesforce.ui.pages.abstracts.campaign.OneCampaignAbstract;
import salesforce.utils.StrategySetter;

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
        //setAccountData(account);
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

    public abstract void setRating(String rating);
    public abstract void setPhone(String phone);
    public abstract void setParent(String parent);
    public abstract void setFax(String fax);
    public abstract void setNumberAccount(String numberAccount);
    public abstract void setWebSite(String webSite);
    public abstract void setSite(String site);
    public abstract void setTicker(String ticker);
    public abstract void setType(String type);
    public abstract void setOwnership(String ownership);
    public abstract void setIndustry(String industry);
    public abstract void setEmployee(String employee);
    public abstract void setAnualRevenue(String anualRevenue);
    public abstract void setSicCode(String sicCode);
    public abstract void setBillingStreet(String billingStreet);
    public abstract void setShippingStreet(String shippingStreet);
    public abstract void setBillingCity(String billingCity);
    public abstract void setBillingState(String billingState);
    public abstract void setShippingCity(String shippingCity);
    public abstract void setShippingState(String shippingState);
    public abstract void setBillingZip(String billingZip);
    public abstract void setBillingCountry(String billingCountry);
    public abstract void setShippingZip(String shippingZip);
    public abstract void setShippingCountry(String shippingCountry);
    public abstract void setCustomerPriority(String customerPriority);
    public abstract void setSlaAccount(String slaAccount);
    public abstract void setSlaDate(String slaDate);
    public abstract void setSlaSerial(String slaSerial);
    public abstract void setNumberLocations(String numberLocations);
    public abstract void setUpsellOportunity(String upsellOportunity);
    public abstract void setActive(String active);
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
        strategyMap.put("name",        () -> setNameTxt(accountInformation.get("name")));
        strategyMap.put("phone",       () -> setPhone(accountInformation.get("phone")));
        strategyMap.put("fax",         () -> setFax(accountInformation.get("fax")));
        strategyMap.put("number",      () -> setNumberAccount(accountInformation.get("number")));
        strategyMap.put("website",     () -> setWebSite(accountInformation.get("website")));
        strategyMap.put("site",        () -> setSite(accountInformation.get("site")));
        strategyMap.put("ticker",      () -> setTicker(accountInformation.get("ticker")));
        strategyMap.put("employee",    () -> setEmployee(accountInformation.get("employee")));
        strategyMap.put("revenue",     () -> setAnualRevenue(accountInformation.get("revenue")));
        strategyMap.put("sic code",    () -> setSicCode(accountInformation.get("sic code")));
        strategyMap.put("bill street", () -> setBillingStreet(accountInformation.get("bill street")));
        strategyMap.put("shipp street",() -> setShippingStreet(accountInformation.get("shipp street")));
        strategyMap.put("bill city",   () -> setBillingCity(accountInformation.get("bill city")));
        strategyMap.put("bill state",  () -> setBillingState(accountInformation.get("bill state")));

        return strategyMap;
    }
}
