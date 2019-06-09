/*
 * @(#) EditAccountClassic.java Copyright (c) 2019 Jala Foundation.
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import salesforce.ui.pages.account.abstracts.EditAccountAbstract;

import java.util.LinkedList;
import java.util.Set;

public class EditAccountClassic extends EditAccountAbstract {

    @FindBy(id = "bodyCell")
    private WebElement newAccountForm;

    @FindBy(id = "acc2")
    private WebElement nameTxt;

    @FindBy(id = "acc3_lkwgt")
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

    @FindBy(id = "00N4P0000072sE9")
    private WebElement slaDateTxt;

    @FindBy(id = "acc20")
    private WebElement descriptionTxt;

    @FindBy (xpath = "//td[@id=\"bottomButtonRow\"]//input[@name=\"save\"]")
    private WebElement saveAccountBtn;

    /**
     * Wait for newAccountForm.
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
    protected void setNameTxt(final String name) {
        nameTxt.sendKeys(name);
    }

    /**
     * Set name in the phone Text.
     * @param phone String
     */
    @Override
    public void setPhone(final String phone) {
        phoneTxt.sendKeys(phone);
    }

    /**
     * Set name in the rating List.
     * @param rating String
     */
    @Override
    public void setRating(final String rating) {
        Select accountRole = new Select(ratingCmb);
        accountRole.selectByVisibleText(rating);
    }

    /**
     * Set name in the parent Text.
     * @param parent String
     */
    @Override
    public void setParent(final String parent) {
        parentTxt.click();
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        driver.switchTo().window(new LinkedList<>(windows).getLast());
        driver.switchTo().frame("resultsFrame");
        driver.findElement(By.cssSelector("table.list tr:nth-child(2) th:nth-child(1) a")).click();
        driver.switchTo().window(parentWindowHandle);
    }

    /**
     * Set name in the fax Text.
     * @param fax String
     */
    @Override
    public void setFax(final String fax) {
        faxTxt.sendKeys(fax);
    }

    /**
     * Set name in the numberAccount Text.
     * @param numberAccount String
     */
    @Override
    public void setNumberAccount(final String numberAccount) {
        numberTxt.sendKeys(numberAccount);
    }

    /**
     * Set name in the webSite Text.
     * @param webSite String
     */
    @Override
    public void setWebSite(final String webSite) {
        websiteTxt.sendKeys(webSite);
    }

    /**
     * Set name in the site Text.
     * @param site String
     */
    @Override
    public void setSite(final String site) {
        siteTxt.sendKeys(site);
    }

    /**
     * Set name in the ticker Text.
     * @param ticker String
     */
    @Override
    public void setTicker(final String ticker) {
        tickerSimpbolTxt.sendKeys(ticker);
    }

    /**
     * Set name in the type Text.
     * @param type String
     */
    @Override
    public void setType(final String type) {
        Select typeAccount = new Select(typeCmb);
        typeAccount.selectByVisibleText(type);
    }

    /**
     * Set name in the ownership Element.
     * @param ownership String
     */
    @Override
    public void setOwnership(final String ownership) {
        Select typeOwnership = new Select(ownershipCmb);
        typeOwnership.selectByVisibleText(ownership);
    }

    /**
     * Set name in the industry Element.
     * @param industry String
     */
    @Override
    public void setIndustry(final String industry) {
        Select typeSector = new Select(industryCmb);
        typeSector.selectByVisibleText(industry);
    }

    /**
     * Set name in the employee Text.
     * @param employee String
     */
    @Override
    public void setEmployee(final String employee) {
        employeesTxt.sendKeys(employee);
    }

    /**
     * Set name in the anualRevenue Text.
     * @param anualRevenue String
     */
    @Override
    public void setAnualRevenue(final String anualRevenue) {
        revenueTxt.sendKeys(anualRevenue);
    }

    /**
     * Set name in the sicCode Text.
     * @param sicCode String
     */
    @Override
    public void setSicCode(final String sicCode) {
        sicCodeTxt.sendKeys(sicCode);
    }

    /**
     * Set name in the billingStreet Text.
     * @param billingStreet String
     */
    @Override
    public void setBillingStreet(final String billingStreet) {
        billingStreetArea.sendKeys(billingStreet);
    }

    /**
     * Set name in the shippingStreet Text.
     * @param shippingStreet String
     */
    @Override
    public void setShippingStreet(final String shippingStreet) {
        shippingStreetArea.sendKeys(shippingStreet);
    }

    /**
     * Set name in the billingCity Text.
     * @param billingCity String
     */
    @Override
    public void setBillingCity(final String billingCity) {
        billingCityTxt.sendKeys(billingCity);
    }

    /**
     * Set name in the billingState Text.
     * @param billingState String
     */
    @Override
    public void setBillingState(final String billingState) {
        billingStateTxt.sendKeys(billingState);
    }

    /**
     * Set name in the shippingCity Text.
     * @param shippingCity String
     */
    @Override
    public void setShippingCity(final String shippingCity) {
        shippingCityTxt.sendKeys(shippingCity);
    }

    /**
     * Set name in the shippingState Text.
     * @param shippingState String
     */
    @Override
    public void setShippingState(final String shippingState) {
        shippingStateTxt.sendKeys(shippingState);
    }

    /**
     * Set name in the billingZip Text.
     * @param billingZip String
     */
    @Override
    public void setBillingZip(final String billingZip) {
        billingZipTxt.sendKeys(billingZip);
    }

    /**
     * Set name in the billingCountry Text.
     * @param billingCountry String
     */
    @Override
    public void setBillingCountry(final String billingCountry) {
        billingCountryTxt.sendKeys(billingCountry);
    }

    /**
     * Set name in the shippingZip Text.
     * @param shippingZip String
     */
    @Override
    public void setShippingZip(final String shippingZip) {
        shippingZipTxt.sendKeys(shippingZip);
    }

    /**
     * Set name in the shippingCountry Text.
     * @param shippingCountry String
     */
    @Override
    public void setShippingCountry(final String shippingCountry) {
        shippingCountryTxt.sendKeys(shippingCountry);
    }

    /**
     * Set name in the customerPriority Element.
     * @param customerPriority String
     */
    @Override
    public void setCustomerPriority(final String customerPriority) {
        customerPriorityCmb.sendKeys(customerPriority);
    }

    /**
     * Set name in the slaAccount Element.
     * @param slaAccount String
     */
    @Override
    public void setSlaAccount(final String slaAccount) {
        Select sla = new Select(slaCmb);
        sla.selectByVisibleText(slaAccount);
    }

    /**
     * Set name in the slaDate Date.
     * @param slaDate String
     */
    @Override
    public void setSlaDate(final String slaDate) {
        slaDateTxt.sendKeys(slaDate);
    }

    /**
     * Set name in the slaSerial Text.
     * @param slaSerial String
     */
    @Override
    public void setSlaSerial(final String slaSerial) {
        slaSerialTxt.sendKeys(slaSerial);
    }

    /**
     * Set name in the numberLocations Text.
     * @param numberLocations String
     */
    @Override
    public void setNumberLocations(final String numberLocations) {
        numberLocationsTxt.sendKeys(numberLocations);
    }

    /**
     * Set name in the upsellOportunity Element.
     * @param upsellOportunity String
     */
    @Override
    public void setUpsellOportunity(final String upsellOportunity) {
        Select upsell = new Select(upsellOportunityCmb);
        upsell.selectByVisibleText(upsellOportunity);
    }

    /**
     * Set name in the active Element.
     * @param active String
     */
    @Override
    public void setActive(final String active) {
        Select activeAccount = new Select(activeCmb);
        activeAccount.selectByVisibleText(active);
    }

    /**
     * Set name in the description Text.
     * @param description String
     */
    @Override
    public void setDescription(final String description) {
        descriptionTxt.sendKeys(description);
    }

    /**
     * Click to Save the changes.
     */
    public void clickSaveBtn() {
        saveAccountBtn.click();
    }
}
