package homework_4.exercise2;

import com.codeborne.selenide.Configuration;
import homework_4.StepsBase;
import homework_4.components.Result;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
/**
 * Created by Dinara Shabanova on 28.11.2019.
 */
public class Exercise2 {

    private static final String PATH_TO_PROPERTIES = "src/main/resources/hw3/UserData.properties";
    private static final String URL_HOME_PAGE = "https://epam.github.io/JDI/index.html";
    public final static String METAL_AND_COLORS = "Metals & Colors";

    @Test(dataProvider = "DataProviderForResult", dataProviderClass = DataProviderResult.class)
    public void exercise2(Result actual) throws IOException {
        // 1. open site
        Configuration.startMaximized = true;
        open(URL_HOME_PAGE);
        StepsBase stepsBase = new StepsBase();

        //2.Assert Browser title ; 5.Assert Browser title
        stepsBase.titleShouldBe("Home Page");

        // 3.Perform login
        Properties userData = new Properties();
        userData.load(new FileInputStream(PATH_TO_PROPERTIES));
        stepsBase.login(userData.getProperty("login"), userData.getProperty("password"));

        // 4. Click on the link on the Header section	Metal & Colors	Page is opened
        stepsBase.clickHeaderMenu(METAL_AND_COLORS);
        stepsBase.titleShouldBe("Metal and Colors");

        //5. choose [{3, 8}; {Cucumber, Tomato}] and check results

        StepsEx2 steps = new StepsEx2();
        //1

        steps.refreshPage();
        steps.createClickFromInData(actual);
        steps.equalsResults(actual);
        steps.softAssertAll();
    }
}
