package homework_api;

import homework_api.api.BoardApi;
import homework_api.api.Boards;
import homework_api.beans.Board;
import io.restassured.http.Method;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestsApi {

    @Test(priority = 1)
    public void createBoard() {
        Board answer = BoardApi.getBoardAnswer(BoardApi
                .with()
                .method(Method.POST)
                .name("Test Board")
                .callApi().then()
                .specification(BoardApi.successResponse()).extract().response());
        assertThat(answer.name, equalTo("Test Board"));
    }

    @Test(priority = 2)
    public void getBoardByName() {
        Board answer = BoardApi.getBoardAnswer(BoardApi
                .with()
                .method(Method.GET)
                .path(Boards.getBoardIdByName("Test Board"))
                .callApi().then()
                .specification(BoardApi.successResponse()).extract().response());

    }

    @Test(priority = 3)
    public void deleteBoardByName() {
        BoardApi
                .with()
                .method(Method.DELETE)
                .path(Boards.getBoardIdByName("Test Board"))
                .callApi().then()
                .specification(BoardApi.successResponse());
    }


    @Test(priority = 4)
    public void getDeletedBoardByName() {
        BoardApi
                .with()
                .method(Method.GET)
                .path(Boards.getBoardIdByName("Test Board"))
                .callApi().then()
                .specification(BoardApi.notFoundResponse());
    }
/*
    @Test
    public void simpleCall() {

    }

    @Test
    public void getAllBoards() {
        List<Board> boards = api.getBoardsResponse(api.getAllBoards().prettyPeek());
    }

    @Test
    public void getOneBoard() {
        step.boardIsExist("MyBoard");
    }

    @Test
    public void createBoard() {

    }

    @Test
    public void updateNameOfBoard() {

    }

    @Test
    public void getNotExistBoard() {

    }

    @Test
    public void deleteBoard() {
        step.deleteBoard("BoardNEW");
    }

    @Test
    public void getDeletedBoard() {

    }

    @Test
    public void badRequest() {

    }*/
}
