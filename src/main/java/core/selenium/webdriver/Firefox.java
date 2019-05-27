package core.selenium.webdriver;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;

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

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setAcceptUntrustedCertificates(true);
        firefoxProfile.setAssumeUntrustedCertificateIssuer(false);

        //set download folder
        String path = "F:\\Yesica\\fundacion\\webdriver";
        File file = new File(path);
        // Instructing firefox to use custom download location
        firefoxProfile.setPreference("browser.download.folderList", 2);
        // Setting custom download directory
        firefoxProfile.setPreference("browser.download.dir", file.getAbsolutePath());
        // Skipping Save As dialog box for types of files with their MIME
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/java-archive, application/x-msexcel," +
                "application/excel,application/vnd.openxmlformats-officedocument" +
                ".wordprocessingml.document,application/x-excel,application/vnd.ms-excel," +
                "image/png,image/jpeg,text/html,text/plain,application/msword,application/xml," +
                "application/vnd.microsoft.portable-executable");

        firefoxProfile.setPreference("browser.urlbar.showPopup", true);
        firefoxProfile.setPreference("dom. popup_allowed_events", "change click dblclick mouseup pointerup " +
                                    "notificationclick reset submit touchend");

        firefoxOptions.setProfile(firefoxProfile);

        //Use to ignore ssl errors
        firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        return new FirefoxDriver(firefoxOptions);

    }
}
