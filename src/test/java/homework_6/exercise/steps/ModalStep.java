package homework_6.exercise.steps;

import cucumber.api.java.en.Given;
import homework_6.common.AbstractBaseSteps;

public class ModalStep extends AbstractBaseSteps {

    @Given("^I am on 'Home Page'$|^I open EPAM JDI Site$")
    public void isOpenEpamJdiSite() {
        homePage.open();
    }
}
