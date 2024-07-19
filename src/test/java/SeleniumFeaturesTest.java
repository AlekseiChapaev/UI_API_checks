import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumFeaturesTest extends BaseTest {

    @Test
    public void clickTest() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.linkText("ClickTest_testClicksASurroundingStrongTag.html"))).click();
        getDriver().findElement(By.linkText("Click")).click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), "XHTML Might Be The Future");
    }

    @Test
    public void labelTest() {
        final String text1 = "Label_1";

        getWait().until(ExpectedConditions.presenceOfElementLocated(By.linkText("ajaxy_page.html"))).click();
        getDriver().findElement(By.xpath("//input[@name = 'typer']")).sendKeys(text1);
        getDriver().findElement(By.id("red")).click();
        getDriver().findElement(By.xpath("//input[@name = 'submit']")).click();

        WebElement label_1 = getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'label']")));
        Assert.assertEquals(label_1.getText(), text1);
        Assert.assertEquals(label_1.getAttribute("style"), "background-color: red;");
    }
}
