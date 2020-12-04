package leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1130. Minimum Cost Tree From Leaf Values
 */
public class MinimumCostTreeFromLeafValues {

    public static int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        return dfs(arr, 0, n - 1, dp);
    }

    private static int dfs(int[] arr, int start, int end, int[][] dp) {
        if (start == end) {
            return 0;
        }
        if (dp[start][end] > 0) {
            return dp[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int left = dfs(arr, start, i, dp);
            int right = dfs(arr, i + 1, end, dp);
            int leftMax = 0, rightMax = 0;
            for (int j = start; j <= i; j++) {
                leftMax = Math.max(leftMax, arr[j]);
            }
            for (int j = i + 1; j <= end; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }
            res = Math.min(res, left + right + leftMax * rightMax);
        }
        dp[start][end] = res;
        return res;
    }

    public static int mctFromLeafValues2(int[] arr) {
        int res = 0;
        List<Integer> n = new ArrayList<>();
        for (int a : arr) {
            n.add(a);
        }
        while (n.size() > 1) {
            int min = Integer.MIN_VALUE, l = -1, r = -1;
            for (int i = 1; i < n.size(); i++) {
                if (n.get(i - 1) * n.get(i) < min) {
                    min = n.get(i - 1) * n.get(i);
                    l = i - 1;
                    r = i;
                }
            }
            res += min;
            if (n.get(l) < n.get(r)) {
                n.remove(l);
            } else {
                n.remove(r);
            }
        }
        return res;
    }

    public static int mctFromLeafValues3(int[] arr) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : arr) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while(stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(mctFromLeafValues3(new int[]{6, 2, 4, 5}));
    }
}
