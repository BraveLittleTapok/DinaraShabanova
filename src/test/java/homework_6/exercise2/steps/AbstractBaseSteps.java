package homework_6.exercise2.steps;

import homework_6.pages.HomePage;
import homework_6.pages.UserTablePage;
import homework_6.components.HeaderMenu;
import homework_6.components.User;
import org.openqa.selenium.WebDriver;

/**
 * Created by dinar on 23.11.2019.
 */
public abstract class AbstractBaseSteps {
    protected WebDriver driver;
    protected static HomePage homePage;
    protected static User user;
    protected static HeaderMenu headerMenu;
    protected static UserTablePage tablePage;


}
