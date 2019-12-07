package homework_6.exercise2.steps;

import cucumber.api.java.en.Then;

import static org.testng.Assert.assertEquals;

public class AssertionsSteps extends AbstractBaseSteps {
    @Then("^username should be '([^\"]+)' on the Home page$")
    public void usernameShouldBeOnTheHomePage(String expectedUsername) {
        assertEquals(user.getUsernameLabelText(), expectedUsername);
    }

    @Then("^'([^\"]+)' page is opened$")
    public void browserTitleShouldBeHomePage(String title) {
        assertEquals(tablePage.getPageTitle(), title);
    }

}
