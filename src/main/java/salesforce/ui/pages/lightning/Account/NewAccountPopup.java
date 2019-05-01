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

package salesforce.ui.pages.lightning.Account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Campaign;
import salesforce.ui.pages.abstracts.Account.NewAccountPageAbstract;

/**
 * NewAccountPopup.
 * @author Luis Guardia.
 */
public class NewAccountPopup extends NewAccountPageAbstract {

    @FindBy(xpath = "//div[@class=\"uiInput witsSuggestedNameField uiInput--default\"]//input[@class=\"input uiInput uiInputText uiInput--default uiInput--input\"]")
    private WebElement nameTxt;

    @FindBy(xpath = "//button[@class=\"slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton\"]")
    private WebElement saveBtn;
    /**
     * Wait for the Popup to initialize.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameTxt));
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
     * Set the name into NameTxt.
     * @param name **this is the name**
     */
    protected void setNameTxt(final String name) {
        nameTxt.sendKeys(name);
    }

    /**
     * Click to Save the changes.
     */
    public void clickSaveBtn() {
        saveBtn.click();
    }
}
