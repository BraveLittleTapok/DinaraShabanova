package homework_3;

import homework_3.components.HeaderMenu;
import homework_3.components.User;
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

    public void openEpamJdiSite() {
        homePage.open();
    }

    public void login(final String username, final String password) {
        user.userIconClick();
        user.fillLoginField(username);
        user.fillPasswordField(password);
        user.clickLoginButton();
    }

    public void headerMenuItemClick(final String item) {
        headerMenu.headerMenuItemClick(item);
    }

    public void usernameOnTheHomePageShouldBe(final String username) {
        assertEquals(user.getUsernameLabelText(), username);
    }

}