package steps;

import core.selenium.WebDriverManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import salesforce.entities.Context;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.TransporterPage;
import salesforce.ui.pages.abstracts.HomePageAbstract;
import salesforce.utils.Setup;

/**
 * Login Steps class.
 */
public class LoginSteps {
    private WebDriver driver = WebDriverManager.getInstance().getWebDriver();
    private TransporterPage transporterPage = TransporterPage.getInstance();
    private LoginPage loginPage;
    private HomePageAbstract homePage;
    private Context context;

    public LoginSteps(Context context) {
        this.context = context;
    }

    /**
     * Sign in step.
     */
    @Given("^I log in to the SalesForce Application$")
    public void signIn() {
        loginPage = transporterPage.navigateToLoginPage();
        loginPage.login(Setup.getInstance().getUsername(), Setup.getInstance().getPassword());

    }

    @Given("^I navigate to HomePage$")
    public void navigateToHomePage() {
        homePage = transporterPage.navigateToHomePage();
        context.setHomePage(homePage);
    }
}
