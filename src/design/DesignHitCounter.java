package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 362. Design Hit Counter
 * Design a hit counter which counts the number of hits received 
 * in the past 5 minutes.
 * @author yutian
 * @since Jul 4, 2016
 */
public class DesignHitCounter {
	
	Queue<Integer> q;
	
	/** Initialize your data structure here. */
    public DesignHitCounter() {
        q = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp - q.peek() >= 300) {
        	q.poll();
        }
        return q.size();
    }

	public static void main(String[] args) {
		DesignHitCounter counter = new DesignHitCounter();
		counter.hit(1);
		counter.hit(2);
		counter.hit(3);
		System.out.println(counter.getHits(4));
		counter.hit(300);
		System.out.println(counter.getHits(300));
		System.out.println(counter.getHits(301));
	}

}
