package runner;

import core.selenium.WebDriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;

import java.io.File;


@CucumberOptions(
        //plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        plugin = {"pretty", "html:target/cucumbe-html-report", "json:target/cucumber.json"},
        glue={"steps"},
        features = {"src/test/resources/features/account.feature"},
        monochrome = true)

public class RunCukesTest extends AbstractTestNGCucumberTests {

    @AfterTest
    public void afterExecution() {
        WebDriverManager.getInstance().getWebDriver().close();
    }
}
