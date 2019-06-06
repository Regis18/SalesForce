package salesforce.entities;

import core.utils.Common;
import core.utils.StrategySetter;
import io.restassured.path.json.JsonPath;

import java.util.HashMap;
import java.util.Map;

/**
 * Campaign.
 * @author Regis Humana.
 * @version 0.0.1
 */
public class Campaign {

    private String id;
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
    private final String ACTIVE = "IsActive";
    private final String TYPE = "Type";
    private final String STATUS = "Status";
    private final String START_DATE = "StarDate";
    private final String END_DATE = "EndDate";
    private final String EXPECTED_REVENUE = "ExpectedRevenue";
    private final String BUDGETED_COST = "BudgetedCost";
    private final String ACTUAL_COST = "ActualCost";
    private final String EXPECTED_RESPONSE = "ExpectedResponse";
    private final String NUM_SENT = "NumberSent";

    /**
     * Gets Id of Campaign.
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets Id of Campaign.
     * @param id string.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets Campaign name.
     * @param name String
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets Campaign name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets Campaign boolean activate.
     * @return activate
     */
    public boolean isActivate() {
        return activate;
    }

    /**
     * Sets boolean activate.
     * @param activate *
     */
    public void setActivate(final boolean activate) {
        this.activate = activate;
    }

    /**
     * Gets Campaign type.
     * @return type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets Campaign type.
     * @param type *
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Gets Campaign status.
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets Campaign status.
     * @param status *
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Gets start date.
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets start Date.
     * @param startDate *
     */
    public void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets end date.
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets end Date.
     * @param endDate *
     */
    public void setEndDate(final String endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets expected revenue.
     * @return expectedRevenue
     */
    public int getExpectedRevenue() {
        return expectedRevenue;
    }

    /**
     * Sets expected revenue.
     * @param expectedRevenue *
     */
    public void setExpectedRevenue(final int expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    /**
     * Gets budgeted cost.
     * @return budgetedCost
     */
    public int getBudgetedCost() {
        return budgetedCost;
    }

    /**
     * Sets budget Cost.
     * @param budgetedCost **
     */
    public void setBudgetedCost(final int budgetedCost) {
        this.budgetedCost = budgetedCost;
    }

    /**
     * Gets actual cost.
     * @return actualCost
     */
    public int getActualCost() {
        return actualCost;
    }

    /**
     * Sets actual cost.
     * @param actualCost **
     */
    public void setActualCost(final int actualCost) {
        this.actualCost = actualCost;
    }

    /**
     * Gets expected response.
     * @return expectedResponse
     */
    public int getExpectedResponse() {
        return expectedResponse;
    }

    /**
     * Sets expected response.
     * @param expectedResponse **
     */
    public void setExpectedResponse(final int expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    /**
     * Gets Num Sent.
     * @return  numSent
     */
    public int getNumSent() {
        return numSent;
    }

    /**
     * Sets num sent.
     * @param numSent int
     */
    public void setNumSent(final int numSent) {
        this.numSent = numSent;
    }

    /**
     * Gets parent campaign.
     * @return parentCampaign
     */
    public String getParentCampaign() {
        return parentCampaign;
    }

    /**
     * Sets parent campaign.
     * @param parentCampaign String
     */
    public void setParentCampaign(final String parentCampaign) {
        this.parentCampaign = parentCampaign;
    }

    /**
     * Gets description.
     * @return string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     * @param description string.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Sets the json values into Campaign.
     * @param json JsonPath.
     * @param key string.
     */
    public void setJsonValues(String key, JsonPath json) {
        if (key.equals("Id")) {
            setId(json.getString(key));
        }
        if (key.equals("Name")) {
            setName(json.getString(key));
        }
        if (key.equals(ACTIVE)) {
            setActivate(json.getBoolean(key));
        }
        if (key.equals(TYPE)) {
            setType(json.getString(TYPE));
        }
        if (key.equals(STATUS)) {
            setStatus(json.getString(STATUS));
        }
        if (key.equals(EXPECTED_REVENUE)) {
            setExpectedRevenue((int)json.getDouble("ExpectedRevenue"));
        }
        if (key.equals(BUDGETED_COST)) {
            setBudgetedCost((int)json.getDouble("BudgetedCost"));
        }
        if (key.equals(ACTUAL_COST)) {
            setActualCost((int)json.getDouble("ActualCost"));
        }
        if (key.equals(EXPECTED_RESPONSE)) {
            setExpectedResponse((int)json.getDouble("ExpectedResponse"));
        }
        if (key.equals(NUM_SENT)) {
            setNumSent((int)json.getDouble("NumberSent"));
        }
        if (key.equals(DESCRIPTION)) {
            setDescription(json.getString(DESCRIPTION));
        }
        if (key.equals(START_DATE)) {
            setStartDate(json.getString("StartDate"));
        }
        if (key.equals(END_DATE)) {
            setEndDate(json.getString("EndDate"));
        }
    }

    /**
     * Processes information of the map and sent to composeStrategyMap.
     * @param campaigns Map.
     */
    public void processInformation(final Map<String, String> campaigns) {
        HashMap<String, StrategySetter> strategyMap = composeStrategyMap(campaigns);
        campaigns.keySet().forEach(key -> {
            strategyMap.get(key).executeMethod();
        });
    }

    /**
     * Composes the values of Campaign.
     * @param campaigns String
     * @return Hashmap
     */
    private HashMap<String, StrategySetter> composeStrategyMap(final Map<String, String> campaigns) {
        HashMap<String, StrategySetter> strategyMap = new HashMap<>();
        strategyMap.put(NAME, () -> setName(campaigns.get(NAME)));
        strategyMap.put(ACTIVE, () -> setActivate(campaigns.get(ACTIVE).equals("True")));
        strategyMap.put(TYPE, () -> setType(campaigns.get(TYPE)));
        strategyMap.put(STATUS, () -> setStatus(campaigns.get(STATUS)));
        strategyMap.put(START_DATE, () -> setStartDate(Common.translateDate(campaigns.get(START_DATE).toLowerCase())));
        strategyMap.put(END_DATE, () -> setEndDate(Common.translateDate(campaigns.get(END_DATE).toLowerCase())));
        strategyMap.put(EXPECTED_REVENUE, () -> setExpectedRevenue(Integer.parseInt(campaigns.get(EXPECTED_REVENUE))));
        strategyMap.put(BUDGETED_COST, () -> setBudgetedCost(Integer.parseInt(campaigns.get(BUDGETED_COST))));
        strategyMap.put(ACTUAL_COST, () -> setActualCost(Integer.parseInt(campaigns.get(ACTUAL_COST))));
        strategyMap.put(EXPECTED_RESPONSE, () -> setExpectedResponse(Integer
                                                                    .parseInt(campaigns.get(EXPECTED_RESPONSE))));
        strategyMap.put(NUM_SENT, () -> setNumSent(Integer.parseInt(campaigns.get(NUM_SENT))));
        strategyMap.put(DESCRIPTION, () -> setDescription(campaigns.get(DESCRIPTION)));
        return strategyMap;
    }
}
