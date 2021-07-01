package company.lnkin.design;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue<E> {
    private int capacity;
    private Queue<E> queue;
    private Lock lock = new ReentrantLock();
    private Lock pushLock = new ReentrantLock();
    private Condition full = this.lock.newCondition();
    private Condition empty = this.lock.newCondition();

    /**
     * Only initialize the queue once and throws exception if the user is
     * trying to initialize it multiple times.
     * @param capacity
     * @throws Exception
     */
    public void init(int capacity) throws Exception {
        this.lock.lock();
        try {
            if (this.queue == null) {
                this.queue = new LinkedList<>();
                this.capacity = capacity;
            } else {
                throw new Exception();
            }
        } finally {
            this.lock.unlock();
        }
    }

    public void push(E obj) throws Exception {
        this.pushLock.lock();
        this.lock.lock();
        try {
            while (this.capacity == this.queue.size()) {
                this.full.wait();
            }
            this.queue.add(obj);
            this.empty.notifyAll();
        } finally {
            this.lock.unlock();
            this.pushLock.unlock();
        }
    }

    public E pop() throws Exception {
        this.lock.lock();
        try {
            while (this.capacity == 0) {
                this.empty.wait();
            }
            E result = this.queue.poll();
            full.notifyAll();
            return result;
        } finally {
            this.lock.unlock();
        }
    }


}
