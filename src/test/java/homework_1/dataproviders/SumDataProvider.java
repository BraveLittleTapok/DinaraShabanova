package homework_1.dataproviders;

import org.testng.annotations.DataProvider;

import static homework_1.tests.Constants.LONG_MAX;
import static homework_1.tests.Constants.LONG_MIN;

/**
 * Created by dinar on 14.11.2019.
 */
public class SumDataProvider {
    @DataProvider(name = "SumDataProviderUnderMax")
    public Object[][] sumDataProviderUnderMaxValue() {
        return new Object[][]{
                {0, 1, 1},
                {250, 122, 372},
                {-5, -98, -103},
                {LONG_MAX - 1, 1, LONG_MAX},
                {LONG_MAX, LONG_MIN, -1}
        };
    }

    @DataProvider(name = "SumDataProviderOverMax")
    public Object[][] sumDataProviderOverMaxValue() {
        return new Object[][]{
                {LONG_MAX, 1, LONG_MIN},
                {LONG_MIN, LONG_MIN, 0},
                {LONG_MAX, LONG_MAX, -2}
        };
    }
}
