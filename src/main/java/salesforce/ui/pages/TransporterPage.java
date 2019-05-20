package salesforce.ui.pages;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Tranporter class.
 */
public class TransporterPage {
    private static TransporterPage instance;
    /**
     * It creates to follow up the instruction of the class.
     */
   // private Logger log = Logs.getInstance().getLog();
    //private String baseURL = Setup.getInstance().urlBasePath;
    private String baseURL = "https://login.salesforce.com/";
    private WebDriver driver;

    /**
     * Constructor of page transporter.
     */
    protected TransporterPage() {
        //log.info("Initialize the TransporterPage class");
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
       // log.info("Initialize the webDriver");
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
       // log.info("Navigate in Log in page");
        goToURL(baseURL);
        return new LoginPage();
    }

//https://na132.lightning.force.com/lightning/page/home
////a[span[contains(text(),"Menú de Tareas")]]
}
