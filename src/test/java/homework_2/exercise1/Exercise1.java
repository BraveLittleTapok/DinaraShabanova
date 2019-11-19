package homework_2.exercise1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1 extends AbstractClassForDriver {

    @Test
    public void testingExercise_1() {
        // 1. open site
        driver.get("https://epam.github.io/JDI/index.html");

        //2.Assert Browser title ; 5.Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 3.Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        WebElement loginedUserName = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));

        // 4.Logined user's name is display correctly
        assertEquals(loginedUserName.getText(), "PITER CHAILOVSKII");

        //6.Menu buttons are displayed and have proper texts "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        WebElement home = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("" +
                        "//div[@class='uui-header dark-gray']//a[contains(text(),'Home')]")));
        WebElement contactForm = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("" +
                        "//div[@class='uui-header dark-gray']//a[contains(text(),'Contact form')]")));
        WebElement service = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("" +
                        "//div[@class='uui-header dark-gray']//a[contains(text(),'Service')]")));
        WebElement metalsColors = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("" +
                        "//div[@class='uui-header dark-gray']//a[contains(text(),'Metals & Colors')]")));

        assertTrue(home.isDisplayed());
        assertTrue(contactForm.isDisplayed());
        assertTrue(service.isDisplayed());
        assertTrue(metalsColors.isDisplayed());

        assertEquals(home.getText(), "HOME");
        assertEquals(contactForm.getText(), "CONTACT FORM");
        assertEquals(service.getText(), "SERVICE");
        assertEquals(metalsColors.getText(), "METALS & COLORS");

        //7. 4 Images are displayed
        WebElement imgPractise = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "//div[@class='col-sm-3']//span[@class='icons-benefit icon-practise']")));
        assertTrue(imgPractise.isDisplayed());
        WebElement imgCustom = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "//div[@class='col-sm-3']//span[@class='icons-benefit icon-custom']")));
        assertTrue(imgCustom.isDisplayed());

        WebElement imgMulti = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "//div[@class='col-sm-3']//span[@class='icons-benefit icon-multi']")));
        assertTrue(imgMulti.isDisplayed());

        WebElement imgBase = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "//div[@class='col-sm-3']//span[@class='icons-benefit icon-base']")));
        assertTrue(imgBase.isDisplayed());

        //8. Texts are displayed and equal to expected under images
        WebElement textUnderPractiseImg = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(), 'To include good practices')]")));
        assertTrue(textUnderPractiseImg.isDisplayed());
        assertEquals(textUnderPractiseImg.getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");

        WebElement textUnderCustomImg = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(), 'To be flexible and')]")));
        assertTrue(textUnderCustomImg.isDisplayed());
        assertEquals(textUnderCustomImg.getText(), "To be flexible and\n" +
                "customizable");

        WebElement textUnderMultiPlImg = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(), 'To be multiplatform')]")));
        assertTrue(textUnderMultiPlImg.isDisplayed());
        assertEquals(textUnderMultiPlImg.getText(), "To be multiplatform");

        WebElement textUnderBaseImg = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(), 'Already have good base')]")));
        assertTrue(textUnderBaseImg.isDisplayed());
        assertEquals(textUnderBaseImg.getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9. text of the main headers
        WebElement mainText = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.name("main-title")));
        assertTrue(mainText.isDisplayed());
        assertEquals(mainText.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement underMainText = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.name("jdi-text")));
        assertTrue(underMainText.isDisplayed());
        assertEquals(underMainText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    }
}
