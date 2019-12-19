package homework_api.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpHeaders;

import java.util.HashMap;
import java.util.Random;

import static homework_api.utils.PropertiesProvider.getPropertyByName;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.ContentType.TEXT;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.lessThan;

public class BoardApi {
    private static final String ROOT_URL = getPropertyByName("path");
    private static final String PROPERTY_TOKEN = getPropertyByName("token");
    private static final String PROPERTY_KEY = getPropertyByName("key");
    private static final String BOARD_PASS = getPropertyByName(ROOT_URL +"/boards/");

//    static RequestSpecification spellerSOAPreqSpec = new RequestSpecBuilder()
//            .addHeader("Accept-Encoding", "gzip,deflate")
//            .setContentType("text/xml;charset=UTF-8")
//            .setBaseUri("https://trello.com/")
//            .build();

    private BoardApi(){}
    private HashMap<String,String> params = new HashMap<>();
    private Method method = Method.GET;

    public static class RequestBuilder{
        BoardApi boardApi;

        private RequestBuilder(BoardApi boardApi){
            this.boardApi = boardApi;
        }

        public RequestBuilder name(String name){
            boardApi.params.put("name", name);
            return this;
        }
        public RequestBuilder id(String id){
            boardApi.params.put("id", id);
            return this;
        }

        public RequestBuilder method(Method method){
            boardApi.method = method;
            return this;
        }

        public Response callApi(){
            return RestAssured.with()
                    .queryParams(boardApi.params)
                    .spec(requestSpecification())
                    .log().all()
                    .basePath(BOARD_PASS)
                    .request(boardApi.method)
                    .prettyPeek();
        }

        public static RequestBuilder with(){
            BoardApi api = new BoardApi();
            return new RequestBuilder(api);
        }

        public static RequestSpecification requestSpecification(){
            return new RequestSpecBuilder()
                    .setContentType(JSON)
                    .setAccept(JSON)
                    .addQueryParam("key", PROPERTY_KEY)
                    .addQueryParam("token", PROPERTY_TOKEN)
                    .addQueryParam("reqId", new Random().nextLong())
                    .build();
        }

        public static ResponseSpecification successResponse(){
            return new ResponseSpecBuilder()
                    .expectContentType(JSON)
                    .expectHeader(HttpHeaders.CONNECTION, "keep-alive")
                    .expectResponseTime(lessThan(2000L))
                    .expectStatusCode(SC_OK)
                    .build();
        }

        public static ResponseSpecification boardNotFound(){
            return new ResponseSpecBuilder()
                    .expectContentType(TEXT)
                    .expectHeader(HttpHeaders.CONNECTION, "keep-alive")
                    .expectResponseTime(lessThan(2000L))
                    .expectStatusCode(SC_NOT_FOUND)
                    .build();
        }

        public static ResponseSpecification badRequest(){
            return new ResponseSpecBuilder()
                    .expectContentType(TEXT)
                    .expectHeader(HttpHeaders.CONNECTION, "keep-alive")
                    .expectResponseTime(lessThan(2000L))
                    .expectStatusCode(SC_BAD_REQUEST)
                    .build();
        }

    }
}
