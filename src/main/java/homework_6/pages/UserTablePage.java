package homework_6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserTablePage extends AbstractBasePage {

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//tbody")
    private WebElement body;

    @FindBy(xpath = "//table[@id='user-table']//tr")
    private List<WebElement> elementsOfBody;

    @FindBy(xpath = "//tbody//tr//td[1]")
    private List<WebElement> numbers;

    @FindBy(xpath = "//tbody//tr//td[2]//select")
    private List<WebElement> dropdowns;

    @FindBy(xpath = "//tbody//tr//td[3]")
    private List<WebElement> userNames;

    @FindBy(xpath = "//tbody//tr//td[4]")
    private List<WebElement> descriptions;

    public List<WebElement> getNumbers() {
        return numbers;
    }

    public List<WebElement> getDropdown() {
        return dropdowns;
    }

    public List<WebElement> getUserNames() {
        return userNames;
    }

    public List<WebElement> geElementsOfBody() {
        return body.findElements(By.tagName("tr"));
    }

    public List<WebElement> getDescriptionImages() {
        return descriptions;
    }

    public List<WebElement> getDescriptionUnderImages() {
        return getDescriptionImages().stream()
                .map(p -> p.findElement(By.tagName("span")))
                .collect(Collectors.toList());
    }

    public List<WebElement> getCheckboxes() {
        return getDescriptionImages().stream()
                .map(p -> p.findElement(By.tagName("input")))
                .collect(Collectors.toList());
    }

    public List<String> getNumbersValues() {
        return body.findElements(By.xpath("//td[1]")).stream()
                .map(p -> p.getText())
                .map(p -> p.trim())
                .collect(Collectors.toList());
    }

    public List<String> getDescriptionOfUser() {
        return body.findElements(By.tagName("span")).stream()
                .map(p -> p.getText())
                .map(p -> p.trim())
                .map(p -> p.replaceAll("\\s", " "))
                .collect(Collectors.toList());
    }

    public List<String> getUserNamesText() {
        return getUserNames().stream()
                .map(p -> p.getText())
                .map(p -> p.trim())
                .collect(Collectors.toList());
    }

    public void clickVipForUser(String fullName) {
        for (int i = 1; i < geElementsOfBody().size(); i++) {
            if (geElementsOfBody().get(i).findElement(By.tagName("a")).getText().equals(fullName)) {
                geElementsOfBody().get(i).findElement(By.tagName("input")).click();
            }
        }
    }

    public void clickDropdownForRoman() {
        for (int i = 1; i < geElementsOfBody().size(); i++) {
            if (geElementsOfBody().get(i).findElement(By.tagName("a")).getText().equals("Roman")) {
                geElementsOfBody().get(i).findElement(By.tagName("select")).click();
            }
        }
    }

    public List<WebElement> getValuesOfDropdown() {
        return new Select(getDropdown().get(0)).getOptions();
    }

}