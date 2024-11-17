package testingUI;

import io.qameta.allure.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
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
        String headerText = new HomePage(getDriver())
                .goToClickTestPage()
                .clickClickLink()
                .getHeaderText();

        Assert.assertEquals(headerText, "XHTML Might Be The Future");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void labelTextTest() {
        final String labelName = "Label_1";

        List<String> listLabelNames = new HomePage(getDriver())
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

        String labelColor = new HomePage(getDriver())
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
        String pageText = new HomePage(getDriver())
                .goToAlertTestPage()
                .clickAlertAppearsOnTheSamePage()
                .getPageText();

        Assert.assertEquals(pageText, "Page with onload event handler");
    }

    @Test
    public void switchToSlowAlertTest() {
        Alert alert = new HomePage(getDriver())
                .goToAlertTestPage()
                .switchToSlowAlert();

        Assert.assertEquals(alert.getText(), "Slow");
    }

    @Severity(SeverityLevel.TRIVIAL)
    @Test
    public void selectDropdownAndGetAlertTextTest() {
        String pageText = new HomePage(getDriver())
                .goToAlertTestPage()
                .setSelect()
                .getText();

        Assert.assertEquals(pageText, "changed");
    }

    @Test
    public void alertDisappearedAfterClickOkButtonOnAlertTest() {
        Alert alert = new HomePage(getDriver())
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
    public void alertDisappearedAfterClickDismissButtonOnAlertTest() {
        Alert alert = new HomePage(getDriver())
                .goToAlertTestPage()
                .switchToAlertWithPrompt();

        alert.dismiss();

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
    public void redirectionToAnotherPageAfterClickOkOnAlertWithConfirmTest() {
        Alert alert = new HomePage(getDriver())
                .goToAlertTestPage()
                .switchToAlertWithConfirm();

        alert.accept();

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1")).getText(), "Heading");


    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void keyReporterTest() {
        final char symbol = 'B';
        int pressCode =  new HomePage(getDriver())
                .goToKeyReporterPage()
                .inputSymbol(symbol)
                .getKeyPressCode();

        Assert.assertEquals(pressCode, symbol);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void typeStuffTest() {
        final String testWord = "123";
        int count = new HomePage(getDriver())
                .goToTypingTestLink()
                .fillSymbol(testWord)
                .getCountNotesInBodyResultLine();

        Assert.assertEquals(count, testWord.length());
    }
}
