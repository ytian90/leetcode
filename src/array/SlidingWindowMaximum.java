package array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 239. Sliding Window Maximum
 * https://hellosmallworld123.wordpress.com/2014/05/28/sliding-window-maximum/
 * @author yutian
 * @since Jan 27, 2016
 */
public class SlidingWindowMaximum {
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0)
			return new int[]{};
		int n = nums.length;
		int[] res = new int[n - k + 1];
		int pos = 0;
		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
				q.pollLast();
			}
			q.add(i);
			if (i >= k - 1) {
				res[pos++] = nums[q.peek()];
			}
		}

		return res;
    }
	
	public static void main(String[] args) {
		for (int i: maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))
			System.out.print(i + " ");
		System.out.println();
//		for (int i: maxSlidingWindow(new int[]{1, 3, -1}, 3))
//			System.out.print(i + " ");
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
