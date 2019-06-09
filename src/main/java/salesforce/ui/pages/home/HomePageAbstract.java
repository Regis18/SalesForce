/*
 * @(#) HomePageAbstract.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.home;

import salesforce.ui.BasePage;


import salesforce.ui.pages.task.abstracts.NewTaskAbstract;
import salesforce.ui.pages.account.abstracts.AccountPageAbstract;
import salesforce.ui.pages.campaign.abstracts.CampaignPageAbstract;

/**
 * HomePageAbstract.
 * @author Regis Humana
 * @version 0.0.1
 */
public abstract class HomePageAbstract extends BasePage {

    /**
     * Click in the button Campaign button.
     * @return Campaign Page abstract.
     */
    public abstract CampaignPageAbstract clickCampaignBtn();

    /**
     * This method will implemented for display a created task.
     * @return NewTaskAbstract.
     */
    public abstract NewTaskAbstract displayCreateTask();

    /**
     * Click in the button Account button.
     * @return Account Page abstract.
     */
    public abstract AccountPageAbstract clickAccountBtn();
}
