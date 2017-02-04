package OCP8.streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Terminal operations can be performed without any intermediate operations but not the other way round.
 */
public class TerminalOperations {

	public static void main(String[] args) {

		// Arrays.asList() returns a backed list -> add throws UnsupportedOperationException
		List<String> list = new ArrayList<>(Arrays.asList("monkey", "gorilla", "bonobo"));

		// count()
		// non terminating reduction, return value: long
		System.out.println(Stream.of("monkey", "gorilla", "bonobo").count());

		// min(<? super T> comparator) / max(<? super T> comparator)
		// non terminating reduction, return value: Optional
		Optional<String> min = list.stream().min((s1, s2) -> s1.length() - s2.length());
		min.ifPresent(System.out::println);

		Optional<Object> empty = Stream.empty().min((s1, s2) -> 0);
		System.out.println(empty.isPresent());

		// findFirst() / findAny()
		// terminating, no reduction, returns Optional<T>
		list.stream().findAny().ifPresent(System.out::println);

		Stream<String> infinite = Stream.generate(() -> "chimp");
		infinite.findAny().ifPresent(System.out::println);			// findAny() is terminating here

		// allMatch() / anyMatch() / noneMatch() -> arg: Predicate<? super T> predicate
		// sometimes terminating, no reduction, returns boolean
		list.add("2");
		Predicate<String> predicate = in -> Character.isLetter(in.charAt(0));
		System.out.println(list.stream().anyMatch(predicate));
		System.out.println(list.stream().allMatch(predicate));
		System.out.println(list.stream().noneMatch(predicate));

		// forEach()
		// non-terminating, no reduction, void return
		Stream<String> stream = list.stream();
		stream.forEach(System.out::println);


		System.out.println("*** reduce ***");
		/**
		 * reduce()
		 * T reduce(T identity, BinaryOperator<T> accumulator)
		 * non-terminating reduction, comines a stream into a single object
		 */
		stream = Stream.of("w", "o", "l", "f");
		String word = stream.reduce("", (s, c) -> s + c);		// or with a method reference: stream.reduce("", String::concat)
		System.out.println(word);

		Stream<Integer> intStream = Stream.of(3, 5, 6);
		Integer multiplied = intStream.reduce(1, (a, b) -> a * b);
		System.out.println(multiplied);
		// without specifying the identity: Optional<T> reduce(BinaryOperator<T> accumulator):
		intStream = Stream.of(3, 5, 6);
		BinaryOperator<Integer> integerBinaryOperator = (a, b) -> a * b;
		Optional<Integer> reduce = intStream.reduce(integerBinaryOperator);
		reduce.ifPresent(System.out::println);
		Stream<Integer> emptyInt = Stream.empty();
		emptyInt.reduce(integerBinaryOperator).ifPresent(System.out::println);	// no output
		Stream<Integer> oneInt = Stream.of(3);
		oneInt.reduce(integerBinaryOperator).ifPresent(System.out::println);	// 3

		// <U> u reduce(U identity, BiFunction<U, ? super T,U> accumulator, BinaryOperator<U> combiner)
		intStream = Stream.of(3, 5, 6);
		System.out.println(intStream.reduce(1, integerBinaryOperator, integerBinaryOperator));		// parallel execution


		System.out.println("*** collect ***");
		/**
		 * collect()
		 * non-terminating, reduction,
		 */
		stream = Stream.of("w", "o", "l", "f");
		// <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
		// when parallel processing: the last parameter takes 2 data collections and merges them
		StringBuilder stringBuilder = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(stringBuilder.toString());
		stream = Stream.of("w", "o", "l", "f");
		TreeSet<String> set = stream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		System.out.println(set);

		// use common collector:
		stream = Stream.of("w", "o", "l", "f");
		set = stream.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(set);
		// without sorting:
		stream = Stream.of("w", "o", "l", "f");
		Set<String> unsortedSet = stream.collect(Collectors.toSet());
		System.out.println(unsortedSet);
	}
}
