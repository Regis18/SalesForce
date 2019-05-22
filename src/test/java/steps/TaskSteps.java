/*
 * @(#) TaskSteps.java Copyright (c) 2019 Jala Foundation.
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

package steps;

import cucumber.api.java.en.When;
import salesforce.ui.pages.lightning.HomeLightPage;
import salesforce.ui.pages.TransporterPage;
import salesforce.ui.pages.lightning.NewTaskLightPopUp;

/**
 * Task steps class.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class TaskSteps {
    private TransporterPage transporterPage = TransporterPage.getInstance();
    private HomeLightPage homeLightPage;
    private NewTaskLightPopUp newTaskLightPopUp;
    private String nameTaskSubject;
    /**
     * navigate to home page.
     */
    @When("^I navigate to home page$")
    public void navigateToHome() {
        homeLightPage = TransporterPage.getInstance().navigateToHomeLightPage();
    }

    /**
     * navigate to tasks home page.
     */
    @When("^I navigate to Lightning Tasks home page$")
    public void navigateToTasksHome() {
        homeLightPage = TransporterPage.getInstance().navigateToTasksHomeLightPage();
    }


    /**
     * Create task step.
     */
    @When("^I create a new task in SalesForce$")
    public void createTask() {
        newTaskLightPopUp = homeLightPage.displayCreateTask();
       // newTaskLightPopUp.createNewTask();
        nameTaskSubject=newTaskLightPopUp.createNewTask();

    }

    /**
     * Display task home.
     */
    @When("^Display Lightning Task Home from home page$")
    public void displayTaskHome() {
        homeLightPage.clickTaskMenuButton();
    }


}
