package array;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 * @author yutian
 * @since Sep 3, 2015
 */
public class LargestRectangleInHistogram {

	// Time O(n) Space O(n)
	public static int largestRectangleArea(int[] heights) {
		int n = heights.length, max = 0;
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i <= n; i++) {
			int h = (i == n ? 0 : heights[i]);
			if (s.isEmpty() || h >= heights[s.peek()]) {
				s.push(i);
			} else {
				int top = s.pop();
				max = Math.max(max, heights[top] * (s.isEmpty() ? i : i - 1 - s.peek()));
				i--; // key
			}
		}
		return max;
	}

	public static void main(String[] args) {
//		System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
		System.out.println(largestRectangleArea(new int[]{2, 1, 2, 3, 1}));
	}

	public static int largestRectangleArea2(int[] heights) {
		Stack<Integer> s = new Stack<>();
		int max = 0;
		int i = 0;
		while (i < heights.length) {
			int h = heights[i];
			if (s.isEmpty() || h >= heights[s.peek()]) {
				s.push(i++);
			} else {
				// don't move i forward
				int top = s.pop();
				max = Math.max(max, heights[top] * (s.isEmpty() ? i : i - 1 - s.peek()));
			}
		}
		// Pop the remaining bars from stack and calculate area
		while (!s.isEmpty()) {
			int top = s.pop();
			max = Math.max(max, heights[top] * (s.isEmpty() ? i : i - 1 - s.peek()));
		}
		return max;
	}

}
