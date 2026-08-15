package tarc.assignment.util;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class RubyTime {
    private static final ZoneId ZONE_ID = ZoneId.of(Environment.get("app.timezone"));

    public static Instant timeNow() {
        return Instant.now();
    }

    public static Instant timeAddDays(int day) {
        return Instant.now()
                .atZone(ZONE_ID)
                .plusDays(day)
                .with(LocalTime.MIDNIGHT)
                .toInstant();
    }

    public static Instant timeAddDays(Instant startTime, int day) {
        if (startTime == null) {
            startTime = Instant.now();
        }
        return startTime
                .atZone(ZONE_ID)
                .plusDays(day)
                .with(LocalTime.MIDNIGHT)
                .toInstant();
    }

    public static String convertFormat(Instant instant,String format){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern(format).withZone(ZONE_ID);
        return formatter.format(instant);
    }
}