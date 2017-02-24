package OCP8.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FindMin extends RecursiveTask {
    private Integer[] elements;
    private int a, b;

    public FindMin(Integer[] elements, int a, int b) {
        this.elements = elements;
        this.a = a;
        this.b = b;
    }

    public Integer compute() {
        if ((b-a) < 2) {
            return Math.min(elements[a], elements[b]);
        } else {
            int m = a + ((b-a)/2);
            System.out.println(a + ", " + m + ", " + b);
            FindMin t1 = new FindMin(elements, a, m);
            // since join() is called immediately after fork(), the process will wait
//            int result = t1.fork().join();
//            return Math.min(new FindMin(elements, m, b).compute(), result);
            t1.fork();
            int result = Math.min(new FindMin(elements, m, b).compute(), t1.compute());
            t1.join();
            return result;
        }
    }

    public static void main(String[] args) {
        Integer[] elements = new Integer[] { 8, -3, 2, -54 };
        ForkJoinTask<Integer> task = new FindMin(elements, 0, elements.length - 1);
        ForkJoinPool pool = new ForkJoinPool();
        Integer sum = pool.invoke(task);
        System.out.println("Min: " + sum);
    }
}
