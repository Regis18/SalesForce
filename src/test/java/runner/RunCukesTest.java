package runner;

import core.selenium.WebDriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;

/**
 * RunCukesTest class.
 */
@CucumberOptions(
        //plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"},
        glue = {"steps"},
        features = {"src/test/resources/features/account.feature"},
        monochrome = true)
public class RunCukesTest extends AbstractTestNGCucumberTests {
    /**
     * After Execution.
     */
    @AfterTest
    public void afterExecution() {
        WebDriverManager.getInstance().getWebDriver().close();
    }
}