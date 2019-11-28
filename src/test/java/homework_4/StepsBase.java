package homework_4;

import com.codeborne.selenide.Selenide;
import homework_4.components.HeaderMenu;
import homework_4.components.MenuLeftSection;
import homework_4.pages.HomePage;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.text;

/**
 * Created by dinar on 23.11.2019.
 */
public class StepsBase {

    protected HomePage homePage;
    protected HeaderMenu headerMenu;
    protected SoftAssert softAssert;
    protected MenuLeftSection leftMenu;

    public StepsBase() {
        this.homePage = new HomePage();
        this.headerMenu = new HeaderMenu();
        this.softAssert = new SoftAssert();
        this.leftMenu = new MenuLeftSection();
    }

    public void clickHeaderMenu(String service) {
        headerMenu.headerMenuItemClick(service);
    }

    public void clickLeftMenuItem(String item) {
        leftMenu.leftMenuItemClick(item);
    }

    public void login(final String username, final String password) {
        homePage.login(username, password);
    }

    public void titleShouldBe(String title) {
        softAssert.assertTrue(Selenide.title().equalsIgnoreCase(title));
    }

    public void userNameShouldBe(String name) {
        homePage.getUsernameLabelText().shouldBe(text(name));
    }

    public void softAssertAll() {
        softAssert.assertAll();
    }

}