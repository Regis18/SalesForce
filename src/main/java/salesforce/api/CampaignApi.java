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

    private final String apiPath = Setup.getInstance().getApiPath();
    private final String delete = "delete";
    private final String get = "get";
    private final String post = "post";
    private String url;

    /**
     * Deletes a campaign by id.
     *
     * @param id String.
     */
    public void deleteCampaign(final String id) {
        url = apiPath + "Campaign/" + id;
        Response response = given().headers("Content-Type", "application/json")
                .auth().oauth2(CommonApi.getToken())
                .when()
                .request(delete, url);
    }

    /**
     * Gets all campaigns.
     */
    public void getCampaigns() {
        url = apiPath + "Campaign";
        Response response = given().headers("Content-Type", "application/json")
                .auth().oauth2(CommonApi.getToken())
                .when()
                .request(get, url);
    }

    /**
     * Get the campaign.
     * @param id string
     * @return JsonPath.
     */
    public JsonPath getCampaignById(final String id) {
        url = apiPath + "Campaign/" + id;
        Response response = given().headers("Content-Type", "application/json")
                .auth().oauth2(CommonApi.getToken())
                .when()
                .request(get, url);
        return response.body().jsonPath();
    }

    /**
     * Create a Campaign from API.
     * @param newCampaign Map.
     * @return JsonPath.
     */
    public JsonPath createCampaign(final Map<String, String> newCampaign) {
        url = apiPath + "Campaign";
        Response response = given().headers("Content-Type", "application/json")
                .auth().oauth2(CommonApi.getToken())
                .body(newCampaign)
                .when()
                .request(post, url);
        return response.body().jsonPath();
    }
}
