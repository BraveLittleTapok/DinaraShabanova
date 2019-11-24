package homework_3.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by dinar on 24.11.2019.
 */
public class MenuLeftSection {
    private WebDriver driver;

    public MenuLeftSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='sidebar-menu']/li")
    private List<WebElement> leftSectionItems;

    public void leftMenuItemClick(final String itemOfLeftMenu) {
        for (WebElement item : leftSectionItems) {
            if (itemOfLeftMenu.equalsIgnoreCase(item.getText())) {
                item.click();
                break;
            }
        }
    }

    public List<WebElement> getLeftSectionItems() {
        return leftSectionItems;
    }
}
