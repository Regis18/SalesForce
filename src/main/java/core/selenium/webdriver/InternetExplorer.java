/*
 * @(#) InternetExplorer.java Copyright (c) 2019 Jala Foundation.
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

package core.selenium.webdriver;

import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * InternetExplorer.
 * @author Luis Guardia.
 */
public class InternetExplorer {
    /**
     * Init the driver of Internet Explorer.
     * @return WebDriver.
     */
    public WebDriver initDriver() {
        InternetExplorerDriverManager.getInstance().setup();
        return new InternetExplorerDriver();
    }
}
