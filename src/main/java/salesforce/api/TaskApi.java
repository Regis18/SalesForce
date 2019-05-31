/*
 * @(#) TaskApi.java Copyright (c) 2019 Jala Foundation.
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

package salesforce.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import salesforce.entities.Task;
import salesforce.utils.Setup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * Common Api class.
 *
 * @author Melvi Caballero
 * @version 0.0.1
 */
public class TaskApi {

    /**
     * Delete task with API test.
     */
    public static void deleteTask(final Task task) {
        List<String> taskIds = new ArrayList<>();

        //Get the task.
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("q", "select id from task where subject='" + task.getSubject() + "' ")
                .auth().oauth2(CommonApi.getToken())
                .when().get(Setup.getInstance().getQueryUrl());

        try {
            Object obj = new JSONParser().parse(response.getBody().asString());
            JSONObject jo = (JSONObject) obj;
            // getting records.
            JSONArray records = (JSONArray) jo.get("records");

            Iterator<JSONObject> iterator = records.iterator();
            while (iterator.hasNext()) {
                taskIds.add((String) (iterator.next().get("Id")));
            }

        } catch (Exception e) {

        }
        given().headers("Content-Type", "application/json")
                .auth().oauth2(CommonApi.getToken())
                .when()
                .request("DELETE", Setup.getInstance().getTaskUrl() + taskIds.get(0));
    }

    /**
     * Delete all tasks.
     */
    public static void deleteAllTasks() {
        List<String> taskIds = new ArrayList<>();

        //Gets all the tasks.
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("q", "select id from task")
                .auth().oauth2(CommonApi.getToken())
                .when().get(Setup.getInstance().getQueryUrl());

        try {
            Object obj = new JSONParser().parse(response.getBody().asString());
            JSONObject jo = (JSONObject) obj;
            JSONArray records = (JSONArray) jo.get("records");

            Iterator<JSONObject> iterator = records.iterator();
            while (iterator.hasNext()) {
                taskIds.add((String) (iterator.next().get("Id")));
            }

        } catch (Exception e) {

        }

        for (int i = 0; i < taskIds.size(); i++) {
            given().headers("Content-Type", "application/json")
                    .auth().oauth2(CommonApi.getToken()).when()
                    .request("DELETE", Setup.getInstance().getTaskUrl() + taskIds.get(i));
        }
    }

    /**
     * Create Task with API test.
     */
    public static void createTask(final Task task) {
        Response response = given()
                .contentType(ContentType.JSON)
                .auth().oauth2(CommonApi.getToken())
                .body("{" + "\"Subject\": \"" + task.getSubject() + "\" " + "}")
                .when().post(Setup.getInstance().getTaskUrl());
    }
}
