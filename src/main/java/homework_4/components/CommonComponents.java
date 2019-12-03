package homework_4.components;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by Dinara Shabanova on 26.11.2019.
 */
public class CommonComponents {

    public CommonComponents() {

        page(this);
    }

    public boolean hasRightSection() {
        return $(By.id("mCSB_1_container")).isDisplayed();
    }

    public boolean hasLeftSection() {
        return $(By.id("mCSB_2")).isDisplayed();
    }

}
