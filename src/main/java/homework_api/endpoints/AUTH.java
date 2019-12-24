package homework_api.endpoints;

import static homework_api.utils.PropertiesProvider.getPropertyByName;

public class AUTH {

    private static final String PROPERTY_TOKEN = getPropertyByName("token");
    private static final String PROPERTY_KEY = getPropertyByName("key");

    public static final String AUTH_URL = "key=" + PROPERTY_KEY + "&token=" + PROPERTY_TOKEN;

}
