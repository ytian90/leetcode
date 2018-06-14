package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 346. Moving Average from Data Stream
 * @author yutian
 * @since May 7, 2016
 */
public class MovingAverageFromDataStream {
	
	private Queue<Integer> q;
	private int size;
	private double sum;
	
	/** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        this.q = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        if (q.size() == size) {
        	sum -= q.poll();
        }
        q.add(val);
        sum += val;
        return sum / q.size();
    }

    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */
	public static void main(String[] args) {
		MovingAverageFromDataStream t = new MovingAverageFromDataStream(3);
		System.out.println(t.next(1));
		System.out.println(t.next(10));
		System.out.println(t.next(3));
		System.out.println(t.next(5));
	}

}
