package JUGS.ch1_lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class Exercise3_MapperExample
{
    public static void main(String[] args)
    {
        List<String> names = Arrays.asList("Tim", "Andi", "Michael");

        final Mapper<String, Integer> intMapper = String::length;
        System.out.println(intMapper.mapAll(names));

        final Mapper<String, String> stringMapper = str -> ">> " + str.toUpperCase() + " <<";
        final List<String> upperCaseNames = stringMapper.mapAll(names);
        System.out.println(upperCaseNames);
    }

    @FunctionalInterface
    public interface Mapper<S, T>
    {
        T map(S elem);

        default public List<T> mapAll(final List<S> sourceElements)
        {
            final List<T> convertedElements = new ArrayList<>();

            for (final S elem : sourceElements)
            {
                final T mappedElem = map(elem);
                convertedElements.add(mappedElem);
            }

            return convertedElements;
        }
    }
}
