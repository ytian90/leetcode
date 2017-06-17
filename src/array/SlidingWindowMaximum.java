package array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. Sliding Window Maximum
 * https://hellosmallworld123.wordpress.com/2014/05/28/sliding-window-maximum/
 * @author yutian
 * @since Jan 27, 2016
 */
public class SlidingWindowMaximum {
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[]{};
        int n = nums.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
        	// remove numbers out of range k
        	while (!q.isEmpty() && q.peek() < i - k + 1) {
        		q.poll();
        	}
        	// remove smaller numbers in k range as they are useless
        	while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
        		q.pollLast();
        	}
        	// q contains index ... r contains content
        	q.offer(i);
        	if (i >= k - 1) {
        		r[ri++] = nums[q.peek()];
        	}
        }
        return r;
    }
	
	public static void main(String[] args) {
		int[] t = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
		int[] t2 = maxSlidingWindow(new int[]{1, 3, -1}, 3);
		for (int i: t) System.out.print(i + " ");
		System.out.println();
//		for (int i: t2) System.out.print(i + " ");
	}
	
	public static int[] windowMax(int[] array, int width) {
		Deque<Integer> q = new LinkedList<Integer>();
		// calculate the first window max
		int[] maxArray = new int[array.length - width + 1];
		for (int i = 0; i < width; i++) {
			while (!q.isEmpty() && array[i] > q.peekLast())
				q.removeLast();
			q.addLast(array[i]);
		}
		maxArray[0] = q.peekFirst();
		// then try to move the window right and pop
		for (int i = width; i < array.length; i++) {
			if (q.size() == width)
				q.removeFirst();
			while (!q.isEmpty() && array[i] > q.peekLast()) {
				q.removeLast();
			}
			q.addLast(array[i]);
			maxArray[i - width + 1] = q.peekFirst();
		}
		return maxArray;
	}

	

}
