package core.selenium.webdriver;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Firefox class.
 * @author Regis Humana
 * @version 0.0.1
 */
public class Firefox implements IDriver {

    /**
     * Init the driver of Firefox.
     * @return WebDriver.
     */
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver();
    }
}
