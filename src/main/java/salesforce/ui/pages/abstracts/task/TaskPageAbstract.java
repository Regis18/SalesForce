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

package salesforce.ui.pages.abstracts.task;

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
    public abstract boolean verifySubjectExist(final String subjectTask);

    /**
     * Click recent refresh.
     */
    public abstract void clickRecentTasksRefresh();

    /**
     * Delete current task.
     */
    public abstract void deleteCurrentTask();

    /**
     * Update current task.
     *
     * @return new subject.
     */
    public abstract String updateCurrentTask();

    /**
     * Wait for load.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
