package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class AlertOnNewPagePage extends BasePage {

    @FindBy(xpath ="//body/p")
    private WebElement pageTest;

    public AlertOnNewPagePage(WebDriver driver) {
        super(driver);
    }

    public String getPageText() {
        return pageTest.getText();
    }
}
