package homework_5;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Created by Dinara Shabanova on 04.12.2019.
 */
public class AttachmentListener extends TestListenerAdapter {

    @Attachment(value = "Attachment: {0}", type = "image/png")
    public byte[] makeScreenshot() {
        byte[] array = {1};
        try {
            return ((TakesScreenshot) WebDriverSingleton.INSTANCE.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        makeScreenshot();
    }
}
