package testingUI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testingUI.pages.base.BaseTest;

import static java.sql.DriverManager.getDriver;

public class ColorTest extends BaseTest {

    @Test
    public void testColors() {
        getDriver().get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement colorPicker = getDriver().findElement(By.name("my-colors"));

        System.out.println(colorPicker.getAttribute("value"));
        colorPicker.click();
        new Actions(getDriver())
                .sendKeys(Keys.TAB, Keys.TAB, Keys.TAB)
                .sendKeys("255")
                .sendKeys(Keys.TAB)
                .sendKeys("0")
                .sendKeys(Keys.TAB)
                .sendKeys("0")
                .sendKeys(Keys.TAB)
                .perform();

        final String finalColor = colorPicker.getAttribute("value");
        System.out.println("finalColor: " + finalColor);

        Assert.assertEquals(finalColor, "#ff0000");
    }
}
