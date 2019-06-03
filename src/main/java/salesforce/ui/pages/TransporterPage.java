package salesforce.ui.pages;

import core.selenium.WebDriverManager;
import core.utils.Logs;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import salesforce.ui.pages.task.abstracts.TaskPageAbstract;
import salesforce.ui.PageFactory;
import salesforce.ui.pages.abstracts.HomePageAbstract;
import salesforce.ui.pages.campaign.abstracts.OneCampaignAbstract;
import salesforce.utils.Setup;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * TransporterPage.
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class TransporterPage {
    private static TransporterPage instance;
    private final String CLASSIC = "classic";
    private final String LIGHT = "light";
    private Logger log = Logs.getInstance().getLog();

    private String baseLightURL = Setup.getInstance().getUrlBasePath();
    private String baseClassicURL = Setup.getInstance().getUrlClassicPath();
    private Setup setup = Setup.getInstance();
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
     * @param  setupPage SetupPage.
     * @return New instance of HomePage.
     */
    public HomePageAbstract navigateToHomePage(final SetupPage setupPage) {
        log.info("Navigate in Log in page");
        HomePageAbstract homePage = null;
        switch (setup.getLayout()) {
            case CLASSIC:
                homePage = setupPage.navigateHomeClassic();
                break;
            case LIGHT:
                homePage = setupPage.navigateHomeLight();
                break;
            default:
                break;
        }
        return homePage;
    }

    /**
     * Navigate to Tasks home page.
     *
     * @return New instance of HomePage.
     */
    public TaskPageAbstract navigateToTasksHomePage() {

        switch (setup.getLayout()) {
            case CLASSIC:
                log.info("Navigate to tasks home page classic skin");
                goToURL(baseClassicURL + "/home/home.jsp");
                break;
            case LIGHT:
                log.info("Navigate to tasks home page lightning skin");
                goToURL(baseLightURL + "/lightning/o/Task/home");
                break;
            default:
        }
        return PageFactory.getTaskHomePage();
    }

    /**
     * NavigateToOneCampaign method.
     * @param urlCampaign value.
     * @return PageFactory.getOneCampaignPage.
     */
    public OneCampaignAbstract navigateToOneCampaign(String urlCampaign) {
        switch (setup.getLayout()) {
            case CLASSIC:
                goToURL(baseClassicURL + "/" + urlCampaign);
                break;
            case LIGHT:
                goToURL(baseLightURL + "/lightning/r/Campaign/" + urlCampaign + "/view");
                break;
            default:
                break;
        }
        return PageFactory.getOneCampaignPage();
    }

    /**
     * Navigate to Tasks home page.
     *
     * @return New instance of HomePage.
     */
    public HomePageAbstract navigateToSalesForceHomePage() {

        switch (setup.getLayout()) {
            case CLASSIC:
                goToURL(baseClassicURL + "/home/home.jsp");
                break;
            case LIGHT:
                 goToURL(baseLightURL + "/lightning/page/home");
                break;
            default:
        }
        return PageFactory.getHomePage();
    }
}
