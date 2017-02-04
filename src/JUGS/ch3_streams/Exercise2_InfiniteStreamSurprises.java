package JUGS.ch3_streams;

import java.util.stream.IntStream;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Stefan Ackermann, Michael Inden
 *
 * Copyright 2015 by Stefan Ackermann & Michael Inden
 */
public class Exercise2_InfiniteStreamSurprises
{
    public static void main(String[] args)
    {
        IntStream.iterate(0, i -> i + 1).
                  boxed().
                  limit(10).
                  sorted().
                  map(e -> "" + e).
                  forEach(System.out::println);
    }
}
