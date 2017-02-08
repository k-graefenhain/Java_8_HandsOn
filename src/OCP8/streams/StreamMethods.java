package OCP8.streams;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamMethods {

	public static void main(String[] args) {
		Stream<Integer> integerStream = Stream.of(12, 40, 11, 22);
		Optional<Integer> min = integerStream.filter((Integer p) -> p % 2 == 0).min(Integer::compare);		//Optional<T> min(Comparator<? super T> comparator);
		System.out.println(min);		// prints "Optional[12]"
	}
}
