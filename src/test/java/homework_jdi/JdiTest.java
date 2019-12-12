package homework_jdi;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

//@Test(dataProvider = "DataProviderJson", dataProviderClass = DataProviderJson.class)
public class JdiTest {
 /*   @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
*/
    @Test
    public void jdiTest(Data data) throws FileNotFoundException {
        Reader reader = new FileReader("src/test/resources/hw_jdi/JDI_ex8_metalsColorsDataSet.json");
        Gson gson = new Gson();
        Data[] datas = gson.fromJson(reader, Data[].class);
        System.out.println();

        AssertionsStep steps = new AssertionsStep();
    /*    steps.openJsiSite();
        steps.loginWasSuccessful();
        steps.clickHeaderMenu(METALS_AND_COLORS);
        steps.pageIsOpened(METALS_AND_COLORS);
        steps.fillPageWithDataFromJson(data);*/
    }

}
