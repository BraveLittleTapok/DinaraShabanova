package homework_jdi.pages.metalsandcolors;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import homework_jdi.DataFromJsonForMetalsColorPage;
import homework_jdi.pages.metalsandcolors.entities.Summary;
import homework_jdi.pages.metalsandcolors.forms.SummaryForm;
import org.openqa.selenium.By;

import java.util.List;

public class MetalsAndColorsPage extends WebPage {

    @Css(".main-content")
    private MainSectionForChoosingElements mainSection;

    private SummaryForm summary;

    @FindBy(xpath = "//div[@name='log-sidebar']")
    private LogSection log;

    public void setSummary(Summary summaryFields) {
        summary.fill(summaryFields);
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
        mainSection.getSubmitButton().click();
    }

    public LogSection getLog() {
        return log;
    }

    public void fill(DataFromJsonForMetalsColorPage data) {
        setSummary(data.getSummary());
        setVegetables(data.getVegetables());
        setColors(data.getColor());
        setElements(data.getElements());
        setMetals(data.getMetals());
        clickSubmit();
    }
}
