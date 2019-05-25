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
 */
public class NewAccountPopup extends NewAccountPageAbstract {

    @FindBy(xpath = "//div[@class=\"uiInput witsSuggestedNameField uiInput--default\"]//input[@class=\"input uiInput uiInputText uiInput--default uiInput--input\"]")
    private WebElement nameAccountTxt;

    @FindBy(css = "div[id^='47']")
    private WebElement ratingAccountTxt;

    @FindBy(css = "input[id^='115']")
    private WebElement phoneAccountTxt;

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
     * Wait for the Popup to initialize.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameAccountTxt));
    }

    /**
     * Set all of the values that is required for the new account.
     * @param data **this is the data**
     */
    @Override
    public void setAccountData(final String data) {
        setNameTxt(data);
    }

    /**
     * Set the phone into NameTxt.
     * @param phone
     */
    protected void setPhone(final String phone) {
        phoneAccountTxt.sendKeys(phone);
    }

    /**
     * Set the name into NameTxt.
     * @param name
     */
    protected void setNameTxt(final String name) {
        nameAccountTxt.sendKeys(name);
    }

    /**
     * Click to Save the changes.
     */
    public void clickSaveBtn() {
        saveAccountBtn.click();
    }
}
