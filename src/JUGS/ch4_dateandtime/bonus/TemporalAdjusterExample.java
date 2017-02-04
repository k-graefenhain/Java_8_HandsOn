package JUGS.ch4_dateandtime.bonus;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class TemporalAdjusterExample
{
    public static void main(String[] args)
    {
        final LocalDate aug18 = LocalDate.of(2015,Month.AUGUST, 18);
        System.out.println("Starting at  " + aug18);
        
        final LocalDate nextFriday = aug18.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("Next friday: " + nextFriday);
        
        System.out.println("2nd friday:  " + aug18.with(new NthWeekdayAdjuster(DayOfWeek.FRIDAY, 2)));
        System.out.println("3rd sunday:  " + aug18.with(new NthWeekdayAdjuster(DayOfWeek.SUNDAY, 3)));
        System.out.println("4th tuesday: " + aug18.with(new NthWeekdayAdjuster(DayOfWeek.TUESDAY, 4)));
    }
}
