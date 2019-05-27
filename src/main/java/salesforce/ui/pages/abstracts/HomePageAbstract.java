package salesforce.ui.pages.abstracts;

import salesforce.ui.BasePage;
import salesforce.ui.pages.abstracts.campaign.CampaignPageAbstract;

/**
 * HomePageAbstract.
 * @author Regis Humana
 * @version 0.0.1
 */
public abstract class HomePageAbstract extends BasePage {

    /**
     * Click in the button Campaign button.
     * @return Campaign Page abstract.
     */
    public abstract CampaignPageAbstract clickCampaignBtn();

    /**
     * This method will implemented for display a created task.
     * @return NewTaskAbstract.
     */
    public abstract NewTaskAbstract displayCreateTask();

}
