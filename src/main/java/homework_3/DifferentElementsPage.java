package homework_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by dinar on 23.11.2019.
 */
public class DifferentElementsPage extends AbstractBasePage {
    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "label-checkbox")
    private List<WebElement> elementsOfCheckbox;

    @FindBy(className = "label-radio")
    private List<WebElement> elementsOfRadio;

    @FindBy(xpath = "//div[@class='main-content-hg']/div[@class='colors']")
    private List<WebElement> elementsOfColors;

    @FindBy(xpath = "//div[@class='main-content-hg']/button")
    private WebElement defaultButton;

    @FindBy(xpath = "//div[@class='main-content-hg']/input")
    private WebElement button;

    @FindBy(name = "log-sidebar")
    private WebElement rightSection;

    @FindBy(id = "mCSB_1")
    private WebElement leftSection;

    @FindBy(xpath = "//div[@class='info-panel-section']/ul/li")
    private List<WebElement> listOfLogs;

    @FindBy(xpath = "//div[@class='main-content-hg']/div[@class='colors']/select[@class='uui-form-element']")
    private WebElement dropDown;

    public WebElement getElementFromCheckBox(final String element){
        WebElement ret = null;
        for (WebElement el: elementsOfCheckbox) {
            if (el.getText().equalsIgnoreCase(element)){
                ret = el;
            }
        }
        return ret;
    }

    public WebElement getElementFromRadio(final String element){
        WebElement ret = null;
        for (WebElement el: elementsOfRadio) {
            if (el.getText().equalsIgnoreCase(element)){
                ret = el;
            }
        }
        return ret;
    }

    public List<WebElement> getElementsOfCheckbox() {
        return elementsOfCheckbox;
    }

    public List<WebElement> getElementsOfRadio() {
        return elementsOfRadio;
    }

    public List<WebElement> getElementsOfColors() {
        return elementsOfColors;
    }

    public WebElement getDefaultButton() {
        return defaultButton;
    }

    public WebElement getButton() {
        return button;
    }

    public WebElement getRightSection() {
        return rightSection;
    }

    public WebElement getLeftSection() {
        return leftSection;
    }

    public List<WebElement> getListOfLogs() {
        return listOfLogs;
    }

    public Select getDropDown() {
        return new Select(dropDown);
    }
}
