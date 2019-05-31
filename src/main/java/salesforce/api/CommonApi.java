/*
 * @(#) CommonApi.java Copyright (c) 2019 Jala Foundation.
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

import salesforce.utils.Setup;

import static io.restassured.RestAssured.given;

public class CommonApi {


    /**
     * Get token.
     * @return token
     */
    public static String GetToken() {
        String token;
        String grant_type = "password";
        String user = Setup.getInstance().getUsername();
        String password = Setup.getInstance().getPassword();
        String client_id = Setup.getInstance().getClient_id();
        String client_secret = Setup.getInstance().getClient_secret();

        token = given().headers("Content-Type", "application/json")
                .queryParam("grant_type", grant_type)
                .queryParam("username", user)
                .queryParam("password", password)
                .queryParam("client_id", client_id)
                .queryParam("client_secret", client_secret)
                .when().post(Setup.getInstance().getTokenUrl()).then()
                .statusCode(200)
                .extract().path("access_token");

        return token;
    }
}
