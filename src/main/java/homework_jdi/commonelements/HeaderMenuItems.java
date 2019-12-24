package homework_jdi.commonelements;

public enum  HeaderMenuItems {
    METALS_AND_COLORS ("Metals & Colors");

    private String value;

    HeaderMenuItems(String s) {
        this.value = s;
    }

    public String getValue() {
        return value;
    }
}
