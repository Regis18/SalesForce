/*
 * @(#) SearchClassicPage.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.BasePage;
import salesforce.ui.pages.campaign.abstracts.OneCampaignAbstract;
import salesforce.ui.pages.campaign.classic.OneCampaignClassicPage;
import salesforce.utils.DriverMethods;

/**
 * SearchClassicPage.
 * @author Regis Humana
 * @version 0.0.1
 */
public class SearchClassicPage extends SearchAbstractPage{
    private String elementSearched = "//*[*[@class='pbHeader']//*[contains(text(),'key')]]//a[text()='element']";
    private final String key = "key";
    private final String element = "element";

    @FindBy(css = "[class='searchResultsCell']")
    private WebElement panelSearch;

    /**
     * Accesses to the element that was searched.
     * @param key string.
     * @param element string.
     * @return OneCampaignClassic.
     */
    @Override
    public OneCampaignAbstract accessToElementSearched(String key, String element) {
        driver.findElement(By.xpath(elementSearched.replace(this.key, key).replace(this.element, element))).click();
        return new OneCampaignClassicPage();
    }

    /**
     * Verifies that the element that was searched exist in the list.
     * @param key string.
     * @param element string.
     * @return boolean
     */
    public boolean doesElementExist(String key, String element) {
        return DriverMethods.searchForExistentElement(By.xpath(elementSearched
                .replace(this.key, key)
                .replace(this.element, element)));
    }

    /**
     * Waits for Panel Search.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(panelSearch));
    }
}
