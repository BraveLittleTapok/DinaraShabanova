package homework_6.exercise2.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homework_6.UserTablePage;
import homework_6.components.HeaderMenu;
import homework_6.components.MenuLeftSection;
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
    public void iClickOnDifferentElementsButtonInServiceDropdown(String item) {
        headerMenu.dropDownMenuItemClick(item);
    }

}

