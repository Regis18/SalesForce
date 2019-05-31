/*
 * @(#) EntityId.java Copyright (c) 2019 Jala Foundation.
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

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;

/**
 * AccountHook.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public class EntityId {
    private static Setup setup = Setup.getInstance();
    private WebDriver driver = WebDriverManager.getInstance().getWebDriver();

    /**
     * Get id the new object created
     * @return idNewObject string.
     */
    public String getIdEntitie() {
        String currentUrl = driver.getCurrentUrl();
        String[] arrayIdAccount = currentUrl.split("/");
        String idObject = "";
        switch (setup.getLayout()) {
            case "classic":
                idObject = arrayIdAccount[arrayIdAccount.length-1];
                break;
            case "light":
                idObject = arrayIdAccount[arrayIdAccount.length-2];
                System.out.println(idObject+" ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
                break;
        }
        return idObject;
    }
}
