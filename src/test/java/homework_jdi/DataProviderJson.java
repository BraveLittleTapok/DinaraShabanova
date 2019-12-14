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
        ListWithDatas datas = gson.fromJson(reader, ListWithDatas.class);

        return new Object[][]{
          //      {datas.getData_1()},
          //      {datas.getData_2()},
                {datas.getData_3()},
                {datas.getData_4()},
                {datas.getData_5()}};
    }

}


