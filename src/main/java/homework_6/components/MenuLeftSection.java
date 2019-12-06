package homework_6.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by dinar on 24.11.2019.
 */
public class MenuLeftSection {
    private WebDriver driver;

    public MenuLeftSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[contains(@class,'sidebar-menu')]/li")
    private List<WebElement> leftSectionItems;

    @FindBy(xpath = "//ul[contains(@class,'sub')]//li")
    private List<WebElement> dropDownItems;

    public void leftMenuItemClick(final String itemOfLeftMenu) {
        for (WebElement item : leftSectionItems) {
            if (itemOfLeftMenu.equalsIgnoreCase(item.getText())) {
                item.click();
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
    public List<WebElement> getLeftSectionItems() {
        return leftSectionItems;
    }
}
