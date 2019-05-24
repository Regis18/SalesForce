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
import salesforce.entities.Context;
import salesforce.entities.Task;
import salesforce.ui.pages.abstracts.HomePageAbstract;
import salesforce.ui.pages.abstracts.task.NewTaskAbstract;
import salesforce.ui.pages.TransporterPage;
import salesforce.ui.pages.lightning.task.TaskLightPage;

import java.util.Map;

/**
 * Task steps class.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class TaskSteps {
    private TransporterPage transporterPage = TransporterPage.getInstance();
    private HomePageAbstract homePage;
    private NewTaskAbstract newTaskPage;
    private String nameTaskSubject;
    private TaskLightPage taskPage;
    private Context context;
    private Task task;

    public TaskSteps(Task task) {
        this.task = task;
    }

//    public TaskSteps(Context context) {
//        this.context = context;
//    }
    /**
     * navigate to tasks home page.
     */
    @When("^I navigate to Tasks Homepage$")
    public void navigateToTasksHome() {
        taskPage = TransporterPage.getInstance().navigateToTasksHomeLightPage();
    }


    /**
     * Create task step.
     */
//    @When("^I create a new task in SalesForce$")
//    public void createTask() {
//        homePage = context.getHomePage();
//        newTaskPage = homePage.displayCreateTask();
//        nameTaskSubject = newTaskPage.createNewTask();
//    }

    @When("^I create a new task with this information$")
    public void createTask(Map<String, String> taskMap) {
        task.proccessInformation(taskMap);
        newTaskPage = homePage.displayCreateTask();
        newTaskPage.createNewTask(task);
    }

    /**
     * Display task home.
     */
    @When("^Display Lightning Task Home from home page$")
    public void displayTaskHome() {
//        homePage.clickTaskMenuButton();
    }

    /**
     * verify task is displayed.
     */
    @Then("^I verify the task is displayed$")
    public void verifyTaskDisplayed() {
        Assert.assertTrue(taskPage.verifySubjectExist(nameTaskSubject));
    }

    /**
     * verify the task was deleted step.
     */
    @Then("^I verify the task was deleted$")
    public void verifyTaskIsNotDisplayed() {
        taskPage.clickRecentTasksRefresh();
        Assert.assertFalse(taskPage.verifySubjectExist(nameTaskSubject));
    }

    /**
     * I update the subject task step.
     */
    @When("^I update the subject task$")
    public void updateTask() {
        nameTaskSubject = taskPage.updateCurrentTask();
    }

    /**
     * delete the task step.
     */
    @When("^I delete the task$")
    public void deletedTask() {
        taskPage.deleteCurrentTask();
    }

}
