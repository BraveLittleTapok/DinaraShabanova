package homework_api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesProvider {
    private static final String PATH_TO_PROPERTIES = "src/main/resources/hw_api/api.properties";

    public static String getPropertyByName(String name){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(PATH_TO_PROPERTIES));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(name);
    }
}
