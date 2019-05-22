/*
 *  @HomeLightPage.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.lightning;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.abstracts.HomePageAbstract;

/**
 * HomeLightPage.
 * @author Regis Humana
 */
public class HomeLightPage extends HomePageAbstract {

    @FindBy(id = "brandBand_1")
    private WebElement homeForm;

    /**
     * Button for opening Campaign.
     */
    @FindBy(xpath = "//one-app-nav-bar-item-root[@data-id=\"Campaign\"]")
    private WebElement campaignBtn;

    @FindBy(xpath = "//a[span[contains(text(),\"Tasks Menu\")]]")
    private WebElement taskDropdownButton;

    /**
     * Wait for the element that is required.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(homeForm));
    }

    /**
     * Event click on tasks dropdown.
     */
    public void clickTasksDropDownButton() {
        taskDropdownButton.click();
    }

    /**
     * display Create task popup.
     */
    public void displayCreateTask() {
        clickTasksDropDownButton();
    }

    /**
     * Click in the campaign button.
     * @return CampaignLightPage.
     */
    public CampaignLightPage clickCampaignBtn() {
        campaignBtn.click();
        return new CampaignLightPage();
    }
}
