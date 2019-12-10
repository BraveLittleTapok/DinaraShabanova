package homework_6.exercise.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homework_6.common.AbstractBaseSteps;

public class ActionSteps extends AbstractBaseSteps {

    @When("^I login as '([^\"]+)' with password '([^\"]+)'$")
    public void iLoginAsEpamWithPassword(String name, String password) {
        user.loginWithNameAndPassword(name, password);
    }

    @When("^I click on '([^\"]+)' button in Header$")
    public void iClickOnServiceInTheHeaderMenu(String item) {
        headerMenu.headerMenuItemClick(item);
    }

    @When("^I click on '([^\"]+)' in the left section on the Home page$")
    public void iClickOnServiceInTheLeftSection(String item) {
        leftMenu.leftMenuItemClick(item);
    }

    @And("^I click on '([^\"]+)' button in Service dropdown on the Home page$")
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



//SCENARIO 2
    @When("^I login as user 'Piter Chailovskii'$")
    public void iLoginAsEpamWithPassword() {
        user.loginWithNameAndPassword("epam", "1234");
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

