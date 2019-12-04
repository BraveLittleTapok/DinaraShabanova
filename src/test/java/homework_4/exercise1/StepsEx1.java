package homework_4.exercise1;

import homework_4.StepsBase;
import homework_4.components.CommonComponents;
import homework_4.components.MenuLeftSection;
import homework_4.pages.TableWithPages;
import io.qameta.allure.Step;

import java.util.List;

/**
 * Created by dinar on 23.11.2019.
 */
public class StepsEx1 extends StepsBase {

    private MenuLeftSection leftMenu;
    private TableWithPages tablePage;
    private CommonComponents commonComponents;

    public StepsEx1() {
        this.leftMenu = new MenuLeftSection();
        this.tablePage = new TableWithPages();
        this.commonComponents = new CommonComponents();
    }


    @Step("Header Dropdown should has all sub categories")
    public void headerDropDownContainsAllElements(List<String> listDropMenuService) {
        for (String item : listDropMenuService) {
            softAssert.assertTrue(headerMenu.dropDownHasElement(item));
        }
    }

    @Step("Left Dropdown should has all sub categories")
    public void leftDropDownContainsAllElements(List<String> listDropMenuService) {
        for (String item : listDropMenuService) {
            softAssert.assertTrue(leftMenu.dropDownHasElement(item));
        }
    }

    @Step("I click item '{0}' from Header Dropdown menu")
    public void clickHeaderMenuDropDown(String dropDownItem) {
        headerMenu.dropDownMenuItemClick(dropDownItem);
    }

    @Step("Default value of the field 'Entry' should be '{0}'")
    public void defaultEntriesValueShouldBe(int value) {
        softAssert.assertEquals(tablePage.getDefaultValOfEntries(), value);
    }

    @Step("Page should has Right Section")
    public void pageHasRightSection() {
        softAssert.assertTrue(commonComponents.hasRightSection());
    }

    @Step("Page should has Left Section")
    public void pageHasLeftSection() {
        softAssert.assertTrue(commonComponents.hasLeftSection());
    }

    @Step("I click field 'Entries'")
    public void clickEntries() {
        tablePage.clickEntries();
    }

    @Step("I click '{0}' of the field 'Entries'")
    public void chooseEntries(int i) {
        tablePage.chooseSelectOption(i);
    }

    @Step("Item of the 'Entries' should be selected")
    public void entriesIsSelect() {
        softAssert.assertTrue(tablePage.entriesIsSelect());
    }

    @Step("Item of the 'Entries' should has Log Row '{0}'")
    public void logRowRespondToChosenEntry(String logRow) {
        softAssert.assertTrue(tablePage.logRowRespondToEntries(logRow));
    }

    @Step("'Table' should has '{0}' entries")
    public void tableHasCorrectNumberOfEntries(int i) {
        softAssert.assertEquals(tablePage.getNumberEntriesInTable(), i);
    }

    @Step("I fill field 'Search' with '{0}'")
    public void fillFieldSearch(String search) {
        tablePage.fillSearch(search);
    }

    @Step("'Table' should contains results only with '{0}'")
    public void tableContainsEntryOnlyWithFieldSearch(String search) {
        softAssert.assertTrue(tablePage.tableContainsOnlySearch(search));
    }
}
