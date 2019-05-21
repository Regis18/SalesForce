package salesforce.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.BasePage;

/**
 * Home page class.
 */
public class HomePage extends BasePage {


    @FindBy(xpath = "//a[span[contains(text(),\"Tasks Menu\")]]")
    private WebElement taskDropdownButton;

    /**
     * Event click on tasks dropdown.
     */
    public void clickTasksDropDonwButton() {
        taskDropdownButton.click();
    }

    /**
     * display Create task popup.
     */
    public void displayCreateTask() {
        clickTasksDropDonwButton();
    }

    /**
     * Wait for page to load.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(taskDropdownButton));
    }
}
