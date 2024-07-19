package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ClickResultPage extends BasePage {

    public ClickResultPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return getDriver().findElement(By.xpath("//h1")).getText();
    }
}
