package testingUI;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testingUI.pages.base.BaseTest;

public class Actions_DragAndDropTest extends BaseTest {

    @Test
    public void testDragAndDropThroughClickAndHoldAndMoveByOffset() {
        getDriver().get("https://www.selenium.dev/selenium/web/dragAndDropTest.html");
        WebElement test1 = getDriver().findElement(By.id("test1"));

        Point oldLocation = test1.getLocation();
        System.out.println("oldLocation: " + oldLocation);

        final int shiftX = 100;
        final int shiftY = 50;

        new Actions(getDriver())
                .clickAndHold(test1)
                .moveByOffset(100, 50)
                .release()
                .perform();

        Point newLocation = test1.getLocation();
        System.out.println("newLocation: " + newLocation);

        Assert.assertEquals(newLocation.getX(), oldLocation.getX() + shiftX);
        Assert.assertEquals(newLocation.getY(), oldLocation.getY() + shiftY);
    }

    @Test
    public void testDragAndDropBy() {
        getDriver().get("https://www.selenium.dev/selenium/web/dragAndDropTest.html");
        WebElement test1 = getDriver().findElement(By.id("test1"));

        Point oldLocation = test1.getLocation();
        System.out.println("oldLocation: " + oldLocation);

        final int shiftX = 200;
        final int shiftY = 200;

        new Actions(getDriver())
                .dragAndDropBy(test1, shiftX, shiftY)
                .moveByOffset(100, 50)
                .release()
                .perform();

        Point newLocation = test1.getLocation();
        System.out.println("newLocation: " + newLocation);

        Assert.assertEquals(newLocation.getX(), oldLocation.getX() + shiftX);
        Assert.assertEquals(newLocation.getY(), oldLocation.getY() + shiftY);
    }
}
