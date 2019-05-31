/*
 * @(#) AccountClassicPage.java Copyright (c) 2019 Jala Foundation.
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
import salesforce.ui.pages.account.abstracts.AccountPageAbstract;
import salesforce.utils.DriverMethods;

/**
 * AccountClassicPage.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public class AccountClassicPage extends AccountPageAbstract {
    private String accountList = "//tr[@onmouseout=\"if (window.hiOff){hiOff(this);}\"]//a[contains(text(),\"account\")]";

    /**
     * AccountForm.
     */
    @FindBy(xpath = "//li[@id='Account_Tab']")
    private WebElement accountForm;

    /**
     * Button: New Account.
     */
    @FindBy(xpath = "//input[@name=\"new\"]")
    private WebElement newAccountBtn;

    /**
     * Wait for Account Form.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountForm));
    }

    /**
     * Click in to New Account button and initialize NewAccountClassicPage.
     * @return NewAccountClassicPage.
     */
    @Override
    public NewAccountClassicPage clickNewAccountBtn() {
        newAccountBtn.click();
        return new NewAccountClassicPage();
    }

    /**
     * Check the account name in the list.
     * @param name string.
     * @return boolean.
     */
    @Override
    public boolean checkAccountList(final String name) {
        return DriverMethods.isElementPresent(By.xpath(accountList.replace("account", name)));
    }
}

