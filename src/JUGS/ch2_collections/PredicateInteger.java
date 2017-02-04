package JUGS.ch2_collections;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Created by kag on 18/08/15.
 */
public class PredicateInteger {

    public static void main(String[] args) {
        final Predicate<Integer> isEven = i -> i%2 == 0;
        final IntPredicate isEven2 = i -> i%2 == 0;
        final IntPredicate isPositive = i ->  i > 0;

        System.out.println(isEven.test(4));
        System.out.println(isEven.test(5));
        System.out.println(isPositive.test(8));
        System.out.println(isPositive.test(-3));

        System.out.println(isPositive.and(isEven2).test(8));
        System.out.println(isPositive.and(isEven2.negate()).test(7));
    }
}
