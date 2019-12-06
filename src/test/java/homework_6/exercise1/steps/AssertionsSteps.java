package homework_6.exercise1.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

import static homework_6.Constants.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionsSteps extends AbstractBaseSteps {
    @Then("^username should be '([^\"]+)' on the Home page$")
    public void usernameShouldBeOnTheHomePage(String expectedUsername) {
        assertEquals(user.getUsernameLabelText(), expectedUsername);
    }

    @Then("^browser title should be '([^\"]+)'$")
    public void browserTitleShouldBeHomePage(String title) {
        assertEquals(homePage.getPageTitle(), title);
    }

    @And("4 pictures are displayed on the Home Page$")
    public void picturesAreDisplayedOnTheHomePage() {
        assertTrue(homePage.getFirstCenterImg().isDisplayed());
        assertTrue(homePage.getSecondCenterImg().isDisplayed());
        assertTrue(homePage.getThirdCenterImg().isDisplayed());
        assertTrue(homePage.getFourthCenterImg().isDisplayed());
    }

    @And("4 text are displayed under pictures on the Home Page$")
    public void textAreDisplayedUnderPicturesOnTheHomePage() {
        assertEquals(homePage.getFirstTextCenterImg(), PRACTISE_FIRST);
        assertEquals(homePage.getSecondTextCenterImg(), CUSTOM_SECOND);
        assertEquals(homePage.getThirdTextCenterImg(), MULTI_THIRD);
        assertEquals(homePage.getFourthTextCenterImg(), BASE_FOURTH);

    }

    @And("^headline above the pictures is displayed on the Home Page$")
    public void headlineAboveThePicturesIsDisplayedOnTheHomePage() {
        assertTrue(homePage.getMainTitle().isDisplayed());
    }

    @And("^description above the pictures is displayed on the Home Page$")
    public void descriptionAboveThePicturesIsDisplayedOnTheHomePage() {
        assertTrue(homePage.getTextUnderMainTitle().isDisplayed());
    }

    @Then("^Service in the header menu contains subcategories '([^\"]+)'$")
    public void serviceContainsSubcategoriesHEaderMenu(List<String> dropmenu) {
        assertTrue(headerMenu.serviceContainsAllSubCategories(dropmenu));
    }

    @Then("^Service in the left menu contains subcategories '([^\"]+)'$")
    public void serviceContainsSubcategoriesLeftMenu(List<String> dropmenu) {
        assertTrue(headerMenu.serviceContainsAllSubCategories(dropmenu));
    }
}
