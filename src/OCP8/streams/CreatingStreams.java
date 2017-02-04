package OCP8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingStreams {

	public static void main(String[] args) {
		Stream<String> empty = Stream.empty();
		Stream<Integer> singleElement = Stream.of(1);
		Stream<Integer> fromArray = Stream.of(1, 2, 3);

		// convert from a list to a stream:
		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> fromList = list.stream();
		// WATCH OUT:
		Stream<List<String>> list1 = Stream.of(list);

		Stream<String> parallelStream = list.parallelStream();

		// infinite stream of random numbers
//		Stream<Double> randoms = Stream.generate(Math::random);
//		randoms.forEach(System.out::println);
		// infinit stream of odd number
//		Stream.iterate(1, n -> n + 2).forEach(System.out::println);


		streamPipeline();



		/**
		 * alternative ways of printing out streams
		 */
		System.out.println(fromList.collect(Collectors.toSet()));

		/**
		 * for infinite streams: limit the number of elements before printing
		 */
		Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
		infinite.limit(5).forEach(System.out::println);
	}

	/**
	 * examples putting together the stream pipeline
	 */
	private static void streamPipeline() {

		// get the first two names alphabetically that are four characters long
		List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
		list.stream().filter(n -> n.length() == 4)
				.sorted()
				.limit(2)
				.forEach(System.out::println);

		// infinite stream, filtered and limited to 2 -> prints out Elsa twice
		Stream.generate(() -> "Elsa")
				.filter(n -> n.length() == 4)
				.limit(2)
				.sorted()
				.forEach(System.out::println);

		// infinite stream, filter doesn't let anything throught, limit gets no elements -> hangs until we kill the programm
//		Stream.generate(() -> "Olaf Lazisson")
//				.filter(n -> n.length() == 4)
//				.limit(2)
//				.sorted()
//				.forEach(System.out::println);


		Stream<Integer> infinite = Stream.iterate(1, x -> x+1);
		infinite.limit(5)
				.peek(System.out::print)
				.filter(x -> x%2 == 1)
				.forEach(System.out::print);		// peek prints out all elements, stream filters even elements
		System.out.println();
		infinite = Stream.iterate(1, x -> x+1);
		infinite.limit(5)
				.filter(x -> x%2 == 1)
				.peek(System.out::print)
				.forEach(System.out::print);
		System.out.println();

		// changing the order of operations, changes the result: first filter, than limit
		infinite = Stream.iterate(1, x -> x+1);
		infinite.filter(x -> x%2 == 1)
				.limit(5)
				.forEach(System.out::print);
		System.out.println();
	}
}
