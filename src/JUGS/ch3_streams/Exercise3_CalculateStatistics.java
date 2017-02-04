package JUGS.ch3_streams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class Exercise3_CalculateStatistics
{
    public static void main(String[] args)
    {
        final IntStream ints1 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final IntStream ints2 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final IntStream ints3 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final IntStream ints4 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final IntStream ints5 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(ints1.min());
        System.out.println(ints2.max());
        System.out.println(ints3.sum());
        System.out.println(ints4.average());
        System.out.println(ints5.count());

        final IntStream ints6 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final IntSummaryStatistics stats = ints6.collect(IntSummaryStatistics::new, IntSummaryStatistics::accept,
                                                         IntSummaryStatistics::combine);
        System.out.println(stats);
    }
}
