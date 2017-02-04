package JUGS.ch3_streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class Exercise4_GroupingByExample
{
    public static void main(String[] args)
    {
        final Stream<String> inputs = Stream.of("Tim", "Tom", "Andy", "Mike", "Merten");    
        final Map<Character, List<String>> grouped = inputs.collect(Collectors.groupingBy(str -> str.charAt(0)));                           
        System.out.println(grouped);           
    }
}

