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

/**
 * Common Api class.
 *
 * @author Melvi Caballero
 * @version 0.0.1
 */
public class CommonApi {
    public static final int STATUSCODE = 200;

    /**
     * Gets token for API test.
     *
     * @return token
     */
    public static String getToken() {
        String token;
        String grantType = "password";
        String user = Setup.getInstance().getUsername();
        String password = Setup.getInstance().getPassword();
        String clientId = Setup.getInstance().getClientId();
        String clientSecret = Setup.getInstance().getClientSecret();

        token = given().headers("Content-Type", "application/json")
                .queryParam("grantType", grantType)
                .queryParam("userName", user)
                .queryParam("password", password)
                .queryParam("clientId", clientId)
                .queryParam("clientSecret", clientSecret)
                .when().post(Setup.getInstance().getTokenUrl()).then()
                .statusCode(STATUSCODE)
                .extract().path("access_token");

        return token;
    }
}
