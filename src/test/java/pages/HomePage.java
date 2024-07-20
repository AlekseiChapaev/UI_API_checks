package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class HomePage extends BasePage {

    @FindBy(linkText = "ClickTest_testClicksASurroundingStrongTag.html")
    private WebElement clickTestLink;
    @FindBy(linkText = "ajaxy_page.html")
    private WebElement labelTestLink;
    @FindBy(linkText = "alerts.html")
    private WebElement alertTestLink;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ClickPage goToClickTestPage() {
        getWait().until(ExpectedConditions.elementToBeClickable(clickTestLink)).click();

        return new ClickPage(getDriver());
    }

    public LabelPage goToLabelTestPage() {
        getWait().until(ExpectedConditions.elementToBeClickable(labelTestLink)).click();

        return new LabelPage(getDriver());
    }

    public AlertPage goToAlertTestPage() {
        getWait().until(ExpectedConditions.elementToBeClickable(alertTestLink)).click();

        return new AlertPage(getDriver());
    }
}
