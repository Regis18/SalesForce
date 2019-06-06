/*
 * @(#) AccountLightPage.java Copyright (c) 2019 Jala Foundation.
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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import salesforce.entities.Account;
import salesforce.entities.Context;
import salesforce.utils.EntityId;

import static io.restassured.RestAssured.given;

/**
 * AccountApi.
 * @author Luis Guardia.
 * @version 0.0.1
 */
public class AccountApi {

    private String urlBase = "https://na132.salesforce.com/services/data/v39.0/sobjects/Account/";

    /**
     * Delete an account by id.
     * @param id String.
     */
    public void deleteAccount(final String id) {
        String url = urlBase + id;
        Response response = given().headers("Content-Type", "application/json").
                auth().oauth2(CommonApi.getToken()).when().request("DELETE", url);
    }

    /**
     * Delete an account by id.
     * @param id String.
     */
    public static Account getAccount(final String id) {
        Account resultAccount = new Account();
        String urlBase = "https://na132.salesforce.com/services/data/v39.0/sobjects/Account/";
        String url = urlBase + id;
        Response response = given().headers("Content-Type", "application/json").
                auth().oauth2(CommonApi.getToken()).when().request("GET", url);
        try {
            Object obj = new JSONParser().parse(response.getBody().asString());
            JSONObject jo = (JSONObject) obj;
            resultAccount.setName((String)jo.get("Name"));
        } catch (Exception e) {
        }
        return resultAccount;
    }

    /**
     * Create Account with API test.
     */
 /*   Map<String,String> newProject = new HashMap<>();
            newProject.put("name", project.getNameProject());
    Response response = given().headers("X-TrackerToken","fa8b8b2d9fd0a6b5beea1c8e232daa67",
            "Content-Type", "application/json").
            auth().basic("user","pass").
            body(newProject).
            when().
            request("POST", url);

        project.setId(response.body().jsonPath().getInt("id"));*/
    public void createAccount(Account account) {

        Response response = given()
                .headers("Content-Type", "application/json")
                .auth().oauth2(CommonApi.getToken())
                .body("{" + "\"Name\": \"" + account.getName() + "\" }")
                .when().request("POST", urlBase);
        try {

            Object obj = new JSONParser().parse(response.getBody().asString());
            JSONObject jo = (JSONObject) obj;
            account.setId((String)jo.get("id"));
        } catch (Exception e) {
        }
    }
}