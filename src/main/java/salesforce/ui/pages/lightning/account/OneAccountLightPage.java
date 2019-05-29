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

package salesforce.ui.pages.lightning.account;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.abstracts.account.OneAccountAbstract;

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
        return messageConfirmation.getText();
    }

    /**
     * Click to detailsTab.
     */
    private void clickDetailsTab() {
        detailsTab.click();
    }
}
