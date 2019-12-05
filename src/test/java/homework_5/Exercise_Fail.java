package homework_5;

import homework_3.AbstractBaseTest;
import homework_3.ex1.StepsEx1;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static homework_3.Constants.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by dinar on 23.11.2019.
 */
@Listeners({AllureTestNg.class, AttachmentListener.class})
public class Exercise_Fail extends AbstractBaseTest {

    private StepsEx1 steps;
    private static final String PATH_TO_PROPERTIES = "src/main/resources/hw3/UserData.properties";

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        steps = new StepsEx1(driver);
    }

    @Feature("Exercise_FAIL")
    @Story("exercise_3")
    @Test
    public void ExerciseFailTest() throws IOException {

        // 1. open site
        steps.openEpamJdiSite();

        //2.Assert Browser title ; 5.Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 3.Perform login
        Properties userData = new Properties();
        userData.load(new FileInputStream(PATH_TO_PROPERTIES));
        steps.login(userData.getProperty("login"), userData.getProperty("password"));

        // 4.Logined user's name is display correctly
        //FAIL
        steps.usernameOnTheHomePageShouldBe("PITER CHAILOVSKII1");

        //6.Menu buttons are displayed and have proper texts "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        steps.itemOfHeaderMenuIsDisplayedAndShouldBe(HOME, "HOME");
        steps.itemOfHeaderMenuIsDisplayedAndShouldBe(CONTACT_FORM, "CONTACT FORM");
        steps.itemOfHeaderMenuIsDisplayedAndShouldBe(SERVICE, "SERVICE");
        steps.itemOfHeaderMenuIsDisplayedAndShouldBe(METALS_AND_COLORS, "METALS & COLORS");

        //7. 4 Images are displayed
        steps.imagesFromHomePagesAreDisplayed();

        //8. Texts are displayed and equal to expected under images
        steps.textOfImgFromHomePageShouldBe(PRACTISE_FIRST);
        steps.textOfImgFromHomePageShouldBe(CUSTOM_SECOND);
        steps.textOfImgFromHomePageShouldBe(MULTI_THIRD);
        steps.textOfImgFromHomePageShouldBe(BASE_FOURTH);

        //9. text of the main headers
        steps.mainTitleIsDisplayedAndShouldBe("EPAM FRAMEWORK WISHES…");
        steps.textUndermainTitleShouldBe(TEXT_UNDER_MAIN_TITLE);

        //10. Assert that there is the iframe in the center of page
        steps.frameIsDiaplayed();

        //11. Switch to the iframe and check that there is Epam logo in the left
        // top conner of iframe
        steps.openFrame();
        steps.logoIsDisplayed();
        // 12. Switch to original window back
        driver.switchTo().defaultContent();
        // 13. Assert a text of the sub header
        steps.textOfSubHeaderShouldBe("JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        steps.linkHasProperURL("https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        steps.leftSectionIsDisplayed();

        //16.Assert that there is Footer
        steps.footerIsDisplayed();
    }
}
