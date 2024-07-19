package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;

public class AlertPage extends BasePage {
    public AlertPage(WebDriver driver) {
        super(driver);
    }

    Select select = new Select(getDriver().findElement(By.id("select")));

    public Alert clickAlertWithText() {
        getDriver().findElement(By.id("alert")).click();

        return getDriver().switchTo().alert();
    }

    public Alert clickAlertWithoutText() {
        getDriver().findElement(By.id("empty-alert")).click();

        return getDriver().switchTo().alert();
    }

    public AlertOnNewPagePage clickAlertAppearsOnTheSamePage() {
        getDriver().findElement(By.id("open-page-with-onload-alert")).click();
        getDriver().switchTo().alert().accept();

        return new AlertOnNewPagePage(getDriver());
    }

    public Alert setSelect() {
        select.selectByIndex(2);

        return getDriver().switchTo().alert();
    }

}

