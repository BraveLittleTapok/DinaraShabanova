package homework_6.exercise1.steps;

import cucumber.api.java.en.Given;
import homework_6.pages.HomePage;

import static homework_6.exercise1.WebDriverSingleton.INSTANCE;

public class ModalStep extends AbstractBaseSteps {

    @Given("^I open EPAM JDI Site$")
    public void isOpenEpamJdiSite() {
        homePage = new HomePage(INSTANCE.getDriver());
        homePage.open();
    }
}
