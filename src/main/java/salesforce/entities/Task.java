/*
 * @(#) Task.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.entities;

import core.utils.StrategySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * Task entity Task.
 *
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class Task {

    private String subject;
    private String comment;
    private String status;
    private String email;
    private String dueDate;
    private String priority;

    /**
     * Get subject to task.
     *
     * @return subject to task.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Set subject to task.
     *
     * @param subject to task.
     */
    public void setSubject(final String subject) {
        this.subject = subject;
    }

    /**
     * Get comment to task.
     *
     * @return comment to task.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Set comment to task.
     *
     * @param comment to task.
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }

    /**
     * Get status to task.
     *
     * @return status to taask.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set status to task.
     *
     * @param status to task.
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Get email attribute to task.
     *
     * @return email task.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email attribute to task.
     *
     * @param email task.
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Get due date attribute to task.
     *
     * @return date task.
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Set due date attribute to task.
     *
     * @param dueDate to task.
     */
    public void setDueDate(final String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Get priority attribute to task.
     *
     * @return priority to task.
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Set priority attribute to task.
     *
     * @param priority to task.
     */
    public void setPriority(final String priority) {
        this.priority = priority;
    }

    /**
     * Process task information.
     *
     * @param taskMap the task map.
     */
    public void processInformation(final Map<String, String> taskMap) {
        HashMap<String, StrategySetter> strategyMap = composeStrategyMap(taskMap);

        taskMap.keySet().forEach(key -> {
            strategyMap.get(key).executeMethod();
        });
    }

    /**
     * Set the strategy map.
     *
     * @param taskMap the task map.
     * @return Strategy map
     */
    private HashMap<String, StrategySetter> composeStrategyMap(final Map<String, String> taskMap) {
        HashMap<String, StrategySetter> strategyMap = new HashMap<>();
        strategyMap.put("Subject", () -> setSubject(taskMap.get("Subject")));
        strategyMap.put("Comment", () -> setComment(taskMap.get("Comment")));
        strategyMap.put("Status", () -> setStatus(taskMap.get("Status")));
        strategyMap.put("Email", () -> setEmail(taskMap.get("Email")));
        strategyMap.put("DueDate", () -> setDueDate(taskMap.get("DueDate")));
        strategyMap.put("Priority", () -> setPriority(taskMap.get("Priority")));
        return strategyMap;
    }

    /**
     * get strategy map.
     *
     * @return strategyMap
     */
    public HashMap<String, StrategySetter> composeGetStrategyMap() {
        HashMap<String, StrategySetter> strategyMap = new HashMap<>();
        strategyMap.put("Subject", () -> getSubject());
        strategyMap.put("Comment", () -> getComment());
        strategyMap.put("Status", () -> getStatus());
        strategyMap.put("Email", () -> getEmail());
        strategyMap.put("DueDate", () -> getDueDate());
        strategyMap.put("Priority", () -> getPriority());
        return strategyMap;
    }
}
