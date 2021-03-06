/*
 * @(#) TaskPageAbstract.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.ui.pages.task.abstracts;

import salesforce.entities.Task;
import salesforce.ui.BasePage;

/**
 * This abstract class is for delete and update a task.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public abstract class TaskPageAbstract extends BasePage {

    /**
     * Verify subject task exist.
     * @param subjectTask subject Task.
     * @return boolean
     */
    public abstract boolean verifySubjectExist(String subjectTask);

    /**
     * Verify task is created.
     *
     * @param task the task.
     * @return if successful
     */
    public abstract boolean verifyTaskWasCreated(final Task task);

    /**
     * Edit a current task.
     * @param task information.
     * @return task information.
     */
    public abstract Task editCurrentTask(final Task task);

    /**
     * Click recent refresh.
     */
    public abstract void clickRecentTasksRefresh();

    /**
     * Delete current task.
     * @param task task
     */
    public abstract void deleteCurrentTask(Task task);

    /**
     * Update current task.
     * @param task task
     * @return updated task
     */
    public abstract Task updateCurrentTask(Task task);

    /**
     * Verifies task values.
     * @param task object.
     */
    public abstract void verifyTaskValues(Task task);

    /**
     * Logout.
     */
    public abstract void logout();


    /**
     * Wait for load.
     */
    @Override
    public abstract void waitUntilPageObjectIsLoaded();
}
