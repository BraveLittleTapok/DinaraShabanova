package homework_jdi.pages.metalsandcolors;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;


public class SummaryElement extends Section {

    @UI(".radio")
    public RadioButtons radioButtons;

}
