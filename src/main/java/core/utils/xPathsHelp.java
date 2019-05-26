/*
 * @(#) xPathsHelp.java Copyright (c) 2019 Jala Foundation.
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

package core.utils;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * XpathHelp.
 * @author Regis Humana
 * @version 0.0.1
 */
public class xPathsHelp {
    protected static WebDriver driver;

    /**
     * Get the path that contains a lot of objects and distribute one by one.
     * @param xPath string
     * @return List of Web Element
     */
    public static List<WebElement> distribution(String xPath) {
        driver = WebDriverManager.getInstance().getWebDriver();
        List<WebElement> arrayElement = new ArrayList();
        for (WebElement element: driver.findElements(By.xpath(xPath))) {
            arrayElement.add(element);
        }
        return arrayElement;
    }
}
