package core.selenium;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class to manage the config of web driver.
 * @author Regis Humana
 * @version 0.0.1
 */
public class WebDriverConfig {

    private static final String BROWSER = "browser";
    private static final String SKIN = "style";
    private static WebDriverConfig instance;
    private static String browser;
    private static String view;
    private static String style;
    private int implicitWaitTime;
    private int explicitWaitTime;
    private int waitSleepTime;
    private Properties prop = new Properties();
    private InputStream input = null;

    /**
     * Constructor of WebDriverConfig.
     * Gets WebDriverConfig as Singleton.
     *
     * @return a instance.
     */
    public static WebDriverConfig getInstance() {
        if (instance == null) {
            instance = new WebDriverConfig();
        }
        return instance;
    }

    /**
     * Initializes WebDriverConfig.
     */
    public void initialize() {
        try {
            input = new FileInputStream("gradle.properties");
            prop.load(input);
        } catch (IOException event) {
            event.printStackTrace();
        }
        browser = System.getProperty(BROWSER) != null ? System.getProperty(BROWSER) : prop.getProperty(BROWSER);
        style = System.getProperty(SKIN) != null ? System.getProperty(SKIN) : prop.getProperty(SKIN);
        String urlJson = "./waitTime.json";
        JsonParser parser = new JsonParser();
        FileReader reader;
        JsonElement json;
        try {
            reader = new FileReader(urlJson);
            json = parser.parse(reader);
            implicitWaitTime = Integer.parseInt(json.getAsJsonObject().get("implicitWaitTime").getAsString());
            explicitWaitTime = Integer.parseInt(json.getAsJsonObject().get("explicitWaitTime").getAsString());
            waitSleepTime = Integer.parseInt(json.getAsJsonObject().get("waitSleepTime").getAsString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Gets the browser in which the tests are being executed.
     *
     * @return Browser.
     */
    public static String getBrowser() {
        return browser;
    }

    /**
     * Gets the implicit wait time set for the WebDriver.
     *
     * @return The implicit time.
     */
    public int getImplicitWaitTime() {
        return implicitWaitTime;
    }

    /**
     * Gets the explicit wait time set for the WebDriver.
     *
     * @return The explicit time.
     */
    public int getExplicitWaitTime() {
        return explicitWaitTime;
    }

    /**
     * Gets the sleep time wait set for the WebDriver.
     *
     * @return Sleep time wait.
     */
    public int getWaitSleepTime() {
        return waitSleepTime;
    }

    /**
     * Gets layout.
     * @return layout.
     */
    public static String getSkin() {
      return style;
   }

}
