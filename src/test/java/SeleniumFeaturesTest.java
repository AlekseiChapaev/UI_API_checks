import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.base.BaseTest;

import java.util.List;

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
        String alertText = new HomePage(getDriver())
                .goToAlertTestPage()
                .clickAlertWithText()
                .getText();

        Assert.assertEquals(alertText, "cheese");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void alertWithoutTextTest() {
        String alertText = new HomePage(getDriver())
                .goToAlertTestPage()
                .clickAlertWithoutText()
                .getText();

        Assert.assertEquals(alertText, "");
    }
}
