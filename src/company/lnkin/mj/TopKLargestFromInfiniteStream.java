package company.lnkin.mj;

import java.util.PriorityQueue;

/**
 * # Write a program which takes an infinite stream of random integers and provides a method to query the top K largest integers encountered so far.
 * # K = 2, 1,2,3,4
 * # init(2), addNumber(1), getTopK(), addN‍‍‍‌‌‍‍‍‌‌‍‌‍‍‍‌‍umber(2), addNumber(3), getTopK(), addNumber(0), getTopK()
 */
public class TopKLargestFromInfiniteStream {
    private int capacity;
    private PriorityQueue<Integer> pq;

    public TopKLargestFromInfiniteStream(int K) {
        this.capacity = K;
        this.pq = new PriorityQueue<>();
    }

    private void addNumber(int num) {
        if (pq.size() < capacity) {
            pq.add(num);
            return;
        }
        int min = pq.peek();
        if (num > min) {
            pq.poll();
            pq.add(num);
        }
    }

    private Integer[] getTopK() {
        return (Integer[]) pq.toArray();
    }
}
