package homework_5;

import org.openqa.selenium.WebDriver;

/**
 * Created by Dinara Shabanova on 04.12.2019.
 */
public enum WebDriverSingleton {

    INSTANCE;

    private WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

}
