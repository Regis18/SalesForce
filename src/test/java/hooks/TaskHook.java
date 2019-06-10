/*
 * @(#) TaskHook.java Copyright (c) 2019 Jala Foundation.
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

package hooks;

import core.utils.Logs;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import salesforce.api.CampaignApi;
import salesforce.api.TaskApi;
import salesforce.entities.Context;
import salesforce.entities.Task;
import salesforce.ui.pages.TransporterPage;
import salesforce.utils.Setup;

/**
 * Task Hook.
 *
 * @author Melvi Caballero
 * @version 0.0.1
 */
public class TaskHook {
    private WebDriver driver;
    private Logger logs = Logs.getInstance().getLog();

    /**
     * Delete all Tasks.
     */
    @Before("@deleteAllTask")
    public void deleteNewAccount() {
        TaskApi.deleteAllTasks();

    }

    @Before("@createTask")
    public void createNewTask() {
        Task task = new Task();
        task.setSubject("callTask_" + String.valueOf((int) (Math.random() * 100)));
        TaskApi.createTask(task);
        Setup.getInstance().setTask(task);
    }

    @After("@deleteTask")
    public void deleteTask(){
        TaskApi.deleteTask(Setup.getInstance().getTask());
    }

    @Before("@createAccountForTask")
    public void createAccountForTask() {
       String name = "accountForTask" + String.valueOf((int) (Math.random() * 100));
        TaskApi.createAccount(name);
        Setup.getInstance().setTaskAccount(name);
    }

    @Before("@createContactForTask")
    public void createContactForTask() {
        String lastName = "contactForTask" + String.valueOf((int) (Math.random() * 100));
        TaskApi.createContact(lastName);
        Setup.getInstance().setTaskContact(lastName);
    }

    @After("@deleteAccount")
    public void deleteAccount() {
        TaskApi.deleteAccount(Setup.getInstance().getTaskAccount());
    }

    @After("@deleteContact")
    public void deleteContact() {
        TaskApi.deleteContact(Setup.getInstance().getTaskContact());
    }
}
