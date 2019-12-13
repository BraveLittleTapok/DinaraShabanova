package homework_jdi.pages.metalsandcolors;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class MainSection extends Section {
    @Css("#calculate-button")
    private Button summaryButton;
    @Css("#salad-dropdown")
    private UIElement vegetables;

    @Css("#elements-block")
    private UIElement elements;

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown colors;

    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown metals;

    @Css("#submit-button")
    private Button submit;

    @FindBy(xpath = "//section[@class='uui-info-panel-horizontal panel-gray']//div[@class='info-panel-section']")
    private SummaryElement summaryElement;

    public SummaryElement getSummaryElement() {
        return summaryElement;
    }

    public UIElement getVegetables() {
        return vegetables;
    }

    public UIElement getElements() {
        return elements;
    }

    public Dropdown getColors() {
        return colors;
    }

    public Dropdown getMetals() {
        return metals;
    }

    public Button getSummaryButton() {
        return summaryButton;
    }

    public Button getSubmit() {
        return submit;
    }

}
