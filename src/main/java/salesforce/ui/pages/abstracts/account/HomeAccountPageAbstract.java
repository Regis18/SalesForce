/*
 * @(#) HomeAccountPageAbstract.java Copyright (c) 2019 Jala Foundation.
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
 * HomeAccountPageAbstract.
 * @author Luis Guardia
 * @version 0.0.1
 */
public abstract class HomeAccountPageAbstract extends BasePage {
    /**
     * Click in the button Campaign button.
     * @return account Page abstract.
     */
    public abstract AccountPageAbstract clickAccountBtn();
}
