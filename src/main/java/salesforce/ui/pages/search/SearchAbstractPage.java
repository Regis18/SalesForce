/*
 * @(#) SearchAbstractPage.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.search;

import salesforce.ui.BasePage;
import salesforce.ui.pages.campaign.abstracts.OneCampaignAbstract;

/**
 * SearchAbstractPage.
 * @author Regis Humana.
 * @version 0.0.1
 */
public abstract class SearchAbstractPage extends BasePage {
    /**
     * Verify that the element that was searched exist in the list.
     * @param key string.
     * @param element string.
     * @return boolean
     */
    public abstract boolean doesElementExist(String key, String element);

    /**
     * Access to the element that was searched.
     * @param key string.
     * @param element string.
     * @return BasePage.
     */
    public abstract OneCampaignAbstract accessToElementSearched(String key, String element);
}
