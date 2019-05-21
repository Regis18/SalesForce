package steps;

import core.selenium.WebDriverManager;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.TransporterPage;
import salesforce.utils.Setup;

/**
 * Login Steps class.
 */
public class LoginSteps {
    private WebDriver driver = WebDriverManager.getInstance().getWebDriver();
    private TransporterPage transporterPage = TransporterPage.getInstance();
    private LoginPage loginPage;

    /**
     * Sign in step.
     */
    @Given("^I log in to the SalesForce Application$")
    public void signIn() {
        loginPage = transporterPage.navigateToLoginPage();
        loginPage.login(Setup.getInstance().getUsername(), Setup.getInstance().getPassword());
    }

}
