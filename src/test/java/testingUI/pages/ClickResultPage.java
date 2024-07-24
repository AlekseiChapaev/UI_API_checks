package testingUI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testingUI.pages.base.BasePage;

public class ClickResultPage extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement header;

    public ClickResultPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return header.getText();
    }
}
