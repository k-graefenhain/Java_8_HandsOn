package OCP8.generics;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by katja on 14.02.17.
 */
public class GenericsTest {

    public static void main(String[] args) {
        Set<Number> numbers = new HashSet<>();
        numbers.add(new Integer(86));
        numbers.add(75);
        numbers.add(new Integer(86));
        numbers.add(null);
        numbers.add(309L);
        for (Number number : numbers) {
            System.out.println(number);
        }
    }
}
