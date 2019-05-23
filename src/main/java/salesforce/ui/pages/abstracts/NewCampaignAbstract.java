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

package salesforce.ui.pages.abstracts;

import salesforce.entities.Campaign;
import salesforce.ui.BasePage;
import salesforce.ui.PageFactory;

/**
 * NewCampaignAbstract.
 * @author Regis Humana
 */
public abstract class NewCampaignAbstract extends BasePage {

    /**
     * Create a new campaign, it create for classic and lightning pages.
     *
     * @param data Campaign.
     */
    public OneCampaignAbstract createNewCampaign(final Campaign data) {
        setCampaignData(data);
        clickSaveBtn();
        return PageFactory.oneCampaignPage();
    }

    /**
     * Click in Save button.
     */
    protected abstract void clickSaveBtn();

    /**
     * Set name of campaign.
     *
     * @param name String
     */
    protected abstract void setNameTxt(String name);

    /**
     * Set Campaign Data.
     * Just is name, can be more.
     *
     * @param data Campaign
     */
    protected abstract void setCampaignData(Campaign data);
}
