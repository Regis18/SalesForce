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
    public void deleteAccount(String id) {
        String url = "https://na132.salesforce.com/services/data/v39.0/sobjects/Account/"+id;
        String token = "00D4P000000gLN4!AQQAQPHZ51eqO2c4wR5RVWKdgJpWy6UFC4MUYqF82WBSrJEjqO5qdeOs.5TwEUIGa.1aAXLbD4XSrXPEWiAALpp9FxAncVUp";
        System.out.println(url +"  "+ token);
        Response response = given().headers("Content-Type", "application/json").
                auth().oauth2(token).when().request("DELETE", url);
    }

    public static AccountApi getInstance() {
        return new AccountApi();
    }
}
