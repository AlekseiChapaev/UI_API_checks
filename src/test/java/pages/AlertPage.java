package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;

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


    Select select;

    public Alert clickAlertWithText() {
        simpleAlert.click();
        return getDriver().switchTo().alert();
    }

    public Alert clickAlertWithoutText() {
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

}

