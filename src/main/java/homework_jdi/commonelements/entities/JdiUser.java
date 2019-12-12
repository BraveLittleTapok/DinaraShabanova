package homework_jdi.commonelements.entities;

public class JdiUser {

    public static final JdiUser ROMAN = new JdiUser("Roman", "Jdi1234", "ROMAN IOVLEV");

    private final String login;
    private final String password;
    private final String fullName;

    public JdiUser(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
