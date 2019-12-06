package homework_1.tests;

import homework_1.dataproviders.SumDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by dinar on 14.11.2019.
 */
public class SumTest extends AbstractBaseTest {

    @Test(dataProvider = "SumDataProviderUnderMax",
            dataProviderClass = SumDataProvider.class)
    public void sumTestNumberUnderMaxValue(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }


    @Test(dataProvider = "SumDataProviderOverMax",
            dataProviderClass = SumDataProvider.class)
    public void sumTestNumberOverMaxValue(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }
}
