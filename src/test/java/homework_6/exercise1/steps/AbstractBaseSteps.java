package homework_6.exercise1.steps;

import homework_6.DifferentElementsPage;
import homework_6.HomePage;
import homework_6.components.HeaderMenu;
import homework_6.components.MenuLeftSection;
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
    protected static MenuLeftSection leftMenu;
    protected static DifferentElementsPage diffPage;
}
