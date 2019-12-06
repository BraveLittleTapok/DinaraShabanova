package homework_6.exercise1;

import homework_6.AbstractBaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static homework_6.Constants.*;


/**
 * Created by dinar on 23.11.2019.
 */
public class Exercise1 extends AbstractBaseTest {
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
    public void exercise1Test() throws IOException {
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
        //5. 4 Images are displayed
        steps.imagesFromHomePagesAreDisplayed();

        //5. Texts are displayed and equal to expected under images
        steps.textOfImgFromHomePageShouldBe(PRACTISE_FIRST);
        steps.textOfImgFromHomePageShouldBe(CUSTOM_SECOND);
        steps.textOfImgFromHomePageShouldBe(MULTI_THIRD);
        steps.textOfImgFromHomePageShouldBe(BASE_FOURTH);

        //5. text of the main headers
        steps.textOfSubHeaderShouldBe("JDI GITHUB");
        steps.mainTitleIsDisplayedAndShouldBe("EPAM FRAMEWORK WISHES…");
        steps.textUnderMainTitleShouldBe(TEXT_UNDER_MAIN_TITLE);

        //6. Drop down "Service" in the header contains subcategories with options
        steps.headerMenuItemClick(SERVICE);
        steps.headerServiceShouldContainsAllSubCategories();

        //7. Drop down "Service" in the left section contains subcategories with options
        steps.leftSectionItemClick(SERVICE);
        steps.leftServiceShouldContainsAllSubCategories();

        // 8. Open through the header menu Service -> Different Elements Page
        steps.headerMenuItemClick(SERVICE);
        steps.headerMenuItemClick(DIFFER_ELEMENETS);
        softAssert.assertEquals(driver.getTitle(), "Different Elements");
        //9.Check interface on Different elements page, it contains all needed elements: 4 checkboxes,
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

        //10. Assert that there is Right Section
        softAssert.assertTrue(steps.getRightSection().isDisplayed());

        //11. Assert that there is Left Section
        softAssert.assertTrue(steps.getLeftSection().isDisplayed());

        //12. Select checkboxes: Water, Wind and (13.) Assert that for each checkbox there is an individual 
        // log row and value is corresponded to the status of checkbox.  AND 18. Unselect and assert checkboxes Water, Wind
        //AND 19. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        //Log rows are displayed, checkbox name and its status is corresponding to selected

        //Water checked select and check lo row

        softAssert.assertTrue(steps.elementHasLogRowAfterClickCheckbox(WATER, WATER_TRUE));
        //Water unchecked select and check row
        softAssert.assertTrue(steps.elementHasLogRowAfterClickCheckbox(WATER, WATER_FALSE));

        //Wind checked select and check row
        softAssert.assertTrue(steps.elementHasLogRowAfterClickCheckbox(WIND, WIND_TRUE));
        //Wind unchecked select and check row
        softAssert.assertTrue(steps.elementHasLogRowAfterClickCheckbox(WIND, WIND_FALSE));

        //14. Select radio and 15. Assert that for button there is a log row and
        // value is corresponded to the status of radio button. 
        softAssert.assertTrue(steps.elementHasLogRowAfterClickRadio(SELEN, METAL_SELEN));

        //16. Select in dropdown Yellow AND 17. Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        steps.dropDownSelect(YELLOW);
        softAssert.assertTrue(steps.checkDropDownIsSelected());
        softAssert.assertTrue(steps.dropDownHasLogRow(COLOR_YELLOW));

        softAssert.assertAll();

    }
}
