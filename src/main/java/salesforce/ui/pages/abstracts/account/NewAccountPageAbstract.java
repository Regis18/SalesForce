/*
 * @(#) NewAccountPageAbstract.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.abstracts.account;

import salesforce.ui.BasePage;
import salesforce.ui.PageFactory;

/**
 * NewAccountPageAbstract.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public abstract class NewAccountPageAbstract extends BasePage {
    /**
     * Create a new account, it create for classic and lightning pages.
     *
     * @param data String.
     */
    public OneAccountAbstract createNewAccount(final String data) {
        setAccountData(data);
        clickSaveBtn();
        return PageFactory.oneAccountPage();
    }

    /**
     * Click in Save button.
     */
    protected abstract void clickSaveBtn();

    /**
     * Set name of account.
     *
     * @param name String
     */
    protected abstract void setNameTxt(String name);

    /**
     * Set account Data.
     * Just is name, can be more.
     *
     * @param data Campaign
     */
    protected abstract void setAccountData(String data);
}
