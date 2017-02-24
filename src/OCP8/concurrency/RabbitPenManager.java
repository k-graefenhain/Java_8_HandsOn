package OCP8.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class RabbitPenManager {

    public static void await(CyclicBarrier cb) {
        try {
            System.out.println(cb);
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(2, () -> System.out.println("Pen is full"));
        IntStream.iterate(1, i-> 1)
                .limit(2)
                .parallel()
                .forEach(i -> await(cb));
    }
}
