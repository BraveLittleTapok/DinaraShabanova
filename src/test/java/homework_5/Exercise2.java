package homework_5;

import homework_3.AbstractBaseTest;
import homework_3.ex2.StepsEx2;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static homework_3.Constants.*;


/**
 * Created by dinar on 23.11.2019.
 */
public class Exercise2 extends AbstractBaseTest {
    private StepsEx2 steps;
    private static final String PATH_TO_PROPERTIES = "src/main/resources/hw3/UserData.properties";

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        steps = new StepsEx2(driver);
    }

    @Feature("Exercise 2")
    @Story("homework_1")
    @Test
    public void testExerciseFail() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        // 1. open site
        steps.openEpamJdiSite();

        //2.Assert Browser title ; 5.Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        // 3.Perform login
        Properties userData = new Properties();
        userData.load(new FileInputStream(PATH_TO_PROPERTIES));
        steps.login(userData.getProperty("login"), userData.getProperty("password"));

        // 4.Logined user's name is display correctly
        steps.usernameOnTheHomePageShouldBe("PITER CHAILOVSKII");

        //5. Drop down "Service" in the header contains subcategories with options
        steps.headerMenuItemClick(SERVICE);
        steps.headerServiceShouldContainsAllSubCategories();

        //6. Drop down "Service" in the left section contains subcategories with options
        steps.leftSectionItemClick(SERVICE);
        steps.leftServiceShouldContainsAllSubCategories();

        // 7. Open through the header menu Service -> Different Elements Page
        steps.headerMenuItemClick(SERVICE);
        steps.headerMenuItemClick(DIFFER_ELEMENETS);
        softAssert.assertEquals(driver.getTitle(), "Different Elements");
        //8.Check interface on Different elements page, it contains all needed elements: 4 checkboxes,
        // 4 radios, 1 dropdown, 2 buttons
        //check that there exactly 4 element for each
        softAssert.assertEquals(steps.getElementsOfCheckBox().size(), 4);

        softAssert.assertEquals(steps.getElementsOfRadio().size(), 4);
        //softAssert.assertEquals(countRadio, 4);
        //dropdown element
        softAssert.assertEquals(steps.getElementsOfColors().size(), 1);

        //first buttons
        softAssert.assertTrue(steps.getDefaultButton().isDisplayed());
        //second button
        softAssert.assertTrue(steps.getButton().isDisplayed());

        //9. Assert that there is Right Section
        softAssert.assertTrue(steps.getRightSection().isDisplayed());

        //10. Assert that there is Left Section
        softAssert.assertTrue(steps.getLeftSection().isDisplayed());

        //11. Select checkboxes: Water, Wind and (12.) Assert that for each checkbox there is an individual 
        // log row and value is corresponded to the status of checkbox.  AND 17. Unselect and assert checkboxes Water, Wind
        //AND 18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        //Log rows are displayed, checkbox name and its status is corresponding to selected

        //Water checked select and check lo row

        softAssert.assertTrue(steps.elementHasLogRowAfterClickCheckbox(WATER, WATER_TRUE));
        //Water unchecked select and check row
        softAssert.assertTrue(steps.elementHasLogRowAfterClickCheckbox(WATER, WATER_FALSE));

        //Wind checked select and check row

        softAssert.assertTrue(steps.elementHasLogRowAfterClickCheckbox(WIND, WIND_TRUE));
        //Wind unchecked select and check row
        softAssert.assertTrue(steps.elementHasLogRowAfterClickCheckbox(WIND, WIND_FALSE));

        //13. Select radio and 14. Assert that for button there is a log row and
        // value is corresponded to the status of radio button. 
        softAssert.assertTrue(steps.elementHasLogRowAfterClickRadio(GOLD, METAL_GOLD));

        //15. Select in dropdown Yellow AND 16. Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        steps.dropDownSelect(YELLOW);
        softAssert.assertTrue(steps.checkDropDownIsSelected());
        softAssert.assertTrue(steps.dropDownHasLogRow(COLOR_YELLOW));

        softAssert.assertAll();

    }
}
