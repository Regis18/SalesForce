/*
 * @(#) CampaignApi.java Copyright (c) 2019 Jala Foundation.
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

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import salesforce.utils.Setup;

import java.util.Map;

import static io.restassured.RestAssured.given;


/**
 * CampaignApi.
 *
 * @author Regis Humana.
 * @version 0.0.1
 */
public class CampaignApi {

    private final String API_PATH = Setup.getInstance().getApiPath();
    private final String DELETE = "DELETE";
    private final String GET = "GET";
    private final String POST = "POST";
    private final String PUT = "PUT";
    private String url;

    /**
     * Deletes a campaign by id.
     *
     * @param id String.
     */
    public void deleteCampaign(String id) {
        url = API_PATH + "Campaign/" + id;
        Response response = given().headers("Content-Type", "application/json")
                .auth().oauth2(CommonApi.getToken())
                .when()
                .request(DELETE, url);
    }

    /**
     * Gets all campaigns.
     */
    public void getCampaigns() {
        url = API_PATH + "Campaign";
        Response response = given().headers("Content-Type", "application/json")
                .auth().oauth2(CommonApi.getToken())
                .when()
                .request(GET, url);
    }

    /**
     * Get the campaign
     * @param id string
     */
    public JsonPath getCampaignById(final String id) {
        url = API_PATH + "Campaign/" + id;
        Response response = given().headers("Content-Type", "application/json")
                .auth().oauth2(CommonApi.getToken())
                .when()
                .request(GET, url);
        return response.body().jsonPath();
    }

    /**
     * Create a Campaign from API.
     * @param newCampaign Map.
     * @return JsonPath.
     */
    public JsonPath createCampaign(Map<String, String> newCampaign) {
        url = API_PATH + "Campaign";
        Response response = given().headers("Content-Type", "application/json")
                .auth().oauth2(CommonApi.getToken())
                .body(newCampaign)
                .when()
                .request(POST, url);
        return response.body().jsonPath();
    }
}
