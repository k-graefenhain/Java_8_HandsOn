package JUGS.ch3_streams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class Exercise2_StreamsExample 
{
	public static void main(String[] args) 
	{	
		// 2a
		// --
		System.out.println("IntStream.of");
		IntStream.of(1,2,3,4,5,6,7,8,9,10).forEach(System.out::println);
		final IntStream oneToFive = IntStream.of(1,2,3,4,5);
		final IntStream sixToTen = IntStream.of(6,7,8,9,10);
		IntStream.concat(oneToFive, sixToTen).forEach(System.out::println);
		
		System.out.println("IntStream.range + rangeClosed");
		IntStream.range(1, 11).forEach(System.out::println);
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		System.out.println("IntStream.rangeClosed and filter");
		IntStream.rangeClosed(1, 100).filter(n -> n <= 10).forEach(System.out::println);
		
		// 2b
		// --
		System.out.println("Stream.iterate");
		Stream.iterate(1, n -> n + 1).limit(10).forEach(System.out::println);
		System.out.println("Stream.iterate 11-21");
		Stream.iterate(1, n -> n + 1).skip(10).limit(11).forEach(System.out::println);
		
		System.out.println("Stream.generate");
// Cannot make a static reference to the non-static method incrementAndGet() from the type AtomicInteger
// IntStream.generate(AtomicInteger::incrementAndGet).limit(10).forEach(System.out::println);
		IntStream.generate(new AtomicInteger()::incrementAndGet).limit(11).forEach(System.out::println);  
		IntStream.generate(new AtomicInteger()::incrementAndGet).skip(10).limit(11).forEach(System.out::println);
	}
}
