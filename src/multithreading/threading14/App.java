package multithreading.threading14;

import java.util.Random;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting.");

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<?> fu = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                Random random = new Random();
                for (int i = 0; i < 1E8; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }

                    Math.sin(random.nextDouble());
                }
                return null;
            }
        });

        executorService.shutdown();

        Thread.sleep(500);

        // way 1:
//        fu.cancel(true);
        // way 2:
        executorService.shutdownNow();

        executorService.awaitTermination(1, TimeUnit.DAYS);

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Random random = new Random();
//
//                for (int i = 0; i < 1e8; i++) {
//                    if (Thread.currentThread().isInterrupted()) {
//                        System.out.println("Interrupted!");
//                        break;
//                    }
//
////                    try {
////                        Thread.sleep(1);
////                    } catch (InterruptedException e) {
////                        System.out.println("We've been interrupted");
////                        break;
////                    }
//                    Math.sin(random.nextDouble());
//                }
//            }
//        });
//        t.start();
//
//        Thread.sleep(500);
//
//        t.interrupt();
//
//        t.join();


        System.out.println("Finished.");
    }
}
