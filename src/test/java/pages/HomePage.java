package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ClickPage goToClickTest() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.linkText("ClickTest_testClicksASurroundingStrongTag.html"))).click();

        return new ClickPage(getDriver());
    }

    public LabelPage goToLabelTest() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.linkText("ajaxy_page.html"))).click();

        return new LabelPage(getDriver());
    }
}
