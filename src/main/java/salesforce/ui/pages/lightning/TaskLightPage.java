/*
 * @(#) TaskLightPage.java Copyright (c) 2019 Jala Foundation.
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import salesforce.ui.BasePage;

/**
 * TaskLightPage class in this class whe navigate for this page the task created are displayed.
 * @author Melvi Caballero
 * @version 0.0.1
 */
public class TaskLightPage extends BasePage {
    public static final int MILLIS = 2500;

    @FindBy(css = ".forceRecordLayout:nth-child(1) .slds-split-view__list-item-action .slds-grow")
    private WebElement task;

//    @FindBy(xpath = "//*[contains(@class,\"slds-button__icon_x-small\")]")
//    private WebElement displayAsDropDownButton;

    @FindBy(css = ".sldsButtonHeightFix")
    private WebElement getDisplayAsDropDownButton;

    @FindBy(xpath = "//a[contains(.,'Delete')]")
    private WebElement deletetask;

   // public void clickDisplayAsDropDownButton(){
   // displayAsDropDownButton.click();
    //}
    public void clickDisplayTask(){ task.click(); }
    public void clickDropDownButton(){ getDisplayAsDropDownButton.click(); }
    public void clickDeleteItem(){ deletetask.click(); }

    public void displayListActions() {
        clickDisplayTask();
        clickDropDownButton();
        try {
            Thread.sleep(MILLIS);
        } catch (Exception e) {
        }
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ENTER);
        actions.perform();
        clickDeleteItem();
     }

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
