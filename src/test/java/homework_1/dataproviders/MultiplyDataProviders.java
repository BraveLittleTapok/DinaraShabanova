package homework_1.dataproviders;

import org.testng.annotations.DataProvider;

import static homework_1.tests.Constants.*;

/**
 * Created by dinar on 14.11.2019.
 */
public class MultiplyDataProviders {
    @DataProvider(name = "MultiplyDataProvider")
    public Object[][] multiplyDataProvider() {
        return new Object[][]{
                {1, 1, 1},
                {0, LONG_MIN, 0},
                {LONG_MAX, 0, LONG_MIN},
                {25, 25, 625}
        };
    }
}
