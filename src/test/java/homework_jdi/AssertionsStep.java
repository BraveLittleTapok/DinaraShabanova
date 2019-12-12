package homework_jdi;

import org.testng.Assert;

import static homework_jdi.commonelements.entities.JdiUser.ROMAN;
import static java.lang.String.format;

public class AssertionsStep {

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

    public void fillPageWithDataFromJson(Data data) {
       // JdiSite.metalColorsPage.setSummary(data.getSummary());
    }

}
