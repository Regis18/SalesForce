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
import org.testng.Assert;
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
    private Task newTask;

    public TaskSteps(Task task) {

        this.task = task;
        homePage = PageFactory.getHomePage();
    }

    /**
     * navigate to tasks home page.
     */
    @When("^I navigate to Tasks Homepage$")
    public void navigateToTasksHome() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        ;
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
        if (newTaskPage == null) {
            newTaskPage = PageFactory.getNewTaskPage();
        }
        task.setSubject(task.getSubject().replace("random", String.valueOf((int) (Math.random() * 100))));

        task.setAccount(Setup.getInstance().getTaskAccount());
        task.setContact(Setup.getInstance().getTaskContact());

        newTaskPage = homePage.displayCreateTask();
        newTaskPage.createNewTask(task);
        Setup.getInstance().setTask(task);
    }

    @Given("^I have a Task with this values$")
    public void getTaskWithValues(Map<String, String> taskMap) {
        task.processInformation(taskMap);
        task.setSubject(task.getSubject().replace("random", String.valueOf((int) (Math.random() * 100))));
        TaskApi.createTask(task);
        Setup.getInstance().setTask(task);
    }

    /**
     * verify task is displayed.
     */
    @Then("^I verify the Task subject is displayed in Tasks Homepage$")
    public void verifyTaskDisplayed() {
        Assert.assertTrue(taskPage.verifySubjectExist(task.getSubject()));
    }

    /**
     * verify the task was deleted step.
     */
    @Then("^I verify the Task was removed form Task section$")
    public void verifyTaskIsNotDisplayed() {
        taskPage.clickRecentTasksRefresh();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        ;
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
    @When("^I delete the Task$")
    public void deletedTask() {
        task = Setup.getInstance().getTask();
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

    @Then("^I verify a message that confirms the new Task was \"([^\"]*)\" is displayed$")
    public void verifyMessageConfirmCreated(String taskCreated) {
        if (newTaskPage == null) {
            newTaskPage = PageFactory.getNewTaskPage();
        }
        if (taskCreated.equals("created")) {
            assertTrue(newTaskPage.verifyMessage("Task " + task.getSubject() + " was created."));
        }
        if (taskCreated.equals("updated")) {
            assertTrue(newTaskPage.verifyMessage("Task " + task.getSubject() + " was updated."));
        }
        if (taskCreated.equals("deleted")) {
            assertTrue(newTaskPage.verifyMessage("Task \"" + task.getSubject() + "\" was deleted."));
        }
    }

    @When("^I open the Task details page from Tasks Homepage$")
    public void openTaskDetails() {
        taskPage.verifyTaskValues(task);
    }

    @Then("^I verify the Task values are displayed in Task details page$")
    public void verifyPageTaskWasCreated() {
        Assert.assertTrue(taskPage.verifyTaskWasCreated(task));
    }

    @When("^I perform a get request for the Task by API$")
    public void getRequestTaskApi() {
        newTask = TaskApi.getTask(task);
    }

    @Then("^I verify the task response contains the Task values$")
    public void verifyTaskApi() {
        Boolean correct = true;
        if (!newTask.getSubject().equals(task.getSubject())) {
            correct = false;
        } else if (!newTask.getComment().equals(task.getComment())) {
            correct = false;
        } else if (!newTask.getPriority().equals(task.getPriority())) {
            correct = false;
        } else if (!newTask.getStatus().equals(task.getStatus())) {
            correct = false;
        }
        Assert.assertTrue(correct);
    }


}