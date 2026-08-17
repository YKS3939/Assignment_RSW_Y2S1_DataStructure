package tarc.assignment.validate;

import java.util.regex.Pattern;

public class GuestValidate {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\u4e00-\\u9fa5\\s]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9]{7,15}$");
//    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (!NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException("Name can only contain letters and spaces.");
        }
    }

    public static void validatePhone(String phoneNum) {
        if (phoneNum == null || !PHONE_PATTERN.matcher(phoneNum).matches()) {
            throw new IllegalArgumentException("PhoneNumber only accept more than 8 number digit");
        }
    }

//    public static void validateEmail(String email) {
//        if (email == null || email.trim().isEmpty()) {
//            throw new IllegalArgumentException("Email cannot be empty.");
//        }
//        if (!EMAIL_PATTERN.matcher(email.trim()).matches()) {
//            throw new IllegalArgumentException("Invalid email format.");
//        }
//    }
}