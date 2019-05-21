/*
 * @(#) NewCampaignPopup.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Campaign;
import salesforce.ui.behaves.NewCampaignAbstract;

/**
 * NewCampaignPopup
 * @author Regis Humana
 */
public class NewCampaignPopup extends NewCampaignAbstract {
    /**
     * Popup the new campaign
     */
    @FindBy(css = "div[class=\"modal-container slds-modal__container\"]")
    private WebElement newCampaignPopup;
    /**
     * Campaign Name of the form
     */
    @FindBy(xpath = "//input[contains(@id,\"58:1383;a\")]")
    private WebElement nameTxt;
    /**
     * Save button
     */
    @FindBy(xpath = "//button[@title=\"Save\"]")
    private WebElement saveBtn;

    /**
     * Wait for the Popup to initialize
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newCampaignPopup));
    }

    /**
     * Set all of the values that is required for the new campaign
     * @param data
     */
    @Override
    public void setCampaignData(Campaign data) {
        setNameTxt(data.getName());
    }

    /**
     * Set the name into NameTxt
     * @param name
     */
    protected void setNameTxt(String name) {
        nameTxt.sendKeys(name);
    }

    /**
     * Click to Save the changes
     */
    public void clickSaveBtn() {
        saveBtn.click();
    }
}
