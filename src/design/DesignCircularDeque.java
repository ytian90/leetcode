package design;

import java.util.ArrayList;
import java.util.List;

/**
 * 641. Desgin Circular Deque
 */
public class DesignCircularDeque {
    private List<Integer> list;
    private int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public DesignCircularDeque(int k) {
        this.list = new ArrayList<>();
        this.capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (list.size() == capacity)
            return false;
        list.add(0, value);
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (list.size() == capacity)
            return false;
        list.add(value);
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (list.size() == 0)
            return false;
        list.remove(0);
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (list.size() == 0)
            return false;
        list.remove(list.size() - 1);
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (list.isEmpty())
            return -1;
        return list.get(0);
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (list.isEmpty())
            return -1;
        return list.get(list.size() - 1);
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return list.size() == capacity;
    }

    public static void main(String[] args) {
        DesignCircularDeque circularDeque = new DesignCircularDeque(3); // set the size to be 3
        System.out.println(circularDeque.insertLast(1));			// return true
        System.out.println(circularDeque.insertLast(2));			// return true
        System.out.println(circularDeque.insertFront(3));			// return true
        System.out.println(circularDeque.insertFront(4));			// return false, the queue is full
        System.out.println(circularDeque.getRear());  				// return 32
        System.out.println(circularDeque.isFull());				// return true
        System.out.println(circularDeque.deleteLast());			// return true
        System.out.println(circularDeque.insertFront(4));			// return true
        System.out.println(circularDeque.getFront());				// return 4
    }
}
