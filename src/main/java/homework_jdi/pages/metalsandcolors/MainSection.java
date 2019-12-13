package homework_jdi.pages.metalsandcolors;

import com.epam.jdi.light.elements.complex.Combobox;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;
import homework_jdi.pages.metalsandcolors.forms.SummaryForm;

public class MainSection extends Section {

    private SummaryForm summary;
    @Css("#salad-dropdown")
    private Dropdown vegetables;

    @Css("#elements-block")
    private MultiSelector elements;
    @Css("#colors")
    private Dropdown colors;
    @Css("#metals")
    private Combobox metals;

    @Css("#submit-button")
    private Button submit;

    public SummaryForm getSummaryForm() {
        return summary;
    }

    public Dropdown getVegetables() {
        return vegetables;
    }

    public MultiSelector getElements() {
        return elements;
    }

    public Dropdown getColors() {
        return colors;
    }

    public Combobox getMetals() {
        return metals;
    }

    public Button getSubmit() {
        return submit;
    }

    public void setSummaryForm(SummaryForm summary) {
        this.summary = summary;
    }

    public void setVegetables(Dropdown vegetables) {
        this.vegetables = vegetables;
    }

    public void setElements(MultiSelector elements) {
        this.elements = elements;
    }

    public void setColors(Dropdown colors) {
        this.colors = colors;
    }

    public void setMetals(Combobox metals) {
        this.metals = metals;
    }

    public void setSubmit(Button submit) {
        this.submit = submit;
    }
}
