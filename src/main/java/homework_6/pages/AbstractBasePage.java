package homework_6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AbstractBasePage {

    protected WebDriver driver;
    @FindBy(xpath = "//div[contains(@class,'info-panel-body-log')]//ul/li")
    protected List<WebElement> listOfLogs;

    protected AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getListOfLogs() {
        return listOfLogs;
    }
}
