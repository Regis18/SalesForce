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
public final class WebDriverFactory {
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";
    private static final String EXPLORER = "explorer";
    private static WebDriver webDriver;
    private static WebDriverConfig webDriverConfig = WebDriverConfig.getInstance();

    /**
     * Constructor.
     */
    private WebDriverFactory() {

    }

    /**
     * Return the object of the Driver that will use.
     * @return Webdriver.
     */
    public static WebDriver getWebDriver() {
        Map<String, IDriver> strategyBrowser = new HashMap<>();
        strategyBrowser.put(FIREFOX, new Firefox());
        strategyBrowser.put(CHROME, new Chrome());
        strategyBrowser.put(EXPLORER, new InternetExplorer());
        return strategyBrowser.get(webDriverConfig.getBrowser().toLowerCase()).initDriver();
    }

}
