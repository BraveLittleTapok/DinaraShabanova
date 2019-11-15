package homework_1.dataproviders;

import org.testng.annotations.DataProvider;

import static homework_1.tests.Constants.LONG_MAX;
import static homework_1.tests.Constants.LONG_MIN;

/**
 * Created by dinar on 14.11.2019.
 */
public class SubtractDataProvider {
    @DataProvider(name = "SubtractDataProviderUnderMax")
    public Object[][] subtractDataProviderUnderMaxValue() {
        return new Object[][]{
                {1, 1, 0},
                {-250, -122, -128},
                {555, -333, 888},
                {LONG_MIN + 1, 1, LONG_MIN},
                {LONG_MAX, LONG_MIN, -1}
        };
    }

    @DataProvider(name = "SubtractDataProviderOverMax")
    public Object[][] subtractDataProviderOverMaxValue() {
        return new Object[][]{
                {LONG_MIN, 1, LONG_MAX},
                {LONG_MIN, LONG_MIN, 0},
                {LONG_MAX, LONG_MAX, 0}
        };
    }
}

