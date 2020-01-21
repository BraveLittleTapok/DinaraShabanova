package homework_api;

import homework_api.api.BoardApi;
import homework_api.beans.Board;
import homework_api.utils.RandomString;
import io.restassured.http.Method;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

import static homework_api.utils.RandomString.SOURCES;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestsApi {

    private final String testName = "Board";
    private final String newName = RandomString.generateString(new Random(), SOURCES, 10);
    private final String description = "Add some description to the board";
    private Board board;

    @BeforeTest
    public void createBoard() {
        board = BoardApi.getBoardAnswer(BoardApi
                .with()
                .method(Method.POST)
                .name(testName)
                .callApi().then()
                .specification(BoardApi.successResponse()));
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
                .specification(BoardApi.successResponse()));
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
                .specification(BoardApi.successResponse()));

        assertThat(board.name, equalTo(newName));

    }

    @Test
    public void boardNameIsNullTest() {
        BoardApi
                .with()
                .method(Method.PUT)
                .id(board.id)
                .path(board.id)
                .name(null)
                .callApi().then()
                .specification(BoardApi.badRequest());
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
                .specification(BoardApi.successResponse()));

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

    @Test
    public void boardNameTooLongFailTest() {
        String failName = RandomString.generateString(new Random(), SOURCES, 10000);
        BoardApi
                .with()
                .method(Method.PUT)
                .id(board.id)
                .path(board.id)
                .name(failName)
                .callApi().then()
                .specification(BoardApi.badRequest());
    }

    @Test
    public void twoBoardsWithSameNameHaveDifferentID() {
        Board newBoard = BoardApi.getBoardAnswer(BoardApi
                .with()
                .method(Method.POST)
                .name(testName)
                .callApi().then()
                .specification(BoardApi.successResponse()));
        assertThat(board.name, equalTo(newBoard.name));
        assertThat(board.id, is(not(equalTo(newBoard.id))));
        BoardApi
                .with()
                .method(Method.DELETE)
                .path(newBoard.id)
                .callApi().then()
                .specification(BoardApi.successResponse());
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