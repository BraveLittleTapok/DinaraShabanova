package homework_4.exercise2;

import homework_4.StepsBase;
import homework_4.components.Entity;
import homework_4.components.Result;
import homework_4.exercise2.ConstantsForPageMetalAndColors.Summary;
import homework_4.pages.MetalAndColorsPage;

import java.util.Collections;
import java.util.List;

import static homework_4.components.Entity.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by dinar on 23.11.2019.
 */
public class StepsEx2 extends StepsBase {

    protected MetalAndColorsPage colorsPage;

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

    public Result getActualResult() {
        return colorsPage.getActualResult();
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

    }

    public void equalsResults(Result actual, Result expected) {
        expected = colorsPage.getActualResult();
        if (actual.getSummary() != null) {
            int sum = 0;
            for (int i : actual.getSummary()) {
                colorsPage.chooseSummary(Summary.getStringValueForHTML(i));
                sum += actual.getSummary().get(i);
            }
            softAssert.assertEquals(sum, Math.toIntExact(expected.getSummary().get(0)));
        }
        if (actual.getElements() != null) {
            for (String str : actual.getElements()) {
                colorsPage.chooseElements(str);
            }
            softAssert.assertTrue(arraysEquals(actual.getElements(), expected.getElements()));
        }
        if (actual.getColor() != null) {
            colorsPage.click(COLORS);
            colorsPage.chooseColors(actual.getColor());
            softAssert.assertEquals(actual.getColor(), expected.getColor());
        }
        if (actual.getVegetables() != null) {
            colorsPage.click(VEGETABLES_ENTITY);
            for (String str : actual.getVegetables()) {
                colorsPage.chooseVegetables(str);
            }
            softAssert.assertTrue(arraysEquals(actual.getVegetables(), expected.getVegetables()));
        }
        if (actual.getMetals() != null) {
            colorsPage.click(METALS);
            colorsPage.chooseMetals(actual.getMetals());
            softAssert.assertEquals(actual.getMetals(), expected.getMetals());
        }

    }

    private boolean arraysEquals(List<String> arr1, List<String> arr2) {
        return arr1.stream().collect(groupingBy(k -> k, counting()))
                .equals(arr2.stream().collect(groupingBy(k -> k, counting())));
    }

}

