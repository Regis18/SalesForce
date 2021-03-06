/*
 * @(#) OneAccountAbstract.java Copyright (c) 2019 Jala Foundation.
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

import java.util.Map;

/**
 * OneAccountAbstract.
 * @author Luis Guardia.
 * @version 0.0.1
 *
 */
public abstract class OneAccountAbstract extends BasePage {

    /**
     * Implement isDisplayedDetailsPage.
     * @return true component
     */
    public abstract boolean isDisplayedDetailsPage();

    /**
     * Implement verifyComponentsAccount.
     * @return true component
     */
    public abstract boolean verifyComponentsAccount();

    /**
     * Implement get name to assert with steps.
     * @return name Account
     */
    public abstract String getNameAccount();

    /**
     * Delete Account of Salesforce.
     */
    public abstract void deleteAccount();

    /**
     * Edit an Account of Salesforce.
     * @return EditAccountAbstract page
     */
    public abstract EditAccountAbstract editAccount();

    /**
     * Delete Account of Salesforce with specific name.
     */
    public abstract Map<String, String> createHasMapAccount(Map<String, String> accountInformation);
}
