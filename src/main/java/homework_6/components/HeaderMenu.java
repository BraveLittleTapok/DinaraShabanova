package homework_6.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
public class HeaderMenu {

    private WebDriver driver;

    public HeaderMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[contains(@class,'navbar-nav m-l8')]/li")
    private List<WebElement> headerItems;

    @FindBy(xpath = "//ul[contains(@class,'navbar-nav m-l8')]/li[@class='dropdown open']/ul/li")
    private List<WebElement> dropDownItems;

    public void headerMenuItemClick(final String itemOfHeaderMenu) {
        for (WebElement menuHeaderItem : headerItems) {
            if (itemOfHeaderMenu.equalsIgnoreCase(menuHeaderItem.getText())) {
                menuHeaderItem.click();
                break;
            }
        }
    }

    public void dropDownMenuItemClick(final String item) {
        for (WebElement menuSub : dropDownItems) {
            if (item.equalsIgnoreCase(menuSub.getText())) {
                menuSub.click();
                break;
            }
        }
    }

    public boolean serviceContainsAllSubCategories(List<String> menu) {
        List<String> actualItems = dropDownItems.stream()
                .map(p -> p.getText())
                .collect(Collectors.toList());
        return actualItems
                .stream()
                .collect(groupingBy(k -> k, counting()))
                .equals(menu.stream()
                        .collect(groupingBy(k -> k, counting())));

    }

}
