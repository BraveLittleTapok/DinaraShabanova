package homework_6.common;

import homework_6.components.HeaderMenu;
import homework_6.components.MenuLeftSection;
import homework_6.components.User;
import homework_6.pages.DifferentElementsPage;
import homework_6.pages.HomePage;
import homework_6.pages.UserTablePage;
import org.openqa.selenium.WebDriver;

import static homework_6.common.WebDriverSingleton.INSTANCE;
import static org.testng.Assert.assertEquals;

/**
 * Created by dinar on 23.11.2019.
 */
public abstract class AbstractBaseSteps {
    protected WebDriver driver;
    protected static HomePage homePage;
    protected static User user;
    protected static HeaderMenu headerMenu;
    protected static MenuLeftSection leftMenu;
    protected static DifferentElementsPage diffPage;
    protected static UserTablePage tablePage;

    public AbstractBaseSteps() {
        homePage = new HomePage(INSTANCE.getDriver());
        user = new User(INSTANCE.getDriver());
        headerMenu = new HeaderMenu(INSTANCE.getDriver());
        leftMenu = new MenuLeftSection(INSTANCE.getDriver());
        diffPage = new DifferentElementsPage(INSTANCE.getDriver());
        tablePage = new UserTablePage(INSTANCE.getDriver());
    }



}
