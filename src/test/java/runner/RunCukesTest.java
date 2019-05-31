package runner;

import core.selenium.WebDriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;

import static runner.GenerateReport.generateMasterReport;

/**
 * RunCukesTest class.
 */
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"},
        glue = {"steps", "hooks"},
        features = {"src/test/resources/feature/task.feature"},
        monochrome = true)

public class RunCukesTest extends AbstractTestNGCucumberTests {

    /**
     * After Execution.
     */
    @AfterTest
    public void afterExecution() {
        WebDriverManager.getInstance().getWebDriver().close();
        generateMasterReport();
    }
}
