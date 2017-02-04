package JUGS.ch1_lambdas.bonus_recursive;

import java.util.function.UnaryOperator;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class SimpleRecursiveLambdaExample
{
    public static UnaryOperator<Integer> f;

    public static void main(String[] args)
    {
        f = i -> i == 0 ? 1 : i * f.apply(i - 1);
        System.out.println(f.apply(5));
    }
}