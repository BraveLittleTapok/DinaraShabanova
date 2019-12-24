package homework_api;

import homework_api.api.BoardApi;
import homework_api.beans.Board;

import java.util.List;

public class Step {

    BoardApi api = new BoardApi();
    List<Board> boards = api.getBoardsResponse(api.getAllBoards());

    public void boardIsExist(String myBoard) {
        api.getBoard()
    }

    public void deleteBoard(String boardNEW) {
        api.deleteBoard(boardNEW)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
