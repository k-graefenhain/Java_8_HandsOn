package OCP8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethods {

	public static void main(String[] args) {
		Stream<Integer> integerStream = Stream.of(12, 40, 11, 22);
		Optional<Integer> min = integerStream.filter((Integer p) -> p % 2 == 0).min(Integer::compare);		//Optional<T> min(Comparator<? super T> comparator);
		System.out.println(min);		// prints "Optional[12]"

		// total
		Stream<Trade> list = Stream.of(new Trade(1, 1000, "John"),
				new Trade(5, 200, "Alice"),
				new Trade(4, 250, "Lisa"));
		Stream<Double> doubleStream = list.map(Trade::getTotal);
		doubleStream.forEach(System.out::println);


		List<String> exams = Arrays.asList("1Z0-809", "1Z0-810", "1Z1-811", "1Z0-803");
		List<String> collect = exams.stream().flatMap(e -> Stream.of(e.split("-")))
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		System.out.println(collect);
	}
}

class Trade {
	int quantity;
	double price, total;
	String buyer;

	public Trade(int quantity, double price, String buyer) {
		this.quantity = quantity;
		this.price = price;
		this.total = quantity * price;
		this.buyer = buyer;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Trade{" +
				"total=" + total +
				", buyer='" + buyer + '\'' +
				'}';
	}
}