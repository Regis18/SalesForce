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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import salesforce.api.TaskApi;
import salesforce.entities.Context;
import salesforce.entities.Task;
import salesforce.ui.PageFactory;
import salesforce.ui.pages.abstracts.HomePageAbstract;
import salesforce.ui.pages.task.abstracts.NewTaskAbstract;
import salesforce.ui.pages.TransporterPage;
import salesforce.ui.pages.task.abstracts.TaskPageAbstract;
import salesforce.utils.Setup;

import java.util.Map;

import static org.testng.Assert.assertTrue;

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
    private TaskPageAbstract taskPage;
    private String nameTaskSubject;
    private Context context;
    private Task task;
    private TaskApi taskApi;

    public TaskSteps(Task task) {

        this.task = task;
        homePage = PageFactory.getHomePage();
    }

    /**
     * navigate to tasks home page.
     */
    @When("^I navigate to Tasks Homepage$")
    public void navigateToTasksHome() {
        try{Thread.sleep(2000);}catch(Exception e){};
        taskPage = transporterPage.navigateToTasksHomePage();
    }

    /**
     * navigate to homepage.
     */
    @Given("^I navigate to Salesforce HomePage$")
    public void navigateToSalesForceHomePage() {
        homePage = transporterPage.navigateToSalesForceHomePage();
    }

    /**
     * Create task step.
     */
    @When("^I create a new Task with this values$")
    public void createTask(Map<String, String> taskMap) {
        task.processInformation(taskMap);
        task.setSubject(task.getSubject().replace("random", String.valueOf((int) (Math.random() * 100))));
        newTaskPage = homePage.displayCreateTask();
        newTaskPage.createNewTask(task);
        Setup.getInstance().setTask(task);
    }

    /**
     * verify task is displayed.
     */
    @Then("^I verify the Task is displayed$")
    public void verifyTaskDisplayed() {
        Assert.assertTrue(taskPage.verifySubjectExist(task.getSubject()));
    }

    /**
     * verify the task was deleted step.
     */
    @Then("^I verify the Task was deleted$")
    public void verifyTaskIsNotDisplayed() {
        taskPage.clickRecentTasksRefresh();
        try{Thread.sleep(2000);}catch(Exception e){};
        Assert.assertFalse(taskPage.verifySubjectExist(task.getSubject()));
    }

    /**
     * I update the subject task step.
     */
    @When("^I update the subject Task$")
    public void updateTask() {
        task = taskPage.updateCurrentTask(Setup.getInstance().getTask());
        Setup.getInstance().setTask(task);
    }

    /**
     * delete the task step.
     */
    @When("^I delete the created Task$")
    public void deletedTask() {
        task=Setup.getInstance().getTask();
        taskPage.deleteCurrentTask(task);
    }

    /**
     * delete the task step.
     */
    @Then("^I logout of the Salesforce Application$")
    public void logoutTask() {
        taskPage = transporterPage.navigateToTasksHomePage();
        taskPage.logout();
    }

    @Then("^I verify a message that confirms the new Task was created is displayed$")
    public void verifyMessageConfirmCreated() {
        assertTrue(newTaskPage.verifyMessage("Task " + task.getSubject() + " was created."));
    }

    @Then("^I verify the page of Task that was created$")
    public void verifyPageTaskWasCreated(){
        Assert.assertTrue(taskPage.verifyTaskWasCreated(task));
    }

    @Then("^I verify new Task using Api$")
    public void verifyTaskApi(){
        Task newTask;
        newTask = TaskApi.getTask(task);
        Assert.assertEquals(newTask.getSubject(), task.getSubject());
    }

}

