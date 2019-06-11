package steps;

import core.selenium.WebDriverManager;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import salesforce.entities.Context;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.SetupPage;
import salesforce.ui.pages.TransporterPage;
import salesforce.ui.pages.home.HomePageAbstract;
import salesforce.utils.Setup;


/**
 * Login Steps class.
 */
public class LoginSteps {
    private WebDriver driver = WebDriverManager.getInstance().getWebDriver();
    private TransporterPage transporterPage = TransporterPage.getInstance();
    private LoginPage loginPage;
    private SetupPage setupPage;
    private HomePageAbstract homePage;
    private Context context;

    public LoginSteps(Context context) {
        this.context = context;
    }

    /**
     * Sign in step.
     */
    @Given("^I log in to the Salesforce Application$")
    public void logInToTheSalesforceApplication() {
        if (driver.getTitle().equals("")) {
            loginPage = transporterPage.navigateToLoginPage();
            setupPage = loginPage.login(Setup.getInstance().getUsername(), Setup.getInstance().getPassword());
        }
    }

    @Given("^I navigate to HomePage$")
    public void navigateToHomePage() {
        if (setupPage != null) {
            homePage = transporterPage.navigateToHomePage(setupPage);
        } else {
            homePage = transporterPage.navigateToHomePage();
        }
        context.setHomePage(homePage);
    }

}
