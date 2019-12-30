package homework_api.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import homework_api.beans.Board;
import homework_api.utils.PropertiesProvider;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.nio.charset.Charset;
import java.util.HashMap;

import static io.restassured.http.ContentType.URLENC;
import static org.hamcrest.Matchers.lessThan;

public class BoardApi {
    private BoardApi() {
    }

    public PropertiesProvider properties = new PropertiesProvider();

    private String path = "";
    private Method method = Method.GET;
    private ContentType contentType = URLENC;
    private Charset charset = Charset.defaultCharset();
    private HashMap<String, String> params = new HashMap<String, String>();

    public static class ApiBuilder {
        BoardApi boardApi;

        private ApiBuilder(BoardApi gcApi) {
            boardApi = gcApi;
        }

        public ApiBuilder path(String path) {
            boardApi.path = path;
            return this;
        }

        public ApiBuilder method(Method method) {
            boardApi.method = method;
            return this;
        }

        public ApiBuilder id(String id) {
            boardApi.params.put("id", id);
            return this;
        }

        public ApiBuilder name(String name) {
            boardApi.params.put("name", name);
            return this;
        }

        public ApiBuilder desc(String desc) {
            boardApi.params.put("desc", desc);
            return this;
        }

        public Response callApi() {
            return RestAssured.with()
                    .spec(baseRequestConfiguration(boardApi.properties))
                    .contentType(boardApi.contentType.withCharset(boardApi.charset.name()))
                    .params(boardApi.params)
                    .log().all()
                    .request(boardApi.method,
                            String.format("%s%s", boardApi.properties.getPropertyByName("path"), boardApi.path))
                    .prettyPeek();
        }
    }

    public static ApiBuilder with() {
        BoardApi api = new BoardApi();
        return new ApiBuilder(api);
    }

    public static Board getBoardAnswer(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<Board>() {
        }.getType());
    }

    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectResponseTime(lessThan(20000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static ResponseSpecification notFoundResponse() {
        return new ResponseSpecBuilder()
                .expectResponseTime(lessThan(20000L))
                .expectStatusCode(HttpStatus.SC_NOT_FOUND)
                .build();
    }

    public static ResponseSpecification badRequest() {
        return new ResponseSpecBuilder()
                .expectResponseTime(lessThan(20000L))
                .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
                .build();
    }
    public static RequestSpecification baseRequestConfiguration(PropertiesProvider properties) {
        return new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setBaseUri(properties.getPropertyByName("path"))
                .addParam("key", properties.getPropertyByName("key"))
                .addParam("token", properties.getPropertyByName("token"))
                .build();
    }
}
