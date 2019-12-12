package homework_jdi.pages.metalsandcolors.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import homework_jdi.pages.metalsandcolors.entities.Summary;

public class SummaryForm extends Form<Summary> {
    @Css("#odds-selector")
    private RadioButtons odd;
    @Css("#even-selector")
    private RadioButtons even;
    @Css("#calculate-button")
    private Button submit;

}
