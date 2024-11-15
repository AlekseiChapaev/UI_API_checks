package testingUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testingUI.pages.base.BaseTest;

public class ActionsTest extends BaseTest {

    private Actions  action;

    private Actions getAction() {
        if (action == null) {
            action = new Actions(getDriver());
        }
        return action;
    }
    @Test
    public void testActions() {
        getDriver().get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement slider = getDriver().findElement(By.name("my-range"));
        getAction()     //here we get an instance of Actions
                .clickAndHold(slider)   //here we tell wat this instance should click and hold slider
                .moveByOffset(-70, 0) // here we set up in which direction and how to move the mouse
                .release()  //here we unpress the mouse
                .perform(); //without this command action doesn't work.

        System.out.println(slider.getAttribute("value"));
        Assert.assertEquals(slider.getAttribute("value"), "3");

    }
}
