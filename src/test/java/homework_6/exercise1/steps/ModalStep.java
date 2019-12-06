package homework_6.exercise1.steps;

import cucumber.api.java.en.Given;
import homework_6.HomePage;

public class ModalStep extends AbstractBaseSteps {

    @Given("^I open EPAM JDI Site$")
    public void  isOpenEpamJdiSite(){
        new HomePage(driver).open();
    }
}
