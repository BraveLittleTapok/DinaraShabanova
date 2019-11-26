package homework_4.exercise1;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static homework_4.Constants.SERVICE;
import static homework_4.Constants.TABLE_WITH_PAGES;
import static homework_4.Constants.listDropMenuService;

/**
 * Created by dinar on 24.11.2019.
 */
public class Exercise1 {
    private static final String PATH_TO_PROPERTIES = "src/main/resources/hw3/UserData.properties";
    private static final String URL_HOME_PAGE = "https://epam.github.io/JDI/index.html";

    @Test
    public void exercise1() throws IOException {
        // 1. open site
        open(URL_HOME_PAGE);
        StepsEx1 steps = new StepsEx1();

        //2.Assert Browser title ; 5.Assert Browser title
        steps.titleShouldBe("Home Page");

        // 3.Perform login
        Properties userData = new Properties();
        userData.load(new FileInputStream(PATH_TO_PROPERTIES));
        steps.login(userData.getProperty("login"), userData.getProperty("password"));

        // 4.Logined user's name is display correctly
        steps.userNameShouldBe("PITER CHAILOVSKII");

        //5. Click on "Service" subcategory in the header
        // and check that drop down contains options
        steps.clickHeaderMenu(SERVICE);
        steps.headerDropDownContainsAllElements(listDropMenuService);

        //6. Click on Service subcategory in the left section
        // and check that drop down contains options
        steps.clickLeftMenuItem(SERVICE);
        steps.leftDropDownContainsAllElements(listDropMenuService);

        //7. Open through the header menu Service -> Table with pages
        steps.clickHeaderMenu(SERVICE);
        steps.clickHeaderMenuDropDown(TABLE_WITH_PAGES);
        steps.titleShouldBe(TABLE_WITH_PAGES);

        //8. Check that default value for “Show entries” dropdown is 5
        steps.defaultEntriesValueShouldBe(5);
        //9. Assert that there is Right Section
        steps.pageHasRightSection();
        //10. Assert that there is Left Section
        steps.pageHasLeftSection();
        //11. Select "10" value for the entries in the dropdown list
        steps.clickEntries();
        steps.chooseEntries(10);
        steps.entriesIsSelect();

        steps.softAssertAll();
    }
}
