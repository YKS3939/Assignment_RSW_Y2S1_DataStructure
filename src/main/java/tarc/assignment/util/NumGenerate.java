package tarc.assignment.util;

import java.util.concurrent.ThreadLocalRandom;

public class NumGenerate {

    /**
     * This part are use AI code generation - Yap Kim Soon
     */
    public static String generateDigit(int digits) {
        if (digits <= 0 || digits > 10) {
            throw new IllegalArgumentException("Digits must be between 1 and 10");
        }

        int min = (int) Math.pow(10, digits - 1);
        int max = (int) Math.pow(10, digits);

        int randomNum = ThreadLocalRandom.current().nextInt(min, max);
        return String.valueOf(randomNum);
    }
}
