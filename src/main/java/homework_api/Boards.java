package homework_api;

import homework_api.api.BoardApi;
import homework_api.beans.Board;

import java.util.List;

public class Boards {
    private static BoardApi api = new BoardApi();
    private static List<Board> boards = api.getBoardsResponse(api.getAllBoards());

    public static String getBoardIdByName(String nameOfBoard){
        return boards.stream()
                .filter(p->p.name.equals(nameOfBoard))
                .findFirst()
                .get()
                .id;
    }
}
