/*
 * @(#) NewCampaignPopup.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.lightning.campaign;

import core.utils.xPathsHelp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.entities.Campaign;
import salesforce.ui.pages.abstracts.campaign.NewCampaignAbstract;

import java.lang.ref.PhantomReference;
import java.util.List;

import static core.utils.xPathsHelp.distribution;

/**
 * NewCampaignPopup.
 * @author Regis Humana.
 * @version 0.0.1.
 */
public class NewCampaignPopup extends NewCampaignAbstract {
    /**
     * Popup the new campaign.
     */
    @FindBy(css = "div[class='modal-container slds-modal__container']")
    private WebElement newCampaignPopup;
    /**
     * Campaign Name of the form.
     */
    @FindBy(xpath = "//div[@data-aura-class='uiInput uiInputText uiInput--default uiInput--input']//input")
    private WebElement nameTxt;
    /**
     * Save button.
     */
    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[contains(@class,\"uiInputCheckbox\")]//input[@type=\"checkbox\"]")
    private WebElement activateChk;

    @FindBy(xpath = "//div[@class='uiPopupTrigger']//a[contains(@class,'select')][contains(text(),'Conference')]")
    private WebElement typeCmb;

    @FindBy(xpath = "//div[@class='uiPopupTrigger']//a[contains(@class,'select')][contains(text(),'Planned')]")
    private WebElement statusCmb;

    @FindBy(xpath = "//div[//span[contains(text(),'Start')]]//div[@class=\"form-element\"]//input[ @class=' input']")
    private WebElement //solo pa dos

    private final String DATES =  "//div[@class=\"form-element\"]//input[@class]";


    private final String COSTS_TXT = "//div[contains(@data-aura-class,\"uiInput uiInput--default uiInput--input\")]//input";

    @FindBy(xpath = "//div[contains(@class,'uiInput uiInputPercent')]//input")
    private WebElement expectedResponseTxt;

    @FindBy(xpath = "//div[contains(@class,\"uiInput uiInputNumber\")]//input")
    private WebElement numSentTxt;

    @FindBy(xpath = "//div[contains(@class,\"uiInput uiInputTextArea\")]//textarea")
    private WebElement descriptionTxt;

    private List<WebElement> typeStatusList;
    private List<WebElement> datesList;
    private List<WebElement> costsList;

    /**
     * Wait for the Popup to initialize.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(newCampaignPopup));
    }

    /**
     * Set the name into NameTxt.
     * @param name **this is the name**
     */
    protected void setNameTxt(final String name) {
        nameTxt.sendKeys(name);
    }

    /**
     * Click to Save the changes.
     */
    public void clickSaveBtn() {
        saveBtn.click();
    }

    @Override
    protected void setActiveChk(boolean isActivate) {
        if(isActivate) {
            activateChk.click();
        }
    }

    @Override
    protected void setTypeCmb(String type) {
        typeStatusList.get(0).sendKeys(type);
    }

    @Override
    protected void setStatusCmb(String status) {
        typeStatusList.get(1).sendKeys(status);
    }

    @Override
    protected void setStartDate(String startDate) {
        datesList.get(0).sendKeys(startDate);
    }

    @Override
    protected void setEndDate(String endDate) {
        datesList.get(1).sendKeys(endDate);
    }

    @Override
    protected void setExpectedRevenueTxt(Integer expected) {
        costsList.get(0).sendKeys(expected.toString());
    }

    @Override
    protected void setBudgetedCostTxt(Integer budgeted) {
        costsList.get(1).sendKeys(budgeted.toString());
    }

    @Override
    protected void setActualCostTxt(Integer actualCost) {
        costsList.get(2).sendKeys(actualCost.toString());
    }

    @Override
    protected void setNumSent(Integer numSent) {
        numSentTxt.sendKeys(numSent.toString());
    }

    @Override
    protected void setDescriptionTxt(String description) {
        descriptionTxt.sendKeys(description);
    }

    @Override
    public void setCampaignData(Campaign data) {
        super.setCampaignData(data);
    }
}
