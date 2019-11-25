package homework_4.exercise1;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by dinar on 24.11.2019.
 */
public class Exercise1 {
    private static final String PATH_TO_PROPERTIES = "src/main/resources/hw3/UserData.properties";
    private static final String URL_HOME_PAGE = "https://epam.github.io/JDI/index.html";
    @Test
    public void exercise1() throws IOException {
        // 1. open site
        open(URL_HOME_PAGE);
        StepsEx1 steps = new StepsEx1();

        //2.Assert Browser title ; 5.Assert Browser title
        steps.titleShouldBe("Home Page");

        // 3.Perform login
        Properties userData = new Properties();
        userData.load(new FileInputStream(PATH_TO_PROPERTIES));
        steps.login(userData.getProperty("login"), userData.getProperty("password"));

        // 4.Logined user's name is display correctly
        steps.userNameShouldBe("PITER CHAILOVSKII");
    }
}
