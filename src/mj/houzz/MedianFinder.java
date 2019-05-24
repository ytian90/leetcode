package mj.houzz;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * leetcode 295
 */
public class MedianFinder {

    int count;
    PriorityQueue<Integer> minPQ;
    PriorityQueue<Integer> maxPQ;

    public MedianFinder() {
        count = 0;
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    }

    // O(logn)
    public void addNum(int num) {
        if (count % 2 == 0) {
            maxPQ.add(num);
            minPQ.add(maxPQ.poll());
        } else {
            minPQ.add(num);
            maxPQ.add(minPQ.poll());
        }
        count++;
    }

    // O(1)
    public double findMedian() {
        if (count % 2 == 0) {
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        } else {
            return minPQ.peek();
        }
    }
    public static void main(String[] args) {
        MedianFinder t = new MedianFinder();
        t.addNum(1);
        t.addNum(2);
        System.out.println(t.findMedian());
        t.addNum(3);
        System.out.println(t.findMedian());
    }
}
