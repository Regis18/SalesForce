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

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.abstracts.HomePageAbstract;
import org.openqa.selenium.interactions.Actions;
import salesforce.ui.pages.abstracts.NewTaskAbstract;
import salesforce.ui.pages.lightning.campaign.CampaignLightPage;

/**
 * HomeLightPage.
 *
 * @author Regis Humana
 * @version 0.0.1
 */
public class HomeLightPage extends HomePageAbstract {

    public static final int MILLIS = 2500;

    @FindBy(id = "brandBand_1")
    private WebElement homeForm;

    @FindBy(xpath = "//one-app-nav-bar-item-root[@data-id=\"Campaign\"]")
    private WebElement campaignBtn;

    @FindBy(xpath = "//a[span[contains(text(),\"Tasks Menu\")]]")
    private WebElement taskDropdownButton;

    @FindBy(xpath = ("//a[span[span[contains(text(),\"New Task\")]]]"))
    private WebElement newTaskItem;

    @FindBy(xpath = "//a[span[contains(text(),\"Tasks\")]]")
    private WebElement taskMenuButton;

    /**
     * Event click on tasks dropdown.
     */
    public void clickTasksDropDownButton() {
        taskDropdownButton.click();
    }

    /**
     * Event click on tasks menu option.
     */
    public void clickTaskMenuButton() {
        taskMenuButton.click();
    }

      /**
     * display Create task popup.
     *
     * @return NewTaskLightPopUp
     */
    public NewTaskAbstract displayCreateTask() {
        clickTasksDropDownButton();
        try {
            Thread.sleep(MILLIS);
        } catch (Exception e) {
        }
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ENTER);
        actions.perform();
        return new NewTaskLightPopUp();
    }

    /**
     * Event click on new tasks item.
     */
    public void clickNewTasksItem() {
        newTaskItem.click();
    }

    /**
     * Wait for the element that is required.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(homeForm));
    }

    /**
     * Click in the campaign button.
     *
     * @return CampaignLightPage.
     */
    public CampaignLightPage clickCampaignBtn() {
        campaignBtn.click();
        return new CampaignLightPage();
    }
}
