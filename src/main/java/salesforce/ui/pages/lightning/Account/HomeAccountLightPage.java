/*
 * @(#) HomeAccountLightPage.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.lightning.Account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.abstracts.Account.HomeAccountPageAbstract;

/**
 * HomeAccountLightPage.
 * @author Luis Guardia.
 */
public class HomeAccountLightPage extends HomeAccountPageAbstract {

    @FindBy(xpath = "//div[@id=\"brandBand_1\"]")
    private WebElement homeForm;

    @FindBy(xpath = "//one-app-nav-bar-item-root[@data-id=\"Account\"]")
    private WebElement accountBtn;

    /**
     * Wait for the element that is required.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(homeForm));
    }

    /**
     * Click in the account button.
     * @return AccountLightPage.
     */
    public AccountLightPage clickAccountBtn() {
        accountBtn.click();
        return new AccountLightPage();
    }
}
