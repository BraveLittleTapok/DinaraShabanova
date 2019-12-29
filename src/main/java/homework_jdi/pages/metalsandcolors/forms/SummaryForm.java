package homework_jdi.pages.metalsandcolors.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import homework_jdi.pages.metalsandcolors.entities.Summary;
import org.openqa.selenium.By;

public class SummaryForm extends Form<Summary> {
    @Css("#odds-selector")
    private RadioButtons summaryElementOdd;

    @Css("#even-selector")
    private RadioButtons summaryElementEven;

    @Css("#calculate-button")
    private Button summaryButton;

    @Override
    public void fill(Summary SummaryEntity) {
        summaryElementOdd.list().find(By.xpath("//label[contains(text(),'" +
                SummaryEntity.getSummaryElementOdd().toString() + "')]")).click();
        summaryElementEven.list().find(By.xpath("//label[contains(text(),'" +
                SummaryEntity.getSummaryElementEven().toString() + "')]")).click();
        summaryButton.click();
    }
}
