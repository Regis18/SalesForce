package salesforce.entities;


public class Context {
    private Campaign campaign;

    public Context() {
        this.campaign = new Campaign();
    }

    public Campaign getCampaign() {
        return campaign;
    }
}
