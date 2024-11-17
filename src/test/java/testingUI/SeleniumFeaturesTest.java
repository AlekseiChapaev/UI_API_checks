package testingUI;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testingUI.pages.HomePage;
import testingUI.pages.base.BaseTest;

import java.util.List;

import static org.testng.Assert.fail;

public class SeleniumFeaturesTest extends BaseTest {

    @Severity(SeverityLevel.MINOR)
    @Test
    public void clickTest() {
        final String headerText = new HomePage(getDriver())
                .goToClickTestPage()
                .clickClickLink()
                .getHeaderText();

        Assert.assertEquals(headerText, "XHTML Might Be The Future");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void labelTextTest() {
        final String labelName = "Label_1";

        final List<String> listLabelNames = new HomePage(getDriver())
                .goToLabelTestPage()
                .fillLabelName(labelName)
                .selectRedColor()
                .clickAddLabelButton()
                .getSetOfLabelName();

        Assert.assertTrue(listLabelNames.contains(labelName));
    }

    @Severity(SeverityLevel.MINOR)
    @Test
    public void labelColorTest() {

        final String labelColor = new HomePage(getDriver())
                .goToLabelTestPage()
                .fillLabelName("name")
                .selectRedColor()
                .clickAddLabelButton()
                .getLabelColor();

        Assert.assertEquals(labelColor, "background-color: red;");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void alertWithTextTest() {
        final Alert alert = new HomePage(getDriver())
                .goToAlertTestPage()
                .switchToAlertWithText();

        Assert.assertEquals(alert.getText(), "cheese");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void alertWithoutTextTest() {
        final Alert alert = new HomePage(getDriver())
                .goToAlertTestPage()
                .switchToAlertWithoutText();

        Assert.assertEquals(alert.getText(), "");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void alertWithNewPageTest() {
        final String pageText = new HomePage(getDriver())
                .goToAlertTestPage()
                .clickAlertAppearsOnTheSamePage()
                .getPageText();

        Assert.assertEquals(pageText, "Page with onload event handler");
    }

    @Test
    public void switchToSlowAlertTest() {
        final Alert alert = new HomePage(getDriver())
                .goToAlertTestPage()
                .switchToSlowAlert();

        Assert.assertEquals(alert.getText(), "Slow");
    }

    @Severity(SeverityLevel.TRIVIAL)
    @Test
    public void selectDropdownAndGetAlertTextTest() {
        final String pageText = new HomePage(getDriver())
                .goToAlertTestPage()
                .setSelect()
                .getText();

        Assert.assertEquals(pageText, "changed");
    }

    @Test
    public void alertDisappearedAfterClickOkButtonOnAlertTest() {
        final Alert alert = new HomePage(getDriver())
                .goToAlertTestPage()
                .switchToAlertWithText();

        alert.accept();

        try {
            getDriver().switchTo().alert();     // we tried to switch to alert. We expect that the issue (NoAlertPresentException) appears here.
                                        // if it happens Java doesn't perform row with fail and go to the catch block
            fail("There is no expected NoAlertPresentException was thrown");  // if our program could switch to alert on previous row
                                        // it means that our test doesn't work (we expected the issue and didn't get it).
                                        // we command Java to fail our test and give a notice that "There is no expected NoAlertPresentException was thrown"
        } catch (NoAlertPresentException e) {
            //pass                              // here we don't perform anything because it was expected app behavior
                                                // So it means that app works as expected and test pass
        }
    }

    @Test
    public void alertWitMessageTest() {
        final String enteredText = "Here is entered text";

        final Alert alert = new HomePage(getDriver())
                .goToAlertTestPage()
                .switchToAlertWithPrompt();

        alert.sendKeys(enteredText); //this notification isn't showed into input field
        alert.accept();

        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@id = 'text']/p")).getText(), enteredText);
    }

    @Test
    public void redirectionToAnotherPageAfterClickOkOnAlertWithConfirmTest() {
        final Alert alert = new HomePage(getDriver())
                .goToAlertTestPage()
                .switchToAlertWithConfirm();

        alert.accept();

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), "Heading");
    }

    @Test
    public void notRedirectionToAnotherPageAfterClickDismissOnAlertWithConfirmTest() {
        final Alert alert = new HomePage(getDriver())
                .goToAlertTestPage()
                .switchToAlertWithConfirm();

        alert.dismiss();

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), "Testing Alerts and Stuff");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void keyReporterTest() {
        final char symbol = 'B';
        final int pressCode =  new HomePage(getDriver())
                .goToKeyReporterPage()
                .inputSymbol(symbol)
                .getKeyPressCode();

        Assert.assertEquals(pressCode, symbol);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void typeStuffTest() {
        final String testWord = "123";
        final int count = new HomePage(getDriver())
                .goToTypingTestLink()
                .fillSymbol(testWord)
                .getCountNotesInBodyResultLine();

        Assert.assertEquals(count, testWord.length());
    }

    @Test
    public void framesTest() {
        getDriver().get("https://www.selenium.dev/selenium/web/iframes.html");
        // in try-catch we're checking that there is no WebElement with id:"email".
        try {
            getDriver().findElement(By.id("email"));
            fail("Unexpected behavior: email field does't exist on that page. It is into a frame");
        } catch(NoSuchElementException e) {
            //test pass
        }
        // here we find iframe and switch to it
        final WebElement currentFrame = getDriver().findElement(By.id("iframe1"));
        getDriver().switchTo().frame(currentFrame);

        final WebElement emailField = getDriver().findElement(By.id("email"));
        Assert.assertEquals(emailField.getTagName(), "input");
    }
}
