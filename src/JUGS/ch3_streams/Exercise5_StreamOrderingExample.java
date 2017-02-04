package JUGS.ch3_streams;

import java.util.stream.Stream;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 * 
 * Angelehnt an http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 */
public class Exercise5_StreamOrderingExample 
{
	public static void main(final String[] args) 
	{
		Stream.of("Andi", "Barbara", "Carsten", "Marius", "Merten", "Micha", "Tim").
		       map(name -> { System.out.println("map: " + name); return name.toUpperCase(); }).
		       filter(name -> { System.out.println("filter: " + name); return name.startsWith("M"); }).
		       forEach(name -> System.out.println("forEach: " + name));

		// 5a
		Stream.of("Andi", "Barbara", "Carsten", "Marius", "Merten", "Micha", "Tim").
			   filter(name -> { System.out.println("filter: " + name); return name.startsWith("M"); }).
			   map(name -> { System.out.println("map: " + name); return name.toUpperCase(); }).
	           forEach(name -> System.out.println("forEach: " + name));

		// 5b 
		Stream.of("Andi", "Barbara", "Carsten", "Marius", "Merten", "Micha", "Tim").
	       map(name -> { System.out.println("map: " + name); return name.toUpperCase(); }).
	       filter(name -> { System.out.println("filter: " + name); return name.startsWith("M"); }).
	       forEach(name -> System.out.println("forEach: " + name));

		// 5c 
		Stream.of("Andi", "Barbara", "Carsten", "Marius", "Merten", "Micha", "Tim").
		       sorted((s1, s2) -> { System.out.printf("sort: %s; %s\n", s1, s2); return s1.compareTo(s2); }).
		       map(name -> { System.out.println("map: " + name); return name.toUpperCase(); }).
	           filter(name -> { System.out.println("filter: " + name); return name.startsWith("M"); }).
		       forEach(name -> System.out.println("forEach: " + name));

		// Tipp: Optimierung durch Reodering der Operationen: filter zuerst, dann sort oder map
		// 5c 
		Stream.of("Andi", "Barbara", "Carsten", "Marius", "Merten", "Micha", "Tim").
	           filter(name -> { System.out.println("filter: " + name); return name.startsWith("M"); }).
		       map(name -> { System.out.println("map: " + name); return name.toUpperCase(); }).
	           sorted((s1, s2) -> { System.out.printf("sort: %s; %s\n", s1, s2); return s1.compareTo(s2); }).
		       forEach(name -> System.out.println("forEach: " + name));
				
		// 4d parallel	
		System.out.println("4d parallel");
		Stream.of("Andi", "Barbara", "Carsten", "Marius", "Merten", "Micha", "Tim").
				parallel().
                filter(name -> { System.out.println("filter: " + name); return name.startsWith("M"); }).
	            map(name -> { System.out.println("map: " + name); return name.toUpperCase(); }).
                sorted((s1, s2) -> { System.out.printf("sort: %s; %s\n", s1, s2); return s1.compareTo(s2); }).
	            forEach(name -> System.out.println("forEach: " + name));
	
		
		Stream.of("Andi", "Barbara", "Carsten", "Marius", "Merten", "Micha", "Tim").
		         parallel()
				.filter(name -> {
					System.out.format("filter: %s [%s]\n", name, Thread
							.currentThread().getName());
				   return name.startsWith("M"); 
				})
				.map(s -> {
					System.out.format("map: %s [%s]\n", s, Thread
							.currentThread().getName());
					return s.toUpperCase();
				})
				.sorted((s1, s2) -> {
					System.out.format("sort: %s <> %s [%s]\n", s1, s2, Thread
							.currentThread().getName());
					return s1.compareTo(s2);
				})
				.forEach(
						s -> System.out.format("forEach: %s [%s]\n", s, Thread
								.currentThread().getName()));
		
		
		Stream.of("Andi", "Barbara", "Carsten", "Marius", "Merten", "Micha", "Tim").parallel()
				.filter(name -> {
					System.out.format("filter: %s [%s]\n", name, Thread
							.currentThread().getName());
				   return name.startsWith("M"); 
				})
				.map(s -> {
					System.out.format("map: %s [%s]\n", s, Thread
							.currentThread().getName());
					return s.toUpperCase();
				})
				.sorted((s1, s2) -> {
					System.out.format("sort: %s <> %s [%s]\n", s1, s2, Thread
							.currentThread().getName());
					return s1.compareTo(s2);
				})
				.forEachOrdered(
						s -> System.out.format("forEach: %s [%s]\n", s, Thread
								.currentThread().getName()));
	}
}
