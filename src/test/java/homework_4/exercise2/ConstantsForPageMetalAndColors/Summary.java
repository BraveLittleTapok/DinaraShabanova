package homework_4.exercise2.ConstantsForPageMetalAndColors;


public class Summary {

    public static String getStringValueForHTML(int value) {
        switch (value) {
            case 1:
                return "p1";
            case 2:
                return "p5";
            case 3:
                return "p2";
            case 4:
                return "p6";
            case 5:
                return "p3";
            case 6:
                return "p7";
            case 7:
                return "p4";
            case 8:
                return "p8";
            default:
                return null;
        }
    }
}
