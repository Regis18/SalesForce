/*
 * @(#) NewCampaignAbstract.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.behaves;

import salesforce.entities.Campaign;
import salesforce.ui.BasePage;

/**
 * NewCampaignAbstract
 * @author Regis Humana
 */
public abstract class NewCampaignAbstract extends BasePage {
    /**
     * Create a new campaign, it create for classic and lightning pages
     * @param data
     */
    public void createNewCampaign(Campaign data) {
        setCampaignData(data);
        clickSaveBtn();
    }
    /**
     * Click in Save button
     */
    protected abstract void clickSaveBtn();

    /**
     * Set name of campaign
     */
    protected abstract void setNameTxt(String name);

    /**
     * Set Campaign Data
     * Just is name, can be more
     * @param data
     */
    protected abstract void setCampaignData(Campaign data);
}
