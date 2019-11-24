package homework_3;

import homework_3.components.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by dinar on 23.11.2019.
 */
public class HomePage extends AbstractBasePage {

    private static final String URL = "https://epam.github.io/JDI/index.html";

    private User user = new User(driver);

    @FindBy(id = "mCSB_1")
    private WebElement leftSection;

    @FindBy(className = "footer-bg")
    private WebElement footer;

    @FindBy(xpath = "//h3[@class='text-center']/a[@ui='link']")
    private WebElement linkGithub;

    @FindBy(id = "iframe")
    private WebElement frame;

    @FindBy(id = "epam_logo")
    private WebElement epamLogo;

    @FindBy(xpath = "//div[@class='col-sm-3']//span[@class='icons-benefit icon-practise']")
    private WebElement firstCenterImg;

    @FindBy(xpath = "//div[@class='col-sm-3']//span[@class='icons-benefit icon-custom']")
    private WebElement secondCenterImg;

    @FindBy(xpath = "//div[@class='col-sm-3']//span[@class='icons-benefit icon-multi']")
    private WebElement thirdCenterImg;

    @FindBy(xpath = "//div[@class='col-sm-3']//span[@class='icons-benefit icon-base']")
    private WebElement fourthCenterImg;

    @FindBy(xpath = "//div[@class='row clerafix benefits']//span[contains(text(), 'To include good practices')]")
    private WebElement firstTextCenterImg;

    @FindBy(xpath = "//div[@class='row clerafix benefits']//span[contains(text(), 'To be flexible and')]")
    private WebElement secondTextCenterImg;

    @FindBy(xpath = "//div[@class='row clerafix benefits']//span[contains(text(), 'To be multiplatform')]")
    private WebElement thirdTextCenterImg;

    @FindBy(xpath = "//div[@class='row clerafix benefits']//span[contains(text(), 'Already have good base')]")
    private WebElement fourthTextCenterImg;

    @FindBy(name = "main-title")
    private WebElement mainTitle;

    @FindBy(name = "jdi-text")
    private WebElement textUnderMainTitle;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(URL);
    }

    public void userIconClick() {
        user.getUserIcon().click();
    }

    public void fillLoginField(String username) {
        user.getUsernameTextField().sendKeys(username);
    }

    public void fillPasswordField(String password) {
        user.getPasswordTextField().sendKeys(password);
    }

    public void clickLoginButton() {
        user.getLoginButton().click();
    }

    public String getUsernameLabelText() {
        return user.getUsernameLabel().getText();
    }

    public WebElement getFirstCenterImg() {
        return firstCenterImg;
    }

    public WebElement getSecondCenterImg() {
        return secondCenterImg;
    }

    public WebElement getThirdCenterImg() {
        return thirdCenterImg;
    }

    public WebElement getFourthCenterImg() {
        return fourthCenterImg;
    }

    public String getFirstTextCenterImg() {
        return firstTextCenterImg.getText();
    }

    public String getSecondTextCenterImg() {
        return secondTextCenterImg.getText();
    }

    public String getThirdTextCenterImg() {
        return thirdTextCenterImg.getText();
    }

    public String getFourthTextCenterImg() {
        return fourthTextCenterImg.getText();
    }

    public WebElement getMainTitle() {
        return mainTitle;
    }

    public WebElement getTextUnderMainTitle() {
        return textUnderMainTitle;
    }

    public void openFrame() {
        driver.switchTo().frame("iframe");
    }

    public WebElement getFrame() {
        return frame;
    }

    public WebElement getEpamLogo() {
        return epamLogo;
    }

    public WebElement getLeftSection() {
        return leftSection;
    }

    public WebElement getFooter() {
        return footer;
    }

    public WebElement getLinkGithub() {
        return linkGithub;
    }
}