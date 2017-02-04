package JUGS.ch2_collections;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class Exercise1_PredicatesExample
{
    public static void main(String[] args)
    {
        final Predicate<Integer> isEven = i -> i % 2 == 0;                                    
        final IntPredicate isPositive = i -> i > 0;                      

        final Predicate<String> isShortWord = str -> str.length() <= 3;      
        
        
        System.out.println("isEven(2)? " + isEven.test(2));
        System.out.println("isPositive(-7)? " + isPositive.test(-7));
        System.out.println("isShortWord('Tim')? " + isShortWord.test("Tim"));
    }
}