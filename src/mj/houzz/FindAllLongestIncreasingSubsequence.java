package mj.houzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * follow up for leetcode 300
 */
public class FindAllLongestIncreasingSubsequence {

    // dp
    public static List<int[]> longestIncreaseSubsequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            len = Math.max(len, dp[i]);
        }
        List<int[]> list = new ArrayList<>();
        for (int i = len - 1; i < n; i++) {
            if (dp[i] == len) {
                int[] curr = new int[len];
                curr[len - 1] = nums[i];
                int index = len - 2, p = i - 1;
                while (index >= 0) {
                    if (nums[p] < curr[index + 1]) {
                        curr[index] = nums[p];
                        index--;
                    }
                    p--;
                }
                list.add(curr);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        for (int[] a : longestIncreaseSubsequence(new int[]{ 10,9,2,5,3,7,101,18 })) {
            System.out.println(Arrays.toString(a));
        }

        for (int[] a : longestIncreaseSubsequence(new int[]{ 3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10 })) {
            System.out.println(Arrays.toString(a));
        }

        System.out.println(Arrays.toString(longestIncreaseSubsequence2(new int[]{3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10})));
    }

    // binary search
    public static int[] longestIncreaseSubsequence2(int[] nums) {
        int[] d = new int[nums.length];
        int len = 0;
        for (int x : nums) {
            // index of the search key, if it is contained
            // in the array within the specified range;
            // otherwise, (-(insertion point) - 1).
            int i = Arrays.binarySearch(d, 0, len, x);
            if (i < 0) i = -(i + 1);
            d[i] = x;
            if (i == len) len++;
        }
        return Arrays.copyOfRange(d, 0, len);
    }
}
