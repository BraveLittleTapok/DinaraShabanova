package homework_4.exercise1;

import homework_4.StepsBase;
import homework_4.components.CommonComponents;
import homework_4.components.MenuLeftSection;
import homework_4.components.TableWithPages;

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


    public void clickHeaderMenu(String service) {
        headerMenu.headerMenuItemClick(service);
    }

    public void headerDropDownContainsAllElements(List<String> listDropMenuService) {
        for (String item : listDropMenuService) {
            softAssert.assertTrue(headerMenu.dropDownHasElement(item));
        }
    }

    public void clickLeftMenuItem(String item) {
        leftMenu.leftMenuItemClick(item);
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
        commonComponents.clickEntries();
    }

    public void chooseEntries(int i) {
        commonComponents.chooseSelectOption(i);
    }

    public void entriesIsSelect() {
        softAssert.assertTrue(commonComponents.entriesIsSelect());
    }
}
