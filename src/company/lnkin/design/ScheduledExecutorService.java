package company.lnkin.design;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorService {
    private class Task implements Runnable, Comparable<Task> {
        private long startTime;
        private Runnable runnable;

        public Task(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void run() {
            this.runnable.run();
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        @Override
        public int compareTo(Task o) {
            return Long.compare(this.getStartTime(), o.getStartTime());
        }

        @Override
        public String toString() {
            return "Task [startTime=" + startTime +"]";
        }
    }

    private class BackgroundScheduler extends Thread {
        @Override
        public void run() {
            while (ScheduledExecutorService.this.alive) {
                synchronized (ScheduledExecutorService.this) {
                    try {
                        while (ScheduledExecutorService.this.alive &&
                            ScheduledExecutorService.this.tasks.isEmpty()) {
                            ScheduledExecutorService.this.wait();
                        }
                        if (!ScheduledExecutorService.this.alive) {
                            return;
                        }
                        long now = System.currentTimeMillis();
                        Task task = tasks.peek();
                        if (task.getStartTime() <= now) {
                            tasks.poll();
                            new Thread(task).start();
                        } else {
                            ScheduledExecutorService.this.wait(task.getStartTime() - now);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    private PriorityQueue<Task> tasks;
    private final BackgroundScheduler backgroundScheduler;
    private volatile boolean alive;

    public ScheduledExecutorService() {
        this.tasks = new PriorityQueue<>();
        this.backgroundScheduler = new BackgroundScheduler();
        this.alive = true;
        this.backgroundScheduler.start();
    }

    public void schedule(Runnable command, long delay, TimeUnit unit) {
        long startTime = System.currentTimeMillis() + unit.toMillis(delay);
        Task task = new Task(command);
        task.setStartTime(startTime);
        synchronized (this) {
            this.tasks.offer(task);
            this.notifyAll();
        }
        System.out.println("Scheduled task " + task);
    }

    public void stop() throws InterruptedException {
        synchronized (this) {
            this.alive = false;
            this.notifyAll();
        }
        this.backgroundScheduler.join();
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledExecutorService();
        scheduledExecutorService.schedule(() -> {
            System.out.println("5 second delay");
        }, 5, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(() -> {
            System.out.println("1 second delay started");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            System.out.println("1 second delay stopped");
        }, 1, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(() -> {
            System.out.println("3 second delay");
        }, 3, TimeUnit.SECONDS);
    }
}
