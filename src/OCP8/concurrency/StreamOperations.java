package OCP8.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

    public static void main(String[] args) {

        // three-argument reduce method
        System.out.println(Arrays.asList('w', 'o', 'l', 'f')
            .stream()
            .reduce("",
                    (c, s1) -> {
                        System.out.println("c: " + c + " s1: " + s1) ; return c+s1; },
                    (s2, s3) -> {
                        System.out.println("s2: " + s2 + " s3:" + s3) ; return s2+s3; }));

        // ???
//        System.out.println(Arrays.asList("duck", "chicken", "flamingo", "pelican")
//            .parallelStream()
//            .reduce(1, (c1, c2) -> {
//                System.out.println("c1: " + c1 + " c2: " + c2);
//                return c1 + c2.length();
//            }, (s1, s2) -> {
//                System.out.println("s1: " + s1 + " s2: " + s2);
//                return s1 + s2;
//            }));


        // three-argument version of collect (Supplier, BiConsumer, BiConsumer)
        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
        System.out.println(set);

        stream = Stream.of("w", "o", "l", "f").parallel();
        ConcurrentMap<String, String> result = stream.collect(Collectors.toConcurrentMap(k -> k, k -> k));
        System.out.println(result);


        // groupingBy
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, List<String>> map = ohMy.collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(map);
    }
}
