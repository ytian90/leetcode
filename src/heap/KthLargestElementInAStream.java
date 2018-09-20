package heap;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 */
public class KthLargestElementInAStream {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int n : nums) add(n);
    }

    public int add(int val) {
        if (pq.size() < k)
            pq.offer(val);
        else if (pq.peek() < val) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAStream obj = new KthLargestElementInAStream(3, new int[]{4, 5, 8, 2});
        System.out.println(obj.add(3)); // returns 4
        System.out.println(obj.add(5));  // 5
        System.out.println(obj.add(10));  // 5
        System.out.println(obj.add(9));  // 8
        System.out.println(obj.add(4));  // 8
    }
}
