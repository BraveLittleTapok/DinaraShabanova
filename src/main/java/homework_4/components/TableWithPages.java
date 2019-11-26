package homework_4.components;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by Dinara Shabanova on 26.11.2019.
 */
public class TableWithPages {

    public TableWithPages() {
        page(this);
    }


    public int getDefaultValOfEntities() {
        return Integer.parseInt($(By.xpath("//select[@name='table-with-pages_length']/" +
                "option")).shouldBe(visible).getText());
    }
}
