package testingUI;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testingUI.pages.base.BaseTest;

public class UsingKeysTest extends BaseTest {


    @Test
    public void testRange() {
        getDriver().get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement slider = getDriver().findElement(By.name("my-range"));
        slider.sendKeys(Keys.RIGHT, Keys.RIGHT);
        slider.sendKeys(Keys.RIGHT);

        Assert.assertEquals(slider.getAttribute("value"), "8");
    }
}
