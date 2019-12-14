package homework_jdi;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import homework_jdi.data.DataProviderJson;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static homework_jdi.HeaderMenuItems.METALS_AND_COLORS;

@Test(dataProvider = "DataProviderJson", dataProviderClass = DataProviderJson.class)
public class JdiTest {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
    public void jdiTest(Data data) {
        AssertionsStep steps = new AssertionsStep();
        steps.openJsiSite();
        steps.loginWasSuccessful();
        steps.clickHeaderMenu(METALS_AND_COLORS);
        steps.pageIsOpened(METALS_AND_COLORS);
        steps.fillPageWithDataFromJson(data);
        steps.resultShouldBeSuccessful(data);
    }

}
