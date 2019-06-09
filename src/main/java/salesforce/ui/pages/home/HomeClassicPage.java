/*
 * @(#) HomeClassicPage.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 *  Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 *
 */

package salesforce.ui.pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.account.classic.AccountClassicPage;
import salesforce.ui.pages.campaign.classic.CampaignClassicPage;
import salesforce.ui.pages.search.SearchAbstractPage;
import salesforce.ui.pages.search.SearchClassicPage;
import salesforce.ui.pages.task.abstracts.NewTaskAbstract;
import salesforce.ui.pages.task.classic.NewTaskClassic;

/**
 * HomeLightPage.
 * @author Regis Humana.
 */
public class HomeClassicPage extends HomePageAbstract {

    /**
     * Account tab.
     */
    @FindBy(id = "Account_Tab")
    private WebElement accountTab;

    /**
     * Is the main table of Home.
     */
    @FindBy(css = "table[id=\"bodyTable\"]")
    private WebElement homeTable;

    /**
     * Campaign tab.
     */
    @FindBy(id = "Campaign_Tab")
    private WebElement campaignTab;

    @FindBy(id = "phSearchButton")
    private WebElement searchBtn;

    @FindBy(id = "phSearchInput")
    private WebElement searchTxt;

    /**
     * Wait for homeTable is ready.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(homeTable));
    }

    /**
     * Click to Account and initialize AccountClassicPage.
     * @return AccountClassicPage.
     */
    public AccountClassicPage clickAccountBtn() {
        accountTab.click();
        return new AccountClassicPage();
    }

    /**
     * Click to Campaign and initialize CampaignClassicPage.
     * @return CampaignClassicPage.
     */
    public CampaignClassicPage clickCampaignBtn() {
        campaignTab.click();
        return new CampaignClassicPage();
    }

    /**
     * Display create task.
     * @return NewTaskClassic
     */
    @Override
    public NewTaskAbstract displayCreateTask() {
        return  new NewTaskClassic();
    }

    /**
     * Search element in the main Search.
     * @param element string.
     * @return SearchClassicPage.
     */
    @Override
    public SearchAbstractPage searchElement(String element) {
        searchTxt.sendKeys(element);
        searchBtn.click();
        return new SearchClassicPage();
    }
}
