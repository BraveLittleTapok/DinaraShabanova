package homework_api;

import homework_api.api.BoardApi;
import homework_api.beans.Board;
import io.restassured.http.Method;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestsApi {

    final private String testName = "Board";
    final private String newName = "Changed name";
    final private String description = "Add some description to the board";

    Board board;

    @BeforeTest
    public void createBoard() {
        board = BoardApi.getBoardAnswer(BoardApi
                .with()
                .method(Method.POST)
                .name(testName)
                .callApi().then()
                .specification(BoardApi.successResponse()).extract().response());
    }

    @Test
    public void boardIsExistTest() {
        assertThat(board, is(notNullValue()));
    }

    @Test
    public void getBoardTest() {
        Board newBoard = BoardApi.getBoardAnswer(BoardApi
                .with()
                .method(Method.GET)
                .path(board.id)
                .callApi().then()
                .specification(BoardApi.successResponse()).extract().response());
        assertThat(newBoard, is(notNullValue()));
    }

    @Test
    public void changeBoardNameTest() {
        board = BoardApi.getBoardAnswer(BoardApi
                .with()
                .method(Method.PUT)
                .id(board.id)
                .path(board.id)
                .name(newName)
                .callApi().then()
                .specification(BoardApi.successResponse()).extract().response());

        assertThat(board.name, equalTo(newName));
    }

    @Test
    public void addDescriptionToExistingBoardTest() {
        assertThat(board.desc, isEmptyString());

        board = BoardApi.getBoardAnswer(BoardApi
                .with()
                .method(Method.PUT)
                .id(board.id)
                .path(board.id)
                .desc(description)
                .callApi().then()
                .specification(BoardApi.successResponse()).extract().response());

        assertThat(board.desc, is(not(isEmptyString())));
    }

    @Test
    public void tryToGetDeletedBoardTest() {
        deleteBoard();
        BoardApi
                .with()
                .method(Method.GET)
                .path(board.id)
                .callApi().then()
                .specification(BoardApi.notFoundResponse());
        createBoard();
    }

    @AfterTest
    public void deleteBoard() {
        BoardApi
                .with()
                .method(Method.DELETE)
                .path(board.id)
                .callApi().then()
                .specification(BoardApi.successResponse());
    }
}