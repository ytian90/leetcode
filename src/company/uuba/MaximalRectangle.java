package company.uuba;

import java.util.Arrays;
import java.util.Stack;

/**
 * LC 85. Maximal Rectangle
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example 1:
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * Example 2:
 *
 * Input: matrix = []
 * Output: 0
 * Example 3:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 * Example 4:
 *
 * Input: matrix = [["1"]]
 * Output: 1
 * Example 5:
 *
 * Input: matrix = [["0","0"]]
 * Output: 0
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length, m = matrix[0].length;
        int[] left = new int[m], right = new int[m], height = new int[m];
        Arrays.fill(right, m);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int currLeft = 0, currRight = m - 1;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], currLeft);
                } else {
                    left[j] = 0;
                    currLeft = j + 1;
                }
            }
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], currRight);
                } else {
                    right[j] = m;
                    currRight = j - 1;
                }
            }
            for (int j = 0; j < m; j++) {
                max = Math.max(max, (right[j] - left[j] + 1) * height[j]);
            }
        }
        return max;
    }

    /**
     * Time: O(N * M)
     * Space: O(3 * M)
     */

    public int maximalRectangle2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length, m = matrix[0].length;
        int[] heights = new int[m];
        int max = 0;
        for (char[] row : matrix) {
            for (int i = 0; i < m; i++) {
                if (row[i] == '1') {
                    heights[i] += 1;
                } else {
                    heights[i] = 0;
                }
            }
            max = Math.max(max, maxArea(heights));
        }
        return max;
    }

    private int maxArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int[] left = new int[n], right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                left[i] = 0;
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                right[i] = n - 1;
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
            }
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] + 1));
        }
        return max;
    }
}
