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
    public void exercise2(Result actual, Result expected) throws IOException {
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

        steps.refreshPage();/*
        steps.summaryChoose(THREE);
        steps.summaryChoose(EIGHT);
        steps.clickDropdown(VEGETABLES_ENTITY);
        steps.vegetableChoose(CUCUMBER);
        steps.vegetableChoose(TOMATO);
        steps.clickSubmitButton();

        Result expectedResult = Result.resultBuilder()
                .setSummary(11)
                .setVegetables(Arrays.asList("Cucumber", "Tomato"))
                .build();
        steps.resultContains(expectedResult);*/

        steps.equalsResults(actual, expected);
        //2 Earth;  Yellow;  Gold
        /*
        steps.refreshPage();
        steps.elementsChoose(EARTH);
        steps.clickDropdown(COLORS);
        steps.colorsChoose(YELLOW);
        steps.clickDropdown(METALS);
        steps.metalsChoose(GOLD);
        steps.clickSubmitButton();

        expectedResult = Result.resultBuilder()
                .setElements(Arrays.asList("Earth"))
                .setColor("Yellow")
                .setMetals("Gold")
                .build();
        steps.resultContains(expectedResult);

        //3 (3, 2); Wind, Fire, Watter; Bronze; Onion
        steps.refreshPage();
        steps.summaryChoose(THREE);
        steps.summaryChoose(TWO);
        steps.elementsChoose(WIND);
        steps.elementsChoose(FIRE);
        steps.elementsChoose(WATER);
        steps.clickDropdown(METALS);
        steps.metalsChoose(BRONZE);
        steps.clickDropdown(VEGETABLES_ENTITY);
        steps.vegetableChoose(ONION);
        steps.clickSubmitButton();

        expectedResult = Result.resultBuilder()
                .setSummary(5)
                .setElements(Arrays.asList("Wind", "Fire", "Water"))
                .setMetals("Bronze")
                .setVegetables(Arrays.asList("Onion"))
                .build();

        steps.resultContains(expectedResult);


/*

        //4 (6, 5); Watter; Green; Selen; Vegetables: All checkboxes;
        steps.refreshPage();
        steps.summaryChoose(SIX);
        steps.summaryChoose(FIVE);
        steps.elementsChoose(WATER);
        steps.clickDropdown(COLORS);
        steps.colorsChoose(GREEN);
        steps.clickDropdown(METALS);
        steps.metalsChoose(SELEN);
        steps.clickDropdown(VEGETABLES_ENTITY);
        steps.vegetableChoose(VEGETABLES);
        steps.vegetableChoose(CUCUMBER);
        steps.vegetableChoose(TOMATO);
        steps.vegetableChoose(ONION);
        steps.clickSubmitButton();

        expectedResult = Result.resultBuilder()
                .setSummary(11)
                .setElements(Arrays.asList("Water"))
                .setColor("Green")
                .setMetals("Selen")
                .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables","Onion"))
                .build();
        steps.resultContains(expectedResult);

        //5 Fire; Blue; Cucumber, Tomato, Vegetables
        steps.refreshPage();
        steps.elementsChoose(FIRE);
        steps.clickDropdown(COLORS);
        steps.colorsChoose(BLUE);
        steps.clickDropdown(VEGETABLES_ENTITY);
        steps.vegetableChoose(VEGETABLES);
        steps.vegetableChoose(CUCUMBER);
        steps.vegetableChoose(TOMATO);
        steps.clickSubmitButton();

        expectedResult = Result.resultBuilder()
                .setElements(Arrays.asList("Fire"))
                .setColor("Blue")
                .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables"))
                .build();
        steps.resultContains(expectedResult);
*/
        steps.softAssertAll();
    }
}
