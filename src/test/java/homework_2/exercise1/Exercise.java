package homework_2.exercise1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
/**
 * Created by dinar on 17.11.2019.
 */
public class Exercise {
    @Test
    public void loginTest() {
       System.setProperty("webdriver.chrome.driver", this.getClass().getClassLoader()
                .getResource("driver/chromedriver").getPath());
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
    }

}
