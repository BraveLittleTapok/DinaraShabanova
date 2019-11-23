package homework_2.exercise2;

import homework_2.AbstractClassForDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static homework_2.Constants.listDropMenuService;

/**
 * Created by Dinara Shabanova on 21.11.2019.
 */
public class Exercise2 extends AbstractClassForDriver {

    @Test
    public void testingExercise2() {
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
                            "//span[contains(text(),'" + option + "')]"));
            softAssert.assertTrue(element.isDisplayed());
        }
        // 7. Open through the header menu Service -> Different Elements Page
        WebElement itemService = driver.findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//" +
                "li[@class='dropdown']"));
        itemService.click();
        itemService.findElement(By.xpath("//a[contains(text(),'Different elements')]")).click();
        softAssert.assertEquals(driver.getTitle(), "Different Elements");

        //8.Check interface on Different elements page, it contains all needed elements: 4 checkboxes,
        // 4 radios, 1 dropdown, 2 buttons
        //check that there exactly 4 element for each
        WebElement elements = driver.findElement(By.className("main-content-hg"));
        List<WebElement> listOfElements = elements.findElements(By.className("label-checkbox"));
        softAssert.assertEquals(listOfElements.size(), 4);

        listOfElements = elements.findElements(By.className("label-radio"));
        softAssert.assertEquals(listOfElements.size(), 4);
        //softAssert.assertEquals(countRadio, 4);
        //dropdown element
        elements = driver.findElement(By.xpath("//div[@class='main-content-hg']/div[@class='colors']"));
        listOfElements = elements.findElements(By.tagName("select"));
        softAssert.assertEquals(listOfElements.size(), 1);

        //first buttons
        softAssert.assertTrue(driver.findElement(By.xpath(
                "//div[@class='main-content-hg']//button[@value='Default Button']")).isDisplayed());
        //second button
        softAssert.assertTrue(driver.findElement(By.xpath(
                "//div[@class='main-content-hg']//input[@value='Button']")).isDisplayed());

        //9. Assert that there is Right Section
        softAssert.assertTrue(driver.findElement(By.name("log-sidebar")).isDisplayed());

        //10. Assert that there is Right Section
        softAssert.assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());

        //11. Select checkboxes: Water, Wind and (12.) Assert that for each checkbox there is an individual 
        // log row and value is corresponded to the status of checkbox.  AND 17. Unselect and assert checkboxes Water, Wind
        //AND 18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        //Log rows are displayed, checkbox name and its status is corresponding to selected

        //Water checked select and check lo row
        WebElement elementWater = driver.findElement(By.xpath("//div[@class='main-content-hg']//" +
                "label[text()[contains(.,'Water')]]/input[@type='checkbox']"));
        elementWater.click();
        softAssert.assertTrue(elementWater.isSelected());
        WebElement log = driver.findElement(By.xpath("//div[@class='info-panel-section']/ul"));
        List<WebElement> listOfLog = log.findElements(By.tagName("li"));
        softAssert.assertTrue(listOfLog.get(0).getText().contains("Water: condition changed to true")
                & listOfLog.get(0).isDisplayed());

        //Water unchecked select and check row
        elementWater.click();
        listOfLog = log.findElements(By.tagName("li"));
        softAssert.assertTrue(listOfLog.get(0).getText().contains("Water: condition changed to false")
                & listOfLog.get(0).isDisplayed());

        //Wind checked select and check row
        WebElement elementWind = driver.findElement(By.xpath("//div[@class='main-content-hg']//" +
                "label[text()[contains(.,'Wind')]]/input[@type='checkbox']"));
        elementWind.click();
        softAssert.assertTrue(elementWind.isSelected());
        listOfLog = log.findElements(By.tagName("li"));
        softAssert.assertTrue(listOfLog.get(0).getText().contains("Wind: condition changed to true")
                & listOfLog.get(0).isDisplayed());
        //Wind unchecked select and check row
        elementWind.click();
        listOfLog = log.findElements(By.tagName("li"));
        softAssert.assertTrue(listOfLog.get(0).getText().contains("Wind: condition changed to false")
                & listOfLog.get(0).isDisplayed());

        //13. Select radio and 14. Assert that for button there is a log row and
        // value is corresponded to the status of radio button. 
        WebElement element = driver.findElement(By.xpath("//div[@class='main-content-hg']//" +
                "label[text()[contains(.,'Gold')]]/input[@type='radio']"));
        element.click();
        softAssert.assertTrue(element.isSelected());

        listOfLog = log.findElements(By.tagName("li"));
        softAssert.assertTrue(listOfLog.get(0).getText().contains("metal: value changed to Gold")
                & listOfLog.get(0).isDisplayed());

        //15. Select in dropdown Yellow AND 16. Assert that for dropdown there is a log row and value is corresponded to the selected value. 

        Select dropDown = new Select(driver.findElement(By.xpath("//div[@class='main-content-hg']//" +
                "select[@class='uui-form-element']")));
        dropDown.selectByVisibleText("Yellow");
        softAssert.assertTrue(dropDown.getFirstSelectedOption().isSelected());
        listOfLog = log.findElements(By.tagName("li"));
        softAssert.assertTrue(listOfLog.get(0).getText().contains("Colors: value changed to Yellow")
                & listOfLog.get(0).isDisplayed());

        softAssert.assertAll();
    }

}
