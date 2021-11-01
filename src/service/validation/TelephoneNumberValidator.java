package service.validation;

import java.util.regex.Pattern;

public class TelephoneNumberValidator {
    public static boolean isValid(String checkStr) {
        return Pattern.matches("375\\d{9}", checkStr);
    }

}

