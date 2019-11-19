package homework_1.tests;

import homework_1.dataproviders.DivideDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by dinar on 14.11.2019.
 */
public class DivideTest extends AbstractBaseTest {
    @Test(dataProvider = "DivideDataProviderNoCheckingDivideByZero",
            dataProviderClass = DivideDataProvider.class)
    public void divideTestWithoutDivByZero(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "DataProviderDivideByZero",
            dataProviderClass = DivideDataProvider.class,
            expectedExceptions = NumberFormatException.class,
    expectedExceptionsMessageRegExp = "Attempt to divide by zero")
    public void divideTesDivByZero(long a, long b) {
        calculator.div(a, b);
    }
}
