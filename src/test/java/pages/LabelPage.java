package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class LabelPage extends BasePage {
    public LabelPage(WebDriver driver) {
        super(driver);
    }

    public LabelPage fillLabelName(String name) {
        getDriver().findElement(By.xpath("//input[@name = 'typer']")).sendKeys(name);

        return this;
    }

    public LabelPage selectRedColor() {
        getDriver().findElement(By.id("red")).click();

        return this;
    }

    public LabelPage clickAddLabelButton() {
        getDriver().findElement(By.xpath("//input[@name = 'submit']")).click();

        return this;
    }

    public String getLabelColor() {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'label']"))).getAttribute("style");
    }

    public String getLabelName() {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'label']"))).getText();
    }
}
