package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class KeyReporterPage extends BasePage {
    public KeyReporterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "keys")
    private WebElement inputField;

    @FindBy(id = "events")
    private WebElement listResults;

    @FindBy(xpath = "//div[@id = 'events']/p[2]")
    private WebElement keypressCode;

    public KeyReporterPage inputSymbol(char symbol) {
        inputField.sendKeys(String.valueOf(symbol));

        return this;
    }

    public int getKeyPressCode() {
        return Integer.parseInt(List.of(keypressCode.getText().split(",")).get(3).split(":")[1].trim());
    }

}

