package homework_3.ex1;

import homework_3.AbstractBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static homework_3.Constants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by dinar on 23.11.2019.
 */
public class Exercise1 extends AbstractBaseTest {

    private StepsEx1 steps;
    private static final String PATH_TO_PROPERTIES = "src/main/resources/hw3/UserData.properties";

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        steps = new StepsEx1(driver);
    }

    @Test
    public void testExercise1() throws IOException {

        // 1. open site
        steps.openEpamJdiSite();

        //2.Assert Browser title ; 5.Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 3.Perform login
        Properties userData = new Properties();
        userData.load(new FileInputStream(PATH_TO_PROPERTIES));
        steps.login(userData.getProperty("login"), userData.getProperty("password"));

        // 4.Logined user's name is display correctly
        steps.usernameOnTheHomePageShouldBe("PITER CHAILOVSKII");

        //6.Menu buttons are displayed and have proper texts "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        assertTrue(steps.getItemOfHeaderMenu(HOME).isDisplayed());
        assertTrue(steps.getItemOfHeaderMenu(CONTACT_FORM).isDisplayed());
        assertTrue(steps.getItemOfHeaderMenu(SERVICE).isDisplayed());
        assertTrue(steps.getItemOfHeaderMenu(METALS_AND_COLORS).isDisplayed());

        assertEquals(steps.getItemOfHeaderMenu(HOME).getText(), "HOME");
        assertEquals(steps.getItemOfHeaderMenu(CONTACT_FORM).getText(), "CONTACT FORM");
        assertEquals(steps.getItemOfHeaderMenu(SERVICE).getText(), "SERVICE");
        assertEquals(steps.getItemOfHeaderMenu(METALS_AND_COLORS).getText(), "METALS & COLORS");

        //7. 4 Images are displayed
        steps.imagesFromHomePagesAreDisplayed();

        //8. Texts are displayed and equal to expected under images
        steps.textOfImgFromHomePageShouldBe(PRACTISE_FIRST);
        steps.textOfImgFromHomePageShouldBe(CUSTOM_SECOND);
        steps.textOfImgFromHomePageShouldBe(MULTI_THIRD);
        steps.textOfImgFromHomePageShouldBe(BASE_FOURTH);

        //9. text of the main headers
        assertTrue(steps.getMainTitle().isDisplayed());
        assertEquals(steps.getMainTitle().getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(steps.getTextUnderMainTitle().getText(), TEXT_UNDER_MAIN_TITLE);

        //10. Assert that there is the iframe in the center of page
        assertTrue(steps.getFrame().isDisplayed());

        //11. Switch to the iframe and check that there is Epam logo in the left
        // top conner of iframe
        steps.openFrame();
        assertTrue(steps.getLogoFrame().isDisplayed());

        // 12. Switch to original window back
        driver.switchTo().defaultContent();

        // 13. Assert a text of the sub header
        assertEquals(steps.getLinkGithub().getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(steps.getLinkGithub().getAttribute("href"), "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        assertTrue(steps.getLeftSection().isDisplayed());

        //16.Assert that there is Footer
        assertTrue(steps.getFooter().isDisplayed());
    }
}
