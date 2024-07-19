package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class AlertPage extends BasePage {
    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public Alert clickAlertWithText() {
        getDriver().findElement(By.id("alert")).click();

        return getDriver().switchTo().alert();
    }

    public Alert clickAlertWithoutText() {
        getDriver().findElement(By.id("empty-alert")).click();

        return getDriver().switchTo().alert();
    }
}

