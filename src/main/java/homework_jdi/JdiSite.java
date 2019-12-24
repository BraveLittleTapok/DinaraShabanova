package homework_jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import homework_jdi.commonelements.HeaderMenu;
import homework_jdi.commonelements.HeaderMenuItems;
import homework_jdi.commonelements.entities.JdiUser;
import homework_jdi.pages.homepage.HomePage;
import homework_jdi.pages.metalsandcolors.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    @Url("index.html")
    public static HomePage jdiHomePage;

    @XPath("//ul[contains(@class,'navbar-nav m-l8')]")
    public static HeaderMenu headerMenu;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalColorsPage;

    public static void open() {
        jdiHomePage.open();
    }

    public static void login(JdiUser jdiUser) {
        jdiHomePage.login(jdiUser);
    }

    public static void clickItemOfHeaderMenu(HeaderMenuItems item) {
        switch (item) {
            case METALS_AND_COLORS: {
                headerMenu.getMetalsAndColors().click();
                break;
            }
        }
    }

}
