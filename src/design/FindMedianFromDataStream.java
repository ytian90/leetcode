package design;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 * cc: page 72
 * @author yutian
 * @since Feb 19, 2016
 */
public class FindMedianFromDataStream {
	
	private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder()); // max heap
	private PriorityQueue<Integer> large = new PriorityQueue<>(); // min heap
	private boolean even = true;
	
	// Adds a number into the data structure.
    public void addNum(int num) {
        if (even) {
        	large.offer(num);
        	small.offer(large.poll());
        } else {
        	small.offer(num);
        	large.offer(small.poll());
        }
        even = !even;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (even) {
        	return (small.peek() + large.peek()) / 2.0;
        } else {
        	return small.peek();
        }
    }

	public static void main(String[] args) {
		FindMedianFromDataStream t = new FindMedianFromDataStream();
		t.addNum(1);
		t.addNum(2);
		t.addNum(3);
		System.out.println(t.findMedian());
		t.addNum(4);
		System.out.println(t.findMedian());
	}

}
