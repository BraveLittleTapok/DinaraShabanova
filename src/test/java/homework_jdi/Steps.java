package homework_jdi;

import homework_jdi.commonelements.HeaderMenuItems;
import org.testng.Assert;

import static homework_jdi.commonelements.entities.JdiUser.ROMAN;
import static java.lang.String.format;
public class Steps {

    public Steps() {
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

    public void clickHeaderMenu(HeaderMenuItems metalsAndColors) {
        JdiSite.clickItemOfHeaderMenu(metalsAndColors);
    }

    public void pageIsOpened(HeaderMenuItems item) {
        switch (item) {
            case METALS_AND_COLORS:
                JdiSite.metalColorsPage.checkOpened();
                break;
        }
    }

    public void fillPageWithDataFromJson(DataFromJsonForMetalsColorPage dataFromJsonForMetalsColorPage) {
        JdiSite.metalColorsPage.refresh();
        JdiSite.metalColorsPage.setSummary(dataFromJsonForMetalsColorPage.getSummary());
        JdiSite.metalColorsPage.setVegetables(dataFromJsonForMetalsColorPage.getVegetables());
        JdiSite.metalColorsPage.setColors(dataFromJsonForMetalsColorPage.getColor());
        JdiSite.metalColorsPage.setElements(dataFromJsonForMetalsColorPage.getElements());
        JdiSite.metalColorsPage.setMetals(dataFromJsonForMetalsColorPage.getMetals());
        JdiSite.metalColorsPage.clickSubmit();

    }
    public void resultShouldBeSuccessful(DataFromJsonForMetalsColorPage dataFromJson) {
        int expected = dataFromJson.getSummary().get(0).intValue() + dataFromJson.getSummary().get(1).intValue();
        Assert.assertEquals(JdiSite.metalColorsPage.getLog().getSummary(), Integer.valueOf(expected));
        DataFromJsonForMetalsColorPage actualDataWithoutSummary = getObjectWithDataFromSite();
        Assert.assertTrue(actualDataWithoutSummary.equals(dataFromJson));
    }

    private DataFromJsonForMetalsColorPage getObjectWithDataFromSite(){
        DataFromJsonForMetalsColorPage actualData = new DataFromJsonForMetalsColorPage();
        actualData.setColor(JdiSite.metalColorsPage.getLog().getColor());
        actualData.setElements(JdiSite.metalColorsPage.getLog().getElements());
        actualData.setMetals(JdiSite.metalColorsPage.getLog().getMetals());
        actualData.setVegetables(JdiSite.metalColorsPage.getLog().getVegetables());

        return actualData;

    }
}
