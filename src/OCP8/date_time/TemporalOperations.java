package OCP8.date_time;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class TemporalOperations {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println("now: " + instant);

        Instant oneHourLater = instant.plus(Duration.of(1, ChronoUnit.HOURS));
        System.out.println(oneHourLater);

        Instant oneHourAndTenMinutes = instant.plus(1, ChronoUnit.HOURS).plus(10, ChronoUnit.MINUTES);
        System.out.println(oneHourAndTenMinutes);
    }
}
