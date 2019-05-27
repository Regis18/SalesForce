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

/**
 * DriverMethods.
 * @author Regis Humana
 */
public class DriverMethods {
    private static WebDriver webDriver;
    private static WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();
    private static int cont = 50;
    private static final int TIMEWAIT = 500;

    /**
     * Wait for the locator, if it exists the result is true, if it is not false.
     * @param locator by.
     * @return boolean.
     */
    public static boolean isElementExist(final By locator) {
        webDriver = WebDriverManager.getInstance().getWebDriver();

        boolean result = true;
        while (cont > 0) {
            try {
                webDriver.manage()
                        .timeouts()
                        .implicitlyWait(TIMEWAIT, TimeUnit.MILLISECONDS);
                webDriver.findElement(locator);
                cont--;
            } catch (NoSuchElementException e) {
                cont = -1;
                result = false;
            } finally {
                webDriver.manage()
                        .timeouts()
                        .implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
            }
        }
        return result;
    }
}
