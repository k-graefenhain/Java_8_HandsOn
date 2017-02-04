package JUGS.ch4_dateandtime.bonus;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class NthWeekdayAdjuster implements TemporalAdjuster
{
    private final DayOfWeek dayToAdjust;
    private final int       count;

    public NthWeekdayAdjuster(final DayOfWeek dayToAdjust, final int count)
    {
        this.dayToAdjust = dayToAdjust;
        this.count = count;
    }

    public Temporal adjustInto(Temporal input)
    {
        final LocalDate startdate = LocalDate.from(input);

        LocalDate adjustedDate = startdate.with(TemporalAdjusters.firstInMonth(dayToAdjust));

        // Achtung: Hier bei 1 starten, weil menschliche Denkweise: 4. Sonntag ist nicht 0-basiert!
        for (int i = 1; i < count; i++)
        {
            adjustedDate = adjustedDate.with(TemporalAdjusters.next(dayToAdjust));
        }

        return input.with(adjustedDate);
    }
}
