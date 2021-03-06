/*
 * @(#) GenerateReport.java Copyright (c) 2019 Jala Foundation.
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

package runner;


import core.selenium.WebDriverConfig;
import core.utils.Logs;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * GenerateReport.
 * @author Regis Humana
 * @version 0.0.1
 */
public class GenerateReport {

    private static Logger logs = Logs.getInstance().getLog();

    /**
     * Generate report of the test.
     */
    public static void generateMasterReport() {
        logs.info("The user is logging in to the application Salesforce");
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add(new File("").getAbsolutePath() + "\\target\\cucumber.json");

        String buildNumber = "1";
        String projectName = "Salesforce";
        boolean runWithJenkins = false;

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setRunWithJenkins(runWithJenkins);
        configuration.setBuildNumber(buildNumber);
        // additional metadata presented on main page
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", WebDriverConfig.getBrowser());
        configuration.addClassifications("Style", WebDriverConfig.getSkin());
        configuration.addClassifications("Branch", "release/1.0");


        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
// and here validate 'result' to decide what to do if report has failed
    }
}
