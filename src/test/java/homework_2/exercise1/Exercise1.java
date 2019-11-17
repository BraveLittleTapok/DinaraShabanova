package homework_2.exercise1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Exercise1 extends AbstractClassForDriver {

    // 1. Checking opening site
    @Test
    public void openSiteTesting() {
        driver.get("https://epam.github.io/JDI/index.html");
    }

    //2.Assert Browser title
    @Test
    public void browserTitleTesting() {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        assertEquals(driver.getTitle(), "Home Page");
    }

    // 3.Perform login


    // 4.Logined user's name is display correctly
    @Test
    public void logInTesting() {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        WebElement loginedUserName = new WebDriverWait(driver,15)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        assertEquals(loginedUserName.getText(),"PITER CHAILOVSKII");

    }
}
