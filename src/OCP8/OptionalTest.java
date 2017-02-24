package OCP8;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class OptionalTest {

    final static OptionalInt j = OptionalInt.of(32);

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("one", "two", "three");
        Optional<String> op = stream.filter(s -> s.length() > 5)
                .findFirst().flatMap(s -> Optional.of("4"));
        System.out.println(op);

        Optional<Integer> opt = Optional.of(8);
        opt.filter(p -> p>8).ifPresent(System.out::print);


        char c = 'A';
        System.out.println((char)calc(c));
    }

    private static int calc(int i) {
        if (j.isPresent()) {
            return j.getAsInt() + i;
        }
        return i;
    }
}
