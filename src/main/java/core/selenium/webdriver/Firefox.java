package core.selenium.webdriver;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements IDriver {

    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver();
    }
}
