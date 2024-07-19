package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    private final WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        if(wait == null) {
            this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        }

        return wait;
    }
}
