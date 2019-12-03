package homework_4.exercise2;


import homework_4.components.Result;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

/**
 * Created by dinar on 01.12.2019.
 */
public class DataProviderResult {

    @DataProvider(name = "DataProviderForResult")
    public Object[][] divideDataProviderNoCheckDivZero() {
        return new Object[][]{
                {Result.resultBuilder()
                        .setSummary(Arrays.asList(3, 8))
                        .setVegetables(Arrays.asList("Cucumber", "Tomato"))
                        .build()},
                {Result.resultBuilder()
                        .setElements(Arrays.asList("Earth"))
                        .setColor("Yellow")
                        .setMetals("Gold")
                        .build()},

                {Result.resultBuilder()
                        .setSummary(Arrays.asList(3, 2))
                        .setElements(Arrays.asList("Wind", "Fire", "Water"))
                        .setMetals("Bronze")
                        .setVegetables(Arrays.asList("Onion"))
                        .build()},

                {Result.resultBuilder()
                        .setSummary(Arrays.asList(6, 5))
                        .setElements(Arrays.asList("Water"))
                        .setColor("Green")
                        .setMetals("Selen")
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion"))
                        .build()},

                {Result.resultBuilder()
                        .setElements(Arrays.asList("Fire"))
                        .setColor("Blue")
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables"))
                        .build()}
        };
    }
}
