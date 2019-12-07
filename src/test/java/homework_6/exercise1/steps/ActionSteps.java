package homework_6.exercise1.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homework_6.DifferentElementsPage;
import homework_6.components.HeaderMenu;
import homework_6.components.MenuLeftSection;
import homework_6.components.User;

import static homework_6.exercise1.WebDriverSingleton.INSTANCE;

public class ActionSteps extends AbstractBaseSteps {

    public ActionSteps() {
        user = new User(INSTANCE.getDriver());
        headerMenu = new HeaderMenu(INSTANCE.getDriver());
        leftMenu = new MenuLeftSection(INSTANCE.getDriver());
        diffPage = new DifferentElementsPage(INSTANCE.getDriver());
    }

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

    @And("^I click on '([^\"]+)' button in Service dropdown$")
    public void iClickOnDifferentElementsButtonInServiceDropdown(String item) {
        headerMenu.dropDownMenuItemClick(item);
    }

    @When("^I select '(Water|Wind)' checkbox on the Different Elements Page$")
    public void iSelectWaterCheckboxOnTheDifferentElementsPage(String checkbox) {
        diffPage.getElementFromCheckBox(checkbox).click();
    }

    @When("^I select '([^\"]+)' radio on the Different Elements Page$")
    public void iSelectSelenRadioOnTheDifferentElementsPage(String radio) {
        diffPage.getElementOfRadio(radio).click();
    }

    @When("^I select '([^\"]+)' in dropdown on the Different Elements Page$")
    public void iClickDropdownOnTheDifferentElementsPage(String dropdown) {
        diffPage.getDropDown().selectByVisibleText(dropdown);
    }
}

