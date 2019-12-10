package homework_6.exercise.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homework_6.common.AbstractBaseSteps;

import java.util.List;
import java.util.Map;

import static homework_6.exercise.Constants.*;
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

    @And("4 pictures should be displayed on the Home Page$")
    public void picturesAreDisplayedOnTheHomePage() {
        assertTrue(homePage.getFirstCenterImg().isDisplayed());
        assertTrue(homePage.getSecondCenterImg().isDisplayed());
        assertTrue(homePage.getThirdCenterImg().isDisplayed());
        assertTrue(homePage.getFourthCenterImg().isDisplayed());
    }

    @And("4 text should be displayed under pictures on the Home Page$")
    public void textAreDisplayedUnderPicturesOnTheHomePage() {
        assertEquals(homePage.getFirstTextCenterImg(), PRACTISE_FIRST);
        assertEquals(homePage.getSecondTextCenterImg(), CUSTOM_SECOND);
        assertEquals(homePage.getThirdTextCenterImg(), MULTI_THIRD);
        assertEquals(homePage.getFourthTextCenterImg(), BASE_FOURTH);

    }

    @And("^headline above the pictures should be displayed on the Home Page$")
    public void headlineAboveThePicturesIsDisplayedOnTheHomePage() {
        assertTrue(homePage.getMainTitle().isDisplayed());
    }

    @And("^description above the pictures should be displayed on the Home Page$")
    public void descriptionAboveThePicturesIsDisplayedOnTheHomePage() {
        assertTrue(homePage.getTextUnderMainTitle().isDisplayed());
    }

    @Then("^Service in the header menu should contains subcategories '([^\"]+)'$")
    public void serviceContainsSubcategoriesHeaderMenu(List<String> dropmenu) {
        assertTrue(headerMenu.serviceContainsAllSubCategories(dropmenu));
    }

    @Then("^Service in the left menu should contains subcategories '([^\"]+)'$")
    public void serviceContainsSubcategoriesLeftMenu(List<String> dropmenu) {
        assertTrue(leftMenu.serviceContainsAllSubCategories(dropmenu));
    }

    @Then("^'([^\"]+)' is opened$" )//"^'([^\"]+)' page is opened$"
    public void differentElementsIsOpened(String titlePage) {
        assertEquals(diffPage.getPageTitle(), titlePage);
    }

    @And("^4 checkboxes should be displayed on the Different Elements Page$")
    public void checkboxesAreDisplayedOnTheDifferentElementsPage() {
        assertTrue(diffPage.getElementsOfCheckbox()
                .stream().allMatch(p -> p.isDisplayed()));
    }

    @And("^4 radio should be displayed on the Different Elements Page$")
    public void radioAreDisplayedOnTheDifferentElementsPage() {
        assertTrue(diffPage.getElementsOfRadio()
                .stream().allMatch(p -> p.isDisplayed()));
    }

    @And("^1 dropdown should be displayed on the Different Elements Page$")
    public void dropdownIsDisplayedOnTheDifferentElementsPage() {
        assertTrue(diffPage.getDropdownElementsOfColors()
                .stream().allMatch(p -> p.isDisplayed()));
    }

    @And("^2 buttons should be displayed on the Different Elements Page$")
    public void buttonsAreDisplayedOnTheDifferentElementsPage() {
        assertTrue(diffPage.getButton().isDisplayed() &
                diffPage.getDefaultButton().isDisplayed());
    }

    @And("^Right Section should be displayed on the Different Elements Page$")
    public void rightSectionIsDisplayedOnTheDifferentElementsPage() {
        assertTrue(diffPage.getRightSection().isDisplayed());
    }

    @And("^Left Section should be displayed on the Different Elements Page$")
    public void leftSectionIsDisplayedOnTheDifferentElementsPage() {
        assertTrue(diffPage.getLeftSection().isDisplayed());
    }

    @Then("1 Log row should has " +
            "'(Water: condition changed to true|Water: condition changed to false|Wind: condition changed to true|Wind: condition changed to false)'" +
            " on the Different Elements Page$")
    public void logRowHasConditionCheckboxesChangedOnTheDifferentElementsPage(String condition) {
        assertTrue(diffPage.getListOfLogs().get(0).getText().contains(condition));
    }

    @Then("1 Log row should has " +
            "'(metal: value changed to Selen|Colors: value changed to Yellow)'" +
            " on the Different Elements Page$")
    public void logRowHasConditionRadioAndColorsChangedOnTheDifferentElementsPage(String condition) {
        assertTrue(diffPage.getListOfLogs().get(0).getText().contains(condition));
    }

    @Then("^element of dropdown should be selected on the Different Elements Page$")
    public void elementIsSelectedOnTheDifferentElementsPage() {
        assertTrue(diffPage.getDropDown().getFirstSelectedOption().isSelected());
    }


    //SCENATIO2

    @And("^6 Number are displayed on Users Table on User Table Page$")
    public void NumberAreDisplayedOnUsersTableOnUserTablePage() {
        assertTrue(tablePage.getNumbers().stream()
                .allMatch(p -> p.isDisplayed()));
    }

    @And("^6 Type Dropdowns are displayed on Users Table on User Table Page$")
    public void dropdownsAreDisplayedOnUsersTableOnUserTablePage() {
        assertTrue(tablePage.getDropdown().stream()
                .allMatch(p -> p.isDisplayed()));
    }

    @And("^6 User names are displayed on Users Table on User Table Page$")
    public void userNamesAreDisplayedOnUsersTableOnUserTablePage() {
        assertTrue(tablePage.getUserNames().stream()
                .allMatch(p -> p.isDisplayed()));
    }

    @And("^6 Description images are displayed on Users Table on User Table Page$")
    public void descriptionImagesAreDisplayedOnUsersTableOnUserTablePage() {
        assertTrue(tablePage.getDescriptionImages().stream()
                .allMatch(p -> p.isDisplayed()));
    }

    @And("^6 Description texts under images are displayed on Users Table on User Table Page$")
    public void descriptionTextsUnderImagesAreDisplayedOnUsersTableOnUserTablePage() {
        assertTrue(tablePage.getDescriptionUnderImages().stream()
                .allMatch(p -> p.isDisplayed()));
    }

    @And("^6 checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayedOnUsersTableOnUserTablePage() {
        assertTrue(tablePage.getCheckboxes().stream()
                .allMatch(p -> p.isDisplayed()));
    }

    @And("^User table contains following values:$")
    public void userTableContainsFollowingValues(DataTable data) {
        List<Map<String, String>> table = data.asMaps(String.class, String.class);
        for (int i = 0; i < table.size(); i++) {
            assertEquals(tablePage.getNumbersValues().get(i), table.get(i).get("Number").trim());
            assertEquals(tablePage.getUserNamesText().get(i), table.get(i).get("User").trim());
            assertEquals(tablePage.getDescriptionOfUser().get(i), table.get(i).get("Description").trim());
        }

    }

    @Then("^1 log row has '([^\"]+)' text in log section$")
    public void logRowHasVipConditionChangedToTrueTextInLogSection(String logRow) {
        assertTrue(tablePage.getListOfLogs().get(0).getText().contains(logRow));
    }

    @Then("^droplist contains values$")
    public void droplistContainsValues(DataTable data) {
        List<Map<String, String>> table = data.asMaps(String.class, String.class);
        for (int i = 0; i < table.size(); i++) {
            assertEquals(tablePage.getValuesOfDropdown().get(i).getText(),
                    table.get(i).get("Dropdown Values"));
        }
    }

    @Then("^'([^\"]+)' page is opened$")
    public void userPageIsOpened(String titlePage) {
        assertEquals(tablePage.getPageTitle(), titlePage);
    }

}
