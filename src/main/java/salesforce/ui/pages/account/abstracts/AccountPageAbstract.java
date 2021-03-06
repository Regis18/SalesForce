/*
 * @(#) AccountPageAbstract.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.account.abstracts;

import salesforce.ui.BasePage;

/**
 * AccountPageAbstract.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public abstract class AccountPageAbstract extends BasePage {

    /**
     * Click in New Account button.
     * @return clickNewAccountBtn.
     */
    public abstract NewAccountPageAbstract clickNewAccountBtn();

    /**
     * Implement: check the account list.
     * @param name string.
     * @return boolean.
     */
    public abstract boolean checkAccountList(String name);

    /**
     * Select Account of Salesforce.
     * @param name String
     * @return selectAccount.
     */
    public abstract OneAccountAbstract selectAccount(String name);
}
