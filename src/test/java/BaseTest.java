import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest extends Utils {

    @BeforeMethod
    public void beforeMethod() {
        getDriver().get("https://www.selenium.dev/selenium/web/");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterMethod
    public void afterMethod() {
        getDriver().quit();
    }
}
