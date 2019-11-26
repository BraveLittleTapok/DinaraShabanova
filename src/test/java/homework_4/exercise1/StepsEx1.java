package homework_4.exercise1;

import homework_4.StepsBase;
import homework_4.components.MenuLeftSection;
import homework_4.components.TableWithPages;

import java.util.List;

/**
 * Created by dinar on 23.11.2019.
 */
public class StepsEx1 extends StepsBase {

    private MenuLeftSection leftMenu;
    private TableWithPages tablePage;

    public StepsEx1() {
        this.leftMenu = new MenuLeftSection();
        this.tablePage = new TableWithPages();
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

    public void defaultEntitiesValueShouldBe(int value) {
        softAssert.assertEquals(tablePage.getDefaultValOfEntities(), value);
    }
}
