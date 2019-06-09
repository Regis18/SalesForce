/*
 * @(#) SetupPage.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.BasePage;
import salesforce.ui.pages.home.HomePageAbstract;
import salesforce.ui.pages.home.HomeClassicPage;
import salesforce.ui.pages.home.HomeLightPage;

/**
 * SetupPage.
 *
 * @author Regis Humana
 * @version 0.0.1
 */
public class SetupPage extends BasePage {

    @FindBy(css = "[data-aura-class='onesetupSetupHeader']")
    private WebElement setupHeader;

    @FindBy(css = "[class='profile-card-footer']")
    private WebElement optionsForm;

    @FindBy(css = "[class^='bare branding-userProfile-button'")
    private WebElement viewProfileBtn;

    @FindBy(css = "[class^='profile-link-label switch-to-aloha']")
    private WebElement switchClassicLink;

    @FindBy(css = "[class^='bare slds-icon-waffle_container slds-context-bar__button']")
    private WebElement appLauncherBtn;

    @FindBy(css = "a[class^='app-launcher-link slds-text-link--reset'][title='Home']")
    private WebElement homeLink;

    //Classic Page
    @FindBy(id = "tabBar")
    private WebElement tabBarClassic;

    @FindBy(id = "home_Tab")
    private WebElement homeTabBtn;

    @FindBy(css = "[class='switch-to-lightning']")
    private WebElement switchLightLink;

    private boolean isLight;

    /**
     * It waits for a time to know in what page is and if the skin is Light or Classic.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        while (driver.getTitle().equals("") || driver.getTitle().equals("Lightning Experience")) {
            continue;
        }

        isLight = driver.getTitle().contains("Home | Salesforce");
        if (isLight) {
            wait.until(ExpectedConditions.visibilityOf(setupHeader));
        } else {
            wait.until(ExpectedConditions.visibilityOf(tabBarClassic));
        }
    }

    /**
     * It navigates to Home Classic from setup classic or light.
     *
     * @return HomePageAbstract.
     */
    public HomePageAbstract navigateHomeClassic() {
        System.out.println(isLight);
        if (isLight) {
            viewProfileBtn.click();
            wait.until(ExpectedConditions.visibilityOf(switchClassicLink));
            switchClassicLink.click();
        } else {
            homeTabBtn.click();
        }
        return new HomeClassicPage();
    }

    /**
     * It navigates to Home Light from setup classic or light.
     *
     * @return HomePageAbstract.
     */
    public HomePageAbstract navigateHomeLight() {
        if (isLight) {
            wait.until(ExpectedConditions.elementToBeClickable(appLauncherBtn));
            appLauncherBtn.click();
            wait.until(ExpectedConditions.elementToBeClickable(homeLink));
            homeLink.click();
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(switchLightLink));
            switchLightLink.click();
        }
        return new HomeLightPage();
    }
}
