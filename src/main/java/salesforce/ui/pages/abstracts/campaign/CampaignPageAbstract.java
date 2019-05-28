/*
 * @(#) CampaignPageAbstract.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.abstracts.campaign;

import salesforce.ui.BasePage;

/**
 * CampaignPageAbstract.
 * @author Regis Humana.
 * @version 0.0.1
 */
public abstract class CampaignPageAbstract extends BasePage {

    /**
     * Click in NewCampaign button.
     * @return clickNewCampaignBtn.
     */
    public abstract NewCampaignAbstract clickNewCampaignBtn();

    /**
     * Check the campaign list.
     * @param name string.
     * @return boolean.
     */
    public abstract boolean checkCampaignList(final String name);

    /**
     * Delete the campaign from the list of campaigns.
     * @param id string.
     */
    public abstract void deleteCampaign(final String id);
}
