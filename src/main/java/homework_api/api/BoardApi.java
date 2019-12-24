package homework_api.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import homework_api.beans.Board;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import java.util.List;

import static homework_api.endpoints.URLS.*;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.ContentType.TEXT;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.lessThan;

public class BoardApi {


    public Response getAllBoards() {
        return request()
                .get(allBoardURL())
                .then()
                .spec(successResponse())
                .extract().response();
    }

    public List<Board> getBoardsResponse(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<List<Board>>() {
        }.getType());
    }

    private RequestSpecification request() {
        return given().contentType(JSON);
    }

    public Response deleteBoard(String nameOfBoard) {
        HttpUriRequest request = RequestBuilder
               .
        return request()
                .delete(deleteBoardURL(nameOfBoard))
                .then()
                .spec(successResponse())
                .extract().response();
    }


    public Response createBoard(String nameOfBoard) {
        return request()
                .post(createBoardURL(nameOfBoard))
                .then()
                .spec(successResponse())
                .extract().response();
    }

    private ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectContentType(JSON)
                .expectHeader(HttpHeaders.CONNECTION, "keep-alive")
                .expectResponseTime(lessThan(2000L))
                .expectStatusCode(SC_OK)
                .build();
    }


    public static ResponseSpecification boardNotFound() {
        return new ResponseSpecBuilder()
                .expectContentType(TEXT)
                .expectHeader(HttpHeaders.CONNECTION, "keep-alive")
                .expectResponseTime(lessThan(2000L))
                .expectStatusCode(SC_NOT_FOUND)
                .build();
    }

    public static ResponseSpecification badRequest() {
        return new ResponseSpecBuilder()
                .expectContentType(TEXT)
                .expectHeader(HttpHeaders.CONNECTION, "keep-alive")
                .expectResponseTime(lessThan(2000L))
                .expectStatusCode(SC_BAD_REQUEST)
                .build();
    }
}
