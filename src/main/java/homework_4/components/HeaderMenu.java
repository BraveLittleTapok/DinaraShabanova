package homework_4.components;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by dinar on 23.11.2019.
 */
public class HeaderMenu {

    public HeaderMenu() {
        page(this);
    }

    public void headerMenuItemClick(final String itemOfHeaderMenu) {
        $$(By.xpath("//ul[contains(@class,'navbar-nav m-l8')]/li"))
                .findBy(text(itemOfHeaderMenu)).click();
    }

    public void dropDownMenuItemClick(final String item) {
        $$(By.xpath("//ul[contains(@class,'navbar-nav m-l8')]" +
                "/li[@class='dropdown open']/ul/li"))
                .findBy(text(item)).click();
    }

    public ElementsCollection getDropDownItems() {
        return $$(By.xpath("//ul[contains(@class,'navbar-nav m-l8')]" +
                "/li[@class='dropdown open']/ul/li"));
    }

    public boolean dropDownHasElement(String item) {
        return getDropDownItems().stream()
                .anyMatch(p -> p.getText().equalsIgnoreCase(item));
    }

}
