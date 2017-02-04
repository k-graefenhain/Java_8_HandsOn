package JUGS.ch4_dateandtime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class Exercise3_TemporalAdjuster
{
    public static void main(String[] args)
    {
        final LocalDate midOfMarch = LocalDate.of(2014, 3, 15);                             
        final TemporalAdjuster toFirstSunday = TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY);          
        
        System.out.println(midOfMarch);
        System.out.println(midOfMarch.with(toFirstSunday));
        
        System.out.println(toFirstSunday.adjustInto(midOfMarch));
    }
}

