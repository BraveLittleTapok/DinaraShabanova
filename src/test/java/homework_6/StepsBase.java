package homework_6;

import homework_6.components.HeaderMenu;
import homework_6.components.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

/**
 * Created by dinar on 23.11.2019.
 */
public class StepsBase {

    protected HomePage homePage;
    protected HeaderMenu headerMenu;
    protected User user;

    public StepsBase(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.headerMenu = new HeaderMenu(driver);
        this.headerMenu = new HeaderMenu(driver);
        this.user = new User(driver);
    }

    @Step("I open EPAM JDI Site")
    public void openEpamJdiSite() {
        homePage.open();
    }

    @Step("I login as '{0}' with password '{1}'")
    public void login(final String username, final String password) {
        user.userIconClick();
        user.fillLoginField(username);
        user.fillPasswordField(password);
        user.clickLoginButton();
    }

    @Step("I click item '{0}' on the Header Menu")
    public void headerMenuItemClick(final String item) {
        headerMenu.headerMenuItemClick(item);
    }

    @Step("Username should be '{0}' on the Home Page")
    public void usernameOnTheHomePageShouldBe(final String username) {
        assertEquals(user.getUsernameLabelText(), username);
    }

}