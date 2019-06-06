package salesforce.entities;

import core.utils.StrategySetter;
import io.restassured.path.json.JsonPath;

import java.util.Date;
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
    private Date startDate;
    private Date endDate;
    private int expectedRevenue;
    private int budgetedCost;
    private int actualCost;
    private int expectedResponse;
    private int numSent;
    private String parentCampaign;
    private String description;
    private final String ID = "Id";
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
    public void setId(final String id) {
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
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets start Date.
     * @param startDate *
     */
    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets end date.
     * @return endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets end Date.
     * @param endDate *
     */
    public void setEndDate(final Date endDate) {
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
     */
    public void setJsonValues(final JsonPath json) {
        System.out.println("impreison: " + json.prettyPrint());
        setId(json.getString(ID));
        setName(json.getString(NAME));
        setActivate(json.getBoolean("IsActive"));
        setType(json.getString(TYPE));
        setStatus(json.getString(STATUS));
//        setStartDate(json.getString("StartDate"));
//        setEndDate(json.getString("EndDate"));
        setExpectedRevenue((int) json.getDouble("ExpectedRevenue"));
        setBudgetedCost((int) json.getDouble("BudgetedCost"));
        setActualCost((int) json.getDouble("ActualCost"));
        setExpectedResponse((int) json.getDouble("ExpectedResponse"));
        setNumSent((int) json.getDouble("NumberSent"));
        setDescription(json.getString(DESCRIPTION));
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
//        strategyMap.put(START_DATE, () -> setStartDate(campaigns.get(START_DATE)));
//        strategyMap.put(END_DATE, () -> setEndDate(campaigns.get(END_DATE)));
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
