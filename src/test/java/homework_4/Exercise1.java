package homework_4;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by dinar on 24.11.2019.
 */
public class Exercise1 {
    @Test
    public void exercise1() {
        open("https://epam.github.io/JDI/index.html");

        HomePage homePage = new HomePage();
        homePage.login("epam", "1234");
        $(By.linkText("Contact form")).click();

    }
}
