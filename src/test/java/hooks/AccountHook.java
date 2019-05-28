/*
 * @(#) AccountHook.java Copyright (c) 2019 Jala Foundation.
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

package hooks;

import core.selenium.WebDriverManager;
import core.utils.Logs;
import cucumber.api.java.After;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import salesforce.api.AccountApi;
import salesforce.entities.Account;

public class AccountHook {
    private Logger logs = Logs.getInstance().getLog();
    private WebDriver driver;
    Account account;

    /**
     * Constructor to initialize context and driver.
     * @param account
     */
    public AccountHook(Account account) {
        this.account = account;
        driver = WebDriverManager.getInstance().getWebDriver();
    }

    /**
     * Delete an Account.
     */
    @After("@deleteAccount")
    public void deleteNewAccount() {
        AccountApi accountApi = new AccountApi();
        accountApi.deleteAccount(account.getId());
    }
}
