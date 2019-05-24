package mj.houzz;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * leetcode 295
 * https://www.1point3acres.com/bbs/thread-454843-1-1.html
 */
public class MedianFinder {

    int count;
    double sum;
    PriorityQueue<Integer> minPQ;
    PriorityQueue<Integer> maxPQ;

    public MedianFinder() {
        count = 0;
        sum = 0;
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    }

    // O(logn)
    public void compute(int num) {
        if (count % 2 == 0) {
            maxPQ.add(num);
            minPQ.add(maxPQ.poll());
        } else {
            minPQ.add(num);
            maxPQ.add(minPQ.poll());
        }
        count++;
        sum += num;
    }

    // O(1)
    public double findMedian() {
        if (count % 2 == 0) {
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        } else {
            return minPQ.peek();
        }
    }

    public double getSum() {
        return sum;
    }

    public double getAverage() {
        return sum / count;
    }

    public static void main(String[] args) {
        MedianFinder t = new MedianFinder();
        t.compute(1);
        t.compute(2);
        System.out.println(t.findMedian());
        t.compute(3);
        System.out.println(t.findMedian());
        System.out.println(t.getSum());
        System.out.println(t.getAverage());
    }
}
