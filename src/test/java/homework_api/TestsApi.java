package homework_api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestsApi {
    @Test
    public void simpleCall(){
        given()
                .baseUri("https://trello.com/")
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200);
    }
}
