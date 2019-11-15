package homework_1.dataproviders;

import org.testng.annotations.DataProvider;

import static homework_1.tests.Constants.LONG_MAX;
import static homework_1.tests.Constants.LONG_MIN;

/**
 * Created by dinar on 14.11.2019.
 */
public class DivideDataProvider {
    @DataProvider(name = "DivideDataProviderNoCheckingDivideByZero")
    public Object[][] divideDataProviderNoCheckDivZero() {
        return new Object[][]{
                {1, 1, 1},
                {0, LONG_MIN, 0},
                {628, 25, 25},
                {0, LONG_MAX, 0}
        };
    }

    @DataProvider(name = "DataProviderDivideByZero")
    public Object[][] divideDataProviderDivByZero() {
        return new Object[][]{
                {0, 0},
                {LONG_MIN, 0},
                {LONG_MAX, 0},
        };
    }
}
