package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class AlertOnNewPagePage extends BasePage {
    public AlertOnNewPagePage(WebDriver driver) {
        super(driver);
    }

    public String getPageText() {
        return getDriver().findElement(By.xpath("//body/p")).getText();
    }
}
