package core.selenium.webdriver;

import core.selenium.WebDriverConfig;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory Browser.
 * @author Regis Humana
 * @version 0.0.1
 */
public final class FactoryBrowser {
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";
    private static WebDriver webDriver;
    private static WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();

    /**
     * Constructor.
     */
    private FactoryBrowser() {

    }

    /**
     * Return the object of the Driver that will use.
     * @return Webdriver.
     */
    public static WebDriver getWebDriver() {
        Map<String, IDriver> strategyBrowser = new HashMap<>();
        strategyBrowser.put(FIREFOX, new Firefox());
        strategyBrowser.put(CHROME, new Chrome());
        return strategyBrowser.get(webDriverConfig.getBrowser().toLowerCase()).initDriver();
    }

}
