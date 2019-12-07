package homework_6.exercise1.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

import static homework_6.exercise1.Constants.*;
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
    public void serviceContainsSubcategoriesHeaderMenu(List<String> dropmenu) {
        assertTrue(headerMenu.serviceContainsAllSubCategories(dropmenu));
    }

    @Then("^Service in the left menu contains subcategories '([^\"]+)'$")
    public void serviceContainsSubcategoriesLeftMenu(List<String> dropmenu) {
        assertTrue(leftMenu.serviceContainsAllSubCategories(dropmenu));
    }

    @Then("^'([^\"]+)' is opened$")
    public void differentElementsIsOpened(String titlePage) {
        assertEquals(diffPage.getPageTitle(), titlePage);
    }

    @And("^4 checkboxes are displayed on the Different Elements Page$")
    public void checkboxesAreDisplayedOnTheDifferentElementsPage() {
        assertTrue(diffPage.getElementsOfCheckbox()
                .stream().allMatch(p -> p.isDisplayed()));
    }

    @And("^4 radio are displayed on the Different Elements Page$")
    public void radioAreDisplayedOnTheDifferentElementsPage() {
        assertTrue(diffPage.getElementsOfRadio()
                .stream().allMatch(p -> p.isDisplayed()));
    }

    @And("^1 dropdown is displayed on the Different Elements Page$")
    public void dropdownIsDisplayedOnTheDifferentElementsPage() {
        assertTrue(diffPage.getDropdownElementsOfColors()
                .stream().allMatch(p -> p.isDisplayed()));
    }

    @And("^2 buttons are displayed on the Different Elements Page$")
    public void buttonsAreDisplayedOnTheDifferentElementsPage() {
        assertTrue(diffPage.getButton().isDisplayed() &
                diffPage.getDefaultButton().isDisplayed());
    }

    @And("^Right Section is displayed on the Different Elements Page$")
    public void rightSectionIsDisplayedOnTheDifferentElementsPage() {
        assertTrue(diffPage.getRightSection().isDisplayed());
    }

    @And("^Left Section is displayed on the Different Elements Page$")
    public void leftSectionIsDisplayedOnTheDifferentElementsPage() {
        assertTrue(diffPage.getLeftSection().isDisplayed());
    }

    @Then("1 Log row has " +
            "'(Water: condition changed to true|Water: condition changed to false|Wind: condition changed to true|Wind: condition changed to false)'" +
            " on the Different Elements Page$")
    public void logRowHasConditionCheckboxesChangedOnTheDifferentElementsPage(String condition) {
        assertTrue(diffPage.getListOfLogs().get(0).getText().contains(condition));
    }

    @Then("1 Log row has " +
            "'(metal: value changed to Selen|Colors: value changed to Yellow)'" +
            " on the Different Elements Page$")
    public void logRowHasConditionRadioAndColorsChangedOnTheDifferentElementsPage(String condition) {
        assertTrue(diffPage.getListOfLogs().get(0).getText().contains(condition));
    }

    @Then("^element of dropdown is selected on the Different Elements Page$")
    public void elementIsSelectedOnTheDifferentElementsPage() {
        assertTrue(diffPage.getDropDown().getFirstSelectedOption().isSelected());
    }
}
