package homework_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePage extends AbstractBasePage {

    public UserTablePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//tr[2]//td[2]")
    private List<WebElement> dropdown;

    @FindBy(xpath = "//tr[2]//td[3]")
    private List<WebElement> userNames;

    @FindBy(xpath = "//tr[2]//td[4]")
    private List<WebElement> descriptionImages;

}
