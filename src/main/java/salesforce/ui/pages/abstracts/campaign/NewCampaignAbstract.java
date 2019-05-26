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

package salesforce.ui.pages.abstracts.campaign;

import salesforce.entities.Campaign;
import salesforce.ui.BasePage;
import salesforce.ui.PageFactory;

import java.util.Date;

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
     * Set Active checkbox.
     * @param isActivate boolean
     */
    protected abstract void setActiveChk(boolean isActivate);

    /**
     * Set Type of the campaign.
     * @param type string.
     */
    protected abstract void setTypeCmb(String type);

    /**
     * Set Status combo box.
     * @param status string.
     */
    protected abstract void setStatusCmb(String status);

    /**
     * Set Start Date.
     * @param startDate string.
     */
    protected abstract void setStartDate(String startDate);

    /**
     * Set End Date.
     * @param endDate string.
     */
    protected abstract void setEndDate(String endDate);

    /**
     * Set Expected Revenue text.
     * @param expected integer.
     */
    protected abstract void setExpectedRevenueTxt(Integer expected);

    /**
     * Set Budgeted cost.
     * @param budgeted integer.
     */
    protected abstract void setBudgetedCostTxt(Integer budgeted);

    /**
     * Set actual Cost text box.
     * @param actualCost integer.
     */
    protected abstract void setActualCostTxt(Integer actualCost);

    /**
     * Set num sent text box.
     * @param numSent integer.
     */
    protected abstract void setNumSent(Integer numSent);

    /**
     * Set Description text box.
     * @param description string.
     */
    protected abstract void setDescriptionTxt(String description);

    /**
     * Set Campaign Data.
     * Just is name, can be more.
     *
     * @param data Campaign
     */
    public void setCampaignData(Campaign data) {
        setNameTxt(data.getName());
        setActiveChk(data.isActivate());
        setTypeCmb(data.getType());
        setStatusCmb(data.getStatus());
        setStartDate(data.getStartDate());
        setEndDate(data.getEndDate());
        setExpectedRevenueTxt(data.getExpectedRevenue());
        setBudgetedCostTxt(data.getBudgetedCost());
        setActualCostTxt(data.getActualCost());
        setNumSent(data.getNumSent());
        setDescriptionTxt(data.getDescription());
    }
}
