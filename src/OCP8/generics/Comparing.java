package OCP8.generics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by katja on 14.02.17.
 */
public class Comparing {

    public static void main(String[] args) {
        String[] values = { "123", "Abb", "aab" };
        Arrays.sort(values, new MyComparator());
        for (String value : values) {
            System.out.println(value + " ");
        }

        Sorted s1 = new Sorted(88, "a");
        Sorted s2 = new Sorted(55, "b");
        TreeSet<Sorted> t1 = new TreeSet<>();
        t1.add(s1);
        t1.add(s2);
        TreeSet<Sorted> t2 = new TreeSet<>(s1);
        t2.add(s1);
        t2.add(s2);
        System.out.println(t1 + " " + t2);
    }

    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o2.toLowerCase().compareTo(o1.toLowerCase());
        }
    }

    public static class Sorted implements Comparable<Sorted>, Comparator<Sorted> {
        private int num;
        private String text;

        public Sorted(int num, String text) {
            this.num = num;
            this.text = text;
        }

        @Override
        public String toString() {
            return "" + num;
        }

        @Override
        public int compareTo(Sorted s) {
            return text.compareTo(s.text);
        }

        @Override
        public int compare(Sorted o1, Sorted o2) {
            return o1.num - o2.num;
        }
    }
}
