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
import salesforce.ui.PageFactory;
import salesforce.ui.pages.abstracts.HomePageAbstract;
import salesforce.ui.pages.abstracts.task.NewTaskAbstract;
import salesforce.ui.pages.TransporterPage;
import salesforce.ui.pages.abstracts.task.TaskPageAbstract;

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
    private TaskPageAbstract taskPage;
    private Context context;
    private Task task;

    public TaskSteps(Task task) {

        this.task = task;
        homePage = PageFactory.homePage();
    }

//    public TaskSteps(Context context) {
//        this.context = context;
//    }

    /**
     * navigate to tasks home page.
     */
    @When("^I navigate to Tasks Homepage$")
    public void navigateToTasksHome() {
        taskPage = transporterPage.navigateToTasksHomePage();
    }


    /**
     * Create task step.
     */
    @When("^I create a new task with this information$")
    public void createTask(Map<String, String> taskMap) {
        task.proccessInformation(taskMap);
        task.setSubject(task.getSubject().replace("<random>",String.valueOf((int)(Math.random()*100))));
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
        Assert.assertTrue(taskPage.verifySubjectExist(task.getSubject()));
    }

    /**
     * verify the task was deleted step.
     */
    @Then("^I verify the task was deleted$")
    public void verifyTaskIsNotDisplayed() {
        taskPage.clickRecentTasksRefresh();
        Assert.assertFalse(taskPage.verifySubjectExist(task.getSubject()));
    }

    /**
     * I update the subject task step.
     */
    @When("^I update the subject task$")
    public void updateTask() {
        task = taskPage.updateCurrentTask(task);
    }

    /**
     * delete the task step.
     */
    @When("^I delete the task$")
    public void deletedTask() {
        taskPage.deleteCurrentTask(task);
    }

}
