import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class Utils {

    private final WebDriver driver = new ChromeDriver(new ChromeOptions());

    public WebDriver getDriver() {
        return driver;
    }
}
