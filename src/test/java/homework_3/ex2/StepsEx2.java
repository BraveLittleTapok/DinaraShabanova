package homework_3.ex2;

import homework_3.DifferentElementsPage;
import homework_3.StepsBase;
import homework_3.components.MenuLeftSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static homework_3.Constants.listDropMenuService;

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

    @Override
    public void headerMenuItemClick(final String item) {
        boolean flag = false;
        for (String element : listDropMenuService) {
            if (element.equalsIgnoreCase(item)) {
                headerMenu.dropDownMenuItemClick(item);
                flag = true;
            }
        }
        if (!flag) {
            headerMenu.headerMenuItemClick(item);
        }
    }

 /*  public WebElement getItemOfHeaderMenu(final String item) {
        return headerMenu.getItem(item);
    }*/

    public void headerServiceShouldContainsAllSubCategories() {
        for (WebElement element : headerMenu.getDropDownItems()) {
            sa.assertTrue(element.isDisplayed());
        }
    }

    public void leftSectionItemClick(final String item) {
        leftSection.leftMenuItemClick(item);
    }

    public void leftServiceShouldContainsAllSubCategories() {
        for (WebElement element : leftSection.getLeftSectionItems()) {
            sa.assertTrue(element.isDisplayed());
        }
    }

    public List<WebElement> getElementsOfCheckBox() {
        return differentPage.getElementsOfCheckbox();
    }

    public List<WebElement> getElementsOfRadio() {
        return differentPage.getElementsOfRadio();
    }

    public List<WebElement> getElementsOfColors() {
        return differentPage.getElementsOfColors();
    }

    public WebElement getDefaultButton() {
        return differentPage.getDefaultButton();
    }

    public WebElement getButton() {
        return differentPage.getButton();
    }

    public WebElement getLeftSection() {
        return differentPage.getLeftSection();
    }

    public WebElement getRightSection() {
        return differentPage.getRightSection();
    }

    public WebElement getElementFromCheckBox(String str) {
        return differentPage.getElementFromCheckBox(str);
    }

    public WebElement getElementFromRadio(String str) {
        return differentPage.getElementFromRadio(str);
    }

    public boolean elementHasLogRowAfterClickCheckbox(String element, String str) {
        getElementFromCheckBox(element).click();
        return differentPage.getListOfLogs().get(0).getText().contains(str);
    }
    public boolean elementHasLogRowAfterClickRadio(String element, String str) {
        getElementFromRadio(element).click();
        return differentPage.getListOfLogs().get(0).getText().contains(str);
    }

    public void dropDownSelect(String str) {
        differentPage.getDropDown().selectByVisibleText(str);
    }

    public boolean checkDropDownIsSelected(){
        return differentPage.getDropDown().getFirstSelectedOption().isSelected();
    }
    public boolean dropDownHasLogRow(String str) {
        return differentPage.getListOfLogs().get(0).getText().contains(str);
    }
}