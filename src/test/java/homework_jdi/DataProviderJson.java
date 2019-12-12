package homework_jdi;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class DataProviderJson {

    @DataProvider(name = "DataProviderJson")
    public Object[][] divideDataProviderNoCheckDivZero() throws FileNotFoundException {
        Reader reader = new FileReader("src/test/resources/hw_jdi/JDI_ex8_metalsColorsDataSet.json");
        Gson gson = new Gson();
        Data[] datas = gson.fromJson(reader, Data[].class);
        System.out.println();
        return new Object[][]{
                {0}, {0}, {1}};
    }

}


