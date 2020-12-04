package leetcode.mj.houzz;

import java.util.Stack;

/**
 * Solve maximal rectangle with leetcode.stack
 */
public class MaximalRectangleStack {

    // time O(N * M)
    // space O(M)
    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }
        return max;
    }



}
