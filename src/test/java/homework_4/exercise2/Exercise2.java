package homework_4.exercise2;

import homework_4.StepsBase;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static homework_4.Constants.METAL_AND_COLORS;
import static homework_4.components.Entity.VEGETABLES;
import static homework_4.exercise2.ConstantsForPageMetalAndColors.Summary.*;
import static homework_4.exercise2.ConstantsForPageMetalAndColors.Vegetables.CUCUMBER;
import static homework_4.exercise2.ConstantsForPageMetalAndColors.Vegetables.TOMATO;

/**
 * Created by Dinara Shabanova on 28.11.2019.
 */
public class Exercise2 {

    private static final String PATH_TO_PROPERTIES = "src/main/resources/hw3/UserData.properties";
    private static final String URL_HOME_PAGE = "https://epam.github.io/JDI/index.html";

    @Test
    public void exercise2() throws IOException {
        // 1. open site
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
        steps.summaryChoose(THREE);
        steps.summaryChoose(EIGHT);
        steps.clickDropdown(VEGETABLES);
        steps.vegetableChoose(CUCUMBER);
        steps.vegetableChoose(TOMATO);
        steps.softAssertAll();
    }
}
