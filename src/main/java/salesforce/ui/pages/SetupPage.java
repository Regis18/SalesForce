package salesforce.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.BasePage;

public class SetupPage extends BasePage {

    @FindBy(xpath = "//span[@title=\"Setup\"]")
    private WebElement setupTitleLbl;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(setupTitleLbl));
    }
}
