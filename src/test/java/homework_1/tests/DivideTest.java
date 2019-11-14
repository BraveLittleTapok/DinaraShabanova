package homework_1.tests;

import homework_1.dataproviders.DivideDataProvider;

import static homework_1.tests.Constants.*;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by dinar on 14.11.2019.
 */
public class DivideTest extends AbstractBaseTest {
    @Test(dataProvider = "DivideDataProviderNoCheckingDivideByZero", dataProviderClass = DivideDataProvider.class)
    public void divideTestWithoutDivByZero(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void divideTesDivByZero() {
        calculator.div(LONG_MAX, 0);
    }
}
