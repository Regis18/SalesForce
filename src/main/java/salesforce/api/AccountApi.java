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
    public void deleteAccount() {
        String url = "https://na132.salesforce.com/services/data/v39.0/sobjects/Account/0014P000026q11OQAQ";
        String token = "00D4P000000gLN4!AQQAQP.osXGMgRHRMXKObYotXXuzfoVeYhYLlrdiFnp3PAIWExSPhqlKHl0rXm26DN_xFvXXu.sdFwW6Y5DiLhcCaCYLikNn";
        System.out.println(url +"  "+ token);
        Response response = given().headers("Content-Type", "application/json").
                auth().oauth2(token).when().request("DELETE", url);
    }
}
