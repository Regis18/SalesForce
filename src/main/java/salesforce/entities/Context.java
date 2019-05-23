package salesforce.entities;

/**
 * Context.
 * @author Regis Humana.
 */
public class Context {
    private Campaign campaign;

    /**
     * This is the context for creation of the constructor.
     */
    public Context() {
        this.campaign = new Campaign();
    }

    /**
     * Get the Campaign object.
     * @return campaign.
     */
    public Campaign getCampaign() {
        return campaign;
    }
}
