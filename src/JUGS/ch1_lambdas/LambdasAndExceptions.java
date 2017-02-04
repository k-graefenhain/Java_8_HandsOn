package JUGS.ch1_lambdas;

import java.io.IOException;
import java.util.Comparator;

/**
 * Created by kag on 18/08/15.
 */
public class LambdasAndExceptions {

    public static void main(String[] args) {

        final MyRunnable runner = () -> { System.out.println("Throwing");
            throw new IOException(); };

        final MyRunnable runner2 = () -> { System.out.println("RunnableThatThrows"); throw new IOException(); };
        runner2.run();
    }

    public interface MyRunnable extends Runnable {
        default void run() {
            try {
                runThrows();
            } catch (final IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void runThrows() throws IOException;
    }

    public interface ComparatorThatThrows<T> extends Comparator<T> {

        @Override
        default int compare(final T o1, final T o2) {
            try {
                return compareThrows(o1, o2);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public int compareThrows(final T t1, final T t2) throws Exception;
    }
}
