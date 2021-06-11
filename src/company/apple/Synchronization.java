package company.apple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Synchronization {
    private Random random = new Random();

    Object fooObj = new Object();
    Object barObj = new Object();

    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();
    private static List<Integer> list3 = new ArrayList<>();

    public synchronized void foo() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(random.nextInt(100));
    }

    public synchronized void bar() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list2.add(random.nextInt(100));
    }

    public void moreFoo() {
        synchronized (fooObj) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    private void moreBar() {
        synchronized (barObj) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    private void all() {
        synchronized (this) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list3.add(random.nextInt(100));
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            // Q1: foo() and moreFoo(), can be concurrent, foo() is fetching Synchronization class lock, and moreFoo() is
            // fetching the fooObj lock.
            foo();
            moreFoo();

            // Q2: foo() and bar(), no concurrency, because both synchronized method keyword will fetch the ReentrantLock
            // of Synchronization class, no multi-threading happens
//            foo();
//            bar();

            // Q3: foo() and all(), synchronized (this) is same as method synchronized keyword, so same as Q2, no synchronized.
//            foo();
//            all();
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting ...");
        long start = System.currentTimeMillis();
        Synchronization obj = new Synchronization();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.process();
            }
        });

//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                obj.process();
//            }
//        });

        t1.start();
//        t2.start();

        try {
            t1.join();
//            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("Time take: " + (end - start));
        System.out.println("List1: " + list1.size() + "; List2: " + list2.size()
            + "; List3: " + list3.size());
    }

    //Question
    /*
    1. foo() and moreFoo()
    2. foo() and bar()
    3. foo() and all()
     */
}
