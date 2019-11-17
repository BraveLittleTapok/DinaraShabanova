package homework_1.tests;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by dinar on 14.11.2019.
 */
public class AbstractBaseTest {

    protected Calculator calculator;

    @BeforeTest
    public void setUp() {
        this.calculator = new Calculator();
    }

    @AfterTest
    private void TearUp() {
        calculator = null;
    }
}
