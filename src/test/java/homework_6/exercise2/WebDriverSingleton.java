package homework_6.exercise2;

import org.openqa.selenium.WebDriver;

public enum  WebDriverSingleton {

    INSTANCE;

    private WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
