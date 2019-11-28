package homework_4.exercise2;

import homework_4.StepsBase;
import homework_4.components.Entity;
import homework_4.pages.MetalAndColorsPage;

/**
 * Created by dinar on 23.11.2019.
 */
public class StepsEx2 extends StepsBase {

    private MetalAndColorsPage colorsPage;

    public StepsEx2() {
        this.colorsPage = new MetalAndColorsPage();
    }

    public void summaryChoose(String item) {
        colorsPage.chooseSummary(item);
    }

    public void clickDropdown(Entity entity) {
        colorsPage.click(entity);
    }

    public void vegetableChoose(String veg) {
        colorsPage.chooseVegetables(veg);
    }
}
