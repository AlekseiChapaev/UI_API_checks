package testingUI;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testingUI.pages.base.BaseTest;

public class UsingKeysTest extends BaseTest {


    @Test
    public void testArrowKeys() {
        getDriver().get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement slider = getDriver().findElement(By.name("my-range"));
        slider.sendKeys(Keys.RIGHT, Keys.RIGHT);
        slider.sendKeys(Keys.RIGHT);

        Assert.assertEquals(slider.getAttribute("value"), "8");
    }

    @Test
    public void testShiftKeyThroughActions() {
        getDriver().get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement textArea = getDriver().findElement(By.name("my-textarea"));

        new Actions(getDriver())
                .click(textArea)
                .keyDown(Keys.SHIFT)
                .sendKeys("qwerty")
                .keyUp(Keys.SHIFT)
                .perform();

        System.out.println(textArea.getAttribute("value"));
        Assert.assertEquals(textArea.getAttribute("value"), "QWERTY");
    }

}
