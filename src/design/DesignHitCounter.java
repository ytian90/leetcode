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
	// Method 1
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

    // Method 2
    private int[] times;
    private int[] hits;
    private int period = 300;

    /** Initialize your data structure here. */
    public void HitCounter2() {
        this.times = new int[period];
        this.hits = new int[period];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit2(int timestamp) {
        int index = timestamp % period;
        if (times[index] == timestamp) {
            hits[index]++;
        } else {
            times[index] = timestamp;
            hits[index] = 1;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits2(int timestamp) {
        int res = 0;
        for (int i = 0; i < period; i++) {
            if (timestamp - times[i] < 300) {
                res += hits[i];
            }
        }
        return res;
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
