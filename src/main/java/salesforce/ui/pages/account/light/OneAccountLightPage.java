/*
 * @(#) OneAccountLightPage.java Copyright (c) 2019 Jala Foundation.
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
import salesforce.ui.pages.account.abstracts.OneAccountAbstract;

import java.util.HashMap;
import java.util.Map;

/**
 * OneAccountLightPage.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public class OneAccountLightPage extends OneAccountAbstract {

    @FindBy(xpath = "//div[@class=\"windowViewMode-normal oneContent active lafPageHost\"]//div[@class=\"row region-header\"]")
    private WebElement accountPanelTitle;

    @FindBy(xpath = "//span[contains(@class, \"forceActionsText\")]")
    private WebElement messageConfirmation;

    @FindBy(xpath = "//div[contains(@class,\"OutputName\")]//span[contains(@class,\"OutputText\")]")
    private WebElement accountTitleLbl;

    @FindBy(xpath = "//a[@title=\"Details\" ]//span[@class=\"title\"]")
    private WebElement detailsTab;

    @FindBy(xpath = "//div[@data-component-id=\"flexipage_tabset\"]//section[contains(@class,\"active uiTab\")]")
    private WebElement detailsForm;

    @FindBy(xpath = "//div[starts-with(@class,'branding-actions ')]//child::li[6]//a")
    private WebElement deleteElementCmbBtn;

    @FindBy(xpath = "//button[@title=\"Delete\"]")
    private WebElement deleteBtn;

    @FindBy(xpath = "//ul[contains(@class,'slds-button-group slds-m-left--xx-small o')]"
            + "//div[@data-aura-class='uiPopupTrigger']//a")
    private WebElement mainMenuCmb;


    ///////*********************Locators light**********************//////
    //@FindBy(css = "span[data-aura-rendered-by^='91:']")
    @FindBy(css = "[data-aura-rendered-by^=\"99\"] [class=\"uiOutputText\"]")
    private WebElement nameAccountLbl;

    @FindBy(css = "a[id^='142']")
    private WebElement parentAccountLbl;


//[data-aura-rendered-by^="205"] [class="uiOutputText"]

    //[data-aura-rendered-by^="248"] [class="uiOutputText"]


    @FindBy(css = "[data-aura-rendered-by^=\"118\"] [class=\"uiOutputPhone\"]")
    private WebElement phoneAccountLbl;



    ///////************************************************************//////

    public Map<String, String> createHasMapAccount() {
        Map<String,String> mapLight= new HashMap<String, String>();
        mapLight.put("Name", nameAccountLbl.getText());
        mapLight.put("Name", nameAccountLbl.getText());
        mapLight.put("Name", nameAccountLbl.getText());
        mapLight.put("Name", nameAccountLbl.getText());
        mapLight.put("Name", phoneAccountLbl.getText());
        mapLight.put("Name", nameAccountLbl.getText());
        return mapLight;
    }

    /**
     * Wait for account Panel Title.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountPanelTitle));
    }

    /**
     * Verify the components of the account.
     * @return
     */
    @Override
    public boolean verifyComponentsAccount() {
        return detailsForm.isDisplayed();
    }

    /**
     * Implement isDisplayedDetailsPage.
     * @return true component
     */
    @Override
    public boolean isDisplayedDetailsPage() {
        clickDetailsTab();
        return detailsForm.isDisplayed();
    }

    /**
     * Get the name of the account title.
     * @return name string.
     */
    @Override
    public String getNameAccount() {
        return accountTitleLbl.getText();
    }

    /**
     * Get the message confirmation.
     * @return message string.
     */
    public String getMessageConfirmation() {
        wait.until(ExpectedConditions.visibilityOf(messageConfirmation));
        return messageConfirmation.getText();
    }

    /**
     * Click to detailsTab.
     */
    private void clickDetailsTab() {
        detailsTab.click();
    }

    /**
     * Delete account.
     */
    @Override
    public void deleteAccount() {
        mainMenuCmb.click();
        deleteElementCmbBtn.click();
        deleteBtn.click();
    }
}
