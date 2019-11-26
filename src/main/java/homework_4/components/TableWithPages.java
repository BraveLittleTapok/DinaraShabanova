package homework_4.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Dinara Shabanova on 26.11.2019.
 */
public class TableWithPages {

    public TableWithPages() {
        page(this);
    }

    @FindBy(xpath = "//table[@id='table-with-pages']//tbody/tr")
    private List<WebElement> tableList;

    @FindBy(xpath = "//select[@name='table-with-pages_length']")
    private WebElement selectElement;

    public int getDefaultValOfEntries() {
        return Integer.parseInt($(By.xpath("//select[@name='table-with-pages_length']/" +
                "option")).shouldBe(visible).getText());
    }

    public void clickEntries() {
        $(By.id("table-with-pages_length")).click();
    }

    public void chooseSelectOption(int i) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(String.valueOf(i));
    }

    public boolean entriesIsSelect() {
        Select select = new Select(selectElement);
        return select.getFirstSelectedOption().isSelected();
    }

    public boolean logRowRespondToEntries(String logRow) {
        WebElement log = $(By.xpath("//ul[@class='panel-body-list logs']/li[2]"));
        return (log.getText().contains(logRow) & log.isDisplayed());
    }

    public int getNumberEntriesInTable() {
        return tableList.size();
    }

    public void fillSearch(String search) {
        $(By.xpath("//label[contains(text(),'Search:')]//input[@class='uui-form-element']")).pressEscape();
        $(By.xpath("//label[contains(text(),'Search:')]//input[@class='uui-form-element']")).sendKeys(search);
    }

    public boolean tableContainsOnlySearch(String search) {
        return tableList.stream()
                .anyMatch((entry) -> {
                    if (!entry.getText().toLowerCase().contains(search.toLowerCase())) {
                        return false;
                    }
                    return true;
                });
    }
}
