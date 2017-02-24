package OCP8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsTest {

    public CollectorsTest() {
    }

    public static void main(String[] args) {
        IntStream ints = IntStream.rangeClosed(1, 5);
        Long collect = ints.mapToObj(i -> new Integer(i)).collect(Collectors.counting());
        System.out.println(collect);

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Double average = ohMy.collect(Collectors.averagingInt(String::length));
        System.out.println(average);

        ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println(result);

        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map = ohMy.collect(Collectors.toMap(String::length, v -> v,
                (s1, s2) -> s1 + ", " + s2, TreeMap::new));
        System.out.println(map);

        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map1 = ohMy.collect(Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map1);

        ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map2 = ohMy.collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(map2);

//        ohMy = Stream.of("lions", "tigers", "bears");
//        Map<Integer, List<Character>> map3 = ohMy.collect(Collectors.groupingBy(String::length,
//                Collectors.mapping(s -> s.charAt(0),
//                        Collectors.minBy(Comparator.naturalOrder()))));
//        System.out.println(map3);
    }
}
