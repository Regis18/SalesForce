package salesforce.ui.pages.abstracts;

import salesforce.ui.BasePage;

/**
 * CampaignPageAbstract.
 * @author Regis Humana.
 */
public abstract class CampaignPageAbstract extends BasePage {

    /**
     * Click in NewCampaign button.
     * @return clickNewCampaignBtn.
     */
    public abstract NewCampaignAbstract clickNewCampaignBtn();

    /**
     * Implement: check the campaign list.
     * @param name string.
     * @return boolean.
     */
    public abstract boolean checkCampaignList(String name);
}
