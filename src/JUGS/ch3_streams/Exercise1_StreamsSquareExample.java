package JUGS.ch3_streams;

import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class Exercise1_StreamsSquareExample 
{
	public static void main(final String[] args) 
	{		
		System.out.println("IntStream filter-map-reduce plain lambdas");
		final int result1 = IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(i -> i % 2 != 1).
		                                                       map(n -> n * n).
		                                                       reduce(0, (i,j) -> i + j);		
		
		System.out.println("IntStream filter-map-reduce with vars");
		final IntPredicate isEven = i -> i % 2 != 1;
		final IntUnaryOperator square = n -> n * n;
		final IntBinaryOperator adder = (i,j) -> i + j;

		final int result2 = IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(isEven).
		                                                       map(square).
		                                                       reduce(0, adder);	
		
		System.out.println("IntStream filter-map-reduce with method reference");
		final int result3 = IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(isEven).
		                                                       map(square).
		                                                       reduce(0, Integer::sum);
		
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}
}
