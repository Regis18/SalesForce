/*
 * @(#) OneCampaignAbstract.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.campaign.abstracts;

import salesforce.ui.BasePage;

/**
 * OneCampaignAbstract class.
 * @author Regis Humana
 * @version 0.0.1
 */
public abstract class OneCampaignAbstract extends BasePage {
    /**
     * VerifyComponentsCampaign.
     * @return boolean.
     */
    public abstract boolean verifyComponentsCampaign();

    /**
     * Get name to assert with steps.
     * @return String
     */
    public abstract String getNameCampaign();

    /**
     * Delete Campaign of Salesforce with specific name.
     * @param nameCampaign string
     * @return CampaignPageAbstract.
     */
    public abstract CampaignPageAbstract deleteCampaign(String nameCampaign);

    /**
     * Open Edit Campaign.
     * @return EditCampaignAbstract
     */
    public abstract EditCampaignAbstract openEditCampaign();

    /**
     * Check if the values of Campaign is correct in the list.
     * @param key String.
     * @param value Value.
     * @return Boolean
     */
    public abstract boolean isCampaignFieldValueDisplayed(String key, String value);

    /**
     * Click the button Campaign and redirected to CampaignPage.
     * @return CampaignPageAbstract.
     */
    public abstract CampaignPageAbstract openCampaignPage();
}
