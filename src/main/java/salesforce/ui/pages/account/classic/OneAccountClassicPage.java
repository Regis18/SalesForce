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

    //////////ELEMENTOS DE DETAILS PAGE
    @FindBy(xpath = "//h2[@class=\"topName\"]")
    private WebElement accountName;

    @FindBy(id = "acc3_ileinner")
    private WebElement parentAccount;

    @FindBy(id = "acc5_ileinner")
    private WebElement numberAccount;

    @FindBy(id = "acc23_ileinner")
    private WebElement siteAccount;

    @FindBy(id = "acc6_ileinner")
    private WebElement typeAccount;

    @FindBy(id = "acc7_ileinner")
    private WebElement industryAccount;

    @FindBy(id = "acc8_ileinner")
    private WebElement revenueAccount;

    @FindBy(id = "acc17_ileinner")
    private WebElement billingAddresAccount;

    @FindBy(id = "00N4P0000072sE6_ileinner")
    private WebElement priorityAccount;

    @FindBy(id = "00N4P0000072sE9_ileinner")
    private WebElement slaDateAccount;

    @FindBy(id = "00N4P0000072sE7_ileinner")
    private WebElement numberLocationsAccount;

    @FindBy(id = "00N4P0000072sE5_ileinner")
    private WebElement activeAccount;

    @FindBy(id = "acc20_ileinner")
    private WebElement descriptionAccount;

    @FindBy(id = "acc9_ileinner")
    private WebElement ratingAccount;

    @FindBy(id = "acc10_ileinner")
    private WebElement phoneAccount;

    @FindBy(id = "acc11_ileinner")
    private WebElement faxAccount;

    @FindBy(id = "acc12_ileinner")
    private WebElement webSiteAccount;

    @FindBy(id = "acc13_ileinner")
    private WebElement tickerAccount;

    @FindBy(id = "acc14_ileinner")
    private WebElement ownershipAccount;

    @FindBy(id = "acc15_ileinner")
    private WebElement employeeAccount;

    @FindBy(id = "acc16_ileinner")
    private WebElement sicCodeAccount;

    @FindBy(id = "acc18_ileinner")
    private WebElement shippinAddresAccount;

    @FindBy(id = "00N4P0000072sE8_ileinner")
    private WebElement slaAccount;

    @FindBy(id = "00N4P0000072sEA_ileinner")
    private WebElement slaSerialAccount;

    @FindBy(id = "00N4P0000072sEB_ileinner")
    private WebElement upsellAccount;

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
     * Implement isDisplayedDetailsPage.
     * @return true component
     */
    @Override
    public boolean isDisplayedDetailsPage() {
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
