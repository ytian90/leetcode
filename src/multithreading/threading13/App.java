package multithreading.threading13;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

//        Future<?> future = executor.submit(new Callable<Void>() {  // change call() type to Void, return null;
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);
                if (duration > 2000) {
                    throw new IOException("Sleeping for too long.");
                }

                System.out.println("Starting ...");

                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Finished.");
                return duration;
            }
        });

        executor.shutdown();

        try {
            System.out.println("Result is: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            IOException ex = (IOException) e.getCause();
            System.out.println(ex.getMessage());
        }
    }
}
