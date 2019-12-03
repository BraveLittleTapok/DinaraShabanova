package homework_4.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by dinar on 24.11.2019.
 */
public class MenuLeftSection {

    public MenuLeftSection() {
        page(this);
    }

    public void leftMenuItemClick(final String itemOfLeftMenu) {
        $$(By.xpath("//ul[contains(@class,'sidebar-menu')]/li")).findBy(text(itemOfLeftMenu)).click();
    }

    public List<WebElement> getLeftSectionItems() {
        return $(By.xpath("//ul[contains(@class,'sidebar-menu')]")).findElements(By.tagName("li"));
    }

    public boolean dropDownHasElement(String item) {
        return getLeftSectionItems().stream()
                .anyMatch(p -> p.getText().equalsIgnoreCase(item));

    }
}
