package JUGS.ch2_collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by kag on 18/08/15.
 */
public class PredicateString {

    public static void main(String[] args) {
        Predicate<String> isShort = str -> str.length() < 4;

        final List<String> names = createNamesList();
        names.removeIf(name -> isShort.test(name));
        names.forEach(name -> System.out.println(name));
    }

    private static List<String> createNamesList() {
        final List<String> names = new ArrayList<>();
        names.add("Michael");
        names.add("Tim");
        names.add("Flo");
        names.add("Clemens");
        return names;
    }
}
