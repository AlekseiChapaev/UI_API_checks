package testingUI.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import testingUI.pages.base.BasePage;

public class AlertPage extends BasePage {
    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alert")
    private WebElement simpleAlert;

    @FindBy(id = "empty-alert")
    private WebElement emptyAlert;

    @FindBy(id = "open-page-with-onload-alert")
    private WebElement alertAndReloadPage;

    @FindBy(id = "select")
    private WebElement SelectDropdown;

    @FindBy(id = "slow-alert")
    private WebElement slowAlert;


    Select select;

    public Alert switchToAlertWithText() {
        simpleAlert.click();
        return getDriver().switchTo().alert();
    }

    public Alert switchToAlertWithoutText() {
        emptyAlert.click();
        return getDriver().switchTo().alert();
    }

    public AlertOnNewPagePage clickAlertAppearsOnTheSamePage() {
        alertAndReloadPage.click();
        getDriver().switchTo().alert().accept();

        return new AlertOnNewPagePage(getDriver());
    }

    public Alert setSelect() {
        if(select == null) {
            select = new Select(SelectDropdown);
        }
        select.selectByIndex(2);

        return getDriver().switchTo().alert();
    }

    public Alert switchToSlowAlert() {
        slowAlert.click();
        getWait().until(ExpectedConditions.alertIsPresent());

        return getDriver().switchTo().alert();
    }
}

