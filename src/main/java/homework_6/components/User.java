package homework_6.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.How.CSS;

/**
 * Created by dinar on 23.11.2019.
 */
public class User {

    private WebDriver driver;

    public User(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(how = CSS, using = "#name")
    private WebElement usernameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement usernameLabel;

    public void userIconClick() {
        userIcon.click();
    }

    public void fillLoginField(String username) {
        usernameTextField.sendKeys(username);
    }

    public void fillPasswordField(String password) {
        passwordTextField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getUsernameLabelText() {
        return usernameLabel.getText();
    }


}
