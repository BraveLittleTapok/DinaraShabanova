package homework_6.exercise1.steps;

import cucumber.api.java.en.When;

public class ActionSteps extends AbstractBaseSteps {

    @When("^I login as '([^\"]+)' with password '([^\"]+)'$")
    public void iLoginAsEpamWithPassword(String name, String password) {
        user.loginWithNameAndPassword(name, password);
    }

    @When("^I click on '([^\"]+)' in the header menu$")
    public void iClickOnServiceInTheHeaderMenu(String item) {
        headerMenu.headerMenuItemClick(item);
    }

    @When("^I click on '([^\"]+)' in the left section$")
    public void iClickOnServiceInTheLeftSection(String item) {
        leftMenu.leftMenuItemClick(item);
    }
}

