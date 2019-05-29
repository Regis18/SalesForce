/*
 * @(#) AccountApi.java Copyright (c) 2019 Jala Foundation.
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
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class AccountApi {
    /**
     * Delete an account by id.
     * @param id String.
     */
    public void deleteAccount(String id) {
        String url = "https://na132.salesforce.com/services/data/v39.0/sobjects/Campaign/"+id;
        String token = "00D4P000000gLN4!AQQAQLo9rpc2CGwwx.rLMs._Boj05m5qZ2OYb3vx.GrY8.tGhYIKxrld4RzWjmrSq2zfq3F0y6CO2P.K.gsHLZyq6VUFX0DD";
        Response response = given().headers("Content-Type", "application/json").
                auth().oauth2(token).when().request("DELETE", url);
    }
}