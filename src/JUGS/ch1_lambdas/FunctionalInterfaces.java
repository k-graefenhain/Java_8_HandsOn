package JUGS.ch1_lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kag on 18/08/15.
 */
public class FunctionalInterfaces {

    public static void main(String[] args) {
        StringToIntConverter stringToIntConverter = str -> { return str.length(); };
        System.out.println(stringToIntConverter.convert("test"));

        StringToStringMapper stringToStringMapper = str -> str.toUpperCase();
        System.out.println(stringToStringMapper.convert("ruby"));

        final List<String> names = Arrays.asList("Tim", "Andi", "Michael");
        final Mapper<String, Integer> intMapper = String::length;
        System.out.println(intMapper.mapAll(names));

        final Mapper<String, String> stringMapper = str -> ">> " + str.toUpperCase() + " << ";
        final List<String> uppercaseNames = stringMapper.mapAll(names);
        System.out.println(uppercaseNames);
    }

    @FunctionalInterface
    public interface StringToIntConverter {
        int convert(final String input);
    }

    @FunctionalInterface
    public interface StringToStringMapper {
        String convert(final String input);
    }

    @FunctionalInterface
    public interface Mapper<S, T> {
        T map(S input);

        default public List<T> mapAll(final List<S> input) {
            final List<T> result = new ArrayList<>();
            for (S s : input) {
                final T t = map(s);
                result.add(t);
            }
            return result;
        }
    }
}
