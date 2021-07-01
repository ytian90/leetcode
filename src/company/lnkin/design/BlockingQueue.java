package company.lnkin.design;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<E> {
    private List<E> queue;
    private int limit;

    public BlockingQueue(int limit) {
        this.queue = new LinkedList<>();
        this.limit = limit;
    }

    public synchronized void put(E item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            System.out.println("Waiting in Enqueue ");
            wait();
        }
        if (this.queue.isEmpty()) {
            notifyAll();
        }
        System.out.println(" Enqueue + " + item.toString());
        this.queue.add(item);
    }

    public synchronized E take() throws InterruptedException {
        while (this.queue.isEmpty()) {
            System.out.println(" Waiting in Dequeue ");
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        E val = this.queue.remove(0);
        System.out.println(" Dequeue " + val.toString());
        return val;
    }
}

