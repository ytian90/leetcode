package leetcode.design;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

/**
 * 1188. Design Bounded Blocking Queue
 */
public class DesignBounderBlockingQueue {
    private Semaphore enq;
    private Semaphore deq;
    private ConcurrentLinkedDeque<Integer> q;

    public DesignBounderBlockingQueue(int capacity) {
        enq = new Semaphore(capacity);
        deq = new Semaphore(0);
        q = new ConcurrentLinkedDeque<>();
    }

    public void enqueue(int element) throws InterruptedException {
        enq.acquire();
        q.add(element);
        deq.release();
    }

    public int dequeue() throws InterruptedException {
        deq.acquire();
        int val = q.poll();
        enq.release();
        return val;
    }

    public int size() {
        return q.size();
    }
}
