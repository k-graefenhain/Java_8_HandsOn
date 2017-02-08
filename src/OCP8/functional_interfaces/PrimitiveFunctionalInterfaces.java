package OCP8.functional_interfaces;

import java.util.function.BinaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class PrimitiveFunctionalInterfaces {

	public static void main(String[] args) {

		System.out.println("ToIntFunction: ");
		Stream<Double> dbls = Stream.of(10.0, 20.1, 30.2);
		ToIntFunction<Double> lif= d -> d.intValue();
//		same as: ToIntFunction<Double> lif= Double::intValue;
		Stream<Integer> ints = dbls.mapToInt(lif).boxed();
		ints.forEach(System.out::print);

		System.out.println("\nLongUnaryOperator: ");
		LongUnaryOperator lou = l -> l*2;
		LongUnaryOperator compose = lou.compose(lou);
		long l = compose.applyAsLong(3);
		System.out.println(l);

		System.out.println("BinaryOperator: ");
		BinaryOperator<Integer> bI = Integer::rotateLeft;
		System.out.println(bI.apply(2, 3));
	}
}
