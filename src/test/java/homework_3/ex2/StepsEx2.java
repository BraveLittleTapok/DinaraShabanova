package homework_3.ex2;

import homework_3.DifferentElementsPage;
import homework_3.StepsBase;
import homework_3.components.MenuLeftSection;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static homework_3.Constants.LIST_DROP_MENU_SERVICE;

/**
 * Created by dinar on 23.11.2019.
 */
public class StepsEx2 extends StepsBase {
    MenuLeftSection leftSection;
    SoftAssert sa = new SoftAssert();
    DifferentElementsPage differentPage;

    public StepsEx2(WebDriver driver) {
        super(driver);
        this.leftSection = new MenuLeftSection(driver);
        this.differentPage = new DifferentElementsPage(driver);
    }

    @Step("I click on the item '{0}' in the Header Menu")
    @Override
    public void headerMenuItemClick(final String item) {
        boolean flag = false;
        for (String element : LIST_DROP_MENU_SERVICE) {
            if (element.equalsIgnoreCase(item)) {
                headerMenu.dropDownMenuItemClick(item);
                flag = true;
            }
        }
        if (!flag) {
            headerMenu.headerMenuItemClick(item);
        }
    }

    @Step("Item 'Service' from Header Menu should contains all sub categories")
    public void headerServiceShouldContainsAllSubCategories() {
        for (WebElement element : headerMenu.getDropDownItems()) {
            sa.assertTrue(element.isDisplayed());
        }
    }

    @Step("I click item '{0}' on the Left section")
    public void leftSectionItemClick(final String item) {
        leftSection.leftMenuItemClick(item);
    }

    @Step("Item 'Service' from Left Section should contains all sub categories")
    public void leftServiceShouldContainsAllSubCategories() {
        for (WebElement element : leftSection.getLeftSectionItems()) {
            sa.assertTrue(element.isDisplayed());
        }
    }

    @Step("I get list of elements of Checkbox from page 'Different page'")
    public List<WebElement> getElementsOfCheckBox() {
        return differentPage.getElementsOfCheckbox();
    }

    @Step("I get list of elements of Radio from page 'Different page'")
    public List<WebElement> getElementsOfRadio() {
        return differentPage.getElementsOfRadio();
    }

    @Step("I get list of elements of Radio from page 'Different page'")
    public List<WebElement> getElementsOfColors() {
        return differentPage.getElementsOfColors();
    }

    @Step("I get Default Button from page 'Different page'")
    public WebElement getDefaultButton() {
        return differentPage.getDefaultButton();
    }

    @Step("I get Button from page 'Different page'")
    public WebElement getButton() {
        return differentPage.getButton();
    }

    @Step("I get Left Section from page 'Different page'")
    public WebElement getLeftSection() {
        return differentPage.getLeftSection();
    }

    @Step("I get Right Section from page 'Different page'")
    public WebElement getRightSection() {
        return differentPage.getRightSection();
    }

    @Step("I get element from Checkbox from page 'Different page'")
    public WebElement getElementFromCheckBox(String str) {
        return differentPage.getElementFromCheckBox(str);
    }

    @Step("I get element from Radio from page 'Different page'")
    public WebElement getElementFromRadio(String str) {
        return differentPage.getElementFromRadio(str);
    }

    @Step("I click '{0}' from Checkbox and it should has Log Row '{1}'")
    public boolean elementHasLogRowAfterClickCheckbox(String element, String str) {
        getElementFromCheckBox(element).click();
        return differentPage.getListOfLogs().get(0).getText().contains(str);
    }

    @Step("I click '{0}' from Radio and it should has Log Row '{1}'")
    public boolean elementHasLogRowAfterClickRadio(String element, String str) {
        getElementFromRadio(element).click();
        return differentPage.getListOfLogs().get(0).getText().contains(str);
    }

    @Step("I select item '(0}' from Dropdown on the page 'Different page'")
    public void dropDownSelect(String str) {
        differentPage.getDropDown().selectByVisibleText(str);
    }

    @Step("First Item should be selected in Dropdown on the page 'Different page'")
    public boolean checkDropDownIsSelected(){
        return differentPage.getDropDown().getFirstSelectedOption().isSelected();
    }

    @Step("Item of the Dropdown should has Log Row '{0}'")
    public boolean dropDownHasLogRow(String str) {
        return differentPage.getListOfLogs().get(0).getText().contains(str);
    }
}