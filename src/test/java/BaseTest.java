import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private ChromeOptions options = new ChromeOptions();

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void beforeMethod() {
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        getDriver().get("https://www.selenium.dev/selenium/web/");
    }

    @AfterMethod
    public void afterMethod() {
        wait = null;
        driver.quit();
    }

    public WebDriverWait getWait() {
        if(wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        return wait;
    }
}
