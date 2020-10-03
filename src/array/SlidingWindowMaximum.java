package array;

import java.util.*;

/**
 * 239. Sliding Window Maximum
 * https://hellosmallworld123.wordpress.com/2014/05/28/sliding-window-maximum/
 * @author yutian
 * @since Jan 27, 2016
 */
public class SlidingWindowMaximum {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] res = new int[n - k + 1];
		int max = findMax(0, k, nums);
		res[0] = max;
		for (int i = 1; i < n; i++) {
			if (nums[i - 1] == max && nums[i + k - 1] < max) {
				max = findMax(i, i + k, nums);
			}
			max = Math.max(max, nums[i + k - 1]);
			res[i] = max;
		}
		return res;
	}

	private static int findMax(int i, int k, int[] nums) {
		int max = Integer.MIN_VALUE;
		while (i < k) {
			max = Math.max(nums[i], max);
			i++;
		}
		return max;
	}

	public static int[] maxSlidingWindow0(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		int n = nums.length;
		int[] res = new int[n - k + 1];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			pq.add(nums[i]);
		}
		for (int i = k; i < n; i++) {
			res[i - k] = pq.peek();
			pq.add(nums[i]);
			pq.remove(nums[i - k]);
		}
		res[n - k] = pq.peek();
		return res;
	}

	public static int[] maxSlidingWindow1(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		int n = nums.length;
		int[] res = new int[n - k + 1];
		int maxVal = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			maxVal = Math.max(nums[i], maxVal);
		}
		res[0] = maxVal;
		for (int i = k; i < n; i++) {
			int newVal = nums[i];
			if (newVal > maxVal) {
				maxVal = newVal;
			} else if (nums[i - k] == maxVal) {
				maxVal = newVal;
				for (int j = i - k + 1; j < i; j++) {
					maxVal = Math.max(maxVal, nums[j]);
				}
			}
			res[i - k + 1] = maxVal;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
	}
	
	public static int[] maxSlidingWindow2(int[] nums, int k) {
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
