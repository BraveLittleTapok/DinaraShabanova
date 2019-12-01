package homework_2.exercise1;


import homework_2.AbstractClassForDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

import static homework_2.Constants.*;
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
        List<WebElement> headerItems = driver.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li"));
        for (WebElement el: headerItems) {
            assertTrue(el.isDisplayed());
        }

        assertEquals(headerItems.get(0).getText(), "HOME");
        assertEquals(headerItems.get(1).getText(), "CONTACT FORM");
        assertEquals(headerItems.get(2).getText(), "SERVICE");
        assertEquals(headerItems.get(3).getText(), "METALS & COLORS");

        //7. 4 Images are displayed
        WebElement imgPractise = driver.findElement(By.xpath(
                "//div[@class='col-sm-3']//span[@class='icons-benefit icon-practise']"));
        assertTrue(imgPractise.isDisplayed());
        WebElement imgCustom = driver.findElement(By.xpath(
                "//div[@class='col-sm-3']//span[@class='icons-benefit icon-custom']"));
        assertTrue(imgCustom.isDisplayed());

        WebElement imgMulti = driver.findElement(By.xpath(
                "//div[@class='col-sm-3']//span[@class='icons-benefit icon-multi']"));
        assertTrue(imgMulti.isDisplayed());

        WebElement imgBase = driver.findElement(By.xpath(
                "//div[@class='col-sm-3']//span[@class='icons-benefit icon-base']"));
        assertTrue(imgBase.isDisplayed());

        //8. Texts are displayed and equal to expected under images
        WebElement textUnderPractiseImg = driver.findElement(
                By.xpath("//*[contains(text(), 'To include good practices')]"));
        assertTrue(textUnderPractiseImg.isDisplayed());
        assertEquals(textUnderPractiseImg.getText(), TEXT_FOR_PRACTISE);

        WebElement textUnderCustomImg = driver.findElement(
                By.xpath("//*[contains(text(), 'To be flexible and')]"));
        assertTrue(textUnderCustomImg.isDisplayed());
        assertEquals(textUnderCustomImg.getText(), TEXT_FOR_CUSTOM);

        WebElement textUnderMultiPlImg = driver.findElement(
                By.xpath("//*[contains(text(), 'To be multiplatform')]"));
        assertTrue(textUnderMultiPlImg.isDisplayed());
        assertEquals(textUnderMultiPlImg.getText(), TEXT_FOR_MULTI);

        WebElement textUnderBaseImg = driver.findElement(
                By.xpath("//*[contains(text(), 'Already have good base')]"));
        assertTrue(textUnderBaseImg.isDisplayed());
        assertEquals(textUnderBaseImg.getText(), TEXT_FOR_BASE);

        //9. text of the main headers
        WebElement mainText = driver.findElement(By.name("main-title"));
        assertTrue(mainText.isDisplayed());
        assertEquals(mainText.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement underMainText = driver.findElement(By.name("jdi-text"));
        assertTrue(underMainText.isDisplayed());
        assertEquals(underMainText.getText(), TEXT_UNDER_MAIN_TITLE);

        //10. Assert that there is the iframe in the center of page
        WebElement frame = driver.findElement(By.id("iframe"));
        assertTrue(frame.isDisplayed());

        //11. Switch to the iframe and check that there is Epam logo in the left
        // top conner of iframe
        driver.switchTo().frame("iframe");
        WebElement epamLogo = driver.findElement(By.id("epam_logo"));
        assertTrue(epamLogo.isDisplayed());

        // 12. Switch to original window back
        driver.switchTo().defaultContent();

        // 13. Assert a text of the sub header
        WebElement linkGithub = driver.findElement(By.xpath("//h3[@class='text-center']/a[@ui='link']"));
        assertTrue(linkGithub.isDisplayed());
        assertEquals(linkGithub.getText(), "JDI GITHUB");

        //14.Assert that JDI GITHUB is a link and has a proper URL
        String urlGithub = "https://github.com/epam/JDI";
        assertEquals(linkGithub.getAttribute("href"), urlGithub);

        //15. Assert that there is Left Section
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());

        //16.Assert that there is Footer
        assertTrue(driver.findElement(By.className("footer-bg")).isDisplayed());


    }
}
