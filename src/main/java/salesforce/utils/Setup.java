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
    private Task task;
    private String taskAccount;
    private String taskContact;

    public String getTaskAccount() {
        return taskAccount;
    }

    public void setTaskAccount(String taskAccount) {
        this.taskAccount = taskAccount;
    }

    public String getTaskContact() {
        return taskContact;
    }

    public void setTaskContact(String taskContact) {
        this.taskContact = taskContact;
    }

    /**
     * Gets task.
     * @return task value.
     */
    public Task getTask() {
        return task;
    }

    /**
     * Sets task.
     * @param task value.
     */
    public void setTask(final Task task) {
        this.task = task;
    }

    /**
     * Gets token url.
     * @return tokenUrl value.
     */
    public String getTokenUrl() {
        return tokenUrl;
    }

    /**
     * Sets token url.
     * @param tokenUrl value.
     */
    public void setTokenUrl(final String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    /**
     * Gets query url.
     * @return query url value.
     */
    public String getQueryUrl() {
        return queryUrl;
    }

    /**
     * Sets Query Url.
     * @param queryUrl value.
     */
    public void setQueryUrl(final String queryUrl) {
        this.queryUrl = queryUrl;
    }

    /**
     * Gets task url.
     * @return taskUrl value.
     */
    public String getTaskUrl() {
        return taskUrl;
    }

    /**
     * Sets task url.
     * @param taskUrl value.
     */
    public void setTaskUrl(final String taskUrl) {
        this.taskUrl = taskUrl;
    }

    /**
     * Gets client id.
     * @return client_id value.
     */
    public String getClient_id() {
        return client_id;
    }

    /**
     * Sets client id.
     * @param client_id value.
     */
    public void setClient_id(final String client_id) {
        this.client_id = client_id;
    }

    /**
     * Gets client secret.
     * @return client_secret value.
     */
    public String getClient_secret() {
        return client_secret;
    }

    /**
     * Sets client secret.
     * @param client_secret value.
     */
    public void setClient_secret(final String client_secret) {
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
     * Gets base path.
     *
     * @return base path urlBasePath value.
     */
    public String getUrlBasePath() {
        return urlBasePath;
    }

    /**
     * Gets username.
     *
     * @return username value.
     */
    public String getUsername() {
        return username;
    }


    /**
     * It creates to follow up the instruction of the class
     */
    // private Logger log = Logs.getInstance().getLog();

    /**
     * Gets password.
     *
     * @return password value.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets loginPath.
     *
     * @return loginpath value.
     */
    public String getLoginpath() {
        return loginpath;
    }

    /**
     * Gets Layout.
     *
     * @return layout value.
     */
    public String getLayout() {
        return WebDriverConfig.getSkin();
    }

    /**
     * Gets urlClassicPath.
     * @return urlClassicPath value.
     */
    public String getUrlClassicPath() {
        return urlClassicPath;
    }

    /**
     * Gets API path.
     * @return apiPath value.
     */
    public String getApiPath() {
        return apiPath;
    }

    /**
     * Gets Token.
     * @return token value.
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
