package testingUI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testingUI.pages.base.BasePage;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void switchToFrame() {
        WebElement frame = getDriver().findElement(By.id("iframe1"));
        getDriver().switchTo().frame(frame);
    }
}
