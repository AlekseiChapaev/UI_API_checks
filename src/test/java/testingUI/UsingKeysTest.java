package testingUI;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testingUI.pages.base.BaseTest;

public class UsingKeysTest extends BaseTest {


    @Test
    public void testRange() {
        getDriver().get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement range = getDriver().findElement(By.name("my-range"));
        range.sendKeys(Keys.RIGHT, Keys.RIGHT);
        range.sendKeys(Keys.RIGHT);

        Assert.assertEquals(range.getAttribute("value"), "8");
    }
}
