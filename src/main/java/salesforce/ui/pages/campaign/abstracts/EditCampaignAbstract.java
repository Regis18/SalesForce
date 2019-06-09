/*
 * @(#) EditCampaignAbstract.java Copyright (c) 2019 Jala Foundation.
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

import core.utils.StrategySetter;
import salesforce.entities.Campaign;
import salesforce.ui.BasePage;
import salesforce.ui.PageFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * EditCampaignAbstract.
 * @author Regis Humana
 * @version 0.0.1
 */
public abstract class EditCampaignAbstract extends BasePage {

    private final String descriptionTag = "Description";
    private final String nameTag = "Name";
    private final String activeTag = "IsActive";
    private final String typeTag = "Type";
    private final String statusTag = "Status";
    private final String startDateTag = "StartDate";
    private final String endDateTag = "EndDate";
    private final String expectedRevenueTag = "ExpectedRevenue";
    private final String budgetedCostTag = "BudgetedCost";
    private final String actualCostTag = "ActualCost";
    private final String expectedResponseTag = "ExpectedResponse";
    private final String numberSentTag = "NumberSent";
    private Campaign campaignValues;

    /**
     * Initializes the campaign.
     */
    public EditCampaignAbstract() {
        campaignValues = new Campaign();
    }

    /**
     * Edit a new campaign, it create for classic and lightning pages.
     *
     * @param data Campaign.
     * @param mapOut Map.
     * @return OneCampaignAbstract.
     */
    public OneCampaignAbstract createNewCampaign(final Campaign data, final Map mapOut) {
        setCampaignData(data, mapOut);
        clickSaveBtn();
        return PageFactory.getOneCampaignPage();
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
    protected abstract void setNameTxt(final String name);

    /**
     * Set Active checkbox.
     * @param isActivate boolean
     */
    protected abstract void setActiveChk(final boolean isActivate);

    /**
     * Set Type of the campaign.
     * @param type string.
     */
    protected abstract void setTypeCmb(final String type);

    /**
     * Set Status combo box.
     * @param status string.
     */
    protected abstract void setStatusCmb(final String status);

    /**
     * Set Start Date.
     * @param startDate string.
     */
    protected abstract void setStartDate(final String startDate);

    /**
     * Set End Date.
     * @param endDate string.
     */
    protected abstract void setEndDate(final String endDate);

    /**
     * Set Expected Revenue text.
     * @param expected integer.
     */
    protected abstract void setExpectedRevenueTxt(final Integer expected);

    /**
     * Set Budgeted cost.
     * @param budgeted integer.
     */
    protected abstract void setBudgetedCostTxt(final Integer budgeted);

    /**
     * Set actual Cost text box.
     * @param actualCost integer.
     */
    protected abstract void setActualCostTxt(final Integer actualCost);

    /**
     * Set num sent text box.
     * @param numSent integer.
     */
    protected abstract void setNumSent(final Integer numSent);

    /**
     * Set Description text box.
     * @param description string.
     */
    protected abstract void setDescriptionTxt(final String description);

    /**
     * Set Expected Response string.
     * @param expectedResponse string
     */
    protected abstract void setExpectedResponse(final Integer expectedResponse);

    /**
     * Set Campaign Data.
     * Just is name, can be more.
     *
     * @param data Campaign
     * @param map Map
     */
    public void setCampaignData(final Campaign data, final Map<String, String> map) {
        HashMap<String, StrategySetter> strategyMap = composeStrategyMap(data);
        map.keySet().forEach(key -> {
            strategyMap.get(key).executeMethod();
        });
    }

    /**
     * Compose the values of Campaign.
     * @param data Campaign.
     * @return Hashmap
     */
    private HashMap<String, StrategySetter> composeStrategyMap(final Campaign data) {
        HashMap<String, StrategySetter> strategyMap = new HashMap<>();
        strategyMap.put(nameTag, () -> setNameTxt(data.getName()));
        strategyMap.put(activeTag, () -> setActiveChk(data.isActivate()));
        strategyMap.put(typeTag, () -> setTypeCmb(data.getType()));
        strategyMap.put(statusTag, () -> setStatusCmb(data.getStatus()));
        strategyMap.put(startDateTag, () -> setStartDate(data.getStartDate()));
        strategyMap.put(endDateTag, () -> setEndDate(data.getEndDate()));
        strategyMap.put(expectedRevenueTag, () -> setExpectedRevenueTxt(data.getExpectedRevenue()));
        strategyMap.put(budgetedCostTag, () -> setBudgetedCostTxt(data.getBudgetedCost()));
        strategyMap.put(actualCostTag, () -> setActualCostTxt(data.getActualCost()));
        strategyMap.put(expectedResponseTag, () -> setExpectedResponse(data.getExpectedResponse()));
        strategyMap.put(numberSentTag, () -> setNumSent(data.getNumSent()));
        strategyMap.put(descriptionTag, () -> setDescriptionTxt(data.getDescription()));
        return strategyMap;
    }
}
