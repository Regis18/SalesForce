package salesforce.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.BasePage;

/**
 * Login page class.
 * @author Melvi Caballero.
 * @version 0.0.1
 */
public class LoginPage extends BasePage {
    /**
     * Locator for user name text box.
     */
    @FindBy(xpath = "//input[@id='username']")
    private WebElement userNameTextBox;
    /**
     * Locator for password text box.
     */
    @FindBy(xpath = "//input[@id='password']")
    private WebElement userPasswordTextBox;
    /**
     * Locator for button Login.
     */
    @FindBy(xpath = "//input[@id=\"Login\"]")
    private WebElement signinButton;

    /**
     * Login need introduce user name and password after click in the button login.
     *
     * @param userName     the user name.
     * @param userPassword the password.
     */
    public void login(final String userName, final String userPassword) {
        setUserNameTextBox(userName);
        setUserPasswordTextBox(userPassword);
        clickOnSigninButton();
    }

    /**
     * Fill the username text box.
     *
     * @param userName the username.
     */
    public void setUserNameTextBox(final String userName) {
        userNameTextBox.sendKeys(userName);
    }

    /**
     * Fill the password text box.
     *
     * @param userPassword the password.
     */
    public void setUserPasswordTextBox(final String userPassword) {
        userPasswordTextBox.sendKeys(userPassword);
    }

    /**
     * Event click on login button.
     */
    public void clickOnSigninButton() {
        signinButton.click();
    }

    /**
     * Wait for userPasswordTextBox
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(userPasswordTextBox));
    }
}
