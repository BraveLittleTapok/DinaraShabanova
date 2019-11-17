package homework_2.exercise1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by dinar on 17.11.2019.
 */
public class AbstractClassForDriver {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(3000, TimeUnit.MILLISECONDS);
    }

    @AfterTest
    public void tearUp() {
        driver.quit();
        driver = null;
    }
}
