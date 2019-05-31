package salesforce.utils;

import core.selenium.WebDriverConfig;
import salesforce.entities.Task;

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
    private String apiPath;
    private String token;
    private String client_id;
    private String client_secret;
    private String tokenUrl;
    private String queryUrl;
    private String taskUrl;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    private Task task;

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    public String getQueryUrl() {
        return queryUrl;
    }

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }

    public String getTaskUrl() {
        return taskUrl;
    }

    public void setTaskUrl(String taskUrl) {
        this.taskUrl = taskUrl;
    }

    /**
     *
     * @return
     */
    public String getClient_id() {
        return client_id;
    }

    /**
     *
     * @param client_id
     */
    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    /**
     *
     * @return
     */
    public String getClient_secret() {
        return client_secret;
    }

    /**
     *
     * @param client_secret
     */
    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

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
        return WebDriverConfig.getSkin();
    }

    /**
     * Get urlClassicPath.
     * @return urlClassicPath
     */
    public String getUrlClassicPath() {
        return urlClassicPath;
    }

    /**
     * Gets API path.
     * @return string
     */
    public String getApiPath() {
        return apiPath;
    }

    /**
     * Gets Token.
     * @return string.
     */
    public String getToken() {
        return token;
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
        apiPath = properties.getProperty("apipath");
        layout = WebDriverConfig.getSkin();
        token = properties.getProperty("token");
        client_id = properties.getProperty("client_id");
        client_secret = properties.getProperty("client_secret");
        tokenUrl = properties.getProperty("tokenUrl");
        queryUrl = properties.getProperty("queryUrl");
        taskUrl = properties.getProperty("taskUrl");
    }
}
