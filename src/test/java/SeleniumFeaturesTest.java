import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumFeaturesTest {

    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.selenium.dev/selenium/web/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void clickTest() {
        driver.findElement(By.linkText("ClickTest_testClicksASurroundingStrongTag.html")).click();
        driver.findElement(By.linkText("Click")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "XHTML Might Be The Future");
    }
}
