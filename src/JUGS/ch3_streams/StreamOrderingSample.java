package JUGS.ch3_streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kag on 18/08/15.
 */
public class StreamOrderingSample {

    public static void main(String[] args) {

        Stream.of("Andi", "Barbara", "Carsten", "Marius", "Micha", "Tim").
                map(name -> {
                    System.out.println("map: " + name);
                    return name.toUpperCase();
                }).
                filter(name -> {
                    System.out.println("filter: " + name);
                    return name.startsWith("M");
                }).
                forEach(name -> System.out.println("forEach: " + name));


        System.out.println();
        System.out.println("use Stream.peek(Consumer):");

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }
}
