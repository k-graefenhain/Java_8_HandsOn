package OCP8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableAndRunnable {

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

            service.submit(() -> { Thread.sleep(1000); return null; });     // treated as a Callable

            // no return type: treated as a Runnable -> unhandled InterruptedException
//            service.submit(() -> { Thread.sleep(1000)});
        } finally {
            if (service != null)
                service.shutdown();
        }
    }
}
