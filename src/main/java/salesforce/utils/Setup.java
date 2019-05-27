package salesforce.utils;

import core.selenium.WebDriverConfig;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * SetupPage class.
 */
public class Setup {
    private static Setup instance;
    private String urlBasePath;
    private String username;
    private String password;
    private String loginpath;
    private String layout;
    private String urlClassicPath;

    /**
     * Constructor of page WebDriverManager.
     */
    protected Setup() {
        initialize();
    }

    /**
     * Constructor of SetupPage.
     * Gets SetupPage as Singleton.
     *
     * @return a instance.
     */
    public static Setup getInstance() {
        if (instance == null) {
            instance = new Setup();
        }
        return instance;
    }

    /**
     * get base path.
     *
     * @return base path
     */
    public String getUrlBasePath() {
        return urlBasePath;
    }

    /**
     * get username.
     *
     * @return user name
     */
    public String getUsername() {
        return username;
    }


    /**
     * It creates to follow up the instruction of the class
     */
    // private Logger log = Logs.getInstance().getLog();

    /**
     * get password.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * get loginPath.
     *
     * @return loginpath
     */
    public String getLoginpath() {
        return loginpath;
    }

    /**
     * Get Layout.
     *
     * @return layout
     */
    public String getLayout() {
        return layout;
    }

    /**
     * Get urlClassicPath.
     * @return urlClassicPath
     */
    public String getUrlClassicPath() {
        return urlClassicPath;
    }

    /**
     * Initialize.
     */
    private void initialize() {
        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream("environment.properties");
            properties.load(in);
            in.close();
        } catch (Exception e) {
//            log.info(e.getMessage());
            e.printStackTrace();
        }
        urlClassicPath = properties.getProperty("classicpath");
        urlBasePath = properties.getProperty("basepath");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        loginpath = properties.getProperty("loginpath");
        layout = WebDriverConfig.getSkin();
    }
}
