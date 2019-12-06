package homework_6;

import homework_6.components.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dinar on 23.11.2019.
 */
public class AbstractBasePage {

    protected WebDriver driver;

    private HeaderMenu headerMenu;

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        headerMenu = new HeaderMenu(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

}
