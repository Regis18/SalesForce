package salesforce.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.BasePage;

public class campaignPage extends BasePage {
    @FindBy(xpath = "//span[@class=\"uiOutputText forceBreadCrumbItem\"]")
    private WebElement campaignTitle;



    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(campaignTitle));
    }
}
