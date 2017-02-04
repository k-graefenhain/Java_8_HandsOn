package JUGS.ch4_dateandtime;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class Exercise4_FirstDayOfQuarterExample
{
    public static void main(String[] args)
    {
        final LocalDate midOfMarch = LocalDate.of(2014, 3, 15);
        final LocalDate midOfJune = LocalDate.of(2014, 6, 15);
        final LocalDate midOfSep = LocalDate.of(2014, 9, 15);
        final LocalDate midOfNov = LocalDate.of(2014, 11, 15);
        
        final TemporalAdjuster toFirstSunday1 = new Exercise4_FirstDayOfQuarterOrig();
        final TemporalAdjuster toFirstSunday2 = new Exercise4_FirstDayOfQuarter();
        final TemporalAdjuster toFirstSunday3 = new Exercise4_FirstDayOfQuarterShort();
        
        final LocalDate[] dates = {midOfMarch, midOfJune, midOfSep, midOfNov};
        final TemporalAdjuster[] adjusters = {toFirstSunday1, toFirstSunday2, toFirstSunday3}; 
        
        for (final TemporalAdjuster adjuster : adjusters)
        {
            for (final LocalDate date : dates)
            {
                System.out.println(date.with(adjuster));            
            }
        }        
    }
}
