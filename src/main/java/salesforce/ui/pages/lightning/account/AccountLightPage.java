/*
 * @(#) AccountLightPage.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.lightning.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.abstracts.account.AccountPageAbstract;

/**
 * AccountLightPage.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public class AccountLightPage extends AccountPageAbstract {

    @FindBy(xpath = "//li[@class=\"slds-button slds-button--neutral slds-truncate\"]//a[@title=\"New\"]")
    private WebElement newAccountBtn;

    /**
     * Wait for the title appears.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newAccountBtn));
    }

    /**
     * Click to the New account button and creates NewAccountPopup object.
     */
    @Override
    public NewAccountPopup clickNewAccountBtn() {
        newAccountBtn.click();
        return new NewAccountPopup();
    }
}
