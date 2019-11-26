package homework_4.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by dinar on 23.11.2019.
 */
public class HeaderMenu {

    public HeaderMenu() {
        page(this);
    }

    public void headerMenuItemClick(final String itemOfHeaderMenu) {
        $$(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li"))
                .findBy(text(itemOfHeaderMenu)).click();
    }

    public void dropDownMenuItemClick(final String item) {
        $$(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']" +
                "/li[@class='dropdown open']/ul/li"))
                .findBy(text(item)).click();
    }

   /* public List<WebElement> getHeaderItems() {
        return headerItems;
    }*/

    /*public WebElement getItem(final String itemOfHeaderMenu) {
        WebElement item = null;
        for (WebElement menuHeaderItem : headerItems) {
            if (itemOfHeaderMenu.equalsIgnoreCase(menuHeaderItem.getText())) {
                item = menuHeaderItem;
            }
        }
        return item;
    }*/

    public List<WebElement> getDropDownItems() {
        return $(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']" +
                "/li[@class='dropdown open']/ul")).findElements(By.tagName("li"));
    }

    public boolean dropDownHasElement(String item) {
        return getDropDownItems().stream()
                .anyMatch(p -> p.getText().equalsIgnoreCase(item));
    }

}
