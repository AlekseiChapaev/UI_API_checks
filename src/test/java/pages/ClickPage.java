package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ClickPage extends BasePage {

    public ClickPage(WebDriver driver) {
        super(driver);
    }

    public ClickResultPage clickClickLink() {
        getDriver().findElement(By.linkText("Click")).click();
        return new ClickResultPage(getDriver());
    }
}
