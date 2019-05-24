package salesforce.entities;

import core.utils.StrategySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * Campaign.
 * @author Regis Humana.
 * @version 0.0.1
 */
public class Campaign {
    private String name;
    private boolean activate;
    private String type;
    private String status;
    private String startDate;
    private String endDate;
    private int expectedRevenue;
    private int budgetedCost;
    private int actualCost;
    private int expectedResponse;
    private int numSent;
    private String parentCampaign;
    private String description;
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

    /**
     * Get Campaign name.
     * @param name String
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Get Campaign name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get Campaign boolean activate.
     * @return activate
     */
    public boolean isActivate() {
        return activate;
    }

    /**
     * Set boolean activate.
     * @param activate *
     */
    public void setActivate(final boolean activate) {
        this.activate = activate;
    }

    /**
     * Get Campaign type.
     * @return type.
     */
    public String getType() {
        return type;
    }

    /**
     * Set Campaign type.
     * @param type *
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Get Campaign status.
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set Campaign status.
     * @param status *
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Get start date.
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Set start Date.
     * @param startDate *
     */
    public void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    /**
     * Get end date.
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Set end Date.
     * @param endDate *
     */
    public void setEndDate(final String endDate) {
        this.endDate = endDate;
    }

    /**
     * Get expected revenue.
     * @return expectedRevenue
     */
    public int getExpectedRevenue() {
        return expectedRevenue;
    }

    /**
     * Set expected revenue.
     * @param expectedRevenue *
     */
    public void setExpectedRevenue(final int expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    /**
     * Get budgeted cost.
     * @return budgetedCost
     */
    public int getBudgetedCost() {
        return budgetedCost;
    }

    /**
     * Set budget Cost.
     * @param budgetedCost **
     */
    public void setBudgetedCost(final int budgetedCost) {
        this.budgetedCost = budgetedCost;
    }

    /**
     * Get actual cost.
     * @return actualCost
     */
    public int getActualCost() {
        return actualCost;
    }

    /**
     * Set actual cost.
     * @param actualCost **
     */
    public void setActualCost(final int actualCost) {
        this.actualCost = actualCost;
    }

    /**
     * Get expected response.
     * @return expectedResponse
     */
    public int getExpectedResponse() {
        return expectedResponse;
    }

    /**
     * Set expected response.
     * @param expectedResponse **
     */
    public void setExpectedResponse(final int expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    /**
     * Get Num Sent.
     * @return  numSent
     */
    public int getNumSent() {
        return numSent;
    }

    /**
     * Set num sent.
     * @param numSent **
     */
    public void setNumSent(final int numSent) {
        this.numSent = numSent;
    }

    /**
     * Get parent campaign.
     * @return parentCampaign
     */
    public String getParentCampaign() {
        return parentCampaign;
    }

    /**
     * Set parent campaign.
     * @param parentCampaign **String**
     */
    public void setParentCampaign(final String parentCampaign) {
        this.parentCampaign = parentCampaign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @param campaigns
     */
    public void processInformation(final Map<String, String> campaigns) {
        HashMap<String, StrategySetter> strategyMap = composeStrategyMap(campaigns);
        campaigns.keySet().forEach(key -> {
            strategyMap.get(key).executedMethod();
            System.out.println(key);
        });
    }

    /**
     * Compose the values of Campaign
     * @param campaigns String
     * @return hashmap
     */
    private HashMap<String, StrategySetter> composeStrategyMap(final Map<String, String> campaigns) {
        HashMap<String, StrategySetter> strategyMap = new HashMap<>();
        strategyMap.put(NAME, () -> setName(campaigns.get(NAME)));
        strategyMap.put(ACTIVE, () -> setActivate(campaigns.get(ACTIVE).equals("True")));
        strategyMap.put(TYPE, () -> setType(campaigns.get(TYPE)));
        strategyMap.put(STATUS, () -> setStatus(campaigns.get(STATUS)));
        strategyMap.put(START_DATE, () -> setStartDate(campaigns.get(START_DATE)));
        strategyMap.put(END_DATE, () -> setEndDate(campaigns.get(END_DATE)));
        strategyMap.put(EXPECTED_REVENUE, () -> setExpectedRevenue(Integer.parseInt(campaigns.get(EXPECTED_REVENUE))));
        strategyMap.put(BUDGETED_COST, () -> setBudgetedCost(Integer.parseInt(campaigns.get(BUDGETED_COST))));
        strategyMap.put(ACTUAL_COST, () -> setActualCost(Integer.parseInt(campaigns.get(ACTUAL_COST))));
        strategyMap.put(EXPECTED_RESPONSE, () -> setExpectedResponse(Integer.parseInt(campaigns.get(EXPECTED_RESPONSE))));
        strategyMap.put(NUM_SENT, () -> setNumSent(Integer.parseInt(campaigns.get(NUM_SENT))));
        strategyMap.put(DESCRIPTION, () -> setDescription(campaigns.get(DESCRIPTION)));
        return strategyMap;
    }
}
