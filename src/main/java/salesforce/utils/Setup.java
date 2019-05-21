package salesforce.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Setup class.
 */
public class Setup {
    private static Setup instance;
    private String urlBasePath;
    private String username;
    private String password;
    private String loginpath;

    /**
     * Constructor of page WebDriverManager.
     */
    protected Setup() {
        initialize();
    }

    /**
     * Constructor of Setup.
     * Gets Setup as Singleton.
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

        urlBasePath = properties.getProperty("basepath");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        loginpath = properties.getProperty("loginpath");
    }
}
