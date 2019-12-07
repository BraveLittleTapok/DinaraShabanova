package homework_6.exercise2.steps;

import cucumber.api.java.en.Given;
import homework_6.HomePage;

import static homework_6.exercise1.WebDriverSingleton.INSTANCE;

public class ModalStep extends AbstractBaseSteps {

    @Given("^I am on 'Home Page'$")
    public void isOpenEpamJdiSite() {
        homePage = new HomePage(INSTANCE.getDriver());
        homePage.open();
    }
}
