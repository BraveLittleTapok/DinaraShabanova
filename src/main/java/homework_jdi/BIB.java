package homework_jdi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class BIB {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/test/resources/hw_jdi/JDI_ex8_metalsColorsDataSet.json"));
        JSONArray jsonArray = (JSONArray) jsonObject.get("data_1");
        //Iterating the contents of the array
        Iterator<String> iterator = jsonArray.iterator();
        while(iterator.hasNext()) {
            System.out.println("First name: "+jsonObject.get("summary"));
            System.out.println("Last name: "+jsonObject.get("elements"));
            System.out.println("Date of birth: "+ jsonObject.get("color"));
            System.out.println("Place of birth: "+ jsonObject.get("metals"));
        }
        System.out.println();
    }
}
