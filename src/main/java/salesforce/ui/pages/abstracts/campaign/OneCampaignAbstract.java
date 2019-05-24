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

package salesforce.ui.pages.abstracts.campaign;

import salesforce.ui.BasePage;

/**
 * OneCampaignAbstract class.
 * @author Regis Humana
 */
public abstract class OneCampaignAbstract extends BasePage {
    /**
     * Implement verifyComponentsCampaign.
     */
    public abstract boolean verifyComponentsCampaign();

    /**
     * Implement get name to assert with steps.
     */
    public abstract String getNameCampaign();

    /**
     * Delete Campaign of Salesforce
     */
    public abstract void deleteCampaign();
}
