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

package salesforce.ui.pages.abstracts.account;

import salesforce.ui.BasePage;

/**
 * OneAccountAbstract.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public abstract class OneAccountAbstract extends BasePage {

    /**
     * Implement verifyComponentsAccount.
     */
    public abstract boolean verifyComponentsAccount();

    /**
     * Implement get name to assert with steps.
     */
    public abstract String getNameAccount();
}
