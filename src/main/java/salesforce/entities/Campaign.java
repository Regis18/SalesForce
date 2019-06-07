package salesforce.entities;

import core.utils.Common;
import core.utils.StrategySetter;
import io.restassured.path.json.JsonPath;

import java.util.HashMap;
import java.util.Map;

/**
 * Campaign.
 *
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

    /**
     * Gets Id of Campaign.
     *
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets Id of Campaign.
     *
     * @param id string.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets Campaign name.
     *
     * @param name String
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets Campaign name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets Campaign boolean activate.
     *
     * @return activate
     */
    public boolean isActivate() {
        return activate;
    }

    /**
     * Sets boolean activate.
     *
     * @param activate *
     */
    public void setActivate(final boolean activate) {
        this.activate = activate;
    }

    /**
     * Gets Campaign type.
     *
     * @return type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets Campaign type.
     *
     * @param type *
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Gets Campaign status.
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets Campaign status.
     *
     * @param status *
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Gets start date.
     *
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets start Date.
     *
     * @param startDate *
     */
    public void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets end date.
     *
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets end Date.
     *
     * @param endDate *
     */
    public void setEndDate(final String endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets expected revenue.
     *
     * @return expectedRevenue
     */
    public int getExpectedRevenue() {
        return expectedRevenue;
    }

    /**
     * Sets expected revenue.
     *
     * @param expectedRevenue *
     */
    public void setExpectedRevenue(final int expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    /**
     * Gets budgeted cost.
     *
     * @return budgetedCost
     */
    public int getBudgetedCost() {
        return budgetedCost;
    }

    /**
     * Sets budget Cost.
     *
     * @param budgetedCost **
     */
    public void setBudgetedCost(final int budgetedCost) {
        this.budgetedCost = budgetedCost;
    }

    /**
     * Gets actual cost.
     *
     * @return actualCost
     */
    public int getActualCost() {
        return actualCost;
    }

    /**
     * Sets actual cost.
     *
     * @param actualCost **
     */
    public void setActualCost(final int actualCost) {
        this.actualCost = actualCost;
    }

    /**
     * Gets expected response.
     *
     * @return expectedResponse
     */
    public int getExpectedResponse() {
        return expectedResponse;
    }

    /**
     * Sets expected response.
     *
     * @param expectedResponse **
     */
    public void setExpectedResponse(final int expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    /**
     * Gets Num Sent.
     *
     * @return numSent
     */
    public int getNumSent() {
        return numSent;
    }

    /**
     * Sets num sent.
     *
     * @param numSent int
     */
    public void setNumSent(final int numSent) {
        this.numSent = numSent;
    }

    /**
     * Gets parent campaign.
     *
     * @return parentCampaign
     */
    public String getParentCampaign() {
        return parentCampaign;
    }

    /**
     * Sets parent campaign.
     *
     * @param parentCampaign String
     */
    public void setParentCampaign(final String parentCampaign) {
        this.parentCampaign = parentCampaign;
    }

    /**
     * Gets description.
     *
     * @return string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description string.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Sets the json values into Campaign.
     *
     * @param json JsonPath.
     * @param key  string.
     */
    public void setJsonValues(final String key, final JsonPath json) {
        if (key.equals("Id")) {
            setId(json.getString(key));
        }
        if (key.equals("Name")) {
            setName(json.getString(key));
        }
        if (key.equals(activeTag)) {
            setActivate(json.getBoolean(key));
        }
        if (key.equals(typeTag)) {
            setType(json.getString(typeTag));
        }
        if (key.equals(statusTag)) {
            setStatus(json.getString(statusTag));
        }
        if (key.equals(expectedRevenueTag)) {
            setExpectedRevenue((int) json.getDouble("ExpectedRevenue"));
        }
        if (key.equals(budgetedCostTag)) {
            setBudgetedCost((int) json.getDouble("BudgetedCost"));
        }
        if (key.equals(actualCostTag)) {
            setActualCost((int) json.getDouble("ActualCost"));
        }
        if (key.equals(expectedResponseTag)) {
            setExpectedResponse((int) json.getDouble("ExpectedResponse"));
        }
        if (key.equals(numberSentTag)) {
            setNumSent((int) json.getDouble("NumberSent"));
        }
        if (key.equals(descriptionTag)) {
            setDescription(json.getString(descriptionTag));
        }
        if (key.equals(startDateTag)) {
            setStartDate(json.getString("StartDate"));
        }
        if (key.equals(endDateTag)) {
            setEndDate(json.getString("EndDate"));
        }
    }

    /**
     * Processes information of the map and sent to composeStrategyMap.
     *
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
     *
     * @param campaigns String
     * @return Hashmap
     */
    private HashMap<String, StrategySetter> composeStrategyMap(final Map<String, String> campaigns) {
        HashMap<String, StrategySetter> strategyMap = new HashMap<>();
        strategyMap.put(nameTag, () -> setName(campaigns.get(nameTag)));
        strategyMap.put(activeTag, () -> setActivate(campaigns.get(activeTag).equals("true")));
        strategyMap.put(typeTag, () -> setType(campaigns.get(typeTag)));
        strategyMap.put(statusTag, () -> setStatus(campaigns.get(statusTag)));
        strategyMap.put(startDateTag, () -> setStartDate(Common.translateDate
                                            (campaigns.get(startDateTag).toLowerCase())));
        strategyMap.put(endDateTag, () -> setEndDate(Common.translateDate
                                            (campaigns.get(endDateTag).toLowerCase())));
        strategyMap.put(expectedRevenueTag, () -> setExpectedRevenue(Integer.parseInt
                                            (campaigns.get(expectedRevenueTag))));
        strategyMap.put(budgetedCostTag, () -> setBudgetedCost(Integer.parseInt(campaigns.get(budgetedCostTag))));
        strategyMap.put(actualCostTag, () -> setActualCost(Integer.parseInt(campaigns.get(actualCostTag))));
        strategyMap.put(expectedResponseTag, () -> setExpectedResponse(Integer
                                            .parseInt(campaigns.get(expectedResponseTag))));
        strategyMap.put(numberSentTag, () -> setNumSent(Integer.parseInt(campaigns.get(numberSentTag))));
        strategyMap.put(descriptionTag, () -> setDescription(campaigns.get(descriptionTag)));
        return strategyMap;
    }
}
