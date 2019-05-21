package core.selenium.webdriver;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Firefox class.
 */
public class Firefox implements IDriver {

    /**
     * @return WebDriver
     */
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver();
    }
}