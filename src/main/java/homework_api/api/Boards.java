package homework_api.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import homework_api.beans.Board;
import homework_api.utils.PropertiesProvider;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.List;
import java.util.NoSuchElementException;

public class Boards {

    private static PropertiesProvider properties = new PropertiesProvider();

    private static Response response() {
        return RestAssured.with()
                .spec(BoardApi.baseRequestConfiguration(properties))
                .log().all()
                .request(Method.GET, properties.getPropertyByName("pathToAllBoards"));
    }

    public static List<Board> boards = new Gson().fromJson(response().asString().trim(),
            new TypeToken<List<Board>>() {
            }.getType());

    public static String getBoardIdByName(String name) {
        String id = null;
        try {
            return boards.stream()
                    .filter(p -> p.name.equals(name))
                    .findFirst()
                    .get()
                    .id;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }
}
