package salesforce.ui;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Yesica on 06/05/2019.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Initializes the web driver, wait and web elements.
     */
    public BasePage() {
        this.driver = WebDriverManager.getInstance().getWebDriver();
        this.wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }


    /**
     * Waits until page object is loaded.
     */
    public abstract void waitUntilPageObjectIsLoaded();

}
