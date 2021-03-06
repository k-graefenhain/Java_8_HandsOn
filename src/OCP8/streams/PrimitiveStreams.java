package OCP8.streams;

import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;


public class PrimitiveStreams {

	public static void main(String[] args) {

		// old school to calculate the sum of integers
		Stream<Integer> stream = Stream.of(1, 2, 3);
		System.out.println(stream.reduce(0, (s, n) -> s + n));

		stream = Stream.of(1, 2, 3);
		IntStream intStream = stream.mapToInt(x -> x);
		System.out.println(intStream.sum());

		intStream = IntStream.of(1, 2, 3);
		System.out.println(intStream.average().getAsDouble());


		LongStream longStream = LongStream.of(5, 10);
		long sum = longStream.sum();
		System.out.println(sum);

		DoubleStream doubleStream = DoubleStream.generate(() -> Math.PI);
//		OptionalDouble min = doubleStream.min();			runs infinitely

		System.out.println(IntStream.of(7, 4, 8, 10).min().orElse(0));
		System.out.println(IntStream.of(7, 4, 8, 10).max());

		System.out.println(max(IntStream.of(7, 4, 8, 10)));
		System.out.println(range(IntStream.of(7, 4, 8, 10)));

		System.out.println("mapToInt:");
		Stream<Double> doubleStr = Stream.of(2.2, 2.8, 2.5);
		IntStream intStr = doubleStr.mapToInt(Double::intValue);		// watch out: return type is IntStream (not Stream<Integer>)
		System.out.println(intStr.distinct().count());

		System.out.println("IntStream methods: ");
		intStr = IntStream.of(3, 2, 1, 5, 3, 4, 5);
		System.out.println(intStr.filter(e -> e>3)
				.distinct()
				.average()			// average() returns OptionalDouble
				.getAsDouble());
	}

	private static int max(IntStream ints) {
		OptionalInt max = ints.max();
		return max.orElseThrow(RuntimeException::new);
	}

	private static int range(IntStream ints) {
		IntSummaryStatistics stats = ints.summaryStatistics();
		if (stats.getCount() == 0) throw new RuntimeException();
		return stats.getMax() - stats.getMin();
	}
}
