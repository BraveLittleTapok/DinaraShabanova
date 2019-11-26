package homework_4.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by Dinara Shabanova on 26.11.2019.
 */
public class CommonComponents {

    public CommonComponents() {

        page(this);
    }
    @FindBy(xpath ="//select[@name='table-with-pages_length']")
    private Select entries;

    public boolean hasRightSection() {
       return $(By.id("mCSB_1_container")).isDisplayed();
    }

    public boolean hasLeftSection() {
        return $(By.id("mCSB_2")).isDisplayed();
    }

    public void clickEntries() {
        $(By.id("table-with-pages_length")).click();
    }

    public void chooseSelectOption(int i){
        entries.selectByValue();
    }

    public boolean entriesIsSelect(){
        return entries.getFirstSelectedOption().isSelected();
    }
}
