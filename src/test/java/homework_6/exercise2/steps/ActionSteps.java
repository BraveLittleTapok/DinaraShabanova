package homework_6.exercise2.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homework_6.pages.UserTablePage;
import homework_6.components.HeaderMenu;
import homework_6.components.User;

import static homework_6.exercise1.WebDriverSingleton.INSTANCE;

public class ActionSteps extends AbstractBaseSteps {

    public ActionSteps() {
        user = new User(INSTANCE.getDriver());
        headerMenu = new HeaderMenu(INSTANCE.getDriver());
        tablePage = new UserTablePage(INSTANCE.getDriver());
    }

    @When("^I login as user 'Piter Chailovskii'$")
    public void iLoginAsEpamWithPassword() {
        user.loginWithNameAndPassword("epam", "1234");
    }

    @When("^I click on '([^\"]+)' button in Header$")
    public void iClickOnServiceInTheHeaderMenu(String item) {
        headerMenu.headerMenuItemClick(item);
    }

    @And("^I click on '([^\"]+)' button in Service dropdown$")
    public void iClickOnUserTableButtonInServiceDropdown(String item) {
        headerMenu.dropDownMenuItemClick(item);
    }

    @When("^I select 'vip' checkbox for '([^\"]+)'$")
    public void iSelectVipCheckboxForUser(String name) {
        tablePage.clickVipForUser(name);
    }

    @When("^I click on dropdown in column Type for user Roman$")
    public void iClickOnDropdownInColumnTypeForUserRoman() {
        tablePage.clickDropdownForRoman();
    }
}

