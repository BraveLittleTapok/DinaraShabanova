package homework_jdi.pages.homepage;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import homework_jdi.commonelements.entities.JdiUser;
import homework_jdi.commonelements.forms.LoginForm;

@SuppressWarnings("")
public class HomePage extends WebPage {

    public LoginForm loginForm;

    @Css("#user-name")
    private Text userName;
    @Css("#user-icon")
    private Button userIcon;

    public String getUserName() {
        return userName.getText();
    }

    public void login(JdiUser jdiUser) {
        userIcon.click();
        loginForm.login(jdiUser);
    }


}
