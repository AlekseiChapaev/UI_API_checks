package testingUI;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testingUI.pages.base.BaseTest;

public class DimensionTest extends BaseTest {

    @Test
    public void testThroughDimension() {
        getDriver().get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement slider = getDriver().findElement(By.name("my-range"));

        final Dimension size = slider.getSize();
        final int sliderHeight = size.getHeight();
        final int sliderWidth = size.getWidth();

        System.out.println(size);

        new Actions(getDriver())
                .moveToElement(slider)
                .moveByOffset(sliderWidth * 2/5, 0)
                .click()
                .perform();

        System.out.println(slider.getAttribute("value"));
        Assert.assertEquals(slider.getAttribute("value"), "9");
    }


}
