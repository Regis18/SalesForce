/*
 * @(#) NewAccountPopup.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.lightning.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.abstracts.account.NewAccountPageAbstract;

/**
 * NewAccountPopup.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public class NewAccountPopup extends NewAccountPageAbstract {

    @FindBy(css = "div[class=\"modal-container slds-modal__container\"]")
    private WebElement newAccountPopup;

    @FindBy(xpath = "//div[@class=\"uiInput witsSuggestedNameField uiInput--default\"]//input[@class=\"input uiInput uiInputText uiInput--default uiInput--input\"]")
    private WebElement nameAccountTxt;

    @FindBy(css = "div[id^='47']")
    private WebElement ratingAccountTxt;

    @FindBy(css = "input[id^='115']")
    private WebElement phoneAccountTxt;

    @FindBy(css = "input[id^='135']")
    private WebElement parentAccountTxt;

    @FindBy(css = "input[id^='211']")
    private WebElement faxAccountTxt;

    @FindBy(css = "input[id^='231']")
    private WebElement accountNumberTxt;

    @FindBy(css = "input[id^='247']")
    private WebElement websiteAccountTxt;

    @FindBy(css = "input[id^='268']")
    private WebElement siteAccountTxt;

    @FindBy(css = "input[id^='284']")
    private WebElement tickerSimbolAccountTxt;

    @FindBy(css = "input[id^='446']")
    private WebElement employeeAccountTxt;

    @FindBy(css = "input[id^='468']")
    private WebElement annualRevenueAccountTxt;

    @FindBy(css = "input[id^='486']")
    private WebElement sicCodeAccountTxt;

    @FindBy(css = "div[id^='311']")
    private WebElement typeAccountLst;

    @FindBy(css = "input[id^='357']")
    private WebElement ownershipAccountLst;

    @FindBy(css = "input[id^='407']")
    private WebElement industryAccountLst;

    @FindBy(css = "textarea[id^='547']")
    private WebElement billingStreetAccountArea;

    @FindBy(css = "textarea[id^='615']")
    private WebElement shippingStreetAccountArea;

    @FindBy(css = "input[id^='557']")
    private WebElement billingCityAccountTxt;

    @FindBy(css = "input[id^='526']")
    private WebElement billingStateAccountTxt;

    @FindBy(css = "input[id^='625']")
    private WebElement shippingCityAccountTxt;

    @FindBy(css = "input[id^='594']")
    private WebElement shipppingStateAccountTxt;

    @FindBy(css = "input[id^='568']")
    private WebElement billingZipAccountTxt;

    @FindBy(css = "input[id^='518']")
    private WebElement billingCountryAccountTxt;

    @FindBy(css = "input[id^='636']")
    private WebElement shipppingZipAccountTxt;

    @FindBy(css = "input[id^='586']")
    private WebElement shipppingCountryAccountTxt;

    @FindBy(css = "div[id^='675']")
    private WebElement customerAccountLst;

    @FindBy(css = "div[id^='721']")
    private WebElement slaStateAccountTxt;

    @FindBy(css = "input[id^='764']")
    private WebElement slaDateAccountTxt;

    @FindBy(css = "input[id^='787']")
    private WebElement slaSerialStateAccountTxt;

    @FindBy(css = "input[id^='807']")
    private WebElement locationAccountLst;

    @FindBy(css = "input[id^='832']")
    private WebElement upsellStateAccountLst;

    @FindBy(css = "div[id^='882']")
    private WebElement activeStateAccountLst;

    @FindBy(css = "textarea[id^='950']")
    private WebElement descriptionStateAccountArea;

    @FindBy(xpath = "//button[@class=\"slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton\"]")
    private WebElement saveAccountBtn;

    /**
     * Wait for the Pop up to initialize.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newAccountPopup));
    }


    @Override
    protected void setNameTxt(String name) { nameAccountTxt.sendKeys(name); }

    /**
     * Set the phone into NameTxt.
     * @param phone
     */
    @Override
    public void setPhone(String phone) { phoneAccountTxt.sendKeys(phone); }

    @Override
    public void setRating(String rating) { ratingAccountTxt.sendKeys(rating); }

    @Override
    public void setParent(String parent) { parentAccountTxt.sendKeys(parent); }
    @Override
    public void setFax(String fax) { faxAccountTxt.sendKeys(fax); }
    @Override
    public void setNumberAccount(String numberAccount) { accountNumberTxt.sendKeys(numberAccount); }
    @Override
    public void setWebSite(String webSite) { websiteAccountTxt.sendKeys(webSite); }
    @Override
    public void setSite(String site) { siteAccountTxt.sendKeys(site); }
    @Override
    public void setTicker(String ticker) { tickerSimbolAccountTxt.sendKeys(ticker); }
    @Override
    public void setType(String type) { employeeAccountTxt.sendKeys(type); }
    @Override
    public void setOwnership(String ownership) { ownershipAccountLst.sendKeys(ownership); }
    @Override
    public void setIndustry(String industry) { industryAccountLst.sendKeys(industry); }
    @Override
    public void setEmployee(String employee) { phoneAccountTxt.sendKeys(employee); }
    @Override
    public void setAnualRevenue(String anualRevenue) { annualRevenueAccountTxt.sendKeys(anualRevenue); }
    @Override
    public void setSicCode(String sicCode) { sicCodeAccountTxt.sendKeys(sicCode); }
    @Override
    public void setBillingStreet(String billingStreet) { billingStreetAccountArea.sendKeys(billingStreet); }
    @Override
    public void setShippingStreet(String shippingStreet) { shippingStreetAccountArea.sendKeys(shippingStreet); }
    @Override
    public void setBillingCity(String billingCity) { phoneAccountTxt.sendKeys(billingCity); }
    @Override
    public void setBillingState(String billingState) { phoneAccountTxt.sendKeys(billingState); }
    @Override
    public void setShippingCity(String shippingCity) { shippingCityAccountTxt.sendKeys(shippingCity); }
    @Override
    public void setShippingState(String shippingState) { shipppingStateAccountTxt.sendKeys(shippingState); }
    @Override
    public void setBillingZip(String billingZip) { billingZipAccountTxt.sendKeys(billingZip); }
    @Override
    public void setBillingCountry(String billingCountry) { billingCountryAccountTxt.sendKeys(billingCountry); }
    @Override
    public void setShippingZip(String shippingZip) { shipppingZipAccountTxt.sendKeys(shippingZip); }
    @Override
    public void setShippingCountry(String shippingCountry) { shipppingCountryAccountTxt.sendKeys(shippingCountry); }
    @Override
    public void setCustomerPriority(String customerPriority) { customerAccountLst.sendKeys(customerPriority); }
    @Override
    public void setSlaAccount(String slaAccount) { slaStateAccountTxt.sendKeys(slaAccount); }
    @Override
    public void setSlaDate(String slaDate) { slaDateAccountTxt.sendKeys(slaDate); }
    @Override
    public void setSlaSerial(String slaSerial) { slaSerialStateAccountTxt.sendKeys(slaSerial); }
    @Override
    public void setNumberLocations(String numberLocations) { locationAccountLst.sendKeys(numberLocations); }
    @Override
    public void setUpsellOportunity(String upsellOportunity) { upsellStateAccountLst.sendKeys(upsellOportunity); }
    @Override
    public void setActive(String active) { activeStateAccountLst.sendKeys(active); }
    @Override
    public void setDescription(String description) { descriptionStateAccountArea.sendKeys(description); }

    /**
     * Click to Save the changes.
     */
    public void clickSaveBtn() {
        saveAccountBtn.click();
    }
}
