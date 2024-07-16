import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumFeaturesTest extends BaseTest {

    @Test
    public void clickTest() {
        getDriver().findElement(By.linkText("ClickTest_testClicksASurroundingStrongTag.html")).click();
        getDriver().findElement(By.linkText("Click")).click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), "XHTML Might Be The Future");
    }
}
