package homework_api;

import homework_api.api.BoardApi;
import homework_api.beans.Board;
import org.testng.annotations.Test;

import java.util.List;

public class TestsApi {
    Step step = new Step();
    BoardApi api = new BoardApi();
    List<Board> boards = api.getBoardsResponse(api.getAllBoards());

    @Test
    public void simpleCall() {

        //    BoardApi api = new BoardApi();
    /*    api.callApi().prettyPeek();
        api.callApicreateDesk();

        List<Board> boards = api.getBoardsResponse(api.callApi());
        System.out.println(boards.size());
//        for (int i = 0; i < 4; i++) {
//            System.out.println(boards.get(i).name);
//        }*/
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

    }
}
