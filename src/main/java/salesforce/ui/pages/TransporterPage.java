package salesforce.ui.pages;

import core.selenium.WebDriverManager;
import core.utils.Logs;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import salesforce.ui.pages.lightning.HomeLightPage;
import salesforce.ui.pages.lightning.TaskLightPage;
import salesforce.utils.Setup;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * TrasporterPage. *
 * @author Melvi Caballero
 * @version 0.0.1
 */
public class TransporterPage {
    private static TransporterPage instance;
    /**
     * It creates to follow up the instruction of the class.
     */
     private Logger log = Logs.getInstance().getLog();
    //private String baseURL = Setup.getInstance().urlBasePath;
    private String baseURL = Setup.getInstance().getUrlBasePath();
    private WebDriver driver;

    /**
     * Constructor of page transporter.
     */
    protected TransporterPage() {
        log.info("Initialize the TransporterPage class");
        initialize();
    }

    /**
     * Gets instance of SelectSiteUserConfig.
     *
     * @return the instance or a new instance.
     */
    public static TransporterPage getInstance() {
        if (instance == null) {
            instance = new TransporterPage();
        }
        return instance;
    }

    /**
     * Initializes page transporter.
     */
    private void initialize() {
        log.info("Initialize the webDriver");
        driver = WebDriverManager.getInstance().getWebDriver();
    }

    /**
     * Goes to the given URL.
     *
     * @param url - Site's URL.
     */
    private void goToURL(final String url) {
        try {
            driver.navigate().to(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigate to Login Page.
     *
     * @return New instance of LoginPage.
     */
    public LoginPage navigateToLoginPage() {
        log.info("Navigate in Log in page");
        goToURL(Setup.getInstance().getLoginpath());
        return new LoginPage();
    }

    /**
     * Navigate to Home Page.
     *
     * @return New instance of HomePage.
     */
    public HomeLightPage navigateToHomeLightPage() {
        log.info("Navigate to home page");
        goToURL(baseURL + "/lightning/page/home");
        return new HomeLightPage();
    }

    /**
     * Navigate to Tasks home page.
     *
     * @return New instance of HomePage.
     */
    public TaskLightPage navigateToTasksHomeLightPage() {
        log.info("Navigate to tasks home page");
        goToURL(baseURL + "/lightning/o/Task/home");
        return new TaskLightPage();
    }


}
