package JUGS.ch4_dateandtime;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.IsoFields;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * basierend auf http://www.leveluplunch.com/java/examples/first-day-of-quarter-java8-adjuster/
 */
public class Exercise4_FirstDayOfQuarterOrig implements TemporalAdjuster
{
    @Override
    public Temporal adjustInto(Temporal temporal)
    {
        int currentQuarter = YearMonth.from(temporal).get(IsoFields.QUARTER_OF_YEAR);

        if (currentQuarter == 1)
        {
            return LocalDate.from(temporal).with(TemporalAdjusters.firstDayOfYear());
        }
        else if (currentQuarter == 2)
        {
            return LocalDate.from(temporal).withMonth(Month.APRIL.getValue()).with(firstDayOfMonth());
        }
        else if (currentQuarter == 3)
        {
            return LocalDate.from(temporal).withMonth(Month.JULY.getValue()).with(firstDayOfMonth());
        }
        else
        {
            return LocalDate.from(temporal).withMonth(Month.OCTOBER.getValue()).with(firstDayOfMonth());
        }
    }
}