/*
 * @(#) OneAccountClassicPage.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.account.classic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.account.abstracts.OneAccountAbstract;

/**
 * OneAccountClassicPage.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public class OneAccountClassicPage extends OneAccountAbstract {

    @FindBy(xpath = "//td[@class=\" oRight\"]")
    private WebElement accountDetailForm;

    @FindBy(xpath = "//div[@class=\"bPageTitle\"]")
    private WebElement accountPanelTitle;

    @FindBy(xpath = "//h2[@class=\"topName\"]")
    private WebElement accountTitleLbl;

    @FindBy(xpath = "//td[@id=\"topButtonRow\"]//input[@name=\"delete\"]")
    private WebElement deleteBtn;

    /**
     * Wait for Account panel title.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(accountPanelTitle));
    }

    /**
     * Verify if the components of the Account exist.
     * @return boolean
     */
    @Override
    public boolean verifyComponentsAccount() {
        return accountDetailForm.isDisplayed();
    }

    /**
     * Get the Name Account.
     * @return string
     */
    @Override
    public String getNameAccount() {
        return accountTitleLbl.getText();
    }

    /**
     * Delete account.
     */
    @Override
    public void deleteAccount() {
        deleteBtn.click();
        driver.switchTo().alert().accept();
    }
}