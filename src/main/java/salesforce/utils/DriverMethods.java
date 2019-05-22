/*
 * @(#) DriverMethods.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.utils;

import core.selenium.WebDriverConfig;
import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverMethods {
    private static WebDriver webDriver;
    private static WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();

    public static boolean waitForElementDisappear(By locator) {
        webDriver = WebDriverManager.getInstance().getWebDriver();
        int cont = 50;
        boolean result = false;
        while (cont > 0) {
            try {
                webDriver.manage()
                        .timeouts()
                        .implicitlyWait(500, TimeUnit.MILLISECONDS);
                webDriver.findElement(locator);
                cont--;
            } catch (NoSuchElementException e) {
                cont = -1;
                result = true;
            } finally {
                webDriver.manage()
                        .timeouts()
                        .implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
            }
        }
        return result;
    }
    public void waitForMilliSeconds(int time) {
        webDriver = WebDriverManager.getInstance().getWebDriver();

        webDriver.manage()
                .timeouts()
                .implicitlyWait(time, TimeUnit.MILLISECONDS);

        webDriver.manage()
                .timeouts()
                .implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);

    }

    public void establishImplicitWait() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
        webDriver.manage()
                .timeouts()
                .implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);

    }
}
