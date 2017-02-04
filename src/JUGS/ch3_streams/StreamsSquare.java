package JUGS.ch3_streams;

import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * Created by kag on 18/08/15.
 */
public class StreamsSquare {

    public static void main(String[] args) {
//        final int result = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(i -> i % 2 != 0)
//                .map(i -> i*i)
//                .reduce(0, (i, j) -> i+j);
//        System.out.println(result);


//        final IntPredicate isEven = i -> i % 2 == 1;
//        final IntUnaryOperator square = n -> n * n;
//        final IntBinaryOperator adder = (i,j) -> i + j;
//
//        final int result = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(isEven)
//                .map(square)
//                .reduce(0, Integer::sum);
//        System.out.println(result);
//
//
//        IntStream.iterate(11, i -> i = i+1).limit(10).boxed().map(e -> e + ", ").forEach(i -> System.out.print(i));
    }
}
