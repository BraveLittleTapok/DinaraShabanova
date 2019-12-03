package homework_4;

import com.codeborne.selenide.Selenide;
import homework_4.components.HeaderMenu;
import homework_4.components.MenuLeftSection;
import homework_4.pages.HomePage;
import io.qameta.allure.Step;
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

    @Step("I click item '{0}' on the Header Menu")
    public void clickHeaderMenu(String service) {
        headerMenu.headerMenuItemClick(service);
    }

    @Step("I click item '{0}' on the Left Menu")
    public void clickLeftMenuItem(String item) {
        leftMenu.leftMenuItemClick(item);
    }

    @Step("I login as '{0}' with password '{1}'")
    public void login(final String username, final String password) {
        homePage.login(username, password);
    }

    @Step("Title should be '{0}'")
    public void titleShouldBe(String title) {
        softAssert.assertTrue(Selenide.title().equalsIgnoreCase(title));
    }

    @Step("Username should be '{0}' on the Home Page")
    public void userNameShouldBe(String name) {
        homePage.getUsernameLabelText().shouldBe(text(name));
    }

    public void softAssertAll() {
        softAssert.assertAll();
    }

}