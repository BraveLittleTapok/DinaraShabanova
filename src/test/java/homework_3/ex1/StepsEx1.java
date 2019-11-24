package homework_3.ex1;

import homework_3.StepsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public WebElement getItemOfHeaderMenu(final String item) {
        return headerMenu.getItem(item);
    }

    public void imagesFromHomePagesAreDisplayed() {
        assertTrue(homePage.getFirstCenterImg().isDisplayed());
        assertTrue(homePage.getSecondCenterImg().isDisplayed());
        assertTrue(homePage.getThirdCenterImg().isDisplayed());
        assertTrue(homePage.getFourthCenterImg().isDisplayed());
    }

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

    public WebElement getMainTitle() {
        return homePage.getMainTitle();
    }

    public WebElement getTextUnderMainTitle() {
        return homePage.getTextUnderMainTitle();
    }

    public void openFrame() {
        homePage.openFrame();
    }

    public WebElement getFrame() {
        return homePage.getFrame();
    }

    public WebElement getLogoFrame() {
        return homePage.getEpamLogo();
    }

    public WebElement getLinkGithub() {
        return homePage.getLinkGithub();
    }

    public WebElement getFooter() {
        return homePage.getFooter();
    }

    public WebElement getLeftSection() {
        return homePage.getLeftSection();
    }

}
