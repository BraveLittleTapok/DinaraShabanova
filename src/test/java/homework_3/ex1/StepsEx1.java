package homework_3.ex1;

import homework_3.StepsBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static homework_3.Constants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by dinar on 23.11.2019.
 */
public class StepsEx1 extends StepsBase {

    public StepsEx1(WebDriver driver) {
        super(driver);
    }

    public void imagesFromHomePagesAreDisplayed() {
        assertTrue(homePage.getFirstCenterImg().isDisplayed());
        assertTrue(homePage.getSecondCenterImg().isDisplayed());
        assertTrue(homePage.getThirdCenterImg().isDisplayed());
        assertTrue(homePage.getFourthCenterImg().isDisplayed());
    }

    @Step("Text of the image on the Home Page should be '{0}'")
    public void textOfImgFromHomePageShouldBe(final String item) {
        switch (item) {
            case PRACTISE_FIRST:
                assertEquals(homePage.getFirstTextCenterImg(), PRACTISE_FIRST);
            case CUSTOM_SECOND:
                assertEquals(homePage.getSecondTextCenterImg(), CUSTOM_SECOND);
                break;
            case MULTI_THIRD:
                assertEquals(homePage.getThirdTextCenterImg(), MULTI_THIRD);
                break;
            case BASE_FOURTH:
                assertEquals(homePage.getFourthTextCenterImg(), BASE_FOURTH);
                break;
        }
    }

    @Step("I open frame from the Home Page")
    public void openFrame() {
        homePage.openFrame();
    }


    @Step("Item '{0}' of HeaderMenu displayed and should be '{1}'")
    public void itemOfHeaderMenuIsDisplayedAndShouldBe(String itemDisplayed, String text) {
        assertTrue(headerMenu.getItem(itemDisplayed).isDisplayed() &
                headerMenu.getItem(itemDisplayed).getText().equals(text));
    }

    @Step("Main title displayed and should be '{0}'")
    public void mainTitleIsDisplayedAndShouldBe(String s) {
        assertTrue(homePage.getMainTitle().isDisplayed() & homePage.getMainTitle().getText().equals(s));

    }

    public void textUndermainTitleShouldBe(String textUnderMainTitle) {
        assertTrue(homePage.getTextUnderMainTitle().getText().equals(textUnderMainTitle));
    }

    public void frameIsDiaplayed() {
        assertTrue(homePage.getFrame().isDisplayed());
    }

    public void logoIsDisplayed() {
        assertTrue(homePage.getLogoFrame().isDisplayed());
    }

    public void textOfSubHeaderShouldBe(String s) {
        assertEquals(homePage.getLinkGithub().getText(), s);
    }

    public void linkHasProperURL(String s) {
        assertEquals(homePage.getLinkGithub().getAttribute("href"), s);
    }

    public void leftSectionIsDisplayed() {
        assertTrue(homePage.getLeftSection().isDisplayed());
    }

    public void footerIsDisplayed() {
        assertTrue(homePage.getFooter().isDisplayed());
    }
}
