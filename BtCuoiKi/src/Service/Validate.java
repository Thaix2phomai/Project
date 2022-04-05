package Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static String EMAIL_REGEX = "^(.+)@(\\S+)$";
    public static String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#_+=,./~$!%*?&])[A-Za-z0-9@#_+=,./~$!%*?&]{7,15}$";
    public static String USERNAME_REGEX = "^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$";
    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean validateUsername(String username) {
        Pattern pattern = Pattern.compile(USERNAME_REGEX);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
