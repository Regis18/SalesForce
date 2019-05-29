/*
 * @(#) NewAccountClassicPage.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.classic.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import salesforce.ui.pages.abstracts.account.NewAccountPageAbstract;

/**
 * NewAccountClassicPage.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public class NewAccountClassicPage extends NewAccountPageAbstract {

    @FindBy(id = "bodyCell")
    private WebElement newAccountForm;

    @FindBy(id = "acc2")
    private WebElement nameTxt;

    @FindBy(id = "acc3")
    private WebElement parentTxt;

    @FindBy(id = "acc5")
    private WebElement numberTxt;

    @FindBy(id = "acc23")
    private WebElement siteTxt;

    @FindBy(id = "acc6")
    private WebElement typeCmb;

    @FindBy(id = "acc7")
    private WebElement industryCmb;

    @FindBy(id = "acc8")
    private WebElement revenueTxt;

    @FindBy(id = "acc9")
    private WebElement ratingCmb;

    @FindBy(id = "acc11")
    private WebElement faxTxt;

    @FindBy(id = "acc14")
    private WebElement ownershipCmb;

    @FindBy(id = "acc10")
    private WebElement phoneTxt;

    @FindBy(id = "acc12")
    private WebElement websiteTxt;

    @FindBy(id = "acc13")
    private WebElement tickerSimpbolTxt;

    @FindBy(id = "acc15")
    private WebElement employeesTxt;

    @FindBy(id = "acc16")
    private WebElement sicCodeTxt;

    @FindBy(id = "acc17street")
    private WebElement billingStreetArea;

    @FindBy(id = "acc18street")
    private WebElement shippingStreetArea;

    @FindBy(id = "acc17city")
    private WebElement billingCityTxt;

    @FindBy(id = "acc18city")
    private WebElement shippingCityTxt;

    @FindBy(id = "acc17state")
    private WebElement billingStateTxt;

    @FindBy(id = "acc18state")
    private WebElement shippingStateTxt;

    @FindBy(id = "acc17zip")
    private WebElement billingZipTxt;

    @FindBy(id = "acc18zip")
    private WebElement shippingZipTxt;

    @FindBy(id = "acc17country")
    private WebElement billingCountryTxt;

    @FindBy(id = "acc18country")
    private WebElement shippingCountryTxt;

    @FindBy(id = "00N4P0000072sE6")
    private WebElement customerPriorityCmb;

    @FindBy(id = "00N4P0000072sE8")
    private WebElement slaCmb;

    @FindBy(id = "00N4P0000072sEA")
    private WebElement slaSerialTxt;

    @FindBy(id = "00N4P0000072sE7")
    private WebElement numberLocationsTxt;

    @FindBy(id = "00N4P0000072sE5")
    private WebElement activeCmb;

    @FindBy(id = "00N4P0000072sEB")
    private WebElement upsellOportunityCmb;

    @FindBy(id = "00N4P0000072sE7")
    private WebElement slaDateTxt;

    @FindBy(id = "acc20")
    private WebElement descriptionTxt;

    @FindBy (xpath = "//td[@id=\"bottomButtonRow\"]//input[@name=\"save\"]")
    private WebElement saveAccountBtn;

    /**
     * Wait for newCampaignForm.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newAccountForm));
    }

    /**
     * Set name in the name Text.
     * @param name String
     */
    @Override
    protected void setNameTxt(final String name) { nameTxt.sendKeys(name); }

    /**
     * Set name in the phone Text.
     * @param phone String
     */
    @Override
    public void setPhone(String phone) { phoneTxt.sendKeys(phone); }

    /**
     * Set name in the rating List.
     * @param rating String
     */
    @Override
    public void setRating(String rating) {
        Select accountRole = new Select(ratingCmb);
        accountRole.selectByVisibleText(rating);
    }

    /**
     * Set name in the parent Text.
     * @param parent String
     */
    @Override
    public void setParent(String parent) { parentTxt.sendKeys(parent); }


    @Override
    public void setFax(String fax) { faxTxt.sendKeys(fax); }

    @Override
    public void setNumberAccount(String numberAccount) { numberTxt.sendKeys(numberAccount); }

    @Override
    public void setWebSite(String webSite) { websiteTxt.sendKeys(webSite); }

    @Override
    public void setSite(String site) { siteTxt.sendKeys(site); }

    @Override
    public void setTicker(String ticker) { tickerSimpbolTxt.sendKeys(ticker); }

    @Override
    public void setType(String type) {
        Select typeAccount = new Select(typeCmb);
        typeAccount.selectByVisibleText(type);
    }

    @Override
    public void setOwnership(String ownership) {
        Select typeOwnership = new Select(ownershipCmb);
        typeOwnership.selectByVisibleText(ownership);
    }

    @Override
    public void setIndustry(String industry) {
        Select typeSector = new Select(industryCmb);
        typeSector.selectByVisibleText(industry);
    }

    @Override
    public void setEmployee(String employee) { employeesTxt.sendKeys(employee); }

    @Override
    public void setAnualRevenue(String anualRevenue) { revenueTxt.sendKeys(anualRevenue); }

    @Override
    public void setSicCode(String sicCode) { sicCodeTxt.sendKeys(sicCode); }

    @Override
    public void setBillingStreet(String billingStreet) { billingStreetArea.sendKeys(billingStreet); }

    @Override
    public void setShippingStreet(String shippingStreet) { shippingStreetArea.sendKeys(shippingStreet); }

    @Override
    public void setBillingCity(String billingCity) { billingCityTxt.sendKeys(billingCity); }

    @Override
    public void setBillingState(String billingState) { billingStateTxt.sendKeys(billingState); }

    @Override
    public void setShippingCity(String shippingCity) { shippingCityTxt.sendKeys(shippingCity); }

    @Override
    public void setShippingState(String shippingState) { shippingStateTxt.sendKeys(shippingState); }

    @Override
    public void setBillingZip(String billingZip) { billingZipTxt.sendKeys(billingZip); }

    @Override
    public void setBillingCountry(String billingCountry) { billingCountryTxt.sendKeys(billingCountry); }

    @Override
    public void setShippingZip(String shippingZip) { shippingZipTxt.sendKeys(shippingZip); }

    @Override
    public void setShippingCountry(String shippingCountry) { shippingCountryTxt.sendKeys(shippingCountry); }

    @Override
    public void setCustomerPriority(String customerPriority) { customerPriorityCmb.sendKeys(customerPriority); }

    @Override
    public void setSlaAccount(String slaAccount) {
        Select sla = new Select(slaCmb);
        sla.selectByVisibleText(slaAccount);
    }

    @Override
    public void setSlaDate(String slaDate) { slaDateTxt.sendKeys(slaDate); }

    @Override
    public void setSlaSerial(String slaSerial) { slaSerialTxt.sendKeys(slaSerial); }

    @Override
    public void setNumberLocations(String numberLocations) { numberLocationsTxt.sendKeys(numberLocations); }

    @Override
    public void setUpsellOportunity(String upsellOportunity) {
        Select upsell = new Select(upsellOportunityCmb);
        upsell.selectByVisibleText(upsellOportunity);
    }

    @Override
    public void setActive(String active) {
        Select activeAccount = new Select(activeCmb);
        activeAccount.selectByVisibleText(active);
    }

    @Override
    public void setDescription(String description) { descriptionTxt.sendKeys(description); }

    /**
     * Click to Save the changes.
     */
    public void clickSaveBtn() {
        saveAccountBtn.click();
    }
}
