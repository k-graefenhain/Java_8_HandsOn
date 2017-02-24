package OCP8.streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Intermediate operations deal with infinite streams simply by returning an infinite stream.
 */
public class IntermediateOperations {

	public static void main(String[] args) {

		System.out.println("*** filter ***");
		/**
		 * filter()
		 * Stream<T> filter(Predicate<? super T> predicate)
		 */
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.filter(x -> x.startsWith("m")).forEach(System.out::println);


		System.out.println("*** distinct ***");
		/**
		 * distint()
		 * returns a stream with duplicate values removed
		 */
		s = Stream.of("duck", "duck", "goose", "duck");
		s.distinct().forEach(System.out::println);


		System.out.println("*** limit / skip ***");
		/**
		 * limit() / skip()
		 * make a stream smaller / make a finite out on an infinite stream
		 */
		Stream<Integer> numbers = Stream.iterate(1, n -> n+1);		// infinite stream of numbers counting from 1
		numbers.skip(5).limit(2).forEach(System.out::println);

		System.out.println("*** map ***");
		/**
		 * map()
		 * converts the elements of the stream according to the lambda expression
		 * <R> Stream<R> map(Function<? super T, ? extends R> mapper)
		 */
		s = Stream.of("monkey", "gorilla", "bonobo");
		s.map(String::length).forEach(System.out::print);
		System.out.println();

		System.out.println("*** flatMap ***");
		/**
		 * flatMap()
		 * makes any element top-level elements in a single stream,
		 * helpful to remove empty elements of to combine a stream of lists
		 */
		List<String> zero = new ArrayList<>(Arrays.asList());
		List<String> bonobo = new ArrayList<>(Arrays.asList("Bonobo"));
		List<String> gorillas = new ArrayList<>(Arrays.asList("Mama Gorilla", "Baby Gorilla"));
		Stream<List<String>> monkeys = Stream.of(zero, bonobo, gorillas);
		monkeys.forEach(System.out::println);		// without flatMap
		monkeys = Stream.of(zero, bonobo, gorillas);
		monkeys.flatMap(Collection::stream).forEach(System.out::println);		// empty element removed, list elements top-level


		System.out.println("*** sorted ***");
		/**
		 * sorted()
		 * returns a stream with the elements sorted,
		 * uses natural ordering unless we specify a comparator
		 *
		 * signatures:
		 * Stream<T> sorted
		 * Stream<T> sorted(Comparator<? super T> comparator)
		 */
		s = Stream.of("monkey", "gorilla", "bonobo");
		s.sorted().map(m -> m + ", ").forEach(System.out::print);
		System.out.println();
		s = Stream.of("monkey", "gorilla", "bonobo");
		s.sorted(Comparator.reverseOrder()).map(m -> m + ", ").forEach(System.out::print);

		// WATCH OUT:
		// does not compile
		// Comparator functional interface: int compare(T o1, T o2);
		// Comparator.reverseOrder has no parameters and no return value -> method reference cannot be used
//		s.sorted(Comparator::reverseOrder);
		s = Stream.of("monkey", "gorilla", "bonobo");
		s.sorted((a, b) -> b.compareTo(a)).map(m -> m + ", ").forEach(System.out::print);


		System.out.println("\n*** peek ***");
		/**
		 * peek()
		 * allows to perform a stream operation without actually chaning the stream, useful for debugging
		 *
		 * signature:
		 * Stream<T> peek(Consumer<? super T> action)
		 */
		s = Stream.of("brown bear", "black bear", "grizzly");
		long count = s.filter(b -> b.startsWith("g")).peek(System.out::println).count();
		System.out.println(count);

		// WATCH OUT: peek() is intended not to change the result!!!
		monkeys = Stream.of(zero, bonobo, gorillas);
		StringBuilder builder = new StringBuilder();
		monkeys.peek(l -> builder.append(l)).map(List::size).forEach(System.out::println);

		monkeys = Stream.of(bonobo, gorillas);
		monkeys.peek(l -> l.remove(0)).map(List::size).forEach(System.out::println);	// here peek modifies the list!!!

		// the original is not changed here
		List<Integer> numbersList = new ArrayList<>();
		numbersList.add(1);
		numbersList.add(7);
		numbersList.add(4);
		numbersList.add(3);
		numbersList.add(5);
		Predicate<Integer> predicate = p -> p < 5;

		numbersList.stream().filter(predicate);
		System.out.println(numbersList);
	}
}
