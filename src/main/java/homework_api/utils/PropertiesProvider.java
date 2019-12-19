package homework_api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.lang.System.getProperty;

public class PropertiesProvider {
    private static final String PATH_TO_PROPERTIES = "src/main/resources/hw_api/api.properties";

    public static String getPropertyByName(String name) {
        Properties apiProperties = new Properties();
        try {
            apiProperties.load(new FileInputStream(PATH_TO_PROPERTIES));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getProperty(name);
    }
}
