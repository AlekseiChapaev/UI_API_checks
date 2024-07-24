package testingUI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testingUI.pages.base.BasePage;

public class ClickPage extends BasePage {

    @FindBy(linkText = "Click")
    private WebElement clickLink;

    public ClickPage(WebDriver driver) {
        super(driver);
    }

    public ClickResultPage clickClickLink() {
        clickLink.click();
        return new ClickResultPage(getDriver());
    }
}
