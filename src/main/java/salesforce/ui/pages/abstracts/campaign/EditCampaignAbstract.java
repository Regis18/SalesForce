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

package salesforce.ui.pages.abstracts.campaign;

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

    private final String DESCRIPTION = "Description";
    private final String NAME = "Name";
    private final String ACTIVE = "Active";
    private final String TYPE = "Type";
    private final String STATUS = "Status";
    private final String START_DATE = "Star Date";
    private final String END_DATE = "End Date";
    private final String EXPECTED_REVENUE = "Expected Revenue";
    private final String BUDGETED_COST = "Budgeted Cost";
    private final String ACTUAL_COST = "Actual Cost";
    private final String EXPECTED_RESPONSE = "Expected Response";
    private final String NUM_SENT = "Num Sent";
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
        setCampaignData(data, mapOut, true);
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
     * Set Expected Response string.
     * @param expectedResponse string
     */
    protected abstract void setExpectedResponse(Integer expectedResponse);

    /**
     * Gets Name of Campaign.
     * @return string
     */
    protected abstract String getNameTxt();

    /**
     * Gets Active of Campaign.
     * @return boolean
     */
    protected abstract boolean getActivateChk();

    /**
     * Gets Type text.
     * @return string
     */
    protected abstract String getTypeCmb();

    /**
     * Gets Status text.
     * @return string.
     */
    protected abstract String getStatusCmb();

    /**
     * Gets Start Date text.
     * @return string
     */
    protected abstract String getStartDateTxt();

    /**
     * Gets End Date Text.
     * @return string.
     */
    protected abstract String getEndDateTxt();

    /**
     * Gets Expected Revenue text.
     * @return string.
     */
    protected abstract String getExpectedRevenueTxt();

    /**
     * Gets budgeted cost text.
     * @return string.
     */
    protected abstract String getBudgetedCostTxt();

    /**
     * Gets Actual Cost text.
     * @return string.
     */
    protected abstract String getActualCostTxt();

    /**
     * Gets Expected response text.
     * @return string
     */
    protected abstract String getExpectedResponseTxt();

    /**
     * Gets Num sent text.
     * @return string.
     */
    protected abstract String getNumSentTxt();

    /**
     * Gets Description text.
     * @return string.
     */
    protected abstract String getDescriptionTxt();

    /**
     * Set Campaign Data.
     * Just is name, can be more.
     *
     * @param data Campaign
     * @param map Map
     */
    public void setCampaignData(final Campaign data, final Map<String, String> map, boolean isSet) {
        if (isSet) {
            HashMap<String, StrategySetter> strategyMap = composeStrategyMap(data);
            map.keySet().forEach(key -> {
                strategyMap.get(key).executeMethod();
            });
        } else {
            HashMap<String, StrategySetter> strategyMap = composeCampaignFromEdit();
            map.keySet().forEach(key -> {
                strategyMap.get(key).executeMethod();
                System.out.println(key);
            });
        }
    }

    /**
     * Compose the values of Campaign.
     * @param data Campaign.
     * @return Hashmap
     */
    private HashMap<String, StrategySetter> composeStrategyMap(final Campaign data) {
        HashMap<String, StrategySetter> strategyMap = new HashMap<>();
        strategyMap.put(NAME, () -> setNameTxt(data.getName()));
        strategyMap.put(ACTIVE, () -> setActiveChk(data.isActivate()));
        strategyMap.put(TYPE, () -> setTypeCmb(data.getType()));
        strategyMap.put(STATUS, () -> setStatusCmb(data.getStatus()));
        strategyMap.put(START_DATE, () -> setStartDate(data.getStartDate()));
        strategyMap.put(END_DATE, () -> setEndDate(data.getEndDate()));
        strategyMap.put(EXPECTED_REVENUE, () -> setExpectedRevenueTxt(data.getExpectedRevenue()));
        strategyMap.put(BUDGETED_COST, () -> setBudgetedCostTxt(data.getBudgetedCost()));
        strategyMap.put(ACTUAL_COST, () -> setActualCostTxt(data.getActualCost()));
        strategyMap.put(EXPECTED_RESPONSE, () -> setExpectedResponse(data.getExpectedResponse()));
        strategyMap.put(NUM_SENT, () -> setNumSent(data.getNumSent()));
        strategyMap.put(DESCRIPTION, () -> setDescriptionTxt(data.getDescription()));
        return strategyMap;
    }

    /**
     * Get all of the values of the campaign that contains the Edit form.
     * @param mapOut mapOut.
     * @return Campaign.
     */
    public Campaign getCampaignValues(Map<String, String> mapOut) {
        setCampaignData(campaignValues, mapOut, false);
        return campaignValues;
    }

    /**
     * Compose the values of Campaign.
     * @return Hashmap
     */
    private HashMap<String, StrategySetter> composeCampaignFromEdit() {
        HashMap<String, StrategySetter> strategyMap = new HashMap<>();
        strategyMap.put(NAME, () -> campaignValues.setName(getNameTxt()));
        strategyMap.put(ACTIVE, () -> campaignValues.setActivate(getActivateChk()));
        strategyMap.put(TYPE, () -> campaignValues.setType(getTypeCmb()));
        strategyMap.put(STATUS, () -> campaignValues.setStatus(getStatusCmb()));
        strategyMap.put(START_DATE, () -> campaignValues.setStartDate(getStartDateTxt()));
        strategyMap.put(END_DATE, () -> campaignValues.setEndDate(getEndDateTxt()));
        strategyMap.put(EXPECTED_REVENUE, () -> campaignValues.setExpectedRevenue(Integer
                                                .parseInt(getExpectedRevenueTxt())));
        strategyMap.put(BUDGETED_COST, () -> campaignValues.setBudgetedCost(Integer.parseInt(getBudgetedCostTxt())));
        strategyMap.put(ACTUAL_COST, () -> campaignValues.setActualCost(Integer.parseInt(getActualCostTxt())));
        strategyMap.put(EXPECTED_RESPONSE, () -> campaignValues.setExpectedResponse(Integer
                                                .parseInt(getExpectedResponseTxt())));
        strategyMap.put(NUM_SENT, () -> campaignValues.setNumSent(Integer.parseInt(getNumSentTxt())));
        strategyMap.put(DESCRIPTION, () -> campaignValues.setDescription(getDescriptionTxt()));
        return strategyMap;
    }
}
