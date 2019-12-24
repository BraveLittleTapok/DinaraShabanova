package homework_jdi.pages.homepage;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import homework_jdi.commonelements.entities.JdiUser;
import homework_jdi.commonelements.forms.LoginForm;

public class HomePage extends WebPage {

    public LoginForm loginForm;

    @Css("#user-name")
    private UIElement userName;
    @Css("#user-icon")
    private Button userIcon;

    public String getUserName() {
        return userName.getText();
    }

    public void login(JdiUser jdiUser) {
        userIcon.click();
        if (userName.isHidden()) {
            loginForm.login(jdiUser);
        }
    }


}
