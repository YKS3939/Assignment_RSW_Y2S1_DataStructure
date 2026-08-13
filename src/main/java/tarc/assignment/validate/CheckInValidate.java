package tarc.assignment.validate;

import java.util.regex.Pattern;

public class CheckInValidate {
    private static final Pattern CONFIRMATION_PATTERN = Pattern.compile("^\\d{8}$");
    private static final Pattern ROOM_NUM_PATTERN = Pattern.compile("^[1-9]\\d{2,3}$");

    public static void validateConfirmationNum(String confirmationNum) {
        if (confirmationNum == null || !CONFIRMATION_PATTERN.matcher(confirmationNum).matches()) {
            throw new IllegalArgumentException("Confirmation number must be exactly 8 digits.");
        }
    }

    public static void validateDay(int day) {
        if (day <= 0) {
            throw new IllegalArgumentException(day+" day you nak stay apa");
        }
    }

    public static void validateRoomNum(String roomNum) {
        if (roomNum == null || !ROOM_NUM_PATTERN.matcher(roomNum.trim()).matches()) {
            throw new IllegalArgumentException("Invalid room number format");
        }
    }
}