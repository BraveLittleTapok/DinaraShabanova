package homework_4.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import homework_4.components.Entity;
import homework_4.components.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
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

    @FindBy(xpath = "//div[@id='metals']//span[@class='caret']")
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
        colors.findElement(By.xpath("//span[contains(@class,'text')][contains(text(),'" + item + "')]")).click();
    }

    public void chooseVegetables(String item) {
        vegetables.findElement(By.xpath("//label[@for='" + item + "']")).click();
    }

    public void chooseColors(String item) {
        colors.findElement(By.xpath("//span[contains(text(),'" + item + "')]")).click();
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
            case VEGETABLES_ENTITY:
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

    public Result getActualResult() {
        List<Integer> summary = null;
        String color = null;
        String metals = null;
        List<String> elements = null ;
        List<String> vegetables = null;

        ElementsCollection listResult = $$(By.xpath("//ul[contains(@class,'panel-body-list results')]/li"));
        for (WebElement el : listResult) {
            String[] firstWord = el.getText().split(":");
            if (("Summary").equals(firstWord[0])) {
                summary = new ArrayList<>();
                summary.add(Integer.parseInt(getValueFromActualResult(el.getText()).get(0).trim()));
            } else if (("Color").equals(firstWord[0])) {
                color = getValueFromActualResult(el.getText()).get(0).trim();
            } else if (("Metal").equals(firstWord[0])) {
                metals = getValueFromActualResult(el.getText()).get(0).trim();
            } else if (("Elements").equals(firstWord[0])) {
                elements = new ArrayList<>();
                elements.addAll(getValueFromActualResult(el.getText()));
            } else if (("Vegetables").equals(firstWord[0])) {
                vegetables = new ArrayList<>();
                vegetables.addAll(getValueFromActualResult(el.getText()));
            }
        }
        return Result.resultBuilder()
                .setSummary(summary)
                .setColor(color)
                .setMetals(metals)
                .setVegetables(vegetables)
                .setElements(elements)
                .build();
    }

    private List<String> getValueFromActualResult(String line) {
        List<String> values = new ArrayList<>();
        int i = 0;
        for (String str : line.split(" ")) {
            if (i > 0) {
                String s = str.replaceAll(",", "");
                values.add(s);
            }
            i++;
        }
        Collections.sort(values);
        return values;
    }

    public void reloadPage() {
        Selenide.refresh();
        unselectDefaultItem();
    }
}
