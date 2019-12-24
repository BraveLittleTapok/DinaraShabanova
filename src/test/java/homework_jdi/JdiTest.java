package homework_jdi;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import homework_jdi.commonelements.HeaderMenuItems;
import homework_jdi.data.DataProviderJson;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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
    public void jdiTest(DataFromJsonForMetalsColorPage dataFromJsonForMetalsColorPage) {
        Steps steps = new Steps();
        steps.openJsiSite();
        steps.loginWasSuccessful();
        steps.clickHeaderMenu(HeaderMenuItems.METALS_AND_COLORS);
        steps.pageIsOpened(HeaderMenuItems.METALS_AND_COLORS);
        steps.fillPageWithDataFromJson(dataFromJsonForMetalsColorPage);
        steps.resultShouldBeSuccessful(dataFromJsonForMetalsColorPage);
    }

}
