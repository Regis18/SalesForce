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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import salesforce.ui.pages.lightning.HomeLightPage;
import salesforce.ui.pages.TransporterPage;
import salesforce.ui.pages.lightning.NewTaskLightPopUp;
import salesforce.ui.pages.lightning.TaskLightPage;

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
    private TaskLightPage taskLightPage;


    /**
     * navigate to tasks home page.
     */
    @When("^I navigate to Lightning Tasks home page$")
    public void navigateToTasksHome() {
        taskLightPage = TransporterPage.getInstance().navigateToTasksHomeLightPage();
    }


    /**
     * Create task step.
     */
    @When("^I create a new task in SalesForce$")
    public void createTask() {
        newTaskLightPopUp = homeLightPage.displayCreateTask();
        nameTaskSubject = newTaskLightPopUp.createNewTask();
    }

    /**
     * Display task home.
     */
    @When("^Display Lightning Task Home from home page$")
    public void displayTaskHome() {
        homeLightPage.clickTaskMenuButton();
    }

    /**
     * verify task is displayed.
     */
    @Then("^I verify the task is displayed$")
    public void verifyTaskDisplayed() {
        Assert.assertTrue(taskLightPage.verifySubjectExist(nameTaskSubject));
    }

    /**
     * verify the task was deleted step.
     */
    @Then("^I verify the task was deleted$")
    public void verifyTaskIsNotDisplayed() {
        taskLightPage.clickRecentTasksRefresh();
        Assert.assertFalse(taskLightPage.verifySubjectExist(nameTaskSubject));
    }

    /**
     * I update the subject task step.
     */
    @When("^I update the subject task$")
    public void updateTask() {
        nameTaskSubject = taskLightPage.updateCurrentTask();
    }

    /**
     * delete the task step.
     */
    @When("^I delete the task$")
    public void deletedTask() {
        taskLightPage.deleteCurrentTask();
    }

}
