package homework_6.exercise1.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import homework_5.WebDriverSingleton;
import homework_6.HomePage;
import homework_6.components.HeaderMenu;
import homework_6.components.MenuLeftSection;
import homework_6.components.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by dinar on 23.11.2019.
 */
public abstract class AbstractBaseSteps {
    protected WebDriver driver;
    protected static HomePage homePage;
    protected static User user;
    protected static HeaderMenu headerMenu;
    protected static MenuLeftSection leftMenu;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(30000, TimeUnit.MILLISECONDS);
        WebDriverSingleton.INSTANCE.setDriver(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
