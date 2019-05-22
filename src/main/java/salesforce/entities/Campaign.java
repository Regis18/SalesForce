package salesforce.entities;

import java.util.Date;

/**
 * Campaign.
 * @author Regis Humana.
 */
public class Campaign {
    private String name;
    private boolean activate;
    private String type;
    private String planned;
    private Date startDate;
    private Date endDate;
    private int expectedRevenue;
    private int budgetedCost;
    private int actualCost;
    private int expectedResponse;
    private int numSent;
    private String parentCampaign;

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
     * Get Campaign planned.
     * @return planned
     */
    public String getPlanned() {
        return planned;
    }

    /**
     * Set Campaign planned.
     * @param planned *
     */
    public void setPlanned(final String planned) {
        this.planned = planned;
    }

    /**
     * Get start date.
     * @return startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Set start Date.
     * @param startDate *
     */
    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Get end date.
     * @return endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Set end Date.
     * @param endDate *
     */
    public void setEndDate(final Date endDate) {
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
}