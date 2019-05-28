package salesforce.entities;

import salesforce.ui.pages.abstracts.HomePageAbstract;

/**
 * Context.
 * @author Regis Humana.
 */
public class Context {
    private Campaign campaign;
    private Account account;
    private HomePageAbstract homePage;

    /**
     * This is the context for creation of the constructor.
     */
    public Context() {
        this.account = new Account();
        this.campaign = new Campaign();
    }

    /**
     * Get the Campaign object.
     * @return campaign.
     */
    public Campaign getCampaign() {
        return campaign;
    }

    /**
     * Get the home page.
     * @return the home page.
     */
    public HomePageAbstract getHomePage() {
        return homePage;
    }

    /**
     * Set home page.
     * @param homePage HomePageAbstract.
     */
    public void setHomePage(final HomePageAbstract homePage) {
        this.homePage = homePage;
    }

    /**
     * Get the Account object.
     * @return account.
     */
    public Account getAccount() {
        return account;
    }
}
