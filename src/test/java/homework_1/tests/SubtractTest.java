package homework_1.tests;

import homework_1.dataproviders.SubtractDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by dinar on 14.11.2019.
 */
public class SubtractTest extends AbstractBaseTest {

    @Test(dataProvider = "SubtractDataProviderUnderMax",
            dataProviderClass = SubtractDataProvider.class)
    public void subtractTestNumberUnderMaxValue(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }


    @Test(dataProvider = "SubtractDataProviderOverMax",
            dataProviderClass = SubtractDataProvider.class)
    public void subtractTestNumberOverMaxValue(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }
}
