package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

import java.util.List;

public class LabelPage extends BasePage {
    public LabelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name = 'typer']")
    private WebElement labelNameInputField;

    @FindBy(id = "red")
    private WebElement radioButtonRedColor;

    @FindBy(xpath = "//input[@name = 'submit']")
    private WebElement addLabelButton;

    @FindBy(xpath = "//div[@class = 'label']")
    private WebElement listLabels;


    public LabelPage fillLabelName(String name) {
        labelNameInputField.sendKeys(name);

        return this;
    }

    public LabelPage selectRedColor() {
        radioButtonRedColor.click();

        return this;
    }

    public LabelPage clickAddLabelButton() {
        addLabelButton.click();

        return this;
    }

    public String getLabelColor() {
        return getWait().until(ExpectedConditions.visibilityOf(listLabels)).getAttribute("style");
    }

    public List<String> getSetOfLabelName() {

        return getWait().until(ExpectedConditions.visibilityOfAllElements(listLabels))
                .stream()
                .map(WebElement::getText)
                .toList();
    }
}
