/*
 * @(#) CampaignHook.java Copyright (c) 2019 Jala Foundation.
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

package hooks;

import core.selenium.WebDriverManager;
import core.utils.Logs;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import salesforce.api.CampaignApi;
import salesforce.entities.Context;
import salesforce.ui.pages.TransporterPage;

/**
 * CampaignHook.
 * @author Regis Humana
 * @version 0.0.1
 */
public class CampaignHook {
    private TransporterPage pageTransporter = TransporterPage.getInstance();

    private Context context;

    private Logger logs = Logs.getInstance().getLog();

    private WebDriver driver;

    private CampaignApi campaignApi;

    /**
     * Constructor to initialize context and driver.
     * @param context
     */
    public CampaignHook(Context context) {
        this.context = context;
        driver = WebDriverManager.getInstance().getWebDriver();
    }

    /**
     * Delete an Account.
     */
    @After("@deleteAccount")
    public void deleteNewAccount() {
        campaignApi = new CampaignApi();
        campaignApi.deleteCampaign(context.getCampaign().getId());
    }

    /**
     * Take a picture of the part that test failed.
     * @param scenario Scenario.
     */
    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            logs.info("The scenario is failed and the screenshot is taken");
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }

}
