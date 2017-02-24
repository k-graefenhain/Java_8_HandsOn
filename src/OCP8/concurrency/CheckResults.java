package OCP8.concurrency;

import java.util.concurrent.*;

public class CheckResults {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // polling example
//        new Thread(() -> {
//            for (int i=0; i<500; i++) {
//                CheckResults.counter++;
//            }
//        }).start();
//
//        while (CheckResults.counter < 100) {
//            System.out.println("Not reached yet");
//            Thread.sleep(1000);
//        }
//
//        System.out.println("Reached");

        // polling with a Future
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 500; i++) {
                    CheckResults.counter++;
                }
            });
            result.get(10, TimeUnit.SECONDS);       // waits for at most 10 seconds
            System.out.println("Reached!");
        } catch(TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if (service != null)
                service.shutdown();
        }
    }
}
