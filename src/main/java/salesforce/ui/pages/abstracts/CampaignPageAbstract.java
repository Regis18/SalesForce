package salesforce.ui.pages.abstracts;

import salesforce.ui.BasePage;
import salesforce.ui.behaves.NewCampaignAbstract;

/**
 * CampaignPageAbstract.
 * @author Regis Humana.
 */
public abstract class CampaignPageAbstract extends BasePage {

    /**
     * Click in NewCampaign button.
     * @return clickNewCampaignBtn.
     */
    protected abstract NewCampaignAbstract clickNewCampaignBtn();
}
