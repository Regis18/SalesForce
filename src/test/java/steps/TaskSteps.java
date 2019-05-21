package steps;

import cucumber.api.java.en.When;
import salesforce.ui.pages.HomePage;
import salesforce.ui.pages.TransporterPage;

/**
 * task steps class.
 */
public class TaskSteps {
    private TransporterPage transporterPage = TransporterPage.getInstance();
    private HomePage homePage;

    /**
     * navigate to home page.
     */
    @When("^I navigate to home page$")
    public void navigateToHome() {
        homePage = TransporterPage.getInstance().navigateToHomePage();
        homePage.clickTasksDropDonwButton();
    }


}
