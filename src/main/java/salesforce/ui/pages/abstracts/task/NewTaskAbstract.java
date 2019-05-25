/*
 * @(#) NewTaskAbstract.java Copyright (c) 2019 Jala Foundation.
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

import salesforce.entities.Task;
import salesforce.ui.BasePage;

/**
 * This abstract class is for create a new task.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public abstract class NewTaskAbstract extends BasePage {
    public static final int INT = 100;

//    public String createNewTask(String nameSubject) {
//       // String nameSubject = "Call" + String.valueOf((int) (Math.random() * INT));
//        setSubjectTextBox(nameSubject);
//        setComments("Test task.");
//        clickSaveButton();
//        return nameSubject;
//    }

    /**
     * Create Task.
     * @param task
     * @return string
     */
    public String createNewTask(final Task task) {
        //log.info("Set information of project.");
        setSubjectTextBox(task.getSubject());
        setComments(task.getComment());
        clickSaveButton();
        return task.getSubject();
    }

    /**
     * click save button.
     */
    protected abstract void clickSaveButton();

    /**
     * click saved notification.
     */
    protected abstract void clickCloseNotificationButton();

    /**
     * Fill the text box.
     *
     * @param value the text to set.
     */
    protected abstract void setSubjectTextBox(String value);

    /**
     * Fill the comments.
     *
     * @param value the text to set.
     */
    protected abstract void setComments(String value);

    /**
     * Wait for Page.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
