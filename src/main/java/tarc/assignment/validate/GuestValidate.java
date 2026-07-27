package tarc.assignment.validate;

import java.util.regex.Pattern;

public class GuestValidate {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\u4e00-\\u9fa5\\s]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9]{7,15}$");

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
            throw new IllegalArgumentException("Invalid phone number format.");
        }
    }
}
