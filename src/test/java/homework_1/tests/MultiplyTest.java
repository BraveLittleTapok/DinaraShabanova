package homework_1.tests;

import homework_1.dataproviders.DivideDataProvider;
import homework_1.dataproviders.MultiplyDataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by dinar on 14.11.2019.
 */
public class MultiplyTest extends AbstractBaseTest {

    @Test(dataProvider = "MultiplyDataProvider", dataProviderClass = MultiplyDataProviders.class)
    public void multiplyTest(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }
}
