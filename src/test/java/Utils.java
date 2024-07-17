import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Utils {

    private final WebDriver driver = new ChromeDriver(new ChromeOptions());
    private WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        if(wait == null) {
            return new WebDriverWait(driver, Duration.ofSeconds(5));
        }
        return wait;
    }


}
