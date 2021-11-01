package service.validation;

import java.util.regex.Pattern;

public class EmailValidator {
    public static boolean isValid(String checkStr){
        return  Pattern.matches("[a-zA-Z]\\w+@[a-zA-Z]+.[a-zA-Z]+", checkStr);
    }
}
