package homework_6.exercise2.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionsSteps extends AbstractBaseSteps {

    @Then("^username should be '([^\"]+)' on the Home page$")
    public void usernameShouldBeOnTheHomePage(String expectedUsername) {
        assertEquals(user.getUsernameLabelText(), expectedUsername);
    }

    @Then("^'([^\"]+)' page is opened$")
    public void browserTitleShouldBeHomePage(String title) {
        assertEquals(tablePage.getPageTitle(), title);
    }

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
}
