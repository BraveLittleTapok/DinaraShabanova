package homework_api.endpoints;

import homework_api.Boards;

import static homework_api.endpoints.AUTH.AUTH_URL;
import static homework_api.utils.PropertiesProvider.getPropertyByName;

public class URLS {

    private static final String rootUrl = getPropertyByName("path");
    private static final String allBoardsUrl = rootUrl + "/members/me/boards?" + AUTH_URL;
    private static final String parametersForCreateBoards = "defaultLabels=true&defaultLists=true&keepFromSource=none&prefs_permissionLevel=private&prefs_voting=disabled&prefs_comments=members&prefs_invitations=members&prefs_selfJoin=true&prefs_cardCovers=true&prefs_background=blue&prefs_cardAging=regular";

    public static String allBoardURL() {
        return allBoardsUrl;
    }

    public static String createBoardURL(String nameOfBoard) {
        return rootUrl + "/boards/?name=" + nameOfBoard + parametersForCreateBoards + AUTH.AUTH_URL;
    }

    public static String deleteBoardURL(String nameOfBoard) {
        String id = Boards.getBoardIdByName(nameOfBoard);
        return rootUrl + "/boards/" + id + "?" + AUTH.AUTH_URL;
    }
}
