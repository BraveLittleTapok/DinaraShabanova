package homework_jdi.pages.metalsandcolors;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import org.openqa.selenium.By;

import java.util.List;

public class MetalsAndColorsPage extends WebPage {

    @Css(".main-content")
    private MainSection mainSection;

   @FindBy(xpath = "//div[@name='log-sidebar']")
    private LogSection log;

    public void setSummary(List<Integer> summaryList) {
        mainSection.getSummaryElement().radioButtons.list().select(summaryList.get(0));
        mainSection.getSummaryElement().radioButtons.list().select(summaryList.get(1));
        mainSection.getSummaryButton().click();
    }

    public void setVegetables(List<String> vegValues) {
        mainSection.getVegetables().find(By.tagName("button")).click();
        mainSection.getVegetables().find(By.xpath("//label[contains(text(),'Vegetables')]")).click();
        for (String value : vegValues) {
            mainSection.getVegetables().find(By.xpath("//label[contains(text(),'" + value + "')]")).click();
        }
    }
    public void setMetals(String metals) {
        mainSection.getMetals().select(metals);
    }
    public void setElements(List<String> elementValues) {
        for (String value : elementValues) {
            mainSection.getElements().find(By.xpath("//label[contains(text(),'" + value + "')]")).click();
        }
    }
    public void setColors(String colors) {
        mainSection.getColors().select(colors);
    }
    public void clickSubmit() {
        mainSection.getSubmit().click();
    }

    public LogSection getLog() {
        return log;
    }
}
