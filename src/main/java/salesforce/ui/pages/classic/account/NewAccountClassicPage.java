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
import salesforce.ui.pages.abstracts.account.NewAccountPageAbstract;

public class NewAccountClassicPage extends NewAccountPageAbstract {

    @FindBy(xpath = "id = \"bodyCell\"")
    private WebElement newAccountForm;

    @FindBy(xpath = "//input[@id=\"cpn1\"]")
    private WebElement nameAccountTxt;

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
     * Set name in the name TextBox.
     * @param name String
     */
    @Override
    protected void setNameTxt(final String name) {
        nameAccountTxt.sendKeys(name);
    }

    @Override
    public void setPhone(String phone) { nameAccountTxt.sendKeys(phone); }

    @Override
    public void setRating(String rating) { nameAccountTxt.sendKeys(rating); }

    @Override
    public void setParent(String parent) { nameAccountTxt.sendKeys(parent); }
    @Override
    public void setFax(String fax) { nameAccountTxt.sendKeys(fax); }
    @Override
    public void setNumberAccount(String numberAccount) { nameAccountTxt.sendKeys(numberAccount); }
    @Override
    public void setWebSite(String webSite) { nameAccountTxt.sendKeys(webSite); }
    @Override
    public void setSite(String site) { nameAccountTxt.sendKeys(site); }
    @Override
    public void setTicker(String ticker) { nameAccountTxt.sendKeys(ticker); }
    @Override
    public void setType(String type) { nameAccountTxt.sendKeys(type); }
    @Override
    public void setOwnership(String ownership) { nameAccountTxt.sendKeys(ownership); }
    @Override
    public void setIndustry(String industry) { nameAccountTxt.sendKeys(industry); }
    @Override
    public void setEmployee(String employee) { nameAccountTxt.sendKeys(employee); }
    @Override
    public void setAnualRevenue(String anualRevenue) { nameAccountTxt.sendKeys(anualRevenue); }
    @Override
    public void setSicCode(String sicCode) { nameAccountTxt.sendKeys(sicCode); }
    @Override
    public void setBillingStreet(String billingStreet) { nameAccountTxt.sendKeys(billingStreet); }
    @Override
    public void setShippingStreet(String shippingStreet) { nameAccountTxt.sendKeys(shippingStreet); }
    @Override
    public void setBillingCity(String billingCity) { nameAccountTxt.sendKeys(billingCity); }
    @Override
    public void setBillingState(String billingState) { nameAccountTxt.sendKeys(billingState); }
    @Override
    public void setShippingCity(String shippingCity) { nameAccountTxt.sendKeys(shippingCity); }
    @Override
    public void setShippingState(String shippingState) { nameAccountTxt.sendKeys(shippingState); }
    @Override
    public void setBillingZip(String billingZip) { nameAccountTxt.sendKeys(billingZip); }
    @Override
    public void setBillingCountry(String billingCountry) { nameAccountTxt.sendKeys(billingCountry); }
    @Override
    public void setShippingZip(String shippingZip) { nameAccountTxt.sendKeys(shippingZip); }
    @Override
    public void setShippingCountry(String shippingCountry) { nameAccountTxt.sendKeys(shippingCountry); }
    @Override
    public void setCustomerPriority(String customerPriority) { nameAccountTxt.sendKeys(customerPriority); }
    @Override
    public void setSlaAccount(String slaAccount) { nameAccountTxt.sendKeys(slaAccount); }
    @Override
    public void setSlaDate(String slaDate) { nameAccountTxt.sendKeys(slaDate); }
    @Override
    public void setSlaSerial(String slaSerial) { nameAccountTxt.sendKeys(slaSerial); }
    @Override
    public void setNumberLocations(String numberLocations) { nameAccountTxt.sendKeys(numberLocations); }
    @Override
    public void setUpsellOportunity(String upsellOportunity) { nameAccountTxt.sendKeys(upsellOportunity); }
    @Override
    public void setActive(String active) { nameAccountTxt.sendKeys(active); }
    @Override
    public void setDescription(String description) { nameAccountTxt.sendKeys(description); }

    /**
     * Click to Save the changes.
     */
    public void clickSaveBtn() {
        saveAccountBtn.click();
    }
}
