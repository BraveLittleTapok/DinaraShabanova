package homework_4.pages;

import homework_4.components.Entity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by Dinara Shabanova on 28.11.2019.
 */
public class MetalAndColorsPage {

    public MetalAndColorsPage() {
        page(this);
        unselectDefaultItem();
    }

    @FindBy(id = "summary-block")
    private WebElement summary;

    @FindBy(id = "elements-block")
    private WebElement elements;

    @FindBy(id = "colors")
    private WebElement colors;

    @FindBy(id = "metals")
    private WebElement metals;

    @FindBy(id = "salad-dropdown")
    private WebElement vegetables;

    @FindBy(xpath = "//div[@id='mCSB_1_container']//div[contains(text(),'Result')]")
    private WebElement result;

    public void chooseSummary(String item) {
        colors.findElement(By.xpath("//label[@for='" + item + "']")).click();
    }

    public void chooseElements(String item) {
        colors.findElement(By.xpath("//label[@for='" + item + "']")).click();
    }

    public void chooseMetals(String item) {
        Select select = new Select(metals);
        select.selectByVisibleText(item);
    }

    public void chooseVegetables(String item) {
        vegetables.findElement(By.xpath("//label[@for='" + item + "']")).click();

    }

    public void chooseColors(String item) {

    }

    public void click(Entity entity) {
        switch (entity) {
            case COLORS:
                colors.findElement(By.tagName("button")).click();
                break;
            case METALS:
                metals.click();
                break;
            case SUBMIT:
                $(By.id("submit-button")).click();
                break;
            case VEGETABLES:
                vegetables.findElement(By.tagName("button")).click();
                break;
        }
    }

    private void unselectDefaultItem() {
        $(By.id("salad-dropdown")).click();
        if ($(By.xpath("//div[@id='salad-dropdown']//button[@type='button']"))
                .getText().contains("Vegetable")) {
            $(By.xpath("//div[@id='salad-dropdown']//label[@for='g7']")).click();
        }
    }
}
