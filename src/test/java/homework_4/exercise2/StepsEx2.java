package homework_4.exercise2;

import homework_4.StepsBase;
import homework_4.components.Entity;
import homework_4.components.Result;
import homework_4.pages.MetalAndColorsPage;

import java.util.Collections;
import java.util.List;

import static homework_4.components.Entity.SUBMIT;

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


    public void clickSubmitButton() {
        colorsPage.click(SUBMIT);
    }

    public void refreshPage() {
        colorsPage.reloadPage();
    }

    public void elementsChoose(String element) {
        colorsPage.chooseElements(element);
    }

    public void colorsChoose(String color) {
        colorsPage.chooseColors(color);
    }

    public void metalsChoose(String metal) {
        colorsPage.chooseMetals(metal);
    }

    public void resultContains(Result result) {
        Result actualRes = colorsPage.getActualResult();
        List<String> orderedElements = null;
        List<String> orderedVegetables = result.getVegetables();

        if (result.getElements() != null) {
            orderedElements = result.getElements();
            Collections.sort(orderedElements);
        }
        Collections.sort(orderedVegetables);

        Result expectedResult = Result.resultBuilder()
                .setSummary(result.getSummary())
                .setColor(result.getColor())
                .setMetals(result.getMetals())
                .setVegetables(orderedVegetables)
                .setElements(orderedElements)
                .build();

        softAssert.assertEquals(actualRes, expectedResult);
    }
}
