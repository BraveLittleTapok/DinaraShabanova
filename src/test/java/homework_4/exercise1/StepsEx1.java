package homework_4.exercise1;

import homework_4.StepsBase;
import homework_4.components.CommonComponents;
import homework_4.components.MenuLeftSection;
import homework_4.pages.TableWithPages;

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


    public void headerDropDownContainsAllElements(List<String> listDropMenuService) {
        for (String item : listDropMenuService) {
            softAssert.assertTrue(headerMenu.dropDownHasElement(item));
        }
    }


    public void leftDropDownContainsAllElements(List<String> listDropMenuService) {
        for (String item : listDropMenuService) {
            softAssert.assertTrue(leftMenu.dropDownHasElement(item));
        }
    }

    public void clickHeaderMenuDropDown(String dropDownItem) {
        headerMenu.dropDownMenuItemClick(dropDownItem);
    }

    public void defaultEntriesValueShouldBe(int value) {
        softAssert.assertEquals(tablePage.getDefaultValOfEntries(), value);
    }

    public void pageHasRightSection() {
        softAssert.assertTrue(commonComponents.hasRightSection());
    }

    public void pageHasLeftSection() {
        softAssert.assertTrue(commonComponents.hasLeftSection());
    }

    public void clickEntries() {
        tablePage.clickEntries();
    }

    public void chooseEntries(int i) {
        tablePage.chooseSelectOption(i);
    }

    public void entriesIsSelect() {
        softAssert.assertTrue(tablePage.entriesIsSelect());
    }

    public void logRowRespondToChoosenEntrie(String logRow) {
        softAssert.assertTrue(tablePage.logRowRespondToEntries(logRow));
    }

    public void tableHasCorrectNumberOfEntries(int i) {
        softAssert.assertEquals(tablePage.getNumberEntriesInTable(), i);
    }

    public void fillFieldSearch(String search) {
        tablePage.fillSearch(search);
    }

    public void tableContainsEntryOnlyWithFieldSearch(String search) {
        softAssert.assertTrue(tablePage.tableContainsOnlySearch(search));
    }
}
