package JUGS.ch4_dateandtime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by kag on 18/08/15.
 */
public class DateCalculations {

    public static void main(String[] args) {
        final LocalDate christmasEve = LocalDate.of(2014, 12, 24);
        System.out.println(DayOfWeek.from(christmasEve));

        System.out.println(DayOfWeek.from(christmasEve.withDayOfMonth(1)));
        System.out.println(DayOfWeek.from(christmasEve.withDayOfMonth(31)));


        // erster und letzter Fr und So im März
        final LocalDate midOfMarch = LocalDate.of(2014, 3, 15);
        final TemporalAdjuster toFirstSunday = TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY);
        final TemporalAdjuster toFirstFriday = TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY);
        System.out.println("first sunday: " + toFirstSunday);
        System.out.println("first friday: " + toFirstFriday);
    }
}
