package OCP8.functional_interfaces;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static OCP8.functional_interfaces.Panda.check;

/**
 * Created by katja on 15.02.17.
 */
public class PredicateTest {

    public static void main(String[] args) {
        Panda p1 = new Panda();
        p1.age = 1;
        check(p1, p -> p.age < 5);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(7);
        numbers.add(4);
        numbers.add(3);
        numbers.add(5);
        Predicate<Integer> predicate = p -> p > 4;
        Consumer<Integer> consumer = System.out::print;
        numbers.stream().filter(predicate.negate()).forEach(consumer);
    }
}

class Panda {
    int age;

    protected static void check(Panda panda, Predicate<Panda> predicate) {
        String result = predicate.test(panda) ? "match" : "not match";
        System.out.println(result);
    }
}