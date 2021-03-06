package homework_4.exercise2;

import homework_4.StepsBase;
import homework_4.components.Result;
import homework_4.exercise2.ConstantsForPageMetalAndColors.Summary;
import homework_4.pages.MetalAndColorsPage;
import io.qameta.allure.Step;

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

    @Step("I reload page")
    public void refreshPage() {
        colorsPage.reloadPage();
    }


    @Step("I choose items on the page 'Metal and Colors'")
    public void createClickFromInData(Result actual) {
        if (actual.getSummary() != null) {
            for (int i : actual.getSummary()) {
                colorsPage.chooseSummary(Summary.getStringValueForHTML(i));
            }
        }
        if (actual.getElements() != null) {
            for (String str : actual.getElements()) {
                colorsPage.chooseElements(str);
            }
        }
        if (actual.getColor() != null) {
            colorsPage.click(COLORS);
            colorsPage.chooseColors(actual.getColor());
        }
        if (actual.getVegetables() != null) {
            colorsPage.click(VEGETABLES_ENTITY);
            for (String str : actual.getVegetables()) {
                colorsPage.chooseVegetables(str);
            }
        }
        if (actual.getMetals() != null) {
            colorsPage.click(METALS);
            colorsPage.chooseMetals(actual.getMetals());
        }
        colorsPage.click(SUBMIT);
    }

    @Step("Actual results should be equals to expected results")
    public void equalsResults(Result actual) {
        Result expected = colorsPage.getActualResult();
        if (actual.getSummary() != null) {
            int sum = 0;
            for (int i = 0; i < actual.getSummary().size(); i++) {
                sum += actual.getSummary().get(i);
            }
            softAssert.assertEquals(sum, Math.toIntExact(expected.getSummary().get(0)));
        }
        if (actual.getElements() != null) {
            softAssert.assertTrue(arraysEquals(actual.getElements(), expected.getElements()));
        }
        if (actual.getColor() != null) {
            softAssert.assertEquals(actual.getColor(), expected.getColor());
        }
        if (actual.getVegetables() != null) {
            softAssert.assertTrue(arraysEquals(actual.getVegetables(), expected.getVegetables()));
        }
        if (actual.getMetals() != null) {
            softAssert.assertEquals(actual.getMetals(), expected.getMetals());
        }
    }

    private boolean arraysEquals(List<String> arr1, List<String> arr2) {
        return arr1.stream().collect(groupingBy(k -> k, counting()))
                .equals(arr2.stream().collect(groupingBy(k -> k, counting())));
    }

}

