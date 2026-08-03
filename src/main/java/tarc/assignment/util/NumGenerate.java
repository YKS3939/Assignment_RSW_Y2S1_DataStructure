package tarc.assignment.util;

import com.github.f4b6a3.tsid.TsidCreator;
import com.github.f4b6a3.ulid.UlidCreator;

import java.util.concurrent.ThreadLocalRandom;

public class NumGenerate {

    /**
     * This method are use AI code generation - Yap Kim Soon
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

    /**
     * Generade ULID unique id -Ma Chun Yen
     * @return String
     */
    public static String generadeULID(){
        return UlidCreator.getUlid().toString();
    }

    /**
     * Generade TSID id for customer id- Goh Wen Ting
     * @return String
     */
    public static String generateTSID() {
        return TsidCreator.getTsid().toString();
    }
}
