package testingUI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testingUI.pages.base.BasePage;

public class TypingTestPage extends BasePage {

    @FindBy(id = "intext")
    private WebElement inputField;

    @FindBy(id = "body_result")
    private WebElement bodyResultLine;

    public TypingTestPage(WebDriver driver) {
        super(driver);
    }

    public TypingTestPage fillSymbol(String str) {
        inputField.sendKeys(str);

        return this;
    }

    public int getCountNotesInBodyResultLine() {
        return bodyResultLine.getText().trim().split(" ").length;
    }
}
