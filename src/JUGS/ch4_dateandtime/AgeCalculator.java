package JUGS.ch4_dateandtime;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.function.Predicate;

/**
 * Created by kag on 18/08/15.
 */
public class AgeCalculator {

    public static void main(String[] args) {
        final LocalDate now = LocalDate.now();
        final LocalDate birthday = LocalDate.of(1981, 4, 7);
        final LocalDate birthdayFlo = LocalDate.of(1978, 10, 8);

        System.out.println(birthday.until(now));
        System.out.println(Period.between(birthdayFlo, now));
        System.out.println(Period.between(birthdayFlo, birthday));
    }
}
