package OCP8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelStreams {

	public static void main(String[] args) {

		List<String> strings = Arrays.asList("Am", "Samstag", "lernen", "ist", "einfach", "zu", "viel");

		// sequentiell
		List<String> words = new ArrayList(strings);
		String reduced = words.stream()
				.filter(s -> s.length() > 0)
				.reduce("", (a, b) -> a + " " + b);
		System.out.println(reduced);

		// parallel: Reihenfolge ändert sich
		words = new ArrayList(strings);
		words.parallelStream()
				.filter(s -> s.length() > 0)
				.forEach(s -> {
					System.out.println(Thread.currentThread().getName() + ": " + s);
				});
	}
}
