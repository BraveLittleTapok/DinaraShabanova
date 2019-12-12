package homework_jdi.commonelements;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class HeaderMenu extends Section {

    @XPath("//a[contains(text(),'Metals & Colors')]")
    private Button metalsAndColors;

    public Button getMetalsAndColors() {
        return metalsAndColors;
    }
}
