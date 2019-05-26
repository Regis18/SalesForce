package salesforce.ui.pages.abstracts;

import salesforce.ui.BasePage;
import salesforce.ui.pages.abstracts.campaign.CampaignPageAbstract;

/**
 * HomePageAbstract.
 * @author Regis Humana
 */
public abstract class HomePageAbstract extends BasePage {

    /**
     * Click in the button Campaign button.
     * @return Campaign Page abstract.
     */
    public abstract CampaignPageAbstract clickCampaignBtn();

    /**
     * This method will implemented for display a created task.
     * @return
     */
    public abstract NewTaskAbstract displayCreateTask();

}
