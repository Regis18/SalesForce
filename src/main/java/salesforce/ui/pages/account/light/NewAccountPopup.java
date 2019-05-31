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

package salesforce.ui.pages.account.light;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.account.abstracts.NewAccountPageAbstract;

/**
 * NewAccountPopup.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public class NewAccountPopup extends NewAccountPageAbstract {

    @FindBy(css = "div[class=\"modal-container slds-modal__container\"]")
    private WebElement newAccountPopup;

    @FindBy(css = "input[id^='90']")
    private WebElement nameAccountTxt;

    @FindBy(css = "div[id^='47']")
    private WebElement ratingAccountCmb;

    @FindBy(xpath = "//a[@title=\"Warm\"]")
    private WebElement ratingWarElement;

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
    private WebElement typeAccountCmb;

    @FindBy(xpath = "//a[@title=\"Prospect\"]")
    private WebElement typeProspectElement;

    @FindBy(css = "div[id^='357']")
    private WebElement ownershipAccountCmb;

    @FindBy(xpath = "//a[@title=\"Private\"]")
    private WebElement ownerPrivateElement;

    @FindBy(css = "div[id^='407']")
    private WebElement industryAccountCmb;

    @FindBy(xpath = "//a[@title=\"Technology\"]")
    private WebElement industryTechnologyElement;

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
    private WebElement customerAccountCmb;

    @FindBy(xpath = "//a[@title=\"High\"]")
    private WebElement customerHighElement;

    @FindBy(xpath = "//a[@title=\"Hight\"]")
    private WebElement optionHightCustomer;

    @FindBy(css = "div[id^='721']")
    private WebElement slaStateAccountCmb;

    @FindBy(xpath = "//a[@title=\"Platinum\"]")
    private WebElement slaPlatinumElement;

    @FindBy(css = "input[id^='764']")
    private WebElement slaDateAccountTxt;

    @FindBy(css = "input[id^='787']")
    private WebElement slaSerialStateAccountTxt;

    @FindBy(css = "input[id^='807']")
    private WebElement locationAccountCmb;

    @FindBy(css = "div[id^='832']")
    private WebElement upsellStateAccountCmb;

    @FindBy(xpath = "//a[@title=\"Maybe\"]")
    private WebElement upsellMaybeElement;

    @FindBy(css = "div[id^='882']")
    private WebElement activeStateAccountCmb;

    @FindBy(xpath = "//a[@title=\"Yes\"]")
    private WebElement activeYesElement;


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

    /**
     * Set name in the name TextBox.
     * @param name String
     */
    @Override
    public void setNameTxt(final String name) {
        nameAccountTxt.sendKeys(name);
    }

    /**
     * Set name in the phone Text.
     * @param phone String
     */
    @Override
    public void setPhone(final String phone) {
        phoneAccountTxt.sendKeys(phone);
    }

    /**
     * Set name in the rating List.
     * @param rating String
     */
    @Override
    public void setRating(final String rating) {
        ratingAccountCmb.click();
        ratingWarElement.click();
    }

    /**
     * Set name in the parent Text.
     * @param parent String
     */
    @Override
    public void setParent(final String parent) {
        faxAccountTxt.sendKeys(parent);
    }

    /**
     * Set name in the fax Text.
     * @param fax String
     */
    @Override
    public void setFax(final String fax) {
        faxAccountTxt.sendKeys(fax);
    }

    /**
     * Set name in the numberAccount Text.
     * @param numberAccount String
     */
    @Override
    public void setNumberAccount(final String numberAccount) {
        accountNumberTxt.sendKeys(numberAccount);
    }

    /**
     * Set name in the webSite Text.
     * @param webSite String
     */
    @Override
    public void setWebSite(final String webSite) {
        websiteAccountTxt.sendKeys(webSite);
    }

    /**
     * Set name in the site Text.
     * @param site String
     */
    @Override
    public void setSite(final String site) {
        siteAccountTxt.sendKeys(site);
    }

    /**
     * Set name in the ticker Text.
     * @param ticker String
     */
    @Override
    public void setTicker(final String ticker) {
        tickerSimbolAccountTxt.sendKeys(ticker);
    }

    /**
     * Set name in the type Text.
     * @param type String
     */
    @Override
    public void setType(final String type) {
        typeAccountCmb.click();
        typeProspectElement.click();
    }

    /**
     * Set name in the ownership Element.
     * @param ownership String
     */
    @Override
    public void setOwnership(final String ownership) {
        ownershipAccountCmb.click();
        ownerPrivateElement.click();
    }

    /**
     * Set name in the industry Element.
     * @param industry String
     */
    @Override
    public void setIndustry(final String industry) {
        industryAccountCmb.click();
        industryTechnologyElement.click();
    }

    /**
     * Set name in the employee Text.
     * @param employee String
     */
    @Override
    public void setEmployee(final String employee) {
        employeeAccountTxt.sendKeys(employee);
    }

    /**
     * Set name in the anualRevenue Text.
     * @param anualRevenue String
     */
    @Override
    public void setAnualRevenue(final String anualRevenue) {
        annualRevenueAccountTxt.sendKeys(anualRevenue);
    }

    /**
     * Set name in the sicCode Text.
     * @param sicCode String
     */
    @Override
    public void setSicCode(final String sicCode) {
        sicCodeAccountTxt.sendKeys(sicCode);
    }

    /**
     * Set name in the billingStreet Text.
     * @param billingStreet String
     */
    @Override
    public void setBillingStreet(final String billingStreet) {
        billingStreetAccountArea.sendKeys(billingStreet);
    }

    /**
     * Set name in the shippingStreet Text.
     * @param shippingStreet String
     */
    @Override
    public void setShippingStreet(final String shippingStreet) {
        shippingStreetAccountArea.sendKeys(shippingStreet);
    }

    /**
     * Set name in the billingCity Text.
     * @param billingCity String
     */
    @Override
    public void setBillingCity(final String billingCity) {
        billingCityAccountTxt.sendKeys(billingCity);
    }

    /**
     * Set name in the billingState Text.
     * @param billingState String
     */
    @Override
    public void setBillingState(final String billingState) {
        billingStateAccountTxt.sendKeys(billingState);
    }

    /**
     * Set name in the shippingCity Text.
     * @param shippingCity String
     */
    @Override
    public void setShippingCity(final String shippingCity) {
        shippingCityAccountTxt.sendKeys(shippingCity);
    }

    /**
     * Set name in the shippingState Text.
     * @param shippingState String
     */
    @Override
    public void setShippingState(final String shippingState) {
        shipppingStateAccountTxt.sendKeys(shippingState);
    }

    /**
     * Set name in the billingZip Text.
     * @param billingZip String
     */
    @Override
    public void setBillingZip(final String billingZip) {
        billingZipAccountTxt.sendKeys(billingZip);
    }

    /**
     * Set name in the billingCountry Text.
     * @param billingCountry String
     */
    @Override
    public void setBillingCountry(final String billingCountry) {
        billingCountryAccountTxt.sendKeys(billingCountry);
    }

    /**
     * Set name in the shippingZip Text.
     * @param shippingZip String
     */
    @Override
    public void setShippingZip(final String shippingZip) {
        shipppingZipAccountTxt.sendKeys(shippingZip);
    }

    /**
     * Set name in the shippingCountry Text.
     * @param shippingCountry String
     */
    @Override
    public void setShippingCountry(final String shippingCountry) {
        shipppingCountryAccountTxt.sendKeys(shippingCountry);
    }

    /**
     * Set name in the customerPriority Element.
     * @param customerPriority String
     */
    @Override
    public void setCustomerPriority(final String customerPriority) {
        customerAccountCmb.click();
        customerHighElement.click();
    }

    /**
     * Set name in the slaAccount Element.
     * @param slaAccount String
     */
    @Override
    public void setSlaAccount(final String slaAccount) {
        slaStateAccountCmb.click();
        slaPlatinumElement.click();
    }

    /**
     * Set name in the slaDate Date.
     * @param slaDate String
     */
    @Override
    public void setSlaDate(final String slaDate) {
        slaDateAccountTxt.sendKeys(slaDate);
    }

    /**
     * Set name in the slaSerial Text.
     * @param slaSerial String
     */
    @Override
    public void setSlaSerial(final String slaSerial) {
        slaSerialStateAccountTxt.sendKeys(slaSerial);
    }

    /**
     * Set name in the numberLocations Text.
     * @param numberLocations String
     */
    @Override
    public void setNumberLocations(final String numberLocations) {
        locationAccountCmb.sendKeys(numberLocations);
    }

    /**
     * Set name in the upsellOportunity Element.
     * @param upsellOportunity String
     */
    @Override
    public void setUpsellOportunity(final String upsellOportunity) {
        upsellStateAccountCmb.click();
        upsellMaybeElement.click();
    }

    /**
     * Set name in the active Element.
     * @param active String
     */
    @Override
    public void setActive(final String active) {
        activeStateAccountCmb.click();
        activeYesElement.click();
    }

    /**
     * Set name in the description Text.
     * @param description String
     */
    @Override
    public void setDescription(final String description) {
        descriptionStateAccountArea.sendKeys(description);
    }

    /**
     * Click to Save the changes.
     */
    public void clickSaveBtn() {
        saveAccountBtn.click();
    }
}
