/*
 * @(#) OneAccountClassicPage.java Copyright (c) 2019 Jala Foundation.
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
import salesforce.ui.pages.abstracts.account.OneAccountAbstract;

public class OneAccountClassicPage extends OneAccountAbstract {

    @FindBy(xpath = "//td[@class=\" oRight\"]")
    private WebElement accountDetailForm;
    @FindBy(xpath = "//h1[@class=\"pageType\"]")
    private WebElement accountPanelTitle;
    @FindBy(xpath = "//h2[@class=\"topName\"]")
    private WebElement accountTitleLbl;

    /**
     * Wait for Account panel title.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountPanelTitle));
    }

    /**
     * Verify if the components of the Account exist.
     * @return boolean
     */
    @Override
    public boolean verifyComponentsAccount() {
        return accountDetailForm.isDisplayed();
    }

    /**
     * Get the Name Account.
     * @return string
     */
    @Override
    public String getNameAccount() {
        return accountTitleLbl.getText();
    }

    /**
     * Delete account
     * @param nameAccount string
     */
    @Override
    public void deleteAccount(String nameAccount) {
    }

    /**
     * Get id account
     * @return idAccount string.
     */
    @Override
    public String getAccountId() {
        String currentUrl = driver.getCurrentUrl();
        String[] arrayIdAccount = currentUrl.split("/");
        String idAccount = arrayIdAccount[arrayIdAccount.length-1];
        return idAccount;
    }
}
