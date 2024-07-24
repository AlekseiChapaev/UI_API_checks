package testingUI.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private WebDriver driver;
    private final ChromeOptions options = new ChromeOptions();

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void beforeMethod() {
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        getDriver().get("https://www.selenium.dev/selenium/web/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
