package homework_2.exercise2;

import homework_2.AbstractClassForDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static homework_2.Constants.listDropMenuService;

/**
 * Created by Dinara Shabanova on 21.11.2019.
 */
public class Exercise2 extends AbstractClassForDriver {

    @Test
    public void exercise2() {
        SoftAssert softAssert = new SoftAssert();
        // 1. open site
        driver.get("https://epam.github.io/JDI/index.html");

        //2.Assert Browser title ; 5.Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        // 3.Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        WebElement loginedUserName = driver.findElement(By.id("user-name"));

        // 4.Logined user's name is display correctly
        softAssert.assertEquals(loginedUserName.getText(), "PITER CHAILOVSKII");

        //5. Drop down "Service" in the header contains subcategories with options
        driver.findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//*" +
                "[@class='dropdown-toggle']")).click();

        for (String option : listDropMenuService) {
            WebElement element = driver.findElement(By.xpath(
                    "//ul[@class='uui-navigation nav navbar-nav m-l8']//*" +
                            "[@class='dropdown-menu']" +
                            "//*[contains(text(),'" + option + "')]"));
            softAssert.assertTrue(element.isDisplayed());
        }

        //6. Drop down "Service" in the left section contains subcategories with options
        driver.findElement(By.xpath("//ul[@class='sidebar-menu']/li[@class='menu-title']/a")).click();
        for (String option : listDropMenuService) {
            WebElement element = driver.findElement(By.xpath(
                    "//ul[@class='sidebar-menu']/li[@class='menu-title']" +
                            "//*[contains(text(),'" + option + "')]"));
            softAssert.assertTrue(element.isDisplayed());
        }

        // 7. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//*" +
                "[@class='dropdown-toggle']")).click();
        driver.findElement(By.xpath(
                "//ul[@class='uui-navigation nav navbar-nav m-l8']//*" +
                        "[@class='dropdown-menu']" +
                        "//*[contains(text(),'Different elements')]")).click();
        softAssert.assertEquals(driver.getTitle(), "Different Elements");

        //8.Check interface on Different elements page, it contains all needed elements: 4 checkboxes,
        // 4 radios, 1 dropdown, 2 buttons
        WebElement element = null;
        int countCheckbox = 0;
        do{
            try {
                element = driver.findElement(By.xpath(
                        "//div[@class='main-content-hg']/div[2]/label[" + ++countCheckbox +"]"
                ));
            }catch (NoSuchElementException e) {
                --countCheckbox;
                element = null;
            }
        }while(element != null );

        int countRadio = 0;
        do{
            try {
                element = driver.findElement(By.xpath(
                        "//div[@class='main-content-hg']/div[3]/label[" + ++countRadio +"]"
                ));
            }catch (NoSuchElementException e) {
                --countRadio;
                element = null;
            }
        }while(element != null );
        softAssert.assertEquals(countCheckbox, 4);
        softAssert.assertEquals(countRadio, 4);
       /* for (int i = 1; i <= 4; i++) {
            softAssert.assertTrue(driver.findElement(By.xpath(
                    "//div[@class='main-content-hg']/div[2]/label[" + i +"]"
            )).isDisplayed());
            softAssert.assertTrue(driver.findElement(By.xpath(
                    "//div[@class='main-content-hg']/div[3]/label[" + i +"]"
            )).isDisplayed());
        }*/
        softAssert.assertAll();
    }
}
