package steps;

import core.selenium.WebDriverManager;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.TransporterPage;

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
    @Given("^I sign in to the salesforce Application$")
    public void signIn() {
        loginPage = transporterPage.navigateToLoginPage();
        loginPage.login("mel@fundacion-jala.com", "control123*");
    }

}
