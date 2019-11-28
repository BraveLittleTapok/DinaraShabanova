package homework_4.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by dinar on 24.11.2019.
 */
public class HomePage {

    public HomePage() {
        page(this);

    }

    public String getTitle() {
        return Selenide.title();
    }

    public void login(final String username, final String password) {
        $(By.id("user-icon")).click();
        $(By.id("name")).sendKeys(username);
        $(By.id("password")).sendKeys(password);
        $(By.id("login-button")).click();
    }

    public SelenideElement getUsernameLabelText() {
        return $(By.id("user-name"));
    }

}
