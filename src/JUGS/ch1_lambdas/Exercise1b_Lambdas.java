package JUGS.ch1_lambdas;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class Exercise1b_Lambdas
{
    public interface LongBinaryOperator
    {
        long applyAsLong(final long left, final Long right);
    }
    
    public static void main(String[] args)
    {
        final LongBinaryOperator v1 = (long x, Long y) -> { return x + y; };

        // incompatible types
        // final LongBinaryOperator v2 = (long x, long y) -> { return x + y; };

        // incompatible types
        // final LongBinaryOperator v3 = (long x, long y) -> x + y;

        // final LongBinaryOperator v4 = (long x, y) -> x + y;

        final LongBinaryOperator v5 = (x, y) -> x + y;

        // final LongBinaryOperator v6 = x, y -> x + y;  
    }
}