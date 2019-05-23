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
import salesforce.ui.pages.abstracts.task.NewTaskAbstract;
import salesforce.ui.pages.lightning.task.NewTaskLightPopUp;

/**
 * HomeLightPage.
 *
 * @author Regis Humana
 */
public class HomeLightPage extends HomePageAbstract {
    public static final int MILLIS = 2500;

    @FindBy(id = "brandBand_1")
    private WebElement homeForm;

    /**
     * Button for opening Campaign.
     */
    @FindBy(xpath = "//one-app-nav-bar-item-root[@data-id=\"Campaign\"]")
    private WebElement campaignBtn;

    /**
     * Button for opening the task dropdown.
     */
    @FindBy(xpath = "//a[span[contains(text(),'Tasks Menu')]]")
    private WebElement taskDropdownButton;

    /**
     * Select item New Task.
     */
    @FindBy(xpath = ("//a[span[span[contains(text(),'New Task')]]]"))
    private WebElement newTaskItem;

//    @FindBy(xpath = ("/html[1]/body[1]/div[5]/div[1]/section[1]/header[1]/div[3]" +
//            "/one-appnav[1]/div[1]/one-app-nav-bar[1]/nav[1]/div[1]/one-app-nav-" +
//            "bar-item-root[4]/one-app-nav-bar-item-dropdown[1]/div[1]/one-app-nav" +
//            "-bar-menu-button[1]/div[1]/slot[1]/one-app-nav-bar-menu-item[1]/a[1]" +
//            "/span[1]/span[1]"))
//    private WebElement newTaskItem;

    /**
     * task menuButton.
     */
    @FindBy(xpath = "//a[span[contains(text(),'Tasks')]]")
    private WebElement taskMenuButton;

//    @FindBy(xpath = "//span[@class='slds-truncate'][contains(text(),'Tasks')]")
//    private WebElement taskMenuButton;

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
