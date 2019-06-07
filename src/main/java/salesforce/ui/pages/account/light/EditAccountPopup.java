/*
 * @(#) EditAccountPopup.java Copyright (c) 2019 Jala Foundation.
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.account.abstracts.EditAccountAbstract;

public class EditAccountPopup extends EditAccountAbstract {

    @FindBy(css = "[class='modal-container slds-modal__container']")
    private WebElement editAccount;

    @FindBy(css = " [class=\"input uiInput uiInputText uiInput--default uiInput--input\"]")
    private WebElement nameAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Parent Account')]]//*[@type='text']")
    private WebElement parentAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Phone')]]//*[@class=' input']")
    private WebElement phoneAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Fax')]]//*[@class=' input']")
    private WebElement faxAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Account Number')]]//*[@class=' input']")
    private WebElement numberAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Account Site')]]//*[@class=' input']")
    private WebElement siteAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Website')]]//*[@class=' input']")
    private WebElement webSiteAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Website')]]//*[@class=' input']")
    private WebElement tickerAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Employees')]]//*[@class=' input']")
    private WebElement employeeAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Annual Revenue')]]//*[@class=' input']")
    private WebElement annualAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'SIC Code')]]//*[@class=' input']")
    private WebElement sicCodeAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Billing Street')]]//*[@role='textbox']")
    private WebElement billingStreetAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Billing City')]]//*[@role='textbox']")
    private WebElement billingCityAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Billing Country')]]//*[@role='textbox']")
    private WebElement billingCountryAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Billing Zip/Postal Code')]]//*[@role='textbox']")
    private WebElement billingZipAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Billing State/Province')]]//*[@role='textbox']")
    private WebElement billingStateAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Shipping Street')]]//*[@role='textbox']")
    private WebElement shippingStreetAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Shipping City')]]//*[@role='textbox']")
    private WebElement shippingCityAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Shipping Country')]]//*[@role='textbox']")
    private WebElement shippingCountryAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Shipping Zip/Postal Code')]]//*[@role='textbox']")
    private WebElement shippingZipAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Shipping State/Province')]]//*[@role='textbox']")
    private WebElement shippingStateAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'SLA Expiration Date')]]//*[@class=' input']")
    private WebElement slaDateAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'SLA Serial Number')]]//*[@class=' input']")
    private WebElement slaSerialAccount;

    @FindBy(xpath = "//*[label//*[contains(text(),'Number of Locations')]]//*[@class=' input']")
    private WebElement numberLocationAccount;

    @FindBy(xpath = "//textarea[@class=\" textarea\"]")
    private WebElement descriptionAccount;

    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveBtn;

    /**
     * Waits for the Edit Campaign Popup appears.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(editAccount));
    }


    /**
     * Set name in the name TextBox.
     * @param name String
     */
    @Override
    public void setNameTxt(final String name) {
        nameAccount.sendKeys(name);
    }

    /**
     * Set name in the rating List.
     * @param rating String
     */
    @Override
    public void setRating(final String rating) {
//        ratingAccountCmb.click();
//        driver.findElement(By.xpath("//a[@title=\"" + rating + "\"]")).click();
    }

    /**
     * Set name in the parent Text.
     * @param parent String
     */
    @Override
    public void setParent(final String parent) {
//        parentAccount.click();
//        WebElement itemToSelect = wait.until(ExpectedConditions.
//                visibilityOfElementLocated(By.xpath("//div[@title='" + parent + "']")));
//        itemToSelect.click();
    }

    /**
     * Set name in the phone Text.
     * @param phone String
     */
    @Override
    public void setPhone(final String phone) {
        phoneAccount.sendKeys(phone);
    }

    /**
     * Set name in the fax Text.
     * @param fax String
     */
    @Override
    public void setFax(final String fax) {
        faxAccount.sendKeys(fax);
    }

    /**
     * Set name in the numberAccount Text.
     * @param number String
     */
    @Override
    public void setNumberAccount(final String number) {
        numberAccount.sendKeys(number);
    }

    /**
     * Set name in the webSite Text.
     * @param webSite String
     */
    @Override
    public void setWebSite(final String webSite) {
        webSiteAccount.sendKeys(webSite);
    }

    /**
     * Set name in the ticker Text.
     * @param ticker String
     */
    @Override
    public void setTicker(final String ticker) {
        tickerAccount.sendKeys(ticker);
    }

    /**
     * Set name in the site Text.
     * @param site String
     */
    @Override
    public void setSite(final String site) {
        siteAccount.sendKeys(site);
    }

    /**
     * Set name in the type Text.
     * @param type String
     */
    @Override
    public void setType(final String type) {
//        typeAccountCmb.click();
//        driver.findElement(By.xpath("//a[@title=\"" + type + "\"]")).click();
    }

    /**
     * Set name in the ownership Element.
     * @param ownership String
     */
    @Override
    public void setOwnership(final String ownership) {
//        ownershipAccountCmb.click();
//        driver.findElement(By.xpath("//a[@title=\"" + ownership + "\"]")).click();
    }

    /**
     * Set name in the industry Element.
     * @param industry String
     */
    @Override
    public void setIndustry(final String industry) {
//        industryAccountCmb.click();
//        driver.findElement(By.xpath("//a[@title=\"" + industry + "\"]")).click();
    }

    /**
     * Set name in the employee Text.
     * @param employee String
     */
    @Override
    public void setEmployee(final String employee) {
        employeeAccount.sendKeys(employee);
    }

    /**
     * Set name in the anualRevenue Text.
     * @param anualRevenue String
     */
    @Override
    public void setAnualRevenue(final String anualRevenue) {
        annualAccount.sendKeys(anualRevenue);
    }

    /**
     * Set name in the sicCode Text.
     * @param sicCode String
     */
    @Override
    public void setSicCode(final String sicCode) {
        sicCodeAccount.sendKeys(sicCode);
    }

    /**
     * Set name in the billingStreet Text.
     * @param billingStreet String
     */
    @Override
    public void setBillingStreet(final String billingStreet) {
        billingStreetAccount.sendKeys(billingStreet);
    }

    /**
     * Set name in the shippingStreet Text.
     * @param shippingStreet String
     */
    @Override
    public void setShippingStreet(final String shippingStreet) {
        shippingStreetAccount.sendKeys(shippingStreet);
    }

    /**
     * Set name in the billingCity Text.
     * @param billingCity String
     */
    @Override
    public void setBillingCity(final String billingCity) {
        billingCityAccount.sendKeys(billingCity);
    }

    /**
     * Set name in the billingState Text.
     * @param billingState String
     */
    @Override
    public void setBillingState(final String billingState) {
        billingStateAccount.sendKeys(billingState);
    }

    /**
     * Set name in the shippingCity Text.
     * @param shippingCity String
     */
    @Override
    public void setShippingCity(final String shippingCity) {
        shippingCityAccount.sendKeys(shippingCity);
    }

    /**
     * Set name in the shippingState Text.
     * @param shippingState String
     */
    @Override
    public void setShippingState(final String shippingState) {
        shippingCityAccount.sendKeys(shippingState);
    }

    /**
     * Set name in the billingZip Text.
     * @param billingZip String
     */
    @Override
    public void setBillingZip(final String billingZip) {
        billingZipAccount.sendKeys(billingZip);
    }

    /**
     * Set name in the billingCountry Text.
     * @param billingCountry String
     */
    @Override
    public void setBillingCountry(final String billingCountry) {
        billingCountryAccount.sendKeys(billingCountry);
    }

    /**
     * Set name in the shippingZip Text.
     * @param shippingZip String
     */
    @Override
    public void setShippingZip(final String shippingZip) {
        shippingZipAccount.sendKeys(shippingZip);
    }

    /**
     * Set name in the shippingCountry Text.
     * @param shippingCountry String
     */
    @Override
    public void setShippingCountry(final String shippingCountry) {
        shippingCountryAccount.sendKeys(shippingCountry);
    }

    /**
     * Set name in the customerPriority Element.
     * @param customerPriority String
     */
    @Override
    public void setCustomerPriority(final String customerPriority) {
//        customerAccountCmb.click();
//        driver.findElement(By.xpath("//a[@title=\"" + customerPriority + "\"]")).click();
    }

    /**
     * Set name in the slaAccount Element.
     * @param slaAccount String
     */
    @Override
    public void setSlaAccount(final String slaAccount) {
//        slaStateAccountCmb.click();
//        driver.findElement(By.xpath("//a[@title=\"" + slaAccount + "\"]")).click();
    }

    /**
     * Set name in the slaDate Date.
     * @param slaDate String
     */
    @Override
    public void setSlaDate(final String slaDate) {
        slaDateAccount.sendKeys(slaDate);
    }

    /**
     * Set name in the slaSerial Text.
     * @param slaSerial String
     */
    @Override
    public void setSlaSerial(final String slaSerial) {
        slaSerialAccount.sendKeys(slaSerial);
    }

    /**
     * Set name in the numberLocations Text.
     * @param numberLocations String
     */
    @Override
    public void setNumberLocations(final String numberLocations) {
        numberLocationAccount.sendKeys(numberLocations);
    }

    /**
     * Set name in the upsellOportunity Element.
     * @param upsellOportunity String
     */
    @Override
    public void setUpsellOportunity(final String upsellOportunity) {
//        upsellStateAccountCmb.click();
//        driver.findElement(By.xpath("//a[@title=\"" + upsellOportunity + "\"]")).click();
    }

    /**
     * Set name in the active Element.
     * @param active String
     */
    @Override
    public void setActive(final String active) {
//        activeStateAccountCmb.click();
//        driver.findElement(By.xpath("//a[@title=\"" + active + "\"]")).click();
    }

    /**
     * Set name in the description Text.
     * @param description String
     */
    @Override
    public void setDescription(final String description) {
        descriptionAccount.sendKeys(description);
    }


    /**
     * Clicks to Save the changes.
     */
    public void clickSaveBtn() {
        saveBtn.click();
    }
}
