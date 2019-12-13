package homework_jdi;

import org.testng.Assert;

import java.io.FileNotFoundException;

import static homework_jdi.commonelements.entities.JdiUser.ROMAN;
import static java.lang.String.format;

public class AssertionsStep {

    public AssertionsStep() {

    }

    public void openJsiSite() {
        JdiSite.open();
    }

    public void loginWasSuccessful() {
        JdiSite.login(ROMAN);
        String actualUserName = JdiSite.jdiHomePage.getUserName();
        Assert.assertEquals(actualUserName, ROMAN.getFullName(),
                format("Expected loggined user: %s, but get %s", ROMAN, actualUserName));
    }

    public void clickHeaderMenu(String metalsAndColors) {
        JdiSite.clickItemOfHeaderMenu(metalsAndColors);
    }

    public void pageIsOpened(String metalsAndColors) {
        JdiSite.metalColorsPage.checkOpened();
    }

    public void fillPageWithDataFromJson(Data data) throws FileNotFoundException {

        JdiSite.metalColorsPage.setSummary(data.getSummary());
        JdiSite.metalColorsPage.setVegetables(data.getVegetables());
        JdiSite.metalColorsPage.setColors(data.getColor());
        JdiSite.metalColorsPage.setElements(data.getElements());
        JdiSite.metalColorsPage.setMetals(data.getMetals());
        JdiSite.metalColorsPage.clickSubmit();

    }

    public void resultShouldBeSuccessful(Data data) {
        int expected = data.getSummary().get(0).intValue() + data.getSummary().get(1).intValue();
        Assert.assertEquals(JdiSite.metalColorsPage.getLog().getSummary(), Integer.valueOf(expected));
    }
}
