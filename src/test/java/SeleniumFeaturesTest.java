import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.base.BaseTest;

public class SeleniumFeaturesTest extends BaseTest {

    @Test
    public void clickTest() {
        String headerText = new HomePage(getDriver())
                .goToClickTest()
                .clickClickLink()
                .getHeaderText();

        Assert.assertEquals(headerText, "XHTML Might Be The Future");
    }

    @Test
    public void labelTextTest() {
        final String labelName = "Label_1";

        String labelText = new HomePage(getDriver())
                .goToLabelTest()
                .fillLabelName(labelName)
                .selectRedColor()
                .clickAddLabelButton()
                .getLabelName();

        Assert.assertEquals(labelText, labelName);
    }

    @Test
    public void labelColorTest() {

        String labelColor = new HomePage(getDriver())
                .goToLabelTest()
                .fillLabelName("name")
                .selectRedColor()
                .clickAddLabelButton()
                .getLabelColor();

        Assert.assertEquals(labelColor, "background-color: red;");
    }
}
