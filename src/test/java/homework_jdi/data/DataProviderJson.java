package homework_jdi.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import homework_jdi.DataFromJsonForMetalsColorPage;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

public class DataProviderJson {

    @DataProvider(name = "DataProviderJson")
    public Object[][] divideDataProviderNoCheckDivZero() throws FileNotFoundException {
        Reader reader = new FileReader("src/test/resources/hw_jdi/JDI_ex8_metalsColorsDataSet.json");
        Map<String, DataFromJsonForMetalsColorPage> dataFromJson = new Gson()
                .fromJson(reader, new TypeToken<Map<String, DataFromJsonForMetalsColorPage>>(){}.getType());
        Object[][] returnObject = new Object[dataFromJson.size()][1];
        int index = 0;
        for (String key : dataFromJson.keySet()) {
            returnObject[index++][0] = dataFromJson.get(key);
        }
        return returnObject;
    }
}


