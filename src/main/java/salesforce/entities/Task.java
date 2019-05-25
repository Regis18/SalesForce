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

import core.StrategySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * Task.
 */
public class Task {

    private String subject;
    private String comment;

    /**
     *
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @param subject subject.
     */
    public void setSubject(final String subject) {
        this.subject = subject;
    }

    /**
     *
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment comment.
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }

//    private String status;
//    private String email;
//    private String dueDate;
//    private String priority;
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getDueDate() {
//        return dueDate;
//    }
//
//    public void setDueDate(String dueDate) {
//        this.dueDate = dueDate;
//    }
//
//    public String getPriority() {
//        return priority;
//    }
//
//    public void setPriority(String priority) {
//        this.priority = priority;
//    }

    /**
     *
     * @param taskMap the task map.
     */
    public void proccessInformation(final Map<String, String> taskMap) {
        HashMap<String, StrategySetter> strategyMap = composeStrategyMap(taskMap);

        taskMap.keySet().forEach(key -> {
            strategyMap.get(key).executeMethod();
        });
    }

    /**
     * @param taskMap the task map.
     * @return setters
     */
    private HashMap<String, StrategySetter> composeStrategyMap(final Map<String, String> taskMap) {
        HashMap<String, StrategySetter> strategyMap = new HashMap<>();
        strategyMap.put("subject", () -> setSubject(taskMap.get("subject")));
        strategyMap.put("comment", () -> setComment(taskMap.get("comment")));
//        strategyMap.put("status",()->setStatus(taskMap.get(status)));
//        strategyMap.put("email",()->setStatus(taskMap.get(email)));
//        strategyMap.put("dueDate",()->setStatus(taskMap.get(dueDate)));
//        strategyMap.put("priority",()->setStatus(taskMap.get(priority)));
        return strategyMap;
    }
}
